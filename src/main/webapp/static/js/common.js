var Common = Common || (function(){
	var _doc = document,
	_navi = navigator,
	_screen = screen,
	_win = window,
	/* encode */
	_encodeWrapper = _win.encodeURIComponent,
	/* decode */
	_decodeWrapper = _win.decodeURIComponent,
	/* urldecode */
	_urldecode = unescape,
	// top level domains
	_topLevelDomain = ['.com', '.co.kr', '.kr', '.net', '.org'];
	
	var CONTENT_WRAPPER = 'contentWrapper'
	
	return {
		getContentWrapper: function() {
			return $('#' + CONTENT_WRAPPER);
		},
		
		addInputFiled: function(args) {
			var $addField = $('<input type="' + args.type + '" />');
			$addField.attr('name', args.name).attr('value', args.value);
			if (args.id) {
				$addField.attr('id', args.id);
			}
			
			$addField.appendTo(args.form);
		},
		
		/**
		 * 쿠키값 호출.
		 * 
		 * @param {String} key
		 * @returns {Object}
		 */
		getCookie: function(key) {
            var cookiePattern = new RegExp('(^|;)[ ]*' + key + '=([^;]*)'),
                cookieMatch = cookiePattern.exec(_doc.cookie);
            return cookieMatch ? _decodeWrapper(cookieMatch[2]) : 0;
		},

		/**
		 * 쿠키값 설정.
		 * 
		 * @param {String} key
		 * @param {String} value
		 * @param {Object} opts
		 */
		setCookie: function(key, value, opts) {
			opts = opts || {};
			
			if (!value) {
				opts.expires = -1;
			} else if (typeof opts.expires == 'number') {
				opts.expires = new Date(new Date().getTime() + (1000*60*opts.expires)).toUTCString();
			}
			
			// 쿠키 생성시 사용될 default domain
			var defaultDomainCookie = '';
			for (var i = 0 ; i < _topLevelDomain.length ; i++) {
				var docDomain = _doc.domain;
				if (docDomain.indexOf(_topLevelDomain[i]) != -1) {
					defaultDomainCookie = _topLevelDomain[i];
			        
			        var tempDomain = docDomain.replace(_topLevelDomain[i], '');
			        var lastIdx = tempDomain.lastIndexOf('.');
			        
			        defaultDomainCookie = tempDomain.substring(lastIdx+1) + defaultDomainCookie;
			        
			        break;
				}
			}
			
			var cookieExpires = opts.expires ? opts.expires : '';
			var cookiePath = opts.path ? opts.path : '/';
			var cookieDomain = opts.domain ? opts.domain : defaultDomainCookie;
			var cookieSecure = opts.secure ? 'secure' : '';
			
			_doc.cookie = key + '=' + _encodeWrapper(String(value))
				+ ('; expires=' + cookieExpires)
				+ ('; path=' +  cookiePath)
				+ ('; domain=' + cookieDomain)
				+ ('; ' + cookieSecure);
		},
		
		/**
		 * 쿠키삭제
		 * 
		 * @param {String} key
		 */
		deleteCookie: function(key) {
			setCookie(key, null);
		},
		
		/**
		 * ajax로딩중 처리.
		 */
		loading: function(flag) {
			if (flag == 'show') {
				$.blockUI({ message: '<div style="padding: 10px;"><h5>처리중입니다...</h5><div class="center"></div></div>' });
				//$('#loading').remove();
				//$('body').modalmanager('loading');
				//$('#body').parent().append('<div id="loading wcsdev-loadingarea">처리중입니다...<div class="center"></div></div>');
				//$('#loading').center(0, 0);				
				
			} else {
				$.unblockUI();
				//$('#loading').remove();
				//$('#loading').remove();
			}
		}
	};
})();

(function(){
    // Your base, I'm in it!
    var originalAddClassMethod = jQuery.fn.addClass;

    // addClass에 trigger등록.
    jQuery.fn.addClass = function(){
        // Execute the original method.
        var result = originalAddClassMethod.apply( this, arguments );

        // trigger a custom event
        jQuery(this).trigger('cssClassChanged', arguments);

        // return the original result
        return result;
    }
    
    
	$(function(){	
		
	    $('.bs-sidenav a').click(function (e) {
	    	e.preventDefault();
	    	
	    	var $tempThis = $(this);
	    	var link = $tempThis.attr('href');
	    	
	    	// sub메뉴인지 판단.
	    	var $dropDownUL = $tempThis.closest('ul');
	    	if ( !( $dropDownUL.hasClass('nav') && $dropDownUL.hasClass('bs-sidenav') ) ) {
	    		$dropDownUL.children('li').removeClass('active');
	    		// 자신의 부모 a 에 active처리.
	    		var $parentLI = $tempThis.closest('a').parent();
	    		if (!$parentLI.hasClass('active')) {
	    			$parentLI.addClass('active');
	    		}
	    	} else {
		    	$('.bs-sidenav li').removeClass('active');
		    	
	    		// 자식메뉴가 없는 메뉴라면 기존에 열려 있던 submenu를 모두 닫는다.
	    		if (!$tempThis.hasClass('dev-dropdown-link')) {
	    			$('a.dev-dropdown-link').next().slideUp();
	    		}
	    	}
	    	$tempThis.parent().addClass('active');
	    	
	    	console.log('-> ajax call link : ' + link);
	    	
	    	if (link == '#') {
	    		return;
	    	}
	    	$.ajax({
	    		url: link,
	    		dataType: 'html',
	    		success: function(res) {
	    			Common.getContentWrapper().html(res);
	    		},
	    		error: function() {
	    			var errText = '<h2>요청 처리시 에러가 발생했습니다.</h2>';
	    			Common.getContentWrapper().html(errText);
	    		}
	    	})
	    	
	    });
	    
	    $('a.dev-dropdown-link').parent('li').each(function() {
	    	$(this).on('cssClassChanged', function(evt, args) {
	    		if (args == 'active') {
	    			var $childUL = $(this).children('ul');
		    		if (!$childUL.is(':visible')) {
		    			$childUL.slideDown();
		    		}
	    		}	    		
	    	});
	    });
	});    
    
})(jQuery);