package org.talend.designer.codegen.translators.common;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Map;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.core.ui.branding.AbstractBrandingService;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.CodeGeneratorRoutine;
import org.talend.designer.codegen.i18n.Messages;
import org.talend.designer.codegen.ITalendSynchronizer;

public class Camel_headerJava
{
  protected static String nl;
  public static synchronized Camel_headerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Camel_headerJava result = new Camel_headerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\tprivate String propertyToString(Object obj){" + NL + "\t\t\t\tif(obj!=null && obj instanceof java.util.Date){" + NL + "\t\t\t\t\treturn String.format(\"yyyy-MM-dd HH:mm:ss;%tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\",obj);" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\treturn String.valueOf(obj);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_2 = NL + "\t\t\t\tprivate org.apache.camel.component.mail.MailEndpoint getMailEndpoint(" + NL + "\t\t\t\t\t\tString uri, String username, String password, String subject, " + NL + "\t\t\t\t\t\tString from, String to, String cc, String bcc) {" + NL + "\t\t\t\t\torg.apache.camel.component.mail.MailEndpoint endpoint = (org.apache.camel.component.mail.MailEndpoint) endpoint(uri);" + NL + "\t\t\t\t\torg.apache.camel.component.mail.MailConfiguration configuration = endpoint.getConfiguration();" + NL + "\t\t\t\t\tconfiguration.setUsername(username);" + NL + "\t\t\t\t\tconfiguration.setPassword(password);" + NL + "\t\t\t\t\tconfiguration.setSubject(subject);" + NL + "\t\t\t\t\tif(null != from && !\"\".equals(from)){" + NL + "\t\t\t\t\t\tconfiguration.setFrom(from);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(null != to && !\"\".equals(to)){" + NL + "\t\t\t\t\t\tconfiguration.setTo(to);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(null != cc && !\"\".equals(cc)){" + NL + "\t\t\t\t\t\tconfiguration.setCC(cc);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif(null != bcc && !\"\".equals(bcc)){" + NL + "\t\t\t\t\t\tconfiguration.setBCC(bcc);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn endpoint;" + NL + "\t\t\t\t}";
  protected final String TEXT_3 = NL + "\t\t\tprivate org.apache.camel.component.file.remote.RemoteFileEndpoint<?> getFtpEndpoint(" + NL + "\t\t\t\t\tString uri, String server, String username, String password," + NL + "\t\t\t\t\tString directory) {" + NL + "\t\t\t\torg.apache.camel.component.file.remote.RemoteFileEndpoint<?> endpoint;" + NL + "\t\t\t\tendpoint = (org.apache.camel.component.file.remote.RemoteFileEndpoint<?>) endpoint(uri);" + NL + "\t\t\t\torg.apache.camel.component.file.remote.RemoteFileConfiguration configuration = endpoint" + NL + "\t\t\t\t\t\t.getConfiguration();" + NL + "\t\t\t\tconfiguration.setUsername(username);" + NL + "\t\t\t\tconfiguration.setPassword(password);" + NL + "\t\t\t\tconfiguration.setHost(server);" + NL + "\t\t\t\tconfiguration.setDirectory(directory);" + NL + "\t\t\t\treturn endpoint;" + NL + "\t\t\t}";
  protected final String TEXT_4 = NL + "\t\t\tprivate org.apache.camel.component.cxf.CxfEndpoint getCxfEndpoint(String uri, boolean isProvider, String... token){" + NL + "\t\t\t\torg.apache.camel.component.cxf.CxfEndpoint cxfEndpoint = (org.apache.camel.component.cxf.CxfEndpoint)endpoint(uri);" + NL + "\t\t\t\tif( null != bundleContext ){" + NL + "\t\t\t\t\torg.apache.cxf.Bus bus = cxfEndpoint.getBus();" + NL + "\t\t\t        org.apache.cxf.configuration.ConfiguredBeanLocator cbl = bus==null?null:bus.getExtension(org.apache.cxf.configuration.ConfiguredBeanLocator.class);" + NL + "\t\t\t        if(cbl != null){" + NL + "\t\t\t             bus.setExtension(new org.apache.cxf.bus.osgi.OSGiBeanLocator(cbl, bundleContext), org.apache.cxf.configuration.ConfiguredBeanLocator.class);" + NL + "\t\t\t        }";
  protected final String TEXT_5 = "\t\t\t        " + NL + "\t\t\t\t        if(isProvider&&token!=null&&\"UsernameToken\".equals(token[0])){" + NL + "\t\t\t\t        \taddUsernameToken(cxfEndpoint,bus, true);" + NL + "\t\t\t\t        } ";
  protected final String TEXT_6 = NL + "\t\t\t\t\t\tif(isProvider&&token!=null &&" + NL + "\t\t\t\t\t\t\t(org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_BASIC.equals(token[0])" + NL + "\t\t\t\t\t\t\t\t||org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_DIGEST.equals(token[0]))){" + NL + "\t\t\t\t\t\t\taddHttpAuth(cxfEndpoint, isProvider, token);" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_7 = NL + "\t\t\t        if(token!=null&&\"SAMLToken\".equals(token[0])){" + NL + "\t\t\t        \taddSAMLToken(cxfEndpoint, bus, isProvider, token);" + NL + "\t\t\t        }";
  protected final String TEXT_8 = NL + "\t\t\t\t}";
  protected final String TEXT_9 = NL + "\t\t\t\tif(!isProvider&&token!=null&&token.length>=3&&\"UsernameToken\".equals(token[0])){" + NL + "\t\t        \taddUsernameToken(cxfEndpoint, null, false, token[1], token[2]);" + NL + "\t\t        }";
  protected final String TEXT_10 = NL + "\t\t\t\t\tif(!isProvider&&token!=null &&" + NL + "\t\t\t\t\t\t\t(org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_BASIC.equals(token[0])" + NL + "\t\t\t\t\t\t\t\t\t||org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_DIGEST.equals(token[0]))){" + NL + "\t\t\t\t\t\taddHttpAuth(cxfEndpoint, isProvider, token);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_11 = NL + "\t\t\t\t" + NL + "\t\t\t\treturn cxfEndpoint;" + NL + "\t\t\t}";
  protected final String TEXT_12 = NL + "\t\t\tprivate void addHttpAuth(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint, boolean isProvider, final String... userInfo){";
  protected final String TEXT_13 = NL + "\t\t\t\t\tif(!isProvider){" + NL + "\t\t\t\t\t\tMap <String, Object> myProperties = new HashMap<String, Object> ();" + NL + "\t\t\t\t\t\torg.apache.cxf.configuration.security.AuthorizationPolicy authorizationPolicy = new org.apache.cxf.configuration.security.AuthorizationPolicy();" + NL + "\t\t\t\t\t\tauthorizationPolicy.setUserName(userInfo[1]);" + NL + "\t\t\t\t\t\tauthorizationPolicy.setPassword(userInfo[2]);" + NL + "\t\t\t\t\t\tauthorizationPolicy.setAuthorizationType(userInfo[0]);" + NL + "\t\t\t\t\t\tmyProperties.put(org.apache.cxf.configuration.security.AuthorizationPolicy.class.getName(), authorizationPolicy); " + NL + "\t\t\t\t\t\tcxfEndpoint.setProperties(myProperties);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_14 = NL + "\t\t\t\t\tif(isProvider){" + NL + "\t\t\t\t\t\torg.apache.cxf.interceptor.security.JAASLoginInterceptor jaasLoginInterceptor = new org.apache.cxf.interceptor.security.JAASLoginInterceptor();" + NL + "\t\t\t\t\t\tjaasLoginInterceptor.setContextName(\"karaf\");" + NL + "\t\t\t\t\t\tcxfEndpoint.getInInterceptors().add(jaasLoginInterceptor);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_15 = NL + "\t\t\t}";
  protected final String TEXT_16 = "\t\t\t" + NL + "\t\t\tprivate void addUsernameToken(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint, " + NL + "\t\t\t\t\torg.apache.cxf.Bus bus, boolean isProvider, final String... userInfo){";
  protected final String TEXT_17 = NL + "\t\t\t\tif(isProvider){" + NL + "\t\t\t        Map<String, Object> props = new HashMap<String, Object>();" + NL + "\t\t\t\t\tprops.put(org.apache.ws.security.handler.WSHandlerConstants.ACTION, org.apache.ws.security.handler.WSHandlerConstants.USERNAME_TOKEN);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.apache.cxf.ws.security.wss4j.WSS4JInInterceptor wss4jInInterceptor = new org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor();" + NL + "\t\t\t\t\twss4jInInterceptor.setProperties(props);" + NL + "\t\t\t\t\tcxfEndpoint.getInInterceptors().add(wss4jInInterceptor);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.apache.ws.security.validate.JAASUsernameTokenValidator validator = new org.apache.ws.security.validate.JAASUsernameTokenValidator();" + NL + "\t\t\t\t\tvalidator.setContextName(\"karaf\");" + NL + "\t\t\t\t\tMap<String,Object> map = new HashMap<String, Object>();" + NL + "\t\t\t\t\tmap.put(\"ws-security.ut.validator\", validator);" + NL + "\t\t\t\t\tcxfEndpoint.setProperties(map);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.apache.neethi.PolicyReference policyReference = new org.apache.neethi.PolicyReference();" + NL + "\t\t\t\t\tpolicyReference.setURI(\"org.talend.esb.job.token.policy\");" + NL + "\t\t\t\t\torg.apache.neethi.Policy policy = new org.apache.neethi.Policy();" + NL + "\t\t\t\t\tpolicy.addPolicyComponent(policyReference);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.apache.cxf.ws.policy.WSPolicyFeature wsPolicyFeature = new org.apache.cxf.ws.policy.WSPolicyFeature();" + NL + "\t\t\t\t\twsPolicyFeature.getPolicies().add(policy);" + NL + "\t\t\t\t\tbus.getFeatures().add(wsPolicyFeature);" + NL + "\t\t\t\t}";
  protected final String TEXT_18 = NL + "\t\t\t\tif(!isProvider){" + NL + "\t\t\t\t\tjavax.security.auth.callback.CallbackHandler c = new javax.security.auth.callback.CallbackHandler() {" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tpublic void handle(javax.security.auth.callback.Callback[] arg0) throws java.io.IOException," + NL + "\t\t\t\t\t\tjavax.security.auth.callback.UnsupportedCallbackException {" + NL + "\t\t\t\t\t\t\torg.apache.ws.security.WSPasswordCallback callback = (org.apache.ws.security.WSPasswordCallback) arg0[0];" + NL + "\t\t\t\t\t\t\tcallback.setPassword(userInfo[1]);" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t};" + NL + "" + NL + "\t\t\t\t\tMap<String, Object> props = new HashMap<String, Object>();" + NL + "\t\t\t\t\tprops.put(org.apache.ws.security.handler.WSHandlerConstants.ACTION, org.apache.ws.security.handler.WSHandlerConstants.USERNAME_TOKEN);" + NL + "\t\t\t\t\tprops.put(org.apache.ws.security.handler.WSHandlerConstants.USER, userInfo[0]);" + NL + "\t\t\t\t\tprops.put(org.apache.ws.security.handler.WSHandlerConstants.PASSWORD_TYPE, org.apache.ws.security.WSConstants.PW_TEXT);" + NL + "\t\t\t\t\tprops.put(org.apache.ws.security.handler.WSHandlerConstants.PW_CALLBACK_REF, c);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\torg.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor wss4jOutInterceptor = new org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor();" + NL + "\t\t\t\t\twss4jOutInterceptor.setProperties(props);" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tcxfEndpoint.getOutInterceptors().add(wss4jOutInterceptor);" + NL + "\t\t\t\t}";
  protected final String TEXT_19 = NL + "\t\t\t}";
  protected final String TEXT_20 = NL + NL + "private Map<String, String> clientProperties;" + NL + "" + NL + "private Map<String, String> stsProperties;" + NL + "\t" + NL + "public void setClientProperties(Map<String, String> clientProperties) {" + NL + "        this.clientProperties = clientProperties;" + NL + "}" + NL + "" + NL + "public void setStsProperties(Map<String, String> stsProperties) {" + NL + "        this.stsProperties = stsProperties;" + NL + "}" + NL + "" + NL + "" + NL + "class WSPasswordCallbackHandler implements javax.security.auth.callback.CallbackHandler {" + NL + "" + NL + "    private final String user;" + NL + "    private final String pass;" + NL + "" + NL + "    public WSPasswordCallbackHandler(String username, String password) {" + NL + "        user = username;" + NL + "        pass = password;" + NL + "    }" + NL + "" + NL + "    public void handle(javax.security.auth.callback.Callback[] callbacks) throws java.io.IOException," + NL + "    javax.security.auth.callback.UnsupportedCallbackException {" + NL + "        for (javax.security.auth.callback.Callback callback : callbacks) {" + NL + "            if (callback instanceof org.apache.ws.security.WSPasswordCallback) {" + NL + "            \torg.apache.ws.security.WSPasswordCallback pc = (org.apache.ws.security.WSPasswordCallback) callback;" + NL + "                if (user.equals(pc.getIdentifier())) {" + NL + "                    pc.setPassword(pass);" + NL + "                    break;" + NL + "                }" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "" + NL + "} " + NL;
  protected final String TEXT_21 = NL + "class CxfConsumerSoapHeaderFilter extends org.apache.camel.component.cxf.common.header.CxfHeaderFilterStrategy{" + NL + "\tpublic boolean applyFilterToCamelHeaders(String headerName," + NL + "\t\t\tObject headerValue, org.apache.camel.Exchange exchange) {" + NL + "\t\tif(org.apache.cxf.headers.Header.HEADER_LIST.equals(headerName)){" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\treturn super.applyFilterToCamelHeaders(headerName, headerValue, exchange);" + NL + "\t}" + NL + "" + NL + "\tpublic boolean applyFilterToExternalHeaders(String headerName," + NL + "\t\t\tObject headerValue, org.apache.camel.Exchange exchange) {" + NL + "\t\tif(org.apache.cxf.headers.Header.HEADER_LIST.equals(headerName)){" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\treturn super.applyFilterToExternalHeaders(headerName, headerValue, exchange);" + NL + "\t}" + NL + "}";
  protected final String TEXT_22 = NL + "private Map<String, String> samlProps;" + NL + "" + NL + "public void setSamlProps(Map<String, String> samlProps){" + NL + "\tthis.samlProps = samlProps;" + NL + "}";
  protected final String TEXT_23 = NL + NL + NL + "private Map<String, String> policies;" + NL + "" + NL + "public void setPolicies(Map<String, String> policies){" + NL + "\tthis.policies = policies;" + NL + "}" + NL + "" + NL + "private org.apache.neethi.Policy loadPolicy(String location, org.apache.cxf.Bus bus) {" + NL + "    java.io.InputStream is = null;" + NL + "    try {" + NL + "        is = new java.io.FileInputStream(location);" + NL + "        return bus.getExtension(org.apache.cxf.ws.policy.PolicyBuilder.class).getPolicy(is);" + NL + "    } catch (Exception e) {" + NL + "        throw new RuntimeException(\"Cannot load policy\", e);" + NL + "    } finally {" + NL + "        if (null != is) {" + NL + "            try {" + NL + "                is.close();" + NL + "            } catch (java.io.IOException e) {" + NL + "                // just ignore" + NL + "            }" + NL + "        }" + NL + "    }" + NL + "}" + NL + "public void registerPolicies(org.apache.cxf.Bus bus) {" + NL + "\tif(policies != null){" + NL + "        org.apache.neethi.PolicyRegistry policyRegistry =" + NL + "                bus.getExtension(org.apache.cxf.ws.policy.PolicyEngine.class).getRegistry();" + NL + "        policyRegistry.register(\"org.talend.esb.job.token.policy\"," + NL + "        \t\tloadPolicy(policies.get(\"policy.token\"), bus));" + NL + "        policyRegistry.register(\"org.talend.esb.job.saml.policy\"," + NL + "        \t\tloadPolicy(policies.get(\"policy.saml\"), bus));" + NL + "\t}" + NL + "}" + NL + "" + NL + "private void addSAMLToken(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint, org.apache.cxf.Bus bus," + NL + "\t\tboolean isProvider, String... token) {";
  protected final String TEXT_24 = NL + "\tif (!isProvider) {" + NL + "\t\torg.apache.cxf.ws.security.trust.STSClient stsClient = new org.apache.cxf.ws.security.trust.STSClient(" + NL + "\t\t\t\tbus);" + NL + "\t\tstsClient.setWsdlLocation(stsProperties.get(\"sts.wsdl.location\"));" + NL + "\t\tstsClient.setServiceQName(new javax.xml.namespace.QName(" + NL + "\t\t\t\tstsProperties.get(\"sts.namespace\"), stsProperties" + NL + "\t\t\t\t\t\t.get(\"sts.service.name\")));" + NL + "\t\tstsClient.setEndpointQName(new javax.xml.namespace.QName(" + NL + "\t\t\t\tstsProperties.get(\"sts.namespace\"), stsProperties" + NL + "\t\t\t\t\t\t.get(\"sts.endpoint.name\")));" + NL + "" + NL + "\t\tMap<String, Object> stsProps = new HashMap<String, Object>();" + NL + "" + NL + "\t\tfor (Map.Entry<String, String> entry : stsProperties.entrySet()) {" + NL + "\t\t\tif (org.apache.cxf.ws.security.SecurityConstants.ALL_PROPERTIES" + NL + "\t\t\t\t\t.contains(entry.getKey())) {" + NL + "\t\t\t\tstsProps.put(entry.getKey(), entry.getValue());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\tstsProps.put(org.apache.cxf.ws.security.SecurityConstants.USERNAME," + NL + "\t\t\t\ttoken[1]);" + NL + "\t\tstsProps.put(org.apache.cxf.ws.security.SecurityConstants.PASSWORD," + NL + "\t\t\t\ttoken[2]);" + NL + "\t\tstsClient.setProperties(stsProps);" + NL + "" + NL + "\t\tMap<String, Object> clientProps = new HashMap<String, Object>();" + NL + "\t\tclientProps.put(" + NL + "\t\t\t\torg.apache.cxf.ws.security.SecurityConstants.STS_CLIENT," + NL + "\t\t\t\tstsClient);" + NL + "" + NL + "\t\tfor (Map.Entry<String, String> entry : clientProperties.entrySet()) {" + NL + "\t\t\tif (org.apache.cxf.ws.security.SecurityConstants.ALL_PROPERTIES" + NL + "\t\t\t\t\t.contains(entry.getKey())) {" + NL + "\t\t\t\tclientProps.put(entry.getKey(), entry.getValue());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tclientProps" + NL + "\t\t\t\t.put(org.apache.cxf.ws.security.SecurityConstants.CALLBACK_HANDLER," + NL + "\t\t\t\t\t\tnew WSPasswordCallbackHandler(" + NL + "\t\t\t\t\t\t\t\tclientProperties" + NL + "\t\t\t\t\t\t\t\t\t\t.get(org.apache.cxf.ws.security.SecurityConstants.SIGNATURE_USERNAME)," + NL + "\t\t\t\t\t\t\t\tclientProperties" + NL + "\t\t\t\t\t\t\t\t\t\t.get(\"ws-security.signature.password\")));" + NL + "\t\t// set the cxfEndpoint Properties" + NL + "\t\tcxfEndpoint.setProperties(clientProps);" + NL + "" + NL + "\t\t// add policy" + NL + "\t\torg.apache.neethi.PolicyReference policyReference = new org.apache.neethi.PolicyReference();" + NL + "\t\tpolicyReference.setURI(\"org.talend.esb.job.saml.policy\");" + NL + "\t\torg.apache.neethi.Policy policy = new org.apache.neethi.Policy();" + NL + "\t\tpolicy.addPolicyComponent(policyReference);" + NL + "" + NL + "\t\torg.apache.cxf.ws.policy.WSPolicyFeature wsPolicyFeature = new org.apache.cxf.ws.policy.WSPolicyFeature();" + NL + "\t\twsPolicyFeature.getPolicies().add(policy);" + NL + "\t\tcxfEndpoint.getFeatures().add(wsPolicyFeature);" + NL + "\t\t// register bus with policy" + NL + "\t\tregisterPolicies(bus);" + NL + "\t}";
  protected final String TEXT_25 = NL + "if (isProvider) {" + NL + "\t\t// get saml properties" + NL + "\t\tString userName = (String) samlProps" + NL + "\t\t\t\t.get(\"ws-security.signature.username\");" + NL + "\t\tString password = (String) samlProps" + NL + "\t\t\t\t.get(\"ws-security.signature.password\");" + NL + "\t\tString properties = (String) samlProps" + NL + "\t\t\t\t.get(\"ws-security.signature.properties\");" + NL + "\t\t// add in intercept" + NL + "\t\tMap<String, Object> props = new HashMap<String, Object>();" + NL + "\t\tprops.put(" + NL + "\t\t\t\torg.apache.ws.security.handler.WSHandlerConstants.ACTION," + NL + "\t\t\t\torg.apache.ws.security.handler.WSHandlerConstants.SAML_TOKEN_SIGNED);" + NL + "\t\tprops.put(" + NL + "\t\t\t\torg.apache.ws.security.handler.WSHandlerConstants.SIG_PROP_FILE," + NL + "\t\t\t\tproperties);" + NL + "" + NL + "\t\torg.apache.cxf.ws.security.wss4j.PolicyBasedWSS4JInInterceptor wss4jInInterceptor = org.apache.cxf.ws.security.wss4j.PolicyBasedWSS4JInInterceptor.INSTANCE;" + NL + "\t\twss4jInInterceptor.setProperties(props);" + NL + "\t\tcxfEndpoint.getInInterceptors().add(wss4jInInterceptor);" + NL + "" + NL + "\t\t// set endpoint properties" + NL + "\t\torg.apache.cxf.interceptor.security.NamePasswordCallbackHandler callbackHandler = new org.apache.cxf.interceptor.security.NamePasswordCallbackHandler(" + NL + "\t\t\t\tuserName, password, \"setPassword\");" + NL + "\t\tMap<String, Object> endpointProps = new HashMap<String, Object>();" + NL + "\t\tendpointProps.put(\"ws-security.signature.username\", userName);" + NL + "\t\tendpointProps.put(\"ws-security.signature.properties\"," + NL + "\t\t\t\tproperties);" + NL + "\t\tendpointProps.put(\"ws-security.callback-handler\"," + NL + "\t\t\t\tcallbackHandler);" + NL + "\t\tcxfEndpoint.setProperties(endpointProps);" + NL + "\t\t// add policy" + NL + "\t\torg.apache.neethi.PolicyReference policyReference = new org.apache.neethi.PolicyReference();" + NL + "\t\tpolicyReference.setURI(\"org.talend.esb.job.saml.policy\");" + NL + "\t\torg.apache.neethi.Policy policy = new org.apache.neethi.Policy();" + NL + "\t\tpolicy.addPolicyComponent(policyReference);" + NL + "" + NL + "\t\torg.apache.cxf.ws.policy.WSPolicyFeature wsPolicyFeature = new org.apache.cxf.ws.policy.WSPolicyFeature();" + NL + "\t\twsPolicyFeature.getPolicies().add(policy);" + NL + "\t\tcxfEndpoint.getFeatures().add(wsPolicyFeature);" + NL + "\t\t// register policy on bus" + NL + "\t\tregisterPolicies(bus);" + NL + "}\t";
  protected final String TEXT_26 = NL + "}";
  protected final String TEXT_27 = NL + NL + "\t\t\t/*" + NL + "\t\t\t * on CXF_MESSAGE case (call a service)" + NL + "\t\t\t * if the response is fault, then will run into problem" + NL + "\t\t\t */" + NL + "\t\t\tprivate void addCXFMESSAGEFaultInterceptor(org.apache.camel.component.cxf.CxfEndpoint cxfEndpoint){" + NL + "\t\t\t\tcxfEndpoint.getBus().getInFaultInterceptors().add(new org.apache.cxf.interceptor.DocLiteralInInterceptor() {" + NL + "\t\t\t\t\t@Override" + NL + "\t\t\t\t\tpublic void handleMessage(org.apache.cxf.message.Message message) {" + NL + "\t\t\t\t\t\t// if has List content, then return" + NL + "\t\t\t\t\t\tif(message.getContent(java.util.List.class) != null){" + NL + "\t\t\t\t\t\t\treturn;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif (isFaultMessage(message)) {" + NL + "\t\t\t\t\t\t\torg.apache.cxf.message.Message inFaultMessage = message" + NL + "\t\t\t\t\t\t\t\t\t.getExchange().getInFaultMessage();" + NL + "\t\t\t\t\t\t\torg.apache.cxf.message.MessageContentsList parameters = new org.apache.cxf.message.MessageContentsList();" + NL + "\t\t\t\t\t\t\tif (inFaultMessage != null) {" + NL + "\t\t\t\t\t\t\t\torg.apache.cxf.staxutils.W3CDOMStreamWriter content = inFaultMessage" + NL + "\t\t\t\t\t\t\t\t\t\t.get(org.apache.cxf.staxutils.W3CDOMStreamWriter.class);" + NL + "\t\t\t\t\t\t\t\tparameters.add(content);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tmessage.setContent(java.util.List.class, parameters);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "" + NL + "\t\t\t\t\tprivate boolean isFaultMessage(org.apache.cxf.message.Message msg) {" + NL + "\t\t\t\t\t\tif (msg == null" + NL + "\t\t\t\t\t\t\t\t|| !(msg instanceof org.apache.cxf.binding.soap.SoapMessage)) {" + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\torg.apache.cxf.binding.soap.SoapMessage message = (org.apache.cxf.binding.soap.SoapMessage) msg;" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t//if it's not a CXF_MESSAGE, then return false" + NL + "\t\t\t\t\t\tObject dataFormat = message.getContextualProperty(org.apache.camel.component.cxf.common.message.CxfConstants.DATA_FORMAT_PROPERTY);" + NL + "\t\t\t\t\t\tif(org.apache.camel.component.cxf.DataFormat.CXF_MESSAGE != dataFormat){" + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tjavax.xml.stream.XMLStreamReader xmlReader = message" + NL + "\t\t\t\t\t\t\t\t.getContent(javax.xml.stream.XMLStreamReader.class);" + NL + "\t\t\t\t\t\tif (xmlReader == null) {" + NL + "\t\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tif (message.getVersion().getFault()" + NL + "\t\t\t\t\t\t\t\t.equals(xmlReader.getName())" + NL + "\t\t\t\t\t\t\t\t&& isRequestor(message)) {" + NL + "\t\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn false;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t\t\t}";
  protected final String TEXT_28 = NL + "\t\t\t/**" + NL + "\t\t\t* please initial uri map " + NL + "\t\t\t*/" + NL + "\t\t\tpublic void configure() throws java.lang.Exception {";
  protected final String TEXT_29 = NL + "\t\t\t\t// CXF endpoint for ";
  protected final String TEXT_30 = NL + "\t\t\t\torg.apache.camel.component.cxf.CxfEndpoint ";
  protected final String TEXT_31 = " = getCxfEndpoint(";
  protected final String TEXT_32 = ", ";
  protected final String TEXT_33 = ", ";
  protected final String TEXT_34 = "\t\t\t\t" + NL + "\t\t\t\t\t\t\t,";
  protected final String TEXT_35 = ",";
  protected final String TEXT_36 = NL + "\t\t\t\t\t\t);";
  protected final String TEXT_37 = NL + "\t\t\t\taddCXFMESSAGEFaultInterceptor(";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "\t\t\t\t// Add Service Locator Service to ";
  protected final String TEXT_40 = NL + "\t\t\t\tif (null != bundleContext) {" + NL + "\t\t\t\t\torg.talend.esb.servicelocator.cxf.LocatorFeature locatorFeature = new org.talend.esb.servicelocator.cxf.LocatorFeature();" + NL + "" + NL + "\t\t\t\t\t";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\tjava.util.Map<String, String> slCustomProps_";
  protected final String TEXT_42 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\t\t\t\tslCustomProps_";
  protected final String TEXT_44 = ".put(";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t\tlocatorFeature.setRequiredEndpointProperties(slCustomProps_";
  protected final String TEXT_49 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\t\tlocatorFeature.setAvailableEndpointProperties(slCustomProps_";
  protected final String TEXT_51 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\t";
  protected final String TEXT_53 = NL + NL + "\t\t\t\t\t";
  protected final String TEXT_54 = ".getFeatures().add(locatorFeature);" + NL + "\t\t\t\t}";
  protected final String TEXT_55 = NL + "\t\t\t\t// Add Service Activity Monitor Service to ";
  protected final String TEXT_56 = NL + "\t\t\t\tif (eventFeature != null) {" + NL + "\t\t\t\t\t((org.apache.camel.component.cxf.CxfEndpoint)";
  protected final String TEXT_57 = ").getFeatures().add(eventFeature);" + NL + "\t\t\t\t}";
  protected final String TEXT_58 = NL + "\t\t\torg.apache.camel.component.file.remote.RemoteFileEndpoint<?> ";
  protected final String TEXT_59 = " =  getFtpEndpoint(";
  protected final String TEXT_60 = ", ";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ", ";
  protected final String TEXT_63 = ", ";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\t\t\torg.apache.camel.component.mail.MailEndpoint ";
  protected final String TEXT_66 = " =  getMailEndpoint(";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = ", ";
  protected final String TEXT_69 = ", ";
  protected final String TEXT_70 = ", ";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "\t\t\t\t\t\torg.apache.camel.spi.AggregationRepository repo_";
  protected final String TEXT_76 = " = new ";
  protected final String TEXT_77 = ";";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\torg.apache.camel.spi.RecoverableAggregationRepository repo_";
  protected final String TEXT_79 = " = new ";
  protected final String TEXT_80 = ";";
  protected final String TEXT_81 = NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_82 = ".setUseRecovery(true);" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_83 = ".setMaximumRedeliveries(";
  protected final String TEXT_84 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_85 = ".setDeadLetterUri(";
  protected final String TEXT_86 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_87 = ".setRecoveryInterval(";
  protected final String TEXT_88 = ");";
  protected final String TEXT_89 = NL + "\t\t\t\t\t\t\torg.apache.camel.component.hawtdb.HawtDBAggregationRepository repo_";
  protected final String TEXT_90 = " = new org.apache.camel.component.hawtdb.HawtDBAggregationRepository(\"";
  protected final String TEXT_91 = "\", ";
  protected final String TEXT_92 = ");";
  protected final String TEXT_93 = NL + "\t\t\t\t\t\t\torg.apache.camel.component.hawtdb.HawtDBAggregationRepository repo_";
  protected final String TEXT_94 = " = new org.apache.camel.component.hawtdb.HawtDBAggregationRepository(\"";
  protected final String TEXT_95 = "\");";
  protected final String TEXT_96 = NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_97 = ".setUseRecovery(true);" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_98 = ".setMaximumRedeliveries(";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_100 = ".setDeadLetterUri(";
  protected final String TEXT_101 = ");" + NL + "\t\t\t\t\t\t\trepo_";
  protected final String TEXT_102 = ".setRecoveryInterval(";
  protected final String TEXT_103 = ");";
  protected final String TEXT_104 = NL + "\t\t\t\tMap<String, String> ";
  protected final String TEXT_105 = "NSMap = new HashMap<String, String>();" + NL + "\t\t\t\t{";
  protected final String TEXT_106 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_107 = "NSMap.put(";
  protected final String TEXT_108 = ", ";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + "\t\t\t\t}";
  protected final String TEXT_111 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_112 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_113 = NL + "\t\t\t\t";
  protected final String TEXT_114 = "NSMap.put(";
  protected final String TEXT_115 = ", ";
  protected final String TEXT_116 = ");";
  protected final String TEXT_117 = NL + "\t\t}";
  protected final String TEXT_118 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_119 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_120 = NL + "\t\t\t\t";
  protected final String TEXT_121 = "NSMap.put(";
  protected final String TEXT_122 = ", ";
  protected final String TEXT_123 = ");";
  protected final String TEXT_124 = NL + "\t\t}";
  protected final String TEXT_125 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_126 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_127 = NL + "\t\t\t\t";
  protected final String TEXT_128 = "NSMap.put(";
  protected final String TEXT_129 = ", ";
  protected final String TEXT_130 = ");";
  protected final String TEXT_131 = NL + "\t\t}";
  protected final String TEXT_132 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_133 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_134 = NL + "\t\t\t\t";
  protected final String TEXT_135 = "NSMap.put(";
  protected final String TEXT_136 = ", ";
  protected final String TEXT_137 = ");";
  protected final String TEXT_138 = NL + "\t\t}";
  protected final String TEXT_139 = NL + "\t\tMap<String, String> ";
  protected final String TEXT_140 = "NSMap = new HashMap<String, String>();" + NL + "\t\t{";
  protected final String TEXT_141 = NL + "\t\t\t\t";
  protected final String TEXT_142 = "NSMap.put(";
  protected final String TEXT_143 = ", ";
  protected final String TEXT_144 = ");";
  protected final String TEXT_145 = NL + "\t\t}";
  protected final String TEXT_146 = NL + "\t\torg.apache.camel.Endpoint endpoint_";
  protected final String TEXT_147 = " = endpoint(\"talend:\"+ ";
  protected final String TEXT_148 = "+ \"?context=\" + ";
  protected final String TEXT_149 = "+\"&propagateHeader=";
  protected final String TEXT_150 = "\");";
  protected final String TEXT_151 = NL + "\t\t\torg.apache.camel.Endpoint endpoint_";
  protected final String TEXT_152 = " = endpoint(\"talend:\"+";
  protected final String TEXT_153 = ".class.getName()+\"?context=\"+\"";
  protected final String TEXT_154 = "&propagateHeader=";
  protected final String TEXT_155 = "\");";
  protected final String TEXT_156 = NL + "{" + NL + "        Map <String, String> propertiesMap = new HashMap<String, String>();  ";
  protected final String TEXT_157 = NL + "\t\t\t\tpropertiesMap.put(";
  protected final String TEXT_158 = ", propertyToString(";
  protected final String TEXT_159 = "));";
  protected final String TEXT_160 = NL + "        endpoint_";
  protected final String TEXT_161 = ".getCamelContext().setProperties(propertiesMap);" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	Vector v = (Vector) codeGenArgument.getArgument();
	IProcess process = (IProcess) v.get(0);
	String version = (String) v.get(1);

/*
	boolean startable = false;
	for (INode node : (List< ? extends INode>)process.getGraphicalNodes()) {
		Object value = node.getPropertyValue("STARTABLE");
		startable = value == null? false:(Boolean)value;
		if(startable){
			break;
		}
	}
*/
	boolean stats = codeGenArgument.isStatistics();


    stringBuffer.append(TEXT_1);
    
			List<? extends INode> cMailNodes = process.getNodesOfType("cMail");
			if(cMailNodes.size() > 0){

    stringBuffer.append(TEXT_2);
    
			}
			
			List<? extends INode> cFtpNodes = process.getNodesOfType("cFtp");
			if(cFtpNodes.size() > 0){

    stringBuffer.append(TEXT_3);
    
			}
			
			boolean hasCXFComponent = false;
			boolean hasCXFSamlTokenProvider = false;
			boolean hasCXFSamlTokenConsumer = false;
			boolean hasCXFUsernameTokenProvider = false;
			boolean hasCXFUsernameTokenConsumer = false;
			boolean hasCXFHTTPAuthConsumer = false;
			boolean hasCXFHTTPAuthProvider = false;
			boolean hasCXFComponentConsumer = false;
			boolean hasCXFComponentConsumerWithCXFMESSAGE = false;
			List<? extends INode> cxfNodes = process.getNodesOfType("cCXF");
			if( null != cxfNodes && cxfNodes.size() >0 ){
				hasCXFComponent = true;
				for(INode n: cxfNodes){
					String useSecurity = ElementParameterParser.getValue(n, "__ENABLE_SECURITY__");
					String formatType = ElementParameterParser.getValue(n, "__DATAFORMAT__");
					if("RAW".equals(formatType) || "CXF_MESSAGE".equals(formatType)){
						useSecurity = "false";
					}
					String securityType = ElementParameterParser.getValue(n, "__SECURITY_TYPE__");
					int incomingConnections = n.getIncomingConnections().size();
					if(!hasCXFComponentConsumer && incomingConnections>0){
						hasCXFComponentConsumer = true;
					}
					if(!hasCXFComponentConsumerWithCXFMESSAGE && incomingConnections>0 && "CXF_MESSAGE".equals(formatType)){
						hasCXFComponentConsumerWithCXFMESSAGE = true;
					}
					if("true".equals(useSecurity)){
						if("SAML".equals(securityType) && (!hasCXFSamlTokenProvider || !hasCXFSamlTokenConsumer)){
							if(incomingConnections == 0){
								hasCXFSamlTokenProvider = true;
							}else{
								hasCXFSamlTokenConsumer = true;
							}
						}else if("USER".equals(securityType) && (!hasCXFUsernameTokenProvider || !hasCXFUsernameTokenConsumer)){
							if(incomingConnections == 0){
								hasCXFUsernameTokenProvider = true;
							}else{
								hasCXFUsernameTokenConsumer = true;
							}
						}else if(("BASIC".equals(securityType)||"DIGEST".equals(securityType)) && (!hasCXFHTTPAuthProvider || !hasCXFHTTPAuthConsumer)){
							if(incomingConnections == 0){
								hasCXFHTTPAuthProvider = true;
							}else{
								hasCXFHTTPAuthConsumer = true;
							}
						}
					}
				}
			}
			
			if(hasCXFComponent){

    stringBuffer.append(TEXT_4);
    
					if(hasCXFUsernameTokenProvider){

    stringBuffer.append(TEXT_5);
    
					}
					if(hasCXFHTTPAuthProvider){

    stringBuffer.append(TEXT_6);
    
					}
					if(hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer){


    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    
				if(hasCXFUsernameTokenConsumer){

    stringBuffer.append(TEXT_9);
    
				}
				if(hasCXFHTTPAuthConsumer){

    stringBuffer.append(TEXT_10);
    
				}

    stringBuffer.append(TEXT_11);
    
			if(hasCXFHTTPAuthConsumer || hasCXFHTTPAuthProvider){

    stringBuffer.append(TEXT_12);
    
				if(hasCXFHTTPAuthConsumer){

    stringBuffer.append(TEXT_13);
    
				}
				if(hasCXFHTTPAuthProvider){

    stringBuffer.append(TEXT_14);
    
				}

    stringBuffer.append(TEXT_15);
    
			}
			if(hasCXFUsernameTokenConsumer || hasCXFUsernameTokenProvider){

    stringBuffer.append(TEXT_16);
    if(hasCXFUsernameTokenProvider){
    stringBuffer.append(TEXT_17);
    
}
if(hasCXFUsernameTokenConsumer){				

    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    
			}
			}
if(hasCXFSamlTokenConsumer){

    stringBuffer.append(TEXT_20);
    
}

if(hasCXFComponentConsumer){

    stringBuffer.append(TEXT_21);
    
}

if(hasCXFSamlTokenProvider){

    stringBuffer.append(TEXT_22);
    
}

if(hasCXFSamlTokenProvider || hasCXFSamlTokenConsumer){

    stringBuffer.append(TEXT_23);
    
if(hasCXFSamlTokenConsumer){

    stringBuffer.append(TEXT_24);
    
}
if(hasCXFSamlTokenProvider){

    stringBuffer.append(TEXT_25);
    
}

    stringBuffer.append(TEXT_26);
    
}
if(hasCXFComponentConsumerWithCXFMESSAGE){

    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    
	List< ? extends INode> processNodes = (List< ? extends INode>)process.getGraphicalNodes();
	for (INode node : processNodes) {
			if (!node.isActivate()) {
				continue;
			}
			String nodeComponentName = node.getComponent().getName();
	if("cCXF".equals(nodeComponentName)){
			IElementParameter param = node.getElementParameter("LABEL");
		   	String cid = node.getUniqueName();
		//  http://jira.talendforge.org/browse/TESB-5241
			/*
		   	 * change to use label + unique to make it unique but readable
		   	 */
			if(param != null && !"__UNIQUE_NAME__".equals(param.getValue())){
				cid = (String)param.getValue()+"_"+cid;	
			}
			String endpointVar = "endpoint_" + node.getUniqueName();
			String uriRef = "uriMap.get(\"" + cid + "\")";
			String formatType = ElementParameterParser.getValue(node, "__DATAFORMAT__");
			String useSecurity = ElementParameterParser.getValue(node, "__ENABLE_SECURITY__");
			if("RAW".equals(formatType) || "CXF_MESSAGE".equals(formatType)){
					useSecurity = "false";
			}
			String securityType = ElementParameterParser.getValue(node, "__SECURITY_TYPE__");
			String username = ElementParameterParser.getValue(node, "__USERNAME__");
			String password = ElementParameterParser.getValue(node, "__PASSWORD__");
			boolean isProvider = node.getIncomingConnections().size()>0?false:true;
			String securityToken = "(String[])null";
			if("true".equals(useSecurity)){
				if("USER".equals(securityType)){
					securityToken = "\"UsernameToken\"";
				}else if("SAML".equals(securityType)){
					securityToken = "\"SAMLToken\"";
				}else if("BASIC".equals(securityType)){
					securityToken = "org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_BASIC";
				}else if("DIGEST".equals(securityType)){
					securityToken = "org.apache.cxf.transport.http.auth.HttpAuthHeader.AUTH_TYPE_DIGEST";
				}
			}else{
				isProvider = false;
			}
			

    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(uriRef);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(isProvider);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(securityToken);
    
				if("true".equals(useSecurity) && !isProvider){

    stringBuffer.append(TEXT_34);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(password);
    
				}

    stringBuffer.append(TEXT_36);
    			
			if("CXF_MESSAGE".equals(formatType) && node.getIncomingConnections().size() > 0){

    stringBuffer.append(TEXT_37);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_38);
    			}
			String useSL = ElementParameterParser.getValue(node, "__ENABLE_SL__");
			String useSAM = ElementParameterParser.getValue(node, "__ENABLE_SAM__");
			if ("true".equals(useSL)) {
				List<Map<String, String>> customProperties = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SL_META_DATA__");

    stringBuffer.append(TEXT_39);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_40);
     if (!customProperties.isEmpty()) { 
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
     for (Map<String, String> custProp : customProperties) { 
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(custProp.get("NAME"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(custProp.get("VALUE"));
    stringBuffer.append(TEXT_46);
     } 
    
							boolean actAsConsumer = false;
							List<? extends IConnection> conns = node.getIncomingConnections();
							if (!conns.isEmpty()) {
								INode source = conns.get(0).getSource();
								if (!("cErrorHandler".equals(source.getComponent().getName())
										&& source.getIncomingConnections().isEmpty())) {
									actAsConsumer = true;
								}
							}

    stringBuffer.append(TEXT_47);
     if (actAsConsumer) { 
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
     } else { 
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
     } 
    stringBuffer.append(TEXT_52);
     } 
    stringBuffer.append(TEXT_53);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_54);
    
			}
			//http://jira.talendforge.org/browse/TESB-3850
			if ("true".equals(useSAM) && !"RAW".equals(formatType)) {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(endpointVar);
    stringBuffer.append(TEXT_57);
    
			}
	}else if("cFtp".equals(nodeComponentName)){
			String ftpEndpointVar = "ftp_" + node.getUniqueName();
			String cid = node.getUniqueName();
			IElementParameter labelParam = node.getElementParameter("LABEL");
			if(labelParam != null && !"__UNIQUE_NAME__".equals(labelParam.getValue())){
				cid = (String)labelParam.getValue()+"_"+cid;	
			}
			String uriRef = "uriMap.get(\"" + cid + "\")";
			
			String userName = ElementParameterParser.getValue(node, "__USERNAME__");
			if("".trim().equals(userName)){
				userName = null;
			}
			String password = ElementParameterParser.getValue(node, "__PASSWORD__");
			if("".trim().equals(password)){
				password = null;
			}
			String ftpServer = ElementParameterParser.getValue(node, "__SERVER__");
			String directory = ElementParameterParser.getValue(node, "__DIRECTORY__");
			if("".trim().equals(directory)){
				directory = null;
			}

    stringBuffer.append(TEXT_58);
    stringBuffer.append(ftpEndpointVar);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(uriRef);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(ftpServer);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(directory);
    stringBuffer.append(TEXT_64);
    	
	
	}else if("cMail".equals(nodeComponentName)){
			String mailEndpointVar = "mail_" + node.getUniqueName();
			String cid = node.getUniqueName();
			IElementParameter labelParam = node.getElementParameter("LABEL");
			if(labelParam != null && !"__UNIQUE_NAME__".equals(labelParam.getValue())){
				cid = (String)labelParam.getValue()+"_"+cid;	
			}
			String uriRef = "uriMap.get(\"" + cid + "\")";
			
			String userName = ElementParameterParser.getValue(node, "__USERNAME__");
			String password = ElementParameterParser.getValue(node, "__PASSWORD__");
			String subject = ElementParameterParser.getValue(node, "__SUBJECT__");
			String from = ElementParameterParser.getValue(node, "__FROM__");
			String to = ElementParameterParser.getValue(node, "__TO__");
			String cc = ElementParameterParser.getValue(node, "__CC__");
			String bcc = ElementParameterParser.getValue(node, "__BCC__");
		

    stringBuffer.append(TEXT_65);
    stringBuffer.append(mailEndpointVar);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(uriRef);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(userName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(subject);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(to);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cc);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(bcc);
    stringBuffer.append(TEXT_74);
    	}else if("cAggregate".equals(nodeComponentName)){
				boolean usePersistence = "true".equals(ElementParameterParser.getValue(node, "__USE_PERSISTENCE__"));
				String repository = ElementParameterParser.getValue(node, "__REPOSITORY__");
				if (usePersistence) {
					boolean useRecovery = "true".equals(ElementParameterParser.getValue(node, "__USE_RECOVERY__"));
					String recoveryInterval = ElementParameterParser.getValue(node, "__RECOVERY_INTERVAL__");
					String deadLetterUri = ElementParameterParser.getValue(node, "__DEAD_LETTER_URI__");
					String maximumRedeliveries = ElementParameterParser.getValue(node, "__MAXIMUM_REDELIVERIES__");

					if ("AGGREGATION".equals(repository)) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CUSTOM_REPOSITORY__") );
    stringBuffer.append(TEXT_77);
    
					} else if ("RECOVERABLE".equals(repository)) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CUSTOM_REPOSITORY__") );
    stringBuffer.append(TEXT_80);
    
						if (useRecovery) {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(maximumRedeliveries);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(deadLetterUri);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(recoveryInterval);
    stringBuffer.append(TEXT_88);
    
						}
					} else if ("HAWTDB".equals(repository)) {
						boolean usePersistentFile = "true".equals(ElementParameterParser.getValue(node, "__USE_PERSISTENT_FILE__"));
						String persistentFile = ElementParameterParser.getValue(node, "__PERSISTENT_FILENAME__");
						if (usePersistentFile) {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(persistentFile);
    stringBuffer.append(TEXT_92);
    
						} else {

    stringBuffer.append(TEXT_93);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_95);
    
						}
						if (useRecovery) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(maximumRedeliveries);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(deadLetterUri);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(recoveryInterval);
    stringBuffer.append(TEXT_103);
    
						}
					}
				}
				
				String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
				String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
				List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");
				if("xpath".equals(language)&&"true".equals(useNamespaces)){
					String cid = node.getUniqueName();
				

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
					for(Map<String, String> m: namespaceValues){
						String pre = m.get("PREFIX");
						String uri = m.get("URI");

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_109);
    
					}

    stringBuffer.append(TEXT_110);
    
				}
	}else if("cLoop".equals(nodeComponentName)){
		String type = ElementParameterParser.getValue(node, "__LOOP_TYPE__");
		if(!"EXPRESSION_TYPE".equals(type)){
			continue;
		}
		String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
		if(!"xpath".equals(language)){
			continue;
		}
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_116);
    
			}

    stringBuffer.append(TEXT_117);
    
		
	}else if("cMessageFilter".equals(nodeComponentName)){
		String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
		if(!"xpath".equals(language)){
			continue;
		}
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_123);
    
			}

    stringBuffer.append(TEXT_124);
    
	}else if("cRecipientList".equals(nodeComponentName)||"cSplitter".equals(nodeComponentName)){
		String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
		if(!"xpath".equals(language)){
			continue;
		}
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_130);
    
			}

    stringBuffer.append(TEXT_131);
    
	}else if("cSetBody".equals(nodeComponentName)){
		String language = ElementParameterParser.getValue(node, "__LANGUAGES__");
		if(!"xpath".equals(language)){
			continue;
		}
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_137);
    
			}

    stringBuffer.append(TEXT_138);
    
	}else if("cSetHeader".equals(nodeComponentName)){
		String useNamespaces = ElementParameterParser.getValue(node, "__USE_NAMESPACES__");
		if(!"true".equals(useNamespaces)){
			continue;
		}
		String cid = node.getUniqueName();
		List<Map<String, String>> namespaceValues = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__NAMESPACES__");

    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
			for(Map<String, String> m: namespaceValues){
				String pre = m.get("PREFIX");
				String uri = m.get("URI");

    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(pre);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_144);
    
			}

    stringBuffer.append(TEXT_145);
    
	}else if("cTalendJob".equals(nodeComponentName)){
    List< ? extends IConnection> conns = node.getIncomingConnections();
  	String cid = node.getUniqueName();
	List<Map<String, String>> contextParams = null;
    if(conns.size()>0) {
        String useJar = ElementParameterParser.getValue(node, "__FROM_EXTERNAL_JAR__");
        // when propagateHeader parameter will be removed the https://github.com/Talend/tesb-rt-se/blob/master/camel-talendjob/src/main/java/org/talend/camel/TalendProducer.java
        // have to be changed - remove populateTalendContextParamsWithCamelHeaders(exchange, args); 
        String propagateHeader = ElementParameterParser.getValue(node, "__PROPAGATE_HEADER__");
        if("true".equals(useJar)){
            String typeName = ElementParameterParser.getValue(node, "__JOB__");
            String context = ElementParameterParser.getValue(node, "__CONTEXT__");
            contextParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__EXTERNAL_JAR_CONTEXTPARAMS__");

    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(propagateHeader);
    stringBuffer.append(TEXT_150);
    
        }else{
           String typeName = "";
           contextParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__CONTEXTPARAMS__");
           String context = (String) node.getElementParameter("PROCESS_TYPE_CONTEXT").getValue();
           String id = (String) node.getElementParameter("PROCESS_TYPE_PROCESS").getValue();
           if(id != null){
        	   String useSelectedContext = ElementParameterParser.getValue(node, "__USE_SELECTED_CONTEXT__");
        	   String useRouteContext = ElementParameterParser.getValue(node, "__USE_ROUTE_CONTEXT__");
        	   String useJobContext = ElementParameterParser.getValue(node, "__USE_JOB_CONTEXT__");
        	   if("true".equals(useRouteContext)){
        		   context = ElementParameterParser.getProcessSelectedContext(process.getId()); // route context
        		   boolean found = ElementParameterParser.checkIfContextExisted(id, context); // check the same context exist or not in job
            	   if(!found){
            		   context = ElementParameterParser.getProcessSelectedContext(id); // if not found, then use default job context
            	   }
            	   
        	   }else if("true".equals(useJobContext)){
        		   context = ElementParameterParser.getProcessSelectedContext(id);
        	   }
        	   
	           String jobName = ElementParameterParser.getStringElementParameterValue(node.getElementParameter("SELECTED_JOB_NAME"));
//	           String jobName = (String) node.getElementParameter("SELECTED_JOB_NAME").getValue();
	           String jobVersion = ElementParameterParser.getStringElementParameterValue(node.getElementParameter("PROCESS_TYPE_VERSION"));
	           String jobFolderName = JavaResourcesHelper.getJobFolderName(jobName, jobVersion);
	           typeName = codeGenArgument.getCurrentProjectName().toLowerCase() + "." + jobFolderName + "." + jobName;
	        }

    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(typeName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(context);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(propagateHeader);
    stringBuffer.append(TEXT_155);
    
        }
        int contextParamsSize = contextParams.size();
        if(contextParamsSize > 0){

    stringBuffer.append(TEXT_156);
    
		for (int i=0; i<contextParamsSize; i++) {
				Map<String, String> contextParam = contextParams.get(i);
				String paramName;
				String paramValue;
		        if("true".equals(useJar)){
					paramName = contextParam.get("EXTERNAL_JAR_PARAM_NAME_COLUMN");
					paramValue = contextParam.get("EXTERNAL_JAR_PARAM_VALUE_COLUMN");
					
				} else {
					paramName = "\"" + contextParam.get("PARAM_NAME_COLUMN") + "\"";
					paramValue = contextParam.get("PARAM_VALUE_COLUMN");
				}

    stringBuffer.append(TEXT_157);
    stringBuffer.append(paramName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(paramValue);
    stringBuffer.append(TEXT_159);
    
		}

    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    
    }
	}
	}
}

    return stringBuffer.toString();
  }
}
