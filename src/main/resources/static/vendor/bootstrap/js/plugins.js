/*
 * Copyright (c) 2018 Marketify
 * Author: Marketify
 * This file is made for CURRENT TEMPLATE
*/

/*

*/



/*** Popup ***/

/*! Magnific Popup - v1.1.0 - 2016-02-20
* http://dimsemenov.com/plugins/magnific-popup/
* Copyright (c) 2016 Dmitry Semenov; */
!function(e){"function"==typeof define&&define.amd?define(["jquery"],e):e("object"==typeof exports?require("jquery"):window.jQuery||window.Zepto)}(function(e){var t,n,i,o,r,a,s="Close",l="BeforeClose",c="AfterClose",d="BeforeAppend",u="MarkupParse",p="Open",f="Change",m="mfp",g="."+m,v="mfp-ready",h="mfp-removing",y="mfp-prevent-close",C=function(){},w=!!window.jQuery,b=e(window),I=function(e,n){t.ev.on(m+e+g,n)},x=function(t,n,i,o){var r=document.createElement("div");return r.className="mfp-"+t,i&&(r.innerHTML=i),o?n&&n.appendChild(r):(r=e(r),n&&r.appendTo(n)),r},k=function(n,i){t.ev.triggerHandler(m+n,i),t.st.callbacks&&(n=n.charAt(0).toLowerCase()+n.slice(1),t.st.callbacks[n]&&t.st.callbacks[n].apply(t,e.isArray(i)?i:[i]))},T=function(n){return n===a&&t.currTemplate.closeBtn||(t.currTemplate.closeBtn=e(t.st.closeMarkup.replace("%title%",t.st.tClose)),a=n),t.currTemplate.closeBtn},_=function(){e.magnificPopup.instance||(t=new C,t.init(),e.magnificPopup.instance=t)},P=function(){var e=document.createElement("p").style,t=["ms","O","Moz","Webkit"];if(void 0!==e.transition)return!0;for(;t.length;)if(t.pop()+"Transition"in e)return!0;return!1};C.prototype={constructor:C,init:function(){var n=navigator.appVersion;t.isLowIE=t.isIE8=document.all&&!document.addEventListener,t.isAndroid=/android/gi.test(n),t.isIOS=/iphone|ipad|ipod/gi.test(n),t.supportsTransition=P(),t.probablyMobile=t.isAndroid||t.isIOS||/(Opera Mini)|Kindle|webOS|BlackBerry|(Opera Mobi)|(Windows Phone)|IEMobile/i.test(navigator.userAgent),i=e(document),t.popupsCache={}},open:function(n){var o;if(n.isObj===!1){t.items=n.items.toArray(),t.index=0;var a,s=n.items;for(o=0;o<s.length;o++)if(a=s[o],a.parsed&&(a=a.el[0]),a===n.el[0]){t.index=o;break}}else t.items=e.isArray(n.items)?n.items:[n.items],t.index=n.index||0;if(t.isOpen)return void t.updateItemHTML();t.types=[],r="",n.mainEl&&n.mainEl.length?t.ev=n.mainEl.eq(0):t.ev=i,n.key?(t.popupsCache[n.key]||(t.popupsCache[n.key]={}),t.currTemplate=t.popupsCache[n.key]):t.currTemplate={},t.st=e.extend(!0,{},e.magnificPopup.defaults,n),t.fixedContentPos="auto"===t.st.fixedContentPos?!t.probablyMobile:t.st.fixedContentPos,t.st.modal&&(t.st.closeOnContentClick=!1,t.st.closeOnBgClick=!1,t.st.showCloseBtn=!1,t.st.enableEscapeKey=!1),t.bgOverlay||(t.bgOverlay=x("bg").on("click"+g,function(){t.close()}),t.wrap=x("wrap").attr("tabindex",-1).on("click"+g,function(e){t._checkIfClose(e.target)&&t.close()}),t.container=x("container",t.wrap)),t.contentContainer=x("content"),t.st.preloader&&(t.preloader=x("preloader",t.container,t.st.tLoading));var l=e.magnificPopup.modules;for(o=0;o<l.length;o++){var c=l[o];c=c.charAt(0).toUpperCase()+c.slice(1),t["init"+c].call(t)}k("BeforeOpen"),t.st.showCloseBtn&&(t.st.closeBtnInside?(I(u,function(e,t,n,i){n.close_replaceWith=T(i.type)}),r+=" mfp-close-btn-in"):t.wrap.append(T())),t.st.alignTop&&(r+=" mfp-align-top"),t.fixedContentPos?t.wrap.css({overflow:t.st.overflowY,overflowX:"hidden",overflowY:t.st.overflowY}):t.wrap.css({top:b.scrollTop(),position:"absolute"}),(t.st.fixedBgPos===!1||"auto"===t.st.fixedBgPos&&!t.fixedContentPos)&&t.bgOverlay.css({height:i.height(),position:"absolute"}),t.st.enableEscapeKey&&i.on("keyup"+g,function(e){27===e.keyCode&&t.close()}),b.on("resize"+g,function(){t.updateSize()}),t.st.closeOnContentClick||(r+=" mfp-auto-cursor"),r&&t.wrap.addClass(r);var d=t.wH=b.height(),f={};if(t.fixedContentPos&&t._hasScrollBar(d)){var m=t._getScrollbarSize();m&&(f.marginRight=m)}t.fixedContentPos&&(t.isIE7?e("body, html").css("overflow","hidden"):f.overflow="hidden");var h=t.st.mainClass;return t.isIE7&&(h+=" mfp-ie7"),h&&t._addClassToMFP(h),t.updateItemHTML(),k("BuildControls"),e("html").css(f),t.bgOverlay.add(t.wrap).prependTo(t.st.prependTo||e(document.body)),t._lastFocusedEl=document.activeElement,setTimeout(function(){t.content?(t._addClassToMFP(v),t._setFocus()):t.bgOverlay.addClass(v),i.on("focusin"+g,t._onFocusIn)},16),t.isOpen=!0,t.updateSize(d),k(p),n},close:function(){t.isOpen&&(k(l),t.isOpen=!1,t.st.removalDelay&&!t.isLowIE&&t.supportsTransition?(t._addClassToMFP(h),setTimeout(function(){t._close()},t.st.removalDelay)):t._close())},_close:function(){k(s);var n=h+" "+v+" ";if(t.bgOverlay.detach(),t.wrap.detach(),t.container.empty(),t.st.mainClass&&(n+=t.st.mainClass+" "),t._removeClassFromMFP(n),t.fixedContentPos){var o={marginRight:""};t.isIE7?e("body, html").css("overflow",""):o.overflow="",e("html").css(o)}i.off("keyup"+g+" focusin"+g),t.ev.off(g),t.wrap.attr("class","mfp-wrap").removeAttr("style"),t.bgOverlay.attr("class","mfp-bg"),t.container.attr("class","mfp-container"),!t.st.showCloseBtn||t.st.closeBtnInside&&t.currTemplate[t.currItem.type]!==!0||t.currTemplate.closeBtn&&t.currTemplate.closeBtn.detach(),t.st.autoFocusLast&&t._lastFocusedEl&&e(t._lastFocusedEl).focus(),t.currItem=null,t.content=null,t.currTemplate=null,t.prevHeight=0,k(c)},updateSize:function(e){if(t.isIOS){var n=document.documentElement.clientWidth/window.innerWidth,i=window.innerHeight*n;t.wrap.css("height",i),t.wH=i}else t.wH=e||b.height();t.fixedContentPos||t.wrap.css("height",t.wH),k("Resize")},updateItemHTML:function(){var n=t.items[t.index];t.contentContainer.detach(),t.content&&t.content.detach(),n.parsed||(n=t.parseEl(t.index));var i=n.type;if(k("BeforeChange",[t.currItem?t.currItem.type:"",i]),t.currItem=n,!t.currTemplate[i]){var r=t.st[i]?t.st[i].markup:!1;k("FirstMarkupParse",r),r?t.currTemplate[i]=e(r):t.currTemplate[i]=!0}o&&o!==n.type&&t.container.removeClass("mfp-"+o+"-holder");var a=t["get"+i.charAt(0).toUpperCase()+i.slice(1)](n,t.currTemplate[i]);t.appendContent(a,i),n.preloaded=!0,k(f,n),o=n.type,t.container.prepend(t.contentContainer),k("AfterChange")},appendContent:function(e,n){t.content=e,e?t.st.showCloseBtn&&t.st.closeBtnInside&&t.currTemplate[n]===!0?t.content.find(".mfp-close").length||t.content.append(T()):t.content=e:t.content="",k(d),t.container.addClass("mfp-"+n+"-holder"),t.contentContainer.append(t.content)},parseEl:function(n){var i,o=t.items[n];if(o.tagName?o={el:e(o)}:(i=o.type,o={data:o,src:o.src}),o.el){for(var r=t.types,a=0;a<r.length;a++)if(o.el.hasClass("mfp-"+r[a])){i=r[a];break}o.src=o.el.attr("data-mfp-src"),o.src||(o.src=o.el.attr("href"))}return o.type=i||t.st.type||"inline",o.index=n,o.parsed=!0,t.items[n]=o,k("ElementParse",o),t.items[n]},addGroup:function(e,n){var i=function(i){i.mfpEl=this,t._openClick(i,e,n)};n||(n={});var o="click.magnificPopup";n.mainEl=e,n.items?(n.isObj=!0,e.off(o).on(o,i)):(n.isObj=!1,n.delegate?e.off(o).on(o,n.delegate,i):(n.items=e,e.off(o).on(o,i)))},_openClick:function(n,i,o){var r=void 0!==o.midClick?o.midClick:e.magnificPopup.defaults.midClick;if(r||!(2===n.which||n.ctrlKey||n.metaKey||n.altKey||n.shiftKey)){var a=void 0!==o.disableOn?o.disableOn:e.magnificPopup.defaults.disableOn;if(a)if(e.isFunction(a)){if(!a.call(t))return!0}else if(b.width()<a)return!0;n.type&&(n.preventDefault(),t.isOpen&&n.stopPropagation()),o.el=e(n.mfpEl),o.delegate&&(o.items=i.find(o.delegate)),t.open(o)}},updateStatus:function(e,i){if(t.preloader){n!==e&&t.container.removeClass("mfp-s-"+n),i||"loading"!==e||(i=t.st.tLoading);var o={status:e,text:i};k("UpdateStatus",o),e=o.status,i=o.text,t.preloader.html(i),t.preloader.find("a").on("click",function(e){e.stopImmediatePropagation()}),t.container.addClass("mfp-s-"+e),n=e}},_checkIfClose:function(n){if(!e(n).hasClass(y)){var i=t.st.closeOnContentClick,o=t.st.closeOnBgClick;if(i&&o)return!0;if(!t.content||e(n).hasClass("mfp-close")||t.preloader&&n===t.preloader[0])return!0;if(n===t.content[0]||e.contains(t.content[0],n)){if(i)return!0}else if(o&&e.contains(document,n))return!0;return!1}},_addClassToMFP:function(e){t.bgOverlay.addClass(e),t.wrap.addClass(e)},_removeClassFromMFP:function(e){this.bgOverlay.removeClass(e),t.wrap.removeClass(e)},_hasScrollBar:function(e){return(t.isIE7?i.height():document.body.scrollHeight)>(e||b.height())},_setFocus:function(){(t.st.focus?t.content.find(t.st.focus).eq(0):t.wrap).focus()},_onFocusIn:function(n){return n.target===t.wrap[0]||e.contains(t.wrap[0],n.target)?void 0:(t._setFocus(),!1)},_parseMarkup:function(t,n,i){var o;i.data&&(n=e.extend(i.data,n)),k(u,[t,n,i]),e.each(n,function(n,i){if(void 0===i||i===!1)return!0;if(o=n.split("_"),o.length>1){var r=t.find(g+"-"+o[0]);if(r.length>0){var a=o[1];"replaceWith"===a?r[0]!==i[0]&&r.replaceWith(i):"img"===a?r.is("img")?r.attr("src",i):r.replaceWith(e("<img>").attr("src",i).attr("class",r.attr("class"))):r.attr(o[1],i)}}else t.find(g+"-"+n).html(i)})},_getScrollbarSize:function(){if(void 0===t.scrollbarSize){var e=document.createElement("div");e.style.cssText="width: 99px; height: 99px; overflow: scroll; position: absolute; top: -9999px;",document.body.appendChild(e),t.scrollbarSize=e.offsetWidth-e.clientWidth,document.body.removeChild(e)}return t.scrollbarSize}},e.magnificPopup={instance:null,proto:C.prototype,modules:[],open:function(t,n){return _(),t=t?e.extend(!0,{},t):{},t.isObj=!0,t.index=n||0,this.instance.open(t)},close:function(){return e.magnificPopup.instance&&e.magnificPopup.instance.close()},registerModule:function(t,n){n.options&&(e.magnificPopup.defaults[t]=n.options),e.extend(this.proto,n.proto),this.modules.push(t)},defaults:{disableOn:0,key:null,midClick:!1,mainClass:"",preloader:!0,focus:"",closeOnContentClick:!1,closeOnBgClick:!0,closeBtnInside:!0,showCloseBtn:!0,enableEscapeKey:!0,modal:!1,alignTop:!1,removalDelay:0,prependTo:null,fixedContentPos:"auto",fixedBgPos:"auto",overflowY:"auto",closeMarkup:'<button title="%title%" type="button" class="mfp-close">&#215;</button>',tClose:"Close (Esc)",tLoading:"Loading...",autoFocusLast:!0}},e.fn.magnificPopup=function(n){_();var i=e(this);if("string"==typeof n)if("open"===n){var o,r=w?i.data("magnificPopup"):i[0].magnificPopup,a=parseInt(arguments[1],10)||0;r.items?o=r.items[a]:(o=i,r.delegate&&(o=o.find(r.delegate)),o=o.eq(a)),t._openClick({mfpEl:o},i,r)}else t.isOpen&&t[n].apply(t,Array.prototype.slice.call(arguments,1));else n=e.extend(!0,{},n),w?i.data("magnificPopup",n):i[0].magnificPopup=n,t.addGroup(i,n);return i};var S,E,z,O="inline",M=function(){z&&(E.after(z.addClass(S)).detach(),z=null)};e.magnificPopup.registerModule(O,{options:{hiddenClass:"hide",markup:"",tNotFound:"Content not found"},proto:{initInline:function(){t.types.push(O),I(s+"."+O,function(){M()})},getInline:function(n,i){if(M(),n.src){var o=t.st.inline,r=e(n.src);if(r.length){var a=r[0].parentNode;a&&a.tagName&&(E||(S=o.hiddenClass,E=x(S),S="mfp-"+S),z=r.after(E).detach().removeClass(S)),t.updateStatus("ready")}else t.updateStatus("error",o.tNotFound),r=e("<div>");return n.inlineElement=r,r}return t.updateStatus("ready"),t._parseMarkup(i,{},n),i}}});var B,L="ajax",H=function(){B&&e(document.body).removeClass(B)},A=function(){H(),t.req&&t.req.abort()};e.magnificPopup.registerModule(L,{options:{settings:null,cursor:"mfp-ajax-cur",tError:'<a href="%url%">The content</a> could not be loaded.'},proto:{initAjax:function(){t.types.push(L),B=t.st.ajax.cursor,I(s+"."+L,A),I("BeforeChange."+L,A)},getAjax:function(n){B&&e(document.body).addClass(B),t.updateStatus("loading");var i=e.extend({url:n.src,success:function(i,o,r){var a={data:i,xhr:r};k("ParseAjax",a),t.appendContent(e(a.data),L),n.finished=!0,H(),t._setFocus(),setTimeout(function(){t.wrap.addClass(v)},16),t.updateStatus("ready"),k("AjaxContentAdded")},error:function(){H(),n.finished=n.loadError=!0,t.updateStatus("error",t.st.ajax.tError.replace("%url%",n.src))}},t.st.ajax.settings);return t.req=e.ajax(i),""}}});var F,j=function(n){if(n.data&&void 0!==n.data.title)return n.data.title;var i=t.st.image.titleSrc;if(i){if(e.isFunction(i))return i.call(t,n);if(n.el)return n.el.attr(i)||""}return""};e.magnificPopup.registerModule("image",{options:{markup:'<div class="mfp-figure"><div class="mfp-close"></div><figure><div class="mfp-img"></div><figcaption><div class="mfp-bottom-bar"><div class="mfp-title"></div><div class="mfp-counter"></div></div></figcaption></figure></div>',cursor:"mfp-zoom-out-cur",titleSrc:"title",verticalFit:!0,tError:'<a href="%url%">The image</a> could not be loaded.'},proto:{initImage:function(){var n=t.st.image,i=".image";t.types.push("image"),I(p+i,function(){"image"===t.currItem.type&&n.cursor&&e(document.body).addClass(n.cursor)}),I(s+i,function(){n.cursor&&e(document.body).removeClass(n.cursor),b.off("resize"+g)}),I("Resize"+i,t.resizeImage),t.isLowIE&&I("AfterChange",t.resizeImage)},resizeImage:function(){var e=t.currItem;if(e&&e.img&&t.st.image.verticalFit){var n=0;t.isLowIE&&(n=parseInt(e.img.css("padding-top"),10)+parseInt(e.img.css("padding-bottom"),10)),e.img.css("max-height",t.wH-n)}},_onImageHasSize:function(e){e.img&&(e.hasSize=!0,F&&clearInterval(F),e.isCheckingImgSize=!1,k("ImageHasSize",e),e.imgHidden&&(t.content&&t.content.removeClass("mfp-loading"),e.imgHidden=!1))},findImageSize:function(e){var n=0,i=e.img[0],o=function(r){F&&clearInterval(F),F=setInterval(function(){return i.naturalWidth>0?void t._onImageHasSize(e):(n>200&&clearInterval(F),n++,void(3===n?o(10):40===n?o(50):100===n&&o(500)))},r)};o(1)},getImage:function(n,i){var o=0,r=function(){n&&(n.img[0].complete?(n.img.off(".mfploader"),n===t.currItem&&(t._onImageHasSize(n),t.updateStatus("ready")),n.hasSize=!0,n.loaded=!0,k("ImageLoadComplete")):(o++,200>o?setTimeout(r,100):a()))},a=function(){n&&(n.img.off(".mfploader"),n===t.currItem&&(t._onImageHasSize(n),t.updateStatus("error",s.tError.replace("%url%",n.src))),n.hasSize=!0,n.loaded=!0,n.loadError=!0)},s=t.st.image,l=i.find(".mfp-img");if(l.length){var c=document.createElement("img");c.className="mfp-img",n.el&&n.el.find("img").length&&(c.alt=n.el.find("img").attr("alt")),n.img=e(c).on("load.mfploader",r).on("error.mfploader",a),c.src=n.src,l.is("img")&&(n.img=n.img.clone()),c=n.img[0],c.naturalWidth>0?n.hasSize=!0:c.width||(n.hasSize=!1)}return t._parseMarkup(i,{title:j(n),img_replaceWith:n.img},n),t.resizeImage(),n.hasSize?(F&&clearInterval(F),n.loadError?(i.addClass("mfp-loading"),t.updateStatus("error",s.tError.replace("%url%",n.src))):(i.removeClass("mfp-loading"),t.updateStatus("ready")),i):(t.updateStatus("loading"),n.loading=!0,n.hasSize||(n.imgHidden=!0,i.addClass("mfp-loading"),t.findImageSize(n)),i)}}});var N,W=function(){return void 0===N&&(N=void 0!==document.createElement("p").style.MozTransform),N};e.magnificPopup.registerModule("zoom",{options:{enabled:!1,easing:"ease-in-out",duration:300,opener:function(e){return e.is("img")?e:e.find("img")}},proto:{initZoom:function(){var e,n=t.st.zoom,i=".zoom";if(n.enabled&&t.supportsTransition){var o,r,a=n.duration,c=function(e){var t=e.clone().removeAttr("style").removeAttr("class").addClass("mfp-animated-image"),i="all "+n.duration/1e3+"s "+n.easing,o={position:"fixed",zIndex:9999,left:0,top:0,"-webkit-backface-visibility":"hidden"},r="transition";return o["-webkit-"+r]=o["-moz-"+r]=o["-o-"+r]=o[r]=i,t.css(o),t},d=function(){t.content.css("visibility","visible")};I("BuildControls"+i,function(){if(t._allowZoom()){if(clearTimeout(o),t.content.css("visibility","hidden"),e=t._getItemToZoom(),!e)return void d();r=c(e),r.css(t._getOffset()),t.wrap.append(r),o=setTimeout(function(){r.css(t._getOffset(!0)),o=setTimeout(function(){d(),setTimeout(function(){r.remove(),e=r=null,k("ZoomAnimationEnded")},16)},a)},16)}}),I(l+i,function(){if(t._allowZoom()){if(clearTimeout(o),t.st.removalDelay=a,!e){if(e=t._getItemToZoom(),!e)return;r=c(e)}r.css(t._getOffset(!0)),t.wrap.append(r),t.content.css("visibility","hidden"),setTimeout(function(){r.css(t._getOffset())},16)}}),I(s+i,function(){t._allowZoom()&&(d(),r&&r.remove(),e=null)})}},_allowZoom:function(){return"image"===t.currItem.type},_getItemToZoom:function(){return t.currItem.hasSize?t.currItem.img:!1},_getOffset:function(n){var i;i=n?t.currItem.img:t.st.zoom.opener(t.currItem.el||t.currItem);var o=i.offset(),r=parseInt(i.css("padding-top"),10),a=parseInt(i.css("padding-bottom"),10);o.top-=e(window).scrollTop()-r;var s={width:i.width(),height:(w?i.innerHeight():i[0].offsetHeight)-a-r};return W()?s["-moz-transform"]=s.transform="translate("+o.left+"px,"+o.top+"px)":(s.left=o.left,s.top=o.top),s}}});var Z="iframe",q="//about:blank",R=function(e){if(t.currTemplate[Z]){var n=t.currTemplate[Z].find("iframe");n.length&&(e||(n[0].src=q),t.isIE8&&n.css("display",e?"block":"none"))}};e.magnificPopup.registerModule(Z,{options:{markup:'<div class="mfp-iframe-scaler"><div class="mfp-close"></div><iframe class="mfp-iframe" src="//about:blank" frameborder="0" allowfullscreen></iframe></div>',srcAction:"iframe_src",patterns:{youtube:{index:"youtube.com",id:"v=",src:"//www.youtube.com/embed/%id%?autoplay=1"},vimeo:{index:"vimeo.com/",id:"/",src:"//player.vimeo.com/video/%id%?autoplay=1"},gmaps:{index:"//maps.google.",src:"%id%&output=embed"}}},proto:{initIframe:function(){t.types.push(Z),I("BeforeChange",function(e,t,n){t!==n&&(t===Z?R():n===Z&&R(!0))}),I(s+"."+Z,function(){R()})},getIframe:function(n,i){var o=n.src,r=t.st.iframe;e.each(r.patterns,function(){return o.indexOf(this.index)>-1?(this.id&&(o="string"==typeof this.id?o.substr(o.lastIndexOf(this.id)+this.id.length,o.length):this.id.call(this,o)),o=this.src.replace("%id%",o),!1):void 0});var a={};return r.srcAction&&(a[r.srcAction]=o),t._parseMarkup(i,a,n),t.updateStatus("ready"),i}}});var K=function(e){var n=t.items.length;return e>n-1?e-n:0>e?n+e:e},D=function(e,t,n){return e.replace(/%curr%/gi,t+1).replace(/%total%/gi,n)};e.magnificPopup.registerModule("gallery",{options:{enabled:!1,arrowMarkup:'<button title="%title%" type="button" class="mfp-arrow mfp-arrow-%dir%"></button>',preload:[0,2],navigateByImgClick:!0,arrows:!0,tPrev:"Previous (Left arrow key)",tNext:"Next (Right arrow key)",tCounter:"%curr% of %total%"},proto:{initGallery:function(){var n=t.st.gallery,o=".mfp-gallery";return t.direction=!0,n&&n.enabled?(r+=" mfp-gallery",I(p+o,function(){n.navigateByImgClick&&t.wrap.on("click"+o,".mfp-img",function(){return t.items.length>1?(t.next(),!1):void 0}),i.on("keydown"+o,function(e){37===e.keyCode?t.prev():39===e.keyCode&&t.next()})}),I("UpdateStatus"+o,function(e,n){n.text&&(n.text=D(n.text,t.currItem.index,t.items.length))}),I(u+o,function(e,i,o,r){var a=t.items.length;o.counter=a>1?D(n.tCounter,r.index,a):""}),I("BuildControls"+o,function(){if(t.items.length>1&&n.arrows&&!t.arrowLeft){var i=n.arrowMarkup,o=t.arrowLeft=e(i.replace(/%title%/gi,n.tPrev).replace(/%dir%/gi,"left")).addClass(y),r=t.arrowRight=e(i.replace(/%title%/gi,n.tNext).replace(/%dir%/gi,"right")).addClass(y);o.click(function(){t.prev()}),r.click(function(){t.next()}),t.container.append(o.add(r))}}),I(f+o,function(){t._preloadTimeout&&clearTimeout(t._preloadTimeout),t._preloadTimeout=setTimeout(function(){t.preloadNearbyImages(),t._preloadTimeout=null},16)}),void I(s+o,function(){i.off(o),t.wrap.off("click"+o),t.arrowRight=t.arrowLeft=null})):!1},next:function(){t.direction=!0,t.index=K(t.index+1),t.updateItemHTML()},prev:function(){t.direction=!1,t.index=K(t.index-1),t.updateItemHTML()},goTo:function(e){t.direction=e>=t.index,t.index=e,t.updateItemHTML()},preloadNearbyImages:function(){var e,n=t.st.gallery.preload,i=Math.min(n[0],t.items.length),o=Math.min(n[1],t.items.length);for(e=1;e<=(t.direction?o:i);e++)t._preloadItem(t.index+e);for(e=1;e<=(t.direction?i:o);e++)t._preloadItem(t.index-e)},_preloadItem:function(n){if(n=K(n),!t.items[n].preloaded){var i=t.items[n];i.parsed||(i=t.parseEl(n)),k("LazyLoad",i),"image"===i.type&&(i.img=e('<img class="mfp-img" />').on("load.mfploader",function(){i.hasSize=!0}).on("error.mfploader",function(){i.hasSize=!0,i.loadError=!0,k("LazyLoadError",i)}).attr("src",i.src)),i.preloaded=!0}}}});var U="retina";e.magnificPopup.registerModule(U,{options:{replaceSrc:function(e){return e.src.replace(/\.\w+$/,function(e){return"@2x"+e})},ratio:1},proto:{initRetina:function(){if(window.devicePixelRatio>1){var e=t.st.retina,n=e.ratio;n=isNaN(n)?n():n,n>1&&(I("ImageHasSize."+U,function(e,t){t.img.css({"max-width":t.img[0].naturalWidth/n,width:"100%"})}),I("ElementParse."+U,function(t,i){i.src=e.replaceSrc(i,n)}))}}}}),_()});


/*!
 * mgGlitch : little jquery helper to glitch everything
 * (c) 2016 Hadrien Mongouachon
 * MIT Licensed.
 *
 * Author URI: http://hmongouachon.com
 * Plugin URI: http://hmongouachon.com
 * Date : 06/2016
 * Version: 1.0.0
 */
!function(t,e,s,i){"use strict";function n(e,s){this.element=e,this.settings=t.extend({},a,s),this._defaults=a,this._name=r,this.init()}var r="mgGlitch",a={destroy:!1,glitch:!0,scale:!0,blend:!0,blendModeType:"hue",glitch1TimeMin:600,glitch1TimeMax:900,glitch2TimeMin:10,glitch2TimeMax:115,zIndexStart:5};t.extend(n.prototype,{init:function(){this.glitch()},glitch:function(){function e(t,e){return Math.floor(Math.random()*(e-t+1))+t}function s(){var i=e(10,1900),n=9999,a=e(10,1300),o=0,h=e(0,16),f=e(0,16),d=e(c,l);t(r).css({clip:"rect("+i+"px, "+n+"px, "+a+"px,"+o+"px)",right:f,left:h}),setTimeout(s,d)}function i(){var s=e(10,1900),n=9999,c=e(10,1300),l=0,f=e(0,40),d=e(0,40),m=e(o,h);if(a===!0)var x=(Math.random()*(1.1-.9)+.9).toFixed(2);else if(a===!1)var x=1;t(r).next().css({clip:"rect("+s+"px, "+n+"px, "+c+"px,"+l+"px)",left:f,right:d,"-webkit-transform":"scale("+x+")","-ms-transform":"scale("+x+")",transform:"scale("+x+")"}),setTimeout(i,m)}function n(){var s=e(10,1900),i=9999,c=e(10,1300),l=0,f=e(0,40),d=e(0,40),m=e(o,h);if(a===!0)var x=(Math.random()*(1.1-.9)+.9).toFixed(2);else if(a===!1)var x=1;t(r).next().next().css({clip:"rect("+s+"px, "+i+"px, "+c+"px,"+l+"px)",left:f,right:d,"-webkit-transform":"scale("+x+")","-ms-transform":"scale("+x+")",transform:"scale("+x+")"}),setTimeout(n,m)}var r=this.element,a=this.settings.scale,c=this.settings.glitch1TimeMin,l=this.settings.glitch1TimeMax,o=this.settings.glitch2TimeMin,h=this.settings.glitch2TimeMax,f=this.settings.zIndexStart;if(this.settings.destroy===!0)(t(r).hasClass("el-front-1")||t(r).hasClass("front-3")||t(r).hasClass("front-2"))&&t(".front-1, .front-2, .front-3").remove(),t(".back").removeClass("back");else if(this.settings.destroy===!1){var d=t(r).clone();if(d.insertBefore(r).addClass("back").css({"z-index":f}),this.settings.blend===!0){var d=t(r).clone();d.insertAfter(r).addClass("front-3").css({"z-index":f+3,"mix-blend-mode":this.settings.blendModeType}),n()}if(this.settings.glitch===!0){var d=t(r).clone();d.insertAfter(r).addClass("front-2").css({"z-index":f+2}),t(".back").next().addClass("front-1").css({"z-index":f+1}),s(),i()}}}}),t.fn[r]=function(t){return this.each(function(){new n(this,t)})}}(jQuery,window,document);


/*------------------------------------------------------------------*/
/*	08) WAYPOINTS
/*------------------------------------------------------------------*/

/*!
Waypoints - 4.0.1
Copyright © 2011-2016 Caleb Troughton
Licensed under the MIT license.
https://github.com/imakewebthings/waypoints/blob/master/licenses.txt
*/
!function(){"use strict";function t(o){if(!o)throw new Error("No options passed to Waypoint constructor");if(!o.element)throw new Error("No element option passed to Waypoint constructor");if(!o.handler)throw new Error("No handler option passed to Waypoint constructor");this.key="waypoint-"+e,this.options=t.Adapter.extend({},t.defaults,o),this.element=this.options.element,this.adapter=new t.Adapter(this.element),this.callback=o.handler,this.axis=this.options.horizontal?"horizontal":"vertical",this.enabled=this.options.enabled,this.triggerPoint=null,this.group=t.Group.findOrCreate({name:this.options.group,axis:this.axis}),this.context=t.Context.findOrCreateByElement(this.options.context),t.offsetAliases[this.options.offset]&&(this.options.offset=t.offsetAliases[this.options.offset]),this.group.add(this),this.context.add(this),i[this.key]=this,e+=1}var e=0,i={};t.prototype.queueTrigger=function(t){this.group.queueTrigger(this,t)},t.prototype.trigger=function(t){this.enabled&&this.callback&&this.callback.apply(this,t)},t.prototype.destroy=function(){this.context.remove(this),this.group.remove(this),delete i[this.key]},t.prototype.disable=function(){return this.enabled=!1,this},t.prototype.enable=function(){return this.context.refresh(),this.enabled=!0,this},t.prototype.next=function(){return this.group.next(this)},t.prototype.previous=function(){return this.group.previous(this)},t.invokeAll=function(t){var e=[];for(var o in i)e.push(i[o]);for(var n=0,r=e.length;r>n;n++)e[n][t]()},t.destroyAll=function(){t.invokeAll("destroy")},t.disableAll=function(){t.invokeAll("disable")},t.enableAll=function(){t.Context.refreshAll();for(var e in i)i[e].enabled=!0;return this},t.refreshAll=function(){t.Context.refreshAll()},t.viewportHeight=function(){return window.innerHeight||document.documentElement.clientHeight},t.viewportWidth=function(){return document.documentElement.clientWidth},t.adapters=[],t.defaults={context:window,continuous:!0,enabled:!0,group:"default",horizontal:!1,offset:0},t.offsetAliases={"bottom-in-view":function(){return this.context.innerHeight()-this.adapter.outerHeight()},"right-in-view":function(){return this.context.innerWidth()-this.adapter.outerWidth()}},window.Waypoint=t}(),function(){"use strict";function t(t){window.setTimeout(t,1e3/60)}function e(t){this.element=t,this.Adapter=n.Adapter,this.adapter=new this.Adapter(t),this.key="waypoint-context-"+i,this.didScroll=!1,this.didResize=!1,this.oldScroll={x:this.adapter.scrollLeft(),y:this.adapter.scrollTop()},this.waypoints={vertical:{},horizontal:{}},t.waypointContextKey=this.key,o[t.waypointContextKey]=this,i+=1,n.windowContext||(n.windowContext=!0,n.windowContext=new e(window)),this.createThrottledScrollHandler(),this.createThrottledResizeHandler()}var i=0,o={},n=window.Waypoint,r=window.onload;e.prototype.add=function(t){var e=t.options.horizontal?"horizontal":"vertical";this.waypoints[e][t.key]=t,this.refresh()},e.prototype.checkEmpty=function(){var t=this.Adapter.isEmptyObject(this.waypoints.horizontal),e=this.Adapter.isEmptyObject(this.waypoints.vertical),i=this.element==this.element.window;t&&e&&!i&&(this.adapter.off(".waypoints"),delete o[this.key])},e.prototype.createThrottledResizeHandler=function(){function t(){e.handleResize(),e.didResize=!1}var e=this;this.adapter.on("resize.waypoints",function(){e.didResize||(e.didResize=!0,n.requestAnimationFrame(t))})},e.prototype.createThrottledScrollHandler=function(){function t(){e.handleScroll(),e.didScroll=!1}var e=this;this.adapter.on("scroll.waypoints",function(){(!e.didScroll||n.isTouch)&&(e.didScroll=!0,n.requestAnimationFrame(t))})},e.prototype.handleResize=function(){n.Context.refreshAll()},e.prototype.handleScroll=function(){var t={},e={horizontal:{newScroll:this.adapter.scrollLeft(),oldScroll:this.oldScroll.x,forward:"right",backward:"left"},vertical:{newScroll:this.adapter.scrollTop(),oldScroll:this.oldScroll.y,forward:"down",backward:"up"}};for(var i in e){var o=e[i],n=o.newScroll>o.oldScroll,r=n?o.forward:o.backward;for(var s in this.waypoints[i]){var a=this.waypoints[i][s];if(null!==a.triggerPoint){var l=o.oldScroll<a.triggerPoint,h=o.newScroll>=a.triggerPoint,p=l&&h,u=!l&&!h;(p||u)&&(a.queueTrigger(r),t[a.group.id]=a.group)}}}for(var c in t)t[c].flushTriggers();this.oldScroll={x:e.horizontal.newScroll,y:e.vertical.newScroll}},e.prototype.innerHeight=function(){return this.element==this.element.window?n.viewportHeight():this.adapter.innerHeight()},e.prototype.remove=function(t){delete this.waypoints[t.axis][t.key],this.checkEmpty()},e.prototype.innerWidth=function(){return this.element==this.element.window?n.viewportWidth():this.adapter.innerWidth()},e.prototype.destroy=function(){var t=[];for(var e in this.waypoints)for(var i in this.waypoints[e])t.push(this.waypoints[e][i]);for(var o=0,n=t.length;n>o;o++)t[o].destroy()},e.prototype.refresh=function(){var t,e=this.element==this.element.window,i=e?void 0:this.adapter.offset(),o={};this.handleScroll(),t={horizontal:{contextOffset:e?0:i.left,contextScroll:e?0:this.oldScroll.x,contextDimension:this.innerWidth(),oldScroll:this.oldScroll.x,forward:"right",backward:"left",offsetProp:"left"},vertical:{contextOffset:e?0:i.top,contextScroll:e?0:this.oldScroll.y,contextDimension:this.innerHeight(),oldScroll:this.oldScroll.y,forward:"down",backward:"up",offsetProp:"top"}};for(var r in t){var s=t[r];for(var a in this.waypoints[r]){var l,h,p,u,c,d=this.waypoints[r][a],f=d.options.offset,w=d.triggerPoint,y=0,g=null==w;d.element!==d.element.window&&(y=d.adapter.offset()[s.offsetProp]),"function"==typeof f?f=f.apply(d):"string"==typeof f&&(f=parseFloat(f),d.options.offset.indexOf("%")>-1&&(f=Math.ceil(s.contextDimension*f/100))),l=s.contextScroll-s.contextOffset,d.triggerPoint=Math.floor(y+l-f),h=w<s.oldScroll,p=d.triggerPoint>=s.oldScroll,u=h&&p,c=!h&&!p,!g&&u?(d.queueTrigger(s.backward),o[d.group.id]=d.group):!g&&c?(d.queueTrigger(s.forward),o[d.group.id]=d.group):g&&s.oldScroll>=d.triggerPoint&&(d.queueTrigger(s.forward),o[d.group.id]=d.group)}}return n.requestAnimationFrame(function(){for(var t in o)o[t].flushTriggers()}),this},e.findOrCreateByElement=function(t){return e.findByElement(t)||new e(t)},e.refreshAll=function(){for(var t in o)o[t].refresh()},e.findByElement=function(t){return o[t.waypointContextKey]},window.onload=function(){r&&r(),e.refreshAll()},n.requestAnimationFrame=function(e){var i=window.requestAnimationFrame||window.mozRequestAnimationFrame||window.webkitRequestAnimationFrame||t;i.call(window,e)},n.Context=e}(),function(){"use strict";function t(t,e){return t.triggerPoint-e.triggerPoint}function e(t,e){return e.triggerPoint-t.triggerPoint}function i(t){this.name=t.name,this.axis=t.axis,this.id=this.name+"-"+this.axis,this.waypoints=[],this.clearTriggerQueues(),o[this.axis][this.name]=this}var o={vertical:{},horizontal:{}},n=window.Waypoint;i.prototype.add=function(t){this.waypoints.push(t)},i.prototype.clearTriggerQueues=function(){this.triggerQueues={up:[],down:[],left:[],right:[]}},i.prototype.flushTriggers=function(){for(var i in this.triggerQueues){var o=this.triggerQueues[i],n="up"===i||"left"===i;o.sort(n?e:t);for(var r=0,s=o.length;s>r;r+=1){var a=o[r];(a.options.continuous||r===o.length-1)&&a.trigger([i])}}this.clearTriggerQueues()},i.prototype.next=function(e){this.waypoints.sort(t);var i=n.Adapter.inArray(e,this.waypoints),o=i===this.waypoints.length-1;return o?null:this.waypoints[i+1]},i.prototype.previous=function(e){this.waypoints.sort(t);var i=n.Adapter.inArray(e,this.waypoints);return i?this.waypoints[i-1]:null},i.prototype.queueTrigger=function(t,e){this.triggerQueues[e].push(t)},i.prototype.remove=function(t){var e=n.Adapter.inArray(t,this.waypoints);e>-1&&this.waypoints.splice(e,1)},i.prototype.first=function(){return this.waypoints[0]},i.prototype.last=function(){return this.waypoints[this.waypoints.length-1]},i.findOrCreate=function(t){return o[t.axis][t.name]||new i(t)},n.Group=i}(),function(){"use strict";function t(t){this.$element=e(t)}var e=window.jQuery,i=window.Waypoint;e.each(["innerHeight","innerWidth","off","offset","on","outerHeight","outerWidth","scrollLeft","scrollTop"],function(e,i){t.prototype[i]=function(){var t=Array.prototype.slice.call(arguments);return this.$element[i].apply(this.$element,t)}}),e.each(["extend","inArray","isEmptyObject"],function(i,o){t[o]=e[o]}),i.adapters.push({name:"jquery",Adapter:t}),i.Adapter=t}(),function(){"use strict";function t(t){return function(){var i=[],o=arguments[0];return t.isFunction(arguments[0])&&(o=t.extend({},arguments[1]),o.handler=arguments[0]),this.each(function(){var n=t.extend({},o,{element:this});"string"==typeof n.context&&(n.context=t(this).closest(n.context)[0]),i.push(new e(n))}),i}}var e=window.Waypoint;window.jQuery&&(window.jQuery.fn.waypoint=t(window.jQuery)),window.Zepto&&(window.Zepto.fn.waypoint=t(window.Zepto))}();


/*------------------------------------------------------------------*/
/*	01) Owl Carousel
/*------------------------------------------------------------------*/


!function(a,b,c,d){function e(b,c){this.settings=null,this.options=a.extend({},e.Defaults,c),this.$element=a(b),this._handlers={},this._plugins={},this._supress={},this._current=null,this._speed=null,this._coordinates=[],this._breakpoint=null,this._width=null,this._items=[],this._clones=[],this._mergers=[],this._widths=[],this._invalidated={},this._pipe=[],this._drag={time:null,target:null,pointer:null,stage:{start:null,current:null},direction:null},this._states={current:{},tags:{initializing:["busy"],animating:["busy"],dragging:["interacting"]}},a.each(["onResize","onThrottledResize"],a.proxy(function(b,c){this._handlers[c]=a.proxy(this[c],this)},this)),a.each(e.Plugins,a.proxy(function(a,b){this._plugins[a.charAt(0).toLowerCase()+a.slice(1)]=new b(this)},this)),a.each(e.Workers,a.proxy(function(b,c){this._pipe.push({filter:c.filter,run:a.proxy(c.run,this)})},this)),this.setup(),this.initialize()}e.Defaults={items:3,loop:!1,center:!1,rewind:!1,mouseDrag:!0,touchDrag:!0,pullDrag:!0,freeDrag:!1,margin:0,stagePadding:0,merge:!1,mergeFit:!0,autoWidth:!1,startPosition:0,rtl:!1,smartSpeed:250,fluidSpeed:!1,dragEndSpeed:!1,responsive:{},responsiveRefreshRate:200,responsiveBaseElement:b,fallbackEasing:"swing",info:!1,nestedItemSelector:!1,itemElement:"div",stageElement:"div",refreshClass:"owl-refresh",loadedClass:"owl-loaded",loadingClass:"owl-loading",rtlClass:"owl-rtl",responsiveClass:"owl-responsive",dragClass:"owl-drag",itemClass:"owl-item",stageClass:"owl-stage",stageOuterClass:"owl-stage-outer",grabClass:"owl-grab"},e.Width={Default:"default",Inner:"inner",Outer:"outer"},e.Type={Event:"event",State:"state"},e.Plugins={},e.Workers=[{filter:["width","settings"],run:function(){this._width=this.$element.width()}},{filter:["width","items","settings"],run:function(a){a.current=this._items&&this._items[this.relative(this._current)]}},{filter:["items","settings"],run:function(){this.$stage.children(".cloned").remove()}},{filter:["width","items","settings"],run:function(a){var b=this.settings.margin||"",c=!this.settings.autoWidth,d=this.settings.rtl,e={width:"auto","margin-left":d?b:"","margin-right":d?"":b};!c&&this.$stage.children().css(e),a.css=e}},{filter:["width","items","settings"],run:function(a){var b=(this.width()/this.settings.items).toFixed(3)-this.settings.margin,c=null,d=this._items.length,e=!this.settings.autoWidth,f=[];for(a.items={merge:!1,width:b};d--;)c=this._mergers[d],c=this.settings.mergeFit&&Math.min(c,this.settings.items)||c,a.items.merge=c>1||a.items.merge,f[d]=e?b*c:this._items[d].width();this._widths=f}},{filter:["items","settings"],run:function(){var b=[],c=this._items,d=this.settings,e=Math.max(2*d.items,4),f=2*Math.ceil(c.length/2),g=d.loop&&c.length?d.rewind?e:Math.max(e,f):0,h="",i="";for(g/=2;g--;)b.push(this.normalize(b.length/2,!0)),h+=c[b[b.length-1]][0].outerHTML,b.push(this.normalize(c.length-1-(b.length-1)/2,!0)),i=c[b[b.length-1]][0].outerHTML+i;this._clones=b,a(h).addClass("cloned").appendTo(this.$stage),a(i).addClass("cloned").prependTo(this.$stage)}},{filter:["width","items","settings"],run:function(){for(var a=this.settings.rtl?1:-1,b=this._clones.length+this._items.length,c=-1,d=0,e=0,f=[];++c<b;)d=f[c-1]||0,e=this._widths[this.relative(c)]+this.settings.margin,f.push(d+e*a);this._coordinates=f}},{filter:["width","items","settings"],run:function(){var a=this.settings.stagePadding,b=this._coordinates,c={width:Math.ceil(Math.abs(b[b.length-1]))+2*a,"padding-left":a||"","padding-right":a||""};this.$stage.css(c)}},{filter:["width","items","settings"],run:function(a){var b=this._coordinates.length,c=!this.settings.autoWidth,d=this.$stage.children();if(c&&a.items.merge)for(;b--;)a.css.width=this._widths[this.relative(b)],d.eq(b).css(a.css);else c&&(a.css.width=a.items.width,d.css(a.css))}},{filter:["items"],run:function(){this._coordinates.length<1&&this.$stage.removeAttr("style")}},{filter:["width","items","settings"],run:function(a){a.current=a.current?this.$stage.children().index(a.current):0,a.current=Math.max(this.minimum(),Math.min(this.maximum(),a.current)),this.reset(a.current)}},{filter:["position"],run:function(){this.animate(this.coordinates(this._current))}},{filter:["width","position","items","settings"],run:function(){var a,b,c,d,e=this.settings.rtl?1:-1,f=2*this.settings.stagePadding,g=this.coordinates(this.current())+f,h=g+this.width()*e,i=[];for(c=0,d=this._coordinates.length;c<d;c++)a=this._coordinates[c-1]||0,b=Math.abs(this._coordinates[c])+f*e,(this.op(a,"<=",g)&&this.op(a,">",h)||this.op(b,"<",g)&&this.op(b,">",h))&&i.push(c);this.$stage.children(".active").removeClass("active"),this.$stage.children(":eq("+i.join("), :eq(")+")").addClass("active"),this.settings.center&&(this.$stage.children(".center").removeClass("center"),this.$stage.children().eq(this.current()).addClass("center"))}}],e.prototype.initialize=function(){if(this.enter("initializing"),this.trigger("initialize"),this.$element.toggleClass(this.settings.rtlClass,this.settings.rtl),this.settings.autoWidth&&!this.is("pre-loading")){var b,c,e;b=this.$element.find("img"),c=this.settings.nestedItemSelector?"."+this.settings.nestedItemSelector:d,e=this.$element.children(c).width(),b.length&&e<=0&&this.preloadAutoWidthImages(b)}this.$element.addClass(this.options.loadingClass),this.$stage=a("<"+this.settings.stageElement+' class="'+this.settings.stageClass+'"/>').wrap('<div class="'+this.settings.stageOuterClass+'"/>'),this.$element.append(this.$stage.parent()),this.replace(this.$element.children().not(this.$stage.parent())),this.$element.is(":visible")?this.refresh():this.invalidate("width"),this.$element.removeClass(this.options.loadingClass).addClass(this.options.loadedClass),this.registerEventHandlers(),this.leave("initializing"),this.trigger("initialized")},e.prototype.setup=function(){var b=this.viewport(),c=this.options.responsive,d=-1,e=null;c?(a.each(c,function(a){a<=b&&a>d&&(d=Number(a))}),e=a.extend({},this.options,c[d]),"function"==typeof e.stagePadding&&(e.stagePadding=e.stagePadding()),delete e.responsive,e.responsiveClass&&this.$element.attr("class",this.$element.attr("class").replace(new RegExp("("+this.options.responsiveClass+"-)\\S+\\s","g"),"$1"+d))):e=a.extend({},this.options),this.trigger("change",{property:{name:"settings",value:e}}),this._breakpoint=d,this.settings=e,this.invalidate("settings"),this.trigger("changed",{property:{name:"settings",value:this.settings}})},e.prototype.optionsLogic=function(){this.settings.autoWidth&&(this.settings.stagePadding=!1,this.settings.merge=!1)},e.prototype.prepare=function(b){var c=this.trigger("prepare",{content:b});return c.data||(c.data=a("<"+this.settings.itemElement+"/>").addClass(this.options.itemClass).append(b)),this.trigger("prepared",{content:c.data}),c.data},e.prototype.update=function(){for(var b=0,c=this._pipe.length,d=a.proxy(function(a){return this[a]},this._invalidated),e={};b<c;)(this._invalidated.all||a.grep(this._pipe[b].filter,d).length>0)&&this._pipe[b].run(e),b++;this._invalidated={},!this.is("valid")&&this.enter("valid")},e.prototype.width=function(a){switch(a=a||e.Width.Default){case e.Width.Inner:case e.Width.Outer:return this._width;default:return this._width-2*this.settings.stagePadding+this.settings.margin}},e.prototype.refresh=function(){this.enter("refreshing"),this.trigger("refresh"),this.setup(),this.optionsLogic(),this.$element.addClass(this.options.refreshClass),this.update(),this.$element.removeClass(this.options.refreshClass),this.leave("refreshing"),this.trigger("refreshed")},e.prototype.onThrottledResize=function(){b.clearTimeout(this.resizeTimer),this.resizeTimer=b.setTimeout(this._handlers.onResize,this.settings.responsiveRefreshRate)},e.prototype.onResize=function(){return!!this._items.length&&(this._width!==this.$element.width()&&(!!this.$element.is(":visible")&&(this.enter("resizing"),this.trigger("resize").isDefaultPrevented()?(this.leave("resizing"),!1):(this.invalidate("width"),this.refresh(),this.leave("resizing"),void this.trigger("resized")))))},e.prototype.registerEventHandlers=function(){a.support.transition&&this.$stage.on(a.support.transition.end+".owl.core",a.proxy(this.onTransitionEnd,this)),this.settings.responsive!==!1&&this.on(b,"resize",this._handlers.onThrottledResize),this.settings.mouseDrag&&(this.$element.addClass(this.options.dragClass),this.$stage.on("mousedown.owl.core",a.proxy(this.onDragStart,this)),this.$stage.on("dragstart.owl.core selectstart.owl.core",function(){return!1})),this.settings.touchDrag&&(this.$stage.on("touchstart.owl.core",a.proxy(this.onDragStart,this)),this.$stage.on("touchcancel.owl.core",a.proxy(this.onDragEnd,this)))},e.prototype.onDragStart=function(b){var d=null;3!==b.which&&(a.support.transform?(d=this.$stage.css("transform").replace(/.*\(|\)| /g,"").split(","),d={x:d[16===d.length?12:4],y:d[16===d.length?13:5]}):(d=this.$stage.position(),d={x:this.settings.rtl?d.left+this.$stage.width()-this.width()+this.settings.margin:d.left,y:d.top}),this.is("animating")&&(a.support.transform?this.animate(d.x):this.$stage.stop(),this.invalidate("position")),this.$element.toggleClass(this.options.grabClass,"mousedown"===b.type),this.speed(0),this._drag.time=(new Date).getTime(),this._drag.target=a(b.target),this._drag.stage.start=d,this._drag.stage.current=d,this._drag.pointer=this.pointer(b),a(c).on("mouseup.owl.core touchend.owl.core",a.proxy(this.onDragEnd,this)),a(c).one("mousemove.owl.core touchmove.owl.core",a.proxy(function(b){var d=this.difference(this._drag.pointer,this.pointer(b));a(c).on("mousemove.owl.core touchmove.owl.core",a.proxy(this.onDragMove,this)),Math.abs(d.x)<Math.abs(d.y)&&this.is("valid")||(b.preventDefault(),this.enter("dragging"),this.trigger("drag"))},this)))},e.prototype.onDragMove=function(a){var b=null,c=null,d=null,e=this.difference(this._drag.pointer,this.pointer(a)),f=this.difference(this._drag.stage.start,e);this.is("dragging")&&(a.preventDefault(),this.settings.loop?(b=this.coordinates(this.minimum()),c=this.coordinates(this.maximum()+1)-b,f.x=((f.x-b)%c+c)%c+b):(b=this.settings.rtl?this.coordinates(this.maximum()):this.coordinates(this.minimum()),c=this.settings.rtl?this.coordinates(this.minimum()):this.coordinates(this.maximum()),d=this.settings.pullDrag?-1*e.x/5:0,f.x=Math.max(Math.min(f.x,b+d),c+d)),this._drag.stage.current=f,this.animate(f.x))},e.prototype.onDragEnd=function(b){var d=this.difference(this._drag.pointer,this.pointer(b)),e=this._drag.stage.current,f=d.x>0^this.settings.rtl?"left":"right";a(c).off(".owl.core"),this.$element.removeClass(this.options.grabClass),(0!==d.x&&this.is("dragging")||!this.is("valid"))&&(this.speed(this.settings.dragEndSpeed||this.settings.smartSpeed),this.current(this.closest(e.x,0!==d.x?f:this._drag.direction)),this.invalidate("position"),this.update(),this._drag.direction=f,(Math.abs(d.x)>3||(new Date).getTime()-this._drag.time>300)&&this._drag.target.one("click.owl.core",function(){return!1})),this.is("dragging")&&(this.leave("dragging"),this.trigger("dragged"))},e.prototype.closest=function(b,c){var d=-1,e=30,f=this.width(),g=this.coordinates();return this.settings.freeDrag||a.each(g,a.proxy(function(a,h){return"left"===c&&b>h-e&&b<h+e?d=a:"right"===c&&b>h-f-e&&b<h-f+e?d=a+1:this.op(b,"<",h)&&this.op(b,">",g[a+1]||h-f)&&(d="left"===c?a+1:a),d===-1},this)),this.settings.loop||(this.op(b,">",g[this.minimum()])?d=b=this.minimum():this.op(b,"<",g[this.maximum()])&&(d=b=this.maximum())),d},e.prototype.animate=function(b){var c=this.speed()>0;this.is("animating")&&this.onTransitionEnd(),c&&(this.enter("animating"),this.trigger("translate")),a.support.transform3d&&a.support.transition?this.$stage.css({transform:"translate3d("+b+"px,0px,0px)",transition:this.speed()/1e3+"s"}):c?this.$stage.animate({left:b+"px"},this.speed(),this.settings.fallbackEasing,a.proxy(this.onTransitionEnd,this)):this.$stage.css({left:b+"px"})},e.prototype.is=function(a){return this._states.current[a]&&this._states.current[a]>0},e.prototype.current=function(a){if(a===d)return this._current;if(0===this._items.length)return d;if(a=this.normalize(a),this._current!==a){var b=this.trigger("change",{property:{name:"position",value:a}});b.data!==d&&(a=this.normalize(b.data)),this._current=a,this.invalidate("position"),this.trigger("changed",{property:{name:"position",value:this._current}})}return this._current},e.prototype.invalidate=function(b){return"string"===a.type(b)&&(this._invalidated[b]=!0,this.is("valid")&&this.leave("valid")),a.map(this._invalidated,function(a,b){return b})},e.prototype.reset=function(a){a=this.normalize(a),a!==d&&(this._speed=0,this._current=a,this.suppress(["translate","translated"]),this.animate(this.coordinates(a)),this.release(["translate","translated"]))},e.prototype.normalize=function(a,b){var c=this._items.length,e=b?0:this._clones.length;return!this.isNumeric(a)||c<1?a=d:(a<0||a>=c+e)&&(a=((a-e/2)%c+c)%c+e/2),a},e.prototype.relative=function(a){return a-=this._clones.length/2,this.normalize(a,!0)},e.prototype.maximum=function(a){var b,c,d,e=this.settings,f=this._coordinates.length;if(e.loop)f=this._clones.length/2+this._items.length-1;else if(e.autoWidth||e.merge){for(b=this._items.length,c=this._items[--b].width(),d=this.$element.width();b--&&(c+=this._items[b].width()+this.settings.margin,!(c>d)););f=b+1}else f=e.center?this._items.length-1:this._items.length-e.items;return a&&(f-=this._clones.length/2),Math.max(f,0)},e.prototype.minimum=function(a){return a?0:this._clones.length/2},e.prototype.items=function(a){return a===d?this._items.slice():(a=this.normalize(a,!0),this._items[a])},e.prototype.mergers=function(a){return a===d?this._mergers.slice():(a=this.normalize(a,!0),this._mergers[a])},e.prototype.clones=function(b){var c=this._clones.length/2,e=c+this._items.length,f=function(a){return a%2===0?e+a/2:c-(a+1)/2};return b===d?a.map(this._clones,function(a,b){return f(b)}):a.map(this._clones,function(a,c){return a===b?f(c):null})},e.prototype.speed=function(a){return a!==d&&(this._speed=a),this._speed},e.prototype.coordinates=function(b){var c,e=1,f=b-1;return b===d?a.map(this._coordinates,a.proxy(function(a,b){return this.coordinates(b)},this)):(this.settings.center?(this.settings.rtl&&(e=-1,f=b+1),c=this._coordinates[b],c+=(this.width()-c+(this._coordinates[f]||0))/2*e):c=this._coordinates[f]||0,c=Math.ceil(c))},e.prototype.duration=function(a,b,c){return 0===c?0:Math.min(Math.max(Math.abs(b-a),1),6)*Math.abs(c||this.settings.smartSpeed)},e.prototype.to=function(a,b){var c=this.current(),d=null,e=a-this.relative(c),f=(e>0)-(e<0),g=this._items.length,h=this.minimum(),i=this.maximum();this.settings.loop?(!this.settings.rewind&&Math.abs(e)>g/2&&(e+=f*-1*g),a=c+e,d=((a-h)%g+g)%g+h,d!==a&&d-e<=i&&d-e>0&&(c=d-e,a=d,this.reset(c))):this.settings.rewind?(i+=1,a=(a%i+i)%i):a=Math.max(h,Math.min(i,a)),this.speed(this.duration(c,a,b)),this.current(a),this.$element.is(":visible")&&this.update()},e.prototype.next=function(a){a=a||!1,this.to(this.relative(this.current())+1,a)},e.prototype.prev=function(a){a=a||!1,this.to(this.relative(this.current())-1,a)},e.prototype.onTransitionEnd=function(a){if(a!==d&&(a.stopPropagation(),(a.target||a.srcElement||a.originalTarget)!==this.$stage.get(0)))return!1;this.leave("animating"),this.trigger("translated")},e.prototype.viewport=function(){var d;return this.options.responsiveBaseElement!==b?d=a(this.options.responsiveBaseElement).width():b.innerWidth?d=b.innerWidth:c.documentElement&&c.documentElement.clientWidth?d=c.documentElement.clientWidth:console.warn("Can not detect viewport width."),d},e.prototype.replace=function(b){this.$stage.empty(),this._items=[],b&&(b=b instanceof jQuery?b:a(b)),this.settings.nestedItemSelector&&(b=b.find("."+this.settings.nestedItemSelector)),b.filter(function(){return 1===this.nodeType}).each(a.proxy(function(a,b){b=this.prepare(b),this.$stage.append(b),this._items.push(b),this._mergers.push(1*b.find("[data-merge]").addBack("[data-merge]").attr("data-merge")||1)},this)),this.reset(this.isNumeric(this.settings.startPosition)?this.settings.startPosition:0),this.invalidate("items")},e.prototype.add=function(b,c){var e=this.relative(this._current);c=c===d?this._items.length:this.normalize(c,!0),b=b instanceof jQuery?b:a(b),this.trigger("add",{content:b,position:c}),b=this.prepare(b),0===this._items.length||c===this._items.length?(0===this._items.length&&this.$stage.append(b),0!==this._items.length&&this._items[c-1].after(b),this._items.push(b),this._mergers.push(1*b.find("[data-merge]").addBack("[data-merge]").attr("data-merge")||1)):(this._items[c].before(b),this._items.splice(c,0,b),this._mergers.splice(c,0,1*b.find("[data-merge]").addBack("[data-merge]").attr("data-merge")||1)),this._items[e]&&this.reset(this._items[e].index()),this.invalidate("items"),this.trigger("added",{content:b,position:c})},e.prototype.remove=function(a){a=this.normalize(a,!0),a!==d&&(this.trigger("remove",{content:this._items[a],position:a}),this._items[a].remove(),this._items.splice(a,1),this._mergers.splice(a,1),this.invalidate("items"),this.trigger("removed",{content:null,position:a}))},e.prototype.preloadAutoWidthImages=function(b){b.each(a.proxy(function(b,c){this.enter("pre-loading"),c=a(c),a(new Image).one("load",a.proxy(function(a){c.attr("src",a.target.src),c.css("opacity",1),this.leave("pre-loading"),!this.is("pre-loading")&&!this.is("initializing")&&this.refresh()},this)).attr("src",c.attr("src")||c.attr("data-src")||c.attr("data-src-retina"))},this))},e.prototype.destroy=function(){this.$element.off(".owl.core"),this.$stage.off(".owl.core"),a(c).off(".owl.core"),this.settings.responsive!==!1&&(b.clearTimeout(this.resizeTimer),this.off(b,"resize",this._handlers.onThrottledResize));for(var d in this._plugins)this._plugins[d].destroy();this.$stage.children(".cloned").remove(),this.$stage.unwrap(),this.$stage.children().contents().unwrap(),this.$stage.children().unwrap(),this.$element.removeClass(this.options.refreshClass).removeClass(this.options.loadingClass).removeClass(this.options.loadedClass).removeClass(this.options.rtlClass).removeClass(this.options.dragClass).removeClass(this.options.grabClass).attr("class",this.$element.attr("class").replace(new RegExp(this.options.responsiveClass+"-\\S+\\s","g"),"")).removeData("owl.carousel")},e.prototype.op=function(a,b,c){var d=this.settings.rtl;switch(b){case"<":return d?a>c:a<c;case">":return d?a<c:a>c;case">=":return d?a<=c:a>=c;case"<=":return d?a>=c:a<=c}},e.prototype.on=function(a,b,c,d){a.addEventListener?a.addEventListener(b,c,d):a.attachEvent&&a.attachEvent("on"+b,c)},e.prototype.off=function(a,b,c,d){a.removeEventListener?a.removeEventListener(b,c,d):a.detachEvent&&a.detachEvent("on"+b,c)},e.prototype.trigger=function(b,c,d,f,g){var h={item:{count:this._items.length,index:this.current()}},i=a.camelCase(a.grep(["on",b,d],function(a){return a}).join("-").toLowerCase()),j=a.Event([b,"owl",d||"carousel"].join(".").toLowerCase(),a.extend({relatedTarget:this},h,c));return this._supress[b]||(a.each(this._plugins,function(a,b){b.onTrigger&&b.onTrigger(j)}),this.register({type:e.Type.Event,name:b}),this.$element.trigger(j),this.settings&&"function"==typeof this.settings[i]&&this.settings[i].call(this,j)),j},e.prototype.enter=function(b){a.each([b].concat(this._states.tags[b]||[]),a.proxy(function(a,b){this._states.current[b]===d&&(this._states.current[b]=0),this._states.current[b]++},this))},e.prototype.leave=function(b){a.each([b].concat(this._states.tags[b]||[]),a.proxy(function(a,b){this._states.current[b]--},this))},e.prototype.register=function(b){if(b.type===e.Type.Event){if(a.event.special[b.name]||(a.event.special[b.name]={}),!a.event.special[b.name].owl){var c=a.event.special[b.name]._default;a.event.special[b.name]._default=function(a){return!c||!c.apply||a.namespace&&a.namespace.indexOf("owl")!==-1?a.namespace&&a.namespace.indexOf("owl")>-1:c.apply(this,arguments)},a.event.special[b.name].owl=!0}}else b.type===e.Type.State&&(this._states.tags[b.name]?this._states.tags[b.name]=this._states.tags[b.name].concat(b.tags):this._states.tags[b.name]=b.tags,this._states.tags[b.name]=a.grep(this._states.tags[b.name],a.proxy(function(c,d){return a.inArray(c,this._states.tags[b.name])===d},this)))},e.prototype.suppress=function(b){a.each(b,a.proxy(function(a,b){this._supress[b]=!0},this))},e.prototype.release=function(b){a.each(b,a.proxy(function(a,b){delete this._supress[b]},this))},e.prototype.pointer=function(a){var c={x:null,y:null};return a=a.originalEvent||a||b.event,a=a.touches&&a.touches.length?a.touches[0]:a.changedTouches&&a.changedTouches.length?a.changedTouches[0]:a,a.pageX?(c.x=a.pageX,c.y=a.pageY):(c.x=a.clientX,c.y=a.clientY),c},e.prototype.isNumeric=function(a){return!isNaN(parseFloat(a))},e.prototype.difference=function(a,b){return{x:a.x-b.x,y:a.y-b.y}},a.fn.owlCarousel=function(b){var c=Array.prototype.slice.call(arguments,1);return this.each(function(){var d=a(this),f=d.data("owl.carousel");f||(f=new e(this,"object"==typeof b&&b),d.data("owl.carousel",f),a.each(["next","prev","to","destroy","refresh","replace","add","remove"],function(b,c){f.register({type:e.Type.Event,name:c}),f.$element.on(c+".owl.carousel.core",a.proxy(function(a){a.namespace&&a.relatedTarget!==this&&(this.suppress([c]),f[c].apply(this,[].slice.call(arguments,1)),this.release([c]))},f))})),"string"==typeof b&&"_"!==b.charAt(0)&&f[b].apply(f,c)})},a.fn.owlCarousel.Constructor=e}(window.Zepto||window.jQuery,window,document),function(a,b,c,d){var e=function(b){this._core=b,this._interval=null,this._visible=null,this._handlers={"initialized.owl.carousel":a.proxy(function(a){a.namespace&&this._core.settings.autoRefresh&&this.watch()},this)},this._core.options=a.extend({},e.Defaults,this._core.options),this._core.$element.on(this._handlers)};e.Defaults={autoRefresh:!0,autoRefreshInterval:500},e.prototype.watch=function(){this._interval||(this._visible=this._core.$element.is(":visible"),this._interval=b.setInterval(a.proxy(this.refresh,this),this._core.settings.autoRefreshInterval))},e.prototype.refresh=function(){this._core.$element.is(":visible")!==this._visible&&(this._visible=!this._visible,this._core.$element.toggleClass("owl-hidden",!this._visible),this._visible&&this._core.invalidate("width")&&this._core.refresh())},e.prototype.destroy=function(){var a,c;b.clearInterval(this._interval);for(a in this._handlers)this._core.$element.off(a,this._handlers[a]);for(c in Object.getOwnPropertyNames(this))"function"!=typeof this[c]&&(this[c]=null)},a.fn.owlCarousel.Constructor.Plugins.AutoRefresh=e}(window.Zepto||window.jQuery,window,document),function(a,b,c,d){var e=function(b){this._core=b,this._loaded=[],this._handlers={"initialized.owl.carousel change.owl.carousel resized.owl.carousel":a.proxy(function(b){if(b.namespace&&this._core.settings&&this._core.settings.lazyLoad&&(b.property&&"position"==b.property.name||"initialized"==b.type))for(var c=this._core.settings,e=c.center&&Math.ceil(c.items/2)||c.items,f=c.center&&e*-1||0,g=(b.property&&b.property.value!==d?b.property.value:this._core.current())+f,h=this._core.clones().length,i=a.proxy(function(a,b){this.load(b)},this);f++<e;)this.load(h/2+this._core.relative(g)),h&&a.each(this._core.clones(this._core.relative(g)),i),g++},this)},this._core.options=a.extend({},e.Defaults,this._core.options),this._core.$element.on(this._handlers)};e.Defaults={lazyLoad:!1},e.prototype.load=function(c){var d=this._core.$stage.children().eq(c),e=d&&d.find(".owl-lazy");!e||a.inArray(d.get(0),this._loaded)>-1||(e.each(a.proxy(function(c,d){var e,f=a(d),g=b.devicePixelRatio>1&&f.attr("data-src-retina")||f.attr("data-src");this._core.trigger("load",{element:f,url:g},"lazy"),f.is("img")?f.one("load.owl.lazy",a.proxy(function(){f.css("opacity",1),this._core.trigger("loaded",{element:f,url:g},"lazy")},this)).attr("src",g):(e=new Image,e.onload=a.proxy(function(){f.css({"background-image":'url("'+g+'")',opacity:"1"}),this._core.trigger("loaded",{element:f,url:g},"lazy")},this),e.src=g)},this)),this._loaded.push(d.get(0)))},e.prototype.destroy=function(){var a,b;for(a in this.handlers)this._core.$element.off(a,this.handlers[a]);for(b in Object.getOwnPropertyNames(this))"function"!=typeof this[b]&&(this[b]=null)},a.fn.owlCarousel.Constructor.Plugins.Lazy=e}(window.Zepto||window.jQuery,window,document),function(a,b,c,d){var e=function(b){this._core=b,this._handlers={"initialized.owl.carousel refreshed.owl.carousel":a.proxy(function(a){a.namespace&&this._core.settings.autoHeight&&this.update()},this),"changed.owl.carousel":a.proxy(function(a){a.namespace&&this._core.settings.autoHeight&&"position"==a.property.name&&this.update()},this),"loaded.owl.lazy":a.proxy(function(a){a.namespace&&this._core.settings.autoHeight&&a.element.closest("."+this._core.settings.itemClass).index()===this._core.current()&&this.update()},this)},this._core.options=a.extend({},e.Defaults,this._core.options),this._core.$element.on(this._handlers)};e.Defaults={autoHeight:!1,autoHeightClass:"owl-height"},e.prototype.update=function(){var b=this._core._current,c=b+this._core.settings.items,d=this._core.$stage.children().toArray().slice(b,c),e=[],f=0;a.each(d,function(b,c){e.push(a(c).height())}),f=Math.max.apply(null,e),this._core.$stage.parent().height(f).addClass(this._core.settings.autoHeightClass)},e.prototype.destroy=function(){var a,b;for(a in this._handlers)this._core.$element.off(a,this._handlers[a]);for(b in Object.getOwnPropertyNames(this))"function"!=typeof this[b]&&(this[b]=null)},a.fn.owlCarousel.Constructor.Plugins.AutoHeight=e}(window.Zepto||window.jQuery,window,document),function(a,b,c,d){var e=function(b){this._core=b,this._videos={},this._playing=null,this._handlers={"initialized.owl.carousel":a.proxy(function(a){a.namespace&&this._core.register({type:"state",name:"playing",tags:["interacting"]})},this),"resize.owl.carousel":a.proxy(function(a){a.namespace&&this._core.settings.video&&this.isInFullScreen()&&a.preventDefault()},this),"refreshed.owl.carousel":a.proxy(function(a){a.namespace&&this._core.is("resizing")&&this._core.$stage.find(".cloned .owl-video-frame").remove()},this),"changed.owl.carousel":a.proxy(function(a){a.namespace&&"position"===a.property.name&&this._playing&&this.stop()},this),"prepared.owl.carousel":a.proxy(function(b){if(b.namespace){var c=a(b.content).find(".owl-video");c.length&&(c.css("display","none"),this.fetch(c,a(b.content)))}},this)},this._core.options=a.extend({},e.Defaults,this._core.options),this._core.$element.on(this._handlers),this._core.$element.on("click.owl.video",".owl-video-play-icon",a.proxy(function(a){this.play(a)},this))};e.Defaults={video:!1,videoHeight:!1,videoWidth:!1},e.prototype.fetch=function(a,b){var c=function(){return a.attr("data-vimeo-id")?"vimeo":a.attr("data-vzaar-id")?"vzaar":"youtube"}(),d=a.attr("data-vimeo-id")||a.attr("data-youtube-id")||a.attr("data-vzaar-id"),e=a.attr("data-width")||this._core.settings.videoWidth,f=a.attr("data-height")||this._core.settings.videoHeight,g=a.attr("href");if(!g)throw new Error("Missing video URL.");if(d=g.match(/(http:|https:|)\/\/(player.|www.|app.)?(vimeo\.com|youtu(be\.com|\.be|be\.googleapis\.com)|vzaar\.com)\/(video\/|videos\/|embed\/|channels\/.+\/|groups\/.+\/|watch\?v=|v\/)?([A-Za-z0-9._%-]*)(\&\S+)?/),d[3].indexOf("youtu")>-1)c="youtube";else if(d[3].indexOf("vimeo")>-1)c="vimeo";else{if(!(d[3].indexOf("vzaar")>-1))throw new Error("Video URL not supported.");c="vzaar"}d=d[6],this._videos[g]={type:c,id:d,width:e,height:f},b.attr("data-video",g),this.thumbnail(a,this._videos[g])},e.prototype.thumbnail=function(b,c){var d,e,f,g=c.width&&c.height?'style="width:'+c.width+"px;height:"+c.height+'px;"':"",h=b.find("img"),i="src",j="",k=this._core.settings,l=function(a){e='<div class="owl-video-play-icon"></div>',d=k.lazyLoad?'<div class="owl-video-tn '+j+'" '+i+'="'+a+'"></div>':'<div class="owl-video-tn" style="opacity:1;background-image:url('+a+')"></div>',b.after(d),b.after(e)};if(b.wrap('<div class="owl-video-wrapper"'+g+"></div>"),this._core.settings.lazyLoad&&(i="data-src",j="owl-lazy"),h.length)return l(h.attr(i)),h.remove(),!1;"youtube"===c.type?(f="//img.youtube.com/vi/"+c.id+"/hqdefault.jpg",l(f)):"vimeo"===c.type?a.ajax({type:"GET",url:"//vimeo.com/api/v2/video/"+c.id+".json",jsonp:"callback",dataType:"jsonp",success:function(a){f=a[0].thumbnail_large,l(f)}}):"vzaar"===c.type&&a.ajax({type:"GET",url:"//vzaar.com/api/videos/"+c.id+".json",jsonp:"callback",dataType:"jsonp",success:function(a){f=a.framegrab_url,l(f)}})},e.prototype.stop=function(){this._core.trigger("stop",null,"video"),this._playing.find(".owl-video-frame").remove(),this._playing.removeClass("owl-video-playing"),this._playing=null,this._core.leave("playing"),this._core.trigger("stopped",null,"video")},e.prototype.play=function(b){var c,d=a(b.target),e=d.closest("."+this._core.settings.itemClass),f=this._videos[e.attr("data-video")],g=f.width||"100%",h=f.height||this._core.$stage.height();this._playing||(this._core.enter("playing"),this._core.trigger("play",null,"video"),e=this._core.items(this._core.relative(e.index())),this._core.reset(e.index()),"youtube"===f.type?c='<iframe width="'+g+'" height="'+h+'" src="//www.youtube.com/embed/'+f.id+"?autoplay=1&rel=0&v="+f.id+'" frameborder="0" allowfullscreen></iframe>':"vimeo"===f.type?c='<iframe src="//player.vimeo.com/video/'+f.id+'?autoplay=1" width="'+g+'" height="'+h+'" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>':"vzaar"===f.type&&(c='<iframe frameborder="0"height="'+h+'"width="'+g+'" allowfullscreen mozallowfullscreen webkitAllowFullScreen src="//view.vzaar.com/'+f.id+'/player?autoplay=true"></iframe>'),a('<div class="owl-video-frame">'+c+"</div>").insertAfter(e.find(".owl-video")),this._playing=e.addClass("owl-video-playing"))},e.prototype.isInFullScreen=function(){var b=c.fullscreenElement||c.mozFullScreenElement||c.webkitFullscreenElement;return b&&a(b).parent().hasClass("owl-video-frame")},e.prototype.destroy=function(){var a,b;this._core.$element.off("click.owl.video");for(a in this._handlers)this._core.$element.off(a,this._handlers[a]);for(b in Object.getOwnPropertyNames(this))"function"!=typeof this[b]&&(this[b]=null)},a.fn.owlCarousel.Constructor.Plugins.Video=e}(window.Zepto||window.jQuery,window,document),function(a,b,c,d){var e=function(b){this.core=b,this.core.options=a.extend({},e.Defaults,this.core.options),this.swapping=!0,this.previous=d,this.next=d,this.handlers={"change.owl.carousel":a.proxy(function(a){a.namespace&&"position"==a.property.name&&(this.previous=this.core.current(),this.next=a.property.value)},this),"drag.owl.carousel dragged.owl.carousel translated.owl.carousel":a.proxy(function(a){a.namespace&&(this.swapping="translated"==a.type)},this),"translate.owl.carousel":a.proxy(function(a){a.namespace&&this.swapping&&(this.core.options.animateOut||this.core.options.animateIn)&&this.swap()},this)},this.core.$element.on(this.handlers)};e.Defaults={animateOut:!1,animateIn:!1},e.prototype.swap=function(){if(1===this.core.settings.items&&a.support.animation&&a.support.transition){this.core.speed(0);var b,c=a.proxy(this.clear,this),d=this.core.$stage.children().eq(this.previous),e=this.core.$stage.children().eq(this.next),f=this.core.settings.animateIn,g=this.core.settings.animateOut;this.core.current()!==this.previous&&(g&&(b=this.core.coordinates(this.previous)-this.core.coordinates(this.next),d.one(a.support.animation.end,c).css({left:b+"px"}).addClass("animated owl-animated-out").addClass(g)),f&&e.one(a.support.animation.end,c).addClass("animated owl-animated-in").addClass(f))}},e.prototype.clear=function(b){a(b.target).css({left:""}).removeClass("animated owl-animated-out owl-animated-in").removeClass(this.core.settings.animateIn).removeClass(this.core.settings.animateOut),this.core.onTransitionEnd()},e.prototype.destroy=function(){var a,b;for(a in this.handlers)this.core.$element.off(a,this.handlers[a]);for(b in Object.getOwnPropertyNames(this))"function"!=typeof this[b]&&(this[b]=null)},
    a.fn.owlCarousel.Constructor.Plugins.Animate = e
}(window.Zepto || window.jQuery, window, document), function (a, b, c, d) {
    var e = function (b) {
        this._core = b, this._timeout = null, this._paused = !1, this._handlers = {
            "changed.owl.carousel": a.proxy(function (a) {
                a.namespace && "settings" === a.property.name ? this._core.settings.autoplay ? this.play() : this.stop() : a.namespace && "position" === a.property.name && this._core.settings.autoplay && this._setAutoPlayInterval()
            }, this), "initialized.owl.carousel": a.proxy(function (a) {
                a.namespace && this._core.settings.autoplay && this.play()
            }, this), "play.owl.autoplay": a.proxy(function (a, b, c) {
                a.namespace && this.play(b, c)
            }, this), "stop.owl.autoplay": a.proxy(function (a) {
                a.namespace && this.stop()
            }, this), "mouseover.owl.autoplay": a.proxy(function () {
                this._core.settings.autoplayHoverPause && this._core.is("rotating") && this.pause()
            }, this), "mouseleave.owl.autoplay": a.proxy(function () {
                this._core.settings.autoplayHoverPause && this._core.is("rotating") && this.play()
            }, this), "touchstart.owl.core": a.proxy(function () {
                this._core.settings.autoplayHoverPause && this._core.is("rotating") && this.pause()
            }, this), "touchend.owl.core": a.proxy(function () {
                this._core.settings.autoplayHoverPause && this.play()
            }, this)
        }, this._core.$element.on(this._handlers), this._core.options = a.extend({}, e.Defaults, this._core.options)
    };
    e.Defaults = {
        autoplay: !1,
        autoplayTimeout: 5e3,
        autoplayHoverPause: !1,
        autoplaySpeed: !1
    }, e.prototype.play = function (a, b) {
        this._paused = !1, this._core.is("rotating") || (this._core.enter("rotating"), this._setAutoPlayInterval())
    }, e.prototype._getNextTimeout = function (d, e) {
        return this._timeout && b.clearTimeout(this._timeout), b.setTimeout(a.proxy(function () {
            this._paused || this._core.is("busy") || this._core.is("interacting") || c.hidden || this._core.next(e || this._core.settings.autoplaySpeed)
        }, this), d || this._core.settings.autoplayTimeout)
    }, e.prototype._setAutoPlayInterval = function () {
        this._timeout = this._getNextTimeout()
    }, e.prototype.stop = function () {
        this._core.is("rotating") && (b.clearTimeout(this._timeout), this._core.leave("rotating"))
    }, e.prototype.pause = function () {
        this._core.is("rotating") && (this._paused = !0)
    }, e.prototype.destroy = function () {
        var a, b;
        this.stop();
        for (a in this._handlers) this._core.$element.off(a, this._handlers[a]);
        for (b in Object.getOwnPropertyNames(this)) "function" != typeof this[b] && (this[b] = null)
    }, a.fn.owlCarousel.Constructor.Plugins.autoplay = e
}(window.Zepto || window.jQuery, window, document), function (a, b, c, d) {
    "use strict";
    var e = function (b) {
        this._core = b, this._initialized = !1, this._pages = [], this._controls = {}, this._templates = [], this.$element = this._core.$element, this._overrides = {
            next: this._core.next,
            prev: this._core.prev,
            to: this._core.to
        }, this._handlers = {
            "prepared.owl.carousel": a.proxy(function (b) {
                b.namespace && this._core.settings.dotsData && this._templates.push('<div class="' + this._core.settings.dotClass + '">' + a(b.content).find("[data-dot]").addBack("[data-dot]").attr("data-dot") + "</div>")
            }, this), "added.owl.carousel": a.proxy(function (a) {
                a.namespace && this._core.settings.dotsData && this._templates.splice(a.position, 0, this._templates.pop())
            }, this), "remove.owl.carousel": a.proxy(function (a) {
                a.namespace && this._core.settings.dotsData && this._templates.splice(a.position, 1)
            }, this), "changed.owl.carousel": a.proxy(function (a) {
                a.namespace && "position" == a.property.name && this.draw()
            }, this), "initialized.owl.carousel": a.proxy(function (a) {
                a.namespace && !this._initialized && (this._core.trigger("initialize", null, "navigation"), this.initialize(), this.update(), this.draw(), this._initialized = !0, this._core.trigger("initialized", null, "navigation"))
            }, this), "refreshed.owl.carousel": a.proxy(function (a) {
                a.namespace && this._initialized && (this._core.trigger("refresh", null, "navigation"), this.update(), this.draw(), this._core.trigger("refreshed", null, "navigation"))
            }, this)
        }, this._core.options = a.extend({}, e.Defaults, this._core.options), this.$element.on(this._handlers)
    };
    e.Defaults = {
        nav: !1,
        navText: ["prev", "next"],
        navSpeed: !1,
        navElement: "div",
        navContainer: !1,
        navContainerClass: "owl-nav",
        navClass: ["owl-prev", "owl-next"],
        slideBy: 1,
        dotClass: "owl-dot",
        dotsClass: "owl-dots",
        dots: !0,
        dotsEach: !1,
        dotsData: !1,
        dotsSpeed: !1,
        dotsContainer: !1
    }, e.prototype.initialize = function () {
        var b, c = this._core.settings;
        this._controls.$relative = (c.navContainer ? a(c.navContainer) : a("<div>").addClass(c.navContainerClass).appendTo(this.$element)).addClass("disabled"), this._controls.$previous = a("<" + c.navElement + ">").addClass(c.navClass[0]).html(c.navText[0]).prependTo(this._controls.$relative).on("click", a.proxy(function (a) {
            this.prev(c.navSpeed)
        }, this)), this._controls.$next = a("<" + c.navElement + ">").addClass(c.navClass[1]).html(c.navText[1]).appendTo(this._controls.$relative).on("click", a.proxy(function (a) {
            this.next(c.navSpeed)
        }, this)), c.dotsData || (this._templates = [a("<div>").addClass(c.dotClass).append(a("<span>")).prop("outerHTML")]), this._controls.$absolute = (c.dotsContainer ? a(c.dotsContainer) : a("<div>").addClass(c.dotsClass).appendTo(this.$element)).addClass("disabled"), this._controls.$absolute.on("click", "div", a.proxy(function (b) {
            var d = a(b.target).parent().is(this._controls.$absolute) ? a(b.target).index() : a(b.target).parent().index();
            b.preventDefault(), this.to(d, c.dotsSpeed)
        }, this));
        for (b in this._overrides) this._core[b] = a.proxy(this[b], this)
    }, e.prototype.destroy = function () {
        var a, b, c, d;
        for (a in this._handlers) this.$element.off(a, this._handlers[a]);
        for (b in this._controls) this._controls[b].remove();
        for (d in this.overides) this._core[d] = this._overrides[d];
        for (c in Object.getOwnPropertyNames(this)) "function" != typeof this[c] && (this[c] = null)
    }, e.prototype.update = function () {
        var a, b, c, d = this._core.clones().length / 2, e = d + this._core.items().length, f = this._core.maximum(!0),
            g = this._core.settings, h = g.center || g.autoWidth || g.dotsData ? 1 : g.dotsEach || g.items;
        if ("page" !== g.slideBy && (g.slideBy = Math.min(g.slideBy, g.items)), g.dots || "page" == g.slideBy) for (this._pages = [], a = d, b = 0, c = 0; a < e; a++) {
            if (b >= h || 0 === b) {
                if (this._pages.push({start: Math.min(f, a - d), end: a - d + h - 1}), Math.min(f, a - d) === f) break;
                b = 0, ++c
            }
            b += this._core.mergers(this._core.relative(a))
        }
    }, e.prototype.draw = function () {
        var b, c = this._core.settings, d = this._core.items().length <= c.items,
            e = this._core.relative(this._core.current()), f = c.loop || c.rewind;
        this._controls.$relative.toggleClass("disabled", !c.nav || d), c.nav && (this._controls.$previous.toggleClass("disabled", !f && e <= this._core.minimum(!0)), this._controls.$next.toggleClass("disabled", !f && e >= this._core.maximum(!0))), this._controls.$absolute.toggleClass("disabled", !c.dots || d), c.dots && (b = this._pages.length - this._controls.$absolute.children().length, c.dotsData && 0 !== b ? this._controls.$absolute.html(this._templates.join("")) : b > 0 ? this._controls.$absolute.append(new Array(b + 1).join(this._templates[0])) : b < 0 && this._controls.$absolute.children().slice(b).remove(), this._controls.$absolute.find(".active").removeClass("active"), this._controls.$absolute.children().eq(a.inArray(this.current(), this._pages)).addClass("active"))
    }, e.prototype.onTrigger = function (b) {
        var c = this._core.settings;
        b.page = {
            index: a.inArray(this.current(), this._pages),
            count: this._pages.length,
            size: c && (c.center || c.autoWidth || c.dotsData ? 1 : c.dotsEach || c.items)
        }
    }, e.prototype.current = function () {
        var b = this._core.relative(this._core.current());
        return a.grep(this._pages, a.proxy(function (a, c) {
            return a.start <= b && a.end >= b
        }, this)).pop()
    }, e.prototype.getPosition = function (b) {
        var c, d, e = this._core.settings;
        return "page" == e.slideBy ? (c = a.inArray(this.current(), this._pages), d = this._pages.length, b ? ++c : --c, c = this._pages[(c % d + d) % d].start) : (c = this._core.relative(this._core.current()), d = this._core.items().length, b ? c += e.slideBy : c -= e.slideBy), c
    }, e.prototype.next = function (b) {
        a.proxy(this._overrides.to, this._core)(this.getPosition(!0), b)
    }, e.prototype.prev = function (b) {
        a.proxy(this._overrides.to, this._core)(this.getPosition(!1), b)
    }, e.prototype.to = function (b, c, d) {
        var e;
        !d && this._pages.length ? (e = this._pages.length, a.proxy(this._overrides.to, this._core)(this._pages[(b % e + e) % e].start, c)) : a.proxy(this._overrides.to, this._core)(b, c)
    }, a.fn.owlCarousel.Constructor.Plugins.Navigation = e
}(window.Zepto || window.jQuery, window, document), function (a, b, c, d) {
    "use strict";
    var e = function (c) {
        this._core = c, this._hashes = {}, this.$element = this._core.$element, this._handlers = {
            "initialized.owl.carousel": a.proxy(function (c) {
                c.namespace && "URLHash" === this._core.settings.startPosition && a(b).trigger("hashchange.owl.navigation")
            }, this), "prepared.owl.carousel": a.proxy(function (b) {
                if (b.namespace) {
                    var c = a(b.content).find("[data-hash]").addBack("[data-hash]").attr("data-hash");
                    if (!c) return;
                    this._hashes[c] = b.content
                }
            }, this), "changed.owl.carousel": a.proxy(function (c) {
                if (c.namespace && "position" === c.property.name) {
                    var d = this._core.items(this._core.relative(this._core.current())),
                        e = a.map(this._hashes, function (a, b) {
                            return a === d ? b : null
                        }).join();
                    if (!e || b.location.hash.slice(1) === e) return;
                    b.location.hash = e
                }
            }, this)
        }, this._core.options = a.extend({}, e.Defaults, this._core.options), this.$element.on(this._handlers), a(b).on("hashchange.owl.navigation", a.proxy(function (a) {
            var c = b.location.hash.substring(1), e = this._core.$stage.children(),
                f = this._hashes[c] && e.index(this._hashes[c]);
            f !== d && f !== this._core.current() && this._core.to(this._core.relative(f), !1, !0)
        }, this))
    };
    e.Defaults = {URLhashListener: !1}, e.prototype.destroy = function () {
        var c, d;
        a(b).off("hashchange.owl.navigation");
        for (c in this._handlers) this._core.$element.off(c, this._handlers[c]);
        for (d in Object.getOwnPropertyNames(this)) "function" != typeof this[d] && (this[d] = null)
    }, a.fn.owlCarousel.Constructor.Plugins.Hash = e
}(window.Zepto || window.jQuery, window, document), function (a, b, c, d) {
    function e(b, c) {
        var e = !1, f = b.charAt(0).toUpperCase() + b.slice(1);
        return a.each((b + " " + h.join(f + " ") + f).split(" "), function (a, b) {
            if (g[b] !== d) return e = !c || b, !1
        }), e
    }

    function f(a) {
        return e(a, !0)
    }

    var g = a("<support>").get(0).style, h = "Webkit Moz O ms".split(" "), i = {
        transition: {
            end: {
                WebkitTransition: "webkitTransitionEnd",
                MozTransition: "transitionend",
                OTransition: "oTransitionEnd",
                transition: "transitionend"
            }
        },
        animation: {
            end: {
                WebkitAnimation: "webkitAnimationEnd",
                MozAnimation: "animationend",
                OAnimation: "oAnimationEnd",
                animation: "animationend"
            }
        }
    }, j = {
        csstransforms: function () {
            return !!e("transform")
        }, csstransforms3d: function () {
            return !!e("perspective")
        }, csstransitions: function () {
            return !!e("transition")
        }, cssanimations: function () {
            return !!e("animation")
        }
    };
    j.csstransitions() && (a.support.transition = String(f("transition")), a.support.transition.end = i.transition.end[a.support.transition]), j.cssanimations() && (a.support.animation = String(f("animation")), a.support.animation.end = i.animation.end[a.support.animation]), j.csstransforms() && (a.support.transform = String(f("transform")), a.support.transform3d = j.csstransforms3d())
}(window.Zepto || window.jQuery, window, document);


/*------------------------------------------------------------------*/
/*	01) TWEENMAX
/*------------------------------------------------------------------*/

var _gsScope="undefined"!=typeof module&&module.exports&&"undefined"!=typeof global?global:this||window;(_gsScope._gsQueue||(_gsScope._gsQueue=[])).push(function(){"use strict";_gsScope._gsDefine("TweenMax",["core.Animation","core.SimpleTimeline","TweenLite"],function(a,b,c){var d=function(a){var b,c=[],d=a.length;for(b=0;b!==d;c.push(a[b++]));return c},e=function(a,b,c){var d,e,f=a.cycle;for(d in f)e=f[d],a[d]="function"==typeof e?e(c,b[c]):e[c%e.length];delete a.cycle},f=function(a,b,d){c.call(this,a,b,d),this._cycle=0,this._yoyo=this.vars.yoyo===!0||!!this.vars.yoyoEase,this._repeat=this.vars.repeat||0,this._repeatDelay=this.vars.repeatDelay||0,this._repeat&&this._uncache(!0),this.render=f.prototype.render},g=1e-10,h=c._internals,i=h.isSelector,j=h.isArray,k=f.prototype=c.to({},.1,{}),l=[];f.version="1.20.3",k.constructor=f,k.kill()._gc=!1,f.killTweensOf=f.killDelayedCallsTo=c.killTweensOf,f.getTweensOf=c.getTweensOf,f.lagSmoothing=c.lagSmoothing,f.ticker=c.ticker,f.render=c.render,k.invalidate=function(){return this._yoyo=this.vars.yoyo===!0||!!this.vars.yoyoEase,this._repeat=this.vars.repeat||0,this._repeatDelay=this.vars.repeatDelay||0,this._yoyoEase=null,this._uncache(!0),c.prototype.invalidate.call(this)},k.updateTo=function(a,b){var d,e=this.ratio,f=this.vars.immediateRender||a.immediateRender;b&&this._startTime<this._timeline._time&&(this._startTime=this._timeline._time,this._uncache(!1),this._gc?this._enabled(!0,!1):this._timeline.insert(this,this._startTime-this._delay));for(d in a)this.vars[d]=a[d];if(this._initted||f)if(b)this._initted=!1,f&&this.render(0,!0,!0);else if(this._gc&&this._enabled(!0,!1),this._notifyPluginsOfEnabled&&this._firstPT&&c._onPluginEvent("_onDisable",this),this._time/this._duration>.998){var g=this._totalTime;this.render(0,!0,!1),this._initted=!1,this.render(g,!0,!1)}else if(this._initted=!1,this._init(),this._time>0||f)for(var h,i=1/(1-e),j=this._firstPT;j;)h=j.s+j.c,j.c*=i,j.s=h-j.c,j=j._next;return this},k.render=function(a,b,d){this._initted||0===this._duration&&this.vars.repeat&&this.invalidate();var e,f,i,j,k,l,m,n,o,p=this._dirty?this.totalDuration():this._totalDuration,q=this._time,r=this._totalTime,s=this._cycle,t=this._duration,u=this._rawPrevTime;if(a>=p-1e-7&&a>=0?(this._totalTime=p,this._cycle=this._repeat,this._yoyo&&0!==(1&this._cycle)?(this._time=0,this.ratio=this._ease._calcEnd?this._ease.getRatio(0):0):(this._time=t,this.ratio=this._ease._calcEnd?this._ease.getRatio(1):1),this._reversed||(e=!0,f="onComplete",d=d||this._timeline.autoRemoveChildren),0===t&&(this._initted||!this.vars.lazy||d)&&(this._startTime===this._timeline._duration&&(a=0),(0>u||0>=a&&a>=-1e-7||u===g&&"isPause"!==this.data)&&u!==a&&(d=!0,u>g&&(f="onReverseComplete")),this._rawPrevTime=n=!b||a||u===a?a:g)):1e-7>a?(this._totalTime=this._time=this._cycle=0,this.ratio=this._ease._calcEnd?this._ease.getRatio(0):0,(0!==r||0===t&&u>0)&&(f="onReverseComplete",e=this._reversed),0>a&&(this._active=!1,0===t&&(this._initted||!this.vars.lazy||d)&&(u>=0&&(d=!0),this._rawPrevTime=n=!b||a||u===a?a:g)),this._initted||(d=!0)):(this._totalTime=this._time=a,0!==this._repeat&&(j=t+this._repeatDelay,this._cycle=this._totalTime/j>>0,0!==this._cycle&&this._cycle===this._totalTime/j&&a>=r&&this._cycle--,this._time=this._totalTime-this._cycle*j,this._yoyo&&0!==(1&this._cycle)&&(this._time=t-this._time,o=this._yoyoEase||this.vars.yoyoEase,o&&(this._yoyoEase||(o!==!0||this._initted?this._yoyoEase=o=o===!0?this._ease:o instanceof Ease?o:Ease.map[o]:(o=this.vars.ease,this._yoyoEase=o=o?o instanceof Ease?o:"function"==typeof o?new Ease(o,this.vars.easeParams):Ease.map[o]||c.defaultEase:c.defaultEase)),this.ratio=o?1-o.getRatio((t-this._time)/t):0)),this._time>t?this._time=t:this._time<0&&(this._time=0)),this._easeType&&!o?(k=this._time/t,l=this._easeType,m=this._easePower,(1===l||3===l&&k>=.5)&&(k=1-k),3===l&&(k*=2),1===m?k*=k:2===m?k*=k*k:3===m?k*=k*k*k:4===m&&(k*=k*k*k*k),1===l?this.ratio=1-k:2===l?this.ratio=k:this._time/t<.5?this.ratio=k/2:this.ratio=1-k/2):o||(this.ratio=this._ease.getRatio(this._time/t))),q===this._time&&!d&&s===this._cycle)return void(r!==this._totalTime&&this._onUpdate&&(b||this._callback("onUpdate")));if(!this._initted){if(this._init(),!this._initted||this._gc)return;if(!d&&this._firstPT&&(this.vars.lazy!==!1&&this._duration||this.vars.lazy&&!this._duration))return this._time=q,this._totalTime=r,this._rawPrevTime=u,this._cycle=s,h.lazyTweens.push(this),void(this._lazy=[a,b]);!this._time||e||o?e&&this._ease._calcEnd&&!o&&(this.ratio=this._ease.getRatio(0===this._time?0:1)):this.ratio=this._ease.getRatio(this._time/t)}for(this._lazy!==!1&&(this._lazy=!1),this._active||!this._paused&&this._time!==q&&a>=0&&(this._active=!0),0===r&&(2===this._initted&&a>0&&this._init(),this._startAt&&(a>=0?this._startAt.render(a,!0,d):f||(f="_dummyGS")),this.vars.onStart&&(0!==this._totalTime||0===t)&&(b||this._callback("onStart"))),i=this._firstPT;i;)i.f?i.t[i.p](i.c*this.ratio+i.s):i.t[i.p]=i.c*this.ratio+i.s,i=i._next;this._onUpdate&&(0>a&&this._startAt&&this._startTime&&this._startAt.render(a,!0,d),b||(this._totalTime!==r||f)&&this._callback("onUpdate")),this._cycle!==s&&(b||this._gc||this.vars.onRepeat&&this._callback("onRepeat")),f&&(!this._gc||d)&&(0>a&&this._startAt&&!this._onUpdate&&this._startTime&&this._startAt.render(a,!0,d),e&&(this._timeline.autoRemoveChildren&&this._enabled(!1,!1),this._active=!1),!b&&this.vars[f]&&this._callback(f),0===t&&this._rawPrevTime===g&&n!==g&&(this._rawPrevTime=0))},f.to=function(a,b,c){return new f(a,b,c)},f.from=function(a,b,c){return c.runBackwards=!0,c.immediateRender=0!=c.immediateRender,new f(a,b,c)},f.fromTo=function(a,b,c,d){return d.startAt=c,d.immediateRender=0!=d.immediateRender&&0!=c.immediateRender,new f(a,b,d)},f.staggerTo=f.allTo=function(a,b,g,h,k,m,n){h=h||0;var o,p,q,r,s=0,t=[],u=function(){g.onComplete&&g.onComplete.apply(g.onCompleteScope||this,arguments),k.apply(n||g.callbackScope||this,m||l)},v=g.cycle,w=g.startAt&&g.startAt.cycle;for(j(a)||("string"==typeof a&&(a=c.selector(a)||a),i(a)&&(a=d(a))),a=a||[],0>h&&(a=d(a),a.reverse(),h*=-1),o=a.length-1,q=0;o>=q;q++){p={};for(r in g)p[r]=g[r];if(v&&(e(p,a,q),null!=p.duration&&(b=p.duration,delete p.duration)),w){w=p.startAt={};for(r in g.startAt)w[r]=g.startAt[r];e(p.startAt,a,q)}p.delay=s+(p.delay||0),q===o&&k&&(p.onComplete=u),t[q]=new f(a[q],b,p),s+=h}return t},f.staggerFrom=f.allFrom=function(a,b,c,d,e,g,h){return c.runBackwards=!0,c.immediateRender=0!=c.immediateRender,f.staggerTo(a,b,c,d,e,g,h)},f.staggerFromTo=f.allFromTo=function(a,b,c,d,e,g,h,i){return d.startAt=c,d.immediateRender=0!=d.immediateRender&&0!=c.immediateRender,f.staggerTo(a,b,d,e,g,h,i)},f.delayedCall=function(a,b,c,d,e){return new f(b,0,{delay:a,onComplete:b,onCompleteParams:c,callbackScope:d,onReverseComplete:b,onReverseCompleteParams:c,immediateRender:!1,useFrames:e,overwrite:0})},f.set=function(a,b){return new f(a,0,b)},f.isTweening=function(a){return c.getTweensOf(a,!0).length>0};var m=function(a,b){for(var d=[],e=0,f=a._first;f;)f instanceof c?d[e++]=f:(b&&(d[e++]=f),d=d.concat(m(f,b)),e=d.length),f=f._next;return d},n=f.getAllTweens=function(b){return m(a._rootTimeline,b).concat(m(a._rootFramesTimeline,b))};f.killAll=function(a,c,d,e){null==c&&(c=!0),null==d&&(d=!0);var f,g,h,i=n(0!=e),j=i.length,k=c&&d&&e;for(h=0;j>h;h++)g=i[h],(k||g instanceof b||(f=g.target===g.vars.onComplete)&&d||c&&!f)&&(a?g.totalTime(g._reversed?0:g.totalDuration()):g._enabled(!1,!1))},f.killChildTweensOf=function(a,b){if(null!=a){var e,g,k,l,m,n=h.tweenLookup;if("string"==typeof a&&(a=c.selector(a)||a),i(a)&&(a=d(a)),j(a))for(l=a.length;--l>-1;)f.killChildTweensOf(a[l],b);else{e=[];for(k in n)for(g=n[k].target.parentNode;g;)g===a&&(e=e.concat(n[k].tweens)),g=g.parentNode;for(m=e.length,l=0;m>l;l++)b&&e[l].totalTime(e[l].totalDuration()),e[l]._enabled(!1,!1)}}};var o=function(a,c,d,e){c=c!==!1,d=d!==!1,e=e!==!1;for(var f,g,h=n(e),i=c&&d&&e,j=h.length;--j>-1;)g=h[j],(i||g instanceof b||(f=g.target===g.vars.onComplete)&&d||c&&!f)&&g.paused(a)};return f.pauseAll=function(a,b,c){o(!0,a,b,c)},f.resumeAll=function(a,b,c){o(!1,a,b,c)},f.globalTimeScale=function(b){var d=a._rootTimeline,e=c.ticker.time;return arguments.length?(b=b||g,d._startTime=e-(e-d._startTime)*d._timeScale/b,d=a._rootFramesTimeline,e=c.ticker.frame,d._startTime=e-(e-d._startTime)*d._timeScale/b,d._timeScale=a._rootTimeline._timeScale=b,b):d._timeScale},k.progress=function(a,b){return arguments.length?this.totalTime(this.duration()*(this._yoyo&&0!==(1&this._cycle)?1-a:a)+this._cycle*(this._duration+this._repeatDelay),b):this._time/this.duration()},k.totalProgress=function(a,b){return arguments.length?this.totalTime(this.totalDuration()*a,b):this._totalTime/this.totalDuration()},k.time=function(a,b){return arguments.length?(this._dirty&&this.totalDuration(),a>this._duration&&(a=this._duration),this._yoyo&&0!==(1&this._cycle)?a=this._duration-a+this._cycle*(this._duration+this._repeatDelay):0!==this._repeat&&(a+=this._cycle*(this._duration+this._repeatDelay)),this.totalTime(a,b)):this._time},k.duration=function(b){return arguments.length?a.prototype.duration.call(this,b):this._duration},k.totalDuration=function(a){return arguments.length?-1===this._repeat?this:this.duration((a-this._repeat*this._repeatDelay)/(this._repeat+1)):(this._dirty&&(this._totalDuration=-1===this._repeat?999999999999:this._duration*(this._repeat+1)+this._repeatDelay*this._repeat,this._dirty=!1),this._totalDuration)},k.repeat=function(a){return arguments.length?(this._repeat=a,this._uncache(!0)):this._repeat},k.repeatDelay=function(a){return arguments.length?(this._repeatDelay=a,this._uncache(!0)):this._repeatDelay},k.yoyo=function(a){return arguments.length?(this._yoyo=a,this):this._yoyo},f},!0),_gsScope._gsDefine("TimelineLite",["core.Animation","core.SimpleTimeline","TweenLite"],function(a,b,c){var d=function(a){b.call(this,a),this._labels={},this.autoRemoveChildren=this.vars.autoRemoveChildren===!0,this.smoothChildTiming=this.vars.smoothChildTiming===!0,this._sortChildren=!0,this._onUpdate=this.vars.onUpdate;var c,d,e=this.vars;for(d in e)c=e[d],i(c)&&-1!==c.join("").indexOf("{self}")&&(e[d]=this._swapSelfInParams(c));i(e.tweens)&&this.add(e.tweens,0,e.align,e.stagger)},e=1e-10,f=c._internals,g=d._internals={},h=f.isSelector,i=f.isArray,j=f.lazyTweens,k=f.lazyRender,l=_gsScope._gsDefine.globals,m=function(a){var b,c={};for(b in a)c[b]=a[b];return c},n=function(a,b,c){var d,e,f=a.cycle;for(d in f)e=f[d],a[d]="function"==typeof e?e(c,b[c]):e[c%e.length];delete a.cycle},o=g.pauseCallback=function(){},p=function(a){var b,c=[],d=a.length;for(b=0;b!==d;c.push(a[b++]));return c},q=d.prototype=new b;return d.version="1.20.3",q.constructor=d,q.kill()._gc=q._forcingPlayhead=q._hasPause=!1,q.to=function(a,b,d,e){var f=d.repeat&&l.TweenMax||c;return b?this.add(new f(a,b,d),e):this.set(a,d,e)},q.from=function(a,b,d,e){return this.add((d.repeat&&l.TweenMax||c).from(a,b,d),e)},q.fromTo=function(a,b,d,e,f){var g=e.repeat&&l.TweenMax||c;return b?this.add(g.fromTo(a,b,d,e),f):this.set(a,e,f)},q.staggerTo=function(a,b,e,f,g,i,j,k){var l,o,q=new d({onComplete:i,onCompleteParams:j,callbackScope:k,smoothChildTiming:this.smoothChildTiming}),r=e.cycle;for("string"==typeof a&&(a=c.selector(a)||a),a=a||[],h(a)&&(a=p(a)),f=f||0,0>f&&(a=p(a),a.reverse(),f*=-1),o=0;o<a.length;o++)l=m(e),l.startAt&&(l.startAt=m(l.startAt),l.startAt.cycle&&n(l.startAt,a,o)),r&&(n(l,a,o),null!=l.duration&&(b=l.duration,delete l.duration)),q.to(a[o],b,l,o*f);return this.add(q,g)},q.staggerFrom=function(a,b,c,d,e,f,g,h){return c.immediateRender=0!=c.immediateRender,c.runBackwards=!0,this.staggerTo(a,b,c,d,e,f,g,h)},q.staggerFromTo=function(a,b,c,d,e,f,g,h,i){return d.startAt=c,d.immediateRender=0!=d.immediateRender&&0!=c.immediateRender,this.staggerTo(a,b,d,e,f,g,h,i)},q.call=function(a,b,d,e){return this.add(c.delayedCall(0,a,b,d),e)},q.set=function(a,b,d){return d=this._parseTimeOrLabel(d,0,!0),null==b.immediateRender&&(b.immediateRender=d===this._time&&!this._paused),this.add(new c(a,0,b),d)},d.exportRoot=function(a,b){a=a||{},null==a.smoothChildTiming&&(a.smoothChildTiming=!0);var e,f,g,h,i=new d(a),j=i._timeline;for(null==b&&(b=!0),j._remove(i,!0),i._startTime=0,i._rawPrevTime=i._time=i._totalTime=j._time,g=j._first;g;)h=g._next,b&&g instanceof c&&g.target===g.vars.onComplete||(f=g._startTime-g._delay,0>f&&(e=1),i.add(g,f)),g=h;return j.add(i,0),e&&i.totalDuration(),i},q.add=function(e,f,g,h){var j,k,l,m,n,o;if("number"!=typeof f&&(f=this._parseTimeOrLabel(f,0,!0,e)),!(e instanceof a)){if(e instanceof Array||e&&e.push&&i(e)){for(g=g||"normal",h=h||0,j=f,k=e.length,l=0;k>l;l++)i(m=e[l])&&(m=new d({tweens:m})),this.add(m,j),"string"!=typeof m&&"function"!=typeof m&&("sequence"===g?j=m._startTime+m.totalDuration()/m._timeScale:"start"===g&&(m._startTime-=m.delay())),j+=h;return this._uncache(!0)}if("string"==typeof e)return this.addLabel(e,f);if("function"!=typeof e)throw"Cannot add "+e+" into the timeline; it is not a tween, timeline, function, or string.";e=c.delayedCall(0,e)}if(b.prototype.add.call(this,e,f),e._time&&e.render((this.rawTime()-e._startTime)*e._timeScale,!1,!1),(this._gc||this._time===this._duration)&&!this._paused&&this._duration<this.duration())for(n=this,o=n.rawTime()>e._startTime;n._timeline;)o&&n._timeline.smoothChildTiming?n.totalTime(n._totalTime,!0):n._gc&&n._enabled(!0,!1),n=n._timeline;return this},q.remove=function(b){if(b instanceof a){this._remove(b,!1);var c=b._timeline=b.vars.useFrames?a._rootFramesTimeline:a._rootTimeline;return b._startTime=(b._paused?b._pauseTime:c._time)-(b._reversed?b.totalDuration()-b._totalTime:b._totalTime)/b._timeScale,this}if(b instanceof Array||b&&b.push&&i(b)){for(var d=b.length;--d>-1;)this.remove(b[d]);return this}return"string"==typeof b?this.removeLabel(b):this.kill(null,b)},q._remove=function(a,c){b.prototype._remove.call(this,a,c);var d=this._last;return d?this._time>this.duration()&&(this._time=this._duration,this._totalTime=this._totalDuration):this._time=this._totalTime=this._duration=this._totalDuration=0,this},q.append=function(a,b){return this.add(a,this._parseTimeOrLabel(null,b,!0,a))},q.insert=q.insertMultiple=function(a,b,c,d){return this.add(a,b||0,c,d)},q.appendMultiple=function(a,b,c,d){return this.add(a,this._parseTimeOrLabel(null,b,!0,a),c,d)},q.addLabel=function(a,b){return this._labels[a]=this._parseTimeOrLabel(b),this},q.addPause=function(a,b,d,e){var f=c.delayedCall(0,o,d,e||this);return f.vars.onComplete=f.vars.onReverseComplete=b,f.data="isPause",this._hasPause=!0,this.add(f,a)},q.removeLabel=function(a){return delete this._labels[a],this},q.getLabelTime=function(a){return null!=this._labels[a]?this._labels[a]:-1},q._parseTimeOrLabel=function(b,c,d,e){var f,g;if(e instanceof a&&e.timeline===this)this.remove(e);else if(e&&(e instanceof Array||e.push&&i(e)))for(g=e.length;--g>-1;)e[g]instanceof a&&e[g].timeline===this&&this.remove(e[g]);if(f="number"!=typeof b||c?this.duration()>99999999999?this.recent().endTime(!1):this._duration:0,"string"==typeof c)return this._parseTimeOrLabel(c,d&&"number"==typeof b&&null==this._labels[c]?b-f:0,d);if(c=c||0,"string"!=typeof b||!isNaN(b)&&null==this._labels[b])null==b&&(b=f);else{if(g=b.indexOf("="),-1===g)return null==this._labels[b]?d?this._labels[b]=f+c:c:this._labels[b]+c;c=parseInt(b.charAt(g-1)+"1",10)*Number(b.substr(g+1)),b=g>1?this._parseTimeOrLabel(b.substr(0,g-1),0,d):f}return Number(b)+c},q.seek=function(a,b){return this.totalTime("number"==typeof a?a:this._parseTimeOrLabel(a),b!==!1)},q.stop=function(){return this.paused(!0)},q.gotoAndPlay=function(a,b){return this.play(a,b)},q.gotoAndStop=function(a,b){return this.pause(a,b)},q.render=function(a,b,c){this._gc&&this._enabled(!0,!1);var d,f,g,h,i,l,m,n=this._time,o=this._dirty?this.totalDuration():this._totalDuration,p=this._startTime,q=this._timeScale,r=this._paused;if(n!==this._time&&(a+=this._time-n),a>=o-1e-7&&a>=0)this._totalTime=this._time=o,this._reversed||this._hasPausedChild()||(f=!0,h="onComplete",i=!!this._timeline.autoRemoveChildren,0===this._duration&&(0>=a&&a>=-1e-7||this._rawPrevTime<0||this._rawPrevTime===e)&&this._rawPrevTime!==a&&this._first&&(i=!0,this._rawPrevTime>e&&(h="onReverseComplete"))),this._rawPrevTime=this._duration||!b||a||this._rawPrevTime===a?a:e,a=o+1e-4;else if(1e-7>a)if(this._totalTime=this._time=0,(0!==n||0===this._duration&&this._rawPrevTime!==e&&(this._rawPrevTime>0||0>a&&this._rawPrevTime>=0))&&(h="onReverseComplete",f=this._reversed),0>a)this._active=!1,this._timeline.autoRemoveChildren&&this._reversed?(i=f=!0,h="onReverseComplete"):this._rawPrevTime>=0&&this._first&&(i=!0),this._rawPrevTime=a;else{if(this._rawPrevTime=this._duration||!b||a||this._rawPrevTime===a?a:e,0===a&&f)for(d=this._first;d&&0===d._startTime;)d._duration||(f=!1),d=d._next;a=0,this._initted||(i=!0)}else{if(this._hasPause&&!this._forcingPlayhead&&!b){if(a>=n)for(d=this._first;d&&d._startTime<=a&&!l;)d._duration||"isPause"!==d.data||d.ratio||0===d._startTime&&0===this._rawPrevTime||(l=d),d=d._next;else for(d=this._last;d&&d._startTime>=a&&!l;)d._duration||"isPause"===d.data&&d._rawPrevTime>0&&(l=d),d=d._prev;l&&(this._time=a=l._startTime,this._totalTime=a+this._cycle*(this._totalDuration+this._repeatDelay))}this._totalTime=this._time=this._rawPrevTime=a}if(this._time!==n&&this._first||c||i||l){if(this._initted||(this._initted=!0),this._active||!this._paused&&this._time!==n&&a>0&&(this._active=!0),0===n&&this.vars.onStart&&(0===this._time&&this._duration||b||this._callback("onStart")),m=this._time,m>=n)for(d=this._first;d&&(g=d._next,m===this._time&&(!this._paused||r));)(d._active||d._startTime<=m&&!d._paused&&!d._gc)&&(l===d&&this.pause(),d._reversed?d.render((d._dirty?d.totalDuration():d._totalDuration)-(a-d._startTime)*d._timeScale,b,c):d.render((a-d._startTime)*d._timeScale,b,c)),d=g;else for(d=this._last;d&&(g=d._prev,m===this._time&&(!this._paused||r));){if(d._active||d._startTime<=n&&!d._paused&&!d._gc){if(l===d){for(l=d._prev;l&&l.endTime()>this._time;)l.render(l._reversed?l.totalDuration()-(a-l._startTime)*l._timeScale:(a-l._startTime)*l._timeScale,b,c),l=l._prev;l=null,this.pause()}d._reversed?d.render((d._dirty?d.totalDuration():d._totalDuration)-(a-d._startTime)*d._timeScale,b,c):d.render((a-d._startTime)*d._timeScale,b,c)}d=g}this._onUpdate&&(b||(j.length&&k(),this._callback("onUpdate"))),h&&(this._gc||(p===this._startTime||q!==this._timeScale)&&(0===this._time||o>=this.totalDuration())&&(f&&(j.length&&k(),this._timeline.autoRemoveChildren&&this._enabled(!1,!1),this._active=!1),!b&&this.vars[h]&&this._callback(h)))}},q._hasPausedChild=function(){for(var a=this._first;a;){if(a._paused||a instanceof d&&a._hasPausedChild())return!0;a=a._next}return!1},q.getChildren=function(a,b,d,e){e=e||-9999999999;for(var f=[],g=this._first,h=0;g;)g._startTime<e||(g instanceof c?b!==!1&&(f[h++]=g):(d!==!1&&(f[h++]=g),a!==!1&&(f=f.concat(g.getChildren(!0,b,d)),h=f.length))),g=g._next;return f},q.getTweensOf=function(a,b){var d,e,f=this._gc,g=[],h=0;for(f&&this._enabled(!0,!0),d=c.getTweensOf(a),e=d.length;--e>-1;)(d[e].timeline===this||b&&this._contains(d[e]))&&(g[h++]=d[e]);return f&&this._enabled(!1,!0),g},q.recent=function(){return this._recent},q._contains=function(a){for(var b=a.timeline;b;){if(b===this)return!0;b=b.timeline}return!1},q.shiftChildren=function(a,b,c){c=c||0;for(var d,e=this._first,f=this._labels;e;)e._startTime>=c&&(e._startTime+=a),e=e._next;if(b)for(d in f)f[d]>=c&&(f[d]+=a);return this._uncache(!0)},q._kill=function(a,b){if(!a&&!b)return this._enabled(!1,!1);for(var c=b?this.getTweensOf(b):this.getChildren(!0,!0,!1),d=c.length,e=!1;--d>-1;)c[d]._kill(a,b)&&(e=!0);return e},q.clear=function(a){var b=this.getChildren(!1,!0,!0),c=b.length;for(this._time=this._totalTime=0;--c>-1;)b[c]._enabled(!1,!1);return a!==!1&&(this._labels={}),this._uncache(!0)},q.invalidate=function(){for(var b=this._first;b;)b.invalidate(),b=b._next;return a.prototype.invalidate.call(this)},q._enabled=function(a,c){if(a===this._gc)for(var d=this._first;d;)d._enabled(a,!0),d=d._next;return b.prototype._enabled.call(this,a,c)},q.totalTime=function(b,c,d){this._forcingPlayhead=!0;var e=a.prototype.totalTime.apply(this,arguments);return this._forcingPlayhead=!1,e},q.duration=function(a){return arguments.length?(0!==this.duration()&&0!==a&&this.timeScale(this._duration/a),this):(this._dirty&&this.totalDuration(),this._duration)},q.totalDuration=function(a){if(!arguments.length){if(this._dirty){for(var b,c,d=0,e=this._last,f=999999999999;e;)b=e._prev,e._dirty&&e.totalDuration(),e._startTime>f&&this._sortChildren&&!e._paused&&!this._calculatingDuration?(this._calculatingDuration=1,this.add(e,e._startTime-e._delay),this._calculatingDuration=0):f=e._startTime,e._startTime<0&&!e._paused&&(d-=e._startTime,this._timeline.smoothChildTiming&&(this._startTime+=e._startTime/this._timeScale,this._time-=e._startTime,this._totalTime-=e._startTime,this._rawPrevTime-=e._startTime),this.shiftChildren(-e._startTime,!1,-9999999999),f=0),c=e._startTime+e._totalDuration/e._timeScale,c>d&&(d=c),e=b;this._duration=this._totalDuration=d,this._dirty=!1}return this._totalDuration}return a&&this.totalDuration()?this.timeScale(this._totalDuration/a):this},q.paused=function(b){if(!b)for(var c=this._first,d=this._time;c;)c._startTime===d&&"isPause"===c.data&&(c._rawPrevTime=0),c=c._next;return a.prototype.paused.apply(this,arguments)},q.usesFrames=function(){for(var b=this._timeline;b._timeline;)b=b._timeline;return b===a._rootFramesTimeline},q.rawTime=function(a){return a&&(this._paused||this._repeat&&this.time()>0&&this.totalProgress()<1)?this._totalTime%(this._duration+this._repeatDelay):this._paused?this._totalTime:(this._timeline.rawTime(a)-this._startTime)*this._timeScale},d},!0),_gsScope._gsDefine("TimelineMax",["TimelineLite","TweenLite","easing.Ease"],function(a,b,c){var d=function(b){a.call(this,b),this._repeat=this.vars.repeat||0,this._repeatDelay=this.vars.repeatDelay||0,this._cycle=0,this._yoyo=this.vars.yoyo===!0,this._dirty=!0},e=1e-10,f=b._internals,g=f.lazyTweens,h=f.lazyRender,i=_gsScope._gsDefine.globals,j=new c(null,null,1,0),k=d.prototype=new a;return k.constructor=d,k.kill()._gc=!1,d.version="1.20.3",k.invalidate=function(){return this._yoyo=this.vars.yoyo===!0,this._repeat=this.vars.repeat||0,this._repeatDelay=this.vars.repeatDelay||0,this._uncache(!0),a.prototype.invalidate.call(this)},k.addCallback=function(a,c,d,e){return this.add(b.delayedCall(0,a,d,e),c)},k.removeCallback=function(a,b){if(a)if(null==b)this._kill(null,a);else for(var c=this.getTweensOf(a,!1),d=c.length,e=this._parseTimeOrLabel(b);--d>-1;)c[d]._startTime===e&&c[d]._enabled(!1,!1);return this},k.removePause=function(b){return this.removeCallback(a._internals.pauseCallback,b)},k.tweenTo=function(a,c){c=c||{};var d,e,f,g={ease:j,useFrames:this.usesFrames(),immediateRender:!1},h=c.repeat&&i.TweenMax||b;for(e in c)g[e]=c[e];return g.time=this._parseTimeOrLabel(a),d=Math.abs(Number(g.time)-this._time)/this._timeScale||.001,f=new h(this,d,g),g.onStart=function(){f.target.paused(!0),f.vars.time!==f.target.time()&&d===f.duration()&&f.duration(Math.abs(f.vars.time-f.target.time())/f.target._timeScale),c.onStart&&c.onStart.apply(c.onStartScope||c.callbackScope||f,c.onStartParams||[])},f},k.tweenFromTo=function(a,b,c){c=c||{},a=this._parseTimeOrLabel(a),c.startAt={onComplete:this.seek,onCompleteParams:[a],callbackScope:this},c.immediateRender=c.immediateRender!==!1;var d=this.tweenTo(b,c);return d.duration(Math.abs(d.vars.time-a)/this._timeScale||.001)},k.render=function(a,b,c){this._gc&&this._enabled(!0,!1);var d,f,i,j,k,l,m,n,o=this._time,p=this._dirty?this.totalDuration():this._totalDuration,q=this._duration,r=this._totalTime,s=this._startTime,t=this._timeScale,u=this._rawPrevTime,v=this._paused,w=this._cycle;if(o!==this._time&&(a+=this._time-o),a>=p-1e-7&&a>=0)this._locked||(this._totalTime=p,this._cycle=this._repeat),this._reversed||this._hasPausedChild()||(f=!0,j="onComplete",k=!!this._timeline.autoRemoveChildren,0===this._duration&&(0>=a&&a>=-1e-7||0>u||u===e)&&u!==a&&this._first&&(k=!0,u>e&&(j="onReverseComplete"))),this._rawPrevTime=this._duration||!b||a||this._rawPrevTime===a?a:e,this._yoyo&&0!==(1&this._cycle)?this._time=a=0:(this._time=q,a=q+1e-4);else if(1e-7>a)if(this._locked||(this._totalTime=this._cycle=0),this._time=0,(0!==o||0===q&&u!==e&&(u>0||0>a&&u>=0)&&!this._locked)&&(j="onReverseComplete",f=this._reversed),0>a)this._active=!1,this._timeline.autoRemoveChildren&&this._reversed?(k=f=!0,j="onReverseComplete"):u>=0&&this._first&&(k=!0),this._rawPrevTime=a;else{if(this._rawPrevTime=q||!b||a||this._rawPrevTime===a?a:e,0===a&&f)for(d=this._first;d&&0===d._startTime;)d._duration||(f=!1),d=d._next;a=0,this._initted||(k=!0)}else if(0===q&&0>u&&(k=!0),this._time=this._rawPrevTime=a,this._locked||(this._totalTime=a,0!==this._repeat&&(l=q+this._repeatDelay,this._cycle=this._totalTime/l>>0,0!==this._cycle&&this._cycle===this._totalTime/l&&a>=r&&this._cycle--,this._time=this._totalTime-this._cycle*l,this._yoyo&&0!==(1&this._cycle)&&(this._time=q-this._time),this._time>q?(this._time=q,a=q+1e-4):this._time<0?this._time=a=0:a=this._time)),this._hasPause&&!this._forcingPlayhead&&!b){if(a=this._time,a>=o||this._repeat&&w!==this._cycle)for(d=this._first;d&&d._startTime<=a&&!m;)d._duration||"isPause"!==d.data||d.ratio||0===d._startTime&&0===this._rawPrevTime||(m=d),d=d._next;else for(d=this._last;d&&d._startTime>=a&&!m;)d._duration||"isPause"===d.data&&d._rawPrevTime>0&&(m=d),d=d._prev;m&&m._startTime<q&&(this._time=a=m._startTime,this._totalTime=a+this._cycle*(this._totalDuration+this._repeatDelay))}if(this._cycle!==w&&!this._locked){var x=this._yoyo&&0!==(1&w),y=x===(this._yoyo&&0!==(1&this._cycle)),z=this._totalTime,A=this._cycle,B=this._rawPrevTime,C=this._time;if(this._totalTime=w*q,this._cycle<w?x=!x:this._totalTime+=q,this._time=o,this._rawPrevTime=0===q?u-1e-4:u,this._cycle=w,this._locked=!0,o=x?0:q,this.render(o,b,0===q),b||this._gc||this.vars.onRepeat&&(this._cycle=A,this._locked=!1,this._callback("onRepeat")),o!==this._time)return;if(y&&(this._cycle=w,this._locked=!0,o=x?q+1e-4:-1e-4,this.render(o,!0,!1)),this._locked=!1,this._paused&&!v)return;this._time=C,this._totalTime=z,this._cycle=A,this._rawPrevTime=B}if(!(this._time!==o&&this._first||c||k||m))return void(r!==this._totalTime&&this._onUpdate&&(b||this._callback("onUpdate")));if(this._initted||(this._initted=!0),this._active||!this._paused&&this._totalTime!==r&&a>0&&(this._active=!0),0===r&&this.vars.onStart&&(0===this._totalTime&&this._totalDuration||b||this._callback("onStart")),n=this._time,n>=o)for(d=this._first;d&&(i=d._next,n===this._time&&(!this._paused||v));)(d._active||d._startTime<=this._time&&!d._paused&&!d._gc)&&(m===d&&this.pause(),d._reversed?d.render((d._dirty?d.totalDuration():d._totalDuration)-(a-d._startTime)*d._timeScale,b,c):d.render((a-d._startTime)*d._timeScale,b,c)),d=i;else for(d=this._last;d&&(i=d._prev,n===this._time&&(!this._paused||v));){if(d._active||d._startTime<=o&&!d._paused&&!d._gc){if(m===d){for(m=d._prev;m&&m.endTime()>this._time;)m.render(m._reversed?m.totalDuration()-(a-m._startTime)*m._timeScale:(a-m._startTime)*m._timeScale,b,c),m=m._prev;m=null,this.pause()}d._reversed?d.render((d._dirty?d.totalDuration():d._totalDuration)-(a-d._startTime)*d._timeScale,b,c):d.render((a-d._startTime)*d._timeScale,b,c)}d=i}this._onUpdate&&(b||(g.length&&h(),this._callback("onUpdate"))),j&&(this._locked||this._gc||(s===this._startTime||t!==this._timeScale)&&(0===this._time||p>=this.totalDuration())&&(f&&(g.length&&h(),this._timeline.autoRemoveChildren&&this._enabled(!1,!1),this._active=!1),!b&&this.vars[j]&&this._callback(j)))},k.getActive=function(a,b,c){null==a&&(a=!0),null==b&&(b=!0),null==c&&(c=!1);var d,e,f=[],g=this.getChildren(a,b,c),h=0,i=g.length;for(d=0;i>d;d++)e=g[d],e.isActive()&&(f[h++]=e);return f},k.getLabelAfter=function(a){a||0!==a&&(a=this._time);var b,c=this.getLabelsArray(),d=c.length;for(b=0;d>b;b++)if(c[b].time>a)return c[b].name;return null},k.getLabelBefore=function(a){null==a&&(a=this._time);for(var b=this.getLabelsArray(),c=b.length;--c>-1;)if(b[c].time<a)return b[c].name;return null},k.getLabelsArray=function(){var a,b=[],c=0;for(a in this._labels)b[c++]={time:this._labels[a],name:a};return b.sort(function(a,b){return a.time-b.time}),b},k.invalidate=function(){return this._locked=!1,a.prototype.invalidate.call(this)},k.progress=function(a,b){return arguments.length?this.totalTime(this.duration()*(this._yoyo&&0!==(1&this._cycle)?1-a:a)+this._cycle*(this._duration+this._repeatDelay),b):this._time/this.duration()||0},k.totalProgress=function(a,b){return arguments.length?this.totalTime(this.totalDuration()*a,b):this._totalTime/this.totalDuration()||0},k.totalDuration=function(b){return arguments.length?-1!==this._repeat&&b?this.timeScale(this.totalDuration()/b):this:(this._dirty&&(a.prototype.totalDuration.call(this),this._totalDuration=-1===this._repeat?999999999999:this._duration*(this._repeat+1)+this._repeatDelay*this._repeat),this._totalDuration)},k.time=function(a,b){return arguments.length?(this._dirty&&this.totalDuration(),a>this._duration&&(a=this._duration),this._yoyo&&0!==(1&this._cycle)?a=this._duration-a+this._cycle*(this._duration+this._repeatDelay):0!==this._repeat&&(a+=this._cycle*(this._duration+this._repeatDelay)),this.totalTime(a,b)):this._time},k.repeat=function(a){return arguments.length?(this._repeat=a,this._uncache(!0)):this._repeat},k.repeatDelay=function(a){return arguments.length?(this._repeatDelay=a,this._uncache(!0)):this._repeatDelay},k.yoyo=function(a){return arguments.length?(this._yoyo=a,this):this._yoyo},k.currentLabel=function(a){return arguments.length?this.seek(a,!0):this.getLabelBefore(this._time+1e-8)},d},!0),function(){var a=180/Math.PI,b=[],c=[],d=[],e={},f=_gsScope._gsDefine.globals,g=function(a,b,c,d){c===d&&(c=d-(d-b)/1e6),a===b&&(b=a+(c-a)/1e6),this.a=a,this.b=b,this.c=c,this.d=d,this.da=d-a,this.ca=c-a,this.ba=b-a},h=",x,y,z,left,top,right,bottom,marginTop,marginLeft,marginRight,marginBottom,paddingLeft,paddingTop,paddingRight,paddingBottom,backgroundPosition,backgroundPosition_y,",i=function(a,b,c,d){var e={a:a},f={},g={},h={c:d},i=(a+b)/2,j=(b+c)/2,k=(c+d)/2,l=(i+j)/2,m=(j+k)/2,n=(m-l)/8;return e.b=i+(a-i)/4,f.b=l+n,e.c=f.a=(e.b+f.b)/2,f.c=g.a=(l+m)/2,g.b=m-n,h.b=k+(d-k)/4,g.c=h.a=(g.b+h.b)/2,[e,f,g,h]},j=function(a,e,f,g,h){var j,k,l,m,n,o,p,q,r,s,t,u,v,w=a.length-1,x=0,y=a[0].a;for(j=0;w>j;j++)n=a[x],k=n.a,l=n.d,m=a[x+1].d,h?(t=b[j],u=c[j],v=(u+t)*e*.25/(g?.5:d[j]||.5),o=l-(l-k)*(g?.5*e:0!==t?v/t:0),p=l+(m-l)*(g?.5*e:0!==u?v/u:0),q=l-(o+((p-o)*(3*t/(t+u)+.5)/4||0))):(o=l-(l-k)*e*.5,p=l+(m-l)*e*.5,q=l-(o+p)/2),o+=q,p+=q,n.c=r=o,0!==j?n.b=y:n.b=y=n.a+.6*(n.c-n.a),n.da=l-k,n.ca=r-k,n.ba=y-k,f?(s=i(k,y,r,l),a.splice(x,1,s[0],s[1],s[2],s[3]),x+=4):x++,y=p;n=a[x],n.b=y,n.c=y+.4*(n.d-y),n.da=n.d-n.a,n.ca=n.c-n.a,n.ba=y-n.a,f&&(s=i(n.a,y,n.c,n.d),a.splice(x,1,s[0],s[1],s[2],s[3]))},k=function(a,d,e,f){var h,i,j,k,l,m,n=[];if(f)for(a=[f].concat(a),i=a.length;--i>-1;)"string"==typeof(m=a[i][d])&&"="===m.charAt(1)&&(a[i][d]=f[d]+Number(m.charAt(0)+m.substr(2)));if(h=a.length-2,0>h)return n[0]=new g(a[0][d],0,0,a[0][d]),n;for(i=0;h>i;i++)j=a[i][d],k=a[i+1][d],n[i]=new g(j,0,0,k),e&&(l=a[i+2][d],b[i]=(b[i]||0)+(k-j)*(k-j),c[i]=(c[i]||0)+(l-k)*(l-k));return n[i]=new g(a[i][d],0,0,a[i+1][d]),n},l=function(a,f,g,i,l,m){var n,o,p,q,r,s,t,u,v={},w=[],x=m||a[0];l="string"==typeof l?","+l+",":h,null==f&&(f=1);for(o in a[0])w.push(o);if(a.length>1){for(u=a[a.length-1],t=!0,n=w.length;--n>-1;)if(o=w[n],Math.abs(x[o]-u[o])>.05){t=!1;break}t&&(a=a.concat(),m&&a.unshift(m),a.push(a[1]),m=a[a.length-3])}for(b.length=c.length=d.length=0,n=w.length;--n>-1;)o=w[n],e[o]=-1!==l.indexOf(","+o+","),v[o]=k(a,o,e[o],m);for(n=b.length;--n>-1;)b[n]=Math.sqrt(b[n]),c[n]=Math.sqrt(c[n]);if(!i){for(n=w.length;--n>-1;)if(e[o])for(p=v[w[n]],s=p.length-1,q=0;s>q;q++)r=p[q+1].da/c[q]+p[q].da/b[q]||0,
d[q]=(d[q]||0)+r*r;for(n=d.length;--n>-1;)d[n]=Math.sqrt(d[n])}for(n=w.length,q=g?4:1;--n>-1;)o=w[n],p=v[o],j(p,f,g,i,e[o]),t&&(p.splice(0,q),p.splice(p.length-q,q));return v},m=function(a,b,c){b=b||"soft";var d,e,f,h,i,j,k,l,m,n,o,p={},q="cubic"===b?3:2,r="soft"===b,s=[];if(r&&c&&(a=[c].concat(a)),null==a||a.length<q+1)throw"invalid Bezier data";for(m in a[0])s.push(m);for(j=s.length;--j>-1;){for(m=s[j],p[m]=i=[],n=0,l=a.length,k=0;l>k;k++)d=null==c?a[k][m]:"string"==typeof(o=a[k][m])&&"="===o.charAt(1)?c[m]+Number(o.charAt(0)+o.substr(2)):Number(o),r&&k>1&&l-1>k&&(i[n++]=(d+i[n-2])/2),i[n++]=d;for(l=n-q+1,n=0,k=0;l>k;k+=q)d=i[k],e=i[k+1],f=i[k+2],h=2===q?0:i[k+3],i[n++]=o=3===q?new g(d,e,f,h):new g(d,(2*e+d)/3,(2*e+f)/3,f);i.length=n}return p},n=function(a,b,c){for(var d,e,f,g,h,i,j,k,l,m,n,o=1/c,p=a.length;--p>-1;)for(m=a[p],f=m.a,g=m.d-f,h=m.c-f,i=m.b-f,d=e=0,k=1;c>=k;k++)j=o*k,l=1-j,d=e-(e=(j*j*g+3*l*(j*h+l*i))*j),n=p*c+k-1,b[n]=(b[n]||0)+d*d},o=function(a,b){b=b>>0||6;var c,d,e,f,g=[],h=[],i=0,j=0,k=b-1,l=[],m=[];for(c in a)n(a[c],g,b);for(e=g.length,d=0;e>d;d++)i+=Math.sqrt(g[d]),f=d%b,m[f]=i,f===k&&(j+=i,f=d/b>>0,l[f]=m,h[f]=j,i=0,m=[]);return{length:j,lengths:h,segments:l}},p=_gsScope._gsDefine.plugin({propName:"bezier",priority:-1,version:"1.3.8",API:2,global:!0,init:function(a,b,c){this._target=a,b instanceof Array&&(b={values:b}),this._func={},this._mod={},this._props=[],this._timeRes=null==b.timeResolution?6:parseInt(b.timeResolution,10);var d,e,f,g,h,i=b.values||[],j={},k=i[0],n=b.autoRotate||c.vars.orientToBezier;this._autoRotate=n?n instanceof Array?n:[["x","y","rotation",n===!0?0:Number(n)||0]]:null;for(d in k)this._props.push(d);for(f=this._props.length;--f>-1;)d=this._props[f],this._overwriteProps.push(d),e=this._func[d]="function"==typeof a[d],j[d]=e?a[d.indexOf("set")||"function"!=typeof a["get"+d.substr(3)]?d:"get"+d.substr(3)]():parseFloat(a[d]),h||j[d]!==i[0][d]&&(h=j);if(this._beziers="cubic"!==b.type&&"quadratic"!==b.type&&"soft"!==b.type?l(i,isNaN(b.curviness)?1:b.curviness,!1,"thruBasic"===b.type,b.correlate,h):m(i,b.type,j),this._segCount=this._beziers[d].length,this._timeRes){var p=o(this._beziers,this._timeRes);this._length=p.length,this._lengths=p.lengths,this._segments=p.segments,this._l1=this._li=this._s1=this._si=0,this._l2=this._lengths[0],this._curSeg=this._segments[0],this._s2=this._curSeg[0],this._prec=1/this._curSeg.length}if(n=this._autoRotate)for(this._initialRotations=[],n[0]instanceof Array||(this._autoRotate=n=[n]),f=n.length;--f>-1;){for(g=0;3>g;g++)d=n[f][g],this._func[d]="function"==typeof a[d]?a[d.indexOf("set")||"function"!=typeof a["get"+d.substr(3)]?d:"get"+d.substr(3)]:!1;d=n[f][2],this._initialRotations[f]=(this._func[d]?this._func[d].call(this._target):this._target[d])||0,this._overwriteProps.push(d)}return this._startRatio=c.vars.runBackwards?1:0,!0},set:function(b){var c,d,e,f,g,h,i,j,k,l,m=this._segCount,n=this._func,o=this._target,p=b!==this._startRatio;if(this._timeRes){if(k=this._lengths,l=this._curSeg,b*=this._length,e=this._li,b>this._l2&&m-1>e){for(j=m-1;j>e&&(this._l2=k[++e])<=b;);this._l1=k[e-1],this._li=e,this._curSeg=l=this._segments[e],this._s2=l[this._s1=this._si=0]}else if(b<this._l1&&e>0){for(;e>0&&(this._l1=k[--e])>=b;);0===e&&b<this._l1?this._l1=0:e++,this._l2=k[e],this._li=e,this._curSeg=l=this._segments[e],this._s1=l[(this._si=l.length-1)-1]||0,this._s2=l[this._si]}if(c=e,b-=this._l1,e=this._si,b>this._s2&&e<l.length-1){for(j=l.length-1;j>e&&(this._s2=l[++e])<=b;);this._s1=l[e-1],this._si=e}else if(b<this._s1&&e>0){for(;e>0&&(this._s1=l[--e])>=b;);0===e&&b<this._s1?this._s1=0:e++,this._s2=l[e],this._si=e}h=(e+(b-this._s1)/(this._s2-this._s1))*this._prec||0}else c=0>b?0:b>=1?m-1:m*b>>0,h=(b-c*(1/m))*m;for(d=1-h,e=this._props.length;--e>-1;)f=this._props[e],g=this._beziers[f][c],i=(h*h*g.da+3*d*(h*g.ca+d*g.ba))*h+g.a,this._mod[f]&&(i=this._mod[f](i,o)),n[f]?o[f](i):o[f]=i;if(this._autoRotate){var q,r,s,t,u,v,w,x=this._autoRotate;for(e=x.length;--e>-1;)f=x[e][2],v=x[e][3]||0,w=x[e][4]===!0?1:a,g=this._beziers[x[e][0]],q=this._beziers[x[e][1]],g&&q&&(g=g[c],q=q[c],r=g.a+(g.b-g.a)*h,t=g.b+(g.c-g.b)*h,r+=(t-r)*h,t+=(g.c+(g.d-g.c)*h-t)*h,s=q.a+(q.b-q.a)*h,u=q.b+(q.c-q.b)*h,s+=(u-s)*h,u+=(q.c+(q.d-q.c)*h-u)*h,i=p?Math.atan2(u-s,t-r)*w+v:this._initialRotations[e],this._mod[f]&&(i=this._mod[f](i,o)),n[f]?o[f](i):o[f]=i)}}}),q=p.prototype;p.bezierThrough=l,p.cubicToQuadratic=i,p._autoCSS=!0,p.quadraticToCubic=function(a,b,c){return new g(a,(2*b+a)/3,(2*b+c)/3,c)},p._cssRegister=function(){var a=f.CSSPlugin;if(a){var b=a._internals,c=b._parseToProxy,d=b._setPluginRatio,e=b.CSSPropTween;b._registerComplexSpecialProp("bezier",{parser:function(a,b,f,g,h,i){b instanceof Array&&(b={values:b}),i=new p;var j,k,l,m=b.values,n=m.length-1,o=[],q={};if(0>n)return h;for(j=0;n>=j;j++)l=c(a,m[j],g,h,i,n!==j),o[j]=l.end;for(k in b)q[k]=b[k];return q.values=o,h=new e(a,"bezier",0,0,l.pt,2),h.data=l,h.plugin=i,h.setRatio=d,0===q.autoRotate&&(q.autoRotate=!0),!q.autoRotate||q.autoRotate instanceof Array||(j=q.autoRotate===!0?0:Number(q.autoRotate),q.autoRotate=null!=l.end.left?[["left","top","rotation",j,!1]]:null!=l.end.x?[["x","y","rotation",j,!1]]:!1),q.autoRotate&&(g._transform||g._enableTransforms(!1),l.autoRotate=g._target._gsTransform,l.proxy.rotation=l.autoRotate.rotation||0,g._overwriteProps.push("rotation")),i._onInitTween(l.proxy,q,g._tween),h}})}},q._mod=function(a){for(var b,c=this._overwriteProps,d=c.length;--d>-1;)b=a[c[d]],b&&"function"==typeof b&&(this._mod[c[d]]=b)},q._kill=function(a){var b,c,d=this._props;for(b in this._beziers)if(b in a)for(delete this._beziers[b],delete this._func[b],c=d.length;--c>-1;)d[c]===b&&d.splice(c,1);if(d=this._autoRotate)for(c=d.length;--c>-1;)a[d[c][2]]&&d.splice(c,1);return this._super._kill.call(this,a)}}(),_gsScope._gsDefine("plugins.CSSPlugin",["plugins.TweenPlugin","TweenLite"],function(a,b){var c,d,e,f,g=function(){a.call(this,"css"),this._overwriteProps.length=0,this.setRatio=g.prototype.setRatio},h=_gsScope._gsDefine.globals,i={},j=g.prototype=new a("css");j.constructor=g,g.version="1.20.3",g.API=2,g.defaultTransformPerspective=0,g.defaultSkewType="compensated",g.defaultSmoothOrigin=!0,j="px",g.suffixMap={top:j,right:j,bottom:j,left:j,width:j,height:j,fontSize:j,padding:j,margin:j,perspective:j,lineHeight:""};var k,l,m,n,o,p,q,r,s=/(?:\-|\.|\b)(\d|\.|e\-)+/g,t=/(?:\d|\-\d|\.\d|\-\.\d|\+=\d|\-=\d|\+=.\d|\-=\.\d)+/g,u=/(?:\+=|\-=|\-|\b)[\d\-\.]+[a-zA-Z0-9]*(?:%|\b)/gi,v=/(?![+-]?\d*\.?\d+|[+-]|e[+-]\d+)[^0-9]/g,w=/(?:\d|\-|\+|=|#|\.)*/g,x=/opacity *= *([^)]*)/i,y=/opacity:([^;]*)/i,z=/alpha\(opacity *=.+?\)/i,A=/^(rgb|hsl)/,B=/([A-Z])/g,C=/-([a-z])/gi,D=/(^(?:url\(\"|url\())|(?:(\"\))$|\)$)/gi,E=function(a,b){return b.toUpperCase()},F=/(?:Left|Right|Width)/i,G=/(M11|M12|M21|M22)=[\d\-\.e]+/gi,H=/progid\:DXImageTransform\.Microsoft\.Matrix\(.+?\)/i,I=/,(?=[^\)]*(?:\(|$))/gi,J=/[\s,\(]/i,K=Math.PI/180,L=180/Math.PI,M={},N={style:{}},O=_gsScope.document||{createElement:function(){return N}},P=function(a,b){return O.createElementNS?O.createElementNS(b||"http://www.w3.org/1999/xhtml",a):O.createElement(a)},Q=P("div"),R=P("img"),S=g._internals={_specialProps:i},T=(_gsScope.navigator||{}).userAgent||"",U=function(){var a=T.indexOf("Android"),b=P("a");return m=-1!==T.indexOf("Safari")&&-1===T.indexOf("Chrome")&&(-1===a||parseFloat(T.substr(a+8,2))>3),o=m&&parseFloat(T.substr(T.indexOf("Version/")+8,2))<6,n=-1!==T.indexOf("Firefox"),(/MSIE ([0-9]{1,}[\.0-9]{0,})/.exec(T)||/Trident\/.*rv:([0-9]{1,}[\.0-9]{0,})/.exec(T))&&(p=parseFloat(RegExp.$1)),b?(b.style.cssText="top:1px;opacity:.55;",/^0.55/.test(b.style.opacity)):!1}(),V=function(a){return x.test("string"==typeof a?a:(a.currentStyle?a.currentStyle.filter:a.style.filter)||"")?parseFloat(RegExp.$1)/100:1},W=function(a){_gsScope.console&&console.log(a)},X="",Y="",Z=function(a,b){b=b||Q;var c,d,e=b.style;if(void 0!==e[a])return a;for(a=a.charAt(0).toUpperCase()+a.substr(1),c=["O","Moz","ms","Ms","Webkit"],d=5;--d>-1&&void 0===e[c[d]+a];);return d>=0?(Y=3===d?"ms":c[d],X="-"+Y.toLowerCase()+"-",Y+a):null},$=O.defaultView?O.defaultView.getComputedStyle:function(){},_=g.getStyle=function(a,b,c,d,e){var f;return U||"opacity"!==b?(!d&&a.style[b]?f=a.style[b]:(c=c||$(a))?f=c[b]||c.getPropertyValue(b)||c.getPropertyValue(b.replace(B,"-$1").toLowerCase()):a.currentStyle&&(f=a.currentStyle[b]),null==e||f&&"none"!==f&&"auto"!==f&&"auto auto"!==f?f:e):V(a)},aa=S.convertToPixels=function(a,c,d,e,f){if("px"===e||!e&&"lineHeight"!==c)return d;if("auto"===e||!d)return 0;var h,i,j,k=F.test(c),l=a,m=Q.style,n=0>d,o=1===d;if(n&&(d=-d),o&&(d*=100),"lineHeight"!==c||e)if("%"===e&&-1!==c.indexOf("border"))h=d/100*(k?a.clientWidth:a.clientHeight);else{if(m.cssText="border:0 solid red;position:"+_(a,"position")+";line-height:0;","%"!==e&&l.appendChild&&"v"!==e.charAt(0)&&"rem"!==e)m[k?"borderLeftWidth":"borderTopWidth"]=d+e;else{if(l=a.parentNode||O.body,-1!==_(l,"display").indexOf("flex")&&(m.position="absolute"),i=l._gsCache,j=b.ticker.frame,i&&k&&i.time===j)return i.width*d/100;m[k?"width":"height"]=d+e}l.appendChild(Q),h=parseFloat(Q[k?"offsetWidth":"offsetHeight"]),l.removeChild(Q),k&&"%"===e&&g.cacheWidths!==!1&&(i=l._gsCache=l._gsCache||{},i.time=j,i.width=h/d*100),0!==h||f||(h=aa(a,c,d,e,!0))}else i=$(a).lineHeight,a.style.lineHeight=d,h=parseFloat($(a).lineHeight),a.style.lineHeight=i;return o&&(h/=100),n?-h:h},ba=S.calculateOffset=function(a,b,c){if("absolute"!==_(a,"position",c))return 0;var d="left"===b?"Left":"Top",e=_(a,"margin"+d,c);return a["offset"+d]-(aa(a,b,parseFloat(e),e.replace(w,""))||0)},ca=function(a,b){var c,d,e,f={};if(b=b||$(a,null))if(c=b.length)for(;--c>-1;)e=b[c],(-1===e.indexOf("-transform")||Da===e)&&(f[e.replace(C,E)]=b.getPropertyValue(e));else for(c in b)(-1===c.indexOf("Transform")||Ca===c)&&(f[c]=b[c]);else if(b=a.currentStyle||a.style)for(c in b)"string"==typeof c&&void 0===f[c]&&(f[c.replace(C,E)]=b[c]);return U||(f.opacity=V(a)),d=Ra(a,b,!1),f.rotation=d.rotation,f.skewX=d.skewX,f.scaleX=d.scaleX,f.scaleY=d.scaleY,f.x=d.x,f.y=d.y,Fa&&(f.z=d.z,f.rotationX=d.rotationX,f.rotationY=d.rotationY,f.scaleZ=d.scaleZ),f.filters&&delete f.filters,f},da=function(a,b,c,d,e){var f,g,h,i={},j=a.style;for(g in c)"cssText"!==g&&"length"!==g&&isNaN(g)&&(b[g]!==(f=c[g])||e&&e[g])&&-1===g.indexOf("Origin")&&("number"==typeof f||"string"==typeof f)&&(i[g]="auto"!==f||"left"!==g&&"top"!==g?""!==f&&"auto"!==f&&"none"!==f||"string"!=typeof b[g]||""===b[g].replace(v,"")?f:0:ba(a,g),void 0!==j[g]&&(h=new sa(j,g,j[g],h)));if(d)for(g in d)"className"!==g&&(i[g]=d[g]);return{difs:i,firstMPT:h}},ea={width:["Left","Right"],height:["Top","Bottom"]},fa=["marginLeft","marginRight","marginTop","marginBottom"],ga=function(a,b,c){if("svg"===(a.nodeName+"").toLowerCase())return(c||$(a))[b]||0;if(a.getCTM&&Oa(a))return a.getBBox()[b]||0;var d=parseFloat("width"===b?a.offsetWidth:a.offsetHeight),e=ea[b],f=e.length;for(c=c||$(a,null);--f>-1;)d-=parseFloat(_(a,"padding"+e[f],c,!0))||0,d-=parseFloat(_(a,"border"+e[f]+"Width",c,!0))||0;return d},ha=function(a,b){if("contain"===a||"auto"===a||"auto auto"===a)return a+" ";(null==a||""===a)&&(a="0 0");var c,d=a.split(" "),e=-1!==a.indexOf("left")?"0%":-1!==a.indexOf("right")?"100%":d[0],f=-1!==a.indexOf("top")?"0%":-1!==a.indexOf("bottom")?"100%":d[1];if(d.length>3&&!b){for(d=a.split(", ").join(",").split(","),a=[],c=0;c<d.length;c++)a.push(ha(d[c]));return a.join(",")}return null==f?f="center"===e?"50%":"0":"center"===f&&(f="50%"),("center"===e||isNaN(parseFloat(e))&&-1===(e+"").indexOf("="))&&(e="50%"),a=e+" "+f+(d.length>2?" "+d[2]:""),b&&(b.oxp=-1!==e.indexOf("%"),b.oyp=-1!==f.indexOf("%"),b.oxr="="===e.charAt(1),b.oyr="="===f.charAt(1),b.ox=parseFloat(e.replace(v,"")),b.oy=parseFloat(f.replace(v,"")),b.v=a),b||a},ia=function(a,b){return"function"==typeof a&&(a=a(r,q)),"string"==typeof a&&"="===a.charAt(1)?parseInt(a.charAt(0)+"1",10)*parseFloat(a.substr(2)):parseFloat(a)-parseFloat(b)||0},ja=function(a,b){return"function"==typeof a&&(a=a(r,q)),null==a?b:"string"==typeof a&&"="===a.charAt(1)?parseInt(a.charAt(0)+"1",10)*parseFloat(a.substr(2))+b:parseFloat(a)||0},ka=function(a,b,c,d){var e,f,g,h,i,j=1e-6;return"function"==typeof a&&(a=a(r,q)),null==a?h=b:"number"==typeof a?h=a:(e=360,f=a.split("_"),i="="===a.charAt(1),g=(i?parseInt(a.charAt(0)+"1",10)*parseFloat(f[0].substr(2)):parseFloat(f[0]))*(-1===a.indexOf("rad")?1:L)-(i?0:b),f.length&&(d&&(d[c]=b+g),-1!==a.indexOf("short")&&(g%=e,g!==g%(e/2)&&(g=0>g?g+e:g-e)),-1!==a.indexOf("_cw")&&0>g?g=(g+9999999999*e)%e-(g/e|0)*e:-1!==a.indexOf("ccw")&&g>0&&(g=(g-9999999999*e)%e-(g/e|0)*e)),h=b+g),j>h&&h>-j&&(h=0),h},la={aqua:[0,255,255],lime:[0,255,0],silver:[192,192,192],black:[0,0,0],maroon:[128,0,0],teal:[0,128,128],blue:[0,0,255],navy:[0,0,128],white:[255,255,255],fuchsia:[255,0,255],olive:[128,128,0],yellow:[255,255,0],orange:[255,165,0],gray:[128,128,128],purple:[128,0,128],green:[0,128,0],red:[255,0,0],pink:[255,192,203],cyan:[0,255,255],transparent:[255,255,255,0]},ma=function(a,b,c){return a=0>a?a+1:a>1?a-1:a,255*(1>6*a?b+(c-b)*a*6:.5>a?c:2>3*a?b+(c-b)*(2/3-a)*6:b)+.5|0},na=g.parseColor=function(a,b){var c,d,e,f,g,h,i,j,k,l,m;if(a)if("number"==typeof a)c=[a>>16,a>>8&255,255&a];else{if(","===a.charAt(a.length-1)&&(a=a.substr(0,a.length-1)),la[a])c=la[a];else if("#"===a.charAt(0))4===a.length&&(d=a.charAt(1),e=a.charAt(2),f=a.charAt(3),a="#"+d+d+e+e+f+f),a=parseInt(a.substr(1),16),c=[a>>16,a>>8&255,255&a];else if("hsl"===a.substr(0,3))if(c=m=a.match(s),b){if(-1!==a.indexOf("="))return a.match(t)}else g=Number(c[0])%360/360,h=Number(c[1])/100,i=Number(c[2])/100,e=.5>=i?i*(h+1):i+h-i*h,d=2*i-e,c.length>3&&(c[3]=Number(c[3])),c[0]=ma(g+1/3,d,e),c[1]=ma(g,d,e),c[2]=ma(g-1/3,d,e);else c=a.match(s)||la.transparent;c[0]=Number(c[0]),c[1]=Number(c[1]),c[2]=Number(c[2]),c.length>3&&(c[3]=Number(c[3]))}else c=la.black;return b&&!m&&(d=c[0]/255,e=c[1]/255,f=c[2]/255,j=Math.max(d,e,f),k=Math.min(d,e,f),i=(j+k)/2,j===k?g=h=0:(l=j-k,h=i>.5?l/(2-j-k):l/(j+k),g=j===d?(e-f)/l+(f>e?6:0):j===e?(f-d)/l+2:(d-e)/l+4,g*=60),c[0]=g+.5|0,c[1]=100*h+.5|0,c[2]=100*i+.5|0),c},oa=function(a,b){var c,d,e,f=a.match(pa)||[],g=0,h="";if(!f.length)return a;for(c=0;c<f.length;c++)d=f[c],e=a.substr(g,a.indexOf(d,g)-g),g+=e.length+d.length,d=na(d,b),3===d.length&&d.push(1),h+=e+(b?"hsla("+d[0]+","+d[1]+"%,"+d[2]+"%,"+d[3]:"rgba("+d.join(","))+")";return h+a.substr(g)},pa="(?:\\b(?:(?:rgb|rgba|hsl|hsla)\\(.+?\\))|\\B#(?:[0-9a-f]{3}){1,2}\\b";for(j in la)pa+="|"+j+"\\b";pa=new RegExp(pa+")","gi"),g.colorStringFilter=function(a){var b,c=a[0]+" "+a[1];pa.test(c)&&(b=-1!==c.indexOf("hsl(")||-1!==c.indexOf("hsla("),a[0]=oa(a[0],b),a[1]=oa(a[1],b)),pa.lastIndex=0},b.defaultStringFilter||(b.defaultStringFilter=g.colorStringFilter);var qa=function(a,b,c,d){if(null==a)return function(a){return a};var e,f=b?(a.match(pa)||[""])[0]:"",g=a.split(f).join("").match(u)||[],h=a.substr(0,a.indexOf(g[0])),i=")"===a.charAt(a.length-1)?")":"",j=-1!==a.indexOf(" ")?" ":",",k=g.length,l=k>0?g[0].replace(s,""):"";return k?e=b?function(a){var b,m,n,o;if("number"==typeof a)a+=l;else if(d&&I.test(a)){for(o=a.replace(I,"|").split("|"),n=0;n<o.length;n++)o[n]=e(o[n]);return o.join(",")}if(b=(a.match(pa)||[f])[0],m=a.split(b).join("").match(u)||[],n=m.length,k>n--)for(;++n<k;)m[n]=c?m[(n-1)/2|0]:g[n];return h+m.join(j)+j+b+i+(-1!==a.indexOf("inset")?" inset":"")}:function(a){var b,f,m;if("number"==typeof a)a+=l;else if(d&&I.test(a)){for(f=a.replace(I,"|").split("|"),m=0;m<f.length;m++)f[m]=e(f[m]);return f.join(",")}if(b=a.match(u)||[],m=b.length,k>m--)for(;++m<k;)b[m]=c?b[(m-1)/2|0]:g[m];return h+b.join(j)+i}:function(a){return a}},ra=function(a){return a=a.split(","),function(b,c,d,e,f,g,h){var i,j=(c+"").split(" ");for(h={},i=0;4>i;i++)h[a[i]]=j[i]=j[i]||j[(i-1)/2>>0];return e.parse(b,h,f,g)}},sa=(S._setPluginRatio=function(a){this.plugin.setRatio(a);for(var b,c,d,e,f,g=this.data,h=g.proxy,i=g.firstMPT,j=1e-6;i;)b=h[i.v],i.r?b=Math.round(b):j>b&&b>-j&&(b=0),i.t[i.p]=b,i=i._next;if(g.autoRotate&&(g.autoRotate.rotation=g.mod?g.mod(h.rotation,this.t):h.rotation),1===a||0===a)for(i=g.firstMPT,f=1===a?"e":"b";i;){if(c=i.t,c.type){if(1===c.type){for(e=c.xs0+c.s+c.xs1,d=1;d<c.l;d++)e+=c["xn"+d]+c["xs"+(d+1)];c[f]=e}}else c[f]=c.s+c.xs0;i=i._next}},function(a,b,c,d,e){this.t=a,this.p=b,this.v=c,this.r=e,d&&(d._prev=this,this._next=d)}),ta=(S._parseToProxy=function(a,b,c,d,e,f){var g,h,i,j,k,l=d,m={},n={},o=c._transform,p=M;for(c._transform=null,M=b,d=k=c.parse(a,b,d,e),M=p,f&&(c._transform=o,l&&(l._prev=null,l._prev&&(l._prev._next=null)));d&&d!==l;){if(d.type<=1&&(h=d.p,n[h]=d.s+d.c,m[h]=d.s,f||(j=new sa(d,"s",h,j,d.r),d.c=0),1===d.type))for(g=d.l;--g>0;)i="xn"+g,h=d.p+"_"+i,n[h]=d.data[i],m[h]=d[i],f||(j=new sa(d,i,h,j,d.rxp[i]));d=d._next}return{proxy:m,end:n,firstMPT:j,pt:k}},S.CSSPropTween=function(a,b,d,e,g,h,i,j,k,l,m){this.t=a,this.p=b,this.s=d,this.c=e,this.n=i||b,a instanceof ta||f.push(this.n),this.r=j,this.type=h||0,k&&(this.pr=k,c=!0),this.b=void 0===l?d:l,this.e=void 0===m?d+e:m,g&&(this._next=g,g._prev=this)}),ua=function(a,b,c,d,e,f){var g=new ta(a,b,c,d-c,e,-1,f);return g.b=c,g.e=g.xs0=d,g},va=g.parseComplex=function(a,b,c,d,e,f,h,i,j,l){c=c||f||"","function"==typeof d&&(d=d(r,q)),h=new ta(a,b,0,0,h,l?2:1,null,!1,i,c,d),d+="",e&&pa.test(d+c)&&(d=[c,d],g.colorStringFilter(d),c=d[0],d=d[1]);var m,n,o,p,u,v,w,x,y,z,A,B,C,D=c.split(", ").join(",").split(" "),E=d.split(", ").join(",").split(" "),F=D.length,G=k!==!1;for((-1!==d.indexOf(",")||-1!==c.indexOf(","))&&(-1!==(d+c).indexOf("rgb")||-1!==(d+c).indexOf("hsl")?(D=D.join(" ").replace(I,", ").split(" "),E=E.join(" ").replace(I,", ").split(" ")):(D=D.join(" ").split(",").join(", ").split(" "),E=E.join(" ").split(",").join(", ").split(" ")),F=D.length),F!==E.length&&(D=(f||"").split(" "),F=D.length),h.plugin=j,h.setRatio=l,pa.lastIndex=0,m=0;F>m;m++)if(p=D[m],u=E[m],x=parseFloat(p),x||0===x)h.appendXtra("",x,ia(u,x),u.replace(t,""),G&&-1!==u.indexOf("px"),!0);else if(e&&pa.test(p))B=u.indexOf(")")+1,B=")"+(B?u.substr(B):""),C=-1!==u.indexOf("hsl")&&U,z=u,p=na(p,C),u=na(u,C),y=p.length+u.length>6,y&&!U&&0===u[3]?(h["xs"+h.l]+=h.l?" transparent":"transparent",h.e=h.e.split(E[m]).join("transparent")):(U||(y=!1),C?h.appendXtra(z.substr(0,z.indexOf("hsl"))+(y?"hsla(":"hsl("),p[0],ia(u[0],p[0]),",",!1,!0).appendXtra("",p[1],ia(u[1],p[1]),"%,",!1).appendXtra("",p[2],ia(u[2],p[2]),y?"%,":"%"+B,!1):h.appendXtra(z.substr(0,z.indexOf("rgb"))+(y?"rgba(":"rgb("),p[0],u[0]-p[0],",",!0,!0).appendXtra("",p[1],u[1]-p[1],",",!0).appendXtra("",p[2],u[2]-p[2],y?",":B,!0),y&&(p=p.length<4?1:p[3],h.appendXtra("",p,(u.length<4?1:u[3])-p,B,!1))),pa.lastIndex=0;else if(v=p.match(s)){if(w=u.match(t),!w||w.length!==v.length)return h;for(o=0,n=0;n<v.length;n++)A=v[n],z=p.indexOf(A,o),h.appendXtra(p.substr(o,z-o),Number(A),ia(w[n],A),"",G&&"px"===p.substr(z+A.length,2),0===n),o=z+A.length;h["xs"+h.l]+=p.substr(o)}else h["xs"+h.l]+=h.l||h["xs"+h.l]?" "+u:u;if(-1!==d.indexOf("=")&&h.data){for(B=h.xs0+h.data.s,m=1;m<h.l;m++)B+=h["xs"+m]+h.data["xn"+m];h.e=B+h["xs"+m]}return h.l||(h.type=-1,h.xs0=h.e),h.xfirst||h},wa=9;for(j=ta.prototype,j.l=j.pr=0;--wa>0;)j["xn"+wa]=0,j["xs"+wa]="";j.xs0="",j._next=j._prev=j.xfirst=j.data=j.plugin=j.setRatio=j.rxp=null,j.appendXtra=function(a,b,c,d,e,f){var g=this,h=g.l;return g["xs"+h]+=f&&(h||g["xs"+h])?" "+a:a||"",c||0===h||g.plugin?(g.l++,g.type=g.setRatio?2:1,g["xs"+g.l]=d||"",h>0?(g.data["xn"+h]=b+c,g.rxp["xn"+h]=e,g["xn"+h]=b,g.plugin||(g.xfirst=new ta(g,"xn"+h,b,c,g.xfirst||g,0,g.n,e,g.pr),g.xfirst.xs0=0),g):(g.data={s:b+c},g.rxp={},g.s=b,g.c=c,g.r=e,g)):(g["xs"+h]+=b+(d||""),g)};var xa=function(a,b){b=b||{},this.p=b.prefix?Z(a)||a:a,i[a]=i[this.p]=this,this.format=b.formatter||qa(b.defaultValue,b.color,b.collapsible,b.multi),b.parser&&(this.parse=b.parser),this.clrs=b.color,this.multi=b.multi,this.keyword=b.keyword,this.dflt=b.defaultValue,this.pr=b.priority||0},ya=S._registerComplexSpecialProp=function(a,b,c){"object"!=typeof b&&(b={parser:c});var d,e,f=a.split(","),g=b.defaultValue;for(c=c||[g],d=0;d<f.length;d++)b.prefix=0===d&&b.prefix,b.defaultValue=c[d]||g,e=new xa(f[d],b)},za=S._registerPluginProp=function(a){if(!i[a]){var b=a.charAt(0).toUpperCase()+a.substr(1)+"Plugin";ya(a,{parser:function(a,c,d,e,f,g,j){var k=h.com.greensock.plugins[b];return k?(k._cssRegister(),i[d].parse(a,c,d,e,f,g,j)):(W("Error: "+b+" js file not loaded."),f)}})}};j=xa.prototype,j.parseComplex=function(a,b,c,d,e,f){var g,h,i,j,k,l,m=this.keyword;if(this.multi&&(I.test(c)||I.test(b)?(h=b.replace(I,"|").split("|"),i=c.replace(I,"|").split("|")):m&&(h=[b],i=[c])),i){for(j=i.length>h.length?i.length:h.length,g=0;j>g;g++)b=h[g]=h[g]||this.dflt,c=i[g]=i[g]||this.dflt,m&&(k=b.indexOf(m),l=c.indexOf(m),k!==l&&(-1===l?h[g]=h[g].split(m).join(""):-1===k&&(h[g]+=" "+m)));b=h.join(", "),c=i.join(", ")}return va(a,this.p,b,c,this.clrs,this.dflt,d,this.pr,e,f)},j.parse=function(a,b,c,d,f,g,h){return this.parseComplex(a.style,this.format(_(a,this.p,e,!1,this.dflt)),this.format(b),f,g)},g.registerSpecialProp=function(a,b,c){ya(a,{parser:function(a,d,e,f,g,h,i){var j=new ta(a,e,0,0,g,2,e,!1,c);return j.plugin=h,j.setRatio=b(a,d,f._tween,e),j},priority:c})},g.useSVGTransformAttr=!0;var Aa,Ba="scaleX,scaleY,scaleZ,x,y,z,skewX,skewY,rotation,rotationX,rotationY,perspective,xPercent,yPercent".split(","),Ca=Z("transform"),Da=X+"transform",Ea=Z("transformOrigin"),Fa=null!==Z("perspective"),Ga=S.Transform=function(){this.perspective=parseFloat(g.defaultTransformPerspective)||0,this.force3D=g.defaultForce3D!==!1&&Fa?g.defaultForce3D||"auto":!1},Ha=_gsScope.SVGElement,Ia=function(a,b,c){var d,e=O.createElementNS("http://www.w3.org/2000/svg",a),f=/([a-z])([A-Z])/g;for(d in c)e.setAttributeNS(null,d.replace(f,"$1-$2").toLowerCase(),c[d]);return b.appendChild(e),e},Ja=O.documentElement||{},Ka=function(){var a,b,c,d=p||/Android/i.test(T)&&!_gsScope.chrome;return O.createElementNS&&!d&&(a=Ia("svg",Ja),b=Ia("rect",a,{width:100,height:50,x:100}),c=b.getBoundingClientRect().width,b.style[Ea]="50% 50%",b.style[Ca]="scaleX(0.5)",d=c===b.getBoundingClientRect().width&&!(n&&Fa),Ja.removeChild(a)),d}(),La=function(a,b,c,d,e,f){var h,i,j,k,l,m,n,o,p,q,r,s,t,u,v=a._gsTransform,w=Qa(a,!0);v&&(t=v.xOrigin,u=v.yOrigin),(!d||(h=d.split(" ")).length<2)&&(n=a.getBBox(),0===n.x&&0===n.y&&n.width+n.height===0&&(n={x:parseFloat(a.hasAttribute("x")?a.getAttribute("x"):a.hasAttribute("cx")?a.getAttribute("cx"):0)||0,y:parseFloat(a.hasAttribute("y")?a.getAttribute("y"):a.hasAttribute("cy")?a.getAttribute("cy"):0)||0,width:0,height:0}),b=ha(b).split(" "),h=[(-1!==b[0].indexOf("%")?parseFloat(b[0])/100*n.width:parseFloat(b[0]))+n.x,(-1!==b[1].indexOf("%")?parseFloat(b[1])/100*n.height:parseFloat(b[1]))+n.y]),c.xOrigin=k=parseFloat(h[0]),c.yOrigin=l=parseFloat(h[1]),d&&w!==Pa&&(m=w[0],n=w[1],o=w[2],p=w[3],q=w[4],r=w[5],s=m*p-n*o,s&&(i=k*(p/s)+l*(-o/s)+(o*r-p*q)/s,j=k*(-n/s)+l*(m/s)-(m*r-n*q)/s,k=c.xOrigin=h[0]=i,l=c.yOrigin=h[1]=j)),v&&(f&&(c.xOffset=v.xOffset,c.yOffset=v.yOffset,v=c),e||e!==!1&&g.defaultSmoothOrigin!==!1?(i=k-t,j=l-u,v.xOffset+=i*w[0]+j*w[2]-i,v.yOffset+=i*w[1]+j*w[3]-j):v.xOffset=v.yOffset=0),f||a.setAttribute("data-svg-origin",h.join(" "))},Ma=function(a){var b,c=P("svg",this.ownerSVGElement&&this.ownerSVGElement.getAttribute("xmlns")||"http://www.w3.org/2000/svg"),d=this.parentNode,e=this.nextSibling,f=this.style.cssText;if(Ja.appendChild(c),c.appendChild(this),this.style.display="block",a)try{b=this.getBBox(),this._originalGetBBox=this.getBBox,this.getBBox=Ma}catch(g){}else this._originalGetBBox&&(b=this._originalGetBBox());return e?d.insertBefore(this,e):d.appendChild(this),Ja.removeChild(c),this.style.cssText=f,b},Na=function(a){try{return a.getBBox()}catch(b){return Ma.call(a,!0)}},Oa=function(a){return!(!Ha||!a.getCTM||a.parentNode&&!a.ownerSVGElement||!Na(a))},Pa=[1,0,0,1,0,0],Qa=function(a,b){var c,d,e,f,g,h,i=a._gsTransform||new Ga,j=1e5,k=a.style;if(Ca?d=_(a,Da,null,!0):a.currentStyle&&(d=a.currentStyle.filter.match(G),d=d&&4===d.length?[d[0].substr(4),Number(d[2].substr(4)),Number(d[1].substr(4)),d[3].substr(4),i.x||0,i.y||0].join(","):""),c=!d||"none"===d||"matrix(1, 0, 0, 1, 0, 0)"===d,!Ca||!(h=!$(a)||"none"===$(a).display)&&a.parentNode||(h&&(f=k.display,k.display="block"),a.parentNode||(g=1,Ja.appendChild(a)),d=_(a,Da,null,!0),c=!d||"none"===d||"matrix(1, 0, 0, 1, 0, 0)"===d,f?k.display=f:h&&Va(k,"display"),g&&Ja.removeChild(a)),(i.svg||a.getCTM&&Oa(a))&&(c&&-1!==(k[Ca]+"").indexOf("matrix")&&(d=k[Ca],c=0),e=a.getAttribute("transform"),c&&e&&(-1!==e.indexOf("matrix")?(d=e,c=0):-1!==e.indexOf("translate")&&(d="matrix(1,0,0,1,"+e.match(/(?:\-|\b)[\d\-\.e]+\b/gi).join(",")+")",c=0))),c)return Pa;for(e=(d||"").match(s)||[],wa=e.length;--wa>-1;)f=Number(e[wa]),e[wa]=(g=f-(f|=0))?(g*j+(0>g?-.5:.5)|0)/j+f:f;return b&&e.length>6?[e[0],e[1],e[4],e[5],e[12],e[13]]:e},Ra=S.getTransform=function(a,c,d,e){if(a._gsTransform&&d&&!e)return a._gsTransform;var f,h,i,j,k,l,m=d?a._gsTransform||new Ga:new Ga,n=m.scaleX<0,o=2e-5,p=1e5,q=Fa?parseFloat(_(a,Ea,c,!1,"0 0 0").split(" ")[2])||m.zOrigin||0:0,r=parseFloat(g.defaultTransformPerspective)||0;if(m.svg=!(!a.getCTM||!Oa(a)),m.svg&&(La(a,_(a,Ea,c,!1,"50% 50%")+"",m,a.getAttribute("data-svg-origin")),Aa=g.useSVGTransformAttr||Ka),f=Qa(a),f!==Pa){if(16===f.length){var s,t,u,v,w,x=f[0],y=f[1],z=f[2],A=f[3],B=f[4],C=f[5],D=f[6],E=f[7],F=f[8],G=f[9],H=f[10],I=f[12],J=f[13],K=f[14],M=f[11],N=Math.atan2(D,H);m.zOrigin&&(K=-m.zOrigin,I=F*K-f[12],J=G*K-f[13],K=H*K+m.zOrigin-f[14]),m.rotationX=N*L,N&&(v=Math.cos(-N),w=Math.sin(-N),s=B*v+F*w,t=C*v+G*w,u=D*v+H*w,F=B*-w+F*v,G=C*-w+G*v,H=D*-w+H*v,M=E*-w+M*v,B=s,C=t,D=u),N=Math.atan2(-z,H),m.rotationY=N*L,N&&(v=Math.cos(-N),w=Math.sin(-N),s=x*v-F*w,t=y*v-G*w,u=z*v-H*w,G=y*w+G*v,H=z*w+H*v,M=A*w+M*v,x=s,y=t,z=u),N=Math.atan2(y,x),m.rotation=N*L,N&&(v=Math.cos(N),w=Math.sin(N),s=x*v+y*w,t=B*v+C*w,u=F*v+G*w,y=y*v-x*w,C=C*v-B*w,G=G*v-F*w,x=s,B=t,F=u),m.rotationX&&Math.abs(m.rotationX)+Math.abs(m.rotation)>359.9&&(m.rotationX=m.rotation=0,m.rotationY=180-m.rotationY),N=Math.atan2(B,C),m.scaleX=(Math.sqrt(x*x+y*y+z*z)*p+.5|0)/p,m.scaleY=(Math.sqrt(C*C+D*D)*p+.5|0)/p,m.scaleZ=(Math.sqrt(F*F+G*G+H*H)*p+.5|0)/p,x/=m.scaleX,B/=m.scaleY,y/=m.scaleX,C/=m.scaleY,Math.abs(N)>o?(m.skewX=N*L,B=0,"simple"!==m.skewType&&(m.scaleY*=1/Math.cos(N))):m.skewX=0,m.perspective=M?1/(0>M?-M:M):0,m.x=I,m.y=J,m.z=K,m.svg&&(m.x-=m.xOrigin-(m.xOrigin*x-m.yOrigin*B),m.y-=m.yOrigin-(m.yOrigin*y-m.xOrigin*C))}else if(!Fa||e||!f.length||m.x!==f[4]||m.y!==f[5]||!m.rotationX&&!m.rotationY){var O=f.length>=6,P=O?f[0]:1,Q=f[1]||0,R=f[2]||0,S=O?f[3]:1;m.x=f[4]||0,m.y=f[5]||0,i=Math.sqrt(P*P+Q*Q),j=Math.sqrt(S*S+R*R),k=P||Q?Math.atan2(Q,P)*L:m.rotation||0,l=R||S?Math.atan2(R,S)*L+k:m.skewX||0,m.scaleX=i,m.scaleY=j,m.rotation=k,m.skewX=l,Fa&&(m.rotationX=m.rotationY=m.z=0,m.perspective=r,m.scaleZ=1),m.svg&&(m.x-=m.xOrigin-(m.xOrigin*P+m.yOrigin*R),m.y-=m.yOrigin-(m.xOrigin*Q+m.yOrigin*S))}Math.abs(m.skewX)>90&&Math.abs(m.skewX)<270&&(n?(m.scaleX*=-1,m.skewX+=m.rotation<=0?180:-180,m.rotation+=m.rotation<=0?180:-180):(m.scaleY*=-1,m.skewX+=m.skewX<=0?180:-180)),m.zOrigin=q;for(h in m)m[h]<o&&m[h]>-o&&(m[h]=0)}return d&&(a._gsTransform=m,m.svg&&(Aa&&a.style[Ca]?b.delayedCall(.001,function(){Va(a.style,Ca)}):!Aa&&a.getAttribute("transform")&&b.delayedCall(.001,function(){a.removeAttribute("transform")}))),m},Sa=function(a){var b,c,d=this.data,e=-d.rotation*K,f=e+d.skewX*K,g=1e5,h=(Math.cos(e)*d.scaleX*g|0)/g,i=(Math.sin(e)*d.scaleX*g|0)/g,j=(Math.sin(f)*-d.scaleY*g|0)/g,k=(Math.cos(f)*d.scaleY*g|0)/g,l=this.t.style,m=this.t.currentStyle;if(m){c=i,i=-j,j=-c,b=m.filter,l.filter="";var n,o,q=this.t.offsetWidth,r=this.t.offsetHeight,s="absolute"!==m.position,t="progid:DXImageTransform.Microsoft.Matrix(M11="+h+", M12="+i+", M21="+j+", M22="+k,u=d.x+q*d.xPercent/100,v=d.y+r*d.yPercent/100;if(null!=d.ox&&(n=(d.oxp?q*d.ox*.01:d.ox)-q/2,o=(d.oyp?r*d.oy*.01:d.oy)-r/2,u+=n-(n*h+o*i),v+=o-(n*j+o*k)),s?(n=q/2,o=r/2,t+=", Dx="+(n-(n*h+o*i)+u)+", Dy="+(o-(n*j+o*k)+v)+")"):t+=", sizingMethod='auto expand')",-1!==b.indexOf("DXImageTransform.Microsoft.Matrix(")?l.filter=b.replace(H,t):l.filter=t+" "+b,(0===a||1===a)&&1===h&&0===i&&0===j&&1===k&&(s&&-1===t.indexOf("Dx=0, Dy=0")||x.test(b)&&100!==parseFloat(RegExp.$1)||-1===b.indexOf(b.indexOf("Alpha"))&&l.removeAttribute("filter")),!s){var y,z,A,B=8>p?1:-1;for(n=d.ieOffsetX||0,o=d.ieOffsetY||0,d.ieOffsetX=Math.round((q-((0>h?-h:h)*q+(0>i?-i:i)*r))/2+u),d.ieOffsetY=Math.round((r-((0>k?-k:k)*r+(0>j?-j:j)*q))/2+v),wa=0;4>wa;wa++)z=fa[wa],y=m[z],c=-1!==y.indexOf("px")?parseFloat(y):aa(this.t,z,parseFloat(y),y.replace(w,""))||0,A=c!==d[z]?2>wa?-d.ieOffsetX:-d.ieOffsetY:2>wa?n-d.ieOffsetX:o-d.ieOffsetY,l[z]=(d[z]=Math.round(c-A*(0===wa||2===wa?1:B)))+"px"}}},Ta=S.set3DTransformRatio=S.setTransformRatio=function(a){var b,c,d,e,f,g,h,i,j,k,l,m,o,p,q,r,s,t,u,v,w,x,y,z=this.data,A=this.t.style,B=z.rotation,C=z.rotationX,D=z.rotationY,E=z.scaleX,F=z.scaleY,G=z.scaleZ,H=z.x,I=z.y,J=z.z,L=z.svg,M=z.perspective,N=z.force3D,O=z.skewY,P=z.skewX;if(O&&(P+=O,B+=O),((1===a||0===a)&&"auto"===N&&(this.tween._totalTime===this.tween._totalDuration||!this.tween._totalTime)||!N)&&!J&&!M&&!D&&!C&&1===G||Aa&&L||!Fa)return void(B||P||L?(B*=K,x=P*K,y=1e5,c=Math.cos(B)*E,f=Math.sin(B)*E,d=Math.sin(B-x)*-F,g=Math.cos(B-x)*F,x&&"simple"===z.skewType&&(b=Math.tan(x-O*K),b=Math.sqrt(1+b*b),d*=b,g*=b,O&&(b=Math.tan(O*K),b=Math.sqrt(1+b*b),c*=b,f*=b)),L&&(H+=z.xOrigin-(z.xOrigin*c+z.yOrigin*d)+z.xOffset,I+=z.yOrigin-(z.xOrigin*f+z.yOrigin*g)+z.yOffset,Aa&&(z.xPercent||z.yPercent)&&(q=this.t.getBBox(),H+=.01*z.xPercent*q.width,I+=.01*z.yPercent*q.height),q=1e-6,q>H&&H>-q&&(H=0),q>I&&I>-q&&(I=0)),u=(c*y|0)/y+","+(f*y|0)/y+","+(d*y|0)/y+","+(g*y|0)/y+","+H+","+I+")",L&&Aa?this.t.setAttribute("transform","matrix("+u):A[Ca]=(z.xPercent||z.yPercent?"translate("+z.xPercent+"%,"+z.yPercent+"%) matrix(":"matrix(")+u):A[Ca]=(z.xPercent||z.yPercent?"translate("+z.xPercent+"%,"+z.yPercent+"%) matrix(":"matrix(")+E+",0,0,"+F+","+H+","+I+")");if(n&&(q=1e-4,q>E&&E>-q&&(E=G=2e-5),q>F&&F>-q&&(F=G=2e-5),!M||z.z||z.rotationX||z.rotationY||(M=0)),B||P)B*=K,r=c=Math.cos(B),s=f=Math.sin(B),P&&(B-=P*K,r=Math.cos(B),s=Math.sin(B),"simple"===z.skewType&&(b=Math.tan((P-O)*K),b=Math.sqrt(1+b*b),r*=b,s*=b,z.skewY&&(b=Math.tan(O*K),b=Math.sqrt(1+b*b),c*=b,f*=b))),d=-s,g=r;else{if(!(D||C||1!==G||M||L))return void(A[Ca]=(z.xPercent||z.yPercent?"translate("+z.xPercent+"%,"+z.yPercent+"%) translate3d(":"translate3d(")+H+"px,"+I+"px,"+J+"px)"+(1!==E||1!==F?" scale("+E+","+F+")":""));c=g=1,d=f=0}k=1,e=h=i=j=l=m=0,o=M?-1/M:0,p=z.zOrigin,q=1e-6,v=",",w="0",B=D*K,B&&(r=Math.cos(B),s=Math.sin(B),i=-s,l=o*-s,e=c*s,h=f*s,k=r,o*=r,c*=r,f*=r),B=C*K,B&&(r=Math.cos(B),s=Math.sin(B),b=d*r+e*s,t=g*r+h*s,j=k*s,m=o*s,e=d*-s+e*r,h=g*-s+h*r,k*=r,o*=r,d=b,g=t),1!==G&&(e*=G,h*=G,k*=G,o*=G),1!==F&&(d*=F,g*=F,j*=F,m*=F),1!==E&&(c*=E,f*=E,i*=E,l*=E),(p||L)&&(p&&(H+=e*-p,I+=h*-p,J+=k*-p+p),L&&(H+=z.xOrigin-(z.xOrigin*c+z.yOrigin*d)+z.xOffset,I+=z.yOrigin-(z.xOrigin*f+z.yOrigin*g)+z.yOffset),q>H&&H>-q&&(H=w),q>I&&I>-q&&(I=w),q>J&&J>-q&&(J=0)),u=z.xPercent||z.yPercent?"translate("+z.xPercent+"%,"+z.yPercent+"%) matrix3d(":"matrix3d(",u+=(q>c&&c>-q?w:c)+v+(q>f&&f>-q?w:f)+v+(q>i&&i>-q?w:i),u+=v+(q>l&&l>-q?w:l)+v+(q>d&&d>-q?w:d)+v+(q>g&&g>-q?w:g),C||D||1!==G?(u+=v+(q>j&&j>-q?w:j)+v+(q>m&&m>-q?w:m)+v+(q>e&&e>-q?w:e),u+=v+(q>h&&h>-q?w:h)+v+(q>k&&k>-q?w:k)+v+(q>o&&o>-q?w:o)+v):u+=",0,0,0,0,1,0,",u+=H+v+I+v+J+v+(M?1+-J/M:1)+")",A[Ca]=u};j=Ga.prototype,j.x=j.y=j.z=j.skewX=j.skewY=j.rotation=j.rotationX=j.rotationY=j.zOrigin=j.xPercent=j.yPercent=j.xOffset=j.yOffset=0,j.scaleX=j.scaleY=j.scaleZ=1,ya("transform,scale,scaleX,scaleY,scaleZ,x,y,z,rotation,rotationX,rotationY,rotationZ,skewX,skewY,shortRotation,shortRotationX,shortRotationY,shortRotationZ,transformOrigin,svgOrigin,transformPerspective,directionalRotation,parseTransform,force3D,skewType,xPercent,yPercent,smoothOrigin",{
parser:function(a,b,c,d,f,h,i){if(d._lastParsedTransform===i)return f;d._lastParsedTransform=i;var j,k=i.scale&&"function"==typeof i.scale?i.scale:0;"function"==typeof i[c]&&(j=i[c],i[c]=b),k&&(i.scale=k(r,a));var l,m,n,o,p,s,t,u,v,w=a._gsTransform,x=a.style,y=1e-6,z=Ba.length,A=i,B={},C="transformOrigin",D=Ra(a,e,!0,A.parseTransform),E=A.transform&&("function"==typeof A.transform?A.transform(r,q):A.transform);if(D.skewType=A.skewType||D.skewType||g.defaultSkewType,d._transform=D,E&&"string"==typeof E&&Ca)m=Q.style,m[Ca]=E,m.display="block",m.position="absolute",O.body.appendChild(Q),l=Ra(Q,null,!1),"simple"===D.skewType&&(l.scaleY*=Math.cos(l.skewX*K)),D.svg&&(s=D.xOrigin,t=D.yOrigin,l.x-=D.xOffset,l.y-=D.yOffset,(A.transformOrigin||A.svgOrigin)&&(E={},La(a,ha(A.transformOrigin),E,A.svgOrigin,A.smoothOrigin,!0),s=E.xOrigin,t=E.yOrigin,l.x-=E.xOffset-D.xOffset,l.y-=E.yOffset-D.yOffset),(s||t)&&(u=Qa(Q,!0),l.x-=s-(s*u[0]+t*u[2]),l.y-=t-(s*u[1]+t*u[3]))),O.body.removeChild(Q),l.perspective||(l.perspective=D.perspective),null!=A.xPercent&&(l.xPercent=ja(A.xPercent,D.xPercent)),null!=A.yPercent&&(l.yPercent=ja(A.yPercent,D.yPercent));else if("object"==typeof A){if(l={scaleX:ja(null!=A.scaleX?A.scaleX:A.scale,D.scaleX),scaleY:ja(null!=A.scaleY?A.scaleY:A.scale,D.scaleY),scaleZ:ja(A.scaleZ,D.scaleZ),x:ja(A.x,D.x),y:ja(A.y,D.y),z:ja(A.z,D.z),xPercent:ja(A.xPercent,D.xPercent),yPercent:ja(A.yPercent,D.yPercent),perspective:ja(A.transformPerspective,D.perspective)},p=A.directionalRotation,null!=p)if("object"==typeof p)for(m in p)A[m]=p[m];else A.rotation=p;"string"==typeof A.x&&-1!==A.x.indexOf("%")&&(l.x=0,l.xPercent=ja(A.x,D.xPercent)),"string"==typeof A.y&&-1!==A.y.indexOf("%")&&(l.y=0,l.yPercent=ja(A.y,D.yPercent)),l.rotation=ka("rotation"in A?A.rotation:"shortRotation"in A?A.shortRotation+"_short":"rotationZ"in A?A.rotationZ:D.rotation,D.rotation,"rotation",B),Fa&&(l.rotationX=ka("rotationX"in A?A.rotationX:"shortRotationX"in A?A.shortRotationX+"_short":D.rotationX||0,D.rotationX,"rotationX",B),l.rotationY=ka("rotationY"in A?A.rotationY:"shortRotationY"in A?A.shortRotationY+"_short":D.rotationY||0,D.rotationY,"rotationY",B)),l.skewX=ka(A.skewX,D.skewX),l.skewY=ka(A.skewY,D.skewY)}for(Fa&&null!=A.force3D&&(D.force3D=A.force3D,o=!0),n=D.force3D||D.z||D.rotationX||D.rotationY||l.z||l.rotationX||l.rotationY||l.perspective,n||null==A.scale||(l.scaleZ=1);--z>-1;)v=Ba[z],E=l[v]-D[v],(E>y||-y>E||null!=A[v]||null!=M[v])&&(o=!0,f=new ta(D,v,D[v],E,f),v in B&&(f.e=B[v]),f.xs0=0,f.plugin=h,d._overwriteProps.push(f.n));return E=A.transformOrigin,D.svg&&(E||A.svgOrigin)&&(s=D.xOffset,t=D.yOffset,La(a,ha(E),l,A.svgOrigin,A.smoothOrigin),f=ua(D,"xOrigin",(w?D:l).xOrigin,l.xOrigin,f,C),f=ua(D,"yOrigin",(w?D:l).yOrigin,l.yOrigin,f,C),(s!==D.xOffset||t!==D.yOffset)&&(f=ua(D,"xOffset",w?s:D.xOffset,D.xOffset,f,C),f=ua(D,"yOffset",w?t:D.yOffset,D.yOffset,f,C)),E="0px 0px"),(E||Fa&&n&&D.zOrigin)&&(Ca?(o=!0,v=Ea,E=(E||_(a,v,e,!1,"50% 50%"))+"",f=new ta(x,v,0,0,f,-1,C),f.b=x[v],f.plugin=h,Fa?(m=D.zOrigin,E=E.split(" "),D.zOrigin=(E.length>2&&(0===m||"0px"!==E[2])?parseFloat(E[2]):m)||0,f.xs0=f.e=E[0]+" "+(E[1]||"50%")+" 0px",f=new ta(D,"zOrigin",0,0,f,-1,f.n),f.b=m,f.xs0=f.e=D.zOrigin):f.xs0=f.e=E):ha(E+"",D)),o&&(d._transformType=D.svg&&Aa||!n&&3!==this._transformType?2:3),j&&(i[c]=j),k&&(i.scale=k),f},prefix:!0}),ya("boxShadow",{defaultValue:"0px 0px 0px 0px #999",prefix:!0,color:!0,multi:!0,keyword:"inset"}),ya("borderRadius",{defaultValue:"0px",parser:function(a,b,c,f,g,h){b=this.format(b);var i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y=["borderTopLeftRadius","borderTopRightRadius","borderBottomRightRadius","borderBottomLeftRadius"],z=a.style;for(q=parseFloat(a.offsetWidth),r=parseFloat(a.offsetHeight),i=b.split(" "),j=0;j<y.length;j++)this.p.indexOf("border")&&(y[j]=Z(y[j])),m=l=_(a,y[j],e,!1,"0px"),-1!==m.indexOf(" ")&&(l=m.split(" "),m=l[0],l=l[1]),n=k=i[j],o=parseFloat(m),t=m.substr((o+"").length),u="="===n.charAt(1),u?(p=parseInt(n.charAt(0)+"1",10),n=n.substr(2),p*=parseFloat(n),s=n.substr((p+"").length-(0>p?1:0))||""):(p=parseFloat(n),s=n.substr((p+"").length)),""===s&&(s=d[c]||t),s!==t&&(v=aa(a,"borderLeft",o,t),w=aa(a,"borderTop",o,t),"%"===s?(m=v/q*100+"%",l=w/r*100+"%"):"em"===s?(x=aa(a,"borderLeft",1,"em"),m=v/x+"em",l=w/x+"em"):(m=v+"px",l=w+"px"),u&&(n=parseFloat(m)+p+s,k=parseFloat(l)+p+s)),g=va(z,y[j],m+" "+l,n+" "+k,!1,"0px",g);return g},prefix:!0,formatter:qa("0px 0px 0px 0px",!1,!0)}),ya("borderBottomLeftRadius,borderBottomRightRadius,borderTopLeftRadius,borderTopRightRadius",{defaultValue:"0px",parser:function(a,b,c,d,f,g){return va(a.style,c,this.format(_(a,c,e,!1,"0px 0px")),this.format(b),!1,"0px",f)},prefix:!0,formatter:qa("0px 0px",!1,!0)}),ya("backgroundPosition",{defaultValue:"0 0",parser:function(a,b,c,d,f,g){var h,i,j,k,l,m,n="background-position",o=e||$(a,null),q=this.format((o?p?o.getPropertyValue(n+"-x")+" "+o.getPropertyValue(n+"-y"):o.getPropertyValue(n):a.currentStyle.backgroundPositionX+" "+a.currentStyle.backgroundPositionY)||"0 0"),r=this.format(b);if(-1!==q.indexOf("%")!=(-1!==r.indexOf("%"))&&r.split(",").length<2&&(m=_(a,"backgroundImage").replace(D,""),m&&"none"!==m)){for(h=q.split(" "),i=r.split(" "),R.setAttribute("src",m),j=2;--j>-1;)q=h[j],k=-1!==q.indexOf("%"),k!==(-1!==i[j].indexOf("%"))&&(l=0===j?a.offsetWidth-R.width:a.offsetHeight-R.height,h[j]=k?parseFloat(q)/100*l+"px":parseFloat(q)/l*100+"%");q=h.join(" ")}return this.parseComplex(a.style,q,r,f,g)},formatter:ha}),ya("backgroundSize",{defaultValue:"0 0",formatter:function(a){return a+="",ha(-1===a.indexOf(" ")?a+" "+a:a)}}),ya("perspective",{defaultValue:"0px",prefix:!0}),ya("perspectiveOrigin",{defaultValue:"50% 50%",prefix:!0}),ya("transformStyle",{prefix:!0}),ya("backfaceVisibility",{prefix:!0}),ya("userSelect",{prefix:!0}),ya("margin",{parser:ra("marginTop,marginRight,marginBottom,marginLeft")}),ya("padding",{parser:ra("paddingTop,paddingRight,paddingBottom,paddingLeft")}),ya("clip",{defaultValue:"rect(0px,0px,0px,0px)",parser:function(a,b,c,d,f,g){var h,i,j;return 9>p?(i=a.currentStyle,j=8>p?" ":",",h="rect("+i.clipTop+j+i.clipRight+j+i.clipBottom+j+i.clipLeft+")",b=this.format(b).split(",").join(j)):(h=this.format(_(a,this.p,e,!1,this.dflt)),b=this.format(b)),this.parseComplex(a.style,h,b,f,g)}}),ya("textShadow",{defaultValue:"0px 0px 0px #999",color:!0,multi:!0}),ya("autoRound,strictUnits",{parser:function(a,b,c,d,e){return e}}),ya("border",{defaultValue:"0px solid #000",parser:function(a,b,c,d,f,g){var h=_(a,"borderTopWidth",e,!1,"0px"),i=this.format(b).split(" "),j=i[0].replace(w,"");return"px"!==j&&(h=parseFloat(h)/aa(a,"borderTopWidth",1,j)+j),this.parseComplex(a.style,this.format(h+" "+_(a,"borderTopStyle",e,!1,"solid")+" "+_(a,"borderTopColor",e,!1,"#000")),i.join(" "),f,g)},color:!0,formatter:function(a){var b=a.split(" ");return b[0]+" "+(b[1]||"solid")+" "+(a.match(pa)||["#000"])[0]}}),ya("borderWidth",{parser:ra("borderTopWidth,borderRightWidth,borderBottomWidth,borderLeftWidth")}),ya("float,cssFloat,styleFloat",{parser:function(a,b,c,d,e,f){var g=a.style,h="cssFloat"in g?"cssFloat":"styleFloat";return new ta(g,h,0,0,e,-1,c,!1,0,g[h],b)}});var Ua=function(a){var b,c=this.t,d=c.filter||_(this.data,"filter")||"",e=this.s+this.c*a|0;100===e&&(-1===d.indexOf("atrix(")&&-1===d.indexOf("radient(")&&-1===d.indexOf("oader(")?(c.removeAttribute("filter"),b=!_(this.data,"filter")):(c.filter=d.replace(z,""),b=!0)),b||(this.xn1&&(c.filter=d=d||"alpha(opacity="+e+")"),-1===d.indexOf("pacity")?0===e&&this.xn1||(c.filter=d+" alpha(opacity="+e+")"):c.filter=d.replace(x,"opacity="+e))};ya("opacity,alpha,autoAlpha",{defaultValue:"1",parser:function(a,b,c,d,f,g){var h=parseFloat(_(a,"opacity",e,!1,"1")),i=a.style,j="autoAlpha"===c;return"string"==typeof b&&"="===b.charAt(1)&&(b=("-"===b.charAt(0)?-1:1)*parseFloat(b.substr(2))+h),j&&1===h&&"hidden"===_(a,"visibility",e)&&0!==b&&(h=0),U?f=new ta(i,"opacity",h,b-h,f):(f=new ta(i,"opacity",100*h,100*(b-h),f),f.xn1=j?1:0,i.zoom=1,f.type=2,f.b="alpha(opacity="+f.s+")",f.e="alpha(opacity="+(f.s+f.c)+")",f.data=a,f.plugin=g,f.setRatio=Ua),j&&(f=new ta(i,"visibility",0,0,f,-1,null,!1,0,0!==h?"inherit":"hidden",0===b?"hidden":"inherit"),f.xs0="inherit",d._overwriteProps.push(f.n),d._overwriteProps.push(c)),f}});var Va=function(a,b){b&&(a.removeProperty?(("ms"===b.substr(0,2)||"webkit"===b.substr(0,6))&&(b="-"+b),a.removeProperty(b.replace(B,"-$1").toLowerCase())):a.removeAttribute(b))},Wa=function(a){if(this.t._gsClassPT=this,1===a||0===a){this.t.setAttribute("class",0===a?this.b:this.e);for(var b=this.data,c=this.t.style;b;)b.v?c[b.p]=b.v:Va(c,b.p),b=b._next;1===a&&this.t._gsClassPT===this&&(this.t._gsClassPT=null)}else this.t.getAttribute("class")!==this.e&&this.t.setAttribute("class",this.e)};ya("className",{parser:function(a,b,d,f,g,h,i){var j,k,l,m,n,o=a.getAttribute("class")||"",p=a.style.cssText;if(g=f._classNamePT=new ta(a,d,0,0,g,2),g.setRatio=Wa,g.pr=-11,c=!0,g.b=o,k=ca(a,e),l=a._gsClassPT){for(m={},n=l.data;n;)m[n.p]=1,n=n._next;l.setRatio(1)}return a._gsClassPT=g,g.e="="!==b.charAt(1)?b:o.replace(new RegExp("(?:\\s|^)"+b.substr(2)+"(?![\\w-])"),"")+("+"===b.charAt(0)?" "+b.substr(2):""),a.setAttribute("class",g.e),j=da(a,k,ca(a),i,m),a.setAttribute("class",o),g.data=j.firstMPT,a.style.cssText=p,g=g.xfirst=f.parse(a,j.difs,g,h)}});var Xa=function(a){if((1===a||0===a)&&this.data._totalTime===this.data._totalDuration&&"isFromStart"!==this.data.data){var b,c,d,e,f,g=this.t.style,h=i.transform.parse;if("all"===this.e)g.cssText="",e=!0;else for(b=this.e.split(" ").join("").split(","),d=b.length;--d>-1;)c=b[d],i[c]&&(i[c].parse===h?e=!0:c="transformOrigin"===c?Ea:i[c].p),Va(g,c);e&&(Va(g,Ca),f=this.t._gsTransform,f&&(f.svg&&(this.t.removeAttribute("data-svg-origin"),this.t.removeAttribute("transform")),delete this.t._gsTransform))}};for(ya("clearProps",{parser:function(a,b,d,e,f){return f=new ta(a,d,0,0,f,2),f.setRatio=Xa,f.e=b,f.pr=-10,f.data=e._tween,c=!0,f}}),j="bezier,throwProps,physicsProps,physics2D".split(","),wa=j.length;wa--;)za(j[wa]);j=g.prototype,j._firstPT=j._lastParsedTransform=j._transform=null,j._onInitTween=function(a,b,h,j){if(!a.nodeType)return!1;this._target=q=a,this._tween=h,this._vars=b,r=j,k=b.autoRound,c=!1,d=b.suffixMap||g.suffixMap,e=$(a,""),f=this._overwriteProps;var n,p,s,t,u,v,w,x,z,A=a.style;if(l&&""===A.zIndex&&(n=_(a,"zIndex",e),("auto"===n||""===n)&&this._addLazySet(A,"zIndex",0)),"string"==typeof b&&(t=A.cssText,n=ca(a,e),A.cssText=t+";"+b,n=da(a,n,ca(a)).difs,!U&&y.test(b)&&(n.opacity=parseFloat(RegExp.$1)),b=n,A.cssText=t),b.className?this._firstPT=p=i.className.parse(a,b.className,"className",this,null,null,b):this._firstPT=p=this.parse(a,b,null),this._transformType){for(z=3===this._transformType,Ca?m&&(l=!0,""===A.zIndex&&(w=_(a,"zIndex",e),("auto"===w||""===w)&&this._addLazySet(A,"zIndex",0)),o&&this._addLazySet(A,"WebkitBackfaceVisibility",this._vars.WebkitBackfaceVisibility||(z?"visible":"hidden"))):A.zoom=1,s=p;s&&s._next;)s=s._next;x=new ta(a,"transform",0,0,null,2),this._linkCSSP(x,null,s),x.setRatio=Ca?Ta:Sa,x.data=this._transform||Ra(a,e,!0),x.tween=h,x.pr=-1,f.pop()}if(c){for(;p;){for(v=p._next,s=t;s&&s.pr>p.pr;)s=s._next;(p._prev=s?s._prev:u)?p._prev._next=p:t=p,(p._next=s)?s._prev=p:u=p,p=v}this._firstPT=t}return!0},j.parse=function(a,b,c,f){var g,h,j,l,m,n,o,p,s,t,u=a.style;for(g in b){if(n=b[g],"function"==typeof n&&(n=n(r,q)),h=i[g])c=h.parse(a,n,g,this,c,f,b);else{if("--"===g.substr(0,2)){this._tween._propLookup[g]=this._addTween.call(this._tween,a.style,"setProperty",$(a).getPropertyValue(g)+"",n+"",g,!1,g);continue}m=_(a,g,e)+"",s="string"==typeof n,"color"===g||"fill"===g||"stroke"===g||-1!==g.indexOf("Color")||s&&A.test(n)?(s||(n=na(n),n=(n.length>3?"rgba(":"rgb(")+n.join(",")+")"),c=va(u,g,m,n,!0,"transparent",c,0,f)):s&&J.test(n)?c=va(u,g,m,n,!0,null,c,0,f):(j=parseFloat(m),o=j||0===j?m.substr((j+"").length):"",(""===m||"auto"===m)&&("width"===g||"height"===g?(j=ga(a,g,e),o="px"):"left"===g||"top"===g?(j=ba(a,g,e),o="px"):(j="opacity"!==g?0:1,o="")),t=s&&"="===n.charAt(1),t?(l=parseInt(n.charAt(0)+"1",10),n=n.substr(2),l*=parseFloat(n),p=n.replace(w,"")):(l=parseFloat(n),p=s?n.replace(w,""):""),""===p&&(p=g in d?d[g]:o),n=l||0===l?(t?l+j:l)+p:b[g],o!==p&&(""!==p||"lineHeight"===g)&&(l||0===l)&&j&&(j=aa(a,g,j,o),"%"===p?(j/=aa(a,g,100,"%")/100,b.strictUnits!==!0&&(m=j+"%")):"em"===p||"rem"===p||"vw"===p||"vh"===p?j/=aa(a,g,1,p):"px"!==p&&(l=aa(a,g,l,p),p="px"),t&&(l||0===l)&&(n=l+j+p)),t&&(l+=j),!j&&0!==j||!l&&0!==l?void 0!==u[g]&&(n||n+""!="NaN"&&null!=n)?(c=new ta(u,g,l||j||0,0,c,-1,g,!1,0,m,n),c.xs0="none"!==n||"display"!==g&&-1===g.indexOf("Style")?n:m):W("invalid "+g+" tween value: "+b[g]):(c=new ta(u,g,j,l-j,c,0,g,k!==!1&&("px"===p||"zIndex"===g),0,m,n),c.xs0=p))}f&&c&&!c.plugin&&(c.plugin=f)}return c},j.setRatio=function(a){var b,c,d,e=this._firstPT,f=1e-6;if(1!==a||this._tween._time!==this._tween._duration&&0!==this._tween._time)if(a||this._tween._time!==this._tween._duration&&0!==this._tween._time||this._tween._rawPrevTime===-1e-6)for(;e;){if(b=e.c*a+e.s,e.r?b=Math.round(b):f>b&&b>-f&&(b=0),e.type)if(1===e.type)if(d=e.l,2===d)e.t[e.p]=e.xs0+b+e.xs1+e.xn1+e.xs2;else if(3===d)e.t[e.p]=e.xs0+b+e.xs1+e.xn1+e.xs2+e.xn2+e.xs3;else if(4===d)e.t[e.p]=e.xs0+b+e.xs1+e.xn1+e.xs2+e.xn2+e.xs3+e.xn3+e.xs4;else if(5===d)e.t[e.p]=e.xs0+b+e.xs1+e.xn1+e.xs2+e.xn2+e.xs3+e.xn3+e.xs4+e.xn4+e.xs5;else{for(c=e.xs0+b+e.xs1,d=1;d<e.l;d++)c+=e["xn"+d]+e["xs"+(d+1)];e.t[e.p]=c}else-1===e.type?e.t[e.p]=e.xs0:e.setRatio&&e.setRatio(a);else e.t[e.p]=b+e.xs0;e=e._next}else for(;e;)2!==e.type?e.t[e.p]=e.b:e.setRatio(a),e=e._next;else for(;e;){if(2!==e.type)if(e.r&&-1!==e.type)if(b=Math.round(e.s+e.c),e.type){if(1===e.type){for(d=e.l,c=e.xs0+b+e.xs1,d=1;d<e.l;d++)c+=e["xn"+d]+e["xs"+(d+1)];e.t[e.p]=c}}else e.t[e.p]=b+e.xs0;else e.t[e.p]=e.e;else e.setRatio(a);e=e._next}},j._enableTransforms=function(a){this._transform=this._transform||Ra(this._target,e,!0),this._transformType=this._transform.svg&&Aa||!a&&3!==this._transformType?2:3};var Ya=function(a){this.t[this.p]=this.e,this.data._linkCSSP(this,this._next,null,!0)};j._addLazySet=function(a,b,c){var d=this._firstPT=new ta(a,b,0,0,this._firstPT,2);d.e=c,d.setRatio=Ya,d.data=this},j._linkCSSP=function(a,b,c,d){return a&&(b&&(b._prev=a),a._next&&(a._next._prev=a._prev),a._prev?a._prev._next=a._next:this._firstPT===a&&(this._firstPT=a._next,d=!0),c?c._next=a:d||null!==this._firstPT||(this._firstPT=a),a._next=b,a._prev=c),a},j._mod=function(a){for(var b=this._firstPT;b;)"function"==typeof a[b.p]&&a[b.p]===Math.round&&(b.r=1),b=b._next},j._kill=function(b){var c,d,e,f=b;if(b.autoAlpha||b.alpha){f={};for(d in b)f[d]=b[d];f.opacity=1,f.autoAlpha&&(f.visibility=1)}for(b.className&&(c=this._classNamePT)&&(e=c.xfirst,e&&e._prev?this._linkCSSP(e._prev,c._next,e._prev._prev):e===this._firstPT&&(this._firstPT=c._next),c._next&&this._linkCSSP(c._next,c._next._next,e._prev),this._classNamePT=null),c=this._firstPT;c;)c.plugin&&c.plugin!==d&&c.plugin._kill&&(c.plugin._kill(b),d=c.plugin),c=c._next;return a.prototype._kill.call(this,f)};var Za=function(a,b,c){var d,e,f,g;if(a.slice)for(e=a.length;--e>-1;)Za(a[e],b,c);else for(d=a.childNodes,e=d.length;--e>-1;)f=d[e],g=f.type,f.style&&(b.push(ca(f)),c&&c.push(f)),1!==g&&9!==g&&11!==g||!f.childNodes.length||Za(f,b,c)};return g.cascadeTo=function(a,c,d){var e,f,g,h,i=b.to(a,c,d),j=[i],k=[],l=[],m=[],n=b._internals.reservedProps;for(a=i._targets||i.target,Za(a,k,m),i.render(c,!0,!0),Za(a,l),i.render(0,!0,!0),i._enabled(!0),e=m.length;--e>-1;)if(f=da(m[e],k[e],l[e]),f.firstMPT){f=f.difs;for(g in d)n[g]&&(f[g]=d[g]);h={};for(g in f)h[g]=k[e][g];j.push(b.fromTo(m[e],c,h,f))}return j},a.activate([g]),g},!0),function(){var a=_gsScope._gsDefine.plugin({propName:"roundProps",version:"1.6.0",priority:-1,API:2,init:function(a,b,c){return this._tween=c,!0}}),b=function(a){for(;a;)a.f||a.blob||(a.m=Math.round),a=a._next},c=a.prototype;c._onInitAllProps=function(){for(var a,c,d,e=this._tween,f=e.vars.roundProps.join?e.vars.roundProps:e.vars.roundProps.split(","),g=f.length,h={},i=e._propLookup.roundProps;--g>-1;)h[f[g]]=Math.round;for(g=f.length;--g>-1;)for(a=f[g],c=e._firstPT;c;)d=c._next,c.pg?c.t._mod(h):c.n===a&&(2===c.f&&c.t?b(c.t._firstPT):(this._add(c.t,a,c.s,c.c),d&&(d._prev=c._prev),c._prev?c._prev._next=d:e._firstPT===c&&(e._firstPT=d),c._next=c._prev=null,e._propLookup[a]=i)),c=d;return!1},c._add=function(a,b,c,d){this._addTween(a,b,c,c+d,b,Math.round),this._overwriteProps.push(b)}}(),function(){_gsScope._gsDefine.plugin({propName:"attr",API:2,version:"0.6.1",init:function(a,b,c,d){var e,f;if("function"!=typeof a.setAttribute)return!1;for(e in b)f=b[e],"function"==typeof f&&(f=f(d,a)),this._addTween(a,"setAttribute",a.getAttribute(e)+"",f+"",e,!1,e),this._overwriteProps.push(e);return!0}})}(),_gsScope._gsDefine.plugin({propName:"directionalRotation",version:"0.3.1",API:2,init:function(a,b,c,d){"object"!=typeof b&&(b={rotation:b}),this.finals={};var e,f,g,h,i,j,k=b.useRadians===!0?2*Math.PI:360,l=1e-6;for(e in b)"useRadians"!==e&&(h=b[e],"function"==typeof h&&(h=h(d,a)),j=(h+"").split("_"),f=j[0],g=parseFloat("function"!=typeof a[e]?a[e]:a[e.indexOf("set")||"function"!=typeof a["get"+e.substr(3)]?e:"get"+e.substr(3)]()),h=this.finals[e]="string"==typeof f&&"="===f.charAt(1)?g+parseInt(f.charAt(0)+"1",10)*Number(f.substr(2)):Number(f)||0,i=h-g,j.length&&(f=j.join("_"),-1!==f.indexOf("short")&&(i%=k,i!==i%(k/2)&&(i=0>i?i+k:i-k)),-1!==f.indexOf("_cw")&&0>i?i=(i+9999999999*k)%k-(i/k|0)*k:-1!==f.indexOf("ccw")&&i>0&&(i=(i-9999999999*k)%k-(i/k|0)*k)),(i>l||-l>i)&&(this._addTween(a,e,g,g+i,e),this._overwriteProps.push(e)));return!0},set:function(a){var b;if(1!==a)this._super.setRatio.call(this,a);else for(b=this._firstPT;b;)b.f?b.t[b.p](this.finals[b.p]):b.t[b.p]=this.finals[b.p],b=b._next}})._autoCSS=!0,_gsScope._gsDefine("easing.Back",["easing.Ease"],function(a){var b,c,d,e=_gsScope.GreenSockGlobals||_gsScope,f=e.com.greensock,g=2*Math.PI,h=Math.PI/2,i=f._class,j=function(b,c){var d=i("easing."+b,function(){},!0),e=d.prototype=new a;return e.constructor=d,e.getRatio=c,d},k=a.register||function(){},l=function(a,b,c,d,e){var f=i("easing."+a,{easeOut:new b,easeIn:new c,easeInOut:new d},!0);return k(f,a),f},m=function(a,b,c){this.t=a,this.v=b,c&&(this.next=c,c.prev=this,this.c=c.v-b,this.gap=c.t-a)},n=function(b,c){var d=i("easing."+b,function(a){this._p1=a||0===a?a:1.70158,this._p2=1.525*this._p1},!0),e=d.prototype=new a;return e.constructor=d,e.getRatio=c,e.config=function(a){return new d(a)},d},o=l("Back",n("BackOut",function(a){return(a-=1)*a*((this._p1+1)*a+this._p1)+1}),n("BackIn",function(a){return a*a*((this._p1+1)*a-this._p1)}),n("BackInOut",function(a){return(a*=2)<1?.5*a*a*((this._p2+1)*a-this._p2):.5*((a-=2)*a*((this._p2+1)*a+this._p2)+2)})),p=i("easing.SlowMo",function(a,b,c){b=b||0===b?b:.7,null==a?a=.7:a>1&&(a=1),this._p=1!==a?b:0,this._p1=(1-a)/2,this._p2=a,this._p3=this._p1+this._p2,this._calcEnd=c===!0},!0),q=p.prototype=new a;return q.constructor=p,q.getRatio=function(a){var b=a+(.5-a)*this._p;return a<this._p1?this._calcEnd?1-(a=1-a/this._p1)*a:b-(a=1-a/this._p1)*a*a*a*b:a>this._p3?this._calcEnd?1===a?0:1-(a=(a-this._p3)/this._p1)*a:b+(a-b)*(a=(a-this._p3)/this._p1)*a*a*a:this._calcEnd?1:b},p.ease=new p(.7,.7),q.config=p.config=function(a,b,c){return new p(a,b,c)},b=i("easing.SteppedEase",function(a,b){a=a||1,this._p1=1/a,this._p2=a+(b?0:1),this._p3=b?1:0},!0),q=b.prototype=new a,q.constructor=b,q.getRatio=function(a){return 0>a?a=0:a>=1&&(a=.999999999),((this._p2*a|0)+this._p3)*this._p1},q.config=b.config=function(a,c){return new b(a,c)},c=i("easing.RoughEase",function(b){b=b||{};for(var c,d,e,f,g,h,i=b.taper||"none",j=[],k=0,l=0|(b.points||20),n=l,o=b.randomize!==!1,p=b.clamp===!0,q=b.template instanceof a?b.template:null,r="number"==typeof b.strength?.4*b.strength:.4;--n>-1;)c=o?Math.random():1/l*n,d=q?q.getRatio(c):c,"none"===i?e=r:"out"===i?(f=1-c,e=f*f*r):"in"===i?e=c*c*r:.5>c?(f=2*c,e=f*f*.5*r):(f=2*(1-c),e=f*f*.5*r),o?d+=Math.random()*e-.5*e:n%2?d+=.5*e:d-=.5*e,p&&(d>1?d=1:0>d&&(d=0)),j[k++]={x:c,y:d};for(j.sort(function(a,b){return a.x-b.x}),h=new m(1,1,null),n=l;--n>-1;)g=j[n],h=new m(g.x,g.y,h);this._prev=new m(0,0,0!==h.t?h:h.next)},!0),q=c.prototype=new a,q.constructor=c,q.getRatio=function(a){var b=this._prev;if(a>b.t){for(;b.next&&a>=b.t;)b=b.next;b=b.prev}else for(;b.prev&&a<=b.t;)b=b.prev;return this._prev=b,b.v+(a-b.t)/b.gap*b.c},q.config=function(a){return new c(a)},c.ease=new c,l("Bounce",j("BounceOut",function(a){return 1/2.75>a?7.5625*a*a:2/2.75>a?7.5625*(a-=1.5/2.75)*a+.75:2.5/2.75>a?7.5625*(a-=2.25/2.75)*a+.9375:7.5625*(a-=2.625/2.75)*a+.984375}),j("BounceIn",function(a){return(a=1-a)<1/2.75?1-7.5625*a*a:2/2.75>a?1-(7.5625*(a-=1.5/2.75)*a+.75):2.5/2.75>a?1-(7.5625*(a-=2.25/2.75)*a+.9375):1-(7.5625*(a-=2.625/2.75)*a+.984375)}),j("BounceInOut",function(a){var b=.5>a;return a=b?1-2*a:2*a-1,a=1/2.75>a?7.5625*a*a:2/2.75>a?7.5625*(a-=1.5/2.75)*a+.75:2.5/2.75>a?7.5625*(a-=2.25/2.75)*a+.9375:7.5625*(a-=2.625/2.75)*a+.984375,b?.5*(1-a):.5*a+.5})),l("Circ",j("CircOut",function(a){return Math.sqrt(1-(a-=1)*a)}),j("CircIn",function(a){return-(Math.sqrt(1-a*a)-1)}),j("CircInOut",function(a){return(a*=2)<1?-.5*(Math.sqrt(1-a*a)-1):.5*(Math.sqrt(1-(a-=2)*a)+1)})),d=function(b,c,d){var e=i("easing."+b,function(a,b){this._p1=a>=1?a:1,this._p2=(b||d)/(1>a?a:1),this._p3=this._p2/g*(Math.asin(1/this._p1)||0),this._p2=g/this._p2},!0),f=e.prototype=new a;return f.constructor=e,f.getRatio=c,f.config=function(a,b){return new e(a,b)},e},l("Elastic",d("ElasticOut",function(a){return this._p1*Math.pow(2,-10*a)*Math.sin((a-this._p3)*this._p2)+1},.3),d("ElasticIn",function(a){return-(this._p1*Math.pow(2,10*(a-=1))*Math.sin((a-this._p3)*this._p2))},.3),d("ElasticInOut",function(a){return(a*=2)<1?-.5*(this._p1*Math.pow(2,10*(a-=1))*Math.sin((a-this._p3)*this._p2)):this._p1*Math.pow(2,-10*(a-=1))*Math.sin((a-this._p3)*this._p2)*.5+1},.45)),l("Expo",j("ExpoOut",function(a){return 1-Math.pow(2,-10*a)}),j("ExpoIn",function(a){return Math.pow(2,10*(a-1))-.001}),j("ExpoInOut",function(a){return(a*=2)<1?.5*Math.pow(2,10*(a-1)):.5*(2-Math.pow(2,-10*(a-1)))})),l("Sine",j("SineOut",function(a){return Math.sin(a*h)}),j("SineIn",function(a){return-Math.cos(a*h)+1}),j("SineInOut",function(a){return-.5*(Math.cos(Math.PI*a)-1)})),i("easing.EaseLookup",{find:function(b){return a.map[b]}},!0),k(e.SlowMo,"SlowMo","ease,"),k(c,"RoughEase","ease,"),k(b,"SteppedEase","ease,"),o},!0)}),_gsScope._gsDefine&&_gsScope._gsQueue.pop()(),function(a,b){"use strict";var c={},d=a.document,e=a.GreenSockGlobals=a.GreenSockGlobals||a;if(!e.TweenLite){var f,g,h,i,j,k=function(a){var b,c=a.split("."),d=e;for(b=0;b<c.length;b++)d[c[b]]=d=d[c[b]]||{};return d},l=k("com.greensock"),m=1e-10,n=function(a){var b,c=[],d=a.length;for(b=0;b!==d;c.push(a[b++]));return c},o=function(){},p=function(){var a=Object.prototype.toString,b=a.call([]);return function(c){return null!=c&&(c instanceof Array||"object"==typeof c&&!!c.push&&a.call(c)===b)}}(),q={},r=function(d,f,g,h){this.sc=q[d]?q[d].sc:[],q[d]=this,this.gsClass=null,this.func=g;var i=[];this.check=function(j){for(var l,m,n,o,p=f.length,s=p;--p>-1;)(l=q[f[p]]||new r(f[p],[])).gsClass?(i[p]=l.gsClass,s--):j&&l.sc.push(this);if(0===s&&g){if(m=("com.greensock."+d).split("."),n=m.pop(),o=k(m.join("."))[n]=this.gsClass=g.apply(g,i),h)if(e[n]=c[n]=o,"undefined"!=typeof module&&module.exports)if(d===b){module.exports=c[b]=o;for(p in c)o[p]=c[p]}else c[b]&&(c[b][n]=o);else"function"==typeof define&&define.amd&&define((a.GreenSockAMDPath?a.GreenSockAMDPath+"/":"")+d.split(".").pop(),[],function(){return o});for(p=0;p<this.sc.length;p++)this.sc[p].check()}},this.check(!0)},s=a._gsDefine=function(a,b,c,d){return new r(a,b,c,d)},t=l._class=function(a,b,c){return b=b||function(){},s(a,[],function(){return b},c),b};s.globals=e;var u=[0,0,1,1],v=t("easing.Ease",function(a,b,c,d){this._func=a,this._type=c||0,this._power=d||0,this._params=b?u.concat(b):u},!0),w=v.map={},x=v.register=function(a,b,c,d){for(var e,f,g,h,i=b.split(","),j=i.length,k=(c||"easeIn,easeOut,easeInOut").split(",");--j>-1;)for(f=i[j],e=d?t("easing."+f,null,!0):l.easing[f]||{},g=k.length;--g>-1;)h=k[g],w[f+"."+h]=w[h+f]=e[h]=a.getRatio?a:a[h]||new a};for(h=v.prototype,h._calcEnd=!1,h.getRatio=function(a){if(this._func)return this._params[0]=a,this._func.apply(null,this._params);var b=this._type,c=this._power,d=1===b?1-a:2===b?a:.5>a?2*a:2*(1-a);return 1===c?d*=d:2===c?d*=d*d:3===c?d*=d*d*d:4===c&&(d*=d*d*d*d),1===b?1-d:2===b?d:.5>a?d/2:1-d/2},f=["Linear","Quad","Cubic","Quart","Quint,Strong"],g=f.length;--g>-1;)h=f[g]+",Power"+g,x(new v(null,null,1,g),h,"easeOut",!0),x(new v(null,null,2,g),h,"easeIn"+(0===g?",easeNone":"")),x(new v(null,null,3,g),h,"easeInOut");w.linear=l.easing.Linear.easeIn,w.swing=l.easing.Quad.easeInOut;var y=t("events.EventDispatcher",function(a){this._listeners={},this._eventTarget=a||this});h=y.prototype,h.addEventListener=function(a,b,c,d,e){e=e||0;var f,g,h=this._listeners[a],k=0;for(this!==i||j||i.wake(),null==h&&(this._listeners[a]=h=[]),g=h.length;--g>-1;)f=h[g],f.c===b&&f.s===c?h.splice(g,1):0===k&&f.pr<e&&(k=g+1);h.splice(k,0,{c:b,s:c,up:d,pr:e})},h.removeEventListener=function(a,b){var c,d=this._listeners[a];if(d)for(c=d.length;--c>-1;)if(d[c].c===b)return void d.splice(c,1)},h.dispatchEvent=function(a){var b,c,d,e=this._listeners[a];if(e)for(b=e.length,b>1&&(e=e.slice(0)),c=this._eventTarget;--b>-1;)d=e[b],d&&(d.up?d.c.call(d.s||c,{type:a,target:c}):d.c.call(d.s||c))};var z=a.requestAnimationFrame,A=a.cancelAnimationFrame,B=Date.now||function(){return(new Date).getTime()},C=B();for(f=["ms","moz","webkit","o"],g=f.length;--g>-1&&!z;)z=a[f[g]+"RequestAnimationFrame"],A=a[f[g]+"CancelAnimationFrame"]||a[f[g]+"CancelRequestAnimationFrame"];t("Ticker",function(a,b){var c,e,f,g,h,k=this,l=B(),n=b!==!1&&z?"auto":!1,p=500,q=33,r="tick",s=function(a){var b,d,i=B()-C;i>p&&(l+=i-q),C+=i,k.time=(C-l)/1e3,b=k.time-h,(!c||b>0||a===!0)&&(k.frame++,h+=b+(b>=g?.004:g-b),d=!0),a!==!0&&(f=e(s)),d&&k.dispatchEvent(r)};y.call(k),k.time=k.frame=0,k.tick=function(){s(!0)},k.lagSmoothing=function(a,b){return arguments.length?(p=a||1/m,void(q=Math.min(b,p,0))):1/m>p},k.sleep=function(){null!=f&&(n&&A?A(f):clearTimeout(f),e=o,f=null,k===i&&(j=!1))},k.wake=function(a){null!==f?k.sleep():a?l+=-C+(C=B()):k.frame>10&&(C=B()-p+5),e=0===c?o:n&&z?z:function(a){return setTimeout(a,1e3*(h-k.time)+1|0)},k===i&&(j=!0),s(2)},k.fps=function(a){return arguments.length?(c=a,g=1/(c||60),h=this.time+g,void k.wake()):c},k.useRAF=function(a){return arguments.length?(k.sleep(),n=a,void k.fps(c)):n},k.fps(a),setTimeout(function(){"auto"===n&&k.frame<5&&"hidden"!==d.visibilityState&&k.useRAF(!1)},1500)}),h=l.Ticker.prototype=new l.events.EventDispatcher,h.constructor=l.Ticker;var D=t("core.Animation",function(a,b){if(this.vars=b=b||{},this._duration=this._totalDuration=a||0,this._delay=Number(b.delay)||0,this._timeScale=1,this._active=b.immediateRender===!0,this.data=b.data,this._reversed=b.reversed===!0,X){j||i.wake();var c=this.vars.useFrames?W:X;c.add(this,c._time),this.vars.paused&&this.paused(!0)}});i=D.ticker=new l.Ticker,h=D.prototype,h._dirty=h._gc=h._initted=h._paused=!1,h._totalTime=h._time=0,h._rawPrevTime=-1,h._next=h._last=h._onUpdate=h._timeline=h.timeline=null,h._paused=!1;var E=function(){j&&B()-C>2e3&&("hidden"!==d.visibilityState||!i.lagSmoothing())&&i.wake();var a=setTimeout(E,2e3);a.unref&&a.unref()};E(),h.play=function(a,b){return null!=a&&this.seek(a,b),this.reversed(!1).paused(!1)},h.pause=function(a,b){return null!=a&&this.seek(a,b),this.paused(!0)},h.resume=function(a,b){return null!=a&&this.seek(a,b),this.paused(!1)},h.seek=function(a,b){return this.totalTime(Number(a),b!==!1)},h.restart=function(a,b){return this.reversed(!1).paused(!1).totalTime(a?-this._delay:0,b!==!1,!0)},h.reverse=function(a,b){return null!=a&&this.seek(a||this.totalDuration(),b),this.reversed(!0).paused(!1)},h.render=function(a,b,c){},h.invalidate=function(){return this._time=this._totalTime=0,this._initted=this._gc=!1,this._rawPrevTime=-1,(this._gc||!this.timeline)&&this._enabled(!0),this},h.isActive=function(){var a,b=this._timeline,c=this._startTime;return!b||!this._gc&&!this._paused&&b.isActive()&&(a=b.rawTime(!0))>=c&&a<c+this.totalDuration()/this._timeScale-1e-7},h._enabled=function(a,b){return j||i.wake(),this._gc=!a,this._active=this.isActive(),b!==!0&&(a&&!this.timeline?this._timeline.add(this,this._startTime-this._delay):!a&&this.timeline&&this._timeline._remove(this,!0)),!1},h._kill=function(a,b){return this._enabled(!1,!1)},h.kill=function(a,b){return this._kill(a,b),this},h._uncache=function(a){for(var b=a?this:this.timeline;b;)b._dirty=!0,b=b.timeline;return this},h._swapSelfInParams=function(a){for(var b=a.length,c=a.concat();--b>-1;)"{self}"===a[b]&&(c[b]=this);return c},h._callback=function(a){var b=this.vars,c=b[a],d=b[a+"Params"],e=b[a+"Scope"]||b.callbackScope||this,f=d?d.length:0;switch(f){case 0:c.call(e);break;case 1:c.call(e,d[0]);break;case 2:c.call(e,d[0],d[1]);break;default:c.apply(e,d)}},h.eventCallback=function(a,b,c,d){if("on"===(a||"").substr(0,2)){var e=this.vars;if(1===arguments.length)return e[a];null==b?delete e[a]:(e[a]=b,e[a+"Params"]=p(c)&&-1!==c.join("").indexOf("{self}")?this._swapSelfInParams(c):c,e[a+"Scope"]=d),"onUpdate"===a&&(this._onUpdate=b)}return this},h.delay=function(a){return arguments.length?(this._timeline.smoothChildTiming&&this.startTime(this._startTime+a-this._delay),this._delay=a,this):this._delay},h.duration=function(a){return arguments.length?(this._duration=this._totalDuration=a,this._uncache(!0),this._timeline.smoothChildTiming&&this._time>0&&this._time<this._duration&&0!==a&&this.totalTime(this._totalTime*(a/this._duration),!0),this):(this._dirty=!1,this._duration)},h.totalDuration=function(a){return this._dirty=!1,arguments.length?this.duration(a):this._totalDuration},h.time=function(a,b){return arguments.length?(this._dirty&&this.totalDuration(),this.totalTime(a>this._duration?this._duration:a,b)):this._time},h.totalTime=function(a,b,c){if(j||i.wake(),!arguments.length)return this._totalTime;if(this._timeline){if(0>a&&!c&&(a+=this.totalDuration()),this._timeline.smoothChildTiming){this._dirty&&this.totalDuration();var d=this._totalDuration,e=this._timeline;if(a>d&&!c&&(a=d),this._startTime=(this._paused?this._pauseTime:e._time)-(this._reversed?d-a:a)/this._timeScale,e._dirty||this._uncache(!1),e._timeline)for(;e._timeline;)e._timeline._time!==(e._startTime+e._totalTime)/e._timeScale&&e.totalTime(e._totalTime,!0),e=e._timeline}this._gc&&this._enabled(!0,!1),(this._totalTime!==a||0===this._duration)&&(J.length&&Z(),this.render(a,b,!1),J.length&&Z())}return this},h.progress=h.totalProgress=function(a,b){var c=this.duration();return arguments.length?this.totalTime(c*a,b):c?this._time/c:this.ratio},h.startTime=function(a){return arguments.length?(a!==this._startTime&&(this._startTime=a,this.timeline&&this.timeline._sortChildren&&this.timeline.add(this,a-this._delay)),this):this._startTime},h.endTime=function(a){return this._startTime+(0!=a?this.totalDuration():this.duration())/this._timeScale},h.timeScale=function(a){if(!arguments.length)return this._timeScale;var b,c;for(a=a||m,this._timeline&&this._timeline.smoothChildTiming&&(b=this._pauseTime,c=b||0===b?b:this._timeline.totalTime(),this._startTime=c-(c-this._startTime)*this._timeScale/a),this._timeScale=a,c=this.timeline;c&&c.timeline;)c._dirty=!0,c.totalDuration(),c=c.timeline;return this},h.reversed=function(a){return arguments.length?(a!=this._reversed&&(this._reversed=a,this.totalTime(this._timeline&&!this._timeline.smoothChildTiming?this.totalDuration()-this._totalTime:this._totalTime,!0)),this):this._reversed},h.paused=function(a){if(!arguments.length)return this._paused;var b,c,d=this._timeline;return a!=this._paused&&d&&(j||a||i.wake(),b=d.rawTime(),c=b-this._pauseTime,!a&&d.smoothChildTiming&&(this._startTime+=c,
this._uncache(!1)),this._pauseTime=a?b:null,this._paused=a,this._active=this.isActive(),!a&&0!==c&&this._initted&&this.duration()&&(b=d.smoothChildTiming?this._totalTime:(b-this._startTime)/this._timeScale,this.render(b,b===this._totalTime,!0))),this._gc&&!a&&this._enabled(!0,!1),this};var F=t("core.SimpleTimeline",function(a){D.call(this,0,a),this.autoRemoveChildren=this.smoothChildTiming=!0});h=F.prototype=new D,h.constructor=F,h.kill()._gc=!1,h._first=h._last=h._recent=null,h._sortChildren=!1,h.add=h.insert=function(a,b,c,d){var e,f;if(a._startTime=Number(b||0)+a._delay,a._paused&&this!==a._timeline&&(a._pauseTime=a._startTime+(this.rawTime()-a._startTime)/a._timeScale),a.timeline&&a.timeline._remove(a,!0),a.timeline=a._timeline=this,a._gc&&a._enabled(!0,!0),e=this._last,this._sortChildren)for(f=a._startTime;e&&e._startTime>f;)e=e._prev;return e?(a._next=e._next,e._next=a):(a._next=this._first,this._first=a),a._next?a._next._prev=a:this._last=a,a._prev=e,this._recent=a,this._timeline&&this._uncache(!0),this},h._remove=function(a,b){return a.timeline===this&&(b||a._enabled(!1,!0),a._prev?a._prev._next=a._next:this._first===a&&(this._first=a._next),a._next?a._next._prev=a._prev:this._last===a&&(this._last=a._prev),a._next=a._prev=a.timeline=null,a===this._recent&&(this._recent=this._last),this._timeline&&this._uncache(!0)),this},h.render=function(a,b,c){var d,e=this._first;for(this._totalTime=this._time=this._rawPrevTime=a;e;)d=e._next,(e._active||a>=e._startTime&&!e._paused&&!e._gc)&&(e._reversed?e.render((e._dirty?e.totalDuration():e._totalDuration)-(a-e._startTime)*e._timeScale,b,c):e.render((a-e._startTime)*e._timeScale,b,c)),e=d},h.rawTime=function(){return j||i.wake(),this._totalTime};var G=t("TweenLite",function(b,c,d){if(D.call(this,c,d),this.render=G.prototype.render,null==b)throw"Cannot tween a null target.";this.target=b="string"!=typeof b?b:G.selector(b)||b;var e,f,g,h=b.jquery||b.length&&b!==a&&b[0]&&(b[0]===a||b[0].nodeType&&b[0].style&&!b.nodeType),i=this.vars.overwrite;if(this._overwrite=i=null==i?V[G.defaultOverwrite]:"number"==typeof i?i>>0:V[i],(h||b instanceof Array||b.push&&p(b))&&"number"!=typeof b[0])for(this._targets=g=n(b),this._propLookup=[],this._siblings=[],e=0;e<g.length;e++)f=g[e],f?"string"!=typeof f?f.length&&f!==a&&f[0]&&(f[0]===a||f[0].nodeType&&f[0].style&&!f.nodeType)?(g.splice(e--,1),this._targets=g=g.concat(n(f))):(this._siblings[e]=$(f,this,!1),1===i&&this._siblings[e].length>1&&aa(f,this,null,1,this._siblings[e])):(f=g[e--]=G.selector(f),"string"==typeof f&&g.splice(e+1,1)):g.splice(e--,1);else this._propLookup={},this._siblings=$(b,this,!1),1===i&&this._siblings.length>1&&aa(b,this,null,1,this._siblings);(this.vars.immediateRender||0===c&&0===this._delay&&this.vars.immediateRender!==!1)&&(this._time=-m,this.render(Math.min(0,-this._delay)))},!0),H=function(b){return b&&b.length&&b!==a&&b[0]&&(b[0]===a||b[0].nodeType&&b[0].style&&!b.nodeType)},I=function(a,b){var c,d={};for(c in a)U[c]||c in b&&"transform"!==c&&"x"!==c&&"y"!==c&&"width"!==c&&"height"!==c&&"className"!==c&&"border"!==c||!(!R[c]||R[c]&&R[c]._autoCSS)||(d[c]=a[c],delete a[c]);a.css=d};h=G.prototype=new D,h.constructor=G,h.kill()._gc=!1,h.ratio=0,h._firstPT=h._targets=h._overwrittenProps=h._startAt=null,h._notifyPluginsOfEnabled=h._lazy=!1,G.version="1.20.3",G.defaultEase=h._ease=new v(null,null,1,1),G.defaultOverwrite="auto",G.ticker=i,G.autoSleep=120,G.lagSmoothing=function(a,b){i.lagSmoothing(a,b)},G.selector=a.$||a.jQuery||function(b){var c=a.$||a.jQuery;return c?(G.selector=c,c(b)):"undefined"==typeof d?b:d.querySelectorAll?d.querySelectorAll(b):d.getElementById("#"===b.charAt(0)?b.substr(1):b)};var J=[],K={},L=/(?:(-|-=|\+=)?\d*\.?\d*(?:e[\-+]?\d+)?)[0-9]/gi,M=/[\+-]=-?[\.\d]/,N=function(a){for(var b,c=this._firstPT,d=1e-6;c;)b=c.blob?1===a&&null!=this.end?this.end:a?this.join(""):this.start:c.c*a+c.s,c.m?b=c.m(b,this._target||c.t):d>b&&b>-d&&!c.blob&&(b=0),c.f?c.fp?c.t[c.p](c.fp,b):c.t[c.p](b):c.t[c.p]=b,c=c._next},O=function(a,b,c,d){var e,f,g,h,i,j,k,l=[],m=0,n="",o=0;for(l.start=a,l.end=b,a=l[0]=a+"",b=l[1]=b+"",c&&(c(l),a=l[0],b=l[1]),l.length=0,e=a.match(L)||[],f=b.match(L)||[],d&&(d._next=null,d.blob=1,l._firstPT=l._applyPT=d),i=f.length,h=0;i>h;h++)k=f[h],j=b.substr(m,b.indexOf(k,m)-m),n+=j||!h?j:",",m+=j.length,o?o=(o+1)%5:"rgba("===j.substr(-5)&&(o=1),k===e[h]||e.length<=h?n+=k:(n&&(l.push(n),n=""),g=parseFloat(e[h]),l.push(g),l._firstPT={_next:l._firstPT,t:l,p:l.length-1,s:g,c:("="===k.charAt(1)?parseInt(k.charAt(0)+"1",10)*parseFloat(k.substr(2)):parseFloat(k)-g)||0,f:0,m:o&&4>o?Math.round:0}),m+=k.length;return n+=b.substr(m),n&&l.push(n),l.setRatio=N,M.test(b)&&(l.end=null),l},P=function(a,b,c,d,e,f,g,h,i){"function"==typeof d&&(d=d(i||0,a));var j,k=typeof a[b],l="function"!==k?"":b.indexOf("set")||"function"!=typeof a["get"+b.substr(3)]?b:"get"+b.substr(3),m="get"!==c?c:l?g?a[l](g):a[l]():a[b],n="string"==typeof d&&"="===d.charAt(1),o={t:a,p:b,s:m,f:"function"===k,pg:0,n:e||b,m:f?"function"==typeof f?f:Math.round:0,pr:0,c:n?parseInt(d.charAt(0)+"1",10)*parseFloat(d.substr(2)):parseFloat(d)-m||0};return("number"!=typeof m||"number"!=typeof d&&!n)&&(g||isNaN(m)||!n&&isNaN(d)||"boolean"==typeof m||"boolean"==typeof d?(o.fp=g,j=O(m,n?parseFloat(o.s)+o.c:d,h||G.defaultStringFilter,o),o={t:j,p:"setRatio",s:0,c:1,f:2,pg:0,n:e||b,pr:0,m:0}):(o.s=parseFloat(m),n||(o.c=parseFloat(d)-o.s||0))),o.c?((o._next=this._firstPT)&&(o._next._prev=o),this._firstPT=o,o):void 0},Q=G._internals={isArray:p,isSelector:H,lazyTweens:J,blobDif:O},R=G._plugins={},S=Q.tweenLookup={},T=0,U=Q.reservedProps={ease:1,delay:1,overwrite:1,onComplete:1,onCompleteParams:1,onCompleteScope:1,useFrames:1,runBackwards:1,startAt:1,onUpdate:1,onUpdateParams:1,onUpdateScope:1,onStart:1,onStartParams:1,onStartScope:1,onReverseComplete:1,onReverseCompleteParams:1,onReverseCompleteScope:1,onRepeat:1,onRepeatParams:1,onRepeatScope:1,easeParams:1,yoyo:1,immediateRender:1,repeat:1,repeatDelay:1,data:1,paused:1,reversed:1,autoCSS:1,lazy:1,onOverwrite:1,callbackScope:1,stringFilter:1,id:1,yoyoEase:1},V={none:0,all:1,auto:2,concurrent:3,allOnStart:4,preexisting:5,"true":1,"false":0},W=D._rootFramesTimeline=new F,X=D._rootTimeline=new F,Y=30,Z=Q.lazyRender=function(){var a,b=J.length;for(K={};--b>-1;)a=J[b],a&&a._lazy!==!1&&(a.render(a._lazy[0],a._lazy[1],!0),a._lazy=!1);J.length=0};X._startTime=i.time,W._startTime=i.frame,X._active=W._active=!0,setTimeout(Z,1),D._updateRoot=G.render=function(){var a,b,c;if(J.length&&Z(),X.render((i.time-X._startTime)*X._timeScale,!1,!1),W.render((i.frame-W._startTime)*W._timeScale,!1,!1),J.length&&Z(),i.frame>=Y){Y=i.frame+(parseInt(G.autoSleep,10)||120);for(c in S){for(b=S[c].tweens,a=b.length;--a>-1;)b[a]._gc&&b.splice(a,1);0===b.length&&delete S[c]}if(c=X._first,(!c||c._paused)&&G.autoSleep&&!W._first&&1===i._listeners.tick.length){for(;c&&c._paused;)c=c._next;c||i.sleep()}}},i.addEventListener("tick",D._updateRoot);var $=function(a,b,c){var d,e,f=a._gsTweenID;if(S[f||(a._gsTweenID=f="t"+T++)]||(S[f]={target:a,tweens:[]}),b&&(d=S[f].tweens,d[e=d.length]=b,c))for(;--e>-1;)d[e]===b&&d.splice(e,1);return S[f].tweens},_=function(a,b,c,d){var e,f,g=a.vars.onOverwrite;return g&&(e=g(a,b,c,d)),g=G.onOverwrite,g&&(f=g(a,b,c,d)),e!==!1&&f!==!1},aa=function(a,b,c,d,e){var f,g,h,i;if(1===d||d>=4){for(i=e.length,f=0;i>f;f++)if((h=e[f])!==b)h._gc||h._kill(null,a,b)&&(g=!0);else if(5===d)break;return g}var j,k=b._startTime+m,l=[],n=0,o=0===b._duration;for(f=e.length;--f>-1;)(h=e[f])===b||h._gc||h._paused||(h._timeline!==b._timeline?(j=j||ba(b,0,o),0===ba(h,j,o)&&(l[n++]=h)):h._startTime<=k&&h._startTime+h.totalDuration()/h._timeScale>k&&((o||!h._initted)&&k-h._startTime<=2e-10||(l[n++]=h)));for(f=n;--f>-1;)if(h=l[f],2===d&&h._kill(c,a,b)&&(g=!0),2!==d||!h._firstPT&&h._initted){if(2!==d&&!_(h,b))continue;h._enabled(!1,!1)&&(g=!0)}return g},ba=function(a,b,c){for(var d=a._timeline,e=d._timeScale,f=a._startTime;d._timeline;){if(f+=d._startTime,e*=d._timeScale,d._paused)return-100;d=d._timeline}return f/=e,f>b?f-b:c&&f===b||!a._initted&&2*m>f-b?m:(f+=a.totalDuration()/a._timeScale/e)>b+m?0:f-b-m};h._init=function(){var a,b,c,d,e,f,g=this.vars,h=this._overwrittenProps,i=this._duration,j=!!g.immediateRender,k=g.ease;if(g.startAt){this._startAt&&(this._startAt.render(-1,!0),this._startAt.kill()),e={};for(d in g.startAt)e[d]=g.startAt[d];if(e.data="isStart",e.overwrite=!1,e.immediateRender=!0,e.lazy=j&&g.lazy!==!1,e.startAt=e.delay=null,e.onUpdate=g.onUpdate,e.onUpdateParams=g.onUpdateParams,e.onUpdateScope=g.onUpdateScope||g.callbackScope||this,this._startAt=G.to(this.target,0,e),j)if(this._time>0)this._startAt=null;else if(0!==i)return}else if(g.runBackwards&&0!==i)if(this._startAt)this._startAt.render(-1,!0),this._startAt.kill(),this._startAt=null;else{0!==this._time&&(j=!1),c={};for(d in g)U[d]&&"autoCSS"!==d||(c[d]=g[d]);if(c.overwrite=0,c.data="isFromStart",c.lazy=j&&g.lazy!==!1,c.immediateRender=j,this._startAt=G.to(this.target,0,c),j){if(0===this._time)return}else this._startAt._init(),this._startAt._enabled(!1),this.vars.immediateRender&&(this._startAt=null)}if(this._ease=k=k?k instanceof v?k:"function"==typeof k?new v(k,g.easeParams):w[k]||G.defaultEase:G.defaultEase,g.easeParams instanceof Array&&k.config&&(this._ease=k.config.apply(k,g.easeParams)),this._easeType=this._ease._type,this._easePower=this._ease._power,this._firstPT=null,this._targets)for(f=this._targets.length,a=0;f>a;a++)this._initProps(this._targets[a],this._propLookup[a]={},this._siblings[a],h?h[a]:null,a)&&(b=!0);else b=this._initProps(this.target,this._propLookup,this._siblings,h,0);if(b&&G._onPluginEvent("_onInitAllProps",this),h&&(this._firstPT||"function"!=typeof this.target&&this._enabled(!1,!1)),g.runBackwards)for(c=this._firstPT;c;)c.s+=c.c,c.c=-c.c,c=c._next;this._onUpdate=g.onUpdate,this._initted=!0},h._initProps=function(b,c,d,e,f){var g,h,i,j,k,l;if(null==b)return!1;K[b._gsTweenID]&&Z(),this.vars.css||b.style&&b!==a&&b.nodeType&&R.css&&this.vars.autoCSS!==!1&&I(this.vars,b);for(g in this.vars)if(l=this.vars[g],U[g])l&&(l instanceof Array||l.push&&p(l))&&-1!==l.join("").indexOf("{self}")&&(this.vars[g]=l=this._swapSelfInParams(l,this));else if(R[g]&&(j=new R[g])._onInitTween(b,this.vars[g],this,f)){for(this._firstPT=k={_next:this._firstPT,t:j,p:"setRatio",s:0,c:1,f:1,n:g,pg:1,pr:j._priority,m:0},h=j._overwriteProps.length;--h>-1;)c[j._overwriteProps[h]]=this._firstPT;(j._priority||j._onInitAllProps)&&(i=!0),(j._onDisable||j._onEnable)&&(this._notifyPluginsOfEnabled=!0),k._next&&(k._next._prev=k)}else c[g]=P.call(this,b,g,"get",l,g,0,null,this.vars.stringFilter,f);return e&&this._kill(e,b)?this._initProps(b,c,d,e,f):this._overwrite>1&&this._firstPT&&d.length>1&&aa(b,this,c,this._overwrite,d)?(this._kill(c,b),this._initProps(b,c,d,e,f)):(this._firstPT&&(this.vars.lazy!==!1&&this._duration||this.vars.lazy&&!this._duration)&&(K[b._gsTweenID]=!0),i)},h.render=function(a,b,c){var d,e,f,g,h=this._time,i=this._duration,j=this._rawPrevTime;if(a>=i-1e-7&&a>=0)this._totalTime=this._time=i,this.ratio=this._ease._calcEnd?this._ease.getRatio(1):1,this._reversed||(d=!0,e="onComplete",c=c||this._timeline.autoRemoveChildren),0===i&&(this._initted||!this.vars.lazy||c)&&(this._startTime===this._timeline._duration&&(a=0),(0>j||0>=a&&a>=-1e-7||j===m&&"isPause"!==this.data)&&j!==a&&(c=!0,j>m&&(e="onReverseComplete")),this._rawPrevTime=g=!b||a||j===a?a:m);else if(1e-7>a)this._totalTime=this._time=0,this.ratio=this._ease._calcEnd?this._ease.getRatio(0):0,(0!==h||0===i&&j>0)&&(e="onReverseComplete",d=this._reversed),0>a&&(this._active=!1,0===i&&(this._initted||!this.vars.lazy||c)&&(j>=0&&(j!==m||"isPause"!==this.data)&&(c=!0),this._rawPrevTime=g=!b||a||j===a?a:m)),(!this._initted||this._startAt&&this._startAt.progress())&&(c=!0);else if(this._totalTime=this._time=a,this._easeType){var k=a/i,l=this._easeType,n=this._easePower;(1===l||3===l&&k>=.5)&&(k=1-k),3===l&&(k*=2),1===n?k*=k:2===n?k*=k*k:3===n?k*=k*k*k:4===n&&(k*=k*k*k*k),1===l?this.ratio=1-k:2===l?this.ratio=k:.5>a/i?this.ratio=k/2:this.ratio=1-k/2}else this.ratio=this._ease.getRatio(a/i);if(this._time!==h||c){if(!this._initted){if(this._init(),!this._initted||this._gc)return;if(!c&&this._firstPT&&(this.vars.lazy!==!1&&this._duration||this.vars.lazy&&!this._duration))return this._time=this._totalTime=h,this._rawPrevTime=j,J.push(this),void(this._lazy=[a,b]);this._time&&!d?this.ratio=this._ease.getRatio(this._time/i):d&&this._ease._calcEnd&&(this.ratio=this._ease.getRatio(0===this._time?0:1))}for(this._lazy!==!1&&(this._lazy=!1),this._active||!this._paused&&this._time!==h&&a>=0&&(this._active=!0),0===h&&(this._startAt&&(a>=0?this._startAt.render(a,!0,c):e||(e="_dummyGS")),this.vars.onStart&&(0!==this._time||0===i)&&(b||this._callback("onStart"))),f=this._firstPT;f;)f.f?f.t[f.p](f.c*this.ratio+f.s):f.t[f.p]=f.c*this.ratio+f.s,f=f._next;this._onUpdate&&(0>a&&this._startAt&&a!==-1e-4&&this._startAt.render(a,!0,c),b||(this._time!==h||d||c)&&this._callback("onUpdate")),e&&(!this._gc||c)&&(0>a&&this._startAt&&!this._onUpdate&&a!==-1e-4&&this._startAt.render(a,!0,c),d&&(this._timeline.autoRemoveChildren&&this._enabled(!1,!1),this._active=!1),!b&&this.vars[e]&&this._callback(e),0===i&&this._rawPrevTime===m&&g!==m&&(this._rawPrevTime=0))}},h._kill=function(a,b,c){if("all"===a&&(a=null),null==a&&(null==b||b===this.target))return this._lazy=!1,this._enabled(!1,!1);b="string"!=typeof b?b||this._targets||this.target:G.selector(b)||b;var d,e,f,g,h,i,j,k,l,m=c&&this._time&&c._startTime===this._startTime&&this._timeline===c._timeline;if((p(b)||H(b))&&"number"!=typeof b[0])for(d=b.length;--d>-1;)this._kill(a,b[d],c)&&(i=!0);else{if(this._targets){for(d=this._targets.length;--d>-1;)if(b===this._targets[d]){h=this._propLookup[d]||{},this._overwrittenProps=this._overwrittenProps||[],e=this._overwrittenProps[d]=a?this._overwrittenProps[d]||{}:"all";break}}else{if(b!==this.target)return!1;h=this._propLookup,e=this._overwrittenProps=a?this._overwrittenProps||{}:"all"}if(h){if(j=a||h,k=a!==e&&"all"!==e&&a!==h&&("object"!=typeof a||!a._tempKill),c&&(G.onOverwrite||this.vars.onOverwrite)){for(f in j)h[f]&&(l||(l=[]),l.push(f));if((l||!a)&&!_(this,c,b,l))return!1}for(f in j)(g=h[f])&&(m&&(g.f?g.t[g.p](g.s):g.t[g.p]=g.s,i=!0),g.pg&&g.t._kill(j)&&(i=!0),g.pg&&0!==g.t._overwriteProps.length||(g._prev?g._prev._next=g._next:g===this._firstPT&&(this._firstPT=g._next),g._next&&(g._next._prev=g._prev),g._next=g._prev=null),delete h[f]),k&&(e[f]=1);!this._firstPT&&this._initted&&this._enabled(!1,!1)}}return i},h.invalidate=function(){return this._notifyPluginsOfEnabled&&G._onPluginEvent("_onDisable",this),this._firstPT=this._overwrittenProps=this._startAt=this._onUpdate=null,this._notifyPluginsOfEnabled=this._active=this._lazy=!1,this._propLookup=this._targets?{}:[],D.prototype.invalidate.call(this),this.vars.immediateRender&&(this._time=-m,this.render(Math.min(0,-this._delay))),this},h._enabled=function(a,b){if(j||i.wake(),a&&this._gc){var c,d=this._targets;if(d)for(c=d.length;--c>-1;)this._siblings[c]=$(d[c],this,!0);else this._siblings=$(this.target,this,!0)}return D.prototype._enabled.call(this,a,b),this._notifyPluginsOfEnabled&&this._firstPT?G._onPluginEvent(a?"_onEnable":"_onDisable",this):!1},G.to=function(a,b,c){return new G(a,b,c)},G.from=function(a,b,c){return c.runBackwards=!0,c.immediateRender=0!=c.immediateRender,new G(a,b,c)},G.fromTo=function(a,b,c,d){return d.startAt=c,d.immediateRender=0!=d.immediateRender&&0!=c.immediateRender,new G(a,b,d)},G.delayedCall=function(a,b,c,d,e){return new G(b,0,{delay:a,onComplete:b,onCompleteParams:c,callbackScope:d,onReverseComplete:b,onReverseCompleteParams:c,immediateRender:!1,lazy:!1,useFrames:e,overwrite:0})},G.set=function(a,b){return new G(a,0,b)},G.getTweensOf=function(a,b){if(null==a)return[];a="string"!=typeof a?a:G.selector(a)||a;var c,d,e,f;if((p(a)||H(a))&&"number"!=typeof a[0]){for(c=a.length,d=[];--c>-1;)d=d.concat(G.getTweensOf(a[c],b));for(c=d.length;--c>-1;)for(f=d[c],e=c;--e>-1;)f===d[e]&&d.splice(c,1)}else if(a._gsTweenID)for(d=$(a).concat(),c=d.length;--c>-1;)(d[c]._gc||b&&!d[c].isActive())&&d.splice(c,1);return d||[]},G.killTweensOf=G.killDelayedCallsTo=function(a,b,c){"object"==typeof b&&(c=b,b=!1);for(var d=G.getTweensOf(a,b),e=d.length;--e>-1;)d[e]._kill(c,a)};var ca=t("plugins.TweenPlugin",function(a,b){this._overwriteProps=(a||"").split(","),this._propName=this._overwriteProps[0],this._priority=b||0,this._super=ca.prototype},!0);if(h=ca.prototype,ca.version="1.19.0",ca.API=2,h._firstPT=null,h._addTween=P,h.setRatio=N,h._kill=function(a){var b,c=this._overwriteProps,d=this._firstPT;if(null!=a[this._propName])this._overwriteProps=[];else for(b=c.length;--b>-1;)null!=a[c[b]]&&c.splice(b,1);for(;d;)null!=a[d.n]&&(d._next&&(d._next._prev=d._prev),d._prev?(d._prev._next=d._next,d._prev=null):this._firstPT===d&&(this._firstPT=d._next)),d=d._next;return!1},h._mod=h._roundProps=function(a){for(var b,c=this._firstPT;c;)b=a[this._propName]||null!=c.n&&a[c.n.split(this._propName+"_").join("")],b&&"function"==typeof b&&(2===c.f?c.t._applyPT.m=b:c.m=b),c=c._next},G._onPluginEvent=function(a,b){var c,d,e,f,g,h=b._firstPT;if("_onInitAllProps"===a){for(;h;){for(g=h._next,d=e;d&&d.pr>h.pr;)d=d._next;(h._prev=d?d._prev:f)?h._prev._next=h:e=h,(h._next=d)?d._prev=h:f=h,h=g}h=b._firstPT=e}for(;h;)h.pg&&"function"==typeof h.t[a]&&h.t[a]()&&(c=!0),h=h._next;return c},ca.activate=function(a){for(var b=a.length;--b>-1;)a[b].API===ca.API&&(R[(new a[b])._propName]=a[b]);return!0},s.plugin=function(a){if(!(a&&a.propName&&a.init&&a.API))throw"illegal plugin definition.";var b,c=a.propName,d=a.priority||0,e=a.overwriteProps,f={init:"_onInitTween",set:"setRatio",kill:"_kill",round:"_mod",mod:"_mod",initAll:"_onInitAllProps"},g=t("plugins."+c.charAt(0).toUpperCase()+c.substr(1)+"Plugin",function(){ca.call(this,c,d),this._overwriteProps=e||[]},a.global===!0),h=g.prototype=new ca(c);h.constructor=g,g.API=a.API;for(b in f)"function"==typeof a[b]&&(h[f[b]]=a[b]);return g.version=a.version,ca.activate([g]),g},f=a._gsQueue){for(g=0;g<f.length;g++)f[g]();for(h in q)q[h].func||a.console.log("GSAP encountered missing dependency: "+h)}j=!1}}("undefined"!=typeof module&&module.exports&&"undefined"!=typeof global?global:this||window,"TweenMax");


/*------------------------------------------------------------------*/
/*	02) JARALLAX
/*------------------------------------------------------------------*/

/*!
 * Name    : Just Another Parallax [Jarallax]
 * Version : 1.7.3
 * Author  : _nK https://nkdev.info
 * GitHub  : https://github.com/nk-o/jarallax
 */
!function(e){"use strict";function t(){i=e.innerWidth||document.documentElement.clientWidth,a=e.innerHeight||document.documentElement.clientHeight}function n(e,t,n){e.addEventListener?e.addEventListener(t,n):e.attachEvent("on"+t,function(){n.call(e)})}function o(n){e.requestAnimationFrame(function(){"scroll"!==n.type&&t();for(var e=0,o=g.length;o>e;e++)"scroll"!==n.type&&(g[e].coverImage(),g[e].clipContainer()),g[e].onScroll()})}Date.now||(Date.now=function(){return(new Date).getTime()}),e.requestAnimationFrame||!function(){for(var t=["webkit","moz"],n=0;n<t.length&&!e.requestAnimationFrame;++n){var o=t[n];e.requestAnimationFrame=e[o+"RequestAnimationFrame"],e.cancelAnimationFrame=e[o+"CancelAnimationFrame"]||e[o+"CancelRequestAnimationFrame"]}if(/iP(ad|hone|od).*OS 6/.test(e.navigator.userAgent)||!e.requestAnimationFrame||!e.cancelAnimationFrame){var i=0;e.requestAnimationFrame=function(e){var t=Date.now(),n=Math.max(i+16,t);return setTimeout(function(){e(i=n)},n-t)},e.cancelAnimationFrame=clearTimeout}}();var i,a,r=function(){if(!e.getComputedStyle)return!1;var t,n=document.createElement("p"),o={webkitTransform:"-webkit-transform",OTransform:"-o-transform",msTransform:"-ms-transform",MozTransform:"-moz-transform",transform:"transform"};(document.body||document.documentElement).insertBefore(n,null);for(var i in o)"undefined"!=typeof n.style[i]&&(n.style[i]="translate3d(1px,1px,1px)",t=e.getComputedStyle(n).getPropertyValue(o[i]));return(document.body||document.documentElement).removeChild(n),"undefined"!=typeof t&&t.length>0&&"none"!==t}(),s=navigator.userAgent.toLowerCase().indexOf("android")>-1,l=/iPad|iPhone|iPod/.test(navigator.userAgent)&&!e.MSStream,m=!!e.opera,c=/Edge\/\d+/.test(navigator.userAgent),p=/Trident.*rv[ :]*11\./.test(navigator.userAgent),u=!!Function("/*@cc_on return document.documentMode===10@*/")(),d=document.all&&!e.atob;t();var g=[],f=function(){function e(e,n){var o,i=this;if(i.$item=e,i.defaults={type:"scroll",speed:.5,imgSrc:null,imgWidth:null,imgHeight:null,enableTransform:!0,elementInViewport:null,zIndex:-100,noAndroid:!1,noIos:!0,onScroll:null,onInit:null,onDestroy:null,onCoverImage:null},o=JSON.parse(i.$item.getAttribute("data-jarallax")||"{}"),i.options=i.extend({},i.defaults,o,n),!(s&&i.options.noAndroid||l&&i.options.noIos)){i.options.speed=Math.min(2,Math.max(-1,parseFloat(i.options.speed)));var a=i.options.elementInViewport;a&&"object"==typeof a&&"undefined"!=typeof a.length&&(a=a[0]),!a instanceof Element&&(a=null),i.options.elementInViewport=a,i.instanceID=t++,i.image={src:i.options.imgSrc||null,$container:null,$item:null,width:i.options.imgWidth||null,height:i.options.imgHeight||null,useImgTag:l||s||m||p||u||c},i.initImg()&&i.init()}}var t=0;return e}();f.prototype.css=function(t,n){if("string"==typeof n)return e.getComputedStyle?e.getComputedStyle(t).getPropertyValue(n):t.style[n];n.transform&&(n.WebkitTransform=n.MozTransform=n.transform);for(var o in n)t.style[o]=n[o];return t},f.prototype.extend=function(e){e=e||{};for(var t=1;t<arguments.length;t++)if(arguments[t])for(var n in arguments[t])arguments[t].hasOwnProperty(n)&&(e[n]=arguments[t][n]);return e},f.prototype.initImg=function(){var e=this;return null===e.image.src&&(e.image.src=e.css(e.$item,"background-image").replace(/^url\(['"]?/g,"").replace(/['"]?\)$/g,"")),!(!e.image.src||"none"===e.image.src)},f.prototype.init=function(){function e(){t.coverImage(),t.clipContainer(),t.onScroll(!0),t.options.onInit&&t.options.onInit.call(t),setTimeout(function(){t.$item&&t.css(t.$item,{"background-image":"none","background-attachment":"scroll","background-size":"auto"})},0)}var t=this,n={position:"absolute",top:0,left:0,width:"100%",height:"100%",overflow:"hidden",pointerEvents:"none"},o={position:"fixed"};t.$item.setAttribute("data-jarallax-original-styles",t.$item.getAttribute("style")),"static"===t.css(t.$item,"position")&&t.css(t.$item,{position:"relative"}),"auto"===t.css(t.$item,"z-index")&&t.css(t.$item,{zIndex:0}),t.image.$container=document.createElement("div"),t.css(t.image.$container,n),t.css(t.image.$container,{visibility:"hidden","z-index":t.options.zIndex}),t.image.$container.setAttribute("id","jarallax-container-"+t.instanceID),t.$item.appendChild(t.image.$container),t.image.useImgTag&&r&&t.options.enableTransform?(t.image.$item=document.createElement("img"),t.image.$item.setAttribute("src",t.image.src),o=t.extend({"max-width":"none"},n,o)):(t.image.$item=document.createElement("div"),o=t.extend({"background-position":"50% 50%","background-size":"100% auto","background-repeat":"no-repeat no-repeat","background-image":'url("'+t.image.src+'")'},n,o)),d&&(o.backgroundAttachment="fixed"),t.parentWithTransform=0;for(var i=t.$item;null!==i&&i!==document&&0===t.parentWithTransform;){var a=t.css(i,"-webkit-transform")||t.css(i,"-moz-transform")||t.css(i,"transform");a&&"none"!==a&&(t.parentWithTransform=1,t.css(t.image.$container,{transform:"translateX(0) translateY(0)"})),i=i.parentNode}t.css(t.image.$item,o),t.image.$container.appendChild(t.image.$item),t.image.width&&t.image.height?e():t.getImageSize(t.image.src,function(n,o){t.image.width=n,t.image.height=o,e()}),g.push(t)},f.prototype.destroy=function(){for(var e=this,t=0,n=g.length;n>t;t++)if(g[t].instanceID===e.instanceID){g.splice(t,1);break}var o=e.$item.getAttribute("data-jarallax-original-styles");e.$item.removeAttribute("data-jarallax-original-styles"),"null"===o?e.$item.removeAttribute("style"):e.$item.setAttribute("style",o),e.$clipStyles&&e.$clipStyles.parentNode.removeChild(e.$clipStyles),e.image.$container.parentNode.removeChild(e.image.$container),e.options.onDestroy&&e.options.onDestroy.call(e),delete e.$item.jarallax;for(var i in e)delete e[i]},f.prototype.getImageSize=function(e,t){if(e&&t){var n=new Image;n.onload=function(){t(n.width,n.height)},n.src=e}},f.prototype.clipContainer=function(){if(!d){var e=this,t=e.image.$container.getBoundingClientRect(),n=t.width,o=t.height;if(!e.$clipStyles){e.$clipStyles=document.createElement("style"),e.$clipStyles.setAttribute("type","text/css"),e.$clipStyles.setAttribute("id","#jarallax-clip-"+e.instanceID);var i=document.head||document.getElementsByTagName("head")[0];i.appendChild(e.$clipStyles)}var a=["#jarallax-container-"+e.instanceID+" {","   clip: rect(0 "+n+"px "+o+"px 0);","   clip: rect(0, "+n+"px, "+o+"px, 0);","}"].join("\n");e.$clipStyles.styleSheet?e.$clipStyles.styleSheet.cssText=a:e.$clipStyles.innerHTML=a}},f.prototype.coverImage=function(){var e=this;if(e.image.width&&e.image.height){var t=e.image.$container.getBoundingClientRect(),n=t.width,o=t.height,i=t.left,s=e.image.width,l=e.image.height,m=e.options.speed,c="scroll"===e.options.type||"scroll-opacity"===e.options.type,p=0,u=0,d=o,g=0,f=0;c&&(p=0>m?m*Math.max(o,a):m*(o+a),m>1?d=Math.abs(p-a):0>m?d=p/m+Math.abs(p):d+=Math.abs(a-o)*(1-m),p/=2),u=d*s/l,n>u&&(u=n,d=u*l/s),e.bgPosVerticalCenter=0,!(c&&a>d)||r&&e.options.enableTransform||(e.bgPosVerticalCenter=(a-d)/2,d=a),c?(g=i+(n-u)/2,f=(a-d)/2):(g=(n-u)/2,f=(o-d)/2),r&&e.options.enableTransform&&e.parentWithTransform&&(g-=i),e.parallaxScrollDistance=p,e.css(e.image.$item,{width:u+"px",height:d+"px",marginLeft:g+"px",marginTop:f+"px"}),e.options.onCoverImage&&e.options.onCoverImage.call(e)}},f.prototype.isVisible=function(){return this.isElementInViewport||!1},f.prototype.onScroll=function(e){var t=this;if(t.image.width&&t.image.height){var n=t.$item.getBoundingClientRect(),o=n.top,s=n.height,l={position:"absolute",visibility:"visible",backgroundPosition:"50% 50%"},m=n;if(t.options.elementInViewport&&(m=t.options.elementInViewport.getBoundingClientRect()),t.isElementInViewport=m.bottom>=0&&m.right>=0&&m.top<=a&&m.left<=i,e?1:t.isElementInViewport){var c=Math.max(0,o),p=Math.max(0,s+o),u=Math.max(0,-o),g=Math.max(0,o+s-a),f=Math.max(0,s-(o+s-a)),h=Math.max(0,-o+a-s),y=1-2*(a-o)/(a+s),v=1;if(a>s?v=1-(u||g)/s:a>=p?v=p/a:a>=f&&(v=f/a),("opacity"===t.options.type||"scale-opacity"===t.options.type||"scroll-opacity"===t.options.type)&&(l.transform="translate3d(0, 0, 0)",l.opacity=v),"scale"===t.options.type||"scale-opacity"===t.options.type){var x=1;t.options.speed<0?x-=t.options.speed*v:x+=t.options.speed*(1-v),l.transform="scale("+x+") translate3d(0, 0, 0)"}if("scroll"===t.options.type||"scroll-opacity"===t.options.type){var b=t.parallaxScrollDistance*y;r&&t.options.enableTransform?(t.parentWithTransform&&(b-=o),l.transform="translate3d(0, "+b+"px, 0)"):t.image.useImgTag?l.top=b+"px":(t.bgPosVerticalCenter&&(b+=t.bgPosVerticalCenter),l.backgroundPosition="50% "+b+"px"),l.position=d?"absolute":"fixed"}t.css(t.image.$item,l),t.options.onScroll&&t.options.onScroll.call(t,{section:n,beforeTop:c,beforeTopEnd:p,afterTop:u,beforeBottom:g,beforeBottomEnd:f,afterBottom:h,visiblePercent:v,fromViewportCenter:y})}}},n(e,"scroll",o),n(e,"resize",o),n(e,"orientationchange",o),n(e,"load",o);var h=function(e){("object"==typeof HTMLElement?e instanceof HTMLElement:e&&"object"==typeof e&&null!==e&&1===e.nodeType&&"string"==typeof e.nodeName)&&(e=[e]);var t,n=arguments[1],o=Array.prototype.slice.call(arguments,2),i=e.length,a=0;for(a;i>a;a++)if("object"==typeof n||"undefined"==typeof n?e[a].jarallax||(e[a].jarallax=new f(e[a],n)):e[a].jarallax&&(t=e[a].jarallax[n].apply(e[a].jarallax,o)),"undefined"!=typeof t)return t;return e};h.constructor=f;var y=e.jarallax;if(e.jarallax=h,e.jarallax.noConflict=function(){return e.jarallax=y,this},"undefined"!=typeof jQuery){var v=function(){var t=arguments||[];Array.prototype.unshift.call(t,this);var n=h.apply(e,t);return"object"!=typeof n?n:this};v.constructor=f;var x=jQuery.fn.jarallax;jQuery.fn.jarallax=v,jQuery.fn.jarallax.noConflict=function(){return jQuery.fn.jarallax=x,this}}n(e,"DOMContentLoaded",function(){h(document.querySelectorAll("[data-jarallax], [data-jarallax-video]"))})}(window);


/*------------------------------------------------------------------*/
/*	04) ISOTOPE
/*------------------------------------------------------------------*/
/*!
 * Isotope PACKAGED v3.0.4
 *
 * Licensed GPLv3 for open source use
 * or Isotope Commercial License for commercial use
 *
 * http://isotope.metafizzy.co
 * Copyright 2017 Metafizzy
 */

!function(t,e){"function"==typeof define&&define.amd?define("jquery-bridget/jquery-bridget",["jquery"],function(i){return e(t,i)}):"object"==typeof module&&module.exports?module.exports=e(t,require("jquery")):t.jQueryBridget=e(t,t.jQuery)}(window,function(t,e){"use strict";function i(i,s,a){function u(t,e,o){var n,s="$()."+i+'("'+e+'")';return t.each(function(t,u){var h=a.data(u,i);if(!h)return void r(i+" not initialized. Cannot call methods, i.e. "+s);var d=h[e];if(!d||"_"==e.charAt(0))return void r(s+" is not a valid method");var l=d.apply(h,o);n=void 0===n?l:n}),void 0!==n?n:t}function h(t,e){t.each(function(t,o){var n=a.data(o,i);n?(n.option(e),n._init()):(n=new s(o,e),a.data(o,i,n))})}a=a||e||t.jQuery,a&&(s.prototype.option||(s.prototype.option=function(t){a.isPlainObject(t)&&(this.options=a.extend(!0,this.options,t))}),a.fn[i]=function(t){if("string"==typeof t){var e=n.call(arguments,1);return u(this,t,e)}return h(this,t),this},o(a))}function o(t){!t||t&&t.bridget||(t.bridget=i)}var n=Array.prototype.slice,s=t.console,r="undefined"==typeof s?function(){}:function(t){s.error(t)};return o(e||t.jQuery),i}),function(t,e){"function"==typeof define&&define.amd?define("ev-emitter/ev-emitter",e):"object"==typeof module&&module.exports?module.exports=e():t.EvEmitter=e()}("undefined"!=typeof window?window:this,function(){function t(){}var e=t.prototype;return e.on=function(t,e){if(t&&e){var i=this._events=this._events||{},o=i[t]=i[t]||[];return o.indexOf(e)==-1&&o.push(e),this}},e.once=function(t,e){if(t&&e){this.on(t,e);var i=this._onceEvents=this._onceEvents||{},o=i[t]=i[t]||{};return o[e]=!0,this}},e.off=function(t,e){var i=this._events&&this._events[t];if(i&&i.length){var o=i.indexOf(e);return o!=-1&&i.splice(o,1),this}},e.emitEvent=function(t,e){var i=this._events&&this._events[t];if(i&&i.length){var o=0,n=i[o];e=e||[];for(var s=this._onceEvents&&this._onceEvents[t];n;){var r=s&&s[n];r&&(this.off(t,n),delete s[n]),n.apply(this,e),o+=r?0:1,n=i[o]}return this}},t}),function(t,e){"use strict";"function"==typeof define&&define.amd?define("get-size/get-size",[],function(){return e()}):"object"==typeof module&&module.exports?module.exports=e():t.getSize=e()}(window,function(){"use strict";function t(t){var e=parseFloat(t),i=t.indexOf("%")==-1&&!isNaN(e);return i&&e}function e(){}function i(){for(var t={width:0,height:0,innerWidth:0,innerHeight:0,outerWidth:0,outerHeight:0},e=0;e<h;e++){var i=u[e];t[i]=0}return t}function o(t){var e=getComputedStyle(t);return e||a("Style returned "+e+". Are you running this code in a hidden iframe on Firefox? See http://bit.ly/getsizebug1"),e}function n(){if(!d){d=!0;var e=document.createElement("div");e.style.width="200px",e.style.padding="1px 2px 3px 4px",e.style.borderStyle="solid",e.style.borderWidth="1px 2px 3px 4px",e.style.boxSizing="border-box";var i=document.body||document.documentElement;i.appendChild(e);var n=o(e);s.isBoxSizeOuter=r=200==t(n.width),i.removeChild(e)}}function s(e){if(n(),"string"==typeof e&&(e=document.querySelector(e)),e&&"object"==typeof e&&e.nodeType){var s=o(e);if("none"==s.display)return i();var a={};a.width=e.offsetWidth,a.height=e.offsetHeight;for(var d=a.isBorderBox="border-box"==s.boxSizing,l=0;l<h;l++){var f=u[l],c=s[f],m=parseFloat(c);a[f]=isNaN(m)?0:m}var p=a.paddingLeft+a.paddingRight,y=a.paddingTop+a.paddingBottom,g=a.marginLeft+a.marginRight,v=a.marginTop+a.marginBottom,_=a.borderLeftWidth+a.borderRightWidth,I=a.borderTopWidth+a.borderBottomWidth,z=d&&r,x=t(s.width);x!==!1&&(a.width=x+(z?0:p+_));var S=t(s.height);return S!==!1&&(a.height=S+(z?0:y+I)),a.innerWidth=a.width-(p+_),a.innerHeight=a.height-(y+I),a.outerWidth=a.width+g,a.outerHeight=a.height+v,a}}var r,a="undefined"==typeof console?e:function(t){console.error(t)},u=["paddingLeft","paddingRight","paddingTop","paddingBottom","marginLeft","marginRight","marginTop","marginBottom","borderLeftWidth","borderRightWidth","borderTopWidth","borderBottomWidth"],h=u.length,d=!1;return s}),function(t,e){"use strict";"function"==typeof define&&define.amd?define("desandro-matches-selector/matches-selector",e):"object"==typeof module&&module.exports?module.exports=e():t.matchesSelector=e()}(window,function(){"use strict";var t=function(){var t=window.Element.prototype;if(t.matches)return"matches";if(t.matchesSelector)return"matchesSelector";for(var e=["webkit","moz","ms","o"],i=0;i<e.length;i++){var o=e[i],n=o+"MatchesSelector";if(t[n])return n}}();return function(e,i){return e[t](i)}}),function(t,e){"function"==typeof define&&define.amd?define("fizzy-ui-utils/utils",["desandro-matches-selector/matches-selector"],function(i){return e(t,i)}):"object"==typeof module&&module.exports?module.exports=e(t,require("desandro-matches-selector")):t.fizzyUIUtils=e(t,t.matchesSelector)}(window,function(t,e){var i={};i.extend=function(t,e){for(var i in e)t[i]=e[i];return t},i.modulo=function(t,e){return(t%e+e)%e},i.makeArray=function(t){var e=[];if(Array.isArray(t))e=t;else if(t&&"object"==typeof t&&"number"==typeof t.length)for(var i=0;i<t.length;i++)e.push(t[i]);else e.push(t);return e},i.removeFrom=function(t,e){var i=t.indexOf(e);i!=-1&&t.splice(i,1)},i.getParent=function(t,i){for(;t.parentNode&&t!=document.body;)if(t=t.parentNode,e(t,i))return t},i.getQueryElement=function(t){return"string"==typeof t?document.querySelector(t):t},i.handleEvent=function(t){var e="on"+t.type;this[e]&&this[e](t)},i.filterFindElements=function(t,o){t=i.makeArray(t);var n=[];return t.forEach(function(t){if(t instanceof HTMLElement){if(!o)return void n.push(t);e(t,o)&&n.push(t);for(var i=t.querySelectorAll(o),s=0;s<i.length;s++)n.push(i[s])}}),n},i.debounceMethod=function(t,e,i){var o=t.prototype[e],n=e+"Timeout";t.prototype[e]=function(){var t=this[n];t&&clearTimeout(t);var e=arguments,s=this;this[n]=setTimeout(function(){o.apply(s,e),delete s[n]},i||100)}},i.docReady=function(t){var e=document.readyState;"complete"==e||"interactive"==e?setTimeout(t):document.addEventListener("DOMContentLoaded",t)},i.toDashed=function(t){return t.replace(/(.)([A-Z])/g,function(t,e,i){return e+"-"+i}).toLowerCase()};var o=t.console;return i.htmlInit=function(e,n){i.docReady(function(){var s=i.toDashed(n),r="data-"+s,a=document.querySelectorAll("["+r+"]"),u=document.querySelectorAll(".js-"+s),h=i.makeArray(a).concat(i.makeArray(u)),d=r+"-options",l=t.jQuery;h.forEach(function(t){var i,s=t.getAttribute(r)||t.getAttribute(d);try{i=s&&JSON.parse(s)}catch(a){return void(o&&o.error("Error parsing "+r+" on "+t.className+": "+a))}var u=new e(t,i);l&&l.data(t,n,u)})})},i}),function(t,e){"function"==typeof define&&define.amd?define("outlayer/item",["ev-emitter/ev-emitter","get-size/get-size"],e):"object"==typeof module&&module.exports?module.exports=e(require("ev-emitter"),require("get-size")):(t.Outlayer={},t.Outlayer.Item=e(t.EvEmitter,t.getSize))}(window,function(t,e){"use strict";function i(t){for(var e in t)return!1;return e=null,!0}function o(t,e){t&&(this.element=t,this.layout=e,this.position={x:0,y:0},this._create())}function n(t){return t.replace(/([A-Z])/g,function(t){return"-"+t.toLowerCase()})}var s=document.documentElement.style,r="string"==typeof s.transition?"transition":"WebkitTransition",a="string"==typeof s.transform?"transform":"WebkitTransform",u={WebkitTransition:"webkitTransitionEnd",transition:"transitionend"}[r],h={transform:a,transition:r,transitionDuration:r+"Duration",transitionProperty:r+"Property",transitionDelay:r+"Delay"},d=o.prototype=Object.create(t.prototype);d.constructor=o,d._create=function(){this._transn={ingProperties:{},clean:{},onEnd:{}},this.css({position:"absolute"})},d.handleEvent=function(t){var e="on"+t.type;this[e]&&this[e](t)},d.getSize=function(){this.size=e(this.element)},d.css=function(t){var e=this.element.style;for(var i in t){var o=h[i]||i;e[o]=t[i]}},d.getPosition=function(){var t=getComputedStyle(this.element),e=this.layout._getOption("originLeft"),i=this.layout._getOption("originTop"),o=t[e?"left":"right"],n=t[i?"top":"bottom"],s=this.layout.size,r=o.indexOf("%")!=-1?parseFloat(o)/100*s.width:parseInt(o,10),a=n.indexOf("%")!=-1?parseFloat(n)/100*s.height:parseInt(n,10);r=isNaN(r)?0:r,a=isNaN(a)?0:a,r-=e?s.paddingLeft:s.paddingRight,a-=i?s.paddingTop:s.paddingBottom,this.position.x=r,this.position.y=a},d.layoutPosition=function(){var t=this.layout.size,e={},i=this.layout._getOption("originLeft"),o=this.layout._getOption("originTop"),n=i?"paddingLeft":"paddingRight",s=i?"left":"right",r=i?"right":"left",a=this.position.x+t[n];e[s]=this.getXValue(a),e[r]="";var u=o?"paddingTop":"paddingBottom",h=o?"top":"bottom",d=o?"bottom":"top",l=this.position.y+t[u];e[h]=this.getYValue(l),e[d]="",this.css(e),this.emitEvent("layout",[this])},d.getXValue=function(t){var e=this.layout._getOption("horizontal");return this.layout.options.percentPosition&&!e?t/this.layout.size.width*100+"%":t+"px"},d.getYValue=function(t){var e=this.layout._getOption("horizontal");return this.layout.options.percentPosition&&e?t/this.layout.size.height*100+"%":t+"px"},d._transitionTo=function(t,e){this.getPosition();var i=this.position.x,o=this.position.y,n=parseInt(t,10),s=parseInt(e,10),r=n===this.position.x&&s===this.position.y;if(this.setPosition(t,e),r&&!this.isTransitioning)return void this.layoutPosition();var a=t-i,u=e-o,h={};h.transform=this.getTranslate(a,u),this.transition({to:h,onTransitionEnd:{transform:this.layoutPosition},isCleaning:!0})},d.getTranslate=function(t,e){var i=this.layout._getOption("originLeft"),o=this.layout._getOption("originTop");return t=i?t:-t,e=o?e:-e,"translate3d("+t+"px, "+e+"px, 0)"},d.goTo=function(t,e){this.setPosition(t,e),this.layoutPosition()},d.moveTo=d._transitionTo,d.setPosition=function(t,e){this.position.x=parseInt(t,10),this.position.y=parseInt(e,10)},d._nonTransition=function(t){this.css(t.to),t.isCleaning&&this._removeStyles(t.to);for(var e in t.onTransitionEnd)t.onTransitionEnd[e].call(this)},d.transition=function(t){if(!parseFloat(this.layout.options.transitionDuration))return void this._nonTransition(t);var e=this._transn;for(var i in t.onTransitionEnd)e.onEnd[i]=t.onTransitionEnd[i];for(i in t.to)e.ingProperties[i]=!0,t.isCleaning&&(e.clean[i]=!0);if(t.from){this.css(t.from);var o=this.element.offsetHeight;o=null}this.enableTransition(t.to),this.css(t.to),this.isTransitioning=!0};var l="opacity,"+n(a);d.enableTransition=function(){if(!this.isTransitioning){var t=this.layout.options.transitionDuration;t="number"==typeof t?t+"ms":t,this.css({transitionProperty:l,transitionDuration:t,transitionDelay:this.staggerDelay||0}),this.element.addEventListener(u,this,!1)}},d.onwebkitTransitionEnd=function(t){this.ontransitionend(t)},d.onotransitionend=function(t){this.ontransitionend(t)};var f={"-webkit-transform":"transform"};d.ontransitionend=function(t){if(t.target===this.element){var e=this._transn,o=f[t.propertyName]||t.propertyName;if(delete e.ingProperties[o],i(e.ingProperties)&&this.disableTransition(),o in e.clean&&(this.element.style[t.propertyName]="",delete e.clean[o]),o in e.onEnd){var n=e.onEnd[o];n.call(this),delete e.onEnd[o]}this.emitEvent("transitionEnd",[this])}},d.disableTransition=function(){this.removeTransitionStyles(),this.element.removeEventListener(u,this,!1),this.isTransitioning=!1},d._removeStyles=function(t){var e={};for(var i in t)e[i]="";this.css(e)};var c={transitionProperty:"",transitionDuration:"",transitionDelay:""};return d.removeTransitionStyles=function(){this.css(c)},d.stagger=function(t){t=isNaN(t)?0:t,this.staggerDelay=t+"ms"},d.removeElem=function(){this.element.parentNode.removeChild(this.element),this.css({display:""}),this.emitEvent("remove",[this])},d.remove=function(){return r&&parseFloat(this.layout.options.transitionDuration)?(this.once("transitionEnd",function(){this.removeElem()}),void this.hide()):void this.removeElem()},d.reveal=function(){delete this.isHidden,this.css({display:""});var t=this.layout.options,e={},i=this.getHideRevealTransitionEndProperty("visibleStyle");e[i]=this.onRevealTransitionEnd,this.transition({from:t.hiddenStyle,to:t.visibleStyle,isCleaning:!0,onTransitionEnd:e})},d.onRevealTransitionEnd=function(){this.isHidden||this.emitEvent("reveal")},d.getHideRevealTransitionEndProperty=function(t){var e=this.layout.options[t];if(e.opacity)return"opacity";for(var i in e)return i},d.hide=function(){this.isHidden=!0,this.css({display:""});var t=this.layout.options,e={},i=this.getHideRevealTransitionEndProperty("hiddenStyle");e[i]=this.onHideTransitionEnd,this.transition({from:t.visibleStyle,to:t.hiddenStyle,isCleaning:!0,onTransitionEnd:e})},d.onHideTransitionEnd=function(){this.isHidden&&(this.css({display:"none"}),this.emitEvent("hide"))},d.destroy=function(){this.css({position:"",left:"",right:"",top:"",bottom:"",transition:"",transform:""})},o}),function(t,e){"use strict";"function"==typeof define&&define.amd?define("outlayer/outlayer",["ev-emitter/ev-emitter","get-size/get-size","fizzy-ui-utils/utils","./item"],function(i,o,n,s){return e(t,i,o,n,s)}):"object"==typeof module&&module.exports?module.exports=e(t,require("ev-emitter"),require("get-size"),require("fizzy-ui-utils"),require("./item")):t.Outlayer=e(t,t.EvEmitter,t.getSize,t.fizzyUIUtils,t.Outlayer.Item)}(window,function(t,e,i,o,n){"use strict";function s(t,e){var i=o.getQueryElement(t);if(!i)return void(u&&u.error("Bad element for "+this.constructor.namespace+": "+(i||t)));this.element=i,h&&(this.$element=h(this.element)),this.options=o.extend({},this.constructor.defaults),this.option(e);var n=++l;this.element.outlayerGUID=n,f[n]=this,this._create();var s=this._getOption("initLayout");s&&this.layout()}function r(t){function e(){t.apply(this,arguments)}return e.prototype=Object.create(t.prototype),e.prototype.constructor=e,e}function a(t){if("number"==typeof t)return t;var e=t.match(/(^\d*\.?\d*)(\w*)/),i=e&&e[1],o=e&&e[2];if(!i.length)return 0;i=parseFloat(i);var n=m[o]||1;return i*n}var u=t.console,h=t.jQuery,d=function(){},l=0,f={};s.namespace="outlayer",s.Item=n,s.defaults={containerStyle:{position:"relative"},initLayout:!0,originLeft:!0,originTop:!0,resize:!0,resizeContainer:!0,transitionDuration:"0.4s",hiddenStyle:{opacity:0,transform:"scale(0.001)"},visibleStyle:{opacity:1,transform:"scale(1)"}};var c=s.prototype;o.extend(c,e.prototype),c.option=function(t){o.extend(this.options,t)},c._getOption=function(t){var e=this.constructor.compatOptions[t];return e&&void 0!==this.options[e]?this.options[e]:this.options[t]},s.compatOptions={initLayout:"isInitLayout",horizontal:"isHorizontal",layoutInstant:"isLayoutInstant",originLeft:"isOriginLeft",originTop:"isOriginTop",resize:"isResizeBound",resizeContainer:"isResizingContainer"},c._create=function(){this.reloadItems(),this.stamps=[],this.stamp(this.options.stamp),o.extend(this.element.style,this.options.containerStyle);var t=this._getOption("resize");t&&this.bindResize()},c.reloadItems=function(){this.items=this._itemize(this.element.children)},c._itemize=function(t){for(var e=this._filterFindItemElements(t),i=this.constructor.Item,o=[],n=0;n<e.length;n++){var s=e[n],r=new i(s,this);o.push(r)}return o},c._filterFindItemElements=function(t){return o.filterFindElements(t,this.options.itemSelector)},c.getItemElements=function(){return this.items.map(function(t){return t.element})},c.layout=function(){this._resetLayout(),this._manageStamps();var t=this._getOption("layoutInstant"),e=void 0!==t?t:!this._isLayoutInited;this.layoutItems(this.items,e),this._isLayoutInited=!0},c._init=c.layout,c._resetLayout=function(){this.getSize()},c.getSize=function(){this.size=i(this.element)},c._getMeasurement=function(t,e){var o,n=this.options[t];n?("string"==typeof n?o=this.element.querySelector(n):n instanceof HTMLElement&&(o=n),this[t]=o?i(o)[e]:n):this[t]=0},c.layoutItems=function(t,e){t=this._getItemsForLayout(t),this._layoutItems(t,e),this._postLayout()},c._getItemsForLayout=function(t){return t.filter(function(t){return!t.isIgnored})},c._layoutItems=function(t,e){if(this._emitCompleteOnItems("layout",t),t&&t.length){var i=[];t.forEach(function(t){var o=this._getItemLayoutPosition(t);o.item=t,o.isInstant=e||t.isLayoutInstant,i.push(o)},this),this._processLayoutQueue(i)}},c._getItemLayoutPosition=function(){return{x:0,y:0}},c._processLayoutQueue=function(t){this.updateStagger(),t.forEach(function(t,e){this._positionItem(t.item,t.x,t.y,t.isInstant,e)},this)},c.updateStagger=function(){var t=this.options.stagger;return null===t||void 0===t?void(this.stagger=0):(this.stagger=a(t),this.stagger)},c._positionItem=function(t,e,i,o,n){o?t.goTo(e,i):(t.stagger(n*this.stagger),t.moveTo(e,i))},c._postLayout=function(){this.resizeContainer()},c.resizeContainer=function(){var t=this._getOption("resizeContainer");if(t){var e=this._getContainerSize();e&&(this._setContainerMeasure(e.width,!0),this._setContainerMeasure(e.height,!1))}},c._getContainerSize=d,c._setContainerMeasure=function(t,e){if(void 0!==t){var i=this.size;i.isBorderBox&&(t+=e?i.paddingLeft+i.paddingRight+i.borderLeftWidth+i.borderRightWidth:i.paddingBottom+i.paddingTop+i.borderTopWidth+i.borderBottomWidth),t=Math.max(t,0),this.element.style[e?"width":"height"]=t+"px"}},c._emitCompleteOnItems=function(t,e){function i(){n.dispatchEvent(t+"Complete",null,[e])}function o(){r++,r==s&&i()}var n=this,s=e.length;if(!e||!s)return void i();var r=0;e.forEach(function(e){e.once(t,o)})},c.dispatchEvent=function(t,e,i){var o=e?[e].concat(i):i;if(this.emitEvent(t,o),h)if(this.$element=this.$element||h(this.element),e){var n=h.Event(e);n.type=t,this.$element.trigger(n,i)}else this.$element.trigger(t,i)},c.ignore=function(t){var e=this.getItem(t);e&&(e.isIgnored=!0)},c.unignore=function(t){var e=this.getItem(t);e&&delete e.isIgnored},c.stamp=function(t){t=this._find(t),t&&(this.stamps=this.stamps.concat(t),t.forEach(this.ignore,this))},c.unstamp=function(t){t=this._find(t),t&&t.forEach(function(t){o.removeFrom(this.stamps,t),this.unignore(t)},this)},c._find=function(t){if(t)return"string"==typeof t&&(t=this.element.querySelectorAll(t)),t=o.makeArray(t)},c._manageStamps=function(){this.stamps&&this.stamps.length&&(this._getBoundingRect(),this.stamps.forEach(this._manageStamp,this))},c._getBoundingRect=function(){var t=this.element.getBoundingClientRect(),e=this.size;this._boundingRect={left:t.left+e.paddingLeft+e.borderLeftWidth,top:t.top+e.paddingTop+e.borderTopWidth,right:t.right-(e.paddingRight+e.borderRightWidth),bottom:t.bottom-(e.paddingBottom+e.borderBottomWidth)}},c._manageStamp=d,c._getElementOffset=function(t){var e=t.getBoundingClientRect(),o=this._boundingRect,n=i(t),s={left:e.left-o.left-n.marginLeft,top:e.top-o.top-n.marginTop,right:o.right-e.right-n.marginRight,bottom:o.bottom-e.bottom-n.marginBottom};return s},c.handleEvent=o.handleEvent,c.bindResize=function(){t.addEventListener("resize",this),this.isResizeBound=!0},c.unbindResize=function(){t.removeEventListener("resize",this),this.isResizeBound=!1},c.onresize=function(){this.resize()},o.debounceMethod(s,"onresize",100),c.resize=function(){this.isResizeBound&&this.needsResizeLayout()&&this.layout()},c.needsResizeLayout=function(){var t=i(this.element),e=this.size&&t;return e&&t.innerWidth!==this.size.innerWidth},c.addItems=function(t){var e=this._itemize(t);return e.length&&(this.items=this.items.concat(e)),e},c.appended=function(t){var e=this.addItems(t);e.length&&(this.layoutItems(e,!0),this.reveal(e))},c.prepended=function(t){var e=this._itemize(t);if(e.length){var i=this.items.slice(0);this.items=e.concat(i),this._resetLayout(),this._manageStamps(),this.layoutItems(e,!0),this.reveal(e),this.layoutItems(i)}},c.reveal=function(t){if(this._emitCompleteOnItems("reveal",t),t&&t.length){var e=this.updateStagger();t.forEach(function(t,i){t.stagger(i*e),t.reveal()})}},c.hide=function(t){if(this._emitCompleteOnItems("hide",t),t&&t.length){var e=this.updateStagger();t.forEach(function(t,i){t.stagger(i*e),t.hide()})}},c.revealItemElements=function(t){var e=this.getItems(t);this.reveal(e)},c.hideItemElements=function(t){var e=this.getItems(t);this.hide(e)},c.getItem=function(t){for(var e=0;e<this.items.length;e++){var i=this.items[e];if(i.element==t)return i}},c.getItems=function(t){t=o.makeArray(t);var e=[];return t.forEach(function(t){var i=this.getItem(t);i&&e.push(i)},this),e},c.remove=function(t){var e=this.getItems(t);this._emitCompleteOnItems("remove",e),e&&e.length&&e.forEach(function(t){t.remove(),o.removeFrom(this.items,t)},this)},c.destroy=function(){var t=this.element.style;t.height="",t.position="",t.width="",this.items.forEach(function(t){t.destroy()}),this.unbindResize();var e=this.element.outlayerGUID;delete f[e],delete this.element.outlayerGUID,h&&h.removeData(this.element,this.constructor.namespace)},s.data=function(t){t=o.getQueryElement(t);var e=t&&t.outlayerGUID;return e&&f[e]},s.create=function(t,e){var i=r(s);return i.defaults=o.extend({},s.defaults),o.extend(i.defaults,e),i.compatOptions=o.extend({},s.compatOptions),i.namespace=t,i.data=s.data,i.Item=r(n),o.htmlInit(i,t),h&&h.bridget&&h.bridget(t,i),i};var m={ms:1,s:1e3};return s.Item=n,s}),function(t,e){"function"==typeof define&&define.amd?define("isotope/js/item",["outlayer/outlayer"],e):"object"==typeof module&&module.exports?module.exports=e(require("outlayer")):(t.Isotope=t.Isotope||{},t.Isotope.Item=e(t.Outlayer))}(window,function(t){"use strict";function e(){t.Item.apply(this,arguments)}var i=e.prototype=Object.create(t.Item.prototype),o=i._create;i._create=function(){this.id=this.layout.itemGUID++,o.call(this),this.sortData={}},i.updateSortData=function(){if(!this.isIgnored){this.sortData.id=this.id,this.sortData["original-order"]=this.id,this.sortData.random=Math.random();var t=this.layout.options.getSortData,e=this.layout._sorters;for(var i in t){var o=e[i];this.sortData[i]=o(this.element,this)}}};var n=i.destroy;return i.destroy=function(){n.apply(this,arguments),this.css({display:""})},e}),function(t,e){"function"==typeof define&&define.amd?define("isotope/js/layout-mode",["get-size/get-size","outlayer/outlayer"],e):"object"==typeof module&&module.exports?module.exports=e(require("get-size"),require("outlayer")):(t.Isotope=t.Isotope||{},t.Isotope.LayoutMode=e(t.getSize,t.Outlayer))}(window,function(t,e){"use strict";function i(t){this.isotope=t,t&&(this.options=t.options[this.namespace],this.element=t.element,this.items=t.filteredItems,this.size=t.size)}var o=i.prototype,n=["_resetLayout","_getItemLayoutPosition","_manageStamp","_getContainerSize","_getElementOffset","needsResizeLayout","_getOption"];return n.forEach(function(t){o[t]=function(){return e.prototype[t].apply(this.isotope,arguments)}}),o.needsVerticalResizeLayout=function(){var e=t(this.isotope.element),i=this.isotope.size&&e;return i&&e.innerHeight!=this.isotope.size.innerHeight},o._getMeasurement=function(){this.isotope._getMeasurement.apply(this,arguments)},o.getColumnWidth=function(){this.getSegmentSize("column","Width")},o.getRowHeight=function(){this.getSegmentSize("row","Height")},o.getSegmentSize=function(t,e){var i=t+e,o="outer"+e;if(this._getMeasurement(i,o),!this[i]){var n=this.getFirstItemSize();this[i]=n&&n[o]||this.isotope.size["inner"+e]}},o.getFirstItemSize=function(){var e=this.isotope.filteredItems[0];return e&&e.element&&t(e.element)},o.layout=function(){this.isotope.layout.apply(this.isotope,arguments)},o.getSize=function(){this.isotope.getSize(),this.size=this.isotope.size},i.modes={},i.create=function(t,e){function n(){i.apply(this,arguments)}return n.prototype=Object.create(o),n.prototype.constructor=n,e&&(n.options=e),n.prototype.namespace=t,i.modes[t]=n,n},i}),function(t,e){"function"==typeof define&&define.amd?define("masonry/masonry",["outlayer/outlayer","get-size/get-size"],e):"object"==typeof module&&module.exports?module.exports=e(require("outlayer"),require("get-size")):t.Masonry=e(t.Outlayer,t.getSize)}(window,function(t,e){var i=t.create("masonry");i.compatOptions.fitWidth="isFitWidth";var o=i.prototype;return o._resetLayout=function(){this.getSize(),this._getMeasurement("columnWidth","outerWidth"),this._getMeasurement("gutter","outerWidth"),this.measureColumns(),this.colYs=[];for(var t=0;t<this.cols;t++)this.colYs.push(0);this.maxY=0,this.horizontalColIndex=0},o.measureColumns=function(){if(this.getContainerWidth(),!this.columnWidth){var t=this.items[0],i=t&&t.element;this.columnWidth=i&&e(i).outerWidth||this.containerWidth}var o=this.columnWidth+=this.gutter,n=this.containerWidth+this.gutter,s=n/o,r=o-n%o,a=r&&r<1?"round":"floor";s=Math[a](s),this.cols=Math.max(s,1)},o.getContainerWidth=function(){var t=this._getOption("fitWidth"),i=t?this.element.parentNode:this.element,o=e(i);this.containerWidth=o&&o.innerWidth},o._getItemLayoutPosition=function(t){t.getSize();var e=t.size.outerWidth%this.columnWidth,i=e&&e<1?"round":"ceil",o=Math[i](t.size.outerWidth/this.columnWidth);o=Math.min(o,this.cols);for(var n=this.options.horizontalOrder?"_getHorizontalColPosition":"_getTopColPosition",s=this[n](o,t),r={x:this.columnWidth*s.col,y:s.y},a=s.y+t.size.outerHeight,u=o+s.col,h=s.col;h<u;h++)this.colYs[h]=a;return r},o._getTopColPosition=function(t){var e=this._getTopColGroup(t),i=Math.min.apply(Math,e);return{col:e.indexOf(i),y:i}},o._getTopColGroup=function(t){if(t<2)return this.colYs;for(var e=[],i=this.cols+1-t,o=0;o<i;o++)e[o]=this._getColGroupY(o,t);return e},o._getColGroupY=function(t,e){if(e<2)return this.colYs[t];var i=this.colYs.slice(t,t+e);return Math.max.apply(Math,i)},o._getHorizontalColPosition=function(t,e){var i=this.horizontalColIndex%this.cols,o=t>1&&i+t>this.cols;i=o?0:i;var n=e.size.outerWidth&&e.size.outerHeight;return this.horizontalColIndex=n?i+t:this.horizontalColIndex,{col:i,y:this._getColGroupY(i,t)}},o._manageStamp=function(t){var i=e(t),o=this._getElementOffset(t),n=this._getOption("originLeft"),s=n?o.left:o.right,r=s+i.outerWidth,a=Math.floor(s/this.columnWidth);a=Math.max(0,a);var u=Math.floor(r/this.columnWidth);u-=r%this.columnWidth?0:1,u=Math.min(this.cols-1,u);for(var h=this._getOption("originTop"),d=(h?o.top:o.bottom)+i.outerHeight,l=a;l<=u;l++)this.colYs[l]=Math.max(d,this.colYs[l])},o._getContainerSize=function(){this.maxY=Math.max.apply(Math,this.colYs);var t={height:this.maxY};return this._getOption("fitWidth")&&(t.width=this._getContainerFitWidth()),t},o._getContainerFitWidth=function(){for(var t=0,e=this.cols;--e&&0===this.colYs[e];)t++;return(this.cols-t)*this.columnWidth-this.gutter},o.needsResizeLayout=function(){var t=this.containerWidth;return this.getContainerWidth(),t!=this.containerWidth},i}),function(t,e){"function"==typeof define&&define.amd?define("isotope/js/layout-modes/masonry",["../layout-mode","masonry/masonry"],e):"object"==typeof module&&module.exports?module.exports=e(require("../layout-mode"),require("masonry-layout")):e(t.Isotope.LayoutMode,t.Masonry)}(window,function(t,e){"use strict";var i=t.create("masonry"),o=i.prototype,n={_getElementOffset:!0,layout:!0,_getMeasurement:!0};for(var s in e.prototype)n[s]||(o[s]=e.prototype[s]);var r=o.measureColumns;o.measureColumns=function(){this.items=this.isotope.filteredItems,r.call(this)};var a=o._getOption;return o._getOption=function(t){return"fitWidth"==t?void 0!==this.options.isFitWidth?this.options.isFitWidth:this.options.fitWidth:a.apply(this.isotope,arguments)},i}),function(t,e){"function"==typeof define&&define.amd?define("isotope/js/layout-modes/fit-rows",["../layout-mode"],e):"object"==typeof exports?module.exports=e(require("../layout-mode")):e(t.Isotope.LayoutMode)}(window,function(t){"use strict";var e=t.create("fitRows"),i=e.prototype;return i._resetLayout=function(){this.x=0,this.y=0,this.maxY=0,this._getMeasurement("gutter","outerWidth")},i._getItemLayoutPosition=function(t){t.getSize();var e=t.size.outerWidth+this.gutter,i=this.isotope.size.innerWidth+this.gutter;0!==this.x&&e+this.x>i&&(this.x=0,this.y=this.maxY);var o={x:this.x,y:this.y};return this.maxY=Math.max(this.maxY,this.y+t.size.outerHeight),this.x+=e,o},i._getContainerSize=function(){return{height:this.maxY}},e}),function(t,e){"function"==typeof define&&define.amd?define("isotope/js/layout-modes/vertical",["../layout-mode"],e):"object"==typeof module&&module.exports?module.exports=e(require("../layout-mode")):e(t.Isotope.LayoutMode)}(window,function(t){"use strict";var e=t.create("vertical",{horizontalAlignment:0}),i=e.prototype;return i._resetLayout=function(){this.y=0},i._getItemLayoutPosition=function(t){t.getSize();var e=(this.isotope.size.innerWidth-t.size.outerWidth)*this.options.horizontalAlignment,i=this.y;return this.y+=t.size.outerHeight,{x:e,y:i}},i._getContainerSize=function(){return{height:this.y}},e}),function(t,e){"function"==typeof define&&define.amd?define(["outlayer/outlayer","get-size/get-size","desandro-matches-selector/matches-selector","fizzy-ui-utils/utils","isotope/js/item","isotope/js/layout-mode","isotope/js/layout-modes/masonry","isotope/js/layout-modes/fit-rows","isotope/js/layout-modes/vertical"],function(i,o,n,s,r,a){return e(t,i,o,n,s,r,a)}):"object"==typeof module&&module.exports?module.exports=e(t,require("outlayer"),require("get-size"),require("desandro-matches-selector"),require("fizzy-ui-utils"),require("isotope/js/item"),require("isotope/js/layout-mode"),require("isotope/js/layout-modes/masonry"),require("isotope/js/layout-modes/fit-rows"),require("isotope/js/layout-modes/vertical")):t.Isotope=e(t,t.Outlayer,t.getSize,t.matchesSelector,t.fizzyUIUtils,t.Isotope.Item,t.Isotope.LayoutMode)}(window,function(t,e,i,o,n,s,r){function a(t,e){return function(i,o){for(var n=0;n<t.length;n++){var s=t[n],r=i.sortData[s],a=o.sortData[s];if(r>a||r<a){var u=void 0!==e[s]?e[s]:e,h=u?1:-1;return(r>a?1:-1)*h}}return 0}}var u=t.jQuery,h=String.prototype.trim?function(t){return t.trim()}:function(t){return t.replace(/^\s+|\s+$/g,"")},d=e.create("isotope",{layoutMode:"masonry",isJQueryFiltering:!0,sortAscending:!0});d.Item=s,d.LayoutMode=r;var l=d.prototype;l._create=function(){this.itemGUID=0,this._sorters={},this._getSorters(),e.prototype._create.call(this),this.modes={},this.filteredItems=this.items,this.sortHistory=["original-order"];for(var t in r.modes)this._initLayoutMode(t)},l.reloadItems=function(){this.itemGUID=0,e.prototype.reloadItems.call(this)},l._itemize=function(){for(var t=e.prototype._itemize.apply(this,arguments),i=0;i<t.length;i++){var o=t[i];o.id=this.itemGUID++}return this._updateItemsSortData(t),t},l._initLayoutMode=function(t){var e=r.modes[t],i=this.options[t]||{};this.options[t]=e.options?n.extend(e.options,i):i,this.modes[t]=new e(this)},l.layout=function(){return!this._isLayoutInited&&this._getOption("initLayout")?void this.arrange():void this._layout()},l._layout=function(){var t=this._getIsInstant();this._resetLayout(),this._manageStamps(),this.layoutItems(this.filteredItems,t),this._isLayoutInited=!0},l.arrange=function(t){this.option(t),this._getIsInstant();var e=this._filter(this.items);this.filteredItems=e.matches,this._bindArrangeComplete(),this._isInstant?this._noTransition(this._hideReveal,[e]):this._hideReveal(e),this._sort(),this._layout()},l._init=l.arrange,l._hideReveal=function(t){this.reveal(t.needReveal),this.hide(t.needHide)},l._getIsInstant=function(){var t=this._getOption("layoutInstant"),e=void 0!==t?t:!this._isLayoutInited;return this._isInstant=e,e},l._bindArrangeComplete=function(){function t(){e&&i&&o&&n.dispatchEvent("arrangeComplete",null,[n.filteredItems])}var e,i,o,n=this;this.once("layoutComplete",function(){e=!0,t()}),this.once("hideComplete",function(){i=!0,t()}),this.once("revealComplete",function(){o=!0,t()})},l._filter=function(t){var e=this.options.filter;e=e||"*";for(var i=[],o=[],n=[],s=this._getFilterTest(e),r=0;r<t.length;r++){var a=t[r];if(!a.isIgnored){var u=s(a);u&&i.push(a),u&&a.isHidden?o.push(a):u||a.isHidden||n.push(a)}}return{matches:i,needReveal:o,needHide:n}},l._getFilterTest=function(t){return u&&this.options.isJQueryFiltering?function(e){return u(e.element).is(t)}:"function"==typeof t?function(e){return t(e.element)}:function(e){return o(e.element,t)}},l.updateSortData=function(t){
var e;t?(t=n.makeArray(t),e=this.getItems(t)):e=this.items,this._getSorters(),this._updateItemsSortData(e)},l._getSorters=function(){var t=this.options.getSortData;for(var e in t){var i=t[e];this._sorters[e]=f(i)}},l._updateItemsSortData=function(t){for(var e=t&&t.length,i=0;e&&i<e;i++){var o=t[i];o.updateSortData()}};var f=function(){function t(t){if("string"!=typeof t)return t;var i=h(t).split(" "),o=i[0],n=o.match(/^\[(.+)\]$/),s=n&&n[1],r=e(s,o),a=d.sortDataParsers[i[1]];return t=a?function(t){return t&&a(r(t))}:function(t){return t&&r(t)}}function e(t,e){return t?function(e){return e.getAttribute(t)}:function(t){var i=t.querySelector(e);return i&&i.textContent}}return t}();d.sortDataParsers={parseInt:function(t){return parseInt(t,10)},parseFloat:function(t){return parseFloat(t)}},l._sort=function(){if(this.options.sortBy){var t=n.makeArray(this.options.sortBy);this._getIsSameSortBy(t)||(this.sortHistory=t.concat(this.sortHistory));var e=a(this.sortHistory,this.options.sortAscending);this.filteredItems.sort(e)}},l._getIsSameSortBy=function(t){for(var e=0;e<t.length;e++)if(t[e]!=this.sortHistory[e])return!1;return!0},l._mode=function(){var t=this.options.layoutMode,e=this.modes[t];if(!e)throw new Error("No layout mode: "+t);return e.options=this.options[t],e},l._resetLayout=function(){e.prototype._resetLayout.call(this),this._mode()._resetLayout()},l._getItemLayoutPosition=function(t){return this._mode()._getItemLayoutPosition(t)},l._manageStamp=function(t){this._mode()._manageStamp(t)},l._getContainerSize=function(){return this._mode()._getContainerSize()},l.needsResizeLayout=function(){return this._mode().needsResizeLayout()},l.appended=function(t){var e=this.addItems(t);if(e.length){var i=this._filterRevealAdded(e);this.filteredItems=this.filteredItems.concat(i)}},l.prepended=function(t){var e=this._itemize(t);if(e.length){this._resetLayout(),this._manageStamps();var i=this._filterRevealAdded(e);this.layoutItems(this.filteredItems),this.filteredItems=i.concat(this.filteredItems),this.items=e.concat(this.items)}},l._filterRevealAdded=function(t){var e=this._filter(t);return this.hide(e.needHide),this.reveal(e.matches),this.layoutItems(e.matches,!0),e.matches},l.insert=function(t){var e=this.addItems(t);if(e.length){var i,o,n=e.length;for(i=0;i<n;i++)o=e[i],this.element.appendChild(o.element);var s=this._filter(e).matches;for(i=0;i<n;i++)e[i].isLayoutInstant=!0;for(this.arrange(),i=0;i<n;i++)delete e[i].isLayoutInstant;this.reveal(s)}};var c=l.remove;return l.remove=function(t){t=n.makeArray(t);var e=this.getItems(t);c.call(this,t);for(var i=e&&e.length,o=0;i&&o<i;o++){var s=e[o];n.removeFrom(this.filteredItems,s)}},l.shuffle=function(){for(var t=0;t<this.items.length;t++){var e=this.items[t];e.sortData.random=Math.random()}this.options.sortBy="random",this._sort(),this._layout()},l._noTransition=function(t,e){var i=this.options.transitionDuration;this.options.transitionDuration=0;var o=t.apply(this,e);return this.options.transitionDuration=i,o},l.getFilteredItemElements=function(){return this.filteredItems.map(function(t){return t.element})},d});


/*------------------------------------------------------------------*/
/*	06) SCROLL TO
/*------------------------------------------------------------------*/

/*!
 * jquery.scrollto.js 0.0.1 - https://github.com/yckart/jquery.scrollto.js
 * Scroll smooth to any element in your DOM.
 *
 * copyright (c) 2012 Yannick Albert (http://yckart.com)
 * Licensed under the MIT license (http://www.opensource.org/licenses/mit-license.php).
 * 2013/02/17
 **/
$.scrollTo=$.fn.scrollTo=function(o,t,n){return this instanceof $?(n=$.extend({},{gap:{x:0,y:0},animation:{easing:"swing",duration:600,complete:$.noop,step:$.noop}},n),this.each(function(){var a=$(this);a.stop().animate({scrollLeft:isNaN(Number(o))?$(t).offset().left+n.gap.x:o,scrollTop:isNaN(Number(t))?$(t).offset().top+n.gap.y:t},n.animation)})):$.fn.scrollTo.apply($("html, body"),arguments)};

/*------------------------------------------------------------------*/
/*	07) EASING
/*------------------------------------------------------------------*/

jQuery.easing.jswing=jQuery.easing.swing;
jQuery.extend(jQuery.easing,{def:"easeOutQuad",swing:function(e,a,c,b,d){return jQuery.easing[jQuery.easing.def](e,a,c,b,d)},easeInQuad:function(e,a,c,b,d){return b*(a/=d)*a+c},easeOutQuad:function(e,a,c,b,d){return-b*(a/=d)*(a-2)+c},easeInOutQuad:function(e,a,c,b,d){if((a/=d/2)<1)return b/2*a*a+c;return-b/2*(--a*(a-2)-1)+c},easeInCubic:function(e,a,c,b,d){return b*(a/=d)*a*a+c},easeOutCubic:function(e,a,c,b,d){return b*((a=a/d-1)*a*a+1)+c},easeInOutCubic:function(e,a,c,b,d){if((a/=d/2)<1)return b/
2*a*a*a+c;return b/2*((a-=2)*a*a+2)+c},easeInQuart:function(e,a,c,b,d){return b*(a/=d)*a*a*a+c},easeOutQuart:function(e,a,c,b,d){return-b*((a=a/d-1)*a*a*a-1)+c},easeInOutQuart:function(e,a,c,b,d){if((a/=d/2)<1)return b/2*a*a*a*a+c;return-b/2*((a-=2)*a*a*a-2)+c},easeInQuint:function(e,a,c,b,d){return b*(a/=d)*a*a*a*a+c},easeOutQuint:function(e,a,c,b,d){return b*((a=a/d-1)*a*a*a*a+1)+c},easeInOutQuint:function(e,a,c,b,d){if((a/=d/2)<1)return b/2*a*a*a*a*a+c;return b/2*((a-=2)*a*a*a*a+2)+c},easeInSine:function(e,
a,c,b,d){return-b*Math.cos(a/d*(Math.PI/2))+b+c},easeOutSine:function(e,a,c,b,d){return b*Math.sin(a/d*(Math.PI/2))+c},easeInOutSine:function(e,a,c,b,d){return-b/2*(Math.cos(Math.PI*a/d)-1)+c},easeInExpo:function(e,a,c,b,d){return a==0?c:b*Math.pow(2,10*(a/d-1))+c},easeOutExpo:function(e,a,c,b,d){return a==d?c+b:b*(-Math.pow(2,-10*a/d)+1)+c},easeInOutExpo:function(e,a,c,b,d){if(a==0)return c;if(a==d)return c+b;if((a/=d/2)<1)return b/2*Math.pow(2,10*(a-1))+c;return b/2*(-Math.pow(2,-10*--a)+2)+c},
easeInCirc:function(e,a,c,b,d){return-b*(Math.sqrt(1-(a/=d)*a)-1)+c},easeOutCirc:function(e,a,c,b,d){return b*Math.sqrt(1-(a=a/d-1)*a)+c},easeInOutCirc:function(e,a,c,b,d){if((a/=d/2)<1)return-b/2*(Math.sqrt(1-a*a)-1)+c;return b/2*(Math.sqrt(1-(a-=2)*a)+1)+c},easeInElastic:function(e,a,c,b,d){e=1.70158;var f=0,g=b;if(a==0)return c;if((a/=d)==1)return c+b;f||(f=d*0.3);if(g<Math.abs(b)){g=b;e=f/4}else e=f/(2*Math.PI)*Math.asin(b/g);return-(g*Math.pow(2,10*(a-=1))*Math.sin((a*d-e)*2*Math.PI/f))+c},easeOutElastic:function(e,
a,c,b,d){e=1.70158;var f=0,g=b;if(a==0)return c;if((a/=d)==1)return c+b;f||(f=d*0.3);if(g<Math.abs(b)){g=b;e=f/4}else e=f/(2*Math.PI)*Math.asin(b/g);return g*Math.pow(2,-10*a)*Math.sin((a*d-e)*2*Math.PI/f)+b+c},easeInOutElastic:function(e,a,c,b,d){e=1.70158;var f=0,g=b;if(a==0)return c;if((a/=d/2)==2)return c+b;f||(f=d*0.3*1.5);if(g<Math.abs(b)){g=b;e=f/4}else e=f/(2*Math.PI)*Math.asin(b/g);if(a<1)return-0.5*g*Math.pow(2,10*(a-=1))*Math.sin((a*d-e)*2*Math.PI/f)+c;return g*Math.pow(2,-10*(a-=1))*Math.sin((a*
d-e)*2*Math.PI/f)*0.5+b+c},easeInBack:function(e,a,c,b,d,f){if(f==undefined)f=1.70158;return b*(a/=d)*a*((f+1)*a-f)+c},easeOutBack:function(e,a,c,b,d,f){if(f==undefined)f=1.70158;return b*((a=a/d-1)*a*((f+1)*a+f)+1)+c},easeInOutBack:function(e,a,c,b,d,f){if(f==undefined)f=1.70158;if((a/=d/2)<1)return b/2*a*a*(((f*=1.525)+1)*a-f)+c;return b/2*((a-=2)*a*(((f*=1.525)+1)*a+f)+2)+c},easeInBounce:function(e,a,c,b,d){return b-jQuery.easing.easeOutBounce(e,d-a,0,b,d)+c},easeOutBounce:function(e,a,c,b,d){return(a/=
d)<1/2.75?b*7.5625*a*a+c:a<2/2.75?b*(7.5625*(a-=1.5/2.75)*a+0.75)+c:a<2.5/2.75?b*(7.5625*(a-=2.25/2.75)*a+0.9375)+c:b*(7.5625*(a-=2.625/2.75)*a+0.984375)+c},easeInOutBounce:function(e,a,c,b,d){if(a<d/2)return jQuery.easing.easeInBounce(e,a*2,0,b,d)*0.5+c;return jQuery.easing.easeOutBounce(e,a*2-d,0,b,d)*0.5+b*0.5+c}});


/*------------------------------------------------------------------*/
/*	09) VEGAS SLIDER
/*------------------------------------------------------------------*/


!function(t){"use strict";var s={slide:0,delay:5e3,loop:!0,preload:!1,preloadImage:!1,preloadVideo:!1,timer:!0,overlay:!1,autoplay:!0,shuffle:!1,cover:!0,color:null,align:"center",valign:"center",firstTransition:null,firstTransitionDuration:null,transition:"fade",transitionDuration:1e3,transitionRegister:[],animation:null,animationDuration:"auto",animationRegister:[],slidesToKeep:1,init:function(){},play:function(){},pause:function(){},walk:function(){},slides:[]},i={},e=function(i,e){this.elmt=i,this.settings=t.extend({},s,t.vegas.defaults,e),this.slide=this.settings.slide,this.total=this.settings.slides.length,this.noshow=this.total<2,this.paused=!this.settings.autoplay||this.noshow,this.ended=!1,this.$elmt=t(i),this.$timer=null,this.$overlay=null,this.$slide=null,this.timeout=null,this.first=!0,this.transitions=["fade","fade2","blur","blur2","flash","flash2","negative","negative2","burn","burn2","slideLeft","slideLeft2","slideRight","slideRight2","slideUp","slideUp2","slideDown","slideDown2","zoomIn","zoomIn2","zoomOut","zoomOut2","swirlLeft","swirlLeft2","swirlRight","swirlRight2"],this.animations=["kenburns","kenburnsLeft","kenburnsRight","kenburnsUp","kenburnsUpLeft","kenburnsUpRight","kenburnsDown","kenburnsDownLeft","kenburnsDownRight"],this.settings.transitionRegister instanceof Array==!1&&(this.settings.transitionRegister=[this.settings.transitionRegister]),this.settings.animationRegister instanceof Array==!1&&(this.settings.animationRegister=[this.settings.animationRegister]),this.transitions=this.transitions.concat(this.settings.transitionRegister),this.animations=this.animations.concat(this.settings.animationRegister),this.support={objectFit:"objectFit"in document.body.style,transition:"transition"in document.body.style||"WebkitTransition"in document.body.style,video:t.vegas.isVideoCompatible()},this.settings.shuffle===!0&&this.shuffle(),this._init()};e.prototype={_init:function(){var s,i,e,n="BODY"===this.elmt.tagName,o=this.settings.timer,a=this.settings.overlay,r=this;this._preload(),n||(this.$elmt.css("height",this.$elmt.css("height")),s=t('<div class="vegas-wrapper">').css("overflow",this.$elmt.css("overflow")).css("padding",this.$elmt.css("padding")),this.$elmt.css("padding")||s.css("padding-top",this.$elmt.css("padding-top")).css("padding-bottom",this.$elmt.css("padding-bottom")).css("padding-left",this.$elmt.css("padding-left")).css("padding-right",this.$elmt.css("padding-right")),this.$elmt.clone(!0).children().appendTo(s),this.elmt.innerHTML=""),o&&this.support.transition&&(e=t('<div class="vegas-timer"><div class="vegas-timer-progress">'),this.$timer=e,this.$elmt.prepend(e)),a&&(i=t('<div class="vegas-overlay">'),"string"==typeof a&&i.css("background-image","url("+a+")"),this.$overlay=i,this.$elmt.prepend(i)),this.$elmt.addClass("vegas-container"),n||this.$elmt.append(s),setTimeout(function(){r.trigger("init"),r._goto(r.slide),r.settings.autoplay&&r.trigger("play")},1)},_preload:function(){var t,s;for(s=0;s<this.settings.slides.length;s++)(this.settings.preload||this.settings.preloadImages)&&this.settings.slides[s].src&&(t=new Image,t.src=this.settings.slides[s].src),(this.settings.preload||this.settings.preloadVideos)&&this.support.video&&this.settings.slides[s].video&&(this.settings.slides[s].video instanceof Array?this._video(this.settings.slides[s].video):this._video(this.settings.slides[s].video.src))},_random:function(t){return t[Math.floor(Math.random()*t.length)]},_slideShow:function(){var t=this;this.total>1&&!this.ended&&!this.paused&&!this.noshow&&(this.timeout=setTimeout(function(){t.next()},this._options("delay")))},_timer:function(t){var s=this;clearTimeout(this.timeout),this.$timer&&(this.$timer.removeClass("vegas-timer-running").find("div").css("transition-duration","0ms"),this.ended||this.paused||this.noshow||t&&setTimeout(function(){s.$timer.addClass("vegas-timer-running").find("div").css("transition-duration",s._options("delay")-100+"ms")},100))},_video:function(t){var s,e,n=t.toString();return i[n]?i[n]:(t instanceof Array==!1&&(t=[t]),s=document.createElement("video"),s.preload=!0,t.forEach(function(t){e=document.createElement("source"),e.src=t,s.appendChild(e)}),i[n]=s,s)},_fadeOutSound:function(t,s){var i=this,e=s/10,n=t.volume-.09;n>0?(t.volume=n,setTimeout(function(){i._fadeOutSound(t,s)},e)):t.pause()},_fadeInSound:function(t,s){var i=this,e=s/10,n=t.volume+.09;n<1&&(t.volume=n,setTimeout(function(){i._fadeInSound(t,s)},e))},_options:function(t,s){return void 0===s&&(s=this.slide),void 0!==this.settings.slides[s][t]?this.settings.slides[s][t]:this.settings[t]},_goto:function(s){function i(){f._timer(!0),setTimeout(function(){y&&(f.support.transition?(h.css("transition","all "+_+"ms").addClass("vegas-transition-"+y+"-out"),h.each(function(){var t=h.find("video").get(0);t&&(t.volume=1,f._fadeOutSound(t,_))}),e.css("transition","all "+_+"ms").addClass("vegas-transition-"+y+"-in")):e.fadeIn(_));for(var t=0;t<h.length-f.settings.slidesToKeep;t++)h.eq(t).remove();f.trigger("walk"),f._slideShow()},100)}"undefined"==typeof this.settings.slides[s]&&(s=0),this.slide=s;var e,n,o,a,r,h=this.$elmt.children(".vegas-slide"),d=this.settings.slides[s].src,l=this.settings.slides[s].video,g=this._options("delay"),u=this._options("align"),c=this._options("valign"),p=this._options("cover"),m=this._options("color")||this.$elmt.css("background-color"),f=this,v=h.length,y=this._options("transition"),_=this._options("transitionDuration"),w=this._options("animation"),b=this._options("animationDuration");this.settings.firstTransition&&this.first&&(y=this.settings.firstTransition||y),this.settings.firstTransitionDuration&&this.first&&(_=this.settings.firstTransitionDuration||_),this.first&&(this.first=!1),"repeat"!==p&&(p===!0?p="cover":p===!1&&(p="contain")),("random"===y||y instanceof Array)&&(y=y instanceof Array?this._random(y):this._random(this.transitions)),("random"===w||w instanceof Array)&&(w=w instanceof Array?this._random(w):this._random(this.animations)),("auto"===_||_>g)&&(_=g),"auto"===b&&(b=g),e=t('<div class="vegas-slide"></div>'),this.support.transition&&y&&e.addClass("vegas-transition-"+y),this.support.video&&l?(a=l instanceof Array?this._video(l):this._video(l.src),a.loop=void 0===l.loop||l.loop,a.muted=void 0===l.mute||l.mute,a.muted===!1?(a.volume=0,this._fadeInSound(a,_)):a.pause(),o=t(a).addClass("vegas-video").css("background-color",m),this.support.objectFit?o.css("object-position",u+" "+c).css("object-fit",p).css("width","100%").css("height","100%"):"contain"===p&&o.css("width","100%").css("height","100%"),e.append(o)):(r=new Image,n=t('<div class="vegas-slide-inner"></div>').css("background-image",'url("'+d+'")').css("background-color",m).css("background-position",u+" "+c),"repeat"===p?n.css("background-repeat","repeat"):n.css("background-size",p),this.support.transition&&w&&n.addClass("vegas-animation-"+w).css("animation-duration",b+"ms"),e.append(n)),this.support.transition||e.css("display","none"),v?h.eq(v-1).after(e):this.$elmt.prepend(e),h.css("transition","all 0ms").each(function(){this.className="vegas-slide","VIDEO"===this.tagName&&(this.className+=" vegas-video"),y&&(this.className+=" vegas-transition-"+y,this.className+=" vegas-transition-"+y+"-in")}),f._timer(!1),a?(4===a.readyState&&(a.currentTime=0),a.play(),i()):(r.src=d,r.complete?i():r.onload=i)},_end:function(){this.ended=!0,this._timer(!1),this.trigger("end")},shuffle:function(){for(var t,s,i=this.total-1;i>0;i--)s=Math.floor(Math.random()*(i+1)),t=this.settings.slides[i],this.settings.slides[i]=this.settings.slides[s],this.settings.slides[s]=t},play:function(){this.paused&&(this.paused=!1,this.next(),this.trigger("play"))},pause:function(){this._timer(!1),this.paused=!0,this.trigger("pause")},toggle:function(){this.paused?this.play():this.pause()},playing:function(){return!this.paused&&!this.noshow},current:function(t){return t?{slide:this.slide,data:this.settings.slides[this.slide]}:this.slide},jump:function(t){t<0||t>this.total-1||t===this.slide||(this.slide=t,this._goto(this.slide))},next:function(){if(this.slide++,this.slide>=this.total){if(!this.settings.loop)return this._end();this.slide=0}this._goto(this.slide)},previous:function(){if(this.slide--,this.slide<0){if(!this.settings.loop)return void this.slide++;this.slide=this.total-1}this._goto(this.slide)},trigger:function(t){var s=[];s="init"===t?[this.settings]:[this.slide,this.settings.slides[this.slide]],this.$elmt.trigger("vegas"+t,s),"function"==typeof this.settings[t]&&this.settings[t].apply(this.$elmt,s)},options:function(i,e){var n=this.settings.slides.slice();if("object"==typeof i)this.settings=t.extend({},s,t.vegas.defaults,i);else{if("string"!=typeof i)return this.settings;if(void 0===e)return this.settings[i];this.settings[i]=e}this.settings.slides!==n&&(this.total=this.settings.slides.length,this.noshow=this.total<2,this._preload())},destroy:function(){clearTimeout(this.timeout),this.$elmt.removeClass("vegas-container"),this.$elmt.find("> .vegas-slide").remove(),this.$elmt.find("> .vegas-wrapper").clone(!0).children().appendTo(this.$elmt),this.$elmt.find("> .vegas-wrapper").remove(),this.settings.timer&&this.$timer.remove(),this.settings.overlay&&this.$overlay.remove(),this.elmt._vegas=null}},t.fn.vegas=function(t){var s,i=arguments,n=!1;if(void 0===t||"object"==typeof t)return this.each(function(){this._vegas||(this._vegas=new e(this,t))});if("string"==typeof t){if(this.each(function(){var e=this._vegas;if(!e)throw new Error("No Vegas applied to this element.");"function"==typeof e[t]&&"_"!==t[0]?s=e[t].apply(e,[].slice.call(i,1)):n=!0}),n)throw new Error('No method "'+t+'" in Vegas.');return void 0!==s?s:this}},t.vegas={},t.vegas.defaults=s,t.vegas.isVideoCompatible=function(){return!/(Android|webOS|Phone|iPad|iPod|BlackBerry|Windows Phone)/i.test(navigator.userAgent)}}(window.jQuery||window.Zepto);
//# sourceMappingURL=vegas.min.js.map

/*------------------------------------------------------------------*/
/*	10) RIPPLE
/*------------------------------------------------------------------*/

/**
 * jQuery Ripples plugin v0.6.2 / https://github.com/sirxemic/jquery.ripples
 * MIT License
 * @author sirxemic / https://sirxemic.com/
 */

!function(e,t){"object"==typeof exports&&"undefined"!=typeof module?t(require("jquery")):"function"==typeof define&&define.amd?define(["jquery"],t):t(e.$)}(this,function(e){"use strict";function t(e){return"%"==e[e.length-1]}function r(e){var t=e.split(" ");if(1!==t.length)return t.map(function(t){switch(e){case"center":return"50%";case"top":case"left":return"0";case"right":case"bottom":return"100%";default:return t}});switch(e){case"center":return["50%","50%"];case"top":return["50%","0"];case"bottom":return["50%","100%"];case"left":return["0","50%"];case"right":return["100%","50%"];default:return[e,"50%"]}}function i(e,t,r){function i(e,t){var r=s.createShader(e);if(s.shaderSource(r,t),s.compileShader(r),!s.getShaderParameter(r,s.COMPILE_STATUS))throw new Error("compile error: "+s.getShaderInfoLog(r));return r}var o={};if(o.id=s.createProgram(),s.attachShader(o.id,i(s.VERTEX_SHADER,e)),s.attachShader(o.id,i(s.FRAGMENT_SHADER,t)),s.linkProgram(o.id),!s.getProgramParameter(o.id,s.LINK_STATUS))throw new Error("link error: "+s.getProgramInfoLog(o.id));o.uniforms={},o.locations={},s.useProgram(o.id),s.enableVertexAttribArray(0);for(var n,a,u=/uniform (\w+) (\w+)/g,h=e+t;null!=(n=u.exec(h));)a=n[2],o.locations[a]=s.getUniformLocation(o.id,a);return o}function o(e,t){s.activeTexture(s.TEXTURE0+(t||0)),s.bindTexture(s.TEXTURE_2D,e)}function n(e){var t=/url\(["']?([^"']*)["']?\)/.exec(e);return null==t?null:t[1]}function a(e){return e.match(/^data:/)}var s,u=(e=e&&"default"in e?e.default:e)(window),h=function(){function e(e,t,i){var o="OES_texture_"+e,n=o+"_linear",a=n in r,s=[o];return a&&s.push(n),{type:t,arrayType:i,linearSupport:a,extensions:s}}var t=document.createElement("canvas");if(!(s=t.getContext("webgl")||t.getContext("experimental-webgl")))return null;var r={};if(["OES_texture_float","OES_texture_half_float","OES_texture_float_linear","OES_texture_half_float_linear"].forEach(function(e){var t=s.getExtension(e);t&&(r[e]=t)}),!r.OES_texture_float)return null;var i=[];i.push(e("float",s.FLOAT,Float32Array)),r.OES_texture_half_float&&i.push(e("half_float",r.OES_texture_half_float.HALF_FLOAT_OES,null));var o=s.createTexture(),n=s.createFramebuffer();s.bindFramebuffer(s.FRAMEBUFFER,n),s.bindTexture(s.TEXTURE_2D,o),s.texParameteri(s.TEXTURE_2D,s.TEXTURE_MIN_FILTER,s.NEAREST),s.texParameteri(s.TEXTURE_2D,s.TEXTURE_MAG_FILTER,s.NEAREST),s.texParameteri(s.TEXTURE_2D,s.TEXTURE_WRAP_S,s.CLAMP_TO_EDGE),s.texParameteri(s.TEXTURE_2D,s.TEXTURE_WRAP_T,s.CLAMP_TO_EDGE);for(var a=null,u=0;u<i.length;u++)if(s.texImage2D(s.TEXTURE_2D,0,s.RGBA,32,32,0,s.RGBA,i[u].type,null),s.framebufferTexture2D(s.FRAMEBUFFER,s.COLOR_ATTACHMENT0,s.TEXTURE_2D,o,0),s.checkFramebufferStatus(s.FRAMEBUFFER)===s.FRAMEBUFFER_COMPLETE){a=i[u];break}return a}(),c=function(e,t){try{return new ImageData(e,t)}catch(r){return document.createElement("canvas").getContext("2d").createImageData(e,t)}}(32,32);e("head").prepend("<style>.jquery-ripples { position: relative; z-index: 0; }</style>");var d=function(t,r){function i(){o.destroyed||(o.step(),requestAnimationFrame(i))}var o=this;this.$el=e(t),this.interactive=r.interactive,this.resolution=r.resolution,this.textureDelta=new Float32Array([1/this.resolution,1/this.resolution]),this.perturbance=r.perturbance,this.dropRadius=r.dropRadius,this.crossOrigin=r.crossOrigin,this.imageUrl=r.imageUrl;var n=document.createElement("canvas");n.width=this.$el.innerWidth(),n.height=this.$el.innerHeight(),this.canvas=n,this.$canvas=e(n),this.$canvas.css({position:"absolute",left:0,top:0,right:0,bottom:0,zIndex:-1}),this.$el.addClass("jquery-ripples").append(n),this.context=s=n.getContext("webgl")||n.getContext("experimental-webgl"),h.extensions.forEach(function(e){s.getExtension(e)}),e(window).on("resize",function(){o.updateSize()}),this.textures=[],this.framebuffers=[],this.bufferWriteIndex=0,this.bufferReadIndex=1;for(var a=h.arrayType,u=a?new a(this.resolution*this.resolution*4):null,c=0;c<2;c++){var d=s.createTexture(),f=s.createFramebuffer();s.bindFramebuffer(s.FRAMEBUFFER,f),s.bindTexture(s.TEXTURE_2D,d),s.texParameteri(s.TEXTURE_2D,s.TEXTURE_MIN_FILTER,h.linearSupport?s.LINEAR:s.NEAREST),s.texParameteri(s.TEXTURE_2D,s.TEXTURE_MAG_FILTER,h.linearSupport?s.LINEAR:s.NEAREST),s.texParameteri(s.TEXTURE_2D,s.TEXTURE_WRAP_S,s.CLAMP_TO_EDGE),s.texParameteri(s.TEXTURE_2D,s.TEXTURE_WRAP_T,s.CLAMP_TO_EDGE),s.texImage2D(s.TEXTURE_2D,0,s.RGBA,this.resolution,this.resolution,0,s.RGBA,h.type,u),s.framebufferTexture2D(s.FRAMEBUFFER,s.COLOR_ATTACHMENT0,s.TEXTURE_2D,d,0),this.textures.push(d),this.framebuffers.push(f)}this.quad=s.createBuffer(),s.bindBuffer(s.ARRAY_BUFFER,this.quad),s.bufferData(s.ARRAY_BUFFER,new Float32Array([-1,-1,1,-1,1,1,-1,1]),s.STATIC_DRAW),this.initShaders(),this.initTexture(),this.setTransparentTexture(),this.loadImage(),s.clearColor(0,0,0,0),s.blendFunc(s.SRC_ALPHA,s.ONE_MINUS_SRC_ALPHA),this.visible=!0,this.running=!0,this.inited=!0,this.destroyed=!1,this.setupPointerEvents(),requestAnimationFrame(i)};d.DEFAULTS={imageUrl:null,resolution:256,dropRadius:20,perturbance:.03,interactive:!0,crossOrigin:""},d.prototype={setupPointerEvents:function(){function e(){return r.visible&&r.running&&r.interactive}function t(t,i){e()&&r.dropAtPointer(t,r.dropRadius*(i?1.5:1),i?.14:.01)}var r=this;this.$el.on("mousemove.ripples",function(e){t(e)}).on("touchmove.ripples, touchstart.ripples",function(e){for(var r=e.originalEvent.changedTouches,i=0;i<r.length;i++)t(r[i])}).on("mousedown.ripples",function(e){t(e,!0)})},loadImage:function(){var e=this;s=this.context;var t=this.imageUrl||n(this.originalCssBackgroundImage)||n(this.$el.css("backgroundImage"));if(t!=this.imageSource)if(this.imageSource=t,this.imageSource){var r=new Image;r.onload=function(){function t(e){return 0==(e&e-1)}s=e.context;var i=t(r.width)&&t(r.height)?s.REPEAT:s.CLAMP_TO_EDGE;s.bindTexture(s.TEXTURE_2D,e.backgroundTexture),s.texParameteri(s.TEXTURE_2D,s.TEXTURE_WRAP_S,i),s.texParameteri(s.TEXTURE_2D,s.TEXTURE_WRAP_T,i),s.texImage2D(s.TEXTURE_2D,0,s.RGBA,s.RGBA,s.UNSIGNED_BYTE,r),e.backgroundWidth=r.width,e.backgroundHeight=r.height,e.hideCssBackground()},r.onerror=function(){s=e.context,e.setTransparentTexture()},r.crossOrigin=a(this.imageSource)?null:this.crossOrigin,r.src=this.imageSource}else this.setTransparentTexture()},step:function(){s=this.context,this.visible&&(this.computeTextureBoundaries(),this.running&&this.update(),this.render())},drawQuad:function(){s.bindBuffer(s.ARRAY_BUFFER,this.quad),s.vertexAttribPointer(0,2,s.FLOAT,!1,0,0),s.drawArrays(s.TRIANGLE_FAN,0,4)},render:function(){s.bindFramebuffer(s.FRAMEBUFFER,null),s.viewport(0,0,this.canvas.width,this.canvas.height),s.enable(s.BLEND),s.clear(s.COLOR_BUFFER_BIT|s.DEPTH_BUFFER_BIT),s.useProgram(this.renderProgram.id),o(this.backgroundTexture,0),o(this.textures[0],1),s.uniform1f(this.renderProgram.locations.perturbance,this.perturbance),s.uniform2fv(this.renderProgram.locations.topLeft,this.renderProgram.uniforms.topLeft),s.uniform2fv(this.renderProgram.locations.bottomRight,this.renderProgram.uniforms.bottomRight),s.uniform2fv(this.renderProgram.locations.containerRatio,this.renderProgram.uniforms.containerRatio),s.uniform1i(this.renderProgram.locations.samplerBackground,0),s.uniform1i(this.renderProgram.locations.samplerRipples,1),this.drawQuad(),s.disable(s.BLEND)},update:function(){s.viewport(0,0,this.resolution,this.resolution),s.bindFramebuffer(s.FRAMEBUFFER,this.framebuffers[this.bufferWriteIndex]),o(this.textures[this.bufferReadIndex]),s.useProgram(this.updateProgram.id),this.drawQuad(),this.swapBufferIndices()},swapBufferIndices:function(){this.bufferWriteIndex=1-this.bufferWriteIndex,this.bufferReadIndex=1-this.bufferReadIndex},computeTextureBoundaries:function(){var e,i=this.$el.css("background-size"),o=this.$el.css("background-attachment"),n=r(this.$el.css("background-position"));if("fixed"==o?((e={left:window.pageXOffset,top:window.pageYOffset}).width=u.width(),e.height=u.height()):((e=this.$el.offset()).width=this.$el.innerWidth(),e.height=this.$el.innerHeight()),"cover"==i)var a=Math.max(e.width/this.backgroundWidth,e.height/this.backgroundHeight),s=this.backgroundWidth*a,h=this.backgroundHeight*a;else if("contain"==i)var a=Math.min(e.width/this.backgroundWidth,e.height/this.backgroundHeight),s=this.backgroundWidth*a,h=this.backgroundHeight*a;else{var s=(i=i.split(" "))[0]||"",h=i[1]||s;t(s)?s=e.width*parseFloat(s)/100:"auto"!=s&&(s=parseFloat(s)),t(h)?h=e.height*parseFloat(h)/100:"auto"!=h&&(h=parseFloat(h)),"auto"==s&&"auto"==h?(s=this.backgroundWidth,h=this.backgroundHeight):("auto"==s&&(s=this.backgroundWidth*(h/this.backgroundHeight)),"auto"==h&&(h=this.backgroundHeight*(s/this.backgroundWidth)))}var c=n[0],d=n[1];c=t(c)?e.left+(e.width-s)*parseFloat(c)/100:e.left+parseFloat(c),d=t(d)?e.top+(e.height-h)*parseFloat(d)/100:e.top+parseFloat(d);var f=this.$el.offset();this.renderProgram.uniforms.topLeft=new Float32Array([(f.left-c)/s,(f.top-d)/h]),this.renderProgram.uniforms.bottomRight=new Float32Array([this.renderProgram.uniforms.topLeft[0]+this.$el.innerWidth()/s,this.renderProgram.uniforms.topLeft[1]+this.$el.innerHeight()/h]);var l=Math.max(this.canvas.width,this.canvas.height);this.renderProgram.uniforms.containerRatio=new Float32Array([this.canvas.width/l,this.canvas.height/l])},initShaders:function(){var e=["attribute vec2 vertex;","varying vec2 coord;","void main() {","coord = vertex * 0.5 + 0.5;","gl_Position = vec4(vertex, 0.0, 1.0);","}"].join("\n");this.dropProgram=i(e,["precision highp float;","const float PI = 3.141592653589793;","uniform sampler2D texture;","uniform vec2 center;","uniform float radius;","uniform float strength;","varying vec2 coord;","void main() {","vec4 info = texture2D(texture, coord);","float drop = max(0.0, 1.0 - length(center * 0.5 + 0.5 - coord) / radius);","drop = 0.5 - cos(drop * PI) * 0.5;","info.r += drop * strength;","gl_FragColor = info;","}"].join("\n")),this.updateProgram=i(e,["precision highp float;","uniform sampler2D texture;","uniform vec2 delta;","varying vec2 coord;","void main() {","vec4 info = texture2D(texture, coord);","vec2 dx = vec2(delta.x, 0.0);","vec2 dy = vec2(0.0, delta.y);","float average = (","texture2D(texture, coord - dx).r +","texture2D(texture, coord - dy).r +","texture2D(texture, coord + dx).r +","texture2D(texture, coord + dy).r",") * 0.25;","info.g += (average - info.r) * 2.0;","info.g *= 0.995;","info.r += info.g;","gl_FragColor = info;","}"].join("\n")),s.uniform2fv(this.updateProgram.locations.delta,this.textureDelta),this.renderProgram=i(["precision highp float;","attribute vec2 vertex;","uniform vec2 topLeft;","uniform vec2 bottomRight;","uniform vec2 containerRatio;","varying vec2 ripplesCoord;","varying vec2 backgroundCoord;","void main() {","backgroundCoord = mix(topLeft, bottomRight, vertex * 0.5 + 0.5);","backgroundCoord.y = 1.0 - backgroundCoord.y;","ripplesCoord = vec2(vertex.x, -vertex.y) * containerRatio * 0.5 + 0.5;","gl_Position = vec4(vertex.x, -vertex.y, 0.0, 1.0);","}"].join("\n"),["precision highp float;","uniform sampler2D samplerBackground;","uniform sampler2D samplerRipples;","uniform vec2 delta;","uniform float perturbance;","varying vec2 ripplesCoord;","varying vec2 backgroundCoord;","void main() {","float height = texture2D(samplerRipples, ripplesCoord).r;","float heightX = texture2D(samplerRipples, vec2(ripplesCoord.x + delta.x, ripplesCoord.y)).r;","float heightY = texture2D(samplerRipples, vec2(ripplesCoord.x, ripplesCoord.y + delta.y)).r;","vec3 dx = vec3(delta.x, heightX - height, 0.0);","vec3 dy = vec3(0.0, heightY - height, delta.y);","vec2 offset = -normalize(cross(dy, dx)).xz;","float specular = pow(max(0.0, dot(offset, normalize(vec2(-0.6, 1.0)))), 4.0);","gl_FragColor = texture2D(samplerBackground, backgroundCoord + offset * perturbance) + specular;","}"].join("\n")),s.uniform2fv(this.renderProgram.locations.delta,this.textureDelta)},initTexture:function(){this.backgroundTexture=s.createTexture(),s.bindTexture(s.TEXTURE_2D,this.backgroundTexture),s.pixelStorei(s.UNPACK_FLIP_Y_WEBGL,1),s.texParameteri(s.TEXTURE_2D,s.TEXTURE_MAG_FILTER,s.LINEAR),s.texParameteri(s.TEXTURE_2D,s.TEXTURE_MIN_FILTER,s.LINEAR)},setTransparentTexture:function(){s.bindTexture(s.TEXTURE_2D,this.backgroundTexture),s.texImage2D(s.TEXTURE_2D,0,s.RGBA,s.RGBA,s.UNSIGNED_BYTE,c)},hideCssBackground:function(){var e=this.$el[0].style.backgroundImage;"none"!=e&&(this.originalInlineCss=e,this.originalCssBackgroundImage=this.$el.css("backgroundImage"),this.$el.css("backgroundImage","none"))},restoreCssBackground:function(){this.$el.css("backgroundImage",this.originalInlineCss||"")},dropAtPointer:function(e,t,r){var i=parseInt(this.$el.css("border-left-width"))||0,o=parseInt(this.$el.css("border-top-width"))||0;this.drop(e.pageX-this.$el.offset().left-i,e.pageY-this.$el.offset().top-o,t,r)},drop:function(e,t,r,i){s=this.context;var n=this.$el.innerWidth(),a=this.$el.innerHeight(),u=Math.max(n,a);r/=u;var h=new Float32Array([(2*e-n)/u,(a-2*t)/u]);s.viewport(0,0,this.resolution,this.resolution),s.bindFramebuffer(s.FRAMEBUFFER,this.framebuffers[this.bufferWriteIndex]),o(this.textures[this.bufferReadIndex]),s.useProgram(this.dropProgram.id),s.uniform2fv(this.dropProgram.locations.center,h),s.uniform1f(this.dropProgram.locations.radius,r),s.uniform1f(this.dropProgram.locations.strength,i),this.drawQuad(),this.swapBufferIndices()},updateSize:function(){var e=this.$el.innerWidth(),t=this.$el.innerHeight();e==this.canvas.width&&t==this.canvas.height||(this.canvas.width=e,this.canvas.height=t)},destroy:function(){this.$el.off(".ripples").removeClass("jquery-ripples").removeData("ripples"),this.$canvas.remove(),this.restoreCssBackground(),this.destroyed=!0},show:function(){this.visible=!0,this.$canvas.show(),this.hideCssBackground()},hide:function(){this.visible=!1,this.$canvas.hide(),this.restoreCssBackground()},pause:function(){this.running=!1},play:function(){this.running=!0},set:function(e,t){switch(e){case"dropRadius":case"perturbance":case"interactive":case"crossOrigin":this[e]=t;break;case"imageUrl":this.imageUrl=t,this.loadImage()}}};var f=e.fn.ripples;e.fn.ripples=function(t){if(!h)throw new Error("Your browser does not support WebGL, the OES_texture_float extension or rendering to floating point textures.");var r=arguments.length>1?Array.prototype.slice.call(arguments,1):void 0;return this.each(function(){var i=e(this),o=i.data("ripples"),n=e.extend({},d.DEFAULTS,i.data(),"object"==typeof t&&t);(o||"string"!=typeof t)&&(o?"string"==typeof t&&d.prototype[t].apply(o,r):i.data("ripples",o=new d(this,n)))})},e.fn.ripples.Constructor=d,e.fn.ripples.noConflict=function(){return e.fn.ripples=f,this}});


/*------------------------------------------------------------------*/
/*	11) YT PLAYER
/*------------------------------------------------------------------*/

/*___________________________________________________________________________________________________________________________________________________
 _ jquery.mb.components                                                                                                                             _
 _                                                                                                                                                  _
 _ file: jquery.mb.YTPlayer.js                                                                                                                      _
 _ last modified: 19/08/14 20.13                                                                                                                    _
 _                                                                                                                                                  _
 _ Open Lab s.r.l., Florence - Italy                                                                                                                _
 _                                                                                                                                                  _
 _ email: matteo@open-lab.com                                                                                                                       _
 _ site: http://pupunzi.com                                                                                                                         _
 _       http://open-lab.com                                                                                                                        _
 _ blog: http://pupunzi.open-lab.com                                                                                                                _
 _ Q&A:  http://jquery.pupunzi.com                                                                                                                  _
 _                                                                                                                                                  _
 _ Licences: MIT, GPL                                                                                                                               _
 _    http://www.opensource.org/licenses/mit-license.php                                                                                            _
 _    http://www.gnu.org/licenses/gpl.html                                                                                                          _
 _                                                                                                                                                  _
 _ Copyright (c) 2001-2014. Matteo Bicocchi (Pupunzi);                                                                                              _
 ___________________________________________________________________________________________________________________________________________________*/

var ytp = ytp || {};

function onYouTubePlayerAPIReady() {
	if(ytp.YTAPIReady)
		return;

	ytp.YTAPIReady=true;
	jQuery(document).trigger("YTAPIReady");
}

(function (jQuery, ytp) {

	/*Browser detection patch*/
	var nAgt = navigator.userAgent;
	if (!jQuery.browser) {
		jQuery.browser = {};
		jQuery.browser.mozilla = !1;
		jQuery.browser.webkit = !1;
		jQuery.browser.opera = !1;
		jQuery.browser.safari = !1;
		jQuery.browser.chrome = !1;
		jQuery.browser.msie = !1;
		jQuery.browser.ua = nAgt;
		jQuery.browser.name = navigator.appName;
		jQuery.browser.fullVersion = "" + parseFloat(navigator.appVersion);
		jQuery.browser.majorVersion = parseInt(navigator.appVersion, 10);
		var nameOffset, verOffset, ix;
		if (-1 != (verOffset = nAgt.indexOf("Opera")))jQuery.browser.opera = !0, jQuery.browser.name = "Opera", jQuery.browser.fullVersion = nAgt.substring(verOffset + 6), -1 != (verOffset = nAgt.indexOf("Version")) && (jQuery.browser.fullVersion = nAgt.substring(verOffset + 8)); else if (-1 != (verOffset = nAgt.indexOf("MSIE")))jQuery.browser.msie = !0, jQuery.browser.name = "Microsoft Internet Explorer", jQuery.browser.fullVersion = nAgt.substring(verOffset + 5); else if (-1 != nAgt.indexOf("Trident")) {
			jQuery.browser.msie = !0;
			jQuery.browser.name = "Microsoft Internet Explorer";
			var start = nAgt.indexOf("rv:") + 3, end = start + 4;
			jQuery.browser.fullVersion = nAgt.substring(start, end)
		} else-1 != (verOffset = nAgt.indexOf("Chrome")) ? (jQuery.browser.webkit = !0, jQuery.browser.chrome = !0, jQuery.browser.name = "Chrome", jQuery.browser.fullVersion = nAgt.substring(verOffset + 7)) : -1 != (verOffset = nAgt.indexOf("Safari")) ? (jQuery.browser.webkit = !0, jQuery.browser.safari = !0, jQuery.browser.name = "Safari", jQuery.browser.fullVersion = nAgt.substring(verOffset + 7), -1 != (verOffset = nAgt.indexOf("Version")) && (jQuery.browser.fullVersion = nAgt.substring(verOffset + 8))) : -1 != (verOffset = nAgt.indexOf("AppleWebkit")) ? (jQuery.browser.webkit = !0, jQuery.browser.name = "Safari", jQuery.browser.fullVersion = nAgt.substring(verOffset + 7), -1 != (verOffset = nAgt.indexOf("Version")) && (jQuery.browser.fullVersion = nAgt.substring(verOffset + 8))) : -1 != (verOffset = nAgt.indexOf("Firefox")) ? (jQuery.browser.mozilla = !0, jQuery.browser.name = "Firefox", jQuery.browser.fullVersion = nAgt.substring(verOffset + 8)) : (nameOffset = nAgt.lastIndexOf(" ") + 1) < (verOffset = nAgt.lastIndexOf("/")) && (jQuery.browser.name = nAgt.substring(nameOffset, verOffset), jQuery.browser.fullVersion = nAgt.substring(verOffset + 1), jQuery.browser.name.toLowerCase() == jQuery.browser.name.toUpperCase() && (jQuery.browser.name = navigator.appName));
		-1 != (ix = jQuery.browser.fullVersion.indexOf(";")) && (jQuery.browser.fullVersion = jQuery.browser.fullVersion.substring(0, ix));
		-1 != (ix = jQuery.browser.fullVersion.indexOf(" ")) && (jQuery.browser.fullVersion = jQuery.browser.fullVersion.substring(0, ix));
		jQuery.browser.majorVersion = parseInt("" + jQuery.browser.fullVersion, 10);
		isNaN(jQuery.browser.majorVersion) && (jQuery.browser.fullVersion = "" + parseFloat(navigator.appVersion), jQuery.browser.majorVersion = parseInt(navigator.appVersion, 10));
		jQuery.browser.version = jQuery.browser.majorVersion
	}
	jQuery.browser.android = /Android/i.test(nAgt);
	jQuery.browser.blackberry = /BlackBerry|BB|PlayBook/i.test(nAgt);
	jQuery.browser.ios = /iPhone|iPad|iPod|webOS/i.test(nAgt);
	jQuery.browser.operaMobile = /Opera Mini/i.test(nAgt);
	jQuery.browser.kindle = /Kindle|Silk/i.test(nAgt);
	jQuery.browser.windowsMobile = /IEMobile|Windows Phone/i.test(nAgt);
	jQuery.browser.mobile = jQuery.browser.android || jQuery.browser.blackberry || jQuery.browser.ios || jQuery.browser.windowsMobile || jQuery.browser.operaMobile || jQuery.browser.kindle;

	/*******************************************************************************
	 * jQuery.mb.components: jquery.mb.CSSAnimate
	 ******************************************************************************/

	jQuery.fn.CSSAnimate=function(a,g,p,m,h){function r(a){return a.replace(/([A-Z])/g,function(a){return"-"+a.toLowerCase()})}function f(a,f){return"string"!==typeof a||a.match(/^[\-0-9\.]+$/)?""+a+f:a}jQuery.support.CSStransition=function(){var a=(document.body||document.documentElement).style;return void 0!==a.transition||void 0!==a.WebkitTransition||void 0!==a.MozTransition||void 0!==a.MsTransition||void 0!==a.OTransition}();return this.each(function(){var e=this,k=jQuery(this);e.id=e.id||"CSSA_"+ (new Date).getTime();var l=l||{type:"noEvent"};if(e.CSSAIsRunning&&e.eventType==l.type)e.CSSqueue=function(){k.CSSAnimate(a,g,p,m,h)};else if(e.CSSqueue=null,e.eventType=l.type,0!==k.length&&a){e.CSSAIsRunning=!0;"function"==typeof g&&(h=g,g=jQuery.fx.speeds._default);"function"==typeof p&&(h=p,p=0);"function"==typeof m&&(h=m,m="cubic-bezier(0.65,0.03,0.36,0.72)");if("string"==typeof g)for(var b in jQuery.fx.speeds)if(g==b){g=jQuery.fx.speeds[b];break}else g=jQuery.fx.speeds._default;g||(g=jQuery.fx.speeds._default); if(jQuery.support.CSStransition){l={"default":"ease","in":"ease-in",out:"ease-out","in-out":"ease-in-out",snap:"cubic-bezier(0,1,.5,1)",easeOutCubic:"cubic-bezier(.215,.61,.355,1)",easeInOutCubic:"cubic-bezier(.645,.045,.355,1)",easeInCirc:"cubic-bezier(.6,.04,.98,.335)",easeOutCirc:"cubic-bezier(.075,.82,.165,1)",easeInOutCirc:"cubic-bezier(.785,.135,.15,.86)",easeInExpo:"cubic-bezier(.95,.05,.795,.035)",easeOutExpo:"cubic-bezier(.19,1,.22,1)",easeInOutExpo:"cubic-bezier(1,0,0,1)",easeInQuad:"cubic-bezier(.55,.085,.68,.53)", easeOutQuad:"cubic-bezier(.25,.46,.45,.94)",easeInOutQuad:"cubic-bezier(.455,.03,.515,.955)",easeInQuart:"cubic-bezier(.895,.03,.685,.22)",easeOutQuart:"cubic-bezier(.165,.84,.44,1)",easeInOutQuart:"cubic-bezier(.77,0,.175,1)",easeInQuint:"cubic-bezier(.755,.05,.855,.06)",easeOutQuint:"cubic-bezier(.23,1,.32,1)",easeInOutQuint:"cubic-bezier(.86,0,.07,1)",easeInSine:"cubic-bezier(.47,0,.745,.715)",easeOutSine:"cubic-bezier(.39,.575,.565,1)",easeInOutSine:"cubic-bezier(.445,.05,.55,.95)",easeInBack:"cubic-bezier(.6,-.28,.735,.045)", easeOutBack:"cubic-bezier(.175, .885,.32,1.275)",easeInOutBack:"cubic-bezier(.68,-.55,.265,1.55)"};l[m]&&(m=l[m]);var d="",q="transitionEnd";jQuery.browser.webkit?(d="-webkit-",q="webkitTransitionEnd"):jQuery.browser.mozilla?(d="-moz-",q="transitionend"):jQuery.browser.opera?(d="-o-",q="otransitionend"):jQuery.browser.msie&&(d="-ms-",q="msTransitionEnd");l=[];for(c in a){b=c;"transform"===b&&(b=d+"transform",a[b]=a[c],delete a[c]);"filter"===b&&(b=d+"filter",a[b]=a[c],delete a[c]);if("transform-origin"=== b||"origin"===b)b=d+"transform-origin",a[b]=a[c],delete a[c];"x"===b&&(b=d+"transform",a[b]=a[b]||"",a[b]+=" translateX("+f(a[c],"px")+")",delete a[c]);"y"===b&&(b=d+"transform",a[b]=a[b]||"",a[b]+=" translateY("+f(a[c],"px")+")",delete a[c]);"z"===b&&(b=d+"transform",a[b]=a[b]||"",a[b]+=" translateZ("+f(a[c],"px")+")",delete a[c]);"rotate"===b&&(b=d+"transform",a[b]=a[b]||"",a[b]+=" rotate("+f(a[c],"deg")+")",delete a[c]);"rotateX"===b&&(b=d+"transform",a[b]=a[b]||"",a[b]+=" rotateX("+f(a[c],"deg")+ ")",delete a[c]);"rotateY"===b&&(b=d+"transform",a[b]=a[b]||"",a[b]+=" rotateY("+f(a[c],"deg")+")",delete a[c]);"rotateZ"===b&&(b=d+"transform",a[b]=a[b]||"",a[b]+=" rotateZ("+f(a[c],"deg")+")",delete a[c]);"scale"===b&&(b=d+"transform",a[b]=a[b]||"",a[b]+=" scale("+f(a[c],"")+")",delete a[c]);"scaleX"===b&&(b=d+"transform",a[b]=a[b]||"",a[b]+=" scaleX("+f(a[c],"")+")",delete a[c]);"scaleY"===b&&(b=d+"transform",a[b]=a[b]||"",a[b]+=" scaleY("+f(a[c],"")+")",delete a[c]);"scaleZ"===b&&(b=d+"transform", a[b]=a[b]||"",a[b]+=" scaleZ("+f(a[c],"")+")",delete a[c]);"skew"===b&&(b=d+"transform",a[b]=a[b]||"",a[b]+=" skew("+f(a[c],"deg")+")",delete a[c]);"skewX"===b&&(b=d+"transform",a[b]=a[b]||"",a[b]+=" skewX("+f(a[c],"deg")+")",delete a[c]);"skewY"===b&&(b=d+"transform",a[b]=a[b]||"",a[b]+=" skewY("+f(a[c],"deg")+")",delete a[c]);"perspective"===b&&(b=d+"transform",a[b]=a[b]||"",a[b]+=" perspective("+f(a[c],"px")+")",delete a[c]);0>l.indexOf(b)&&l.push(r(b))}var c=l.join(","),s=function(){k.off(q+"."+ e.id);clearTimeout(e.timeout);k.css(d+"transition","");"function"==typeof h&&h(k);e.called=!0;e.CSSAIsRunning=!1;"function"==typeof e.CSSqueue&&(e.CSSqueue(),e.CSSqueue=null)},n={};jQuery.extend(n,a);n[d+"transition-property"]=c;n[d+"transition-duration"]=g+"ms";n[d+"transition-delay"]=p+"ms";n[d+"transition-style"]="preserve-3d";n[d+"transition-timing-function"]=m;setTimeout(function(){k.one(q+"."+e.id,s);k.css(n)},1);e.timeout=setTimeout(function(){k.called||!h?(k.called=!1,e.CSSAIsRunning=!1):(k.css(d+ "transition",""),h(k),e.CSSAIsRunning=!1,"function"==typeof e.CSSqueue&&(e.CSSqueue(),e.CSSqueue=null))},g+p+100)}else{for(var c in a)"transform"===c&&delete a[c],"filter"===c&&delete a[c],"transform-origin"===c&&delete a[c],"auto"===a[c]&&delete a[c];h&&"string"!==typeof h||(h="linear");k.animate(a,g,h)}}})};

	/******************************************************************************/

	var getYTPVideoID = function (url) {

		var videoID, playlistID;

		if (url.indexOf("youtu.be") > 0) {
			videoID = url.substr(url.lastIndexOf("/")+1, url.length);
			playlistID = videoID.indexOf("?list=") > 0 ? videoID.substr(videoID.lastIndexOf("="), videoID.length) : null;
			videoID = playlistID ? videoID.substr(0, videoID.lastIndexOf("?")) : videoID;
		} else if (url.indexOf("http") > -1) {
			videoID = url.match(/[\\?&]v=([^&#]*)/)[1];
			playlistID = url.indexOf("list=")>0 ? url.match(/[\\?&]list=([^&#]*)/)[1] : null;
		} else {
			videoID = url.length > 15 ? null : url;
			playlistID = videoID ? null : url;
		}

		return {videoID: videoID, playlistID: playlistID};
	};

	/* todo:
	 setPlaybackRate()
	 playlist
	 */


	jQuery.mbYTPlayer = {
		name   : "jquery.mb.YTPlayer",
		version: "2.7.8",
		author : "Matteo Bicocchi",

		defaults: {
			containment            : "body",
			ratio                  : "16/9",
			videoURL               : null,
			playlistURL            : null,
			startAt                : 0,
			stopAt                 : 0,
			autoPlay               : true,
			vol                    : 100, // 1 to 100
			addRaster              : false,
			opacity                : 1,
			quality                : "default", //or â€œsmallâ€, â€œmediumâ€, â€œlargeâ€, â€œhd720â€, â€œhd1080â€, â€œhighresâ€
			mute                   : false,
			loop                   : true,
			showControls           : true,
			showAnnotations        : false,
			showYTLogo             : true,
			stopMovieOnClick       : false,
			stopMovieOnBlur        : true,
			realfullscreen         : true,
			gaTrack                : true,
			onReady                : function (player) {}
		},

		/*@fontface icons*/
		controls: {
			play    : "P",
			pause   : "p",
			mute    : "M",
			unmute  : "A",
			onlyYT  : "O",
			showSite: "R",
			ytLogo  : "Y"
		},

		locationProtocol: "https:",

		buildPlayer: function (options) {
			return this.each(function () {
				var YTPlayer = this;
				var $YTPlayer = jQuery(YTPlayer);

				YTPlayer.loop = 0;
				YTPlayer.opt = {};

				$YTPlayer.addClass("mb_YTPlayer");

				var property = $YTPlayer.data("property") && typeof $YTPlayer.data("property") == "string" ? eval('(' + $YTPlayer.data("property") + ')') : $YTPlayer.data("property");

				if (typeof property != "undefined" && typeof property.vol != "undefined")
					property.vol = property.vol == 0 ? property.vol = 1 : property.vol;

				jQuery.extend(YTPlayer.opt, jQuery.mbYTPlayer.defaults, options, property);

				var canGoFullscreen = !(jQuery.browser.msie || jQuery.browser.opera || self.location.href != top.location.href);

				if (!canGoFullscreen)
					YTPlayer.opt.realfullscreen = false;

				if (!$YTPlayer.attr("id"))
					$YTPlayer.attr("id", "video_" + new Date().getTime());

				var playerID = "mbYTP_" + YTPlayer.id;

				YTPlayer.isAlone = false;
				YTPlayer.hasFocus = true;

				var videoID = this.opt.videoURL ? getYTPVideoID(this.opt.videoURL).videoID : $YTPlayer.attr("href") ? getYTPVideoID($YTPlayer.attr("href")).videoID : false;
				var playlistID = this.opt.videoURL ? getYTPVideoID(this.opt.videoURL).playlistID : $YTPlayer.attr("href") ? getYTPVideoID($YTPlayer.attr("href")).playlistID : false;

				YTPlayer.videoID = videoID;
				YTPlayer.playlistID = playlistID;

				YTPlayer.opt.showAnnotations = (YTPlayer.opt.showAnnotations) ? '0' : '3';
				var playerVars = { 'autoplay': 0, 'modestbranding': 1, 'controls': 0, 'showinfo': 0, 'rel': 0, 'enablejsapi': 1, 'version': 3, 'playerapiid': playerID, 'origin': '*', 'allowfullscreen': true, 'wmode': 'transparent', 'iv_load_policy': YTPlayer.opt.showAnnotations};

				var v = document.createElement('video');
				if (v.canPlayType)
					jQuery.extend(playerVars, {'html5': 1});

				if (jQuery.browser.msie && jQuery.browser.version < 9) {
					this.opt.opacity = 1;
				}

				var playerBox = jQuery("<div/>").attr("id", playerID).addClass("playerBox");
				var overlay = jQuery("<div/>").css({position: "absolute", top: 0, left: 0, width: "100%", height: "100%"}).addClass("YTPOverlay");

				YTPlayer.isSelf = YTPlayer.opt.containment == "self";
				YTPlayer.opt.containment = YTPlayer.opt.containment == "self" ? jQuery(this) : jQuery(YTPlayer.opt.containment);
				YTPlayer.isBackground = YTPlayer.opt.containment.get(0).tagName.toLowerCase() == "body";

				if (YTPlayer.isBackground && ytp.backgroundIsInited)
					return;

				var isPlayer = YTPlayer.opt.containment.is(jQuery(this)) && jQuery(this).children().length == 0;

				if (!isPlayer) {
					$YTPlayer.hide();
				} else {
					YTPlayer.isPlayer = true;
				}

				if (jQuery.browser.mobile && YTPlayer.isBackground) {
					$YTPlayer.remove();
					return;
				}

				if (YTPlayer.opt.addRaster) {
					var classN = YTPlayer.opt.addRaster == "dot" ? "raster-dot" : "raster";

					var retina = (window.retina || window.devicePixelRatio > 1);
					overlay.addClass(retina ? classN + " retina" : classN);
				} else {

					overlay.removeClass(function (index, classNames) {

						// change the list into an array
						var current_classes = classNames.split(" "),
						// array of classes which are to be removed
								classes_to_remove = [];

						jQuery.each(current_classes, function (index, class_name) {
							// if the classname begins with bg add it to the classes_to_remove array
							if (/raster-.*/.test(class_name)) {
								classes_to_remove.push(class_name);
							}
						});

						classes_to_remove.push("retina");
						// turn the array back into a string
						return classes_to_remove.join(" ");
					})
				}

				var wrapper = jQuery("<div/>").addClass("mbYTP_wrapper").attr("id", "wrapper_" + playerID);
				wrapper.css({position: "absolute", zIndex: 0, minWidth: "100%", minHeight: "100%", left: 0, top: 0, overflow: "hidden", opacity: 0});
				playerBox.css({position: "absolute", zIndex: 0, width: "100%", height: "100%", top: 0, left: 0, overflow: "hidden"});
				wrapper.append(playerBox);

				YTPlayer.opt.containment.children().not("script, style").each(function () {
					if (jQuery(this).css("position") == "static")
						jQuery(this).css("position", "relative");
				});

				if (YTPlayer.isBackground) {
//					jQuery("body").css({position: "relative", minWidth: "100%", minHeight: "100%", zIndex: 1, boxSizing: "border-box"});
					wrapper.css({position: "fixed", top: 0, left: 0, zIndex: 0, webkitTransform: "translateZ(0)"});
					$YTPlayer.hide();
				} else if (YTPlayer.opt.containment.css("position") == "static")
					YTPlayer.opt.containment.css({position: "relative"});

				YTPlayer.opt.containment.prepend(wrapper);
				YTPlayer.wrapper = wrapper;

				playerBox.css({opacity: 1});

				if (!jQuery.browser.mobile) {
					playerBox.after(overlay);
					YTPlayer.overlay = overlay;
				}

				if (!YTPlayer.isBackground) {
					overlay.on("mouseenter", function () {
						$YTPlayer.find(".mb_YTPBar").addClass("visible");
					}).on("mouseleave", function () {
						$YTPlayer.find(".mb_YTPBar").removeClass("visible");
					})
				}

				if (!ytp.YTAPIReady) {
					jQuery("#YTAPI").remove();
					var tag = jQuery("<script></script>").attr({"src": jQuery.mbYTPlayer.locationProtocol + "//www.youtube.com/player_api?v=" + jQuery.mbYTPlayer.version, "id": "YTAPI"});
					jQuery("head title").after(tag);
				} else {
					setTimeout(function () {
						jQuery(document).trigger("YTAPIReady");
					}, 100)
				}

				jQuery(document).on("YTAPIReady", function () {

					if ((YTPlayer.isBackground && ytp.backgroundIsInited) || YTPlayer.isInit)
						return;

					if (YTPlayer.isBackground && YTPlayer.opt.stopMovieOnClick)
						jQuery(document).off("mousedown.ytplayer").on("mousedown,.ytplayer", function (e) {
							var target = jQuery(e.target);
							if (target.is("a") || target.parents().is("a")) {
								$YTPlayer.pauseYTP();
							}
						});

					if (YTPlayer.isBackground) {
						ytp.backgroundIsInited = true;
					}

					YTPlayer.opt.autoPlay = typeof YTPlayer.opt.autoPlay == "undefined" ? (YTPlayer.isBackground ? true : false) : YTPlayer.opt.autoPlay;
					YTPlayer.opt.vol = YTPlayer.opt.vol ? YTPlayer.opt.vol : 100;

					jQuery.mbYTPlayer.getDataFromFeed(YTPlayer);

					jQuery(YTPlayer).on("YTPChanged", function () {

						if (YTPlayer.isInit)
							return;

						YTPlayer.isInit = true;

						//if is mobile && isPlayer fallback to the default YT player
						if (jQuery.browser.mobile && YTPlayer.isPlayer) {
							new YT.Player(playerID, {
								videoId: YTPlayer.videoID.toString(),
								height : '100%',
								width  : '100%',
								videoId: YTPlayer.videoID,
								events : {
									'onReady'      : function (event) {
										YTPlayer.player = event.target;
										playerBox.css({opacity: 1});
										YTPlayer.wrapper.css({opacity: YTPlayer.opt.opacity});
										$YTPlayer.optimizeDisplay();
									},
									'onStateChange': function () {}
								}
							});
							return;
						}

						new YT.Player(playerID, {
							videoId   : YTPlayer.videoID.toString(),
							playerVars: playerVars,
							events    : {
								'onReady': function (event) {

									YTPlayer.player = event.target;

									if (YTPlayer.isReady)
										return;

									YTPlayer.isReady = true;

									YTPlayer.playerEl = YTPlayer.player.getIframe();

									$YTPlayer.optimizeDisplay();

									YTPlayer.videoID = videoID;

									jQuery(window).on("resize.YTP", function () {
										$YTPlayer.optimizeDisplay();
									});

									if (YTPlayer.opt.showControls)
										jQuery(YTPlayer).buildYTPControls();

									var startAt = YTPlayer.opt.startAt ? YTPlayer.opt.startAt : 1;

									YTPlayer.player.setVolume(0);
									jQuery(YTPlayer).muteYTPVolume();

									jQuery.mbYTPlayer.checkForState(YTPlayer);

									YTPlayer.checkForStartAt = setInterval(function () {

										var canPlayVideo = jQuery.browser.mozilla && !window.MediaSource ? true : (YTPlayer.player.getVideoLoadedFraction() > startAt / YTPlayer.player.getDuration());

										if (YTPlayer.player.getDuration() > 0 && YTPlayer.player.getCurrentTime() >= startAt && canPlayVideo) {
											clearInterval(YTPlayer.checkForStartAt);
											YTPlayer.player.setVolume(0);
											jQuery(YTPlayer).muteYTPVolume();
											if (typeof YTPlayer.opt.onReady == "function")
												YTPlayer.opt.onReady(YTPlayer);
											if (!YTPlayer.opt.mute)
												jQuery(YTPlayer).unmuteYTP();

											jQuery.mbYTPlayer.checkForState(YTPlayer);

											YTPlayer.player.pauseVideo();

											setTimeout(function () {

												YTPlayer.canTrigger = true;

												if (YTPlayer.opt.autoPlay) {
													$YTPlayer.playYTP();
													$YTPlayer.css("background-image", "none");
													YTPlayer.wrapper.CSSAnimate({opacity: YTPlayer.isAlone ? 1 : YTPlayer.opt.opacity}, 2000);
												} else {
													YTPlayer.player.pauseVideo();
												}
											}, 100)

										} else {
											YTPlayer.player.playVideo();
											YTPlayer.player.seekTo(startAt, true);
										}
									}, jQuery.browser.chrome ? 1000 : 1);
								},

								'onStateChange': function (event) {
									/*
									 -1 (unstarted)
									 0 (ended)
									 1 (playing)
									 2 (paused)
									 3 (buffering)
									 5 (video cued).
									 */

									if (typeof event.target.getPlayerState != "function")
										return;

									var state = event.target.getPlayerState();

									if (YTPlayer.state == state)
										return;

									YTPlayer.state = state;

									var controls = jQuery("#controlBar_" + YTPlayer.id);
									var data = YTPlayer.opt;

									var eventType;

									switch (state) {
										case -1: //------------------------------------------------ unstarted

											eventType = "YTPUnstarted";
											break;

										case 0:  //------------------------------------------------ ended

											eventType = "YTPEnd";
											YTPlayer.player.pauseVideo();
											var startAt = YTPlayer.opt.startAt ? YTPlayer.opt.startAt : 1;

											if (data.loop) {
												YTPlayer.wrapper.css({opacity: 0});
												$YTPlayer.playYTP();
												YTPlayer.player.seekTo(startAt, true);

											} else if (!YTPlayer.isBackground) {
												YTPlayer.player.seekTo(startAt, true);
												$YTPlayer.playYTP();
												setTimeout(function () {
													$YTPlayer.pauseYTP();
												}, 10);
											}

											if (!data.loop && YTPlayer.isBackground)
												YTPlayer.wrapper.CSSAnimate({opacity: 0}, 2000);
											else if (data.loop) {
												YTPlayer.loop++;
											}

											controls.find(".mb_YTPPlaypause").html(jQuery.mbYTPlayer.controls.play);

											break;

										case 1:  //------------------------------------------------ play

											eventType = "YTPStart";

											if (!jQuery.browser.chrome)
												YTPlayer.player.setPlaybackQuality(YTPlayer.opt.quality);

											controls.find(".mb_YTPPlaypause").html(jQuery.mbYTPlayer.controls.pause);

											if (typeof _gaq != "undefined" && eval(YTPlayer.opt.gaTrack))
												_gaq.push(['_trackEvent', 'YTPlayer', 'Play', (YTPlayer.videoTitle || YTPlayer.videoID.toString())]);

											if (typeof ga != "undefined" && eval(YTPlayer.opt.gaTrack))
												ga('send', 'event', 'YTPlayer', 'play', (YTPlayer.videoTitle || YTPlayer.videoID.toString()));

											break;

										case 2:  //------------------------------------------------ pause

											eventType = "YTPPause";

											controls.find(".mb_YTPPlaypause").html(jQuery.mbYTPlayer.controls.play);

											break;

										case 3:  //------------------------------------------------ buffer

											eventType = "YTPBuffering";

											if (!jQuery.browser.chrome)
												YTPlayer.player.setPlaybackQuality(YTPlayer.opt.quality);

											controls.find(".mb_YTPPlaypause").html(jQuery.mbYTPlayer.controls.play);

											break;

										case 5:  //------------------------------------------------ cued
											eventType = "YTPCued";
											break;

										default:
											break;

									}

									// Trigger state events
									var YTPevent = jQuery.Event(eventType);
									YTPevent.time = YTPlayer.player.time;
									if (YTPlayer.canTrigger)
										jQuery(YTPlayer).trigger(YTPevent);

								},

								'onPlaybackQualityChange': function (e) {

									var quality = e.target.getPlaybackQuality();

									var YTPQualityChange = jQuery.Event("YTPQualityChange");
									YTPQualityChange.quality = quality;
									jQuery(YTPlayer).trigger(YTPQualityChange);

								},

								'onError': function (err) {

									if (err.data == 150) {
										console.log("Embedding this video is restricted by Youtube.");
										if (YTPlayer.isPlayList)
											jQuery(YTPlayer).playNext();
									}
									if (err.data == 2 && YTPlayer.isPlayList)
										jQuery(YTPlayer).playNext();

									if (typeof YTPlayer.opt.onError == "function")
										YTPlayer.opt.onError($YTPlayer, err);
								}
							}
						});
					});
				})
			});
		},

		getDataFromFeed: function (YTPlayer) {
			//Get video info from FEEDS API

			if (!(jQuery.browser.msie && jQuery.browser.version <= 9)) {
				jQuery.getJSON(jQuery.mbYTPlayer.locationProtocol + '//gdata.youtube.com/feeds/api/videos/' + YTPlayer.videoID + '?v=2&alt=jsonc', function (data, status, xhr) {
					YTPlayer.dataReceived = true;
					YTPlayer.videoData = data.data;
					jQuery(YTPlayer).trigger("YTPChanged");
					var YTPData = jQuery.Event("YTPData");
					YTPData.prop = {};
					for (var x in YTPlayer.videoData)
						YTPData.prop[x] = YTPlayer.videoData[x];
					jQuery(YTPlayer).trigger(YTPData);
					YTPlayer.videoTitle = YTPlayer.videoData.title;
					if (YTPlayer.opt.ratio == "auto")
						if (YTPlayer.videoData.aspectRatio && YTPlayer.videoData.aspectRatio === "widescreen")
							YTPlayer.opt.ratio = "16/9";
						else
							YTPlayer.opt.ratio = "4/3";
					if (!YTPlayer.hasData) {
						YTPlayer.hasData = true;
						if (YTPlayer.isPlayer) {
							var bgndURL = YTPlayer.videoData.thumbnail.hqDefault;
							YTPlayer.opt.containment.css({background: "rgba(0,0,0,0.5) url(" + bgndURL + ") center center", backgroundSize: "cover"});
						}
					}
				});
				setTimeout(function () {
					if (!YTPlayer.dataReceived && !YTPlayer.hasData) {
						YTPlayer.hasData = true;
						jQuery(YTPlayer).trigger("YTPChanged");
					}
				}, 1500)

			} else {
				YTPlayer.opt.ratio == "auto" ? YTPlayer.opt.ratio = "16/9" : YTPlayer.opt.ratio;

				if (!YTPlayer.hasData) {
					YTPlayer.hasData = true;
					setTimeout(function () {
						jQuery(YTPlayer).trigger("YTPChanged");
					}, 100)
				}
			}
		},

		getVideoData: function () {
			var YTPlayer = this.get(0);
			return YTPlayer.videoData;
		},

		getVideoID: function () {
			var YTPlayer = this.get(0);
			return YTPlayer.videoID || false;
		},

		setVideoQuality: function (quality) {
			var YTPlayer = this.get(0);

			if (!jQuery.browser.chrome)
				YTPlayer.player.setPlaybackQuality(quality);
		},

		YTPlaylist: function (videos, shuffle, callback) {
			var YTPlayer = this.get(0);

			YTPlayer.isPlayList = true;

			if (shuffle)
				videos = jQuery.shuffle(videos);

			if (!YTPlayer.videoID) {
				YTPlayer.videos = videos;
				YTPlayer.videoCounter = 0;
				YTPlayer.videoLength = videos.length;

				jQuery(YTPlayer).data("property", videos[0]);
				jQuery(YTPlayer).mb_YTPlayer();
			}

			if (typeof callback == "function")
				jQuery(YTPlayer).on("YTPChanged", function () {
					callback(YTPlayer);
				});

			jQuery(YTPlayer).on("YTPEnd", function () {
				jQuery(YTPlayer).playNext();
			});
		},

		playNext: function () {
			var YTPlayer = this.get(0);
			YTPlayer.videoCounter++;
			if (YTPlayer.videoCounter >= YTPlayer.videoLength)
				YTPlayer.videoCounter = 0;
			jQuery(YTPlayer.playerEl).css({opacity: 0});
			jQuery(YTPlayer).changeMovie(YTPlayer.videos[YTPlayer.videoCounter]);
		},

		playPrev: function () {
			var YTPlayer = this.get(0);
			YTPlayer.videoCounter--;
			if (YTPlayer.videoCounter < 0)
				YTPlayer.videoCounter = YTPlayer.videoLength - 1;
			jQuery(YTPlayer.playerEl).css({opacity: 0});
			jQuery(YTPlayer).changeMovie(YTPlayer.videos[YTPlayer.videoCounter]);
		},

		changeMovie: function (opt) {
			var YTPlayer = this.get(0);

			YTPlayer.opt.startAt = 0;
			YTPlayer.opt.stopAt = 0;
			YTPlayer.opt.mute = true;

			if (opt) {
				jQuery.extend(YTPlayer.opt, opt);
			}

			YTPlayer.videoID = getYTPVideoID(YTPlayer.opt.videoURL).videoID;

			jQuery(YTPlayer).pauseYTP();

			var timer = jQuery.browser.msie ? 1000 : 0;

			jQuery(YTPlayer.playerEl).CSSAnimate({opacity: 0}, timer);


			setTimeout(function () {
				var quality = !jQuery.browser.chrome ? YTPlayer.opt.quality : "default";

				jQuery(YTPlayer).getPlayer().cueVideoByUrl(encodeURI(jQuery.mbYTPlayer.locationProtocol + "//www.youtube.com/v/" + YTPlayer.videoID), 1, quality);

				jQuery(YTPlayer).playYTP();


				jQuery(YTPlayer).one("YTPStart", function () {
					YTPlayer.wrapper.CSSAnimate({opacity: YTPlayer.isAlone ? 1 : YTPlayer.opt.opacity}, 1000);
					jQuery(YTPlayer.playerEl).CSSAnimate({opacity: 1}, timer);

					if (YTPlayer.opt.startAt) {
						YTPlayer.player.seekTo(YTPlayer.opt.startAt);
					}
					jQuery.mbYTPlayer.checkForState(YTPlayer);

					if (!YTPlayer.opt.autoPlay)
						jQuery(YTPlayer).pauseYTP();

				});

				if (YTPlayer.opt.mute) {
					jQuery(YTPlayer).muteYTPVolume();
				} else {
					jQuery(YTPlayer).unmuteYTP();
				}

			}, timer);

			if (YTPlayer.opt.addRaster) {
				var retina = (window.retina || window.devicePixelRatio > 1);
				YTPlayer.overlay.addClass(retina ? "raster retina" : "raster");
			} else {
				YTPlayer.overlay.removeClass("raster");
				YTPlayer.overlay.removeClass("retina");
			}

			jQuery("#controlBar_" + YTPlayer.id).remove();

			if (YTPlayer.opt.showControls)
				jQuery(YTPlayer).buildYTPControls();

			jQuery.mbYTPlayer.getDataFromFeed(YTPlayer);
			jQuery(YTPlayer).optimizeDisplay();
		},

		getPlayer: function () {
			return jQuery(this).get(0).player;
		},

		playerDestroy: function () {
			var YTPlayer = this.get(0);
			ytp.YTAPIReady = false;
			ytp.backgroundIsInited = false;
			YTPlayer.isInit = false;
			YTPlayer.videoID = null;
			var playerBox = YTPlayer.wrapper;
			playerBox.remove();
			jQuery("#controlBar_" + YTPlayer.id).remove();
		},

		fullscreen: function (real) {

			var YTPlayer = this.get(0);

			if (typeof real == "undefined")
				real = YTPlayer.opt.realfullscreen;

			real = eval(real);

			var controls = jQuery("#controlBar_" + YTPlayer.id);
			var fullScreenBtn = controls.find(".mb_OnlyYT");
			var videoWrapper = YTPlayer.isSelf ? YTPlayer.opt.containment : YTPlayer.wrapper;
			//var videoWrapper = YTPlayer.wrapper;

			if (real) {
				var fullscreenchange = jQuery.browser.mozilla ? "mozfullscreenchange" : jQuery.browser.webkit ? "webkitfullscreenchange" : "fullscreenchange";
				jQuery(document).off(fullscreenchange).on(fullscreenchange, function () {
					var isFullScreen = RunPrefixMethod(document, "IsFullScreen") || RunPrefixMethod(document, "FullScreen");

					if (!isFullScreen) {
						YTPlayer.isAlone = false;
						fullScreenBtn.html(jQuery.mbYTPlayer.controls.onlyYT);
						jQuery(YTPlayer).setVideoQuality(YTPlayer.opt.quality);
						videoWrapper.removeClass("fullscreen");

						videoWrapper.CSSAnimate({opacity: YTPlayer.opt.opacity}, 500);
						videoWrapper.css({zIndex: 0});

						if (YTPlayer.isBackground) {
							jQuery("body").after(controls);
						} else {
							YTPlayer.wrapper.before(controls);
						}
						jQuery(window).resize();
						jQuery(YTPlayer).trigger("YTPFullScreenEnd");

					} else {
						jQuery(YTPlayer).setVideoQuality("default");
						jQuery(YTPlayer).trigger("YTPFullScreenStart");
					}
				});
			}

			if (!YTPlayer.isAlone) {

				if (real) {

					videoWrapper.css({opacity: 0});
					videoWrapper.addClass("fullscreen");
					launchFullscreen(videoWrapper.get(0));
					setTimeout(function () {
						videoWrapper.CSSAnimate({opacity: 1}, 1000);
						YTPlayer.wrapper.append(controls);
						jQuery(YTPlayer).optimizeDisplay();

						YTPlayer.player.seekTo(YTPlayer.player.getCurrentTime() + .1, true);
					}, 500)
				} else
					videoWrapper.css({zIndex: 10000}).CSSAnimate({opacity: 1}, 1000);


				fullScreenBtn.html(jQuery.mbYTPlayer.controls.showSite);
				YTPlayer.isAlone = true;

			} else {

				if (real) {
					cancelFullscreen();
				} else {
					videoWrapper.CSSAnimate({opacity: YTPlayer.opt.opacity}, 500);
					videoWrapper.css({zIndex: 0});
				}


                fullScreenBtn.html(jQuery.mbYTPlayer.controls.onlyYT);
				YTPlayer.isAlone = false;
			}

			function RunPrefixMethod(obj, method) {
				var pfx = ["webkit", "moz", "ms", "o", ""];
				var p = 0, m, t;
				while (p < pfx.length && !obj[m]) {
					m = method;
					if (pfx[p] == "") {
						m = m.substr(0, 1).toLowerCase() + m.substr(1);
					}
					m = pfx[p] + m;
					t = typeof obj[m];
					if (t != "undefined") {
						pfx = [pfx[p]];
						return (t == "function" ? obj[m]() : obj[m]);
					}
					p++;
				}
			}

			function launchFullscreen(element) {
				RunPrefixMethod(element, "RequestFullScreen");
			}

			function cancelFullscreen() {
				if (RunPrefixMethod(document, "FullScreen") || RunPrefixMethod(document, "IsFullScreen")) {
					RunPrefixMethod(document, "CancelFullScreen");
				}
			}
		},

		playYTP: function () {
			var YTPlayer = this.get(0);

			if (typeof YTPlayer.player === "undefined")
				return;

			var controls = jQuery("#controlBar_" + YTPlayer.id);
			var playBtn = controls.find(".mb_YTPPlaypause");
			playBtn.html(jQuery.mbYTPlayer.controls.pause);
			YTPlayer.player.playVideo();

			YTPlayer.wrapper.CSSAnimate({opacity: YTPlayer.isAlone ? 1 : YTPlayer.opt.opacity}, 2000);
			jQuery(YTPlayer).on("YTPStart", function () {
				jQuery(YTPlayer).css("background-image", "none");
			})
		},

		toggleLoops: function () {
			var YTPlayer = this.get(0);
			var data = YTPlayer.opt;
			if (data.loop == 1) {
				data.loop = 0;
			} else {
				if (data.startAt) {
					YTPlayer.player.seekTo(data.startAt);
				} else {
					YTPlayer.player.playVideo();
				}
				data.loop = 1;
			}
		},

		stopYTP: function () {
			var YTPlayer = this.get(0);
			var controls = jQuery("#controlBar_" + YTPlayer.id);
			var playBtn = controls.find(".mb_YTPPlaypause");
			playBtn.html(jQuery.mbYTPlayer.controls.play);
			YTPlayer.player.stopVideo();
		},

		pauseYTP: function () {
			var YTPlayer = this.get(0);
			var data = YTPlayer.opt;
			var controls = jQuery("#controlBar_" + YTPlayer.id);
			var playBtn = controls.find(".mb_YTPPlaypause");
			playBtn.html(jQuery.mbYTPlayer.controls.play);
			YTPlayer.player.pauseVideo();
		},

		seekToYTP: function (val) {
			var YTPlayer = this.get(0);
			YTPlayer.player.seekTo(val, true);
		},

		setYTPVolume: function (val) {
			var YTPlayer = this.get(0);
			if (!val && !YTPlayer.opt.vol && YTPlayer.player.getVolume() == 0)
				jQuery(YTPlayer).unmuteYTP();
			else if ((!val && YTPlayer.player.getVolume() > 0) || (val && YTPlayer.player.getVolume() == val))
				jQuery(YTPlayer).muteYTPVolume();
			else
				YTPlayer.opt.vol = val;
			YTPlayer.player.setVolume(YTPlayer.opt.vol);
		},

		muteYTP: function () {
			var YTPlayer = this.get(0);
			YTPlayer.player.mute();
			YTPlayer.player.setVolume(0);

			var controls = jQuery("#controlBar_" + YTPlayer.id);
			var muteBtn = controls.find(".mb_YTPMuteUnmute");
			muteBtn.html(jQuery.mbYTPlayer.controls.unmute);
			jQuery(YTPlayer).addClass("isMuted");
			jQuery(YTPlayer).trigger("YTPMuted");
		},

		unmuteYTP: function () {
			var YTPlayer = this.get(0);

			YTPlayer.player.unMute();
			YTPlayer.player.setVolume(YTPlayer.opt.vol);

			var controls = jQuery("#controlBar_" + YTPlayer.id);
			var muteBtn = controls.find(".mb_YTPMuteUnmute");
			muteBtn.html(jQuery.mbYTPlayer.controls.mute);

			jQuery(YTPlayer).removeClass("isMuted");
			jQuery(YTPlayer).trigger("YTPUnmuted");
		},

		manageYTPProgress: function () {

			var YTPlayer = this.get(0);
			var controls = jQuery("#controlBar_" + YTPlayer.id);
			var progressBar = controls.find(".mb_YTPProgress");
			var loadedBar = controls.find(".mb_YTPLoaded");
			var timeBar = controls.find(".mb_YTPseekbar");
			var totW = progressBar.outerWidth();

			var currentTime = Math.floor(YTPlayer.player.getCurrentTime());
			var totalTime = Math.floor(YTPlayer.player.getDuration());
			var timeW = (currentTime * totW) / totalTime;
			var startLeft = 0;

			var loadedW = YTPlayer.player.getVideoLoadedFraction() * 100;

			loadedBar.css({left: startLeft, width: loadedW + "%"});
			timeBar.css({left: 0, width: timeW});
			return {totalTime: totalTime, currentTime: currentTime};
		},

		buildYTPControls: function () {
			var YTPlayer = this.get(0);
			var data = YTPlayer.opt;

			/** @data.printUrl is deprecated; use data.showYTLogo */
			data.showYTLogo = data.showYTLogo || data.printUrl;

			if (jQuery("#controlBar_" + YTPlayer.id).length)
				return;

			var controlBar = jQuery("<span/>").attr("id", "controlBar_" + YTPlayer.id).addClass("mb_YTPBar").css({whiteSpace: "noWrap", position: YTPlayer.isBackground ? "fixed" : "absolute", zIndex: YTPlayer.isBackground ? 10000 : 1000}).hide();
			var buttonBar = jQuery("<div/>").addClass("buttonBar");

			var playpause = jQuery("<span>" + jQuery.mbYTPlayer.controls.play + "</span>").addClass("mb_YTPPlaypause ytpicon").click(function () {
				if (YTPlayer.player.getPlayerState() == 1)
					jQuery(YTPlayer).pauseYTP();
				else
					jQuery(YTPlayer).playYTP();
			});

			var MuteUnmute = jQuery("<span>" + jQuery.mbYTPlayer.controls.mute + "</span>").addClass("mb_YTPMuteUnmute ytpicon").click(function () {
				if (YTPlayer.player.getVolume() == 0) {
					jQuery(YTPlayer).unmuteYTP();
				} else {
					jQuery(YTPlayer).muteYTP();
				}
			});

			var idx = jQuery("<span/>").addClass("mb_YTPTime");

			var vURL = data.videoURL ? data.videoURL : "";

			if (vURL.indexOf("http") < 0)
				vURL = jQuery.mbYTPlayer.locationProtocol + "//www.youtube.com/watch?v=" + data.videoURL;
			var movieUrl = jQuery("<span/>").html(jQuery.mbYTPlayer.controls.ytLogo).addClass("mb_YTPUrl ytpicon").attr("title", "view on YouTube").on("click", function () {window.open(vURL, "viewOnYT")});
			var onlyVideo = jQuery("<span/>").html(jQuery.mbYTPlayer.controls.onlyYT).addClass("mb_OnlyYT ytpicon").on("click", function () {jQuery(YTPlayer).fullscreen(data.realfullscreen);});

			var progressBar = jQuery("<div/>").addClass("mb_YTPProgress").css("position", "absolute").click(function (e) {
				timeBar.css({width: (e.clientX - timeBar.offset().left)});
				YTPlayer.timeW = e.clientX - timeBar.offset().left;
				controlBar.find(".mb_YTPLoaded").css({width: 0});
				var totalTime = Math.floor(YTPlayer.player.getDuration());
				YTPlayer.goto = (timeBar.outerWidth() * totalTime) / progressBar.outerWidth();

				YTPlayer.player.seekTo(parseFloat(YTPlayer.goto), true);
				controlBar.find(".mb_YTPLoaded").css({width: 0});
			});

			var loadedBar = jQuery("<div/>").addClass("mb_YTPLoaded").css("position", "absolute");
			var timeBar = jQuery("<div/>").addClass("mb_YTPseekbar").css("position", "absolute");

			progressBar.append(loadedBar).append(timeBar);
			buttonBar.append(playpause).append(MuteUnmute).append(idx);

			if (data.showYTLogo) {
				buttonBar.append(movieUrl);
			}

			if (YTPlayer.isBackground || (eval(YTPlayer.opt.realfullscreen) && !YTPlayer.isBackground))
				buttonBar.append(onlyVideo);

			controlBar.append(buttonBar).append(progressBar);

			if (!YTPlayer.isBackground) {
				controlBar.addClass("inlinePlayer");
				YTPlayer.wrapper.before(controlBar);
			} else {
				jQuery("body").after(controlBar);
			}
			controlBar.fadeIn();
		},

		checkForState: function (YTPlayer) {

			var interval = YTPlayer.opt.showControls ? 10 : 1000;
			clearInterval(YTPlayer.getState);

			YTPlayer.getState = setInterval(function () {
				var prog = jQuery(YTPlayer).manageYTPProgress();
				var $YTPlayer = jQuery(YTPlayer);
				var controlBar = jQuery("#controlBar_" + YTPlayer.id);
				var data = YTPlayer.opt;
				var startAt = YTPlayer.opt.startAt ? YTPlayer.opt.startAt : 1;
				var stopAt = YTPlayer.opt.stopAt > YTPlayer.opt.startAt ? YTPlayer.opt.stopAt : 0;
				stopAt = stopAt < YTPlayer.player.getDuration() ? stopAt : 0;

				if (YTPlayer.player.time != prog.currentTime) {
					var YTPevent = jQuery.Event("YTPTime");
					YTPevent.time = YTPlayer.player.time;
					jQuery(YTPlayer).trigger(YTPevent);
				}

				YTPlayer.player.time = prog.currentTime;

				if (YTPlayer.player.getVolume() == 0)
					$YTPlayer.addClass("isMuted");
				else
					$YTPlayer.removeClass("isMuted");

				if (YTPlayer.opt.showControls)
					if (prog.totalTime) {
						controlBar.find(".mb_YTPTime").html(jQuery.mbYTPlayer.formatTime(prog.currentTime) + " / " + jQuery.mbYTPlayer.formatTime(prog.totalTime));
					} else {
						controlBar.find(".mb_YTPTime").html("-- : -- / -- : --");
					}

				if(YTPlayer.opt.stopMovieOnBlur)
					if (!document.hasFocus()) {

						if (YTPlayer.state == 1) {
							YTPlayer.hasFocus = false;
							$YTPlayer.pauseYTP();
						}

					} else if (document.hasFocus() && !YTPlayer.hasFocus) {

						YTPlayer.hasFocus = true;
						$YTPlayer.playYTP();
					}

				if (YTPlayer.player.getPlayerState() == 1 && (parseFloat(YTPlayer.player.getDuration() - 3) < YTPlayer.player.getCurrentTime() || (stopAt > 0 && parseFloat(YTPlayer.player.getCurrentTime()) > stopAt))) {

					if (YTPlayer.isEnded)
						return;

					YTPlayer.isEnded = true;
					setTimeout(function () {YTPlayer.isEnded = false}, 2000);

					if (YTPlayer.isPlayList) {
						clearInterval(YTPlayer.getState);

						var YTPEnd = jQuery.Event("YTPEnd");
						YTPEnd.time = YTPlayer.player.time;
						jQuery(YTPlayer).trigger(YTPEnd);



					} else if (!data.loop) {
						YTPlayer.player.pauseVideo();
						YTPlayer.wrapper.CSSAnimate({opacity: 0}, 1000, function () {

							var YTPEnd = jQuery.Event("YTPEnd");
							YTPEnd.time = YTPlayer.player.time;
							jQuery(YTPlayer).trigger(YTPEnd);

							YTPlayer.player.seekTo(startAt, true);

							if (!YTPlayer.isBackground) {
								var bgndURL = YTPlayer.videoData.thumbnail.hqDefault;
								jQuery(YTPlayer).css({background: "rgba(0,0,0,0.5) url(" + bgndURL + ") center center", backgroundSize: "cover"});
							}

						});
					} else
						YTPlayer.player.seekTo(startAt, true);
				}
			}, interval);
		},

		formatTime: function (s) {
			var min = Math.floor(s / 60);
			var sec = Math.floor(s - (60 * min));
			return (min <= 9 ? "0" + min : min) + " : " + (sec <= 9 ? "0" + sec : sec);
		}
	};

	jQuery.fn.toggleVolume = function () {
		var YTPlayer = this.get(0);
		if (!YTPlayer)
			return;

		if (YTPlayer.player.isMuted()) {
			jQuery(YTPlayer).unmuteYTP();
			return true;
		} else {
			jQuery(YTPlayer).muteYTP();
			return false;
		}
	};

	jQuery.fn.optimizeDisplay = function () {

		var YTPlayer = this.get(0);
		var data = YTPlayer.opt;
		var playerBox = jQuery(YTPlayer.playerEl);
		var win = {};
		var el = YTPlayer.wrapper;

		win.width = el.outerWidth();
		win.height = el.outerHeight();

		var margin = 24;
		var overprint = 100;
		var vid = {};
		vid.width = win.width + ((win.width * margin) / 100);
		vid.height = data.ratio == "16/9" ? Math.ceil((9 * win.width) / 16) : Math.ceil((3 * win.width) / 4);
		vid.marginTop = -((vid.height - win.height) / 2);
		vid.marginLeft = -((win.width * (margin / 2)) / 100);

		if (vid.height < win.height) {
			vid.height = win.height + ((win.height * margin) / 100);
			vid.width = data.ratio == "16/9" ? Math.floor((16 * win.height) / 9) : Math.floor((4 * win.height) / 3);
			vid.marginTop = -((win.height * (margin / 2)) / 100);
			vid.marginLeft = -((vid.width - win.width) / 2);
		}

		vid.width += overprint;
		vid.height += overprint;
		vid.marginTop -= overprint / 2;
		vid.marginLeft -= overprint / 2;

		playerBox.css({width: vid.width, height: vid.height, marginTop: vid.marginTop, marginLeft: vid.marginLeft});
	};

	jQuery.shuffle = function (arr) {
		var newArray = arr.slice();
		var len = newArray.length;
		var i = len;
		while (i--) {
			var p = parseInt(Math.random() * len);
			var t = newArray[i];
			newArray[i] = newArray[p];
			newArray[p] = t;
		}
		return newArray;
	};

	/*Exposed method for external use*/
	jQuery.fn.YTPlayer = jQuery.mbYTPlayer.buildPlayer;
	jQuery.fn.YTPlaylist = jQuery.mbYTPlayer.YTPlaylist;
	jQuery.fn.playNext = jQuery.mbYTPlayer.playNext;
	jQuery.fn.playPrev = jQuery.mbYTPlayer.playPrev;
	jQuery.fn.changeMovie = jQuery.mbYTPlayer.changeMovie;
	jQuery.fn.getVideoID = jQuery.mbYTPlayer.getVideoID;
	jQuery.fn.getPlayer = jQuery.mbYTPlayer.getPlayer;
	jQuery.fn.playerDestroy = jQuery.mbYTPlayer.playerDestroy;
	jQuery.fn.fullscreen = jQuery.mbYTPlayer.fullscreen;
	jQuery.fn.buildYTPControls = jQuery.mbYTPlayer.buildYTPControls;
	jQuery.fn.playYTP = jQuery.mbYTPlayer.playYTP;
	jQuery.fn.toggleLoops = jQuery.mbYTPlayer.toggleLoops;
	jQuery.fn.stopYTP = jQuery.mbYTPlayer.stopYTP;
	jQuery.fn.pauseYTP = jQuery.mbYTPlayer.pauseYTP;
	jQuery.fn.seekToYTP = jQuery.mbYTPlayer.seekToYTP;
	jQuery.fn.muteYTP = jQuery.mbYTPlayer.muteYTP;
	jQuery.fn.unmuteYTP = jQuery.mbYTPlayer.unmuteYTP;
	jQuery.fn.setYTPVolume = jQuery.mbYTPlayer.setYTPVolume;
	jQuery.fn.setVideoQuality = jQuery.mbYTPlayer.setVideoQuality;
	jQuery.fn.manageYTPProgress = jQuery.mbYTPlayer.manageYTPProgress;
	jQuery.fn.getDataFromFeed = jQuery.mbYTPlayer.getVideoData;

	/** @deprecated **/
	jQuery.fn.mb_YTPlayer = jQuery.fn.YTPlayer;
	jQuery.fn.muteYTPVolume = jQuery.mbYTPlayer.muteYTP;
	jQuery.fn.unmuteYTPVolume = jQuery.mbYTPlayer.unmuteYTP;


})(jQuery, ytp);

/*------------------------------------------------------------------*/
/*	12) TYPED
/*------------------------------------------------------------------*/

// The MIT License (MIT)

// Typed.js | Copyright (c) 2016 Matt Boldt | www.mattboldt.com

// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:

// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.

// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.

! function($) {

	"use strict";

	var Typed = function(el, options) {

		// chosen element to manipulate text
		this.el = $(el);

		// options
		this.options = $.extend({}, $.fn.typed.defaults, options);

		// attribute to type into
		this.isInput = this.el.is('input');
		this.attr = this.options.attr;

		// show cursor
		this.showCursor = this.isInput ? false : this.options.showCursor;

		// text content of element
		this.elContent = this.attr ? this.el.attr(this.attr) : this.el.text();

		// html or plain text
		this.contentType = this.options.contentType;

		// typing speed
		this.typeSpeed = this.options.typeSpeed;

		// add a delay before typing starts
		this.startDelay = this.options.startDelay;

		// backspacing speed
		this.backSpeed = this.options.backSpeed;

		// amount of time to wait before backspacing
		this.backDelay = this.options.backDelay;

		// div containing strings
		this.stringsElement = this.options.stringsElement;

		// input strings of text
		this.strings = this.options.strings;

		// character number position of current string
		this.strPos = 0;

		// current array position
		this.arrayPos = 0;

		// number to stop backspacing on.
		// default 0, can change depending on how many chars
		// you want to remove at the time
		this.stopNum = 0;

		// Looping logic
		this.loop = this.options.loop;
		this.loopCount = this.options.loopCount;
		this.curLoop = 0;

		// for stopping
		this.stop = false;

		// custom cursor
		this.cursorChar = this.options.cursorChar;

		// shuffle the strings
		this.shuffle = this.options.shuffle;
		// the order of strings
		this.sequence = [];

		// All systems go!
		this.build();
	};

	Typed.prototype = {

		constructor: Typed,

		init: function() {
			// begin the loop w/ first current string (global self.strings)
			// current string will be passed as an argument each time after this
			var self = this;
			self.timeout = setTimeout(function() {
				for (var i=0;i<self.strings.length;++i) self.sequence[i]=i;

				// shuffle the array if true
				if(self.shuffle) self.sequence = self.shuffleArray(self.sequence);

				// Start typing
				self.typewrite(self.strings[self.sequence[self.arrayPos]], self.strPos);
			}, self.startDelay);
		},

		build: function() {
			var self = this;
			// Insert cursor
			if (this.showCursor === true) {
				this.cursor = $("<span class=\"typed-cursor\">" + this.cursorChar + "</span>");
				this.el.after(this.cursor);
			}
			if (this.stringsElement) {
				this.strings = [];
				this.stringsElement.hide();
				console.log(this.stringsElement.children());
				var strings = this.stringsElement.children();
				$.each(strings, function(key, value){
					self.strings.push($(value).html());
				});
			}
			this.init();
		},

		// pass current string state to each function, types 1 char per call
		typewrite: function(curString, curStrPos) {
			// exit when stopped
			if (this.stop === true) {
				return;
			}

			// varying values for setTimeout during typing
			// can't be global since number changes each time loop is executed
			var humanize = Math.round(Math.random() * (100 - 30)) + this.typeSpeed;
			var self = this;

			// ------------- optional ------------- //
			// backpaces a certain string faster
			// ------------------------------------ //
			// if (self.arrayPos == 1){
			//  self.backDelay = 50;
			// }
			// else{ self.backDelay = 500; }

			// contain typing function in a timeout humanize'd delay
			self.timeout = setTimeout(function() {
				// check for an escape character before a pause value
				// format: \^\d+ .. eg: ^1000 .. should be able to print the ^ too using ^^
				// single ^ are removed from string
				var charPause = 0;
				var substr = curString.substr(curStrPos);
				if (substr.charAt(0) === '^') {
					var skip = 1; // skip atleast 1
					if (/^\^\d+/.test(substr)) {
						substr = /\d+/.exec(substr)[0];
						skip += substr.length;
						charPause = parseInt(substr);
					}

					// strip out the escape character and pause value so they're not printed
					curString = curString.substring(0, curStrPos) + curString.substring(curStrPos + skip);
				}

				if (self.contentType === 'html') {
					// skip over html tags while typing
                    var curChar = curString.substr(curStrPos).charAt(0);
					if (curChar === '<' || curChar === '&') {
						var tag = '';
						var endTag = '';
						if (curChar === '<') {
							endTag = '>'
						}
						else {
							endTag = ';'
						}
						while (curString.substr(curStrPos + 1).charAt(0) !== endTag) {
							tag += curString.substr(curStrPos).charAt(0);
							curStrPos++;
							if (curStrPos + 1 > curString.length) { break; }
						}
						curStrPos++;
						tag += endTag;
					}
				}

				// timeout for any pause after a character
				self.timeout = setTimeout(function() {
					if (curStrPos === curString.length) {
						// fires callback function
						self.options.onStringTyped(self.arrayPos);

						// is this the final string
						if (self.arrayPos === self.strings.length - 1) {
							// animation that occurs on the last typed string
							self.options.callback();

							self.curLoop++;

							// quit if we wont loop back
							if (self.loop === false || self.curLoop === self.loopCount)
								return;
						}

						self.timeout = setTimeout(function() {
							self.backspace(curString, curStrPos);
						}, self.backDelay);

					} else {

						/* call before functions if applicable */
						if (curStrPos === 0) {
							self.options.preStringTyped(self.arrayPos);
						}

						// start typing each new char into existing string
						// curString: arg, self.el.html: original text inside element
						var nextString = curString.substr(0, curStrPos + 1);
						if (self.attr) {
							self.el.attr(self.attr, nextString);
						} else {
							if (self.isInput) {
								self.el.val(nextString);
							} else if (self.contentType === 'html') {
								self.el.html(nextString);
							} else {
								self.el.text(nextString);
							}
						}

						// add characters one by one
						curStrPos++;
						// loop the function
						self.typewrite(curString, curStrPos);
					}
					// end of character pause
				}, charPause);

				// humanized value for typing
			}, humanize);

		},

		backspace: function(curString, curStrPos) {
			// exit when stopped
			if (this.stop === true) {
				return;
			}

			// varying values for setTimeout during typing
			// can't be global since number changes each time loop is executed
			var humanize = Math.round(Math.random() * (100 - 30)) + this.backSpeed;
			var self = this;

			self.timeout = setTimeout(function() {

				// ----- this part is optional ----- //
				// check string array position
				// on the first string, only delete one word
				// the stopNum actually represents the amount of chars to
				// keep in the current string. In my case it's 14.
				// if (self.arrayPos == 1){
				//  self.stopNum = 14;
				// }
				//every other time, delete the whole typed string
				// else{
				//  self.stopNum = 0;
				// }

				if (self.contentType === 'html') {
					// skip over html tags while backspacing
					if (curString.substr(curStrPos).charAt(0) === '>') {
						var tag = '';
						while (curString.substr(curStrPos - 1).charAt(0) !== '<') {
							tag -= curString.substr(curStrPos).charAt(0);
							curStrPos--;
							if (curStrPos < 0) { break; }
						}
						curStrPos--;
						tag += '<';
					}
				}

				// ----- continue important stuff ----- //
				// replace text with base text + typed characters
				var nextString = curString.substr(0, curStrPos);
				if (self.attr) {
					self.el.attr(self.attr, nextString);
				} else {
					if (self.isInput) {
						self.el.val(nextString);
					} else if (self.contentType === 'html') {
						self.el.html(nextString);
					} else {
						self.el.text(nextString);
					}
				}

				// if the number (id of character in current string) is
				// less than the stop number, keep going
				if (curStrPos > self.stopNum) {
					// subtract characters one by one
					curStrPos--;
					// loop the function
					self.backspace(curString, curStrPos);
				}
				// if the stop number has been reached, increase
				// array position to next string
				else if (curStrPos <= self.stopNum) {
					self.arrayPos++;

					if (self.arrayPos === self.strings.length) {
						self.arrayPos = 0;

						// Shuffle sequence again
						if(self.shuffle) self.sequence = self.shuffleArray(self.sequence);

						self.init();
					} else
						self.typewrite(self.strings[self.sequence[self.arrayPos]], curStrPos);
				}

				// humanized value for typing
			}, humanize);

		},
		/**
		 * Shuffles the numbers in the given array.
		 * @param {Array} array
		 * @returns {Array}
		 */
		shuffleArray: function(array) {
			var tmp, current, top = array.length;
			if(top) while(--top) {
				current = Math.floor(Math.random() * (top + 1));
				tmp = array[current];
				array[current] = array[top];
				array[top] = tmp;
			}
			return array;
		},

		// Start & Stop currently not working

		// , stop: function() {
		//     var self = this;

		//     self.stop = true;
		//     clearInterval(self.timeout);
		// }

		// , start: function() {
		//     var self = this;
		//     if(self.stop === false)
		//        return;

		//     this.stop = false;
		//     this.init();
		// }

		// Reset and rebuild the element
		reset: function() {
			var self = this;
			clearInterval(self.timeout);
			var id = this.el.attr('id');
			this.el.empty();
			if (typeof this.cursor !== 'undefined') {
        this.cursor.remove();
      }
			this.strPos = 0;
			this.arrayPos = 0;
			this.curLoop = 0;
			// Send the callback
			this.options.resetCallback();
		}

	};

	$.fn.typed = function(option) {
		return this.each(function() {
			var $this = $(this),
				data = $this.data('typed'),
				options = typeof option == 'object' && option;
			if (data) { data.reset(); }
			$this.data('typed', (data = new Typed(this, options)));
			if (typeof option == 'string') data[option]();
		});
	};

	$.fn.typed.defaults = {
		strings: ["These are the default values...", "You know what you should do?", "Use your own!", "Have a great day!"],
		stringsElement: null,
		// typing speed
		typeSpeed: 0,
		// time before typing starts
		startDelay: 0,
		// backspacing speed
		backSpeed: 0,
		// shuffle the strings
		shuffle: false,
		// time before backspacing
		backDelay: 500,
		// loop
		loop: false,
		// false = infinite
		loopCount: false,
		// show cursor
		showCursor: true,
		// character for cursor
		cursorChar: "",
		// attribute to type (null == text)
		attr: null,
		// either html or text
		contentType: 'html',
		// call when done callback function
		callback: function() {},
		// starting callback function before each string
		preStringTyped: function() {},
		//callback for every typed string
		onStringTyped: function() {},
		// callback for reset
		resetCallback: function() {}
	};


}(window.jQuery);

/*------------------------------------------------------------------*/
/*	05) NICESCROLL
/*------------------------------------------------------------------*/

/* jquery.nicescroll 3.2.0 InuYaksa*2013 MIT http://areaaperta.com/nicescroll */
(function(e){var y=!1,D=!1,J=5E3,K=2E3,x=0,L=function(){var e=document.getElementsByTagName("script"),e=e[e.length-1].src.split("?")[0];return 0<e.split("/").length?e.split("/").slice(0,-1).join("/")+"/":""}();Array.prototype.forEach||(Array.prototype.forEach=function(e,c){for(var h=0,l=this.length;h<l;++h)e.call(c,this[h],h,this)});var v=window.requestAnimationFrame||!1,w=window.cancelAnimationFrame||!1;["ms","moz","webkit","o"].forEach(function(e){v||(v=window[e+"RequestAnimationFrame"]);w||(w=
window[e+"CancelAnimationFrame"]||window[e+"CancelRequestAnimationFrame"])});var z=window.MutationObserver||window.WebKitMutationObserver||!1,F={zindex:"auto",cursoropacitymin:0,cursoropacitymax:1,cursorcolor:"#424242",cursorwidth:"5px",cursorborder:"1px solid #fff",cursorborderradius:"5px",scrollspeed:60,mousescrollstep:24,touchbehavior:!1,hwacceleration:!0,usetransition:!0,boxzoom:!1,dblclickzoom:!0,gesturezoom:!0,grabcursorenabled:!0,autohidemode:!0,background:"",iframeautoresize:!0,cursorminheight:32,
preservenativescrolling:!0,railoffset:!1,bouncescroll:!0,spacebarenabled:!0,railpadding:{top:0,right:0,left:0,bottom:0},disableoutline:!0,horizrailenabled:!0,railalign:"right",railvalign:"bottom",enabletranslate3d:!0,enablemousewheel:!0,enablekeyboard:!0,smoothscroll:!0,sensitiverail:!0,enablemouselockapi:!0,cursorfixedheight:!1,directionlockdeadzone:6,hidecursordelay:400,nativeparentscrolling:!0,enablescrollonselection:!0,overflowx:!0,overflowy:!0,cursordragspeed:0.3,rtlmode:!1,cursordragontouch:!1},
E=!1,M=function(){if(E)return E;var e=document.createElement("DIV"),c={haspointerlock:"pointerLockElement"in document||"mozPointerLockElement"in document||"webkitPointerLockElement"in document};c.isopera="opera"in window;c.isopera12=c.isopera&&"getUserMedia"in navigator;c.isie="all"in document&&"attachEvent"in e&&!c.isopera;c.isieold=c.isie&&!("msInterpolationMode"in e.style);c.isie7=c.isie&&!c.isieold&&(!("documentMode"in document)||7==document.documentMode);c.isie8=c.isie&&"documentMode"in document&&
8==document.documentMode;c.isie9=c.isie&&"performance"in window&&9<=document.documentMode;c.isie10=c.isie&&"performance"in window&&10<=document.documentMode;c.isie9mobile=/iemobile.9/i.test(navigator.userAgent);c.isie9mobile&&(c.isie9=!1);c.isie7mobile=!c.isie9mobile&&c.isie7&&/iemobile/i.test(navigator.userAgent);c.ismozilla="MozAppearance"in e.style;c.iswebkit="WebkitAppearance"in e.style;c.ischrome="chrome"in window;c.ischrome22=c.ischrome&&c.haspointerlock;c.ischrome26=c.ischrome&&"transition"in
e.style;c.cantouch="ontouchstart"in document.documentElement||"ontouchstart"in window;c.hasmstouch=window.navigator.msPointerEnabled||!1;c.ismac=/^mac$/i.test(navigator.platform);c.isios=c.cantouch&&/iphone|ipad|ipod/i.test(navigator.platform);c.isios4=c.isios&&!("seal"in Object);c.isandroid=/android/i.test(navigator.userAgent);c.trstyle=!1;c.hastransform=!1;c.hastranslate3d=!1;c.transitionstyle=!1;c.hastransition=!1;c.transitionend=!1;for(var h=["transform","msTransform","webkitTransform","MozTransform",
"OTransform"],l=0;l<h.length;l++)if("undefined"!=typeof e.style[h[l]]){c.trstyle=h[l];break}c.hastransform=!1!=c.trstyle;c.hastransform&&(e.style[c.trstyle]="translate3d(1px,2px,3px)",c.hastranslate3d=/translate3d/.test(e.style[c.trstyle]));c.transitionstyle=!1;c.prefixstyle="";c.transitionend=!1;for(var h="transition webkitTransition MozTransition OTransition OTransition msTransition KhtmlTransition".split(" "),n=" -webkit- -moz- -o- -o -ms- -khtml-".split(" "),t="transitionend webkitTransitionEnd transitionend otransitionend oTransitionEnd msTransitionEnd KhtmlTransitionEnd".split(" "),
l=0;l<h.length;l++)if(h[l]in e.style){c.transitionstyle=h[l];c.prefixstyle=n[l];c.transitionend=t[l];break}c.ischrome26&&(c.prefixstyle=n[1]);c.hastransition=c.transitionstyle;a:{h=["-moz-grab","-webkit-grab","grab"];if(c.ischrome&&!c.ischrome22||c.isie)h=[];for(l=0;l<h.length;l++)if(n=h[l],e.style.cursor=n,e.style.cursor==n){h=n;break a}h="url(http://www.google.com/intl/en_ALL/mapfiles/openhand.cur),n-resize"}c.cursorgrabvalue=h;c.hasmousecapture="setCapture"in e;c.hasMutationObserver=!1!==z;return E=
c},N=function(k,c){function h(){var d=b.win;if("zIndex"in d)return d.zIndex();for(;0<d.length&&9!=d[0].nodeType;){var c=d.css("zIndex");if(!isNaN(c)&&0!=c)return parseInt(c);d=d.parent()}return!1}function l(d,c,g){c=d.css(c);d=parseFloat(c);return isNaN(d)?(d=u[c]||0,g=3==d?g?b.win.outerHeight()-b.win.innerHeight():b.win.outerWidth()-b.win.innerWidth():1,b.isie8&&d&&(d+=1),g?d:0):d}function n(d,c,g,e){b._bind(d,c,function(b){b=b?b:window.event;var e={original:b,target:b.target||b.srcElement,type:"wheel",
deltaMode:"MozMousePixelScroll"==b.type?0:1,deltaX:0,deltaZ:0,preventDefault:function(){b.preventDefault?b.preventDefault():b.returnValue=!1;return!1},stopImmediatePropagation:function(){b.stopImmediatePropagation?b.stopImmediatePropagation():b.cancelBubble=!0}};"mousewheel"==c?(e.deltaY=-0.025*b.wheelDelta,b.wheelDeltaX&&(e.deltaX=-0.025*b.wheelDeltaX)):e.deltaY=b.detail;return g.call(d,e)},e)}function t(d,c,g){var e,f;0==d.deltaMode?(e=-Math.floor(d.deltaX*(b.opt.mousescrollstep/54)),f=-Math.floor(d.deltaY*
(b.opt.mousescrollstep/54))):1==d.deltaMode&&(e=-Math.floor(d.deltaX*b.opt.mousescrollstep),f=-Math.floor(d.deltaY*b.opt.mousescrollstep));c&&(0==e&&f)&&(e=f,f=0);e&&(b.scrollmom&&b.scrollmom.stop(),b.lastdeltax+=e,b.debounced("mousewheelx",function(){var d=b.lastdeltax;b.lastdeltax=0;b.rail.drag||b.doScrollLeftBy(d)},120));if(f){if(b.opt.nativeparentscrolling&&g&&!b.ispage&&!b.zoomactive)if(0>f){if(b.getScrollTop()>=b.page.maxh)return!0}else if(0>=b.getScrollTop())return!0;b.scrollmom&&b.scrollmom.stop();
b.lastdeltay+=f;b.debounced("mousewheely",function(){var d=b.lastdeltay;b.lastdeltay=0;b.rail.drag||b.doScrollBy(d)},120)}d.stopImmediatePropagation();return d.preventDefault()}var b=this;this.version="3.4.0";this.name="nicescroll";this.me=c;this.opt={doc:e("body"),win:!1};e.extend(this.opt,F);this.opt.snapbackspeed=80;if(k)for(var q in b.opt)"undefined"!=typeof k[q]&&(b.opt[q]=k[q]);this.iddoc=(this.doc=b.opt.doc)&&this.doc[0]?this.doc[0].id||"":"";this.ispage=/BODY|HTML/.test(b.opt.win?b.opt.win[0].nodeName:
this.doc[0].nodeName);this.haswrapper=!1!==b.opt.win;this.win=b.opt.win||(this.ispage?e(window):this.doc);this.docscroll=this.ispage&&!this.haswrapper?e(window):this.win;this.body=e("body");this.iframe=this.isfixed=this.viewport=!1;this.isiframe="IFRAME"==this.doc[0].nodeName&&"IFRAME"==this.win[0].nodeName;this.istextarea="TEXTAREA"==this.win[0].nodeName;this.forcescreen=!1;this.canshowonmouseevent="scroll"!=b.opt.autohidemode;this.page=this.view=this.onzoomout=this.onzoomin=this.onscrollcancel=
this.onscrollend=this.onscrollstart=this.onclick=this.ongesturezoom=this.onkeypress=this.onmousewheel=this.onmousemove=this.onmouseup=this.onmousedown=!1;this.scroll={x:0,y:0};this.scrollratio={x:0,y:0};this.cursorheight=20;this.scrollvaluemax=0;this.observerremover=this.observer=this.scrollmom=this.scrollrunning=this.checkrtlmode=!1;do this.id="ascrail"+K++;while(document.getElementById(this.id));this.hasmousefocus=this.hasfocus=this.zoomactive=this.zoom=this.selectiondrag=this.cursorfreezed=this.cursor=
this.rail=!1;this.visibility=!0;this.hidden=this.locked=!1;this.cursoractive=!0;this.overflowx=b.opt.overflowx;this.overflowy=b.opt.overflowy;this.nativescrollingarea=!1;this.checkarea=0;this.events=[];this.saved={};this.delaylist={};this.synclist={};this.lastdeltay=this.lastdeltax=0;this.detected=M();var f=e.extend({},this.detected);this.ishwscroll=(this.canhwscroll=f.hastransform&&b.opt.hwacceleration)&&b.haswrapper;this.istouchcapable=!1;f.cantouch&&(f.ischrome&&!f.isios&&!f.isandroid)&&(this.istouchcapable=
!0,f.cantouch=!1);f.cantouch&&(f.ismozilla&&!f.isios)&&(this.istouchcapable=!0,f.cantouch=!1);b.opt.enablemouselockapi||(f.hasmousecapture=!1,f.haspointerlock=!1);this.delayed=function(d,c,g,e){var f=b.delaylist[d],h=(new Date).getTime();if(!e&&f&&f.tt)return!1;f&&f.tt&&clearTimeout(f.tt);if(f&&f.last+g>h&&!f.tt)b.delaylist[d]={last:h+g,tt:setTimeout(function(){b.delaylist[d].tt=0;c.call()},g)};else if(!f||!f.tt)b.delaylist[d]={last:h,tt:0},setTimeout(function(){c.call()},0)};this.debounced=function(d,
c,g){var f=b.delaylist[d];(new Date).getTime();b.delaylist[d]=c;f||setTimeout(function(){var c=b.delaylist[d];b.delaylist[d]=!1;c.call()},g)};this.synched=function(d,c){b.synclist[d]=c;(function(){b.onsync||(v(function(){b.onsync=!1;for(d in b.synclist){var c=b.synclist[d];c&&c.call(b);b.synclist[d]=!1}}),b.onsync=!0)})();return d};this.unsynched=function(d){b.synclist[d]&&(b.synclist[d]=!1)};this.css=function(d,c){for(var g in c)b.saved.css.push([d,g,d.css(g)]),d.css(g,c[g])};this.scrollTop=function(d){return"undefined"==
typeof d?b.getScrollTop():b.setScrollTop(d)};this.scrollLeft=function(d){return"undefined"==typeof d?b.getScrollLeft():b.setScrollLeft(d)};BezierClass=function(b,c,g,f,e,h,l){this.st=b;this.ed=c;this.spd=g;this.p1=f||0;this.p2=e||1;this.p3=h||0;this.p4=l||1;this.ts=(new Date).getTime();this.df=this.ed-this.st};BezierClass.prototype={B2:function(b){return 3*b*b*(1-b)},B3:function(b){return 3*b*(1-b)*(1-b)},B4:function(b){return(1-b)*(1-b)*(1-b)},getNow:function(){var b=1-((new Date).getTime()-this.ts)/
this.spd,c=this.B2(b)+this.B3(b)+this.B4(b);return 0>b?this.ed:this.st+Math.round(this.df*c)},update:function(b,c){this.st=this.getNow();this.ed=b;this.spd=c;this.ts=(new Date).getTime();this.df=this.ed-this.st;return this}};if(this.ishwscroll){this.doc.translate={x:0,y:0,tx:"0px",ty:"0px"};f.hastranslate3d&&f.isios&&this.doc.css("-webkit-backface-visibility","hidden");var r=function(){var d=b.doc.css(f.trstyle);return d&&"matrix"==d.substr(0,6)?d.replace(/^.*\((.*)\)$/g,"$1").replace(/px/g,"").split(/, +/):
!1};this.getScrollTop=function(d){if(!d){if(d=r())return 16==d.length?-d[13]:-d[5];if(b.timerscroll&&b.timerscroll.bz)return b.timerscroll.bz.getNow()}return b.doc.translate.y};this.getScrollLeft=function(d){if(!d){if(d=r())return 16==d.length?-d[12]:-d[4];if(b.timerscroll&&b.timerscroll.bh)return b.timerscroll.bh.getNow()}return b.doc.translate.x};this.notifyScrollEvent=document.createEvent?function(b){var c=document.createEvent("UIEvents");c.initUIEvent("scroll",!1,!0,window,1);b.dispatchEvent(c)}:
document.fireEvent?function(b){var c=document.createEventObject();b.fireEvent("onscroll");c.cancelBubble=!0}:function(b,c){};f.hastranslate3d&&b.opt.enabletranslate3d?(this.setScrollTop=function(d,c){b.doc.translate.y=d;b.doc.translate.ty=-1*d+"px";b.doc.css(f.trstyle,"translate3d("+b.doc.translate.tx+","+b.doc.translate.ty+",0px)");c||b.notifyScrollEvent(b.win[0])},this.setScrollLeft=function(d,c){b.doc.translate.x=d;b.doc.translate.tx=-1*d+"px";b.doc.css(f.trstyle,"translate3d("+b.doc.translate.tx+
","+b.doc.translate.ty+",0px)");c||b.notifyScrollEvent(b.win[0])}):(this.setScrollTop=function(d,c){b.doc.translate.y=d;b.doc.translate.ty=-1*d+"px";b.doc.css(f.trstyle,"translate("+b.doc.translate.tx+","+b.doc.translate.ty+")");c||b.notifyScrollEvent(b.win[0])},this.setScrollLeft=function(d,c){b.doc.translate.x=d;b.doc.translate.tx=-1*d+"px";b.doc.css(f.trstyle,"translate("+b.doc.translate.tx+","+b.doc.translate.ty+")");c||b.notifyScrollEvent(b.win[0])})}else this.getScrollTop=function(){return b.docscroll.scrollTop()},
this.setScrollTop=function(d){return b.docscroll.scrollTop(d)},this.getScrollLeft=function(){return b.docscroll.scrollLeft()},this.setScrollLeft=function(d){return b.docscroll.scrollLeft(d)};this.getTarget=function(b){return!b?!1:b.target?b.target:b.srcElement?b.srcElement:!1};this.hasParent=function(b,c){if(!b)return!1;for(var g=b.target||b.srcElement||b||!1;g&&g.id!=c;)g=g.parentNode||!1;return!1!==g};var u={thin:1,medium:3,thick:5};this.getOffset=function(){if(b.isfixed)return{top:parseFloat(b.win.css("top")),
left:parseFloat(b.win.css("left"))};if(!b.viewport)return b.win.offset();var d=b.win.offset(),c=b.viewport.offset();return{top:d.top-c.top+b.viewport.scrollTop(),left:d.left-c.left+b.viewport.scrollLeft()}};this.updateScrollBar=function(d){if(b.ishwscroll)b.rail.css({height:b.win.innerHeight()}),b.railh&&b.railh.css({width:b.win.innerWidth()});else{var c=b.getOffset(),g=c.top,f=c.left,g=g+l(b.win,"border-top-width",!0);b.win.outerWidth();b.win.innerWidth();var f=f+(b.rail.align?b.win.outerWidth()-
l(b.win,"border-right-width")-b.rail.width:l(b.win,"border-left-width")),e=b.opt.railoffset;e&&(e.top&&(g+=e.top),b.rail.align&&e.left&&(f+=e.left));b.locked||b.rail.css({top:g,left:f,height:d?d.h:b.win.innerHeight()});b.zoom&&b.zoom.css({top:g+1,left:1==b.rail.align?f-20:f+b.rail.width+4});b.railh&&!b.locked&&(g=c.top,f=c.left,d=b.railh.align?g+l(b.win,"border-top-width",!0)+b.win.innerHeight()-b.railh.height:g+l(b.win,"border-top-width",!0),f+=l(b.win,"border-left-width"),b.railh.css({top:d,left:f,
width:b.railh.width}))}};this.doRailClick=function(d,c,g){var f;b.locked||(b.cancelEvent(d),c?(c=g?b.doScrollLeft:b.doScrollTop,f=g?(d.pageX-b.railh.offset().left-b.cursorwidth/2)*b.scrollratio.x:(d.pageY-b.rail.offset().top-b.cursorheight/2)*b.scrollratio.y,c(f)):(c=g?b.doScrollLeftBy:b.doScrollBy,f=g?b.scroll.x:b.scroll.y,d=g?d.pageX-b.railh.offset().left:d.pageY-b.rail.offset().top,g=g?b.view.w:b.view.h,f>=d?c(g):c(-g)))};b.hasanimationframe=v;b.hascancelanimationframe=w;b.hasanimationframe?b.hascancelanimationframe||
(w=function(){b.cancelAnimationFrame=!0}):(v=function(b){return setTimeout(b,15-Math.floor(+new Date/1E3)%16)},w=clearInterval);this.init=function(){b.saved.css=[];if(f.isie7mobile)return!0;f.hasmstouch&&b.css(b.ispage?e("html"):b.win,{"-ms-touch-action":"none"});b.zindex="auto";b.zindex=!b.ispage&&"auto"==b.opt.zindex?h()||"auto":b.opt.zindex;!b.ispage&&"auto"!=b.zindex&&b.zindex>x&&(x=b.zindex);b.isie&&(0==b.zindex&&"auto"==b.opt.zindex)&&(b.zindex="auto");if(!b.ispage||!f.cantouch&&!f.isieold&&
!f.isie9mobile){var d=b.docscroll;b.ispage&&(d=b.haswrapper?b.win:b.doc);f.isie9mobile||b.css(d,{"overflow-y":"hidden"});b.ispage&&f.isie7&&("BODY"==b.doc[0].nodeName?b.css(e("html"),{"overflow-y":"hidden"}):"HTML"==b.doc[0].nodeName&&b.css(e("body"),{"overflow-y":"hidden"}));f.isios&&(!b.ispage&&!b.haswrapper)&&b.css(e("body"),{"-webkit-overflow-scrolling":"touch"});var c=e(document.createElement("div"));c.css({position:"relative",top:0,"float":"right",width:b.opt.cursorwidth,height:"0px","background-color":b.opt.cursorcolor,
border:b.opt.cursorborder,"background-clip":"padding-box","-webkit-border-radius":b.opt.cursorborderradius,"-moz-border-radius":b.opt.cursorborderradius,"border-radius":b.opt.cursorborderradius});c.hborder=parseFloat(c.outerHeight()-c.innerHeight());b.cursor=c;var g=e(document.createElement("div"));g.attr("id",b.id);g.addClass("nicescroll-rails");var l,k,n=["left","right"],G;for(G in n)k=n[G],(l=b.opt.railpadding[k])?g.css("padding-"+k,l+"px"):b.opt.railpadding[k]=0;g.append(c);g.width=Math.max(parseFloat(b.opt.cursorwidth),
c.outerWidth())+b.opt.railpadding.left+b.opt.railpadding.right;g.css({width:g.width+"px",zIndex:b.zindex,background:b.opt.background,cursor:"default"});g.visibility=!0;g.scrollable=!0;g.align="left"==b.opt.railalign?0:1;b.rail=g;c=b.rail.drag=!1;b.opt.boxzoom&&(!b.ispage&&!f.isieold)&&(c=document.createElement("div"),b.bind(c,"click",b.doZoom),b.zoom=e(c),b.zoom.css({cursor:"pointer","z-index":b.zindex,backgroundImage:"url("+L+"zoomico.png)",height:18,width:18,backgroundPosition:"0px 0px"}),b.opt.dblclickzoom&&
b.bind(b.win,"dblclick",b.doZoom),f.cantouch&&b.opt.gesturezoom&&(b.ongesturezoom=function(d){1.5<d.scale&&b.doZoomIn(d);0.8>d.scale&&b.doZoomOut(d);return b.cancelEvent(d)},b.bind(b.win,"gestureend",b.ongesturezoom)));b.railh=!1;if(b.opt.horizrailenabled){b.css(d,{"overflow-x":"hidden"});c=e(document.createElement("div"));c.css({position:"relative",top:0,height:b.opt.cursorwidth,width:"0px","background-color":b.opt.cursorcolor,border:b.opt.cursorborder,"background-clip":"padding-box","-webkit-border-radius":b.opt.cursorborderradius,
"-moz-border-radius":b.opt.cursorborderradius,"border-radius":b.opt.cursorborderradius});c.wborder=parseFloat(c.outerWidth()-c.innerWidth());b.cursorh=c;var m=e(document.createElement("div"));m.attr("id",b.id+"-hr");m.addClass("nicescroll-rails");m.height=Math.max(parseFloat(b.opt.cursorwidth),c.outerHeight());m.css({height:m.height+"px",zIndex:b.zindex,background:b.opt.background});m.append(c);m.visibility=!0;m.scrollable=!0;m.align="top"==b.opt.railvalign?0:1;b.railh=m;b.railh.drag=!1}b.ispage?
(g.css({position:"fixed",top:"0px",height:"100%"}),g.align?g.css({right:"0px"}):g.css({left:"0px"}),b.body.append(g),b.railh&&(m.css({position:"fixed",left:"0px",width:"100%"}),m.align?m.css({bottom:"0px"}):m.css({top:"0px"}),b.body.append(m))):(b.ishwscroll?("static"==b.win.css("position")&&b.css(b.win,{position:"relative"}),d="HTML"==b.win[0].nodeName?b.body:b.win,b.zoom&&(b.zoom.css({position:"absolute",top:1,right:0,"margin-right":g.width+4}),d.append(b.zoom)),g.css({position:"absolute",top:0}),
g.align?g.css({right:0}):g.css({left:0}),d.append(g),m&&(m.css({position:"absolute",left:0,bottom:0}),m.align?m.css({bottom:0}):m.css({top:0}),d.append(m))):(b.isfixed="fixed"==b.win.css("position"),d=b.isfixed?"fixed":"absolute",b.isfixed||(b.viewport=b.getViewport(b.win[0])),b.viewport&&(b.body=b.viewport,!1==/relative|absolute/.test(b.viewport.css("position"))&&b.css(b.viewport,{position:"relative"})),g.css({position:d}),b.zoom&&b.zoom.css({position:d}),b.updateScrollBar(),b.body.append(g),b.zoom&&
b.body.append(b.zoom),b.railh&&(m.css({position:d}),b.body.append(m))),f.isios&&b.css(b.win,{"-webkit-tap-highlight-color":"rgba(0,0,0,0)","-webkit-touch-callout":"none"}),f.isie&&b.opt.disableoutline&&b.win.attr("hideFocus","true"),f.iswebkit&&b.opt.disableoutline&&b.win.css({outline:"none"}));!1===b.opt.autohidemode?(b.autohidedom=!1,b.rail.css({opacity:b.opt.cursoropacitymax}),b.railh&&b.railh.css({opacity:b.opt.cursoropacitymax})):!0===b.opt.autohidemode?(b.autohidedom=e().add(b.rail),f.isie8&&
(b.autohidedom=b.autohidedom.add(b.cursor)),b.railh&&(b.autohidedom=b.autohidedom.add(b.railh)),b.railh&&f.isie8&&(b.autohidedom=b.autohidedom.add(b.cursorh))):"scroll"==b.opt.autohidemode?(b.autohidedom=e().add(b.rail),b.railh&&(b.autohidedom=b.autohidedom.add(b.railh))):"cursor"==b.opt.autohidemode?(b.autohidedom=e().add(b.cursor),b.railh&&(b.autohidedom=b.autohidedom.add(b.cursorh))):"hidden"==b.opt.autohidemode&&(b.autohidedom=!1,b.hide(),b.locked=!1);if(f.isie9mobile)b.scrollmom=new H(b),b.onmangotouch=
function(d){d=b.getScrollTop();var c=b.getScrollLeft();if(d==b.scrollmom.lastscrolly&&c==b.scrollmom.lastscrollx)return!0;var g=d-b.mangotouch.sy,f=c-b.mangotouch.sx;if(0!=Math.round(Math.sqrt(Math.pow(f,2)+Math.pow(g,2)))){var p=0>g?-1:1,e=0>f?-1:1,h=+new Date;b.mangotouch.lazy&&clearTimeout(b.mangotouch.lazy);80<h-b.mangotouch.tm||b.mangotouch.dry!=p||b.mangotouch.drx!=e?(b.scrollmom.stop(),b.scrollmom.reset(c,d),b.mangotouch.sy=d,b.mangotouch.ly=d,b.mangotouch.sx=c,b.mangotouch.lx=c,b.mangotouch.dry=
p,b.mangotouch.drx=e,b.mangotouch.tm=h):(b.scrollmom.stop(),b.scrollmom.update(b.mangotouch.sx-f,b.mangotouch.sy-g),b.mangotouch.tm=h,g=Math.max(Math.abs(b.mangotouch.ly-d),Math.abs(b.mangotouch.lx-c)),b.mangotouch.ly=d,b.mangotouch.lx=c,2<g&&(b.mangotouch.lazy=setTimeout(function(){b.mangotouch.lazy=!1;b.mangotouch.dry=0;b.mangotouch.drx=0;b.mangotouch.tm=0;b.scrollmom.doMomentum(30)},100)))}},g=b.getScrollTop(),m=b.getScrollLeft(),b.mangotouch={sy:g,ly:g,dry:0,sx:m,lx:m,drx:0,lazy:!1,tm:0},b.bind(b.docscroll,
"scroll",b.onmangotouch);else{if(f.cantouch||b.istouchcapable||b.opt.touchbehavior||f.hasmstouch){b.scrollmom=new H(b);b.ontouchstart=function(d){if(d.pointerType&&2!=d.pointerType)return!1;if(!b.locked){if(f.hasmstouch)for(var c=d.target?d.target:!1;c;){var g=e(c).getNiceScroll();if(0<g.length&&g[0].me==b.me)break;if(0<g.length)return!1;if("DIV"==c.nodeName&&c.id==b.id)break;c=c.parentNode?c.parentNode:!1}b.cancelScroll();if((c=b.getTarget(d))&&/INPUT/i.test(c.nodeName)&&/range/i.test(c.type))return b.stopPropagation(d);
!("clientX"in d)&&"changedTouches"in d&&(d.clientX=d.changedTouches[0].clientX,d.clientY=d.changedTouches[0].clientY);b.forcescreen&&(g=d,d={original:d.original?d.original:d},d.clientX=g.screenX,d.clientY=g.screenY);b.rail.drag={x:d.clientX,y:d.clientY,sx:b.scroll.x,sy:b.scroll.y,st:b.getScrollTop(),sl:b.getScrollLeft(),pt:2,dl:!1};if(b.ispage||!b.opt.directionlockdeadzone)b.rail.drag.dl="f";else{var g=e(window).width(),p=e(window).height(),h=Math.max(document.body.scrollWidth,document.documentElement.scrollWidth),
l=Math.max(document.body.scrollHeight,document.documentElement.scrollHeight),p=Math.max(0,l-p),g=Math.max(0,h-g);b.rail.drag.ck=!b.rail.scrollable&&b.railh.scrollable?0<p?"v":!1:b.rail.scrollable&&!b.railh.scrollable?0<g?"h":!1:!1;b.rail.drag.ck||(b.rail.drag.dl="f")}b.opt.touchbehavior&&(b.isiframe&&f.isie)&&(g=b.win.position(),b.rail.drag.x+=g.left,b.rail.drag.y+=g.top);b.hasmoving=!1;b.lastmouseup=!1;b.scrollmom.reset(d.clientX,d.clientY);if(!f.cantouch&&!this.istouchcapable&&!f.hasmstouch){if(!c||
!/INPUT|SELECT|TEXTAREA/i.test(c.nodeName))return!b.ispage&&f.hasmousecapture&&c.setCapture(),b.cancelEvent(d);/SUBMIT|CANCEL|BUTTON/i.test(e(c).attr("type"))&&(pc={tg:c,click:!1},b.preventclick=pc)}}};b.ontouchend=function(d){if(d.pointerType&&2!=d.pointerType)return!1;if(b.rail.drag&&2==b.rail.drag.pt&&(b.scrollmom.doMomentum(),b.rail.drag=!1,b.hasmoving&&(b.hasmoving=!1,b.lastmouseup=!0,b.hideCursor(),f.hasmousecapture&&document.releaseCapture(),!f.cantouch)))return b.cancelEvent(d)};var q=b.opt.touchbehavior&&
b.isiframe&&!f.hasmousecapture;b.ontouchmove=function(d,c){if(d.pointerType&&2!=d.pointerType)return!1;if(b.rail.drag&&2==b.rail.drag.pt){if(f.cantouch&&"undefined"==typeof d.original)return!0;b.hasmoving=!0;b.preventclick&&!b.preventclick.click&&(b.preventclick.click=b.preventclick.tg.onclick||!1,b.preventclick.tg.onclick=b.onpreventclick);d=e.extend({original:d},d);"changedTouches"in d&&(d.clientX=d.changedTouches[0].clientX,d.clientY=d.changedTouches[0].clientY);if(b.forcescreen){var g=d;d={original:d.original?
d.original:d};d.clientX=g.screenX;d.clientY=g.screenY}g=ofy=0;if(q&&!c){var p=b.win.position(),g=-p.left;ofy=-p.top}var h=d.clientY+ofy,p=h-b.rail.drag.y,l=d.clientX+g,k=l-b.rail.drag.x,s=b.rail.drag.st-p;b.ishwscroll&&b.opt.bouncescroll?0>s?s=Math.round(s/2):s>b.page.maxh&&(s=b.page.maxh+Math.round((s-b.page.maxh)/2)):(0>s&&(h=s=0),s>b.page.maxh&&(s=b.page.maxh,h=0));if(b.railh&&b.railh.scrollable){var m=b.rail.drag.sl-k;b.ishwscroll&&b.opt.bouncescroll?0>m?m=Math.round(m/2):m>b.page.maxw&&(m=b.page.maxw+
Math.round((m-b.page.maxw)/2)):(0>m&&(l=m=0),m>b.page.maxw&&(m=b.page.maxw,l=0))}g=!1;if(b.rail.drag.dl)g=!0,"v"==b.rail.drag.dl?m=b.rail.drag.sl:"h"==b.rail.drag.dl&&(s=b.rail.drag.st);else{var p=Math.abs(p),k=Math.abs(k),n=b.opt.directionlockdeadzone;if("v"==b.rail.drag.ck){if(p>n&&k<=0.3*p)return b.rail.drag=!1,!0;k>n&&(b.rail.drag.dl="f",e("body").scrollTop(e("body").scrollTop()))}else if("h"==b.rail.drag.ck){if(k>n&&p<=0.3*az)return b.rail.drag=!1,!0;p>n&&(b.rail.drag.dl="f",e("body").scrollLeft(e("body").scrollLeft()))}}b.synched("touchmove",
function(){b.rail.drag&&2==b.rail.drag.pt&&(b.prepareTransition&&b.prepareTransition(0),b.rail.scrollable&&b.setScrollTop(s),b.scrollmom.update(l,h),b.railh&&b.railh.scrollable?(b.setScrollLeft(m),b.showCursor(s,m)):b.showCursor(s),f.isie10&&document.selection.clear())});f.ischrome&&b.istouchcapable&&(g=!1);if(g)return b.cancelEvent(d)}}}b.onmousedown=function(d,c){if(!(b.rail.drag&&1!=b.rail.drag.pt)){if(b.locked)return b.cancelEvent(d);b.cancelScroll();b.rail.drag={x:d.clientX,y:d.clientY,sx:b.scroll.x,
sy:b.scroll.y,pt:1,hr:!!c};var g=b.getTarget(d);!b.ispage&&f.hasmousecapture&&g.setCapture();b.isiframe&&!f.hasmousecapture&&(b.saved.csspointerevents=b.doc.css("pointer-events"),b.css(b.doc,{"pointer-events":"none"}));return b.cancelEvent(d)}};b.onmouseup=function(d){if(b.rail.drag&&(f.hasmousecapture&&document.releaseCapture(),b.isiframe&&!f.hasmousecapture&&b.doc.css("pointer-events",b.saved.csspointerevents),1==b.rail.drag.pt))return b.rail.drag=!1,b.cancelEvent(d)};b.onmousemove=function(d){if(b.rail.drag&&
1==b.rail.drag.pt){if(f.ischrome&&0==d.which)return b.onmouseup(d);b.cursorfreezed=!0;if(b.rail.drag.hr){b.scroll.x=b.rail.drag.sx+(d.clientX-b.rail.drag.x);0>b.scroll.x&&(b.scroll.x=0);var c=b.scrollvaluemaxw;b.scroll.x>c&&(b.scroll.x=c)}else b.scroll.y=b.rail.drag.sy+(d.clientY-b.rail.drag.y),0>b.scroll.y&&(b.scroll.y=0),c=b.scrollvaluemax,b.scroll.y>c&&(b.scroll.y=c);b.synched("mousemove",function(){b.rail.drag&&1==b.rail.drag.pt&&(b.showCursor(),b.rail.drag.hr?b.doScrollLeft(Math.round(b.scroll.x*
b.scrollratio.x),b.opt.cursordragspeed):b.doScrollTop(Math.round(b.scroll.y*b.scrollratio.y),b.opt.cursordragspeed))});return b.cancelEvent(d)}};if(f.cantouch||b.opt.touchbehavior)b.onpreventclick=function(d){if(b.preventclick)return b.preventclick.tg.onclick=b.preventclick.click,b.preventclick=!1,b.cancelEvent(d)},b.bind(b.win,"mousedown",b.ontouchstart),b.onclick=f.isios?!1:function(d){return b.lastmouseup?(b.lastmouseup=!1,b.cancelEvent(d)):!0},b.opt.grabcursorenabled&&f.cursorgrabvalue&&(b.css(b.ispage?
b.doc:b.win,{cursor:f.cursorgrabvalue}),b.css(b.rail,{cursor:f.cursorgrabvalue}));else{var r=function(d){if(b.selectiondrag){if(d){var c=b.win.outerHeight();d=d.pageY-b.selectiondrag.top;0<d&&d<c&&(d=0);d>=c&&(d-=c);b.selectiondrag.df=d}0!=b.selectiondrag.df&&(b.doScrollBy(2*-Math.floor(b.selectiondrag.df/6)),b.debounced("doselectionscroll",function(){r()},50))}};b.hasTextSelected="getSelection"in document?function(){return 0<document.getSelection().rangeCount}:"selection"in document?function(){return"None"!=
document.selection.type}:function(){return!1};b.onselectionstart=function(d){b.ispage||(b.selectiondrag=b.win.offset())};b.onselectionend=function(d){b.selectiondrag=!1};b.onselectiondrag=function(d){b.selectiondrag&&b.hasTextSelected()&&b.debounced("selectionscroll",function(){r(d)},250)}}f.hasmstouch&&(b.css(b.rail,{"-ms-touch-action":"none"}),b.css(b.cursor,{"-ms-touch-action":"none"}),b.bind(b.win,"MSPointerDown",b.ontouchstart),b.bind(document,"MSPointerUp",b.ontouchend),b.bind(document,"MSPointerMove",
b.ontouchmove),b.bind(b.cursor,"MSGestureHold",function(b){b.preventDefault()}),b.bind(b.cursor,"contextmenu",function(b){b.preventDefault()}));this.istouchcapable&&(b.bind(b.win,"touchstart",b.ontouchstart),b.bind(document,"touchend",b.ontouchend),b.bind(document,"touchcancel",b.ontouchend),b.bind(document,"touchmove",b.ontouchmove));b.bind(b.cursor,"mousedown",b.onmousedown);b.bind(b.cursor,"mouseup",b.onmouseup);b.railh&&(b.bind(b.cursorh,"mousedown",function(d){b.onmousedown(d,!0)}),b.bind(b.cursorh,
"mouseup",function(d){if(!(b.rail.drag&&2==b.rail.drag.pt))return b.rail.drag=!1,b.hasmoving=!1,b.hideCursor(),f.hasmousecapture&&document.releaseCapture(),b.cancelEvent(d)}));if(b.opt.cursordragontouch||!f.cantouch&&!b.opt.touchbehavior)b.rail.css({cursor:"default"}),b.railh&&b.railh.css({cursor:"default"}),b.jqbind(b.rail,"mouseenter",function(){b.canshowonmouseevent&&b.showCursor();b.rail.active=!0}),b.jqbind(b.rail,"mouseleave",function(){b.rail.active=!1;b.rail.drag||b.hideCursor()}),b.opt.sensitiverail&&
(b.bind(b.rail,"click",function(d){b.doRailClick(d,!1,!1)}),b.bind(b.rail,"dblclick",function(d){b.doRailClick(d,!0,!1)}),b.bind(b.cursor,"click",function(d){b.cancelEvent(d)}),b.bind(b.cursor,"dblclick",function(d){b.cancelEvent(d)})),b.railh&&(b.jqbind(b.railh,"mouseenter",function(){b.canshowonmouseevent&&b.showCursor();b.rail.active=!0}),b.jqbind(b.railh,"mouseleave",function(){b.rail.active=!1;b.rail.drag||b.hideCursor()}),b.opt.sensitiverail&&(b.bind(b.railh,"click",function(d){b.doRailClick(d,
!1,!0)}),b.bind(b.railh,"dblclick",function(d){b.doRailClick(d,!0,!0)}),b.bind(b.cursorh,"click",function(d){b.cancelEvent(d)}),b.bind(b.cursorh,"dblclick",function(d){b.cancelEvent(d)})));!f.cantouch&&!b.opt.touchbehavior?(b.bind(f.hasmousecapture?b.win:document,"mouseup",b.onmouseup),b.bind(document,"mousemove",b.onmousemove),b.onclick&&b.bind(document,"click",b.onclick),!b.ispage&&b.opt.enablescrollonselection&&(b.bind(b.win[0],"mousedown",b.onselectionstart),b.bind(document,"mouseup",b.onselectionend),
b.bind(b.cursor,"mouseup",b.onselectionend),b.cursorh&&b.bind(b.cursorh,"mouseup",b.onselectionend),b.bind(document,"mousemove",b.onselectiondrag)),b.zoom&&(b.jqbind(b.zoom,"mouseenter",function(){b.canshowonmouseevent&&b.showCursor();b.rail.active=!0}),b.jqbind(b.zoom,"mouseleave",function(){b.rail.active=!1;b.rail.drag||b.hideCursor()}))):(b.bind(f.hasmousecapture?b.win:document,"mouseup",b.ontouchend),b.bind(document,"mousemove",b.ontouchmove),b.onclick&&b.bind(document,"click",b.onclick),b.opt.cursordragontouch&&
(b.bind(b.cursor,"mousedown",b.onmousedown),b.bind(b.cursor,"mousemove",b.onmousemove),b.cursorh&&b.bind(b.cursorh,"mousedown",b.onmousedown),b.cursorh&&b.bind(b.cursorh,"mousemove",b.onmousemove)));b.opt.enablemousewheel&&(b.isiframe||b.bind(f.isie&&b.ispage?document:b.docscroll,"mousewheel",b.onmousewheel),b.bind(b.rail,"mousewheel",b.onmousewheel),b.railh&&b.bind(b.railh,"mousewheel",b.onmousewheelhr));!b.ispage&&(!f.cantouch&&!/HTML|BODY/.test(b.win[0].nodeName))&&(b.win.attr("tabindex")||b.win.attr({tabindex:J++}),
b.jqbind(b.win,"focus",function(d){y=b.getTarget(d).id||!0;b.hasfocus=!0;b.canshowonmouseevent&&b.noticeCursor()}),b.jqbind(b.win,"blur",function(d){y=!1;b.hasfocus=!1}),b.jqbind(b.win,"mouseenter",function(d){D=b.getTarget(d).id||!0;b.hasmousefocus=!0;b.canshowonmouseevent&&b.noticeCursor()}),b.jqbind(b.win,"mouseleave",function(){D=!1;b.hasmousefocus=!1}))}b.onkeypress=function(d){if(b.locked&&0==b.page.maxh)return!0;d=d?d:window.e;var c=b.getTarget(d);if(c&&/INPUT|TEXTAREA|SELECT|OPTION/.test(c.nodeName)&&
(!c.getAttribute("type")&&!c.type||!/submit|button|cancel/i.tp))return!0;if(b.hasfocus||b.hasmousefocus&&!y||b.ispage&&!y&&!D){c=d.keyCode;if(b.locked&&27!=c)return b.cancelEvent(d);var g=d.ctrlKey||!1,p=d.shiftKey||!1,f=!1;switch(c){case 38:case 63233:b.doScrollBy(72);f=!0;break;case 40:case 63235:b.doScrollBy(-72);f=!0;break;case 37:case 63232:b.railh&&(g?b.doScrollLeft(0):b.doScrollLeftBy(72),f=!0);break;case 39:case 63234:b.railh&&(g?b.doScrollLeft(b.page.maxw):b.doScrollLeftBy(-72),f=!0);break;
case 33:case 63276:b.doScrollBy(b.view.h);f=!0;break;case 34:case 63277:b.doScrollBy(-b.view.h);f=!0;break;case 36:case 63273:b.railh&&g?b.doScrollPos(0,0):b.doScrollTo(0);f=!0;break;case 35:case 63275:b.railh&&g?b.doScrollPos(b.page.maxw,b.page.maxh):b.doScrollTo(b.page.maxh);f=!0;break;case 32:b.opt.spacebarenabled&&(p?b.doScrollBy(b.view.h):b.doScrollBy(-b.view.h),f=!0);break;case 27:b.zoomactive&&(b.doZoom(),f=!0)}if(f)return b.cancelEvent(d)}};b.opt.enablekeyboard&&b.bind(document,f.isopera&&
!f.isopera12?"keypress":"keydown",b.onkeypress);b.bind(window,"resize",b.lazyResize);b.bind(window,"orientationchange",b.lazyResize);b.bind(window,"load",b.lazyResize);if(f.ischrome&&!b.ispage&&!b.haswrapper){var t=b.win.attr("style"),g=parseFloat(b.win.css("width"))+1;b.win.css("width",g);b.synched("chromefix",function(){b.win.attr("style",t)})}b.onAttributeChange=function(d){b.lazyResize(250)};!b.ispage&&!b.haswrapper&&(!1!==z?(b.observer=new z(function(d){d.forEach(b.onAttributeChange)}),b.observer.observe(b.win[0],
{childList:!0,characterData:!1,attributes:!0,subtree:!1}),b.observerremover=new z(function(d){d.forEach(function(d){if(0<d.removedNodes.length)for(var c in d.removedNodes)if(d.removedNodes[c]==b.win[0])return b.remove()})}),b.observerremover.observe(b.win[0].parentNode,{childList:!0,characterData:!1,attributes:!1,subtree:!1})):(b.bind(b.win,f.isie&&!f.isie9?"propertychange":"DOMAttrModified",b.onAttributeChange),f.isie9&&b.win[0].attachEvent("onpropertychange",b.onAttributeChange),b.bind(b.win,"DOMNodeRemoved",
function(d){d.target==b.win[0]&&b.remove()})));!b.ispage&&b.opt.boxzoom&&b.bind(window,"resize",b.resizeZoom);b.istextarea&&b.bind(b.win,"mouseup",b.lazyResize);b.checkrtlmode=!0;b.lazyResize(30)}if("IFRAME"==this.doc[0].nodeName){var I=function(d){b.iframexd=!1;try{var c="contentDocument"in this?this.contentDocument:this.contentWindow.document}catch(g){b.iframexd=!0,c=!1}if(b.iframexd)return"console"in window&&console.log("NiceScroll error: policy restriced iframe"),!0;b.forcescreen=!0;b.isiframe&&
(b.iframe={doc:e(c),html:b.doc.contents().find("html")[0],body:b.doc.contents().find("body")[0]},b.getContentSize=function(){return{w:Math.max(b.iframe.html.scrollWidth,b.iframe.body.scrollWidth),h:Math.max(b.iframe.html.scrollHeight,b.iframe.body.scrollHeight)}},b.docscroll=e(b.iframe.body));!f.isios&&(b.opt.iframeautoresize&&!b.isiframe)&&(b.win.scrollTop(0),b.doc.height(""),d=Math.max(c.getElementsByTagName("html")[0].scrollHeight,c.body.scrollHeight),b.doc.height(d));b.lazyResize(30);f.isie7&&
b.css(e(b.iframe.html),{"overflow-y":"hidden"});b.css(e(b.iframe.body),{"overflow-y":"hidden"});"contentWindow"in this?b.bind(this.contentWindow,"scroll",b.onscroll):b.bind(c,"scroll",b.onscroll);b.opt.enablemousewheel&&b.bind(c,"mousewheel",b.onmousewheel);b.opt.enablekeyboard&&b.bind(c,f.isopera?"keypress":"keydown",b.onkeypress);if(f.cantouch||b.opt.touchbehavior)b.bind(c,"mousedown",b.onmousedown),b.bind(c,"mousemove",function(d){b.onmousemove(d,!0)}),b.opt.grabcursorenabled&&f.cursorgrabvalue&&
b.css(e(c.body),{cursor:f.cursorgrabvalue});b.bind(c,"mouseup",b.onmouseup);b.zoom&&(b.opt.dblclickzoom&&b.bind(c,"dblclick",b.doZoom),b.ongesturezoom&&b.bind(c,"gestureend",b.ongesturezoom))};this.doc[0].readyState&&"complete"==this.doc[0].readyState&&setTimeout(function(){I.call(b.doc[0],!1)},500);b.bind(this.doc,"load",I)}};this.showCursor=function(d,c){b.cursortimeout&&(clearTimeout(b.cursortimeout),b.cursortimeout=0);if(b.rail){b.autohidedom&&(b.autohidedom.stop().css({opacity:b.opt.cursoropacitymax}),
b.cursoractive=!0);if(!b.rail.drag||1!=b.rail.drag.pt)"undefined"!=typeof d&&!1!==d&&(b.scroll.y=Math.round(1*d/b.scrollratio.y)),"undefined"!=typeof c&&(b.scroll.x=Math.round(1*c/b.scrollratio.x));b.cursor.css({height:b.cursorheight,top:b.scroll.y});b.cursorh&&(!b.rail.align&&b.rail.visibility?b.cursorh.css({width:b.cursorwidth,left:b.scroll.x+b.rail.width}):b.cursorh.css({width:b.cursorwidth,left:b.scroll.x}),b.cursoractive=!0);b.zoom&&b.zoom.stop().css({opacity:b.opt.cursoropacitymax})}};this.hideCursor=
function(d){!b.cursortimeout&&(b.rail&&b.autohidedom)&&(b.cursortimeout=setTimeout(function(){if(!b.rail.active||!b.showonmouseevent)b.autohidedom.stop().animate({opacity:b.opt.cursoropacitymin}),b.zoom&&b.zoom.stop().animate({opacity:b.opt.cursoropacitymin}),b.cursoractive=!1;b.cursortimeout=0},d||b.opt.hidecursordelay))};this.noticeCursor=function(d,c,g){b.showCursor(c,g);b.rail.active||b.hideCursor(d)};this.getContentSize=b.ispage?function(){return{w:Math.max(document.body.scrollWidth,document.documentElement.scrollWidth),
h:Math.max(document.body.scrollHeight,document.documentElement.scrollHeight)}}:b.haswrapper?function(){return{w:b.doc.outerWidth()+parseInt(b.win.css("paddingLeft"))+parseInt(b.win.css("paddingRight")),h:b.doc.outerHeight()+parseInt(b.win.css("paddingTop"))+parseInt(b.win.css("paddingBottom"))}}:function(){return{w:b.docscroll[0].scrollWidth,h:b.docscroll[0].scrollHeight}};this.onResize=function(d,c){if(!b.win)return!1;if(!b.haswrapper&&!b.ispage){if("none"==b.win.css("display"))return b.visibility&&
b.hideRail().hideRailHr(),!1;!b.hidden&&!b.visibility&&b.showRail().showRailHr()}var g=b.page.maxh,f=b.page.maxw,e=b.view.w;b.view={w:b.ispage?b.win.width():parseInt(b.win[0].clientWidth),h:b.ispage?b.win.height():parseInt(b.win[0].clientHeight)};b.page=c?c:b.getContentSize();b.page.maxh=Math.max(0,b.page.h-b.view.h);b.page.maxw=Math.max(0,b.page.w-b.view.w);if(b.page.maxh==g&&b.page.maxw==f&&b.view.w==e){if(b.ispage)return b;g=b.win.offset();if(b.lastposition&&(f=b.lastposition,f.top==g.top&&f.left==
g.left))return b;b.lastposition=g}0==b.page.maxh?(b.hideRail(),b.scrollvaluemax=0,b.scroll.y=0,b.scrollratio.y=0,b.cursorheight=0,b.setScrollTop(0),b.rail.scrollable=!1):b.rail.scrollable=!0;0==b.page.maxw?(b.hideRailHr(),b.scrollvaluemaxw=0,b.scroll.x=0,b.scrollratio.x=0,b.cursorwidth=0,b.setScrollLeft(0),b.railh.scrollable=!1):b.railh.scrollable=!0;b.locked=0==b.page.maxh&&0==b.page.maxw;if(b.locked)return b.ispage||b.updateScrollBar(b.view),!1;!b.hidden&&!b.visibility?b.showRail().showRailHr():
!b.hidden&&!b.railh.visibility&&b.showRailHr();b.istextarea&&(b.win.css("resize")&&"none"!=b.win.css("resize"))&&(b.view.h-=20);b.cursorheight=Math.min(b.view.h,Math.round(b.view.h*(b.view.h/b.page.h)));b.cursorheight=b.opt.cursorfixedheight?b.opt.cursorfixedheight:Math.max(b.opt.cursorminheight,b.cursorheight);b.cursorwidth=Math.min(b.view.w,Math.round(b.view.w*(b.view.w/b.page.w)));b.cursorwidth=b.opt.cursorfixedheight?b.opt.cursorfixedheight:Math.max(b.opt.cursorminheight,b.cursorwidth);b.scrollvaluemax=
b.view.h-b.cursorheight-b.cursor.hborder;b.railh&&(b.railh.width=0<b.page.maxh?b.view.w-b.rail.width:b.view.w,b.scrollvaluemaxw=b.railh.width-b.cursorwidth-b.cursorh.wborder);b.checkrtlmode&&b.railh&&(b.checkrtlmode=!1,b.opt.rtlmode&&0==b.scroll.x&&b.setScrollLeft(b.page.maxw));b.ispage||b.updateScrollBar(b.view);b.scrollratio={x:b.page.maxw/b.scrollvaluemaxw,y:b.page.maxh/b.scrollvaluemax};b.getScrollTop()>b.page.maxh?b.doScrollTop(b.page.maxh):(b.scroll.y=Math.round(b.getScrollTop()*(1/b.scrollratio.y)),
b.scroll.x=Math.round(b.getScrollLeft()*(1/b.scrollratio.x)),b.cursoractive&&b.noticeCursor());b.scroll.y&&0==b.getScrollTop()&&b.doScrollTo(Math.floor(b.scroll.y*b.scrollratio.y));return b};this.resize=b.onResize;this.lazyResize=function(d){d=isNaN(d)?30:d;b.delayed("resize",b.resize,d);return b};this._bind=function(d,c,g,f){b.events.push({e:d,n:c,f:g,b:f,q:!1});d.addEventListener?d.addEventListener(c,g,f||!1):d.attachEvent?d.attachEvent("on"+c,g):d["on"+c]=g};this.jqbind=function(d,c,g){b.events.push({e:d,
n:c,f:g,q:!0});e(d).bind(c,g)};this.bind=function(d,c,g,e){var h="jquery"in d?d[0]:d;"mousewheel"==c?"onwheel"in b.win?b._bind(h,"wheel",g,e||!1):(d="undefined"!=typeof document.onmousewheel?"mousewheel":"DOMMouseScroll",n(h,d,g,e||!1),"DOMMouseScroll"==d&&n(h,"MozMousePixelScroll",g,e||!1)):h.addEventListener?(f.cantouch&&/mouseup|mousedown|mousemove/.test(c)&&b._bind(h,"mousedown"==c?"touchstart":"mouseup"==c?"touchend":"touchmove",function(b){if(b.touches){if(2>b.touches.length){var d=b.touches.length?
b.touches[0]:b;d.original=b;g.call(this,d)}}else b.changedTouches&&(d=b.changedTouches[0],d.original=b,g.call(this,d))},e||!1),b._bind(h,c,g,e||!1),f.cantouch&&"mouseup"==c&&b._bind(h,"touchcancel",g,e||!1)):b._bind(h,c,function(d){if((d=d||window.event||!1)&&d.srcElement)d.target=d.srcElement;"pageY"in d||(d.pageX=d.clientX+document.documentElement.scrollLeft,d.pageY=d.clientY+document.documentElement.scrollTop);return!1===g.call(h,d)||!1===e?b.cancelEvent(d):!0})};this._unbind=function(b,c,g,f){b.removeEventListener?
b.removeEventListener(c,g,f):b.detachEvent?b.detachEvent("on"+c,g):b["on"+c]=!1};this.unbindAll=function(){for(var d=0;d<b.events.length;d++){var c=b.events[d];c.q?c.e.unbind(c.n,c.f):b._unbind(c.e,c.n,c.f,c.b)}};this.cancelEvent=function(b){b=b.original?b.original:b?b:window.event||!1;if(!b)return!1;b.preventDefault&&b.preventDefault();b.stopPropagation&&b.stopPropagation();b.preventManipulation&&b.preventManipulation();b.cancelBubble=!0;b.cancel=!0;return b.returnValue=!1};this.stopPropagation=
function(b){b=b.original?b.original:b?b:window.event||!1;if(!b)return!1;if(b.stopPropagation)return b.stopPropagation();b.cancelBubble&&(b.cancelBubble=!0);return!1};this.showRail=function(){if(0!=b.page.maxh&&(b.ispage||"none"!=b.win.css("display")))b.visibility=!0,b.rail.visibility=!0,b.rail.css("display","block");return b};this.showRailHr=function(){if(!b.railh)return b;if(0!=b.page.maxw&&(b.ispage||"none"!=b.win.css("display")))b.railh.visibility=!0,b.railh.css("display","block");return b};this.hideRail=
function(){b.visibility=!1;b.rail.visibility=!1;b.rail.css("display","none");return b};this.hideRailHr=function(){if(!b.railh)return b;b.railh.visibility=!1;b.railh.css("display","none");return b};this.show=function(){b.hidden=!1;b.locked=!1;return b.showRail().showRailHr()};this.hide=function(){b.hidden=!0;b.locked=!0;return b.hideRail().hideRailHr()};this.toggle=function(){return b.hidden?b.show():b.hide()};this.remove=function(){b.stop();b.cursortimeout&&clearTimeout(b.cursortimeout);b.doZoomOut();
b.unbindAll();!1!==b.observer&&b.observer.disconnect();!1!==b.observerremover&&b.observerremover.disconnect();b.events=[];b.cursor&&(b.cursor.remove(),b.cursor=null);b.cursorh&&(b.cursorh.remove(),b.cursorh=null);b.rail&&(b.rail.remove(),b.rail=null);b.railh&&(b.railh.remove(),b.railh=null);b.zoom&&(b.zoom.remove(),b.zoom=null);for(var d=0;d<b.saved.css.length;d++){var c=b.saved.css[d];c[0].css(c[1],"undefined"==typeof c[2]?"":c[2])}b.saved=!1;b.me.data("__nicescroll","");b.me=null;b.doc=null;b.docscroll=
null;b.win=null;return b};this.scrollstart=function(d){this.onscrollstart=d;return b};this.scrollend=function(d){this.onscrollend=d;return b};this.scrollcancel=function(d){this.onscrollcancel=d;return b};this.zoomin=function(d){this.onzoomin=d;return b};this.zoomout=function(d){this.onzoomout=d;return b};this.isScrollable=function(b){b=b.target?b.target:b;if("OPTION"==b.nodeName)return!0;for(;b&&1==b.nodeType&&!/BODY|HTML/.test(b.nodeName);){var c=e(b),c=c.css("overflowY")||c.css("overflowX")||c.css("overflow")||
"";if(/scroll|auto/.test(c))return b.clientHeight!=b.scrollHeight;b=b.parentNode?b.parentNode:!1}return!1};this.getViewport=function(b){for(b=b&&b.parentNode?b.parentNode:!1;b&&1==b.nodeType&&!/BODY|HTML/.test(b.nodeName);){var c=e(b),g=c.css("overflowY")||c.css("overflowX")||c.css("overflow")||"";if(/scroll|auto/.test(g)&&b.clientHeight!=b.scrollHeight||0<c.getNiceScroll().length)return c;b=b.parentNode?b.parentNode:!1}return!1};this.onmousewheel=function(d){if(b.locked)return!0;if(b.rail.drag)return b.cancelEvent(d);
if(!b.rail.scrollable)return b.railh&&b.railh.scrollable?b.onmousewheelhr(d):!0;var c=+new Date,g=!1;b.opt.preservenativescrolling&&b.checkarea+600<c&&(b.nativescrollingarea=b.isScrollable(d),g=!0);b.checkarea=c;if(b.nativescrollingarea)return!0;if(d=t(d,!1,g))b.checkarea=0;return d};this.onmousewheelhr=function(d){if(b.locked||!b.railh.scrollable)return!0;if(b.rail.drag)return b.cancelEvent(d);var c=+new Date,g=!1;b.opt.preservenativescrolling&&b.checkarea+600<c&&(b.nativescrollingarea=b.isScrollable(d),
g=!0);b.checkarea=c;return b.nativescrollingarea?!0:b.locked?b.cancelEvent(d):t(d,!0,g)};this.stop=function(){b.cancelScroll();b.scrollmon&&b.scrollmon.stop();b.cursorfreezed=!1;b.scroll.y=Math.round(b.getScrollTop()*(1/b.scrollratio.y));b.noticeCursor();return b};this.getTransitionSpeed=function(c){var f=Math.round(10*b.opt.scrollspeed);c=Math.min(f,Math.round(c/20*b.opt.scrollspeed));return 20<c?c:0};b.opt.smoothscroll?b.ishwscroll&&f.hastransition&&b.opt.usetransition?(this.prepareTransition=function(c,
e){var g=e?20<c?c:0:b.getTransitionSpeed(c),h=g?f.prefixstyle+"transform "+g+"ms ease-out":"";if(!b.lasttransitionstyle||b.lasttransitionstyle!=h)b.lasttransitionstyle=h,b.doc.css(f.transitionstyle,h);return g},this.doScrollLeft=function(c,f){var g=b.scrollrunning?b.newscrolly:b.getScrollTop();b.doScrollPos(c,g,f)},this.doScrollTop=function(c,f){var g=b.scrollrunning?b.newscrollx:b.getScrollLeft();b.doScrollPos(g,c,f)},this.doScrollPos=function(c,e,g){var h=b.getScrollTop(),l=b.getScrollLeft();(0>
(b.newscrolly-h)*(e-h)||0>(b.newscrollx-l)*(c-l))&&b.cancelScroll();!1==b.opt.bouncescroll&&(0>e?e=0:e>b.page.maxh&&(e=b.page.maxh),0>c?c=0:c>b.page.maxw&&(c=b.page.maxw));if(b.scrollrunning&&c==b.newscrollx&&e==b.newscrolly)return!1;b.newscrolly=e;b.newscrollx=c;b.newscrollspeed=g||!1;if(b.timer)return!1;b.timer=setTimeout(function(){var g=b.getScrollTop(),h=b.getScrollLeft(),l,k;l=c-h;k=e-g;l=Math.round(Math.sqrt(Math.pow(l,2)+Math.pow(k,2)));l=b.newscrollspeed&&1<b.newscrollspeed?b.newscrollspeed:
b.getTransitionSpeed(l);b.newscrollspeed&&1>=b.newscrollspeed&&(l*=b.newscrollspeed);b.prepareTransition(l,!0);b.timerscroll&&b.timerscroll.tm&&clearInterval(b.timerscroll.tm);0<l&&(!b.scrollrunning&&b.onscrollstart&&b.onscrollstart.call(b,{type:"scrollstart",current:{x:h,y:g},request:{x:c,y:e},end:{x:b.newscrollx,y:b.newscrolly},speed:l}),f.transitionend?b.scrollendtrapped||(b.scrollendtrapped=!0,b.bind(b.doc,f.transitionend,b.onScrollEnd,!1)):(b.scrollendtrapped&&clearTimeout(b.scrollendtrapped),
b.scrollendtrapped=setTimeout(b.onScrollEnd,l)),b.timerscroll={bz:new BezierClass(g,b.newscrolly,l,0,0,0.58,1),bh:new BezierClass(h,b.newscrollx,l,0,0,0.58,1)},b.cursorfreezed||(b.timerscroll.tm=setInterval(function(){b.showCursor(b.getScrollTop(),b.getScrollLeft())},60)));b.synched("doScroll-set",function(){b.timer=0;b.scrollendtrapped&&(b.scrollrunning=!0);b.setScrollTop(b.newscrolly);b.setScrollLeft(b.newscrollx);if(!b.scrollendtrapped)b.onScrollEnd()})},50)},this.cancelScroll=function(){if(!b.scrollendtrapped)return!0;
var c=b.getScrollTop(),e=b.getScrollLeft();b.scrollrunning=!1;f.transitionend||clearTimeout(f.transitionend);b.scrollendtrapped=!1;b._unbind(b.doc,f.transitionend,b.onScrollEnd);b.prepareTransition(0);b.setScrollTop(c);b.railh&&b.setScrollLeft(e);b.timerscroll&&b.timerscroll.tm&&clearInterval(b.timerscroll.tm);b.timerscroll=!1;b.cursorfreezed=!1;b.showCursor(c,e);return b},this.onScrollEnd=function(){b.scrollendtrapped&&b._unbind(b.doc,f.transitionend,b.onScrollEnd);b.scrollendtrapped=!1;b.prepareTransition(0);
b.timerscroll&&b.timerscroll.tm&&clearInterval(b.timerscroll.tm);b.timerscroll=!1;var c=b.getScrollTop(),e=b.getScrollLeft();b.setScrollTop(c);b.railh&&b.setScrollLeft(e);b.noticeCursor(!1,c,e);b.cursorfreezed=!1;0>c?c=0:c>b.page.maxh&&(c=b.page.maxh);0>e?e=0:e>b.page.maxw&&(e=b.page.maxw);if(c!=b.newscrolly||e!=b.newscrollx)return b.doScrollPos(e,c,b.opt.snapbackspeed);b.onscrollend&&b.scrollrunning&&b.onscrollend.call(b,{type:"scrollend",current:{x:e,y:c},end:{x:b.newscrollx,y:b.newscrolly}});b.scrollrunning=
!1}):(this.doScrollLeft=function(c,f){var g=b.scrollrunning?b.newscrolly:b.getScrollTop();b.doScrollPos(c,g,f)},this.doScrollTop=function(c,f){var g=b.scrollrunning?b.newscrollx:b.getScrollLeft();b.doScrollPos(g,c,f)},this.doScrollPos=function(c,f,g){function e(){if(b.cancelAnimationFrame)return!0;b.scrollrunning=!0;if(r=1-r)return b.timer=v(e)||1;var c=0,d=sy=b.getScrollTop();if(b.dst.ay){var d=b.bzscroll?b.dst.py+b.bzscroll.getNow()*b.dst.ay:b.newscrolly,g=d-sy;if(0>g&&d<b.newscrolly||0<g&&d>b.newscrolly)d=
b.newscrolly;b.setScrollTop(d);d==b.newscrolly&&(c=1)}else c=1;var f=sx=b.getScrollLeft();if(b.dst.ax){f=b.bzscroll?b.dst.px+b.bzscroll.getNow()*b.dst.ax:b.newscrollx;g=f-sx;if(0>g&&f<b.newscrollx||0<g&&f>b.newscrollx)f=b.newscrollx;b.setScrollLeft(f);f==b.newscrollx&&(c+=1)}else c+=1;2==c?(b.timer=0,b.cursorfreezed=!1,b.bzscroll=!1,b.scrollrunning=!1,0>d?d=0:d>b.page.maxh&&(d=b.page.maxh),0>f?f=0:f>b.page.maxw&&(f=b.page.maxw),f!=b.newscrollx||d!=b.newscrolly?b.doScrollPos(f,d):b.onscrollend&&b.onscrollend.call(b,
{type:"scrollend",current:{x:sx,y:sy},end:{x:b.newscrollx,y:b.newscrolly}})):b.timer=v(e)||1}f="undefined"==typeof f||!1===f?b.getScrollTop(!0):f;if(b.timer&&b.newscrolly==f&&b.newscrollx==c)return!0;b.timer&&w(b.timer);b.timer=0;var h=b.getScrollTop(),l=b.getScrollLeft();(0>(b.newscrolly-h)*(f-h)||0>(b.newscrollx-l)*(c-l))&&b.cancelScroll();b.newscrolly=f;b.newscrollx=c;if(!b.bouncescroll||!b.rail.visibility)0>b.newscrolly?b.newscrolly=0:b.newscrolly>b.page.maxh&&(b.newscrolly=b.page.maxh);if(!b.bouncescroll||
!b.railh.visibility)0>b.newscrollx?b.newscrollx=0:b.newscrollx>b.page.maxw&&(b.newscrollx=b.page.maxw);b.dst={};b.dst.x=c-l;b.dst.y=f-h;b.dst.px=l;b.dst.py=h;var k=Math.round(Math.sqrt(Math.pow(b.dst.x,2)+Math.pow(b.dst.y,2)));b.dst.ax=b.dst.x/k;b.dst.ay=b.dst.y/k;var n=0,q=k;0==b.dst.x?(n=h,q=f,b.dst.ay=1,b.dst.py=0):0==b.dst.y&&(n=l,q=c,b.dst.ax=1,b.dst.px=0);k=b.getTransitionSpeed(k);g&&1>=g&&(k*=g);b.bzscroll=0<k?b.bzscroll?b.bzscroll.update(q,k):new BezierClass(n,q,k,0,1,0,1):!1;if(!b.timer){(h==
b.page.maxh&&f>=b.page.maxh||l==b.page.maxw&&c>=b.page.maxw)&&b.checkContentSize();var r=1;b.cancelAnimationFrame=!1;b.timer=1;b.onscrollstart&&!b.scrollrunning&&b.onscrollstart.call(b,{type:"scrollstart",current:{x:l,y:h},request:{x:c,y:f},end:{x:b.newscrollx,y:b.newscrolly},speed:k});e();(h==b.page.maxh&&f>=h||l==b.page.maxw&&c>=l)&&b.checkContentSize();b.noticeCursor()}},this.cancelScroll=function(){b.timer&&w(b.timer);b.timer=0;b.bzscroll=!1;b.scrollrunning=!1;return b}):(this.doScrollLeft=function(c,
f){var g=b.getScrollTop();b.doScrollPos(c,g,f)},this.doScrollTop=function(c,f){var g=b.getScrollLeft();b.doScrollPos(g,c,f)},this.doScrollPos=function(c,f,g){var e=c>b.page.maxw?b.page.maxw:c;0>e&&(e=0);var h=f>b.page.maxh?b.page.maxh:f;0>h&&(h=0);b.synched("scroll",function(){b.setScrollTop(h);b.setScrollLeft(e)})},this.cancelScroll=function(){});this.doScrollBy=function(c,f){var g=0,g=f?Math.floor((b.scroll.y-c)*b.scrollratio.y):(b.timer?b.newscrolly:b.getScrollTop(!0))-c;if(b.bouncescroll){var e=
Math.round(b.view.h/2);g<-e?g=-e:g>b.page.maxh+e&&(g=b.page.maxh+e)}b.cursorfreezed=!1;py=b.getScrollTop(!0);if(0>g&&0>=py)return b.noticeCursor();if(g>b.page.maxh&&py>=b.page.maxh)return b.checkContentSize(),b.noticeCursor();b.doScrollTop(g)};this.doScrollLeftBy=function(c,f){var g=0,g=f?Math.floor((b.scroll.x-c)*b.scrollratio.x):(b.timer?b.newscrollx:b.getScrollLeft(!0))-c;if(b.bouncescroll){var e=Math.round(b.view.w/2);g<-e?g=-e:g>b.page.maxw+e&&(g=b.page.maxw+e)}b.cursorfreezed=!1;px=b.getScrollLeft(!0);
if(0>g&&0>=px||g>b.page.maxw&&px>=b.page.maxw)return b.noticeCursor();b.doScrollLeft(g)};this.doScrollTo=function(c,f){f&&Math.round(c*b.scrollratio.y);b.cursorfreezed=!1;b.doScrollTop(c)};this.checkContentSize=function(){var c=b.getContentSize();(c.h!=b.page.h||c.w!=b.page.w)&&b.resize(!1,c)};b.onscroll=function(c){b.rail.drag||b.cursorfreezed||b.synched("scroll",function(){b.scroll.y=Math.round(b.getScrollTop()*(1/b.scrollratio.y));b.railh&&(b.scroll.x=Math.round(b.getScrollLeft()*(1/b.scrollratio.x)));
b.noticeCursor()})};b.bind(b.docscroll,"scroll",b.onscroll);this.doZoomIn=function(c){if(!b.zoomactive){b.zoomactive=!0;b.zoomrestore={style:{}};var h="position top left zIndex backgroundColor marginTop marginBottom marginLeft marginRight".split(" "),g=b.win[0].style,l;for(l in h){var k=h[l];b.zoomrestore.style[k]="undefined"!=typeof g[k]?g[k]:""}b.zoomrestore.style.width=b.win.css("width");b.zoomrestore.style.height=b.win.css("height");b.zoomrestore.padding={w:b.win.outerWidth()-b.win.width(),h:b.win.outerHeight()-
b.win.height()};f.isios4&&(b.zoomrestore.scrollTop=e(window).scrollTop(),e(window).scrollTop(0));b.win.css({position:f.isios4?"absolute":"fixed",top:0,left:0,"z-index":x+100,margin:"0px"});h=b.win.css("backgroundColor");(""==h||/transparent|rgba\(0, 0, 0, 0\)|rgba\(0,0,0,0\)/.test(h))&&b.win.css("backgroundColor","#fff");b.rail.css({"z-index":x+101});b.zoom.css({"z-index":x+102});b.zoom.css("backgroundPosition","0px -18px");b.resizeZoom();b.onzoomin&&b.onzoomin.call(b);return b.cancelEvent(c)}};this.doZoomOut=
function(c){if(b.zoomactive)return b.zoomactive=!1,b.win.css("margin",""),b.win.css(b.zoomrestore.style),f.isios4&&e(window).scrollTop(b.zoomrestore.scrollTop),b.rail.css({"z-index":b.zindex}),b.zoom.css({"z-index":b.zindex}),b.zoomrestore=!1,b.zoom.css("backgroundPosition","0px 0px"),b.onResize(),b.onzoomout&&b.onzoomout.call(b),b.cancelEvent(c)};this.doZoom=function(c){return b.zoomactive?b.doZoomOut(c):b.doZoomIn(c)};this.resizeZoom=function(){if(b.zoomactive){var c=b.getScrollTop();b.win.css({width:e(window).width()-
b.zoomrestore.padding.w+"px",height:e(window).height()-b.zoomrestore.padding.h+"px"});b.onResize();b.setScrollTop(Math.min(b.page.maxh,c))}};this.init();e.nicescroll.push(this)},H=function(e){var c=this;this.nc=e;this.steptime=this.lasttime=this.speedy=this.speedx=this.lasty=this.lastx=0;this.snapy=this.snapx=!1;this.demuly=this.demulx=0;this.lastscrolly=this.lastscrollx=-1;this.timer=this.chky=this.chkx=0;this.time=function(){return+new Date};this.reset=function(e,l){c.stop();var k=c.time();c.steptime=
0;c.lasttime=k;c.speedx=0;c.speedy=0;c.lastx=e;c.lasty=l;c.lastscrollx=-1;c.lastscrolly=-1};this.update=function(e,l){var k=c.time();c.steptime=k-c.lasttime;c.lasttime=k;var k=l-c.lasty,t=e-c.lastx,b=c.nc.getScrollTop(),q=c.nc.getScrollLeft(),b=b+k,q=q+t;c.snapx=0>q||q>c.nc.page.maxw;c.snapy=0>b||b>c.nc.page.maxh;c.speedx=t;c.speedy=k;c.lastx=e;c.lasty=l};this.stop=function(){c.nc.unsynched("domomentum2d");c.timer&&clearTimeout(c.timer);c.timer=0;c.lastscrollx=-1;c.lastscrolly=-1};this.doSnapy=function(e,
l){var k=!1;0>l?(l=0,k=!0):l>c.nc.page.maxh&&(l=c.nc.page.maxh,k=!0);0>e?(e=0,k=!0):e>c.nc.page.maxw&&(e=c.nc.page.maxw,k=!0);k&&c.nc.doScrollPos(e,l,c.nc.opt.snapbackspeed)};this.doMomentum=function(e){var l=c.time(),k=e?l+e:c.lasttime;e=c.nc.getScrollLeft();var t=c.nc.getScrollTop(),b=c.nc.page.maxh,q=c.nc.page.maxw;c.speedx=0<q?Math.min(60,c.speedx):0;c.speedy=0<b?Math.min(60,c.speedy):0;k=k&&50>=l-k;if(0>t||t>b||0>e||e>q)k=!1;e=c.speedx&&k?c.speedx:!1;if(c.speedy&&k&&c.speedy||e){var f=Math.max(16,
c.steptime);50<f&&(e=f/50,c.speedx*=e,c.speedy*=e,f=50);c.demulxy=0;c.lastscrollx=c.nc.getScrollLeft();c.chkx=c.lastscrollx;c.lastscrolly=c.nc.getScrollTop();c.chky=c.lastscrolly;var r=c.lastscrollx,u=c.lastscrolly,d=function(){var e=600<c.time()-l?0.04:0.02;if(c.speedx&&(r=Math.floor(c.lastscrollx-c.speedx*(1-c.demulxy)),c.lastscrollx=r,0>r||r>q))e=0.1;if(c.speedy&&(u=Math.floor(c.lastscrolly-c.speedy*(1-c.demulxy)),c.lastscrolly=u,0>u||u>b))e=0.1;c.demulxy=Math.min(1,c.demulxy+e);c.nc.synched("domomentum2d",
function(){c.speedx&&(c.nc.getScrollLeft()!=c.chkx&&c.stop(),c.chkx=r,c.nc.setScrollLeft(r));c.speedy&&(c.nc.getScrollTop()!=c.chky&&c.stop(),c.chky=u,c.nc.setScrollTop(u));c.timer||(c.nc.hideCursor(),c.doSnapy(r,u))});1>c.demulxy?c.timer=setTimeout(d,f):(c.stop(),c.nc.hideCursor(),c.doSnapy(r,u))};d()}else c.doSnapy(c.nc.getScrollLeft(),c.nc.getScrollTop())}},A=e.fn.scrollTop;e.cssHooks.pageYOffset={get:function(k,c,h){return(c=e.data(k,"__nicescroll")||!1)&&c.ishwscroll?c.getScrollTop():A.call(k)},
set:function(k,c){var h=e.data(k,"__nicescroll")||!1;h&&h.ishwscroll?h.setScrollTop(parseInt(c)):A.call(k,c);return this}};e.fn.scrollTop=function(k){if("undefined"==typeof k){var c=this[0]?e.data(this[0],"__nicescroll")||!1:!1;return c&&c.ishwscroll?c.getScrollTop():A.call(this)}return this.each(function(){var c=e.data(this,"__nicescroll")||!1;c&&c.ishwscroll?c.setScrollTop(parseInt(k)):A.call(e(this),k)})};var B=e.fn.scrollLeft;e.cssHooks.pageXOffset={get:function(k,c,h){return(c=e.data(k,"__nicescroll")||
!1)&&c.ishwscroll?c.getScrollLeft():B.call(k)},set:function(k,c){var h=e.data(k,"__nicescroll")||!1;h&&h.ishwscroll?h.setScrollLeft(parseInt(c)):B.call(k,c);return this}};e.fn.scrollLeft=function(k){if("undefined"==typeof k){var c=this[0]?e.data(this[0],"__nicescroll")||!1:!1;return c&&c.ishwscroll?c.getScrollLeft():B.call(this)}return this.each(function(){var c=e.data(this,"__nicescroll")||!1;c&&c.ishwscroll?c.setScrollLeft(parseInt(k)):B.call(e(this),k)})};var C=function(k){var c=this;this.length=
0;this.name="nicescrollarray";this.each=function(e){for(var h=0;h<c.length;h++)e.call(c[h]);return c};this.push=function(e){c[c.length]=e;c.length++};this.eq=function(e){return c[e]};if(k)for(a=0;a<k.length;a++){var h=e.data(k[a],"__nicescroll")||!1;h&&(this[this.length]=h,this.length++)}return this};(function(e,c,h){for(var l=0;l<c.length;l++)h(e,c[l])})(C.prototype,"show hide toggle onResize resize remove stop doScrollPos".split(" "),function(e,c){e[c]=function(){var e=arguments;return this.each(function(){this[c].apply(this,
e)})}});e.fn.getNiceScroll=function(k){return"undefined"==typeof k?new C(this):e.data(this[k],"__nicescroll")||!1};e.extend(e.expr[":"],{nicescroll:function(k){return e.data(k,"__nicescroll")?!0:!1}});e.fn.niceScroll=function(k,c){"undefined"==typeof c&&("object"==typeof k&&!("jquery"in k))&&(c=k,k=!1);var h=new C;"undefined"==typeof c&&(c={});k&&(c.doc=e(k),c.win=e(this));var l=!("doc"in c);!l&&!("win"in c)&&(c.win=e(this));this.each(function(){var k=e(this).data("__nicescroll")||!1;k||(c.doc=l?
e(this):c.doc,k=new N(c,e(this)),e(this).data("__nicescroll",k));h.push(k)});return 1==h.length?h[0]:h};window.NiceScroll={getjQuery:function(){return e}};e.nicescroll||(e.nicescroll=new C,e.nicescroll.options=F)})(jQuery);

/* -----------------------------------------------
/* Author : Vincent Garreau  - vincentgarreau.com
/* MIT license: http://opensource.org/licenses/MIT
/* Demo / Generator : vincentgarreau.com/particles.js
/* GitHub : github.com/VincentGarreau/particles.js
/* How to use? : Check the GitHub README
/* v2.0.0
/* ----------------------------------------------- */
function hexToRgb(e) {
    var a = /^#?([a-f\d])([a-f\d])([a-f\d])$/i;
    e = e.replace(a, function (e, a, t, i) {
        return a + a + t + t + i + i
    });
    var t = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(e);
    return t ? {r: parseInt(t[1], 16), g: parseInt(t[2], 16), b: parseInt(t[3], 16)} : null
}

function clamp(e, a, t) {
    return Math.min(Math.max(e, a), t)
}

function isInArray(e, a) {
    return a.indexOf(e) > -1
}

var pJS = function (e, a) {
    var t = document.querySelector("#" + e + " > .particles-js-canvas-el");
    this.pJS = {
        canvas: {el: t, w: t.offsetWidth, h: t.offsetHeight},
        particles: {
            number: {value: 400, density: {enable: !0, value_area: 800}},
            color: {value: "#fff"},
            shape: {
                type: "circle",
                stroke: {width: 0, color: "#ff0000"},
                polygon: {nb_sides: 5},
                image: {src: "", width: 100, height: 100}
            },
            opacity: {value: 1, random: !1, anim: {enable: !1, speed: 2, opacity_min: 0, sync: !1}},
            size: {value: 20, random: !1, anim: {enable: !1, speed: 20, size_min: 0, sync: !1}},
            line_linked: {enable: !0, distance: 100, color: "#fff", opacity: 1, width: 1},
            move: {
                enable: !0,
                speed: 2,
                direction: "none",
                random: !1,
                straight: !1,
                out_mode: "out",
                bounce: !1,
                attract: {enable: !1, rotateX: 3e3, rotateY: 3e3}
            },
            array: []
        },
        interactivity: {
            detect_on: "canvas",
            events: {onhover: {enable: !0, mode: "grab"}, onclick: {enable: !0, mode: "push"}, resize: !0},
            modes: {
                grab: {distance: 100, line_linked: {opacity: 1}},
                bubble: {distance: 200, size: 80, duration: .4},
                repulse: {distance: 200, duration: .4},
                push: {particles_nb: 4},
                remove: {particles_nb: 2}
            },
            mouse: {}
        },
        retina_detect: !1,
        fn: {interact: {}, modes: {}, vendors: {}},
        tmp: {}
    };
    var i = this.pJS;
    a && Object.deepExtend(i, a), i.tmp.obj = {
        size_value: i.particles.size.value,
        size_anim_speed: i.particles.size.anim.speed,
        move_speed: i.particles.move.speed,
        line_linked_distance: i.particles.line_linked.distance,
        line_linked_width: i.particles.line_linked.width,
        mode_grab_distance: i.interactivity.modes.grab.distance,
        mode_bubble_distance: i.interactivity.modes.bubble.distance,
        mode_bubble_size: i.interactivity.modes.bubble.size,
        mode_repulse_distance: i.interactivity.modes.repulse.distance
    }, i.fn.retinaInit = function () {
        i.retina_detect && window.devicePixelRatio > 1 ? (i.canvas.pxratio = window.devicePixelRatio, i.tmp.retina = !0) : (i.canvas.pxratio = 1, i.tmp.retina = !1), i.canvas.w = i.canvas.el.offsetWidth * i.canvas.pxratio, i.canvas.h = i.canvas.el.offsetHeight * i.canvas.pxratio, i.particles.size.value = i.tmp.obj.size_value * i.canvas.pxratio, i.particles.size.anim.speed = i.tmp.obj.size_anim_speed * i.canvas.pxratio, i.particles.move.speed = i.tmp.obj.move_speed * i.canvas.pxratio, i.particles.line_linked.distance = i.tmp.obj.line_linked_distance * i.canvas.pxratio, i.interactivity.modes.grab.distance = i.tmp.obj.mode_grab_distance * i.canvas.pxratio, i.interactivity.modes.bubble.distance = i.tmp.obj.mode_bubble_distance * i.canvas.pxratio, i.particles.line_linked.width = i.tmp.obj.line_linked_width * i.canvas.pxratio, i.interactivity.modes.bubble.size = i.tmp.obj.mode_bubble_size * i.canvas.pxratio, i.interactivity.modes.repulse.distance = i.tmp.obj.mode_repulse_distance * i.canvas.pxratio
    }, i.fn.canvasInit = function () {
        i.canvas.ctx = i.canvas.el.getContext("2d")
    }, i.fn.canvasSize = function () {
        i.canvas.el.width = i.canvas.w, i.canvas.el.height = i.canvas.h, i && i.interactivity.events.resize && window.addEventListener("resize", function () {
            i.canvas.w = i.canvas.el.offsetWidth, i.canvas.h = i.canvas.el.offsetHeight, i.tmp.retina && (i.canvas.w *= i.canvas.pxratio, i.canvas.h *= i.canvas.pxratio), i.canvas.el.width = i.canvas.w, i.canvas.el.height = i.canvas.h, i.particles.move.enable || (i.fn.particlesEmpty(), i.fn.particlesCreate(), i.fn.particlesDraw(), i.fn.vendors.densityAutoParticles()), i.fn.vendors.densityAutoParticles()
        })
    }, i.fn.canvasPaint = function () {
        i.canvas.ctx.fillRect(0, 0, i.canvas.w, i.canvas.h)
    }, i.fn.canvasClear = function () {
        i.canvas.ctx.clearRect(0, 0, i.canvas.w, i.canvas.h)
    }, i.fn.particle = function (e, a, t) {
        if (this.radius = (i.particles.size.random ? Math.random() : 1) * i.particles.size.value, i.particles.size.anim.enable && (this.size_status = !1, this.vs = i.particles.size.anim.speed / 100, i.particles.size.anim.sync || (this.vs = this.vs * Math.random())), this.x = t ? t.x : Math.random() * i.canvas.w, this.y = t ? t.y : Math.random() * i.canvas.h, this.x > i.canvas.w - 2 * this.radius ? this.x = this.x - this.radius : this.x < 2 * this.radius && (this.x = this.x + this.radius), this.y > i.canvas.h - 2 * this.radius ? this.y = this.y - this.radius : this.y < 2 * this.radius && (this.y = this.y + this.radius), i.particles.move.bounce && i.fn.vendors.checkOverlap(this, t), this.color = {}, "object" == typeof e.value) if (e.value instanceof Array) {
            var s = e.value[Math.floor(Math.random() * i.particles.color.value.length)];
            this.color.rgb = hexToRgb(s)
        } else void 0 != e.value.r && void 0 != e.value.g && void 0 != e.value.b && (this.color.rgb = {
            r: e.value.r,
            g: e.value.g,
            b: e.value.b
        }), void 0 != e.value.h && void 0 != e.value.s && void 0 != e.value.l && (this.color.hsl = {
            h: e.value.h,
            s: e.value.s,
            l: e.value.l
        }); else "random" == e.value ? this.color.rgb = {
            r: Math.floor(256 * Math.random()) + 0,
            g: Math.floor(256 * Math.random()) + 0,
            b: Math.floor(256 * Math.random()) + 0
        } : "string" == typeof e.value && (this.color = e, this.color.rgb = hexToRgb(this.color.value));
        this.opacity = (i.particles.opacity.random ? Math.random() : 1) * i.particles.opacity.value, i.particles.opacity.anim.enable && (this.opacity_status = !1, this.vo = i.particles.opacity.anim.speed / 100, i.particles.opacity.anim.sync || (this.vo = this.vo * Math.random()));
        var n = {};
        switch (i.particles.move.direction) {
            case"top":
                n = {x: 0, y: -1};
                break;
            case"top-right":
                n = {x: .5, y: -.5};
                break;
            case"right":
                n = {x: 1, y: -0};
                break;
            case"bottom-right":
                n = {x: .5, y: .5};
                break;
            case"bottom":
                n = {x: 0, y: 1};
                break;
            case"bottom-left":
                n = {x: -.5, y: 1};
                break;
            case"left":
                n = {x: -1, y: 0};
                break;
            case"top-left":
                n = {x: -.5, y: -.5};
                break;
            default:
                n = {x: 0, y: 0}
        }
        i.particles.move.straight ? (this.vx = n.x, this.vy = n.y, i.particles.move.random && (this.vx = this.vx * Math.random(), this.vy = this.vy * Math.random())) : (this.vx = n.x + Math.random() - .5, this.vy = n.y + Math.random() - .5), this.vx_i = this.vx, this.vy_i = this.vy;
        var r = i.particles.shape.type;
        if ("object" == typeof r) {
            if (r instanceof Array) {
                var c = r[Math.floor(Math.random() * r.length)];
                this.shape = c
            }
        } else this.shape = r;
        if ("image" == this.shape) {
            var o = i.particles.shape;
            this.img = {
                src: o.image.src,
                ratio: o.image.width / o.image.height
            }, this.img.ratio || (this.img.ratio = 1), "svg" == i.tmp.img_type && void 0 != i.tmp.source_svg && (i.fn.vendors.createSvgImg(this), i.tmp.pushing && (this.img.loaded = !1))
        }
    }, i.fn.particle.prototype.draw = function () {
        function e() {
            i.canvas.ctx.drawImage(r, a.x - t, a.y - t, 2 * t, 2 * t / a.img.ratio)
        }

        var a = this;
        if (void 0 != a.radius_bubble) var t = a.radius_bubble; else var t = a.radius;
        if (void 0 != a.opacity_bubble) var s = a.opacity_bubble; else var s = a.opacity;
        if (a.color.rgb) var n = "rgba(" + a.color.rgb.r + "," + a.color.rgb.g + "," + a.color.rgb.b + "," + s + ")"; else var n = "hsla(" + a.color.hsl.h + "," + a.color.hsl.s + "%," + a.color.hsl.l + "%," + s + ")";
        switch (i.canvas.ctx.fillStyle = n, i.canvas.ctx.beginPath(), a.shape) {
            case"circle":
                i.canvas.ctx.arc(a.x, a.y, t, 0, 2 * Math.PI, !1);
                break;
            case"edge":
                i.canvas.ctx.rect(a.x - t, a.y - t, 2 * t, 2 * t);
                break;
            case"triangle":
                i.fn.vendors.drawShape(i.canvas.ctx, a.x - t, a.y + t / 1.66, 2 * t, 3, 2);
                break;
            case"polygon":
                i.fn.vendors.drawShape(i.canvas.ctx, a.x - t / (i.particles.shape.polygon.nb_sides / 3.5), a.y - t / .76, 2.66 * t / (i.particles.shape.polygon.nb_sides / 3), i.particles.shape.polygon.nb_sides, 1);
                break;
            case"star":
                i.fn.vendors.drawShape(i.canvas.ctx, a.x - 2 * t / (i.particles.shape.polygon.nb_sides / 4), a.y - t / 1.52, 2 * t * 2.66 / (i.particles.shape.polygon.nb_sides / 3), i.particles.shape.polygon.nb_sides, 2);
                break;
            case"image":
                if ("svg" == i.tmp.img_type) var r = a.img.obj; else var r = i.tmp.img_obj;
                r && e()
        }
        i.canvas.ctx.closePath(), i.particles.shape.stroke.width > 0 && (i.canvas.ctx.strokeStyle = i.particles.shape.stroke.color, i.canvas.ctx.lineWidth = i.particles.shape.stroke.width, i.canvas.ctx.stroke()), i.canvas.ctx.fill()
    }, i.fn.particlesCreate = function () {
        for (var e = 0; e < i.particles.number.value; e++) i.particles.array.push(new i.fn.particle(i.particles.color, i.particles.opacity.value))
    }, i.fn.particlesUpdate = function () {
        for (var e = 0; e < i.particles.array.length; e++) {
            var a = i.particles.array[e];
            if (i.particles.move.enable) {
                var t = i.particles.move.speed / 2;
                a.x += a.vx * t, a.y += a.vy * t
            }
            if (i.particles.opacity.anim.enable && (1 == a.opacity_status ? (a.opacity >= i.particles.opacity.value && (a.opacity_status = !1), a.opacity += a.vo) : (a.opacity <= i.particles.opacity.anim.opacity_min && (a.opacity_status = !0), a.opacity -= a.vo), a.opacity < 0 && (a.opacity = 0)), i.particles.size.anim.enable && (1 == a.size_status ? (a.radius >= i.particles.size.value && (a.size_status = !1), a.radius += a.vs) : (a.radius <= i.particles.size.anim.size_min && (a.size_status = !0), a.radius -= a.vs), a.radius < 0 && (a.radius = 0)), "bounce" == i.particles.move.out_mode) var s = {
                x_left: a.radius,
                x_right: i.canvas.w,
                y_top: a.radius,
                y_bottom: i.canvas.h
            }; else var s = {
                x_left: -a.radius,
                x_right: i.canvas.w + a.radius,
                y_top: -a.radius,
                y_bottom: i.canvas.h + a.radius
            };
            switch (a.x - a.radius > i.canvas.w ? (a.x = s.x_left, a.y = Math.random() * i.canvas.h) : a.x + a.radius < 0 && (a.x = s.x_right, a.y = Math.random() * i.canvas.h), a.y - a.radius > i.canvas.h ? (a.y = s.y_top, a.x = Math.random() * i.canvas.w) : a.y + a.radius < 0 && (a.y = s.y_bottom, a.x = Math.random() * i.canvas.w), i.particles.move.out_mode) {
                case"bounce":
                    a.x + a.radius > i.canvas.w ? a.vx = -a.vx : a.x - a.radius < 0 && (a.vx = -a.vx), a.y + a.radius > i.canvas.h ? a.vy = -a.vy : a.y - a.radius < 0 && (a.vy = -a.vy)
            }
            if (isInArray("grab", i.interactivity.events.onhover.mode) && i.fn.modes.grabParticle(a), (isInArray("bubble", i.interactivity.events.onhover.mode) || isInArray("bubble", i.interactivity.events.onclick.mode)) && i.fn.modes.bubbleParticle(a), (isInArray("repulse", i.interactivity.events.onhover.mode) || isInArray("repulse", i.interactivity.events.onclick.mode)) && i.fn.modes.repulseParticle(a), i.particles.line_linked.enable || i.particles.move.attract.enable) for (var n = e + 1; n < i.particles.array.length; n++) {
                var r = i.particles.array[n];
                i.particles.line_linked.enable && i.fn.interact.linkParticles(a, r), i.particles.move.attract.enable && i.fn.interact.attractParticles(a, r), i.particles.move.bounce && i.fn.interact.bounceParticles(a, r)
            }
        }
    }, i.fn.particlesDraw = function () {
        i.canvas.ctx.clearRect(0, 0, i.canvas.w, i.canvas.h), i.fn.particlesUpdate();
        for (var e = 0; e < i.particles.array.length; e++) {
            var a = i.particles.array[e];
            a.draw()
        }
    }, i.fn.particlesEmpty = function () {
        i.particles.array = []
    }, i.fn.particlesRefresh = function () {
        cancelRequestAnimFrame(i.fn.checkAnimFrame), cancelRequestAnimFrame(i.fn.drawAnimFrame), i.tmp.source_svg = void 0, i.tmp.img_obj = void 0, i.tmp.count_svg = 0, i.fn.particlesEmpty(), i.fn.canvasClear(), i.fn.vendors.start()
    }, i.fn.interact.linkParticles = function (e, a) {
        var t = e.x - a.x, s = e.y - a.y, n = Math.sqrt(t * t + s * s);
        if (n <= i.particles.line_linked.distance) {
            var r = i.particles.line_linked.opacity - n / (1 / i.particles.line_linked.opacity) / i.particles.line_linked.distance;
            if (r > 0) {
                var c = i.particles.line_linked.color_rgb_line;
                i.canvas.ctx.strokeStyle = "rgba(" + c.r + "," + c.g + "," + c.b + "," + r + ")", i.canvas.ctx.lineWidth = i.particles.line_linked.width, i.canvas.ctx.beginPath(), i.canvas.ctx.moveTo(e.x, e.y), i.canvas.ctx.lineTo(a.x, a.y), i.canvas.ctx.stroke(), i.canvas.ctx.closePath()
            }
        }
    }, i.fn.interact.attractParticles = function (e, a) {
        var t = e.x - a.x, s = e.y - a.y, n = Math.sqrt(t * t + s * s);
        if (n <= i.particles.line_linked.distance) {
            var r = t / (1e3 * i.particles.move.attract.rotateX), c = s / (1e3 * i.particles.move.attract.rotateY);
            e.vx -= r, e.vy -= c, a.vx += r, a.vy += c
        }
    }, i.fn.interact.bounceParticles = function (e, a) {
        var t = e.x - a.x, i = e.y - a.y, s = Math.sqrt(t * t + i * i), n = e.radius + a.radius;
        n >= s && (e.vx = -e.vx, e.vy = -e.vy, a.vx = -a.vx, a.vy = -a.vy)
    }, i.fn.modes.pushParticles = function (e, a) {
        i.tmp.pushing = !0;
        for (var t = 0; e > t; t++) i.particles.array.push(new i.fn.particle(i.particles.color, i.particles.opacity.value, {
            x: a ? a.pos_x : Math.random() * i.canvas.w,
            y: a ? a.pos_y : Math.random() * i.canvas.h
        })), t == e - 1 && (i.particles.move.enable || i.fn.particlesDraw(), i.tmp.pushing = !1)
    }, i.fn.modes.removeParticles = function (e) {
        i.particles.array.splice(0, e), i.particles.move.enable || i.fn.particlesDraw()
    }, i.fn.modes.bubbleParticle = function (e) {
        function a() {
            e.opacity_bubble = e.opacity, e.radius_bubble = e.radius
        }

        function t(a, t, s, n, c) {
            if (a != t) if (i.tmp.bubble_duration_end) {
                if (void 0 != s) {
                    var o = n - p * (n - a) / i.interactivity.modes.bubble.duration, l = a - o;
                    d = a + l, "size" == c && (e.radius_bubble = d), "opacity" == c && (e.opacity_bubble = d)
                }
            } else if (r <= i.interactivity.modes.bubble.distance) {
                if (void 0 != s) var v = s; else var v = n;
                if (v != a) {
                    var d = n - p * (n - a) / i.interactivity.modes.bubble.duration;
                    "size" == c && (e.radius_bubble = d), "opacity" == c && (e.opacity_bubble = d)
                }
            } else "size" == c && (e.radius_bubble = void 0), "opacity" == c && (e.opacity_bubble = void 0)
        }

        if (i.interactivity.events.onhover.enable && isInArray("bubble", i.interactivity.events.onhover.mode)) {
            var s = e.x - i.interactivity.mouse.pos_x, n = e.y - i.interactivity.mouse.pos_y,
                r = Math.sqrt(s * s + n * n), c = 1 - r / i.interactivity.modes.bubble.distance;
            if (r <= i.interactivity.modes.bubble.distance) {
                if (c >= 0 && "mousemove" == i.interactivity.status) {
                    if (i.interactivity.modes.bubble.size != i.particles.size.value) if (i.interactivity.modes.bubble.size > i.particles.size.value) {
                        var o = e.radius + i.interactivity.modes.bubble.size * c;
                        o >= 0 && (e.radius_bubble = o)
                    } else {
                        var l = e.radius - i.interactivity.modes.bubble.size, o = e.radius - l * c;
                        o > 0 ? e.radius_bubble = o : e.radius_bubble = 0
                    }
                    if (i.interactivity.modes.bubble.opacity != i.particles.opacity.value) if (i.interactivity.modes.bubble.opacity > i.particles.opacity.value) {
                        var v = i.interactivity.modes.bubble.opacity * c;
                        v > e.opacity && v <= i.interactivity.modes.bubble.opacity && (e.opacity_bubble = v)
                    } else {
                        var v = e.opacity - (i.particles.opacity.value - i.interactivity.modes.bubble.opacity) * c;
                        v < e.opacity && v >= i.interactivity.modes.bubble.opacity && (e.opacity_bubble = v)
                    }
                }
            } else a();
            "mouseleave" == i.interactivity.status && a()
        } else if (i.interactivity.events.onclick.enable && isInArray("bubble", i.interactivity.events.onclick.mode)) {
            if (i.tmp.bubble_clicking) {
                var s = e.x - i.interactivity.mouse.click_pos_x, n = e.y - i.interactivity.mouse.click_pos_y,
                    r = Math.sqrt(s * s + n * n), p = ((new Date).getTime() - i.interactivity.mouse.click_time) / 1e3;
                p > i.interactivity.modes.bubble.duration && (i.tmp.bubble_duration_end = !0), p > 2 * i.interactivity.modes.bubble.duration && (i.tmp.bubble_clicking = !1, i.tmp.bubble_duration_end = !1)
            }
            i.tmp.bubble_clicking && (t(i.interactivity.modes.bubble.size, i.particles.size.value, e.radius_bubble, e.radius, "size"), t(i.interactivity.modes.bubble.opacity, i.particles.opacity.value, e.opacity_bubble, e.opacity, "opacity"))
        }
    }, i.fn.modes.repulseParticle = function (e) {
        function a() {
            var a = Math.atan2(d, p);
            if (e.vx = u * Math.cos(a), e.vy = u * Math.sin(a), "bounce" == i.particles.move.out_mode) {
                var t = {x: e.x + e.vx, y: e.y + e.vy};
                t.x + e.radius > i.canvas.w ? e.vx = -e.vx : t.x - e.radius < 0 && (e.vx = -e.vx), t.y + e.radius > i.canvas.h ? e.vy = -e.vy : t.y - e.radius < 0 && (e.vy = -e.vy)
            }
        }

        if (i.interactivity.events.onhover.enable && isInArray("repulse", i.interactivity.events.onhover.mode) && "mousemove" == i.interactivity.status) {
            var t = e.x - i.interactivity.mouse.pos_x, s = e.y - i.interactivity.mouse.pos_y,
                n = Math.sqrt(t * t + s * s), r = {x: t / n, y: s / n}, c = i.interactivity.modes.repulse.distance,
                o = 100, l = clamp(1 / c * (-1 * Math.pow(n / c, 2) + 1) * c * o, 0, 50),
                v = {x: e.x + r.x * l, y: e.y + r.y * l};
            "bounce" == i.particles.move.out_mode ? (v.x - e.radius > 0 && v.x + e.radius < i.canvas.w && (e.x = v.x), v.y - e.radius > 0 && v.y + e.radius < i.canvas.h && (e.y = v.y)) : (e.x = v.x, e.y = v.y)
        } else if (i.interactivity.events.onclick.enable && isInArray("repulse", i.interactivity.events.onclick.mode)) if (i.tmp.repulse_finish || (i.tmp.repulse_count++, i.tmp.repulse_count == i.particles.array.length && (i.tmp.repulse_finish = !0)), i.tmp.repulse_clicking) {
            var c = Math.pow(i.interactivity.modes.repulse.distance / 6, 3),
                p = i.interactivity.mouse.click_pos_x - e.x, d = i.interactivity.mouse.click_pos_y - e.y,
                m = p * p + d * d, u = -c / m * 1;
            c >= m && a()
        } else 0 == i.tmp.repulse_clicking && (e.vx = e.vx_i, e.vy = e.vy_i)
    }, i.fn.modes.grabParticle = function (e) {
        if (i.interactivity.events.onhover.enable && "mousemove" == i.interactivity.status) {
            var a = e.x - i.interactivity.mouse.pos_x, t = e.y - i.interactivity.mouse.pos_y,
                s = Math.sqrt(a * a + t * t);
            if (s <= i.interactivity.modes.grab.distance) {
                var n = i.interactivity.modes.grab.line_linked.opacity - s / (1 / i.interactivity.modes.grab.line_linked.opacity) / i.interactivity.modes.grab.distance;
                if (n > 0) {
                    var r = i.particles.line_linked.color_rgb_line;
                    i.canvas.ctx.strokeStyle = "rgba(" + r.r + "," + r.g + "," + r.b + "," + n + ")", i.canvas.ctx.lineWidth = i.particles.line_linked.width, i.canvas.ctx.beginPath(), i.canvas.ctx.moveTo(e.x, e.y), i.canvas.ctx.lineTo(i.interactivity.mouse.pos_x, i.interactivity.mouse.pos_y), i.canvas.ctx.stroke(), i.canvas.ctx.closePath()
                }
            }
        }
    }, i.fn.vendors.eventsListeners = function () {
        "window" == i.interactivity.detect_on ? i.interactivity.el = window : i.interactivity.el = i.canvas.el, (i.interactivity.events.onhover.enable || i.interactivity.events.onclick.enable) && (i.interactivity.el.addEventListener("mousemove", function (e) {
            if (i.interactivity.el == window) var a = e.clientX, t = e.clientY; else var a = e.offsetX || e.clientX,
                t = e.offsetY || e.clientY;
            i.interactivity.mouse.pos_x = a, i.interactivity.mouse.pos_y = t, i.tmp.retina && (i.interactivity.mouse.pos_x *= i.canvas.pxratio, i.interactivity.mouse.pos_y *= i.canvas.pxratio), i.interactivity.status = "mousemove"
        }), i.interactivity.el.addEventListener("mouseleave", function (e) {
            i.interactivity.mouse.pos_x = null, i.interactivity.mouse.pos_y = null, i.interactivity.status = "mouseleave"
        })), i.interactivity.events.onclick.enable && i.interactivity.el.addEventListener("click", function () {
            if (i.interactivity.mouse.click_pos_x = i.interactivity.mouse.pos_x, i.interactivity.mouse.click_pos_y = i.interactivity.mouse.pos_y, i.interactivity.mouse.click_time = (new Date).getTime(), i.interactivity.events.onclick.enable) switch (i.interactivity.events.onclick.mode) {
                case"push":
                    i.particles.move.enable ? i.fn.modes.pushParticles(i.interactivity.modes.push.particles_nb, i.interactivity.mouse) : 1 == i.interactivity.modes.push.particles_nb ? i.fn.modes.pushParticles(i.interactivity.modes.push.particles_nb, i.interactivity.mouse) : i.interactivity.modes.push.particles_nb > 1 && i.fn.modes.pushParticles(i.interactivity.modes.push.particles_nb);
                    break;
                case"remove":
                    i.fn.modes.removeParticles(i.interactivity.modes.remove.particles_nb);
                    break;
                case"bubble":
                    i.tmp.bubble_clicking = !0;
                    break;
                case"repulse":
                    i.tmp.repulse_clicking = !0, i.tmp.repulse_count = 0, i.tmp.repulse_finish = !1, setTimeout(function () {
                        i.tmp.repulse_clicking = !1
                    }, 1e3 * i.interactivity.modes.repulse.duration)
            }
        })
    }, i.fn.vendors.densityAutoParticles = function () {
        if (i.particles.number.density.enable) {
            var e = i.canvas.el.width * i.canvas.el.height / 1e3;
            i.tmp.retina && (e /= 2 * i.canvas.pxratio);
            var a = e * i.particles.number.value / i.particles.number.density.value_area,
                t = i.particles.array.length - a;
            0 > t ? i.fn.modes.pushParticles(Math.abs(t)) : i.fn.modes.removeParticles(t)
        }
    }, i.fn.vendors.checkOverlap = function (e, a) {
        for (var t = 0; t < i.particles.array.length; t++) {
            var s = i.particles.array[t], n = e.x - s.x, r = e.y - s.y, c = Math.sqrt(n * n + r * r);
            c <= e.radius + s.radius && (e.x = a ? a.x : Math.random() * i.canvas.w, e.y = a ? a.y : Math.random() * i.canvas.h, i.fn.vendors.checkOverlap(e))
        }
    }, i.fn.vendors.createSvgImg = function (e) {
        var a = i.tmp.source_svg, t = /#([0-9A-F]{3,6})/gi, s = a.replace(t, function (a, t, i, s) {
                if (e.color.rgb) var n = "rgba(" + e.color.rgb.r + "," + e.color.rgb.g + "," + e.color.rgb.b + "," + e.opacity + ")"; else var n = "hsla(" + e.color.hsl.h + "," + e.color.hsl.s + "%," + e.color.hsl.l + "%," + e.opacity + ")";
                return n
            }), n = new Blob([s], {type: "image/svg+xml;charset=utf-8"}), r = window.URL || window.webkitURL || window,
            c = r.createObjectURL(n), o = new Image;
        o.addEventListener("load", function () {
            e.img.obj = o, e.img.loaded = !0, r.revokeObjectURL(c), i.tmp.count_svg++
        }), o.src = c
    }, i.fn.vendors.destroypJS = function () {
        cancelAnimationFrame(i.fn.drawAnimFrame), t.remove(), pJSDom = null
    }, i.fn.vendors.drawShape = function (e, a, t, i, s, n) {
        var r = s * n, c = s / n, o = 180 * (c - 2) / c, l = Math.PI - Math.PI * o / 180;
        e.save(), e.beginPath(), e.translate(a, t), e.moveTo(0, 0);
        for (var v = 0; r > v; v++) e.lineTo(i, 0), e.translate(i, 0), e.rotate(l);
        e.fill(), e.restore()
    }, i.fn.vendors.exportImg = function () {
        window.open(i.canvas.el.toDataURL("image/png"), "_blank")
    }, i.fn.vendors.loadImg = function (e) {
        if (i.tmp.img_error = void 0, "" != i.particles.shape.image.src) if ("svg" == e) {
            var a = new XMLHttpRequest;
            a.open("GET", i.particles.shape.image.src), a.onreadystatechange = function (e) {
                4 == a.readyState && (200 == a.status ? (i.tmp.source_svg = e.currentTarget.response, i.fn.vendors.checkBeforeDraw()) : (console.log("Error pJS - Image not found"), i.tmp.img_error = !0))
            }, a.send()
        } else {
            var t = new Image;
            t.addEventListener("load", function () {
                i.tmp.img_obj = t, i.fn.vendors.checkBeforeDraw()
            }), t.src = i.particles.shape.image.src
        } else console.log("Error pJS - No image.src"), i.tmp.img_error = !0
    }, i.fn.vendors.draw = function () {
        "image" == i.particles.shape.type ? "svg" == i.tmp.img_type ? i.tmp.count_svg >= i.particles.number.value ? (i.fn.particlesDraw(), i.particles.move.enable ? i.fn.drawAnimFrame = requestAnimFrame(i.fn.vendors.draw) : cancelRequestAnimFrame(i.fn.drawAnimFrame)) : i.tmp.img_error || (i.fn.drawAnimFrame = requestAnimFrame(i.fn.vendors.draw)) : void 0 != i.tmp.img_obj ? (i.fn.particlesDraw(), i.particles.move.enable ? i.fn.drawAnimFrame = requestAnimFrame(i.fn.vendors.draw) : cancelRequestAnimFrame(i.fn.drawAnimFrame)) : i.tmp.img_error || (i.fn.drawAnimFrame = requestAnimFrame(i.fn.vendors.draw)) : (i.fn.particlesDraw(), i.particles.move.enable ? i.fn.drawAnimFrame = requestAnimFrame(i.fn.vendors.draw) : cancelRequestAnimFrame(i.fn.drawAnimFrame))
    }, i.fn.vendors.checkBeforeDraw = function () {
        "image" == i.particles.shape.type ? "svg" == i.tmp.img_type && void 0 == i.tmp.source_svg ? i.tmp.checkAnimFrame = requestAnimFrame(check) : (cancelRequestAnimFrame(i.tmp.checkAnimFrame), i.tmp.img_error || (i.fn.vendors.init(), i.fn.vendors.draw())) : (i.fn.vendors.init(), i.fn.vendors.draw())
    }, i.fn.vendors.init = function () {
        i.fn.retinaInit(), i.fn.canvasInit(), i.fn.canvasSize(), i.fn.canvasPaint(), i.fn.particlesCreate(), i.fn.vendors.densityAutoParticles(), i.particles.line_linked.color_rgb_line = hexToRgb(i.particles.line_linked.color)
    }, i.fn.vendors.start = function () {
        isInArray("image", i.particles.shape.type) ? (i.tmp.img_type = i.particles.shape.image.src.substr(i.particles.shape.image.src.length - 3), i.fn.vendors.loadImg(i.tmp.img_type)) : i.fn.vendors.checkBeforeDraw()
    }, i.fn.vendors.eventsListeners(), i.fn.vendors.start()
};
Object.deepExtend = function (e, a) {
    for (var t in a) a[t] && a[t].constructor && a[t].constructor === Object ? (e[t] = e[t] || {}, arguments.callee(e[t], a[t])) : e[t] = a[t];
    return e
}, window.requestAnimFrame = function () {
    return window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame || function (e) {
        window.setTimeout(e, 1e3 / 60)
    }
}(), window.cancelRequestAnimFrame = function () {
    return window.cancelAnimationFrame || window.webkitCancelRequestAnimationFrame || window.mozCancelRequestAnimationFrame || window.oCancelRequestAnimationFrame || window.msCancelRequestAnimationFrame || clearTimeout
}(), window.pJSDom = [], window.particlesJS = function (e, a) {
    "string" != typeof e && (a = e, e = "particles-js"), e || (e = "particles-js");
    var t = document.getElementById(e), i = "particles-js-canvas-el", s = t.getElementsByClassName(i);
    if (s.length) for (; s.length > 0;) t.removeChild(s[0]);
    var n = document.createElement("canvas");
    n.className = i, n.style.width = "100%", n.style.height = "100%";
    var r = document.getElementById(e).appendChild(n);
    null != r && pJSDom.push(new pJS(e, a))
}, window.particlesJS.load = function (e, a, t) {
    var i = new XMLHttpRequest;
    i.open("GET", a), i.onreadystatechange = function (a) {
        if (4 == i.readyState) if (200 == i.status) {
            var s = JSON.parse(a.currentTarget.response);
            window.particlesJS(e, s), t && t()
        } else console.log("Error pJS - XMLHttpRequest status: " + i.status), console.log("Error pJS - fle config not found")
    }, i.send()
};


/* -----------------------------------------------
/* How to use? : Check the GitHub README
/* ----------------------------------------------- */

particlesJS('particles-js',
  
  {
    "particles": {
      "number": {
        "value": 50,
        "density": {
          "enable": true,
          "value_area": 800
        }
      },
      "color": {
        "value": "#888"
      },
      "shape": {
        "type": "circle",
        "stroke": {
          "width": 0,
          "color": "#888"
        },
        "polygon": {
          "nb_sides": 5
        },
        "image": {
          "src": "img/github.svg",
          "width": 100,
          "height": 100
        }
      },
      "opacity": {
        "value": 0.5,
        "random": false,
        "anim": {
          "enable": false,
          "speed": 3,
          "opacity_min": 0.1,
          "sync": false
        }
      },
      "size": {
        "value": 5,
        "random": true,
        "anim": {
          "enable": false,
          "speed": 40,
          "size_min": 0.1,
          "sync": false
        }
      },
      "line_linked": {
        "enable": true,
        "distance": 150,
        "color": "#888",
        "opacity": 0.4,
        "width": 1
      },
      "move": {
        "enable": true,
        "speed": 6,
        "direction": "none",
        "random": false,
        "straight": false,
        "out_mode": "out",
        "attract": {
          "enable": false,
          "rotateX": 600,
          "rotateY": 1200
        }
      }
    },
    "interactivity": {
      "detect_on": "canvas",
      "events": {
        "onhover": {
          "enable": true,
          "mode": "repulse"
        },
        "onclick": {
          "enable": true,
          "mode": "push"
        },
        "resize": true
      },
      "modes": {
        "grab": {
          "distance": 400,
          "line_linked": {
            "opacity": 1
          }
        },
        "bubble": {
          "distance": 400,
          "size": 40,
          "duration": 2,
          "opacity": 8,
          "speed": 3
        },
        "repulse": {
          "distance": 200
        },
        "push": {
          "particles_nb": 4
        },
        "remove": {
          "particles_nb": 2
        }
      }
    },
    "retina_detect": true,
    "config_demo": {
      "hide_card": false,
      "background_color": "#b61924",
      "background_image": "",
      "background_position": "50% 50%",
      "background_repeat": "no-repeat",
      "background_size": "cover"
    }
  }

);
