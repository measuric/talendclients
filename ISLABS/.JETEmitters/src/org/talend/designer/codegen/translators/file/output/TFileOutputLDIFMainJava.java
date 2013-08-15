package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TFileOutputLDIFMainJava
{
  protected static String nl;
  public static synchronized TFileOutputLDIFMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputLDIFMainJava result = new TFileOutputLDIFMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t//////////////////////////" + NL + "\t\tboolean encodingBase64 = false;";
  protected final String TEXT_2 = " " + NL + "\t\tStringBuilder sb_";
  protected final String TEXT_3 = " = new StringBuilder();" + NL + "\t\tboolean needSeparator_";
  protected final String TEXT_4 = " = false;" + NL + "\t\tboolean canOutput_";
  protected final String TEXT_5 = " = false;\t\t\t\t   \t\t" + NL + "\t\tboolean isPrintable_";
  protected final String TEXT_6 = " = false;";
  protected final String TEXT_7 = NL + "\t\tencodingBase64 = false;" + NL + "\t\tString value_";
  protected final String TEXT_8 = "_";
  protected final String TEXT_9 = " = \"\";";
  protected final String TEXT_10 = "   \t\t\t\t" + NL + "\t    if(";
  protected final String TEXT_11 = ".";
  protected final String TEXT_12 = " != null && !(\"\").equals(";
  protected final String TEXT_13 = ".";
  protected final String TEXT_14 = ")) {";
  protected final String TEXT_15 = NL + "    \tvalue_";
  protected final String TEXT_16 = "_";
  protected final String TEXT_17 = " =  \t\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\tFormatterUtils.format_Date(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ", ";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t\t";
  protected final String TEXT_23 = ".";
  protected final String TEXT_24 = ";";
  protected final String TEXT_25 = NL + "\t\tString.valueOf(";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "\t\torg.apache.commons.codec.binary.Base64.encodeBase64String(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "\t\tString.valueOf(";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = ");";
  protected final String TEXT_33 = "\t\t" + NL + "\t\tutil_";
  protected final String TEXT_34 = ".breakString(sb_";
  protected final String TEXT_35 = ", dn_";
  protected final String TEXT_36 = " + value_";
  protected final String TEXT_37 = "_";
  protected final String TEXT_38 = ", wrap_";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = "\t\t" + NL + "        util_";
  protected final String TEXT_41 = ".breakString(sb_";
  protected final String TEXT_42 = ", changetype_";
  protected final String TEXT_43 = " + \"";
  protected final String TEXT_44 = "\", wrap_";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = NL;
  protected final String TEXT_47 = NL + "\tcanOutput_";
  protected final String TEXT_48 = " = true;        ";
  protected final String TEXT_49 = " " + NL;
  protected final String TEXT_50 = NL + "\t    }";
  protected final String TEXT_51 = "   ";
  protected final String TEXT_52 = "\t\t\t\t\t\t";
  protected final String TEXT_53 = NL + "\t    }";
  protected final String TEXT_54 = " \t\t" + NL + "\t";
  protected final String TEXT_55 = NL + "//////////////////////////////////////////////////" + NL + "Please check \"isBase64\" for column ";
  protected final String TEXT_56 = " when \"isBianry\" is checked." + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\t// Convert binary or Base64 value to Base64 encoded string\t\t\t\t" + NL + "\t\t\t\t\t\tencodingBase64 = true;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_58 = NL;
  protected final String TEXT_59 = NL + "\tif(needSeparator_";
  protected final String TEXT_60 = "){" + NL + "\t\tsb_";
  protected final String TEXT_61 = ".append(\"-\\n\");" + NL + "\t}  " + NL + "\tutil_";
  protected final String TEXT_62 = ".breakString(sb_";
  protected final String TEXT_63 = ", \"";
  protected final String TEXT_64 = ": \" + \"";
  protected final String TEXT_65 = "\", wrap_";
  protected final String TEXT_66 = ");" + NL + "\t";
  protected final String TEXT_67 = "\t\t" + NL + "\t\tString[] values_";
  protected final String TEXT_68 = "_";
  protected final String TEXT_69 = " = value_";
  protected final String TEXT_70 = "_";
  protected final String TEXT_71 = ".split(";
  protected final String TEXT_72 = ");" + NL + "\t\tfor(String item_";
  protected final String TEXT_73 = " : values_";
  protected final String TEXT_74 = "_";
  protected final String TEXT_75 = "){" + NL + "\t\t\t// follow LDIF rules or not" + NL + "            isPrintable_";
  protected final String TEXT_76 = " =  netscape.ldap.util.LDIF.isPrintable(item_";
  protected final String TEXT_77 = ".getBytes(";
  protected final String TEXT_78 = "));" + NL + "\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t// If content doesn't follow LDIF rules, it must be base64 encoded" + NL + "\t\t\t\tif(!isPrintable_";
  protected final String TEXT_80 = "){" + NL + "\t\t\t\t\tencodingBase64 = true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\telse{" + NL + "\t\t\t\t\tencodingBase64 = false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t// Add \":\" to comply with base64 ldif syntax" + NL + "\t\t\t\titem_";
  protected final String TEXT_82 = " = util_";
  protected final String TEXT_83 = ".getBase64StringOrNot(encodingBase64,item_";
  protected final String TEXT_84 = ",";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = NL + "\t\t\t\t    util_";
  protected final String TEXT_87 = ".breakString(sb_";
  protected final String TEXT_88 = ", \"";
  protected final String TEXT_89 = ";binary";
  protected final String TEXT_90 = ":: \" + item_";
  protected final String TEXT_91 = ", wrap_";
  protected final String TEXT_92 = ");";
  protected final String TEXT_93 = NL + "\t\t\t\t\t\tif(!isPrintable_";
  protected final String TEXT_94 = "){" + NL + "\t\t\t\t\t\t\tutil_";
  protected final String TEXT_95 = ".breakString(sb_";
  protected final String TEXT_96 = ", \"";
  protected final String TEXT_97 = ":: \" + item_";
  protected final String TEXT_98 = ", wrap_";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tutil_";
  protected final String TEXT_100 = ".breakString(sb_";
  protected final String TEXT_101 = ", \"";
  protected final String TEXT_102 = ": \" + item_";
  protected final String TEXT_103 = ", wrap_";
  protected final String TEXT_104 = ");" + NL + "\t               \t\t}";
  protected final String TEXT_105 = NL + "                    \tutil_";
  protected final String TEXT_106 = ".breakString(sb_";
  protected final String TEXT_107 = ", \"";
  protected final String TEXT_108 = ": \" + item_";
  protected final String TEXT_109 = ", wrap_";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL + "\t\t}";
  protected final String TEXT_112 = NL + "\t\t// follow LDIF rules or not" + NL + "        isPrintable_";
  protected final String TEXT_113 = " =  netscape.ldap.util.LDIF.isPrintable(value_";
  protected final String TEXT_114 = "_";
  protected final String TEXT_115 = ".getBytes(";
  protected final String TEXT_116 = "));";
  protected final String TEXT_117 = NL + "\t\t\t// If content doesn't follow LDIF rules, it must be base64 encoded" + NL + "\t\t\tif(!isPrintable_";
  protected final String TEXT_118 = "){" + NL + "\t\t\t\tencodingBase64 = true;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_119 = NL + "\t\t// Add \":\" to comply with base64 ldif syntax" + NL + "\t\t\tvalue_";
  protected final String TEXT_120 = "_";
  protected final String TEXT_121 = " = util_";
  protected final String TEXT_122 = ".getBase64StringOrNot(encodingBase64,value_";
  protected final String TEXT_123 = "_";
  protected final String TEXT_124 = ",";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "                    util_";
  protected final String TEXT_127 = ".breakString(sb_";
  protected final String TEXT_128 = ", \"";
  protected final String TEXT_129 = ";binary";
  protected final String TEXT_130 = ":: \" + value_";
  protected final String TEXT_131 = "_";
  protected final String TEXT_132 = ", wrap_";
  protected final String TEXT_133 = ");";
  protected final String TEXT_134 = NL + "\t\t\t\t\t\tif(!isPrintable_";
  protected final String TEXT_135 = "){" + NL + "\t\t\t\t\t\t\tutil_";
  protected final String TEXT_136 = ".breakString(sb_";
  protected final String TEXT_137 = ", \"";
  protected final String TEXT_138 = ":: \" + value_";
  protected final String TEXT_139 = "_";
  protected final String TEXT_140 = ", wrap_";
  protected final String TEXT_141 = ");" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tutil_";
  protected final String TEXT_142 = ".breakString(sb_";
  protected final String TEXT_143 = ", \"";
  protected final String TEXT_144 = ": \" + value_";
  protected final String TEXT_145 = "_";
  protected final String TEXT_146 = ", wrap_";
  protected final String TEXT_147 = ");" + NL + "\t               \t\t}";
  protected final String TEXT_148 = NL + "\t                   util_";
  protected final String TEXT_149 = ".breakString(sb_";
  protected final String TEXT_150 = ", \"";
  protected final String TEXT_151 = ": \" + value_";
  protected final String TEXT_152 = "_";
  protected final String TEXT_153 = ", wrap_";
  protected final String TEXT_154 = ");";
  protected final String TEXT_155 = NL + "\tneedSeparator_";
  protected final String TEXT_156 = " = true;" + NL + "\tcanOutput_";
  protected final String TEXT_157 = " = true;   \t";
  protected final String TEXT_158 = NL + "sb_";
  protected final String TEXT_159 = ".append(\"-\\n\");";
  protected final String TEXT_160 = NL + "//////////////////////////////////////////////////" + NL + "Please check \"isBase64\" for column ";
  protected final String TEXT_161 = " when \"isBianry\" is checked." + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_162 = NL + "\t\t\t\t\t\t// Convert binary or Base64 value to Base64 encoded string\t\t\t\t" + NL + "\t\t\t\t\t\tencodingBase64 = true;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_163 = NL + "\t";
  protected final String TEXT_164 = NL + "\t\tString[] values_";
  protected final String TEXT_165 = "_";
  protected final String TEXT_166 = " = value_";
  protected final String TEXT_167 = "_";
  protected final String TEXT_168 = ".split(";
  protected final String TEXT_169 = ");" + NL + "\t\tfor(String item_";
  protected final String TEXT_170 = " : values_";
  protected final String TEXT_171 = "_";
  protected final String TEXT_172 = "){" + NL + "\t\t        //follow LDIF rules or not" + NL + "                isPrintable_";
  protected final String TEXT_173 = " =  netscape.ldap.util.LDIF.isPrintable(item_";
  protected final String TEXT_174 = ".getBytes(";
  protected final String TEXT_175 = "));     " + NL + "\t\t\t\t";
  protected final String TEXT_176 = NL + "\t\t\t\t\t// If content doesn't follow LDIF rules, it must be base64 encoded" + NL + "\t\t\t\t\tif(!isPrintable_";
  protected final String TEXT_177 = "){" + NL + "\t\t\t\t\t\tencodingBase64 = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\telse{" + NL + "\t\t\t\t\t\tencodingBase64 = false;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_178 = NL + "\t\t\t\t// Add \":\" to comply with base64 ldif syntax" + NL + "\t                item_";
  protected final String TEXT_179 = " = util_";
  protected final String TEXT_180 = ".getBase64StringOrNot(encodingBase64,item_";
  protected final String TEXT_181 = ",";
  protected final String TEXT_182 = ");";
  protected final String TEXT_183 = NL + "\t\t\t\t\t\tutil_";
  protected final String TEXT_184 = ".breakString(sb_";
  protected final String TEXT_185 = ", \"";
  protected final String TEXT_186 = ";binary";
  protected final String TEXT_187 = ":: \" + item_";
  protected final String TEXT_188 = ", wrap_";
  protected final String TEXT_189 = ");";
  protected final String TEXT_190 = NL + "    \t\t\t\t\t\tif(!isPrintable_";
  protected final String TEXT_191 = "){" + NL + "    \t\t\t\t\t\t\tutil_";
  protected final String TEXT_192 = ".breakString(sb_";
  protected final String TEXT_193 = ", \"";
  protected final String TEXT_194 = ":: \" + item_";
  protected final String TEXT_195 = ", wrap_";
  protected final String TEXT_196 = ");" + NL + "    \t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\tutil_";
  protected final String TEXT_197 = ".breakString(sb_";
  protected final String TEXT_198 = ", \"";
  protected final String TEXT_199 = ": \" + item_";
  protected final String TEXT_200 = ", wrap_";
  protected final String TEXT_201 = ");" + NL + "    \t               \t\t}";
  protected final String TEXT_202 = NL + "\t                    util_";
  protected final String TEXT_203 = ".breakString(sb_";
  protected final String TEXT_204 = ", \"";
  protected final String TEXT_205 = ": \" + item_";
  protected final String TEXT_206 = ", wrap_";
  protected final String TEXT_207 = ");";
  protected final String TEXT_208 = NL + "\t\t}";
  protected final String TEXT_209 = NL + "                // follow LDIF rules or not" + NL + "                isPrintable_";
  protected final String TEXT_210 = " =  netscape.ldap.util.LDIF.isPrintable(value_";
  protected final String TEXT_211 = "_";
  protected final String TEXT_212 = ".getBytes(";
  protected final String TEXT_213 = ")); ";
  protected final String TEXT_214 = NL + "\t\t\t\t\t// If content doesn't follow LDIF rules, it must be base64 encoded" + NL + "\t\t\t\t\tif(!isPrintable_";
  protected final String TEXT_215 = "){" + NL + "\t\t\t\t\t\tencodingBase64 = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_216 = NL + "\t\t\t// Add \":\" to comply with base64 ldif syntax" + NL + "\t\t\t\tvalue_";
  protected final String TEXT_217 = "_";
  protected final String TEXT_218 = " = util_";
  protected final String TEXT_219 = ".getBase64StringOrNot(encodingBase64,value_";
  protected final String TEXT_220 = "_";
  protected final String TEXT_221 = ",";
  protected final String TEXT_222 = ");";
  protected final String TEXT_223 = NL + "                    util_";
  protected final String TEXT_224 = ".breakString(sb_";
  protected final String TEXT_225 = ", \"";
  protected final String TEXT_226 = ";binary";
  protected final String TEXT_227 = ":: \" + value_";
  protected final String TEXT_228 = "_";
  protected final String TEXT_229 = ", wrap_";
  protected final String TEXT_230 = ");";
  protected final String TEXT_231 = NL + "\t\t\t\t\t\tif(!isPrintable_";
  protected final String TEXT_232 = "){" + NL + "\t\t\t\t\t\t\tutil_";
  protected final String TEXT_233 = ".breakString(sb_";
  protected final String TEXT_234 = ", \"";
  protected final String TEXT_235 = ":: \" + value_";
  protected final String TEXT_236 = "_";
  protected final String TEXT_237 = ", wrap_";
  protected final String TEXT_238 = ");" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tutil_";
  protected final String TEXT_239 = ".breakString(sb_";
  protected final String TEXT_240 = ", \"";
  protected final String TEXT_241 = ": \" + value_";
  protected final String TEXT_242 = "_";
  protected final String TEXT_243 = ", wrap_";
  protected final String TEXT_244 = ");" + NL + "\t               \t\t}";
  protected final String TEXT_245 = NL + "\t                   util_";
  protected final String TEXT_246 = ".breakString(sb_";
  protected final String TEXT_247 = ", \"";
  protected final String TEXT_248 = ": \" + value_";
  protected final String TEXT_249 = "_";
  protected final String TEXT_250 = ", wrap_";
  protected final String TEXT_251 = ");";
  protected final String TEXT_252 = NL + "\t\tcanOutput_";
  protected final String TEXT_253 = " = true;";
  protected final String TEXT_254 = NL + "\t\tutil_";
  protected final String TEXT_255 = ".breakString(sb_";
  protected final String TEXT_256 = ", \"";
  protected final String TEXT_257 = ": \" + value_";
  protected final String TEXT_258 = "_";
  protected final String TEXT_259 = ", wrap_";
  protected final String TEXT_260 = ");" + NL + "\t\tcanOutput_";
  protected final String TEXT_261 = " = true;";
  protected final String TEXT_262 = NL;
  protected final String TEXT_263 = NL + "\t    }";
  protected final String TEXT_264 = "   \t\t\t\t";
  protected final String TEXT_265 = "\t\t\t\t\t\t" + NL + "\t\tsb_";
  protected final String TEXT_266 = ".append('\\n');\t\t" + NL + "\t\t" + NL + "\tif(canOutput_";
  protected final String TEXT_267 = "){\t\t" + NL + "\t\tpw_";
  protected final String TEXT_268 = ".write(sb_";
  protected final String TEXT_269 = ".toString());" + NL + "\t\t";
  protected final String TEXT_270 = NL + "            if(nb_line_";
  protected final String TEXT_271 = "%";
  protected final String TEXT_272 = " == 0) {\t\t" + NL + "    \t\tpw_";
  protected final String TEXT_273 = ".flush();" + NL + "    \t\t}" + NL + "\t\t";
  protected final String TEXT_274 = " \t\t" + NL + "\t\t" + NL + "    \tnb_line_";
  protected final String TEXT_275 = "++;" + NL + "    }\t";
  protected final String TEXT_276 = "    \t" + NL + "    \t//////////////////////////";
  protected final String TEXT_277 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        String cid = node.getUniqueName();
        String changetype = ElementParameterParser.getValue(node, "__CHANGETYPE__");
        boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));		
        String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
        
        List<Map<String, String>> multiValueColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MULTIVALUECOLUMNS__");
        List<Map<String, String>> modifyColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MODIFYCONFIG__");

    stringBuffer.append(TEXT_1);
    
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {    		

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    		
    			boolean generateOneAlready = false; //only for Modify append the char '-'
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			boolean firstLoop = true;
    			for (int i = 0; i < sizeColumns; i++) {    				
    				IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());					

    stringBuffer.append(TEXT_7);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    					
					if(!isPrimitive) {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_14);
    
} 

    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_21);
    				
					} else if(javaType == JavaTypesManager.STRING) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_24);
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_26);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_27);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_29);
    
					} else {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_32);
    
					}

     
	if(i==0) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    if(!"none".equals(changetype)){
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(changetype );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    if("delete".equals(changetype)){
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    
	if(!isPrimitive) {

    stringBuffer.append(TEXT_50);
    					
	} 

    stringBuffer.append(TEXT_51);
    
	continue;
 } 

    stringBuffer.append(TEXT_52);
     if ("delete".equals(changetype)) {
	if(firstLoop){
	
    
	if(!isPrimitive) {

    stringBuffer.append(TEXT_53);
    					
	} 

    stringBuffer.append(TEXT_54);
    	
	}
	firstLoop = false; 
	break; 
} 
     if ("modify".equals(changetype)) {
		String operation = null;
		boolean isMultiValue = false;   
		String separator = null;
		boolean isBinary = false;
		boolean isBase64 = false;
		for(Map<String, String> line:modifyColumns){// search in the configuration table
				String columnName = line.get("SCHEMA_COLUMN");				
				if(column.getLabel().equals(columnName)){
					operation = line.get("OPERATION");					
					isMultiValue = "true".equals(line.get("ISMULTIVALUE"));
					separator = line.get("SEPARATOR");
					isBinary = "true".equals(line.get("BINARY"));
					isBase64 = "true".equals(line.get("BASE64"));
					// Binary content --> always Base64 encoded
					// Explicit base64 encoding : base64 checkbox checked for this column
					if(isBinary && !isBase64){

    stringBuffer.append(TEXT_55);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_56);
    
					}
					if(isBinary || isBase64){
						
    stringBuffer.append(TEXT_57);
    	
					}
					break;
				}
		}	

    stringBuffer.append(TEXT_58);
    if(!"none".equals(operation)){
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(operation );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    if(isMultiValue){
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(separator );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_78);
    
			// Not binary and no explicit base64 encoding --> check if base 64 encoding needed
			if(!isBinary && !isBase64){
				
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    
			}
			
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_85);
    
			List<IMetadataColumn> columns_sub = metadata.getListColumns();
            for (int j = 0; j < columns_sub.size(); j++) {
                IMetadataColumn column_sub = columns_sub.get(j);
                JavaType javaType_sub = JavaTypesManager.getJavaTypeFromId(column_sub.getTalendType());
                if(javaType_sub == JavaTypesManager.BYTE_ARRAY && column_sub.getLabel().equals(column.getLabel())){

    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel() );
    if(isBinary){
    stringBuffer.append(TEXT_89);
    }
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_92);
    
                }else if(column_sub.getLabel().equals(column.getLabel())){
					if(isBase64){

    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    
					}else{

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    
				   }
                }
            }

    stringBuffer.append(TEXT_111);
    			
	}else{

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_116);
    
		// Not binary and no explicit base64 encoding --> check if base 64 encoding needed
		if(!isBinary && !isBase64){

    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    
		}
		
    stringBuffer.append(TEXT_119);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_125);
    
			List<IMetadataColumn> columns_sub = metadata.getListColumns();
            for (int j = 0; j < columns_sub.size(); j++) {
                IMetadataColumn column_sub = columns_sub.get(j);
                JavaType javaType_sub = JavaTypesManager.getJavaTypeFromId(column_sub.getTalendType());
                if(javaType_sub == JavaTypesManager.BYTE_ARRAY && column_sub.getLabel().equals(column.getLabel())){

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(column.getLabel() );
    if(isBinary){
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    
                }else if(column_sub.getLabel().equals(column.getLabel())){
					if(isBase64){

    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    
					}else{

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    
					}
                }
            }
	}

    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    }
  if(i==sizeColumns - 1){

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    }
}// here end the if modify

     if ("add".equals(changetype) || "none".equals(changetype)) {   
		boolean isMultiValue = false;
		String separator = null;
		boolean isBinary = false;
		boolean isBase64 = false;
		for(Map<String, String> line:multiValueColumns){// search in the configuration table
				String columnName = line.get("SCHEMA_COLUMN");				
				if(column.getLabel().equals(columnName)){
					isMultiValue = "true".equals(line.get("ISMULTIVALUE"));
					separator = line.get("SEPARATOR");
					isBinary = "true".equals(line.get("BINARY"));
					isBase64 = "true".equals(line.get("BASE64"));
					// Binary content --> always Base64 encoded
					// Explicit base64 encoding : base64 checkbox checked for this column
                    if(isBinary && !isBase64){

    stringBuffer.append(TEXT_160);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_161);
    
                    }
					if(isBinary || isBase64){
						
    stringBuffer.append(TEXT_162);
    	
					}
					break;
				}
		}

    stringBuffer.append(TEXT_163);
    if(isMultiValue){
    stringBuffer.append(TEXT_164);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(separator );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_175);
    
				// Not binary and no explicit base64 encoding --> check if base 64 encoding needed
				if(!isBinary && !isBase64){
					
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    
				}
				
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_182);
    
    			List<IMetadataColumn> columns_sub = metadata.getListColumns();
                for (int j = 0; j < columns_sub.size(); j++) {
                    IMetadataColumn column_sub = columns_sub.get(j);
                    JavaType javaType_sub = JavaTypesManager.getJavaTypeFromId(column_sub.getTalendType());
                    if(javaType_sub == JavaTypesManager.BYTE_ARRAY && column_sub.getLabel().equals(column.getLabel())){

    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(column.getLabel() );
    if(isBinary){
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    
                    }else if(column_sub.getLabel().equals(column.getLabel())){
    					if(isBase64){

    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    
					   }else{

    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    
					   }
                    }
			     }

    stringBuffer.append(TEXT_208);
    
	}else{

    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_213);
    
				// Not binary and no explicit base64 encoding --> check if base 64 encoding needed
				if(!isBinary && !isBase64){

    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    
				}
			
    stringBuffer.append(TEXT_216);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_222);
    
			List<IMetadataColumn> columns_sub = metadata.getListColumns();
            for (int j = 0; j < columns_sub.size(); j++) {
                IMetadataColumn column_sub = columns_sub.get(j);
                JavaType javaType_sub = JavaTypesManager.getJavaTypeFromId(column_sub.getTalendType());
                if(javaType_sub == JavaTypesManager.BYTE_ARRAY && column_sub.getLabel().equals(column.getLabel())){

    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(column.getLabel() );
    if(isBinary){
    stringBuffer.append(TEXT_226);
    }
    stringBuffer.append(TEXT_227);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    
                }else if(column_sub.getLabel().equals(column.getLabel())){
					if(isBase64){

    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    
					}else{

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    
					}
                }
            }
	}

    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    
}// here end the if add

     if ("modrdn".equals(changetype)) {

    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    
}// here end the if modrdn

    stringBuffer.append(TEXT_262);
    
	if(!isPrimitive) {

    stringBuffer.append(TEXT_263);
    					
	} 

    stringBuffer.append(TEXT_264);
     
}//here end the last for, the List "columns"

    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
     if(flushOnRow) { 
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    
			}
		
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    
	}
}//here end the first for, the List "conns"

    stringBuffer.append(TEXT_276);
    
  }
}  

    stringBuffer.append(TEXT_277);
    return stringBuffer.toString();
  }
}
