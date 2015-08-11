/*
 * Bo Y Te Calendar
 * Doi du an Bo Y Te - Phong san pham dieu hanh tac nghiep - BU Hanh chinh cong  * 
 */

/**
 * Nếu số ngày tháng có 1 ký tự thì thêm 0 ở đầu
 * @param {type} number
 * @returns {pad.r|String}
 */
function pad(number) {
    var r = String(number);
    if ( r.length === 1 ) {
        r = '0' + r;
    }
    return r;
}

/**
 * Hàm mở rộng js, insert 1 phần tử vào array tại vị trí truyền vào
 * @param  {[type]} index [description]
 * @param  {[type]} item  [description]
 * @return {[type]}       [description]
 */
Array.prototype.insert = function (index, item) {
  this.splice(index, 0, item);
};

/**
 * Kiểm tra mở đầu của 1 chuỗi có phải là giá trị truyền vào
 * @param  {[type]} str [description]
 * @return {[type]}     [description]
 */
String.prototype.startsWith = function (str){
    return this.indexOf(str) === 0;
};

/**
 * Kiểm tra kết thúc chuỗi có phải là suffix truyền vào ko
 * @param  {[type]} suffix [description]
 * @return {[type]}        [description]
 */
String.prototype.endsWith = function(suffix) {
    return this.indexOf(suffix, this.length - suffix.length) !== -1;
};

/**
 * Hàm tìm kiếm với tiếng việt không dấu
 * @param {type} term
 * @returns {undefined}
 */
String.prototype.searchWithOutAlias = function(term){
    term = changeAlias(term);
    return (changeAlias(this)).search(term);
};

/**
 * Chuyển date về dạng "dd/MM/yyyy"
 * @returns {String}
 */
Date.prototype.toDayFirstString = function(){
    var date = this;
    var str = pad(date.getDate()) + "/" + pad(date.getMonth() + 1) + "/" + pad(date.getYear() + 1900);
    return str;
};

Date.prototype.toDayFirstWithTime = function(){
    var date = this;
    var str = pad(date.getDate()) + "/" + pad(date.getMonth() + 1) + "/" + pad(date.getYear() + 1900) + " " + pad(date.getHours()) + ":" + pad(date.getMinutes());
    return str;
},

/**
 * Chuyển date sang dạng string
 * @returns {String}
 */
Date.prototype.toISOString = function() {
    return this.getUTCFullYear()
        + '-' + pad( this.getUTCMonth() + 1 )
        + '-' + pad( this.getUTCDate() )
        + 'T' + pad( this.getUTCHours() )
        + ':' + pad( this.getUTCMinutes() )
        + ':' + pad( this.getUTCSeconds() )
//        + '.' + String( (this.getUTCMilliseconds()/1000).toFixed(3) ).slice( 2, 5 )
        + 'Z';
};

/**
 * Chuyển những trường dữ liệu đặc biệt của client để trên server có thể hiểu được
 * Ví dụ date -> string
 * ...
 * @param {type} formData
 * @returns {undefined}
 */
function prepareFormData(formData){
    if(formData != null){
        for(var key in formData){
            var obj = formData[key];
            if(obj !=  null && typeof obj == 'object' && typeof obj.getMonth == 'function'){
                formData[key] = obj.toDayFirstWithTime();
                formData[key + "Iso8601"] = obj.toISOString();
            }
        }
    }
    return formData;
};

//function prepareResponse(formData){
//    if(formData != null){
//        for(var key in formData){
//            var obj = formData[key];
//            if(typeof obj == 'object' && typeof obj.getMonth == 'function'){
//                formData[key] = obj.toDayFirstWithTime();
//                formData[key + "Iso8601"] = obj.toISOString();
//            }
//        }
//    }
//    return formData;
//};

/**
 * Encode html truyền vào
 * @param {type} html
 * @returns {Node.innerHTML}
 */
function htmlEncode( html ) {
    return document.createElement( 'div' ).appendChild(document.createTextNode( html ) ).parentNode.innerHTML;
};

/**
 * Decode html truyền vào
 * @param {type} html
 * @returns {document@call;createElement.textContent|a.textContent|a@call;formToArray.textContent}
 */
function htmlDecode( html ) {
    var a = document.createElement( 'div' ); a.innerHTML = html;
    return a.textContent;
};

/**
 * Clone 1 đối tượng trong javascript
 * @param {type} obj Đối tượng cần clone
 * @param {type} excludeArr Loại bỏ key không cần thiết
 * @returns {undefined}
 */
function clone(obj, excludeArr){
    if(typeof obj == 'undefined'){
        return null;
    }
    if(obj == null){
        return obj;
    }
    if(typeof  obj != 'object' || (typeof obj == 'object' && typeof obj.getMonth == 'function')){
        return JSON.parse(JSON.stringify(obj));
    }
    var c = obj.constructor();
    for(var key in obj){
        if(!excludeArr || !excludeArr.indexOf(key)){
            c[key] = obj[key];
        }
    }
    return c;
};

/**
 * Chuyển tiếng việt có đấu hành không dấu, đồng thời xóa các ký tự đặc biệt
 * @param  {[type]} alias [description]
 * @return {[type]}       [description]
 */
function changeAlias( alias )
{
    var str = alias;
    str= str.toLowerCase(); 
    str= str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ  |ặ|ẳ|ẵ/g,"a"); 
    str= str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g,"e"); 
    str= str.replace(/ì|í|ị|ỉ|ĩ/g,"i"); 
    str= str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ  |ợ|ở|ỡ/g,"o"); 
    str= str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g,"u"); 
    str= str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g,"y"); 
    str= str.replace(/đ/g,"d"); 
    str= str.replace(/!|@|%|\^|\*|\(|\)|\+|\=|\<|\>|\?|\/|,|\.|\:|\;|\'|\"|\&|\#|\[|\]|~|$|_/g,"-");
    /* tìm và thay thế các kí tự đặc biệt trong chuỗi sang kí tự - */
    str= str.replace(/-+-/g,"-"); //thay thế 2- thành 1-
    str= str.replace(/^\-+|\-+$/g,""); 
    //cắt bỏ ký tự - ở đầu và cuối chuỗi 
    return str;
}


/**
 * Kiểm tra xem thiết bị có phải là mobile hay không
 * @returns {Boolean}
 */

var isMobileDevice = function(){
    if( navigator.userAgent.match(/Android/i)
    || navigator.userAgent.match(/webOS/i)
    || navigator.userAgent.match(/iPhone/i)
    || navigator.userAgent.match(/iPad/i)
    || navigator.userAgent.match(/iPod/i)
    || navigator.userAgent.match(/BlackBerry/i)
    || navigator.userAgent.match(/Windows Phone/i)
    ){
       return true;
     }
    else {
       return false;
     }
};

$(document).ready(function () {
    /*
        ajax loading
    */
    $(document).ajaxStart(function () {
        if(NProgress){
            NProgress.start();
        }
    }).ajaxStop(function () {
        if(NProgress){
            NProgress.remove();
        }
    }).ajaxComplete(function () {
        if(NProgress){
            NProgress.done();
            NProgress.remove();
        }
    }).ajaxError(function () {
        if(NProgress){
            NProgress.remove();
        }
    });


    /* token */
    $.ajaxSetup({
        beforeSend: function (jqXHR) {
            var _csrf = $('meta[name=_csrf]').attr("content");
            var _csrf_header = $('meta[name=_csrf_header]').attr("content");
            if(_csrf){
                jqXHR.setRequestHeader(_csrf_header, _csrf);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("jqXHR -> ", jqXHR);
            console.log("textStatus -> ", textStatus);
            console.log("errorThrown -> ", errorThrown);
            if (jqXHR.status == 403) {
                //window.location.href = window.baseUrl + "403";
            }
            else if (jqXHR.status == 500) {
                //window.location.href = window.baseUrl + "500";
            }
        }
    });
});


/*
 * $Id: base64.js,v 2.15 2014/04/05 12:58:57 dankogai Exp dankogai $
 *
 *  Licensed under the MIT license.
 *    http://opensource.org/licenses/mit-license
 *
 *  References:
 *    http://en.wikipedia.org/wiki/Base64
 */

(function(global) {
    'use strict';
    // existing version for noConflict()
    var _Base64 = global.Base64;
    var version = "2.1.6";
    // if node.js, we use Buffer
    var buffer;
    if (typeof module !== 'undefined' && module.exports) {
        buffer = require('buffer').Buffer;
    }
    // constants
    var b64chars
        = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/';
    var b64tab = function(bin) {
        var t = {};
        for (var i = 0, l = bin.length; i < l; i++) t[bin.charAt(i)] = i;
        return t;
    }(b64chars);
    var fromCharCode = String.fromCharCode;
    // encoder stuff
    var cb_utob = function(c) {
        if (c.length < 2) {
            var cc = c.charCodeAt(0);
            return cc < 0x80 ? c
                : cc < 0x800 ? (fromCharCode(0xc0 | (cc >>> 6))
                                + fromCharCode(0x80 | (cc & 0x3f)))
                : (fromCharCode(0xe0 | ((cc >>> 12) & 0x0f))
                   + fromCharCode(0x80 | ((cc >>>  6) & 0x3f))
                   + fromCharCode(0x80 | ( cc         & 0x3f)));
        } else {
            var cc = 0x10000
                + (c.charCodeAt(0) - 0xD800) * 0x400
                + (c.charCodeAt(1) - 0xDC00);
            return (fromCharCode(0xf0 | ((cc >>> 18) & 0x07))
                    + fromCharCode(0x80 | ((cc >>> 12) & 0x3f))
                    + fromCharCode(0x80 | ((cc >>>  6) & 0x3f))
                    + fromCharCode(0x80 | ( cc         & 0x3f)));
        }
    };
    var re_utob = /[\uD800-\uDBFF][\uDC00-\uDFFFF]|[^\x00-\x7F]/g;
    var utob = function(u) {
        return u.replace(re_utob, cb_utob);
    };
    var cb_encode = function(ccc) {
        var padlen = [0, 2, 1][ccc.length % 3],
        ord = ccc.charCodeAt(0) << 16
            | ((ccc.length > 1 ? ccc.charCodeAt(1) : 0) << 8)
            | ((ccc.length > 2 ? ccc.charCodeAt(2) : 0)),
        chars = [
            b64chars.charAt( ord >>> 18),
            b64chars.charAt((ord >>> 12) & 63),
            padlen >= 2 ? '=' : b64chars.charAt((ord >>> 6) & 63),
            padlen >= 1 ? '=' : b64chars.charAt(ord & 63)
        ];
        return chars.join('');
    };
    var btoa = global.btoa ? function(b) {
        return global.btoa(b);
    } : function(b) {
        return b.replace(/[\s\S]{1,3}/g, cb_encode);
    };
    var _encode = buffer
        ? function (u) { return (new buffer(u)).toString('base64') } 
    : function (u) { return btoa(utob(u)) }
    ;
    var encode = function(u, urisafe) {
        return !urisafe 
            ? _encode(String(u))
            : _encode(String(u)).replace(/[+\/]/g, function(m0) {
                return m0 == '+' ? '-' : '_';
            }).replace(/=/g, '');
    };
    var encodeURI = function(u) { return encode(u, true) };
    // decoder stuff
    var re_btou = new RegExp([
        '[\xC0-\xDF][\x80-\xBF]',
        '[\xE0-\xEF][\x80-\xBF]{2}',
        '[\xF0-\xF7][\x80-\xBF]{3}'
    ].join('|'), 'g');
    var cb_btou = function(cccc) {
        switch(cccc.length) {
        case 4:
            var cp = ((0x07 & cccc.charCodeAt(0)) << 18)
                |    ((0x3f & cccc.charCodeAt(1)) << 12)
                |    ((0x3f & cccc.charCodeAt(2)) <<  6)
                |     (0x3f & cccc.charCodeAt(3)),
            offset = cp - 0x10000;
            return (fromCharCode((offset  >>> 10) + 0xD800)
                    + fromCharCode((offset & 0x3FF) + 0xDC00));
        case 3:
            return fromCharCode(
                ((0x0f & cccc.charCodeAt(0)) << 12)
                    | ((0x3f & cccc.charCodeAt(1)) << 6)
                    |  (0x3f & cccc.charCodeAt(2))
            );
        default:
            return  fromCharCode(
                ((0x1f & cccc.charCodeAt(0)) << 6)
                    |  (0x3f & cccc.charCodeAt(1))
            );
        }
    };
    var btou = function(b) {
        return b.replace(re_btou, cb_btou);
    };
    var cb_decode = function(cccc) {
        var len = cccc.length,
        padlen = len % 4,
        n = (len > 0 ? b64tab[cccc.charAt(0)] << 18 : 0)
            | (len > 1 ? b64tab[cccc.charAt(1)] << 12 : 0)
            | (len > 2 ? b64tab[cccc.charAt(2)] <<  6 : 0)
            | (len > 3 ? b64tab[cccc.charAt(3)]       : 0),
        chars = [
            fromCharCode( n >>> 16),
            fromCharCode((n >>>  8) & 0xff),
            fromCharCode( n         & 0xff)
        ];
        chars.length -= [0, 0, 2, 1][padlen];
        return chars.join('');
    };
    var atob = global.atob ? function(a) {
        return global.atob(a);
    } : function(a){
        return a.replace(/[\s\S]{1,4}/g, cb_decode);
    };
    var _decode = buffer
        ? function(a) { return (new buffer(a, 'base64')).toString() }
    : function(a) { return btou(atob(a)) };
    var decode = function(a){
        return _decode(
            String(a).replace(/[-_]/g, function(m0) { return m0 == '-' ? '+' : '/' })
                .replace(/[^A-Za-z0-9\+\/]/g, '')
        );
    };
    var noConflict = function() {
        var Base64 = global.Base64;
        global.Base64 = _Base64;
        return Base64;
    };
    // export Base64
    global.Base64 = {
        VERSION: version,
        atob: atob,
        btoa: btoa,
        fromBase64: decode,
        toBase64: encode,
        utob: utob,
        encode: encode,
        encodeURI: encodeURI,
        btou: btou,
        decode: decode,
        noConflict: noConflict
    };
    // if ES5 is available, make Base64.extendString() available
    if (typeof Object.defineProperty === 'function') {
        var noEnum = function(v){
            return {value:v,enumerable:false,writable:true,configurable:true};
        };
        global.Base64.extendString = function () {
            Object.defineProperty(
                String.prototype, 'fromBase64', noEnum(function () {
                    return decode(this)
                }));
            Object.defineProperty(
                String.prototype, 'toBase64', noEnum(function (urisafe) {
                    return encode(this, urisafe)
                }));
            Object.defineProperty(
                String.prototype, 'toBase64URI', noEnum(function () {
                    return encode(this, true)
                }));
        };
    }
    // that's it!
})(this);

if (this['Meteor']) {
    Base64 = global.Base64; // for normal export in Meteor.js
}
