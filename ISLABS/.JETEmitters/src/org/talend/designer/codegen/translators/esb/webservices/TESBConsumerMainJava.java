package org.talend.designer.codegen.translators.esb.webservices;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TESBConsumerMainJava
{
  protected static String nl;
  public static synchronized TESBConsumerMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TESBConsumerMainJava result = new TESBConsumerMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        ";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "    final javax.xml.namespace.QName serviceName_";
  protected final String TEXT_4 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_5 = "\", \"";
  protected final String TEXT_6 = "\");" + NL + "    final javax.xml.namespace.QName portName_";
  protected final String TEXT_7 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_8 = "\", \"";
  protected final String TEXT_9 = "\");" + NL + "" + NL + "    final routines.system.Document headersTalendDoc_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = " ";
  protected final String TEXT_12 = ".headers; ";
  protected final String TEXT_13 = " null;";
  protected final String TEXT_14 = NL + NL + "    try {" + NL + "        routines.system.Document requestTalendDoc_";
  protected final String TEXT_15 = " = ";
  protected final String TEXT_16 = ".payload;" + NL + "" + NL + "        try {" + NL + "            org.dom4j.Document responseDoc_";
  protected final String TEXT_17 = " = null;" + NL;
  protected final String TEXT_18 = NL + "                final java.util.Map<String, String> slCustomProps_";
  protected final String TEXT_19 = " = new java.util.HashMap<String, String>();";
  protected final String TEXT_20 = NL + "                    slCustomProps_";
  protected final String TEXT_21 = ".put(";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + NL + "            java.util.Map<String, String> customProps_";
  protected final String TEXT_25 = " = null;";
  protected final String TEXT_26 = NL + "                    customProps_";
  protected final String TEXT_27 = " = new java.util.HashMap<String, String>();";
  protected final String TEXT_28 = NL + "                    customProps_";
  protected final String TEXT_29 = ".put(";
  protected final String TEXT_30 = ", ";
  protected final String TEXT_31 = ");";
  protected final String TEXT_32 = NL + NL + "            if (null == this.registry) {" + NL + "                GenericConsumer genericConsumer_";
  protected final String TEXT_33 = " = new GenericConsumer();" + NL + "                genericConsumer_";
  protected final String TEXT_34 = ".setServiceQName(serviceName_";
  protected final String TEXT_35 = ");" + NL + "                genericConsumer_";
  protected final String TEXT_36 = ".setPortQName(portName_";
  protected final String TEXT_37 = ");" + NL + "                genericConsumer_";
  protected final String TEXT_38 = ".setOperationQName(new javax.xml.namespace.QName(\"";
  protected final String TEXT_39 = "\", \"";
  protected final String TEXT_40 = "\"));" + NL + "                genericConsumer_";
  protected final String TEXT_41 = ".setIsRequestResponse(";
  protected final String TEXT_42 = ");";
  protected final String TEXT_43 = "genericConsumer_";
  protected final String TEXT_44 = ".setSoapAction(\"";
  protected final String TEXT_45 = "\");";
  protected final String TEXT_46 = NL + "                genericConsumer_";
  protected final String TEXT_47 = ".setAddress(";
  protected final String TEXT_48 = ");" + NL + "                if (null != getClass().getResourceAsStream(\"wsdl/";
  protected final String TEXT_49 = ".wsdl\")) {" + NL + "                    genericConsumer_";
  protected final String TEXT_50 = ".setWsdlURL(\"classpath:/\" + this.getClass().getPackage().getName().replace(\".\", \"/\") + \"/wsdl/";
  protected final String TEXT_51 = ".wsdl\");" + NL + "                }" + NL + "" + NL + "                java.util.Collection<org.apache.cxf.feature.AbstractFeature> esbFeatures_";
  protected final String TEXT_52 = " =" + NL + "                        new java.util.ArrayList<org.apache.cxf.feature.AbstractFeature>();" + NL;
  protected final String TEXT_53 = NL + "// disable SL (java.lang.RuntimeException: Could not find conduit initiator for address: locator:// and transport: http://schemas.xmlsoap.org/soap/http)" + NL + "// Cause: client.getConduit()" + NL + "//                    genericConsumer_";
  protected final String TEXT_54 = ".setAddress(\"locator://\");" + NL + "//" + NL + "//                    // if (!inOSGi) {" + NL + "//                    genericConsumer_";
  protected final String TEXT_55 = ".setBus(new org.apache.cxf.bus.spring.SpringBusFactory().createBus(\"META-INF/tesb/locator/beans.xml\"));" + NL + "//                    // }" + NL + "//                    org.talend.esb.servicelocator.cxf.LocatorFeature featureSL_";
  protected final String TEXT_56 = " = new org.talend.esb.servicelocator.cxf.LocatorFeature();" + NL + "//                    if (null != slCustomProps_";
  protected final String TEXT_57 = " && !slCustomProps_";
  protected final String TEXT_58 = ".isEmpty()) {" + NL + "//                        featureSL_";
  protected final String TEXT_59 = ".setRequiredEndpointProperties(slCustomProps_";
  protected final String TEXT_60 = ");" + NL + "//                    }" + NL + "//                    esbFeatures_";
  protected final String TEXT_61 = ".add(featureSL_";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + "                    // if (null == eventFeature) {" + NL + "                    org.springframework.context.support.ClassPathXmlApplicationContext classpathXmlApplicationContext =" + NL + "                            new org.springframework.context.support.ClassPathXmlApplicationContext(\"META-INF/tesb/agent-context.xml\");" + NL + "                    org.talend.esb.sam.agent.feature.EventFeature featureSAM_";
  protected final String TEXT_64 = " = classpathXmlApplicationContext.getBean(org.talend.esb.sam.agent.feature.EventFeature.class);" + NL + "                    // }" + NL + "                    if (null != customProps_";
  protected final String TEXT_65 = " && !customProps_";
  protected final String TEXT_66 = ".isEmpty()) {" + NL + "                        org.talend.esb.sam.common.handler.impl.CustomInfoHandler ciHandler = new org.talend.esb.sam.common.handler.impl.CustomInfoHandler();" + NL + "                        ciHandler.setCustomInfo(customProps_";
  protected final String TEXT_67 = ");" + NL + "                        featureSAM_";
  protected final String TEXT_68 = ".setHandler(ciHandler);" + NL + "                    }" + NL + "                    esbFeatures_";
  protected final String TEXT_69 = ".add(featureSAM_";
  protected final String TEXT_70 = ");";
  protected final String TEXT_71 = NL + "                genericConsumer_";
  protected final String TEXT_72 = ".setEsbFeatures(esbFeatures_";
  protected final String TEXT_73 = ");" + NL;
  protected final String TEXT_74 = NL + "                    genericConsumer_";
  protected final String TEXT_75 = ".setAuthType(\"";
  protected final String TEXT_76 = "\");" + NL + "                    genericConsumer_";
  protected final String TEXT_77 = ".setUsername(";
  protected final String TEXT_78 = ");" + NL + "                    genericConsumer_";
  protected final String TEXT_79 = ".setPassword(";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "                    genericConsumer_";
  protected final String TEXT_82 = ".setProxyServer(";
  protected final String TEXT_83 = ");" + NL + "                    genericConsumer_";
  protected final String TEXT_84 = ".setProxyPort(";
  protected final String TEXT_85 = ");" + NL + "                    genericConsumer_";
  protected final String TEXT_86 = ".setProxyUsername(";
  protected final String TEXT_87 = ");" + NL + "                    genericConsumer_";
  protected final String TEXT_88 = ".setProxyPassword(";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "                genericConsumer_";
  protected final String TEXT_91 = ".setConnectionTimeout((long)(";
  protected final String TEXT_92 = " * 1000));" + NL + "                genericConsumer_";
  protected final String TEXT_93 = ".setReceiveTimeout((long)(";
  protected final String TEXT_94 = " * 1000));" + NL + "" + NL + "                genericConsumer_";
  protected final String TEXT_95 = ".setLogMessages(";
  protected final String TEXT_96 = ");" + NL;
  protected final String TEXT_97 = NL + "                    System.setProperty(\"java.protocol.handler.pkgs\", \"com.sun.net.ssl.internal.www.protocol\");" + NL + "                    System.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_98 = ");" + NL + "                    System.setProperty(\"javax.net.ssl.trustStorePassword\", ";
  protected final String TEXT_99 = ");";
  protected final String TEXT_100 = NL + NL + "                if (null != headersTalendDoc_";
  protected final String TEXT_101 = " && null != headersTalendDoc_";
  protected final String TEXT_102 = ".getDocument()) {" + NL + "                    genericConsumer_";
  protected final String TEXT_103 = ".setSoapHeaders(headersTalendDoc_";
  protected final String TEXT_104 = ".getDocument());" + NL + "                }" + NL + "" + NL + "                responseDoc_";
  protected final String TEXT_105 = " = genericConsumer_";
  protected final String TEXT_106 = ".invoke(requestTalendDoc_";
  protected final String TEXT_107 = ".getDocument());" + NL + "" + NL + "            } else {" + NL + "                ESBConsumer consumer_";
  protected final String TEXT_108 = " = this.registry.createConsumer(" + NL + "                    new ESBEndpointInfo() {" + NL + "" + NL + "                        @SuppressWarnings(\"serial\")" + NL + "                        private java.util.Map<String, Object> props = new java.util.HashMap<String, Object>() {{" + NL + "                            put(\"dataFormat\", \"PAYLOAD\");" + NL + "                            put(\"portName\", portName_";
  protected final String TEXT_109 = ".toString());" + NL + "                            put(\"serviceName\", serviceName_";
  protected final String TEXT_110 = ".toString());" + NL + "                            put(\"defaultOperationName\", \"";
  protected final String TEXT_111 = "\");" + NL + "                            put(\"defaultOperationNameSpace\", \"\");" + NL + "                            put(\"soapAction\", \"";
  protected final String TEXT_112 = "\");" + NL + "                            if (null != getClass().getResourceAsStream(\"wsdl/";
  protected final String TEXT_113 = ".wsdl\")) {" + NL + "                                put(\"wsdlURL\", \"classpath:/\" + this.getClass().getPackage().getName().replace(\".\", \"/\") + \"/wsdl/";
  protected final String TEXT_114 = ".wsdl\");" + NL + "                            }" + NL + "                            put(\"publishedEndpointUrl\", ";
  protected final String TEXT_115 = ");" + NL + "                            put(\"COMMUNICATION_STYLE\", \"";
  protected final String TEXT_116 = "\");" + NL + "" + NL + "                            put(\"logMessages\", ";
  protected final String TEXT_117 = ");" + NL + "" + NL + "                            // use Service Locator" + NL + "                            put(\"useServiceLocator\", ";
  protected final String TEXT_118 = ");";
  protected final String TEXT_119 = NL + "                                put(\"LocatorSelectionStrategy\", \"";
  protected final String TEXT_120 = "\");" + NL + "                                put(\"SL-PROPS\", slCustomProps_";
  protected final String TEXT_121 = ");";
  protected final String TEXT_122 = NL + "                            // use Service Activity Monitor" + NL + "                            put(\"useServiceActivityMonitor\", ";
  protected final String TEXT_123 = ");" + NL;
  protected final String TEXT_124 = NL + "                                put(\"useServiceRegistry\", ";
  protected final String TEXT_125 = ");" + NL + "                                put(\"username\", ";
  protected final String TEXT_126 = ");" + NL + "                                put(\"password\", ";
  protected final String TEXT_127 = ");" + NL + "                                put(\"role\", ";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "                                    put(\"useAuthorization\", ";
  protected final String TEXT_130 = ");";
  protected final String TEXT_131 = NL + "                                        put(\"role\", ";
  protected final String TEXT_132 = ");";
  protected final String TEXT_133 = NL + "                                        put(\"role\", \"\");";
  protected final String TEXT_134 = NL + "                                put(\"esbSecurity\", \"";
  protected final String TEXT_135 = "\");" + NL + "                                put(\"username\", ";
  protected final String TEXT_136 = ");" + NL + "                                put(\"password\", ";
  protected final String TEXT_137 = ");";
  protected final String TEXT_138 = NL + "                            if (null != headersTalendDoc_";
  protected final String TEXT_139 = " && null != headersTalendDoc_";
  protected final String TEXT_140 = ".getDocument()) {" + NL + "                                put(\"soapHeaders\", headersTalendDoc_";
  protected final String TEXT_141 = ".getDocument());" + NL + "                            }" + NL + "                        }};" + NL + "" + NL + "                        public String getEndpointUri() {" + NL + "                            // projectName + \"_\" + processName + \"_\" + componentName" + NL + "                            return \"";
  protected final String TEXT_142 = "_";
  protected final String TEXT_143 = "_";
  protected final String TEXT_144 = "\";" + NL + "                        }" + NL + "" + NL + "                        public java.util.Map<String, Object> getEndpointProperties() {" + NL + "                            return props;" + NL + "                        }" + NL + "" + NL + "                        public String getEndpointKey() {" + NL + "                            return \"cxf\";" + NL + "                        }" + NL + "                    }" + NL + "                );" + NL + "" + NL + "                Object request_";
  protected final String TEXT_145 = " = wrapPayload(requestTalendDoc_";
  protected final String TEXT_146 = ".getDocument(), customProps_";
  protected final String TEXT_147 = ");" + NL + "                responseDoc_";
  protected final String TEXT_148 = " = (org.dom4j.Document) consumer_";
  protected final String TEXT_149 = ".invoke(request_";
  protected final String TEXT_150 = ");" + NL + "            }";
  protected final String TEXT_151 = NL + "                if (";
  protected final String TEXT_152 = " == null) {";
  protected final String TEXT_153 = NL + "                    ";
  protected final String TEXT_154 = " = new ";
  protected final String TEXT_155 = "Struct();" + NL + "                }" + NL + "                routines.system.Document responseTalendDoc_";
  protected final String TEXT_156 = " = null;" + NL + "                if (null != responseDoc_";
  protected final String TEXT_157 = ") {" + NL + "                    responseTalendDoc_";
  protected final String TEXT_158 = " = new routines.system.Document();" + NL + "                    responseTalendDoc_";
  protected final String TEXT_159 = ".setDocument(responseDoc_";
  protected final String TEXT_160 = ");" + NL + "                }";
  protected final String TEXT_161 = NL + "                ";
  protected final String TEXT_162 = ".payload = responseTalendDoc_";
  protected final String TEXT_163 = ";";
  protected final String TEXT_164 = NL + "        } catch (org.apache.cxf.binding.soap.SoapFault e_";
  protected final String TEXT_165 = ") {";
  protected final String TEXT_166 = NL + "                if (";
  protected final String TEXT_167 = " == null) {";
  protected final String TEXT_168 = NL + "                    ";
  protected final String TEXT_169 = " = new ";
  protected final String TEXT_170 = "Struct();" + NL + "                }";
  protected final String TEXT_171 = NL + "                ";
  protected final String TEXT_172 = ".faultCode = e_";
  protected final String TEXT_173 = ".getFaultCode().toString();" + NL;
  protected final String TEXT_174 = NL + "                ";
  protected final String TEXT_175 = ".faultString = e_";
  protected final String TEXT_176 = ".getReason();";
  protected final String TEXT_177 = NL + "                ";
  protected final String TEXT_178 = ".faultActor = e_";
  protected final String TEXT_179 = ".getRole();";
  protected final String TEXT_180 = NL + "                ";
  protected final String TEXT_181 = ".faultNode = e_";
  protected final String TEXT_182 = ".getNode();" + NL + "" + NL + "                if (null != e_";
  protected final String TEXT_183 = ".getDetail() && null != e_";
  protected final String TEXT_184 = ".getDetail().getFirstChild()) {" + NL + "                    javax.xml.transform.Source faultSource_";
  protected final String TEXT_185 = " =" + NL + "                        new javax.xml.transform.dom.DOMSource(e_";
  protected final String TEXT_186 = ".getDetail().getFirstChild());";
  protected final String TEXT_187 = NL + "                    ";
  protected final String TEXT_188 = ".faultDetail = new routines.system.Document();";
  protected final String TEXT_189 = NL + "                    ";
  protected final String TEXT_190 = ".faultDetail.setDocument(GenericConsumer.sourceToDocument(faultSource_";
  protected final String TEXT_191 = "));" + NL + "                }";
  protected final String TEXT_192 = NL + "                e_";
  protected final String TEXT_193 = ".printStackTrace(System.err);";
  protected final String TEXT_194 = NL + "        } catch (GenericFaultInfoException e_";
  protected final String TEXT_195 = ") {";
  protected final String TEXT_196 = NL + "                if (";
  protected final String TEXT_197 = " == null) {";
  protected final String TEXT_198 = NL + "                    ";
  protected final String TEXT_199 = " = new ";
  protected final String TEXT_200 = "Struct();" + NL + "                }";
  protected final String TEXT_201 = NL + "                ";
  protected final String TEXT_202 = ".faultString = e_";
  protected final String TEXT_203 = ".getMessage();" + NL;
  protected final String TEXT_204 = NL + "                ";
  protected final String TEXT_205 = ".faultDetail = new routines.system.Document();";
  protected final String TEXT_206 = NL + "                ";
  protected final String TEXT_207 = ".faultDetail.setDocument((org.dom4j.Document) e_";
  protected final String TEXT_208 = ".getFaultInfo());";
  protected final String TEXT_209 = NL + "                System.err.println(e_";
  protected final String TEXT_210 = ".getMessage() + \": \" + ((org.dom4j.Document) e_";
  protected final String TEXT_211 = ".getFaultInfo()).asXML());";
  protected final String TEXT_212 = NL + "        } catch (javax.xml.ws.soap.SOAPFaultException e_";
  protected final String TEXT_213 = ") {";
  protected final String TEXT_214 = NL + "                javax.xml.soap.SOAPFault soapFault_";
  protected final String TEXT_215 = " = e_";
  protected final String TEXT_216 = ".getFault();" + NL + "                org.dom4j.Document faultDoc_";
  protected final String TEXT_217 = " = null;" + NL + "                if (null != soapFault_";
  protected final String TEXT_218 = ".getDetail() && null != soapFault_";
  protected final String TEXT_219 = ".getDetail().getFirstChild()) {" + NL + "                    try {" + NL + "                        javax.xml.transform.Source faultSource_";
  protected final String TEXT_220 = " =" + NL + "                            new javax.xml.transform.dom.DOMSource(soapFault_";
  protected final String TEXT_221 = ".getDetail().getFirstChild());" + NL + "" + NL + "                        org.dom4j.io.DocumentResult result_";
  protected final String TEXT_222 = " = new org.dom4j.io.DocumentResult();" + NL + "                        javax.xml.transform.TransformerFactory.newInstance()" + NL + "                            .newTransformer().transform(faultSource_";
  protected final String TEXT_223 = ", result_";
  protected final String TEXT_224 = ");" + NL + "                        faultDoc_";
  protected final String TEXT_225 = " = result_";
  protected final String TEXT_226 = ".getDocument();" + NL + "                    } catch (Exception e1_";
  protected final String TEXT_227 = ") {" + NL + "                        e1_";
  protected final String TEXT_228 = ".printStackTrace();" + NL + "                    }" + NL + "                }" + NL + "" + NL + "                if (";
  protected final String TEXT_229 = " == null) {";
  protected final String TEXT_230 = NL + "                    ";
  protected final String TEXT_231 = " = new ";
  protected final String TEXT_232 = "Struct();" + NL + "                }";
  protected final String TEXT_233 = NL + "                ";
  protected final String TEXT_234 = ".faultCode = soapFault_";
  protected final String TEXT_235 = ".getFaultCodeAsQName().toString();";
  protected final String TEXT_236 = NL + "                ";
  protected final String TEXT_237 = ".faultString = soapFault_";
  protected final String TEXT_238 = ".getFaultString();";
  protected final String TEXT_239 = NL + "                ";
  protected final String TEXT_240 = ".faultActor = soapFault_";
  protected final String TEXT_241 = ".getFaultActor();" + NL;
  protected final String TEXT_242 = NL + "                ";
  protected final String TEXT_243 = ".faultNode = null;";
  protected final String TEXT_244 = NL + "                ";
  protected final String TEXT_245 = ".faultRole = null;" + NL + "                if (javax.xml.soap.SOAPConstants.URI_NS_SOAP_1_2_ENVELOPE.equals(soapFault_";
  protected final String TEXT_246 = ".getNamespaceURI())) {" + NL + "                    // SOAP 1.2" + NL + "                    try {";
  protected final String TEXT_247 = NL + "                        ";
  protected final String TEXT_248 = ".faultNode = soapFault_";
  protected final String TEXT_249 = ".getFaultNode();";
  protected final String TEXT_250 = NL + "                        ";
  protected final String TEXT_251 = ".faultRole = soapFault_";
  protected final String TEXT_252 = ".getFaultRole();" + NL + "                    } catch (java.lang.UnsupportedOperationException uoe_";
  protected final String TEXT_253 = ") { }" + NL + "                }" + NL + "" + NL + "                routines.system.Document faultTalendDoc_";
  protected final String TEXT_254 = " = null;" + NL + "                if (null != faultDoc_";
  protected final String TEXT_255 = ") {" + NL + "                    faultTalendDoc_";
  protected final String TEXT_256 = " = new routines.system.Document();" + NL + "                    faultTalendDoc_";
  protected final String TEXT_257 = ".setDocument(faultDoc_";
  protected final String TEXT_258 = ");" + NL + "                }";
  protected final String TEXT_259 = NL + "                ";
  protected final String TEXT_260 = ".faultDetail = faultTalendDoc_";
  protected final String TEXT_261 = ";";
  protected final String TEXT_262 = NL + "                e_";
  protected final String TEXT_263 = ".printStackTrace();";
  protected final String TEXT_264 = NL + "        }" + NL + "    } catch (Exception e_";
  protected final String TEXT_265 = "){";
  protected final String TEXT_266 = NL + "            throw(e_";
  protected final String TEXT_267 = ");";
  protected final String TEXT_268 = NL + "            new TalendException(e_";
  protected final String TEXT_269 = ",currentComponent,globalMap).printStackTrace();";
  protected final String TEXT_270 = NL + "    }" + NL;
  protected final String TEXT_271 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

String projectName = codeGenArgument.getCurrentProjectName();
String processName = node.getProcess().getName();

String serviceNS = ElementParameterParser.getValue(node, "__SERVICE_NS__");
String serviceName = ElementParameterParser.getValue(node, "__SERVICE_NAME__");
String portNS = ElementParameterParser.getValue(node, "__PORT_NS__");
String portName = ElementParameterParser.getValue(node, "__PORT_NAME__");

String methodNS = ElementParameterParser.getValue(node, "__METHOD_NS__");
if (methodNS == null || "".equals(methodNS)) {
    methodNS = serviceNS;
}
String methodTemp = ElementParameterParser.getValue(node, "__METHOD__");
String method = methodTemp.indexOf("(") != -1 ? methodTemp.substring(0, methodTemp.indexOf("(")) : methodTemp;

Boolean useAuth = Boolean.valueOf(ElementParameterParser.getValue(node, "__NEED_AUTH__"));
Boolean useSR = Boolean.valueOf(ElementParameterParser.getValue(node, "__USE_SR__"));
Boolean useAuthorization = Boolean.valueOf(ElementParameterParser.getValue(node, "__NEED_AUTHORIZATION__"));
String authorizationRole = ElementParameterParser.getValue(node, "__ROLE__");

//if no a EE version then useSR should be false
boolean isStudioEEVersion = org.talend.core.PluginChecker.isTIS();
if(!isStudioEEVersion){
	useSR = false;
}
Boolean useSl = Boolean.valueOf(ElementParameterParser.getValue(node, "__SERVICE_LOCATOR__")) && !useSR;
Boolean useSAM = Boolean.valueOf(ElementParameterParser.getValue(node, "__SERVICE_ACTIVITY_MONITOR__"));

String authType = ElementParameterParser.getValue(node, "__AUTH_TYPE__");
String username = ElementParameterParser.getValue(node, "__AUTH_USERNAME__");
String password = ElementParameterParser.getValue(node, "__AUTH_PASSWORD__");

String connTimeout = ElementParameterParser.getValue(node, "__CONNECTION_TIMEOUT__");
String receiveTimeout = ElementParameterParser.getValue(node, "__RECEIVE_TIMEOUT__");

Boolean logMessages = Boolean.valueOf(ElementParameterParser.getValue(node, "__LOG_MESSAGES__"));

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
if (inputConn != null) {
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
    IConnection connResponse = null;
    IConnection connFault = null;
    if (connsResponse.size() == 1) {
        connResponse = connsResponse.get(0);
    }
    if (connsFault.size() == 1) {
        connFault = connsFault.get(0);
    }

    boolean hasHeaders = false;
    for (IMetadataColumn connColumn : inputConn.getMetadataTable().getListColumns()) {
        if ("headers".equals(connColumn.getLabel())) {
            hasHeaders = true;
            break;
        }
    }

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(serviceNS);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(serviceName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(portNS);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
     if(hasHeaders) { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_12);
     } else { 
    stringBuffer.append(TEXT_13);
     } 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
     if (useSl) { 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    
                List<Map<String, String>> customProperties = (List<Map<String,String>>)
                        ElementParameterParser.getObjectValue(node, "__SERVICE_LOCATOR_CUSTOM_PROPERTIES__");
                for (int k = 0; k < customProperties.size(); k++) { 
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(customProperties.get(k).get("PROP_NAME"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(customProperties.get(k).get("PROP_VALUE"));
    stringBuffer.append(TEXT_23);
     }
            } 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
     if (Boolean.valueOf(ElementParameterParser.getValue(node, "__SERVICE_ACTIVITY_MONITOR__"))) {
                List<Map<String, String>> customProperties = (List<Map<String,String>>)
                        ElementParameterParser.getObjectValue(node, "__SERVICE_ACTIVITY_CUSTOM_PROPERTIES__");
                if (!customProperties.isEmpty()) { 
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
     for (int k = 0; k < customProperties.size(); k++) { 
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(customProperties.get(k).get("PROP_NAME"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(customProperties.get(k).get("PROP_VALUE"));
    stringBuffer.append(TEXT_31);
     } 
     } 
     } 
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(methodNS);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append("request-response".equals(ElementParameterParser.getValue(node, "__COMMUNICATION_STYLE__")));
    stringBuffer.append(TEXT_42);
     String soapAction=ElementParameterParser.getValue(node, "__SOAP_ACTION__");
                	if(soapAction!=null&&(!soapAction.matches("\\s*"))){
                		
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(soapAction);
    stringBuffer.append(TEXT_45);
                    	
                	}
                
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ESB_ENDPOINT__"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
     if (useSl) { 
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
     } 
     if (useSAM) { 
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
     } 
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
     if (useAuth && !useSR) { 
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_80);
     } 
     if ("true".equals(ElementParameterParser.getValue(node, "__USE_PROXY__"))) { 
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PROXY_HOST__"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PROXY_PORT__"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PROXY_USERNAME__"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PROXY_PASSWORD__"));
    stringBuffer.append(TEXT_89);
     } 
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(connTimeout);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(receiveTimeout);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(logMessages);
    stringBuffer.append(TEXT_96);
     if ("true".equals(ElementParameterParser.getValue(node, "__NEED_SSL_TO_TRUSTSERVER__"))) { 
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SSL_TRUSTSERVER_TRUSTSTORE__"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SSL_TRUSTSERVER_PASSWORD__"));
    stringBuffer.append(TEXT_99);
     } 
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SOAP_ACTION__"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ESB_ENDPOINT__"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(ElementParameterParser.getValue(node, "__COMMUNICATION_STYLE__"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(logMessages);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(useSl);
    stringBuffer.append(TEXT_118);
     if (useSl) { 
    stringBuffer.append(TEXT_119);
    stringBuffer.append(ElementParameterParser.getValue(node, "__SERVICE_LOCATOR_STRATEGY__"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
     } 
    stringBuffer.append(TEXT_122);
    stringBuffer.append(useSAM);
    stringBuffer.append(TEXT_123);
     if (useSR) { 
    stringBuffer.append(TEXT_124);
    stringBuffer.append(Boolean.valueOf(ElementParameterParser.getValue(node, "__USE_SR__")));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(authorizationRole);
    stringBuffer.append(TEXT_128);
     } else if (useAuth) { 
     if ("SAML".equals(authType) && isStudioEEVersion) { 
    stringBuffer.append(TEXT_129);
    stringBuffer.append(useAuthorization);
    stringBuffer.append(TEXT_130);
     if (useAuthorization) { 
    stringBuffer.append(TEXT_131);
    stringBuffer.append(authorizationRole);
    stringBuffer.append(TEXT_132);
     } else { 
    stringBuffer.append(TEXT_133);
     } 
     } 
    stringBuffer.append(TEXT_134);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_137);
     } 
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(processName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
     if (null != connResponse) {
                String connResponseName = connResponse.getName(); 
    stringBuffer.append(TEXT_151);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
     } 
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
     if (null != connFault) {
                String connFaultName = connFault.getName(); 
    stringBuffer.append(TEXT_166);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
     } else { 
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
     } 
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
     if (null != connFault) {
                String connFaultName = connFault.getName(); 
    stringBuffer.append(TEXT_196);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
     } else { 
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
     } 
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
     if (null != connFault) {
                String connFaultName = connFault.getName(); 
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
     } else { 
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
     } 
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
     if ("true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"))) { 
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
     } else { 
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
     } 
    stringBuffer.append(TEXT_270);
     } 
    stringBuffer.append(TEXT_271);
    return stringBuffer.toString();
  }
}
