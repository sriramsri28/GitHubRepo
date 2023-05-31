/*!
 * 
 *     MCAFEE RESTRICTED CONFIDENTIAL
 *     Copyright (c) 2023 McAfee, LLC
 *
 *     The source code contained or described herein and all documents related
 *     to the source code ("Material") are owned by McAfee or its
 *     suppliers or licensors. Title to the Material remains with McAfee
 *     or its suppliers and licensors. The Material contains trade
 *     secrets and proprietary and confidential information of McAfee or its
 *     suppliers and licensors. The Material is protected by worldwide copyright
 *     and trade secret laws and treaty provisions. No part of the Material may
 *     be used, copied, reproduced, modified, published, uploaded, posted,
 *     transmitted, distributed, or disclosed in any way without McAfee's prior
 *     express written permission.
 *
 *     No license under any patent, copyright, trade secret or other intellectual
 *     property right is granted to or conferred upon you by disclosure or
 *     delivery of the Materials, either expressly, by implication, inducement,
 *     estoppel or otherwise. Any license under such intellectual property rights
 *     must be expressed and approved by McAfee in writing.
 *
 */(()=>{"use strict";const e=chrome,t="LOCAL_STORE",s="CONTENT_HANDLER",n="EXECUTE_COMMAND",a="FOCUS_OR_CREATE_TAB",o="GET_BK_GLOBALS",c="GET_EXTENSION_STATUS",m="GET_TAB_DATA",i="TI_REQUEST",r="PLACEHOLDER_TEXT",d="REMOVE_TAB",E="SEND_TELEMETRY",T="SET_VIEWPORT",u="WHITELIST",_="RESET_NATIVE_SETTING",g="UPDATE_BK_NATIVE_SETTINGS",S="SHOW_SIDEBAR_MAIN",l="GET_POPUP_DATA",M="GET_SETTINGS_DATA",A="RESET_SETTINGS",I="GET_TYPOSQUATTING_DATA",P="IS_FRAME_BLOCKED",h="IS_WHITELISTED",O="ANY_BLOCKED_IFRAMES",D="ANY_BLOCKED_CRYPTOSCRIPTS",N="UNBLOCK_ALL_IFRAMES",C="VIEW_SITE_REPORT",L="SEARCH_ANNOTATION",F="UPDATE_ENGINE_STATS",R="SOCIAL_MEDIA_ANNOTATION",G="UPDATE_RAT_DETECTION_SHOWING_FLAG",p="SEARCH_SUGGEST",W="SAVE_FORM_INFO",f="GET_FORM_INFO_CACHE",y="CLEAR_FORM_INFO_CACHE",U="SAVE_MULTISTEP_LOGIN",w="GET_FD_WEIGHTS",B="GET_FD_EXCEPTIONS",H="GET_FD_CRF_PARAMS",b="CLEAR_DWS_INFO",v="GET_CACHED_DWS_INFO",V="UPDATE_DWS_WHITELIST",Y="LAUNCH_IDPS_LOGIN",x="UPDATE_DWS_SHOWN",k="GET_APS_DETAILS",K="SIGN_UP_FORM_DETECTED",X="SET_FF_POLICY_COLLECTION",q="SET_FF_POLICY_LAST_SHOWN",z="PING_CONTENT_FF_VIEWPORTS",Q="BROADCAST_TO_FOREGROUND";class J{static handlePromiseMessage(e,t=null){return new Promise(((s,n)=>{chrome.runtime.sendMessage(e,(e=>{"function"==typeof t?t(s,n,e):((e,t,s)=>{chrome.runtime.lastError&&t(chrome.runtime.lastError.message),e(s)})(s,n,e)}))}))}}class j{static localStore(e,s){const n=t;return J.handlePromiseMessage({command:n,action:e,data:s})}static sessionStore(e,s){const n=t;return J.handlePromiseMessage({command:n,action:e,data:s})}static isFrameBlocked(e){const t=P;return J.handlePromiseMessage({command:t,url:e})}static makeMTIRequest(e,t){const s={command:i,requestData:e,referer:t};return J.handlePromiseMessage(s)}static executeCommand(t,s){const a=n;e.runtime.sendMessage({command:a,commandId:t,params:s})}static focusOrCreateTab(t){const s=a;e.runtime.sendMessage({command:s,url:t})}static closeTab(){const t=d;e.runtime.sendMessage({command:t})}static whitelist(e,t,s){const n=u;return J.handlePromiseMessage({action:e,command:n,type:t,data:s})}static getPopupData(){const e=l;return J.handlePromiseMessage({command:e})}static getSettingsData(){const e=M;return J.handlePromiseMessage({command:e})}static searchAnnotation(e,t){const s=L;return J.handlePromiseMessage({action:e,data:t,command:s})}static socialMediaAnnotation(e,t){const s=R;return J.handlePromiseMessage({action:e,data:t,command:s})}static async getBkGlobals(e=!1){return new Promise((t=>{const s=o;J.handlePromiseMessage({command:s,bIncludeSearchEngines:e}).then((e=>{t(JSON.parse(e))}))}))}static viewSiteReport(t=null,s=!1){const n=C;e.runtime.sendMessage({command:n,url:t,showInNewTab:s})}static getTypoSquattingData(e){const t=I;return J.handlePromiseMessage({command:t,domain:e})}static getPlaceholderText(e){const t=r;return J.handlePromiseMessage({command:t,id:e})}static setViewPort(t,s){const n=T;e.runtime.sendMessage({command:n,x:t,y:s})}static sendTelemetry(t){const s=E;e.runtime.sendMessage({command:s,telemetry:t})}static anyBlockedIframes(e){const t=O;return J.handlePromiseMessage({command:t,frameUrls:e})}static anyBlockedCryptoScripts(){const e=D;return J.handlePromiseMessage({command:e})}static resetSettings(){const t=A;e.runtime.sendMessage({command:t})}static sendEngineStat(t){e.runtime.sendMessage({command:F,engine:t})}static contentHandler(t){const n=s;e.runtime.sendMessage({command:n,message:t})}static getTabData(e={}){const t={command:m,...e};return J.handlePromiseMessage(t)}static isWhitelisted(e){const t={command:h,url:e};return J.handlePromiseMessage(t)}static getExtensionStatus(e){return J.handlePromiseMessage({command:c,extension_id:e})}static unblockAllIframes(){const t=N;e.runtime.sendMessage({command:t})}static updateRatDetectionShowingFlag(t){const s=G;e.runtime.sendMessage({command:s,showed:t})}static getSearchSuggest(e){const t={command:p,searchTerm:e};return J.handlePromiseMessage(t)}static resetNativeSetting(t){const s=_;e.runtime.sendMessage({command:s,setting:t})}static saveFormInfo(t,s){const n=W;e.runtime.sendMessage({command:n,username:t,hostname:s})}static saveMultiStepLogin(t,s){const n=U;e.runtime.sendMessage({command:n,data:t,completeLogin:s})}static getFormInfoCache(){const e=f;return J.handlePromiseMessage({command:e})}static clearFormInfoCache(){const t=y;e.runtime.sendMessage({command:t})}static updateDWSWhitelist(t){const s=V;e.runtime.sendMessage({command:s,email:t})}static getCachedDWSInfo(e){const t={command:v,email:e};return J.handlePromiseMessage(t)}static clearCachedDWSInfo(t){const s=b;e.runtime.sendMessage({command:s,email:t})}static updateDWSShown(t){const s=x;e.runtime.sendMessage({command:s,email:t})}static getAPSDetails(){const e=k;return J.handlePromiseMessage({command:e})}static signUpFormDetected(){const t=K;e.runtime.sendMessage({command:t})}static updateBkNativeSettings(t,s){const n=g;e.runtime.sendMessage({command:n,name:t,value:s})}static launchIDPSLogin(){const t=Y;e.runtime.sendMessage({command:t})}static showSidebarMain(){const t=S;e.runtime.sendMessage({command:t})}static setFFPolicyCollection({personal:t,activity:s}){const n=X;e.runtime.sendMessage({command:n,personal:t,activity:s})}static setFFPolicyLastShown(){const t=q;e.runtime.sendMessage({command:t})}static broadcastToForeground(t){const s=Q;e.runtime.sendMessage({command:s,payload:t})}static getFDWeights(){const e=w;return J.handlePromiseMessage({command:e})}static getFDExceptions(){const e=B;return J.handlePromiseMessage({command:e})}static getFDCrfParams(){const e=H;return J.handlePromiseMessage({command:e})}}class Z{constructor(e){this.pingCommand=e,this.basePingListener()}basePingListener(e=null){chrome.runtime.onMessage.addListener(((t,s,n)=>{if(s.id!==chrome.runtime.id)return;const{command:a}=t;a===this.pingCommand&&(n({content:!0}),"function"==typeof e&&e())}))}}(new class extends Z{constructor(){super(z)}main(){var e;e=()=>{if(!window)return;const{devicePixelRatio:e,mozInnerScreenX:t,mozInnerScreenY:s,screenX:n,screenY:a}=window,o=Math.round((t-n)*e),c=Math.round((s-a)*e);j.setViewPort(o,c)},"undefined"!=typeof document&&null!==document&&("complete"===document.readyState||"loading"!==document.readyState&&!document.documentElement.doScroll?e():document.addEventListener("DOMContentLoaded",e))}}).main()})();
//# sourceMappingURL=../sourceMap/scripts/content_ff_viewports.js.map