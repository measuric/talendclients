package org.talend.designer.codegen.translators.esb.rest;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TRESTClientMainJava
{
  protected static String nl;
  public static synchronized TRESTClientMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRESTClientMainJava result = new TRESTClientMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + NL + "try {" + NL + "\t// request body" + NL + "\torg.dom4j.Document requestDoc_";
  protected final String TEXT_4 = " = null;" + NL + "\tString requestString_";
  protected final String TEXT_5 = " = null;" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\tif (null != ";
  protected final String TEXT_7 = ".body) {" + NL + "\t\t\trequestDoc_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ".body.getDocument();" + NL + "\t\t}" + NL + "\t\trequestString_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ".string;" + NL + "\t";
  protected final String TEXT_12 = NL + NL + "\tObject requestBody_";
  protected final String TEXT_13 = " = requestDoc_";
  protected final String TEXT_14 = " != null ? requestDoc_";
  protected final String TEXT_15 = " : requestString_";
  protected final String TEXT_16 = ";" + NL + "" + NL + "\t// expected response body" + NL + "\tObject responseDoc_";
  protected final String TEXT_17 = " = null;" + NL + "\t";
  protected final String TEXT_18 = NL + "\tClass<?> responseClass_";
  protected final String TEXT_19 = " = ";
  protected final String TEXT_20 = "String.class";
  protected final String TEXT_21 = "org.dom4j.Document.class";
  protected final String TEXT_22 = ";" + NL + "" + NL + "\t// create web client instance" + NL + "\torg.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_";
  protected final String TEXT_23 = " =" + NL + "\t\tnew org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();" + NL + "\t";
  protected final String TEXT_24 = NL + "\t\tfactoryBean_";
  protected final String TEXT_25 = ".setUsername(";
  protected final String TEXT_26 = ");" + NL + "\t\tfactoryBean_";
  protected final String TEXT_27 = ".setPassword(";
  protected final String TEXT_28 = ");" + NL + "\t";
  protected final String TEXT_29 = NL + NL + "\tfinal java.util.List<org.apache.cxf.feature.AbstractFeature> features_";
  protected final String TEXT_30 = " =" + NL + "\t\t\tnew java.util.ArrayList<org.apache.cxf.feature.AbstractFeature>();" + NL + "" + NL + "\t";
  protected final String TEXT_31 = NL + "\t\tboolean inOSGi = false;" + NL + "\t\ttry {" + NL + "\t\t\tinOSGi = (null != factoryBean_";
  protected final String TEXT_32 = ".getBus().getExtension(Class.forName(\"org.osgi.framework.BundleContext\")));" + NL + "\t\t} catch (ClassNotFoundException e_";
  protected final String TEXT_33 = ") {" + NL + "\t\t\t; // ignore" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_34 = NL + NL + "\t";
  protected final String TEXT_35 = NL + "\t\tfactoryBean_";
  protected final String TEXT_36 = ".setAddress(\"locator://rest\");" + NL + "\t\tfactoryBean_";
  protected final String TEXT_37 = ".setServiceName(new javax.xml.namespace.QName(" + NL + "\t\t\t";
  protected final String TEXT_38 = "," + NL + "\t\t\t";
  protected final String TEXT_39 = "));" + NL + "" + NL + "\t\tif (!inOSGi) {" + NL + "\t\t\tfactoryBean_";
  protected final String TEXT_40 = ".setBus(new org.apache.cxf.bus.spring.SpringBusFactory().createBus(\"META-INF/tesb/locator/beans.xml\"));" + NL + "\t\t}" + NL + "" + NL + "\t\torg.talend.esb.servicelocator.cxf.LocatorFeature feature_";
  protected final String TEXT_41 = " =" + NL + "\t\t\t\tnew org.talend.esb.servicelocator.cxf.LocatorFeature();" + NL + "" + NL + "\t\t";
  protected final String TEXT_42 = NL + "\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\tfinal java.util.Map<String, String> slCustomProps_";
  protected final String TEXT_44 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t";
  protected final String TEXT_45 = NL + "\t\t\t\tslCustomProps_";
  protected final String TEXT_46 = ".put(";
  protected final String TEXT_47 = ", ";
  protected final String TEXT_48 = ");" + NL + "\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\tfeature_";
  protected final String TEXT_50 = ".setRequiredEndpointProperties(slCustomProps_";
  protected final String TEXT_51 = ");" + NL + "\t\t";
  protected final String TEXT_52 = NL + NL + "\t\tfeatures_";
  protected final String TEXT_53 = ".add(feature_";
  protected final String TEXT_54 = ");" + NL + "\t";
  protected final String TEXT_55 = NL + "\t\tString url = ";
  protected final String TEXT_56 = ";" + NL + "\t\t// {baseUri}tRESTClient" + NL + "\t\tfactoryBean_";
  protected final String TEXT_57 = ".setServiceName(new javax.xml.namespace.QName(url, \"tRESTClient\"));" + NL + "\t\tfactoryBean_";
  protected final String TEXT_58 = ".setAddress(url);" + NL + "\t";
  protected final String TEXT_59 = NL + NL + "\t";
  protected final String TEXT_60 = NL + "\t\torg.talend.esb.sam.agent.feature.EventFeature samEventFeature = null;" + NL + "\t\tif (null == eventFeature) {" + NL + "\t\t\torg.springframework.context.support.ClassPathXmlApplicationContext context = null;" + NL + "\t\t//\tif (inOSGi) {" + NL + "\t\t//\t\tcontext = new org.springframework.context.support.ClassPathXmlApplicationContext(\"META-INF/tesb/agent-osgi.xml\");" + NL + "\t\t//\t} else {" + NL + "\t\t\t\tcontext = new org.springframework.context.support.ClassPathXmlApplicationContext(\"META-INF/tesb/agent-context.xml\");" + NL + "\t\t//\t}" + NL + "\t\t\tsamEventFeature = context.getBean(org.talend.esb.sam.agent.feature.EventFeature.class);" + NL + "\t\t} else {" + NL + "\t\t\tsamEventFeature = (org.talend.esb.sam.agent.feature.EventFeature) eventFeature;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_61 = NL + "\t\t";
  protected final String TEXT_62 = NL + "\t\t\torg.talend.esb.sam.common.handler.impl.CustomInfoHandler ciHandler = new org.talend.esb.sam.common.handler.impl.CustomInfoHandler();" + NL + "\t\t\tjava.util.Map<String, String> samCustomProps_";
  protected final String TEXT_63 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t";
  protected final String TEXT_64 = NL + "\t\t\t\tsamCustomProps_";
  protected final String TEXT_65 = ".put(";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ");" + NL + "\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\tciHandler.setCustomInfo(samCustomProps_";
  protected final String TEXT_69 = ");" + NL + "\t\t\tsamEventFeature.setHandler(ciHandler);" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\tfeatures_";
  protected final String TEXT_71 = ".add(samEventFeature);" + NL + "\t";
  protected final String TEXT_72 = NL + NL + "\t";
  protected final String TEXT_73 = NL + "\t\tfeatures_";
  protected final String TEXT_74 = ".add(new org.apache.cxf.feature.LoggingFeature());" + NL + "\t";
  protected final String TEXT_75 = NL + NL + "\tfactoryBean_";
  protected final String TEXT_76 = ".setFeatures(features_";
  protected final String TEXT_77 = ");" + NL + "" + NL + "" + NL + "\tjava.util.List<Object> providers_";
  protected final String TEXT_78 = " = new java.util.ArrayList<Object>();" + NL + "\tproviders_";
  protected final String TEXT_79 = ".add(new org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider() {" + NL + "\t\t// workaround for https://jira.talendforge.org/browse/TESB-7276" + NL + "\t\tpublic org.dom4j.Document readFrom(Class<org.dom4j.Document> cls," + NL + "\t\t\t\t\t\t\t\t\t\t\tjava.lang.reflect.Type type," + NL + "\t\t\t\t\t\t\t\t\t\t\tjava.lang.annotation.Annotation[] anns," + NL + "\t\t\t\t\t\t\t\t\t\t\tjavax.ws.rs.core.MediaType mt," + NL + "\t\t\t\t\t\t\t\t\t\t\tjavax.ws.rs.core.MultivaluedMap<String, String> headers," + NL + "\t\t\t\t\t\t\t\t\t\t\tjava.io.InputStream is)" + NL + "\t\t\t\tthrows IOException, javax.ws.rs.WebApplicationException {" + NL + "\t\t\tString contentLength = headers.getFirst(\"Content-Length\");" + NL + "\t\t\tif (!org.apache.cxf.common.util.StringUtils.isEmpty(contentLength)" + NL + "\t\t\t\t&& Integer.valueOf(contentLength) <= 0) {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\treturn org.dom4j.DocumentHelper.parseText(\"<root/>\");" + NL + "\t\t\t\t} catch (org.dom4j.DocumentException e_";
  protected final String TEXT_80 = ") {" + NL + "\t\t\t\t\te_";
  protected final String TEXT_81 = ".printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn super.readFrom(cls, type, anns, mt, headers, is);" + NL + "\t\t}" + NL + "\t});" + NL + "\torg.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_";
  protected final String TEXT_82 = " =" + NL + "\t\t\tnew org.apache.cxf.jaxrs.provider.json.JSONProvider();" + NL + "\t\tjsonProvider_";
  protected final String TEXT_83 = ".setIgnoreNamespaces(true);" + NL + "\t\tjsonProvider_";
  protected final String TEXT_84 = ".setAttributesToElements(true);" + NL + "\t";
  protected final String TEXT_85 = NL + "\t";
  protected final String TEXT_86 = NL + "\t\tjsonProvider_";
  protected final String TEXT_87 = ".setSupportUnwrapped(true);" + NL + "\t\tjsonProvider_";
  protected final String TEXT_88 = ".setWrapperName(\"root\");" + NL + "\t";
  protected final String TEXT_89 = NL + "\t";
  protected final String TEXT_90 = NL + "\t\tjsonProvider_";
  protected final String TEXT_91 = ".setDropRootElement(";
  protected final String TEXT_92 = ");" + NL + "\tproviders_";
  protected final String TEXT_93 = ".add(jsonProvider_";
  protected final String TEXT_94 = ");" + NL + "\tfactoryBean_";
  protected final String TEXT_95 = ".setProviders(providers_";
  protected final String TEXT_96 = ");" + NL + "\tfactoryBean_";
  protected final String TEXT_97 = ".setTransportId(\"http://cxf.apache.org/transports/http\");" + NL + "" + NL + "\torg.apache.cxf.jaxrs.client.WebClient webClient_";
  protected final String TEXT_98 = " = factoryBean_";
  protected final String TEXT_99 = ".createWebClient();" + NL + "" + NL + "\t// set request path" + NL + "\twebClient_";
  protected final String TEXT_100 = ".path(";
  protected final String TEXT_101 = ");" + NL + "" + NL + "\t// set connection properties" + NL + "\torg.apache.cxf.transport.http.HTTPConduit conduit_";
  protected final String TEXT_102 = " =" + NL + "\torg.apache.cxf.jaxrs.client.WebClient.getConfig(webClient_";
  protected final String TEXT_103 = ").getHttpConduit();" + NL + "\tconduit_";
  protected final String TEXT_104 = ".getClient().setReceiveTimeout((long)(";
  protected final String TEXT_105 = " * 1000));" + NL + "\tconduit_";
  protected final String TEXT_106 = ".getClient().setConnectionTimeout((long)(";
  protected final String TEXT_107 = " * 1000));" + NL + "\t";
  protected final String TEXT_108 = NL + "\t\tconduit_";
  protected final String TEXT_109 = ".getClient().setProxyServer(";
  protected final String TEXT_110 = ");" + NL + "\t\tconduit_";
  protected final String TEXT_111 = ".getClient().setProxyServerPort(Integer.valueOf(";
  protected final String TEXT_112 = "));" + NL + "\t\tconduit_";
  protected final String TEXT_113 = ".getProxyAuthorization().setUserName(";
  protected final String TEXT_114 = ");" + NL + "\t\tconduit_";
  protected final String TEXT_115 = ".getProxyAuthorization().setPassword(";
  protected final String TEXT_116 = ");" + NL + "\t";
  protected final String TEXT_117 = NL + NL + "\t// set Content-Type" + NL + "\t";
  protected final String TEXT_118 = NL + "\t\twebClient_";
  protected final String TEXT_119 = ".type(\"";
  protected final String TEXT_120 = "\");" + NL + "\t";
  protected final String TEXT_121 = NL + "\t// set Accept-Type" + NL + "\t";
  protected final String TEXT_122 = NL + "\t\twebClient_";
  protected final String TEXT_123 = ".accept(\"";
  protected final String TEXT_124 = "\");" + NL + "\t";
  protected final String TEXT_125 = NL + NL + "\t// set optional query and header properties if any" + NL + "\t";
  protected final String TEXT_126 = NL + "\t\twebClient_";
  protected final String TEXT_127 = ".header(";
  protected final String TEXT_128 = " ,";
  protected final String TEXT_129 = ");" + NL + "\t";
  protected final String TEXT_130 = NL + NL + "\t// if FORM request then capture query parameters into Form, otherwise set them as queries" + NL + "\t";
  protected final String TEXT_131 = NL + "\t\torg.apache.cxf.jaxrs.ext.form.Form form_";
  protected final String TEXT_132 = " = new org.apache.cxf.jaxrs.ext.form.Form();" + NL + "\t\t";
  protected final String TEXT_133 = NL + "\t\t\tform_";
  protected final String TEXT_134 = ".set(";
  protected final String TEXT_135 = " ,";
  protected final String TEXT_136 = ");" + NL + "\t\t";
  protected final String TEXT_137 = NL + "\t\trequestBody_";
  protected final String TEXT_138 = " = form_";
  protected final String TEXT_139 = ";" + NL + "\t";
  protected final String TEXT_140 = NL + "\t\t";
  protected final String TEXT_141 = NL + "\t\t\twebClient_";
  protected final String TEXT_142 = ".query(";
  protected final String TEXT_143 = " ,";
  protected final String TEXT_144 = ");" + NL + "\t\t";
  protected final String TEXT_145 = NL + "\t";
  protected final String TEXT_146 = NL + NL + NL + "\ttry {" + NL + "\t\t// start send request" + NL + "\t\t";
  protected final String TEXT_147 = NL + "\t\t\tresponseDoc_";
  protected final String TEXT_148 = " = webClient_";
  protected final String TEXT_149 = ".get(responseClass_";
  protected final String TEXT_150 = ");" + NL + "\t\t";
  protected final String TEXT_151 = NL + "\t\t\tresponseDoc_";
  protected final String TEXT_152 = " = webClient_";
  protected final String TEXT_153 = ".post(requestBody_";
  protected final String TEXT_154 = ", responseClass_";
  protected final String TEXT_155 = ");" + NL + "\t\t";
  protected final String TEXT_156 = NL + "\t\t\tresponseDoc_";
  protected final String TEXT_157 = " = webClient_";
  protected final String TEXT_158 = ".put(requestBody_";
  protected final String TEXT_159 = ", responseClass_";
  protected final String TEXT_160 = ");" + NL + "\t\t";
  protected final String TEXT_161 = NL + "\t\t\twebClient_";
  protected final String TEXT_162 = ".invoke(\"";
  protected final String TEXT_163 = "\", requestBody_";
  protected final String TEXT_164 = ");" + NL + "\t\t";
  protected final String TEXT_165 = NL + NL + NL + "\t\tint webClientResponseStatus_";
  protected final String TEXT_166 = " = webClient_";
  protected final String TEXT_167 = ".getResponse().getStatus();" + NL + "\t\tif (webClientResponseStatus_";
  protected final String TEXT_168 = " >= 300) {" + NL + "\t\t\tthrow new javax.ws.rs.WebApplicationException(webClient_";
  protected final String TEXT_169 = ".getResponse());" + NL + "\t\t}" + NL + "" + NL + "\t\t";
  protected final String TEXT_170 = NL + "\t\t\tif (";
  protected final String TEXT_171 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_172 = " = new ";
  protected final String TEXT_173 = "Struct();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_174 = ".statusCode = webClientResponseStatus_";
  protected final String TEXT_175 = ";" + NL + "\t\t\tif (responseDoc_";
  protected final String TEXT_176 = " != null) {" + NL + "\t\t\t\tif (responseClass_";
  protected final String TEXT_177 = " == String.class) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_178 = ".string = (String) responseDoc_";
  protected final String TEXT_179 = ";" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\troutines.system.Document responseTalendDoc_";
  protected final String TEXT_180 = " = null;" + NL + "\t\t\t\t\tif (null != responseDoc_";
  protected final String TEXT_181 = ") {" + NL + "\t\t\t\t\t\tresponseTalendDoc_";
  protected final String TEXT_182 = " = new routines.system.Document();" + NL + "\t\t\t\t\t\tresponseTalendDoc_";
  protected final String TEXT_183 = ".setDocument((org.dom4j.Document) responseDoc_";
  protected final String TEXT_184 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_185 = ".body = responseTalendDoc_";
  protected final String TEXT_186 = ";" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_187 = NL + NL + "\t} catch (javax.ws.rs.WebApplicationException ex_";
  protected final String TEXT_188 = ") {" + NL + "\t\t";
  protected final String TEXT_189 = NL + "\t\t\tif (";
  protected final String TEXT_190 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_191 = " = new ";
  protected final String TEXT_192 = "Struct();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_193 = ".errorCode = ex_";
  protected final String TEXT_194 = ".getResponse().getStatus();" + NL + "" + NL + "\t\t\tString errorMessage_";
  protected final String TEXT_195 = " = ex_";
  protected final String TEXT_196 = ".getMessage();" + NL + "\t\t\tif (null == errorMessage_";
  protected final String TEXT_197 = " || 0 == errorMessage_";
  protected final String TEXT_198 = ".trim().length()) {" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\terrorMessage_";
  protected final String TEXT_199 = " = ex_";
  protected final String TEXT_200 = ".getResponse().readEntity(String.class);" + NL + "\t\t\t\t} catch (Exception exe_";
  protected final String TEXT_201 = ") {" + NL + "\t\t\t\t\t// ignore" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_202 = ".errorMessage = errorMessage_";
  protected final String TEXT_203 = ";" + NL + "\t\t";
  protected final String TEXT_204 = NL + "\t\t\tthrow ex_";
  protected final String TEXT_205 = ";" + NL + "\t\t";
  protected final String TEXT_206 = NL + "\t}" + NL + "" + NL + "} catch(Exception e_";
  protected final String TEXT_207 = ") {" + NL + "\t";
  protected final String TEXT_208 = NL + "\t\tthrow new TalendException(e_";
  protected final String TEXT_209 = ", currentComponent, globalMap);" + NL + "\t";
  protected final String TEXT_210 = NL + "\t\tnew TalendException(e_";
  protected final String TEXT_211 = ", currentComponent, globalMap).printStackTrace();" + NL + "\t";
  protected final String TEXT_212 = NL + "}";
  protected final String TEXT_213 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();


IConnection inputConn = null;
List<? extends IConnection> incomingConnections = node.getIncomingConnections();
if (incomingConnections != null && !incomingConnections.isEmpty()) {
	for (IConnection conn : incomingConnections) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			inputConn = conn;
			break;
		}
	}
}

List<? extends IConnection> conns = node.getOutgoingSortedConnections();
if (conns != null && conns.size() > 0) {
	for (int i = 0; i < conns.size(); i++) {
		IConnection conn = conns.get(i);
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_2);
    
		}
	}
}

List<? extends IConnection> connsResponse = node.getOutgoingConnections("RESPONSE");
List<? extends IConnection> connsFault = node.getOutgoingConnections("FAULT");
IConnection connResponse = (connsResponse.size() == 1) ? connsResponse.get(0) : null;
IConnection connFault = (connsFault.size() == 1) ? connsFault.get(0) : null;



String method = ElementParameterParser.getValue(node,"__METHOD__");

String acceptType = ElementParameterParser.getValue(node,"__ACCEPT_TYPE__");
if (acceptType == null) {
	acceptType = "application/xml";
}

String contentType = ElementParameterParser.getValue(node,"__CONTENT_TYPE__");
if (contentType == null) {
	contentType = "application/xml";
}

boolean isSLEnable = Boolean.valueOf(ElementParameterParser.getValue(node,"__SERVICE_LOCATOR__"));
boolean isSAMEnable = Boolean.valueOf(ElementParameterParser.getValue(node,"__SERVICE_ACTIVITY_MONITOR__"));

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
     if (null != inputConn) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
		String convertResponseToDomProperty = ElementParameterParser.getValue(node,"__CONVERT_RESPONSE_TO_DOM__");
		boolean convertResponseToDom = convertResponseToDomProperty == null ? true : Boolean.valueOf(convertResponseToDomProperty);
	
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
     if ("*/*".equals(acceptType) || !convertResponseToDom) { 
    stringBuffer.append(TEXT_20);
     } else { 
    stringBuffer.append(TEXT_21);
     } 
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
     if (Boolean.valueOf(ElementParameterParser.getValue(node,"__NEED_AUTH__"))) { 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(ElementParameterParser.getValue(node,"__AUTH_USERNAME__"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(ElementParameterParser.getValue(node,"__AUTH_PASSWORD__"));
    stringBuffer.append(TEXT_28);
     } 
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
     if (isSLEnable || isSAMEnable) { 
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
     } 
    stringBuffer.append(TEXT_34);
     if (isSLEnable) { 
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(ElementParameterParser.getValue(node,"__SERVICE_NAMESPACE__"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(ElementParameterParser.getValue(node,"__SERVICE_NAME__"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
     List<Map<String, String>> customProperties = (List<Map<String,String>>)
				ElementParameterParser.getObjectValue(node, "__SERVICE_LOCATOR_CUSTOM_PROPERTIES__"); 
    stringBuffer.append(TEXT_42);
     if (!customProperties.isEmpty()) { 
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
     for (int k = 0; k < customProperties.size(); k++) { 
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(customProperties.get(k).get("PROP_NAME"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(customProperties.get(k).get("PROP_VALUE"));
    stringBuffer.append(TEXT_48);
     } 
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
     } 
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
     } else { 
    stringBuffer.append(TEXT_55);
    stringBuffer.append(ElementParameterParser.getValue(node,"__URL__"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
     } 
    stringBuffer.append(TEXT_59);
     if (isSAMEnable) { 
    stringBuffer.append(TEXT_60);
     List<Map<String, String>> samCustomProperties = (List<Map<String,String>>)
				ElementParameterParser.getObjectValue(node, "__SERVICE_ACTIVITY_MONITOR_CUSTOM_PROPERTIES__"); 
    stringBuffer.append(TEXT_61);
     if (!samCustomProperties.isEmpty()) { 
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
     for (int k = 0; k < samCustomProperties.size(); k++) { 
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(samCustomProperties.get(k).get("PROP_NAME"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(samCustomProperties.get(k).get("PROP_VALUE"));
    stringBuffer.append(TEXT_67);
     } 
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
     } 
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
     } 
    stringBuffer.append(TEXT_72);
     if (Boolean.valueOf(ElementParameterParser.getValue(node,"__LOG_MESSAGES__"))) { 
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
     } 
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    
		String wrapJsonResponseProperty = ElementParameterParser.getValue(node,"__WRAP_JSON_RESPONSE__");
		boolean wrapJsonResponse = wrapJsonResponseProperty == null ? true : Boolean.valueOf(wrapJsonResponseProperty);
	
    stringBuffer.append(TEXT_85);
     if (wrapJsonResponse) { 
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
     } 
    stringBuffer.append(TEXT_89);
    
		boolean dropJsonRoot = (("POST".equals(method) || "PUT".equals(method)) && "application/json".equals(contentType))
				? Boolean.valueOf(ElementParameterParser.getValue(node,"__UNWRAP_JSON_REQUEST__")) : false;
	
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(dropJsonRoot);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(ElementParameterParser.getValue(node,"__PATH__"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(ElementParameterParser.getValue(node,"__RECEIVE_TIMEOUT__"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(ElementParameterParser.getValue(node,"__CONNECTION_TIMEOUT__"));
    stringBuffer.append(TEXT_107);
     if (Boolean.valueOf(ElementParameterParser.getValue(node,"__USE_PROXY__"))) { 
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(ElementParameterParser.getValue(node,"__PROXY_HOST__"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(ElementParameterParser.getValue(node,"__PROXY_PORT__"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(ElementParameterParser.getValue(node,"__PROXY_USERNAME__"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(ElementParameterParser.getValue(node,"__PROXY_PASSWORD__"));
    stringBuffer.append(TEXT_116);
     } 
    stringBuffer.append(TEXT_117);
     if (!"GET".equals(method) && !"DELETE".equals(method)) { 
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(contentType);
    stringBuffer.append(TEXT_120);
     } 
    stringBuffer.append(TEXT_121);
     if (!acceptType.isEmpty()) { 
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(acceptType);
    stringBuffer.append(TEXT_124);
     } 
    stringBuffer.append(TEXT_125);
     List<Map<String, String>> headers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__HEADERS__");
		for (Map<String, String> header : headers) { 
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(header.get("NAME") );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(header.get("VALUE") );
    stringBuffer.append(TEXT_129);
     } 
    stringBuffer.append(TEXT_130);
     List<Map<String, String>> queries = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__QUERY__");
		if ("application/x-www-form-urlencoded".equals(contentType) && !"GET".equals(method) && !"DELETE".equals(method)) { 
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
     for (Map<String, String> query : queries) { 
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(query.get("NAME") );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(query.get("VALUE") );
    stringBuffer.append(TEXT_136);
     } 
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
     } else { 
    stringBuffer.append(TEXT_140);
     for (Map<String, String> query : queries) { 
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(query.get("NAME") );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(query.get("VALUE") );
    stringBuffer.append(TEXT_144);
     } 
    stringBuffer.append(TEXT_145);
     } 
    stringBuffer.append(TEXT_146);
     if ("GET".equals(method)) { 
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
     } else if ("POST".equals(method)) { 
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
     } else if ("PUT".equals(method)) { 
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
     } else { 
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
     } 
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
     if (null != connResponse) {
			String connResponseName = connResponse.getName(); 
    stringBuffer.append(TEXT_170);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
     } 
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
     if (null != connFault) {
			String connFaultName = connFault.getName(); 
    stringBuffer.append(TEXT_189);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
     } else { 
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
     } 
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
     if ("true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"))) { 
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
     } else { 
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
     } 
    stringBuffer.append(TEXT_212);
    stringBuffer.append(TEXT_213);
    return stringBuffer.toString();
  }
}
