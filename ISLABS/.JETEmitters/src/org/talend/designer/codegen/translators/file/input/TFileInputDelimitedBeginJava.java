package org.talend.designer.codegen.translators.file.input;

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

public class TFileInputDelimitedBeginJava
{
  protected static String nl;
  public static synchronized TFileInputDelimitedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputDelimitedBeginJava result = new TFileInputDelimitedBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t\t\trowHelper_";
  protected final String TEXT_4 = ".valueToConn(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ");" + NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t\trowHelper_";
  protected final String TEXT_8 = ".valueToConnWithD(";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = ");" + NL + "\t\t";
  protected final String TEXT_12 = NL + "\t\t\trowHelper_";
  protected final String TEXT_13 = ".connToConn(";
  protected final String TEXT_14 = ",";
  protected final String TEXT_15 = ");" + NL + "\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tclass RowHelper_";
  protected final String TEXT_17 = "{" + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\tchar fieldSeparator_";
  protected final String TEXT_19 = "[] = null;" + NL + "\t\t\t\t\tpublic RowHelper_";
  protected final String TEXT_20 = "(){" + NL + "\t\t\t\t\t\t//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'. " + NL + "\t\t\t\t\t\tif ( ((String)";
  protected final String TEXT_21 = ").length() > 0 ){" + NL + "\t\t\t\t\t\t\tfieldSeparator_";
  protected final String TEXT_22 = " = ((String)";
  protected final String TEXT_23 = ").toCharArray();" + NL + "\t\t\t\t\t\t}else {\t\t\t" + NL + "\t\t\t\t\t\t\tthrow new IllegalArgumentException(\"Field Separator must be assigned a char.\"); " + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\t\t\tpublic void valueToConn_";
  protected final String TEXT_26 = "(";
  protected final String TEXT_27 = " ";
  protected final String TEXT_28 = ",";
  protected final String TEXT_29 = "Struct ";
  protected final String TEXT_30 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_32 = NL + "\t\t\t\t\tpublic void valueToConnWithD_";
  protected final String TEXT_33 = "(";
  protected final String TEXT_34 = " ";
  protected final String TEXT_35 = ",";
  protected final String TEXT_36 = "Struct ";
  protected final String TEXT_37 = ", routines.system.Dynamic ";
  protected final String TEXT_38 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_39 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_40 = NL + "\t\t\t\t\tpublic void connToConn_";
  protected final String TEXT_41 = "(";
  protected final String TEXT_42 = "Struct ";
  protected final String TEXT_43 = ",";
  protected final String TEXT_44 = "Struct ";
  protected final String TEXT_45 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t\t\tpublic void valueToConn(";
  protected final String TEXT_48 = " ";
  protected final String TEXT_49 = ",";
  protected final String TEXT_50 = "Struct ";
  protected final String TEXT_51 = ") throws java.lang.Exception{" + NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t\t\tpublic void valueToConnWithD(";
  protected final String TEXT_53 = " ";
  protected final String TEXT_54 = ",";
  protected final String TEXT_55 = "Struct ";
  protected final String TEXT_56 = ", routines.system.Dynamic ";
  protected final String TEXT_57 = ") throws java.lang.Exception{" + NL + "\t\t\t\t";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\tvalueToConn_";
  protected final String TEXT_59 = "(";
  protected final String TEXT_60 = ",";
  protected final String TEXT_61 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\tvalueToConnWithD_";
  protected final String TEXT_63 = "(";
  protected final String TEXT_64 = ",";
  protected final String TEXT_65 = ",";
  protected final String TEXT_66 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_67 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\tpublic void connToConn(";
  protected final String TEXT_69 = "Struct ";
  protected final String TEXT_70 = ",";
  protected final String TEXT_71 = "Struct ";
  protected final String TEXT_72 = ") throws java.lang.Exception{" + NL + "\t\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\tconnToConn_";
  protected final String TEXT_74 = "(";
  protected final String TEXT_75 = ",";
  protected final String TEXT_76 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\t}" + NL + "\t\t\t\tRowHelper_";
  protected final String TEXT_79 = " rowHelper_";
  protected final String TEXT_80 = "  = new RowHelper_";
  protected final String TEXT_81 = "();" + NL + "\t\t\t";
  protected final String TEXT_82 = NL + "\t";
  protected final String TEXT_83 = NL + "\t\t\tif(isFirstCheckDyn_";
  protected final String TEXT_84 = "){// for the header line" + NL + "\t\t\t\t";
  protected final String TEXT_85 = NL + "\t\t\t\t\tint colsLen_";
  protected final String TEXT_86 = " = row";
  protected final String TEXT_87 = ".length;" + NL + "\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\tint colsLen_";
  protected final String TEXT_89 = " = fid_";
  protected final String TEXT_90 = ".getColumnsCountOfCurrentRow();" + NL + "\t\t\t\t";
  protected final String TEXT_91 = NL + "    \t\t\tfor (int i = ";
  protected final String TEXT_92 = "; i < colsLen_";
  protected final String TEXT_93 = "-";
  protected final String TEXT_94 = "; i++) {" + NL + "\t\t\t    \troutines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_95 = " = new routines.system.DynamicMetadata();" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_96 = ".setName(";
  protected final String TEXT_97 = "row";
  protected final String TEXT_98 = "[i]";
  protected final String TEXT_99 = "fid_";
  protected final String TEXT_100 = ".get(i)";
  protected final String TEXT_101 = ".replaceAll(\"[ .-]+\", \"_\"));" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_102 = ".setDbName(dynamicMetadata_";
  protected final String TEXT_103 = ".getName());" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_104 = ".setType(\"id_String\");" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_105 = ".setDbType(\"VARCHAR\");" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_106 = ".setLength(100);" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_107 = ".setPrecision(0);" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_108 = ".setNullable(true);" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_109 = ".setKey(false);" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_110 = ".setSourceType(routines.system.DynamicMetadata.sourceTypes.demilitedFile);" + NL + "\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_111 = ".setColumnPosition(i);" + NL + "\t\t\t    \tdynamic_";
  protected final String TEXT_112 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_113 = ");" + NL + "\t\t\t    }" + NL + "    \t\t\tisFirstCheckDyn_";
  protected final String TEXT_114 = " = false;" + NL + "    \t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_115 = NL + "\t\t\tint footer_value_";
  protected final String TEXT_116 = " = ";
  protected final String TEXT_117 = ", random_value_";
  protected final String TEXT_118 = " = ";
  protected final String TEXT_119 = ";" + NL + "\t\t\tif(footer_value_";
  protected final String TEXT_120 = " >0 || random_value_";
  protected final String TEXT_121 = " > 0){" + NL + "\t\t\t\tthrow new java.lang.Exception(\"When the input source is a stream,footer and random shouldn't be bigger than 0.\");\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_122 = NL + "\t\t\tint footer_value_";
  protected final String TEXT_123 = " = ";
  protected final String TEXT_124 = ";" + NL + "\t\t\tif(footer_value_";
  protected final String TEXT_125 = " > 0){" + NL + "\t\t\t\tthrow new java.lang.Exception(\"When the input source is a stream,footer shouldn't be bigger than 0.\");" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\tint dynamic_column_count_";
  protected final String TEXT_127 = "=";
  protected final String TEXT_128 = ".getColumnCount()";
  protected final String TEXT_129 = "1";
  protected final String TEXT_130 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t\tint columnIndexWithD_";
  protected final String TEXT_132 = " = 0;" + NL + "\t\t\t\t";
  protected final String TEXT_133 = NL + "\t\t\t\t\tString temp = \"\"; " + NL + "\t\t\t\t";
  protected final String TEXT_134 = NL + "\t\t\t\t\tcolumnIndexWithD_";
  protected final String TEXT_135 = " = ";
  protected final String TEXT_136 = "+dynamic_column_count_";
  protected final String TEXT_137 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_138 = NL + "\t\t\t\t\tcolumnIndexWithD_";
  protected final String TEXT_139 = " = ";
  protected final String TEXT_140 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\t\t\t\ttemp  = ";
  protected final String TEXT_142 = ".get(columnIndexWithD_";
  protected final String TEXT_143 = ")";
  protected final String TEXT_144 = ";" + NL + "\t\t\t\t\t\t\tif(temp.length() > 0){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = " = temp;" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_147 = ".";
  protected final String TEXT_148 = " = ";
  protected final String TEXT_149 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_150 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_151 = ".";
  protected final String TEXT_152 = " = ";
  protected final String TEXT_153 = ".get(columnIndexWithD_";
  protected final String TEXT_154 = ")";
  protected final String TEXT_155 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_156 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_157 = ".clearColumnValues();" + NL + "\t\t\t\t\t\tint fieldCount = ";
  protected final String TEXT_158 = ".getColumnsCountOfCurrentRow();" + NL + "\t\t\t\t\t\tdynamic_column_count_";
  protected final String TEXT_159 = " = ";
  protected final String TEXT_160 = ".getColumnCount();" + NL + "\t\t\t\t\t\tfor (int i = 0; i < dynamic_column_count_";
  protected final String TEXT_161 = " ; i++) {" + NL + "\t\t\t\t\t\t\tif ((";
  protected final String TEXT_162 = "+i) < fieldCount){" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_163 = ".addColumnValue(";
  protected final String TEXT_164 = ".get(";
  protected final String TEXT_165 = "+i)";
  protected final String TEXT_166 = ");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\telse{" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_167 = ".addColumnValue(\"\");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_168 = ".";
  protected final String TEXT_169 = "=";
  protected final String TEXT_170 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_171 = NL + "\t\t\t\t\t\ttemp = ";
  protected final String TEXT_172 = ".get(columnIndexWithD_";
  protected final String TEXT_173 = ")";
  protected final String TEXT_174 = ";" + NL + "\t\t\t\t\t\tif(temp.length() > 0) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_175 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_176 = ".";
  protected final String TEXT_177 = " = temp.getBytes(";
  protected final String TEXT_178 = ");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_179 = NL + "                                ";
  protected final String TEXT_180 = ".";
  protected final String TEXT_181 = " = ParserUtils.parseTo_List(temp, ";
  protected final String TEXT_182 = ");";
  protected final String TEXT_183 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_184 = ".";
  protected final String TEXT_185 = " = ParserUtils.parseTo_Date(temp, ";
  protected final String TEXT_186 = ", false);" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_187 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_188 = ".";
  protected final String TEXT_189 = " = ParserUtils.parseTo_Date(temp, ";
  protected final String TEXT_190 = ");" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_191 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_192 = ".";
  protected final String TEXT_193 = " = ParserUtils.parseTo_";
  protected final String TEXT_194 = "(ParserUtils.parseTo_Number(temp, ";
  protected final String TEXT_195 = ", ";
  protected final String TEXT_196 = "));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_197 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_198 = ".";
  protected final String TEXT_199 = " = ParserUtils.parseTo_";
  protected final String TEXT_200 = "(temp);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_201 = NL + "\t\t\t\t\t\t} else {\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_202 = NL + "\t\t\t\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_203 = "' in '";
  protected final String TEXT_204 = "' connection, value is invalid or this column should be nullable or have a default value.\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_205 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_206 = ".";
  protected final String TEXT_207 = " = ";
  protected final String TEXT_208 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_209 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_210 = NL + "\t\t\t\t";
  protected final String TEXT_211 = NL + "\t\t\t\t \tint filedsum = ";
  protected final String TEXT_212 = ".getColumnsCountOfCurrentRow();" + NL + "\t\t\t\t \tif(filedsum < (";
  protected final String TEXT_213 = " ";
  protected final String TEXT_214 = "+ dynamic_column_count_";
  protected final String TEXT_215 = " -1";
  protected final String TEXT_216 = ")){" + NL + "\t\t\t\t\t \tthrow new RuntimeException(\"Column(s) missing\");" + NL + "\t\t\t\t\t } else if(filedsum > (";
  protected final String TEXT_217 = " ";
  protected final String TEXT_218 = "+ dynamic_column_count_";
  protected final String TEXT_219 = " -1";
  protected final String TEXT_220 = ")) {" + NL + "\t\t\t\t\t \tthrow new RuntimeException(\"Too many columns\");" + NL + "\t\t\t\t\t }     " + NL + "\t\t\t\t";
  protected final String TEXT_221 = NL + "    \t\t\t\t";
  protected final String TEXT_222 = ".";
  protected final String TEXT_223 = " = ";
  protected final String TEXT_224 = ".";
  protected final String TEXT_225 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_226 = NL + "\t\t\t";
  protected final String TEXT_227 = NL + "\t\t\t\t\t\t\tboolean isFirstCheckDyn_";
  protected final String TEXT_228 = " = true;" + NL + "\t\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_229 = " = new routines.system.Dynamic();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_230 = NL + "\t\t\t\tint nb_line_";
  protected final String TEXT_231 = " = 0;" + NL + "\t\t\t\torg.talend.fileprocess.FileInputDelimited fid_";
  protected final String TEXT_232 = " = null;" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_233 = NL + "\t\t\t\t\t\tObject filename_";
  protected final String TEXT_234 = " = ";
  protected final String TEXT_235 = ";\t" + NL + "\t\t\t\t\t\tjava.util.zip.ZipInputStream zis_";
  protected final String TEXT_236 = " = null;" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tif(filename_";
  protected final String TEXT_237 = " instanceof java.io.InputStream){" + NL + "\t\t\t\t\t\t\t\tzis_";
  protected final String TEXT_238 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream((java.io.InputStream)filename_";
  protected final String TEXT_239 = "));" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tzis_";
  protected final String TEXT_240 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_241 = "))));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_242 = NL + "\t\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_243 = NL + "\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_244 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tjava.util.zip.ZipEntry entry_";
  protected final String TEXT_245 = " = null;" + NL + "\t\t" + NL + "\t\t\t\t\t\twhile (true) {" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\tentry_";
  protected final String TEXT_246 = " = zis_";
  protected final String TEXT_247 = ".getNextEntry();" + NL + "\t\t\t\t\t\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_248 = NL + "\t\t\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_249 = NL + "\t\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_250 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif(entry_";
  protected final String TEXT_251 = " == null) {" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tif(entry_";
  protected final String TEXT_252 = ".isDirectory()){ //directory" + NL + "\t\t\t\t\t\t\t\tcontinue;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\tfid_";
  protected final String TEXT_253 = " = new org.talend.fileprocess.FileInputDelimited(zis_";
  protected final String TEXT_254 = ", ";
  protected final String TEXT_255 = ",";
  protected final String TEXT_256 = ",";
  protected final String TEXT_257 = ",";
  protected final String TEXT_258 = ",";
  protected final String TEXT_259 = ",";
  protected final String TEXT_260 = ",";
  protected final String TEXT_261 = ",";
  protected final String TEXT_262 = ", ";
  protected final String TEXT_263 = ");" + NL + "\t\t\t\t\t\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_264 = NL + "\t\t\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_265 = NL + "\t\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_266 = NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_267 = NL + "\t\t\t\t\t\tObject filename_";
  protected final String TEXT_268 = " = ";
  protected final String TEXT_269 = ";" + NL + "\t\t\t\t\t\tif(filename_";
  protected final String TEXT_270 = " instanceof java.io.InputStream){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_271 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tfid_";
  protected final String TEXT_272 = " = new org.talend.fileprocess.FileInputDelimited(";
  protected final String TEXT_273 = ", ";
  protected final String TEXT_274 = ",";
  protected final String TEXT_275 = ",";
  protected final String TEXT_276 = ",";
  protected final String TEXT_277 = ",";
  protected final String TEXT_278 = ",";
  protected final String TEXT_279 = ",";
  protected final String TEXT_280 = ",";
  protected final String TEXT_281 = ", ";
  protected final String TEXT_282 = ");" + NL + "\t\t\t\t\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_283 = NL + "\t\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_284 = NL + "\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_285 = NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_286 = NL + "\t\t\t\t\twhile (fid_";
  protected final String TEXT_287 = "!=null && fid_";
  protected final String TEXT_288 = ".nextRecord()) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_289 = NL + "\t\t\t    \t\t\t\t\t\t";
  protected final String TEXT_290 = " = null;\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_291 = "\t\t\t" + NL + "\t\t\t\t\t\t\t\t\tboolean whetherReject_";
  protected final String TEXT_292 = " = false;" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_293 = " = new ";
  protected final String TEXT_294 = "Struct();" + NL + "\t\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_295 = " " + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_296 = " = null; " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_297 = NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t    \t\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t        \t\t\t\t\twhetherReject_";
  protected final String TEXT_298 = " = true;" + NL + "\t\t\t        \t\t\t\t\t";
  protected final String TEXT_299 = NL + "\t\t\t            \t\t\t\t\tthrow(e);" + NL + "\t\t\t            \t\t\t\t";
  protected final String TEXT_300 = "                    " + NL + "\t\t\t                    \t\t\t\t";
  protected final String TEXT_301 = " = new ";
  protected final String TEXT_302 = "Struct();" + NL + "\t\t\t\t                \t\t\t\t";
  protected final String TEXT_303 = NL + "\t\t\t\t                \t\t\t\t";
  protected final String TEXT_304 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_305 = ";" + NL + "\t\t\t                \t\t\t\t\t";
  protected final String TEXT_306 = " = null;" + NL + "\t\t\t                \t\t\t\t";
  protected final String TEXT_307 = NL + "\t\t\t                \t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t                \t\t\t\t\t";
  protected final String TEXT_308 = " = null;" + NL + "\t\t\t                \t\t\t\t";
  protected final String TEXT_309 = NL + "\t\t\t            \t\t\t\t\t\t";
  protected final String TEXT_310 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_311 = ";" + NL + "\t\t\t            \t\t\t\t\t";
  protected final String TEXT_312 = NL + "\t\t\t    \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_313 = NL + "\t\t\t\t\t\t\t\t\t\t\tif(!whetherReject_";
  protected final String TEXT_314 = ") { " + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_315 = "      " + NL + "\t\t\t             \t\t\t\tif(";
  protected final String TEXT_316 = " == null){ " + NL + "\t\t\t            \t \t\t\t\t";
  protected final String TEXT_317 = " = new ";
  protected final String TEXT_318 = "Struct();" + NL + "\t\t\t             \t\t\t\t}\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_319 = " " + NL + "\t\t\t\t\t\t\t\t\t} " + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_320 = "\t\t\t\t" + NL + "\t                int dynamic_column_count_";
  protected final String TEXT_321 = "=";
  protected final String TEXT_322 = ".getColumnCount()";
  protected final String TEXT_323 = "1";
  protected final String TEXT_324 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_325 = NL + "\t\t\t\tif(";
  protected final String TEXT_326 = ".length == 1 && (\"\\015\").equals(";
  protected final String TEXT_327 = "[0])){//empty line when row separator is '\\n'" + NL + "\t\t\t\t\t";
  protected final String TEXT_328 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_329 = ".";
  protected final String TEXT_330 = " = ";
  protected final String TEXT_331 = ";" + NL + "\t\t\t\t\t";
  protected final String TEXT_332 = NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\t";
  protected final String TEXT_333 = NL + "\t\t\t\t\tfor(int i_";
  protected final String TEXT_334 = "=0;i_";
  protected final String TEXT_335 = "<";
  protected final String TEXT_336 = ".length;i_";
  protected final String TEXT_337 = "++){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_338 = "[i_";
  protected final String TEXT_339 = "]=";
  protected final String TEXT_340 = "[i_";
  protected final String TEXT_341 = "].trim();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_342 = NL + "\t\t\t\t\t\tString temp = \"\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_343 = NL + "\t                int columnIndexWithD_";
  protected final String TEXT_344 = " = 0; //Column Index " + NL + "\t                ";
  protected final String TEXT_345 = NL + "\t\t\t\t\t\tcolumnIndexWithD_";
  protected final String TEXT_346 = " = ";
  protected final String TEXT_347 = " + dynamic_column_count_";
  protected final String TEXT_348 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_349 = NL + "\t\t\t\t\t\tcolumnIndexWithD_";
  protected final String TEXT_350 = " = ";
  protected final String TEXT_351 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_352 = NL + "\t\t\t\t\t\tif(columnIndexWithD_";
  protected final String TEXT_353 = " < ";
  protected final String TEXT_354 = ".length){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_355 = "\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_356 = "[columnIndexWithD_";
  protected final String TEXT_357 = "]=";
  protected final String TEXT_358 = "[columnIndexWithD_";
  protected final String TEXT_359 = "].trim();\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_360 = NL + "\t\t\t\t\t\t\t\t\ttemp = ";
  protected final String TEXT_361 = "[columnIndexWithD_";
  protected final String TEXT_362 = "];" + NL + "\t\t\t\t\t\t\t\t\tif(temp.length() > 0){" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_363 = ".";
  protected final String TEXT_364 = " = temp;" + NL + "\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_365 = ".";
  protected final String TEXT_366 = " = ";
  protected final String TEXT_367 = ";" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_368 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_369 = ".";
  protected final String TEXT_370 = " = ";
  protected final String TEXT_371 = "[columnIndexWithD_";
  protected final String TEXT_372 = "];" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_373 = NL + "\t\t\t\t\t\t\t\tif(";
  protected final String TEXT_374 = "[columnIndexWithD_";
  protected final String TEXT_375 = "].length() > 0) {" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_376 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_377 = ".";
  protected final String TEXT_378 = " = ParserUtils.parseTo_Date(";
  protected final String TEXT_379 = "[columnIndexWithD_";
  protected final String TEXT_380 = "], ";
  protected final String TEXT_381 = ", false);" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_382 = NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_383 = ".";
  protected final String TEXT_384 = " = ParserUtils.parseTo_Date(";
  protected final String TEXT_385 = "[columnIndexWithD_";
  protected final String TEXT_386 = "], ";
  protected final String TEXT_387 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_388 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_389 = ".";
  protected final String TEXT_390 = " = ParserUtils.parseTo_";
  protected final String TEXT_391 = "(ParserUtils.parseTo_Number(";
  protected final String TEXT_392 = "[columnIndexWithD_";
  protected final String TEXT_393 = "], ";
  protected final String TEXT_394 = ", ";
  protected final String TEXT_395 = "));" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_396 = "\t\t\t\t\t\t\t" + NL + "\t\t    \t\t\t\t\t\t\t";
  protected final String TEXT_397 = ".";
  protected final String TEXT_398 = " = ";
  protected final String TEXT_399 = "[columnIndexWithD_";
  protected final String TEXT_400 = "].getBytes(";
  protected final String TEXT_401 = ");" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_402 = "                          ";
  protected final String TEXT_403 = NL + "                                        ";
  protected final String TEXT_404 = ".";
  protected final String TEXT_405 = " = ParserUtils.parseTo_List(";
  protected final String TEXT_406 = "[columnIndexWithD_";
  protected final String TEXT_407 = "],String.valueOf(fieldSeparator_";
  protected final String TEXT_408 = "[0]));";
  protected final String TEXT_409 = NL + "\t\t\t\t\t\t\t\t\t    dynamic_column_count_";
  protected final String TEXT_410 = " = ";
  protected final String TEXT_411 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t\t\tfor (int i = 0; i < dynamic_column_count_";
  protected final String TEXT_412 = "; i++) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_413 = ".clearColumnValues();" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\tint fieldCount = ";
  protected final String TEXT_414 = ".length;\t" + NL + "\t\t\t\t\t\t\t\t\t\tfor (int i = 0; i < dynamic_column_count_";
  protected final String TEXT_415 = "; i++) {" + NL + "\t\t\t\t\t\t\t\t\t\t\tif ((";
  protected final String TEXT_416 = "+i) < fieldCount)" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_417 = ".addColumnValue(";
  protected final String TEXT_418 = "[";
  protected final String TEXT_419 = "+i]);" + NL + "\t\t\t\t\t\t\t\t\t\t\telse" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_420 = ".addColumnValue(\"\");" + NL + "\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_421 = ".";
  protected final String TEXT_422 = " = ";
  protected final String TEXT_423 = ";" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_424 = NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_425 = ".";
  protected final String TEXT_426 = " = ParserUtils.parseTo_";
  protected final String TEXT_427 = "(";
  protected final String TEXT_428 = "[columnIndexWithD_";
  protected final String TEXT_429 = "]);" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_430 = "\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_431 = ".";
  protected final String TEXT_432 = " = ";
  protected final String TEXT_433 = ";" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_434 = "\t" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_435 = ".";
  protected final String TEXT_436 = " = ";
  protected final String TEXT_437 = ";" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_438 = NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_439 = NL + " \t\t\t\t\tint filedsum = ";
  protected final String TEXT_440 = ".length;" + NL + " \t\t\t\t\tif(filedsum < (";
  protected final String TEXT_441 = " ";
  protected final String TEXT_442 = "+ dynamic_column_count_";
  protected final String TEXT_443 = "-1";
  protected final String TEXT_444 = ")){" + NL + " \t\t\t\t\t\tthrow new java.lang.Exception(\"Column(s) missing\");" + NL + " \t\t\t\t\t} else if(filedsum > (";
  protected final String TEXT_445 = " ";
  protected final String TEXT_446 = "+ dynamic_column_count_";
  protected final String TEXT_447 = " -1";
  protected final String TEXT_448 = ")) {" + NL + " \t\t\t\t\t\tthrow new RuntimeException(\"Too many columns\");" + NL + " \t\t\t\t\t}     " + NL + "\t\t\t\t";
  protected final String TEXT_449 = NL + "    \t\t\t\t";
  protected final String TEXT_450 = ".";
  protected final String TEXT_451 = " = ";
  protected final String TEXT_452 = ".";
  protected final String TEXT_453 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_454 = NL + "\t\t\t";
  protected final String TEXT_455 = NL + "\t\t\t\t\t\t\tboolean isFirstCheckDyn_";
  protected final String TEXT_456 = " = true;" + NL + "\t\t\t\t\t\t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_457 = " = new routines.system.Dynamic();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_458 = NL + "\t\t\t\tint nb_line_";
  protected final String TEXT_459 = " = 0;" + NL + "\t\t\t\tint footer_";
  protected final String TEXT_460 = " = ";
  protected final String TEXT_461 = ";" + NL + "\t\t\t\tint totalLine";
  protected final String TEXT_462 = " = 0;" + NL + "\t\t\t\tint limit";
  protected final String TEXT_463 = " = ";
  protected final String TEXT_464 = ";" + NL + "\t\t\t\tint lastLine";
  protected final String TEXT_465 = " = -1;\t" + NL + "\t\t\t\t" + NL + "\t\t\t\tchar fieldSeparator_";
  protected final String TEXT_466 = "[] = null;" + NL + "\t\t\t\t" + NL + "\t\t\t\t//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'. " + NL + "\t\t\t\tif ( ((String)";
  protected final String TEXT_467 = ").length() > 0 ){" + NL + "\t\t\t\t\tfieldSeparator_";
  protected final String TEXT_468 = " = ((String)";
  protected final String TEXT_469 = ").toCharArray();" + NL + "\t\t\t\t}else {\t\t\t" + NL + "\t\t\t\t\tthrow new IllegalArgumentException(\"Field Separator must be assigned a char.\"); " + NL + "\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t\tchar rowSeparator_";
  protected final String TEXT_470 = "[] = null;" + NL + "\t\t\t" + NL + "\t\t\t\t//support passing value (property: Row Separator) by 'context.rs' or 'globalMap.get(\"rs\")'. " + NL + "\t\t\t\tif ( ((String)";
  protected final String TEXT_471 = ").length() > 0 ){" + NL + "\t\t\t\t\trowSeparator_";
  protected final String TEXT_472 = " = ((String)";
  protected final String TEXT_473 = ").toCharArray();" + NL + "\t\t\t\t}else {" + NL + "\t\t\t\t\tthrow new IllegalArgumentException(\"Row Separator must be assigned a char.\"); " + NL + "\t\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t\tObject filename_";
  protected final String TEXT_474 = " = ";
  protected final String TEXT_475 = ";\t\t" + NL + "\t\t\t\tcom.talend.csv.CSVReader csvReader";
  protected final String TEXT_476 = " = null;" + NL + "\t" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_477 = NL + "\t        \t\t\tjava.util.zip.ZipInputStream zis_";
  protected final String TEXT_478 = " = null;" + NL + "\t        \t\t\ttry {" + NL + "\t\t        \t\t\tif(filename_";
  protected final String TEXT_479 = " instanceof java.io.InputStream){" + NL + "\t\t        \t\t\t\tzis_";
  protected final String TEXT_480 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream((java.io.InputStream)filename_";
  protected final String TEXT_481 = "));" + NL + "\t\t        \t\t\t}else{" + NL + "\t\t        \t\t\t\tzis_";
  protected final String TEXT_482 = " = new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_483 = "))));" + NL + "\t\t        \t\t\t}" + NL + "\t        \t\t\t} catch(java.lang.Exception e) {" + NL + "\t        \t\t\t\t";
  protected final String TEXT_484 = NL + "\t\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_485 = NL + "\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_486 = NL + "\t        \t\t\t}" + NL + "\t        \t\t\tjava.util.zip.ZipEntry entry_";
  protected final String TEXT_487 = " = null;" + NL + "\t\t        " + NL + "\t\t\t\t        while (true) {" + NL + "\t\t\t        \t\ttry {" + NL + "\t        \t\t\t\t\tentry_";
  protected final String TEXT_488 = " = zis_";
  protected final String TEXT_489 = ".getNextEntry();" + NL + "\t        \t\t\t\t} catch(java.lang.Exception e) {" + NL + "\t        \t\t\t\t\t";
  protected final String TEXT_490 = NL + "\t\t\t\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_491 = NL + "\t\t\t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_492 = NL + "\t        \t\t\t\t}" + NL + "\t        \t\t\t\tif(entry_";
  protected final String TEXT_493 = " == null) {" + NL + "\t\t\t\t\t\t\t\tbreak;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t        \t\t\t\tif(entry_";
  protected final String TEXT_494 = ".isDirectory()){ //directory" + NL + "\t        \t\t\t\t\tcontinue;" + NL + "\t        \t\t\t\t}" + NL + "\t        \t\t\t\tString[] row";
  protected final String TEXT_495 = "=null;" + NL + "\t        \t\t\t\tint currentLine";
  protected final String TEXT_496 = " = 0;" + NL + "\t        \t\t\t\tint outputLine";
  protected final String TEXT_497 = " = 0;" + NL + "\t        \t\t\t\ttry {//TD110 begin" + NL + "\t        \t\t\t\t\tcsvReader";
  protected final String TEXT_498 = "=new com.talend.csv.CSVReader(zis_";
  protected final String TEXT_499 = ", fieldSeparator_";
  protected final String TEXT_500 = "[0], ";
  protected final String TEXT_501 = ");" + NL + "\t\t\t\t\t";
  protected final String TEXT_502 = NL + "\t\t\t\t\t\tString[] row";
  protected final String TEXT_503 = "=null;" + NL + "\t\t\t\t\t\tint currentLine";
  protected final String TEXT_504 = " = 0;" + NL + "\t        \t\t\tint outputLine";
  protected final String TEXT_505 = " = 0;" + NL + "\t\t\t\t\t\ttry {//TD110 begin" + NL + "\t\t\t\t\t\t\tif(filename_";
  protected final String TEXT_506 = " instanceof java.io.InputStream){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_507 = NL + "\t\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_508 = "=new com.talend.csv.CSVReader((java.io.InputStream)filename_";
  protected final String TEXT_509 = ", fieldSeparator_";
  protected final String TEXT_510 = "[0], ";
  protected final String TEXT_511 = ");" + NL + "\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_512 = "=new com.talend.csv.CSVReader(new java.io.BufferedReader(new java.io.InputStreamReader(" + NL + "\t\t                \t\tnew java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_513 = ")),";
  protected final String TEXT_514 = ")), fieldSeparator_";
  protected final String TEXT_515 = "[0]);" + NL + "\t\t        \t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_516 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tcsvReader";
  protected final String TEXT_517 = ".setTrimWhitespace(false);" + NL + "\t\t\t\t\tif ( (rowSeparator_";
  protected final String TEXT_518 = "[0] != '\\n') && (rowSeparator_";
  protected final String TEXT_519 = "[0] != '\\r') )" + NL + "\t        \t\t\tcsvReader";
  protected final String TEXT_520 = ".setLineEnd(\"\"+rowSeparator_";
  protected final String TEXT_521 = "[0]);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_522 = NL + "\t        \t\t\t\tcsvReader";
  protected final String TEXT_523 = ".setQuoteChar('";
  protected final String TEXT_524 = "');" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_525 = NL + "\t\t\t\t\t\t\tString textEnclosure1_";
  protected final String TEXT_526 = " = ";
  protected final String TEXT_527 = "; " + NL + "\t\t\t\t\t\t\tchar textEnclosure_";
  protected final String TEXT_528 = "[] = null;" + NL + "\t\t\t        " + NL + "\t    \t\t\t\t    if(((String)textEnclosure1_";
  protected final String TEXT_529 = ").length() > 0 ){ " + NL + "\t  \t\t\t\t\t\t\ttextEnclosure_";
  protected final String TEXT_530 = " = ((String)textEnclosure1_";
  protected final String TEXT_531 = ").toCharArray(); " + NL + "\t\t\t\t\t\t\t}else { " + NL + "\t            \t\t\t\tthrow new IllegalArgumentException(\"Text Enclosure must be assigned a char.\"); " + NL + "\t        \t\t\t\t}" + NL + "\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_532 = ".setQuoteChar(textEnclosure_";
  protected final String TEXT_533 = "[0]); " + NL + "\t\t\t\t\t\t";
  protected final String TEXT_534 = NL + "\t            \t\t\t\tcsvReader";
  protected final String TEXT_535 = ".setEscapeChar('\\\\');" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_536 = NL + "\t            \t\t\t\tcsvReader";
  protected final String TEXT_537 = ".setEscapeChar(csvReader";
  protected final String TEXT_538 = ".getQuoteChar());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_539 = NL + "\t            \t\t\t\t//?????doesn't work for other escapeChar" + NL + "\t            \t\t\t\t//the default escape mode is double escape" + NL + "\t            \t\t\t\tcsvReader";
  protected final String TEXT_540 = ".setEscapeChar(csvReader";
  protected final String TEXT_541 = ".getQuoteChar());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_542 = " " + NL + "\t\t        \t\t\tString escapeChar1_";
  protected final String TEXT_543 = " = ";
  protected final String TEXT_544 = ";          " + NL + "\t\t        \t\t\tchar escapeChar_";
  protected final String TEXT_545 = "[] = null;" + NL + "\t\t\t        " + NL + "\t\t\t\t\t        if(((String)escapeChar1_";
  protected final String TEXT_546 = ").length() > 0 ){ " + NL + "\t\t\t\t\t        \tescapeChar_";
  protected final String TEXT_547 = " = ((String)escapeChar1_";
  protected final String TEXT_548 = ").toCharArray(); " + NL + "\t\t\t\t\t  \t\t}else { " + NL + "\t\t        \t\t\t    throw new IllegalArgumentException(\"Escape Char must be assigned a char.\"); " + NL + "\t\t        \t\t\t}" + NL + "\t\t       \t\t\t\tif(escapeChar_";
  protected final String TEXT_549 = "[0] == '\\\\'){" + NL + "\t\t       \t\t\t\t\tcsvReader";
  protected final String TEXT_550 = ".setEscapeChar('\\\\');" + NL + "\t\t       \t\t\t\t}else if(escapeChar_";
  protected final String TEXT_551 = "[0] ==";
  protected final String TEXT_552 = "'";
  protected final String TEXT_553 = "'";
  protected final String TEXT_554 = "textEnclosure_";
  protected final String TEXT_555 = "[0]";
  protected final String TEXT_556 = "){" + NL + "\t\t       \t\t\t\t\tcsvReader";
  protected final String TEXT_557 = ".setEscapeChar(csvReader";
  protected final String TEXT_558 = ".getQuoteChar());" + NL + "\t\t       \t\t\t\t} else {" + NL + "\t\t       \t\t\t\t\t//the default escape mode is double escape" + NL + "\t\t       \t\t\t\t\tcsvReader";
  protected final String TEXT_559 = ".setEscapeChar(csvReader";
  protected final String TEXT_560 = ".getQuoteChar());" + NL + "\t\t       \t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_561 = "      " + NL + "\t\t" + NL + "\t\t\t" + NL + "\t\t\t\t\t\tif(footer_";
  protected final String TEXT_562 = " > 0){" + NL + "\t\t\t\t\t\tfor(totalLine";
  protected final String TEXT_563 = "=0;totalLine";
  protected final String TEXT_564 = " < ";
  protected final String TEXT_565 = "; totalLine";
  protected final String TEXT_566 = "++){" + NL + "\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_567 = ".readNext();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tcsvReader";
  protected final String TEXT_568 = ".setSkipEmptyRecords(";
  protected final String TEXT_569 = ");" + NL + "\t\t\t            while (csvReader";
  protected final String TEXT_570 = ".readNext()) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_571 = NL + "\t\t\t\t\t\t\t\trow";
  protected final String TEXT_572 = "=csvReader";
  protected final String TEXT_573 = ".getValues();" + NL + "\t\t\t\t\t\t\t\tif(!(row";
  protected final String TEXT_574 = ".length == 1 && (\"\\015\").equals(row";
  protected final String TEXT_575 = "[0]))){//empty line when row separator is '\\n'" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_576 = NL + "\t                " + NL + "\t                \t\ttotalLine";
  protected final String TEXT_577 = "++;" + NL + "\t                " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_578 = NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_579 = NL + "\t                " + NL + "\t\t\t            }" + NL + "\t            \t\tint lastLineTemp";
  protected final String TEXT_580 = " = totalLine";
  protected final String TEXT_581 = " - footer_";
  protected final String TEXT_582 = "   < 0? 0 : totalLine";
  protected final String TEXT_583 = " - footer_";
  protected final String TEXT_584 = " ;" + NL + "\t            \t\tif(lastLine";
  protected final String TEXT_585 = " > 0){" + NL + "\t                \t\tlastLine";
  protected final String TEXT_586 = " = lastLine";
  protected final String TEXT_587 = " < lastLineTemp";
  protected final String TEXT_588 = " ? lastLine";
  protected final String TEXT_589 = " : lastLineTemp";
  protected final String TEXT_590 = "; " + NL + "\t            \t\t}else {" + NL + "\t                \t\tlastLine";
  protected final String TEXT_591 = " = lastLineTemp";
  protected final String TEXT_592 = ";" + NL + "\t            \t\t}" + NL + "\t         " + NL + "\t\t\t          \tcsvReader";
  protected final String TEXT_593 = ".close();" + NL + "\t\t\t\t        if(filename_";
  protected final String TEXT_594 = " instanceof java.io.InputStream){" + NL + "\t\t\t\t \t\t\tcsvReader";
  protected final String TEXT_595 = "=new com.talend.csv.CSVReader((java.io.InputStream)filename_";
  protected final String TEXT_596 = ", fieldSeparator_";
  protected final String TEXT_597 = "[0], ";
  protected final String TEXT_598 = ");" + NL + "\t\t        \t\t}else{" + NL + "\t\t\t\t \t\t\tcsvReader";
  protected final String TEXT_599 = "=new com.talend.csv.CSVReader(new java.io.BufferedReader(new java.io.InputStreamReader(" + NL + "\t\t\t\t          \tnew java.io.FileInputStream(String.valueOf(filename_";
  protected final String TEXT_600 = ")),";
  protected final String TEXT_601 = ")), fieldSeparator_";
  protected final String TEXT_602 = "[0]);" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tcsvReader";
  protected final String TEXT_603 = ".setTrimWhitespace(false);" + NL + "\t\t\t\t\t\tif ( (rowSeparator_";
  protected final String TEXT_604 = "[0] != '\\n') && (rowSeparator_";
  protected final String TEXT_605 = "[0] != '\\r') )\t" + NL + "\t        \t\t\t\tcsvReader";
  protected final String TEXT_606 = ".setLineEnd(\"\"+rowSeparator_";
  protected final String TEXT_607 = "[0]);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_608 = NL + "\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_609 = ".setQuoteChar('";
  protected final String TEXT_610 = "');" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_611 = NL + "\t\t\t\t\t\t\tcsvReader";
  protected final String TEXT_612 = ".setQuoteChar(textEnclosure_";
  protected final String TEXT_613 = "[0]);" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_614 = NL + "\t        \t\t\t\tcsvReader";
  protected final String TEXT_615 = ".setEscapeChar('\\\\');" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_616 = NL + "\t        \t\t\t\tcsvReader";
  protected final String TEXT_617 = ".setEscapeChar(csvReader";
  protected final String TEXT_618 = ".getQuoteChar());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_619 = NL + "\t        \t\t\t\t//?????doesn't work for other escapeChar" + NL + "\t        \t\t\t\t//the default escape mode is double escape" + NL + "\t        \t\t\t\tcsvReader";
  protected final String TEXT_620 = ".setEscapeChar(csvReader";
  protected final String TEXT_621 = ".getQuoteChar());" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_622 = " " + NL + "\t       \t\t\t\t\tif(escapeChar_";
  protected final String TEXT_623 = "[0] == '\\\\'){" + NL + "\t       \t\t\t\t\t\tcsvReader";
  protected final String TEXT_624 = ".setEscapeChar('\\\\');" + NL + "\t       \t\t\t\t\t}else if(escapeChar_";
  protected final String TEXT_625 = "[0] == ";
  protected final String TEXT_626 = "'";
  protected final String TEXT_627 = "'";
  protected final String TEXT_628 = "textEnclosure_";
  protected final String TEXT_629 = "[0]";
  protected final String TEXT_630 = "){" + NL + "\t       \t\t\t\t\t\tcsvReader";
  protected final String TEXT_631 = ".setEscapeChar(csvReader";
  protected final String TEXT_632 = ".getQuoteChar());" + NL + "\t       \t\t\t\t\t} else {" + NL + "\t       \t\t\t\t\t\t//the default escape mode is double escape" + NL + "\t        \t\t\t\t\tcsvReader";
  protected final String TEXT_633 = ".setEscapeChar(csvReader";
  protected final String TEXT_634 = ".getQuoteChar());" + NL + "\t       \t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_635 = "  " + NL + "\t        \t\t}" + NL + "\t        " + NL + "\t\t\t        if(limit";
  protected final String TEXT_636 = " != 0){" + NL + "\t\t\t        \tfor(currentLine";
  protected final String TEXT_637 = "=0;currentLine";
  protected final String TEXT_638 = " < ";
  protected final String TEXT_639 = ";currentLine";
  protected final String TEXT_640 = "++){" + NL + "\t\t\t        \t\tcsvReader";
  protected final String TEXT_641 = ".readNext();" + NL + "\t\t\t        \t}" + NL + "\t\t\t        }" + NL + "\t\t\t        csvReader";
  protected final String TEXT_642 = ".setSkipEmptyRecords(";
  protected final String TEXT_643 = ");" + NL + "\t        " + NL + "\t    \t\t} catch(java.lang.Exception e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_644 = NL + "\t\t\t\t\t\tthrow e;" + NL + "\t\t\t\t\t";
  protected final String TEXT_645 = NL + "\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "\t\t\t\t\t";
  protected final String TEXT_646 = NL + "\t    \t\t}//TD110 end" + NL + "\t        " + NL + "\t        \twhile ( limit";
  protected final String TEXT_647 = " != 0 && csvReader";
  protected final String TEXT_648 = "!=null && csvReader";
  protected final String TEXT_649 = ".readNext() ) { " + NL + "\t        " + NL + "\t\t        \trow";
  protected final String TEXT_650 = "=csvReader";
  protected final String TEXT_651 = ".getValues();" + NL + "\t        \t" + NL + "\t\t\t\t\t";
  protected final String TEXT_652 = NL + "\t        \t\t\tif(row";
  protected final String TEXT_653 = ".length == 1 && (\"\\015\").equals(row";
  protected final String TEXT_654 = "[0])){//empty line when row separator is '\\n'" + NL + "\t        \t\t\t\tcontinue;" + NL + "\t        \t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_655 = NL + "\t        \t" + NL + "\t        \t" + NL + "\t        \t\tcurrentLine";
  protected final String TEXT_656 = "++;" + NL + "\t            " + NL + "\t\t            if(lastLine";
  protected final String TEXT_657 = " > -1 && currentLine";
  protected final String TEXT_658 = " > lastLine";
  protected final String TEXT_659 = ") {" + NL + "\t\t                break;" + NL + "\t    \t        }" + NL + "\t        \t    outputLine";
  protected final String TEXT_660 = "++;" + NL + "\t            \tif (limit";
  protected final String TEXT_661 = " > 0 && outputLine";
  protected final String TEXT_662 = " > limit";
  protected final String TEXT_663 = ") {" + NL + "\t                \tbreak;" + NL + "\t            \t}  " + NL + "\t                                                                      " + NL + "\t\t\t\t\t";
  protected final String TEXT_664 = NL + "\t    \t\t\t\t\t\t\t";
  protected final String TEXT_665 = " = null;\t\t\t" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_666 = NL + "\t\t\t\t\t\t\t\tboolean whetherReject_";
  protected final String TEXT_667 = " = false;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_668 = " = new ";
  protected final String TEXT_669 = "Struct();" + NL + "\t\t\t\t\t\t\t\ttry {\t\t\t" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_670 = " " + NL + "\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_671 = " = null; " + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_672 = NL + "\t    \t\t\t\t\t\t} catch (java.lang.Exception e) {" + NL + "\t\t\t\t\t\t\t        whetherReject_";
  protected final String TEXT_673 = " = true;" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_674 = NL + "            \t\t\t\t\t\t\tthrow(e);" + NL + "            \t\t\t\t\t\t";
  protected final String TEXT_675 = NL + "\t\t\t\t\t\t                    ";
  protected final String TEXT_676 = " = new ";
  protected final String TEXT_677 = "Struct();" + NL + "                \t\t\t\t\t\t\t";
  protected final String TEXT_678 = NL + "                \t\t\t\t\t\t\t";
  protected final String TEXT_679 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_680 = ";" + NL + "                \t\t\t\t\t\t\t";
  protected final String TEXT_681 = " = null;" + NL + "                \t\t\t\t\t\t";
  protected final String TEXT_682 = NL + "                \t\t\t\t\t\t\tSystem.err.println(e.getMessage());" + NL + "                \t\t\t\t\t\t\t";
  protected final String TEXT_683 = " = null;" + NL + "                \t\t\t\t\t\t";
  protected final String TEXT_684 = NL + "            \t\t\t\t\t\t\t\t";
  protected final String TEXT_685 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_686 = ";" + NL + "            \t\t\t\t\t\t\t";
  protected final String TEXT_687 = NL + "\t    \t\t\t\t\t\t}" + NL + "\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_688 = NL + "\t\t\t\t\t\t\t\t\t\tif(!whetherReject_";
  protected final String TEXT_689 = ") { " + NL + "\t\t\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_690 = "      " + NL + "\t             \t\t\t\t\tif(";
  protected final String TEXT_691 = " == null){ " + NL + "\t            \t \t\t\t\t\t";
  protected final String TEXT_692 = " = new ";
  protected final String TEXT_693 = "Struct();" + NL + "\t             \t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_694 = " " + NL + "\t\t\t\t\t\t\t\t} " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_695 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
	class DefaultRowUtil {
		String cid = "";
		INode node;
		int schemaOptNum;
		int columnListSize;
		boolean isOptimizeCode;
		boolean isBehindDynamic;
	
		boolean useV2C = false;
		IMetadataTable V2CMetadata;
		String V2CTargetConnName;
		String V2CSourceValueClass;
		String V2CSourceValueName;
		
		public void prepareOptimizeParam(IMetadataTable metadata,int schemaOptNum){
			this.schemaOptNum=schemaOptNum;
			this.columnListSize = metadata.getListColumns().size();
			this.isOptimizeCode = schemaOptNum < this.columnListSize;
		}
		
		public void prepareValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int schemaOptNum){
			this.node = node;
			this.V2CMetadata = metadata;
			this.V2CTargetConnName = targetConnName;
			this.V2CSourceValueClass = sourceValueClass;
			this.V2CSourceValueName = sourceValueName;
			this.useV2C = true;
			prepareOptimizeParam(metadata, schemaOptNum);
		}
		
		public void codeForValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int start , int end){
		}
		
		public void callValueToConn(String sourceValueName, String targetConnName){
			if(isOptimizeCode){
		
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_6);
    
			}else{
				codeForValueToConn(node, V2CMetadata, V2CSourceValueClass, V2CSourceValueName, V2CTargetConnName, 0, columnListSize);
			}
		}
		
		boolean useV2CWithD = false;
		IMetadataTable V2CWithDMetadata;
		String V2CWithDTargetConnName;
		String V2CWithDSourceValueClass;
		String V2CWithDSourceValueName;
		String V2CWithDDynamicName;
		public void prepareValueToConnWithD(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, String dynamicName, int schemaOptNum){
			this.node = node;
			this.V2CWithDMetadata = metadata;
			this.V2CWithDTargetConnName = targetConnName;
			this.V2CWithDSourceValueClass = sourceValueClass;
			this.V2CWithDSourceValueName = sourceValueName;
			this.V2CWithDDynamicName = dynamicName;
			this.useV2CWithD = true;
			prepareOptimizeParam(metadata, schemaOptNum);
		}
		
		public boolean codeForValueToConnWithD(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, String dynamicName ,int start , int end){
			return false;
		}
		
		public void callValueToConnWithD(String sourceValueName, String targetConnName, String dynamicName){
			if(isOptimizeCode){
		
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_11);
    
			}else{
				codeForValueToConnWithD(node, V2CWithDMetadata, V2CWithDSourceValueClass, V2CWithDSourceValueName, V2CWithDTargetConnName, V2CWithDDynamicName, 0, columnListSize);
			}
		}
		
		IMetadataTable C2CMetadata;
		String C2CTargetConnName;
		String C2CSourceConnName;
		boolean useC2C = false;
		public void prepareConnToConn(IMetadataTable metadata, String sourceConnName, String targetConnName){
			this.C2CMetadata = metadata;
			this.C2CTargetConnName = targetConnName;
			this.C2CSourceConnName = sourceConnName;
			this.useC2C = true;
		}
		
		public void codeForConnToConn(INode node, IMetadataTable metadata, String sourceConnName, String targetConnName, int start ,int end){
		}
		
		public void callConnToConn(String sourceConnName, String targetConnName){
			if(isOptimizeCode){
		
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_15);
    
			}else{
				codeForConnToConn(node, C2CMetadata, C2CSourceConnName, C2CTargetConnName, 0, columnListSize);
			}
		}
		
		
		public void generateClass(String delim1){
		  	if(isOptimizeCode){
				cid = node.getUniqueName();
				int methodNum=(columnListSize%schemaOptNum==0?columnListSize/schemaOptNum:(columnListSize/schemaOptNum)+1);
				
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    if(delim1!=null){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    
				int start=0;
				int end=0;
				for(int i=0;i<methodNum;i++){
					start=i*schemaOptNum;
					if(i==(methodNum-1)){
						end=columnListSize;
					}else{
						end=(i+1)*schemaOptNum;
					}
					if(useV2C){
					
    stringBuffer.append(TEXT_25);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(V2CSourceValueClass);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_30);
    codeForValueToConn(node, V2CMetadata, V2CSourceValueClass, V2CSourceValueName, V2CTargetConnName, start, end);
    stringBuffer.append(TEXT_31);
    	
					}
					if(useV2CWithD){
					
    stringBuffer.append(TEXT_32);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(V2CWithDSourceValueClass);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_38);
    this.isBehindDynamic = codeForValueToConnWithD(node, V2CWithDMetadata, V2CWithDSourceValueClass, V2CWithDSourceValueName, V2CWithDTargetConnName, V2CWithDDynamicName, start, end);
    stringBuffer.append(TEXT_39);
    		
					}
					if(useC2C){
					
    stringBuffer.append(TEXT_40);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_45);
    codeForConnToConn(node, C2CMetadata, C2CSourceConnName, C2CTargetConnName, start, end);
    stringBuffer.append(TEXT_46);
    
					}
				}
				if(useV2C){//Call all split methods in one method
				
    stringBuffer.append(TEXT_47);
    stringBuffer.append(V2CSourceValueClass);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_51);
    	
				}
				if(useV2CWithD){
				
    stringBuffer.append(TEXT_52);
    stringBuffer.append(V2CWithDSourceValueClass);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_57);
    
				}
				for(int i=0;i<methodNum;i++){
					if(useV2C){
					
    stringBuffer.append(TEXT_58);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(V2CSourceValueName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(V2CTargetConnName);
    stringBuffer.append(TEXT_61);
    
					}
					if(useV2CWithD){
					
    stringBuffer.append(TEXT_62);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(V2CWithDSourceValueName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(V2CWithDTargetConnName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(V2CWithDDynamicName);
    stringBuffer.append(TEXT_66);
    
					}
				}
				if(useV2C || useV2CWithD){
				
    stringBuffer.append(TEXT_67);
    
				}
				if(useC2C){
				
    stringBuffer.append(TEXT_68);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_72);
    
					for(int i=0;i<methodNum;i++){
						if(useC2C){
						
    stringBuffer.append(TEXT_73);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(C2CSourceConnName);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(C2CTargetConnName);
    stringBuffer.append(TEXT_76);
    
						}
					}
					
    stringBuffer.append(TEXT_77);
    
				}
				
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    
		  	}
		}
	}
	
    stringBuffer.append(TEXT_82);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    final String cid = node.getUniqueName();	
	
	String projectName = codeGenArgument.getCurrentProjectName();
	String jobName = codeGenArgument.getJobName();
	String jobVersion = codeGenArgument.getJobVersion();
	
	String tempDir = ElementParameterParser.getValue(node, "__TEMP_DIR__");
	
	String vcid = "";

	String destination = ElementParameterParser.getValue(node, "__DESTINATION__");
	if(destination!=null && !"".equals(destination)){
		vcid = destination;
	}
	int dynamic_index = -1;
	boolean hasDynamic = false;
	List<IMetadataColumn> columnList = null;
	List<IMetadataTable> metadatas = node.getMetadataList();
	IMetadataTable metadata = null;
	int sizeListColumns = 0;
	if ((metadatas!=null)&&(metadatas.size()>0)) {
		metadata = metadatas.get(0);
		if (metadata!=null) {
			columnList = metadata.getListColumns();
			sizeListColumns = columnList.size();
		}
	}
	for(int i=0; columnList!=null && i< columnList.size(); i++) {
        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
            dynamic_index = i+1;
            hasDynamic = true;
            break;
        }
	}
	int schemaOptNum=100;
	String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
	if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
		schemaOptNum  = Integer.parseInt(schemaOptNumStr);
	}
		
		
	class GenerateCode{
		public int dynamic_index = -1;
		public int colLen = 0; // the length of the column in the input schema
		public void generateDynamicSchemaCode(boolean isCsv){
		
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    
				if(isCsv){
				
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    
				}else{
				
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    
				}
				
    stringBuffer.append(TEXT_91);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(colLen-dynamic_index);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    if(isCsv){
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    }else{
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    }
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    
		}
		public void checkFooterAndRandom(String footer,String random){
		
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(random );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    
		}
		
		public void checkFooter(String footer){
		
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    	
		}
	}
	GenerateCode generateCode = new GenerateCode();

	if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		final String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
		class RowUtil extends DefaultRowUtil{
			public void codeForValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int start , int end){
				codeForValueToConnWithD(node, metadata, sourceValueClass, sourceValueName, targetConnName, null, start ,end);
			}
			public boolean codeForValueToConnWithD(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, String dynamicName, int start , int end){
				cid = node.getUniqueName();
				String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
				
				List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
				String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
				boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;
				
				String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
				boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
				
				String checkNumStr = ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__");
				boolean checkNum = (checkNumStr!=null&&!("").equals(checkNumStr))?("true").equals(checkNumStr):false; 
				
				String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
				boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
				String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
				String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
				
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int sizeListColumns = listColumns.size();
				boolean noStringTypeExist = false;
				int dynamic_index = -1;
				if(metadata.isDynamicSchema()){
				
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    if(this.isBehindDynamic){
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_128);
    }else{
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    
				}
				
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    
				for (int valueN=0; valueN<sizeListColumns; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
					}else{
						noStringTypeExist = true;
						break;
					}
				}
				boolean hasStringDefault = false;
				for (int valueM=0; valueM<sizeListColumns; valueM++) {
					IMetadataColumn column = listColumns.get(valueM);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
						if(hasStringDefault==false && column.getDefault()!=null && column.getDefault().length() > 0 ){
							hasStringDefault = true;
							break;
						}
					}
				}
				if(noStringTypeExist || hasStringDefault){
				
    stringBuffer.append(TEXT_133);
    
				}
				for (int valueN=start; valueN<end; valueN++) {
					IMetadataColumn column = listColumns.get(valueN);
					String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
					if(metadata.isDynamicSchema()){
					
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(valueN-1);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    
					}else{
					
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(valueN);
    stringBuffer.append(TEXT_140);
    
					}
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
						String defaultValue = column.getDefault();
						if(defaultValue!=null && defaultValue.length()>0){
						
    stringBuffer.append(TEXT_141);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_149);
    
						}else{
						
    stringBuffer.append(TEXT_150);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_151);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_155);
    
						}
					}else if(column.getTalendType().equals("id_Dynamic")){
						this.isBehindDynamic=true;
						dynamic_index = valueN;
					
    stringBuffer.append(TEXT_156);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_165);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_170);
    
					}else{
					
    stringBuffer.append(TEXT_171);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(valueN).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_174);
    
							if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
							} else if(javaType == JavaTypesManager.BYTE_ARRAY){ 
							
    stringBuffer.append(TEXT_175);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_178);
    
							} else if(javaType == JavaTypesManager.LIST){ 
                            
    stringBuffer.append(TEXT_179);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_181);
    stringBuffer.append( fieldSeparator );
    stringBuffer.append(TEXT_182);
    
							}else if(javaType == JavaTypesManager.DATE) { 
								if(checkNum || checkDate){
								
    stringBuffer.append(TEXT_183);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_185);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_186);
    
								}else{
								
    stringBuffer.append(TEXT_187);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_189);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_190);
    
								}
							}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
							
    stringBuffer.append(TEXT_191);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_193);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_194);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_195);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_196);
    
							} else { 
							
    stringBuffer.append(TEXT_197);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_199);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_200);
    
							}
							
    stringBuffer.append(TEXT_201);
    
							String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
							if(defaultValue == null) {
							
    stringBuffer.append(TEXT_202);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_204);
    
							} else {
							
    stringBuffer.append(TEXT_205);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_208);
    
							}
							
    stringBuffer.append(TEXT_209);
    
					}
				}
				
    stringBuffer.append(TEXT_210);
    if(checkNum) {
    stringBuffer.append(TEXT_211);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_212);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_213);
    if(metadata.isDynamicSchema()){
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    }
    stringBuffer.append(TEXT_216);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_217);
    if(metadata.isDynamicSchema()){
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    }
    stringBuffer.append(TEXT_220);
    
				}
				return this.isBehindDynamic;
			}
			
			public void codeForConnToConn(INode node, IMetadataTable metadata, String sourceConnName, String targetConnName, int start , int end){
    			for(int colNum=start;colNum<end;colNum++) {
    				IMetadataColumn column=metadata.getListColumns().get(colNum);
    			
    stringBuffer.append(TEXT_221);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_223);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_225);
    
				}
				
    stringBuffer.append(TEXT_226);
    
			}
		}//class defined end

		if ((metadatas!=null)&&(metadatas.size()>0)) {
			if (metadata!=null) {
				String filename = ElementParameterParser.getValue(node,"__FILENAME__");
				
				if(!("".equals(vcid))) {
					filename = "\"/"+filename.substring(1, filename.length()-1)+vcid+"_"+projectName+"_"+jobName+"_"+jobVersion+"\"";
					filename = tempDir+"+"+filename;
				}
				
		    	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		    	String header = ElementParameterParser.getValue(node, "__HEADER__");
		    	if(("").equals(header)){
		    		header="0";
		    	}
		    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
				if(("").equals(limit)){
					limit = "-1";
				}
		    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
				boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));
		    	if(("").equals(footer) || uncompress){
		    		footer="0";
		    	}
		    	String random = "-1";
		    	String ran = ElementParameterParser.getValue(node, "__RANDOM__");
		    	if(("true").equals(ran)){
		    		random = ElementParameterParser.getValue(node, "__NB_RANDOM__");
		    		if(("").equals(random)){
		    			random="0";
		    		}
		    	}
		    	if(uncompress){
		    		random="-1";
		    	}
				
		    	String rowSeparator = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
		    	String removeEmptyRowFlag =  ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
		    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
				boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false; 
				
				String splitRecordStr = ElementParameterParser.getValue(node, "__SPLITRECORD__");
				boolean splitRecord = (splitRecordStr!=null&&!("").equals(splitRecordStr))?("true").equals(splitRecordStr):false;
				
				//find main & reject conns;
				List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
			    String rejectConnName = "";
			    List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
			    if(rejectConns != null && rejectConns.size() > 0) {
			        IConnection rejectConn = rejectConns.get(0);
			        rejectConnName = rejectConn.getName();
			    }
			    List<IMetadataColumn> rejectColumnList = null;
			    IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
			    if(metadataTable != null) {
			        rejectColumnList = metadataTable.getListColumns();      
			    }
			    String firstConnName = "";
				if (conns!=null) {
					if (conns.size()>0) {
						IConnection conn = conns.get(0);
						if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
							firstConnName = conn.getName();
						}
					}
				}			    
				
				RowUtil rowUtil = new RowUtil(); 
				if (conns!=null) {
				    if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
						if(hasDynamic){
							rowUtil.prepareValueToConnWithD(node, metadata, "org.talend.fileprocess.FileInputDelimited", "fid_"+cid, firstConnName, "dynamic_"+cid, schemaOptNum);
							
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    
						}else{
							rowUtil.prepareValueToConn(node, metadata, "org.talend.fileprocess.FileInputDelimited", "fid_"+cid, firstConnName, schemaOptNum);
						}
						if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
							rowUtil.prepareConnToConn(metadata, firstConnName, rejectConnName);
						}
						rowUtil.generateClass(null);
					}
				}
				
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    
					if(uncompress){
					
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
     if(dieOnError) {
    stringBuffer.append(TEXT_242);
     } else { 
    stringBuffer.append(TEXT_243);
     } 
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
     if(dieOnError) {
    stringBuffer.append(TEXT_248);
     } else { 
    stringBuffer.append(TEXT_249);
     } 
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(removeEmptyRowFlag );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(header );
    stringBuffer.append(hasDynamic?"-1":"");
    stringBuffer.append(TEXT_259);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(random );
    stringBuffer.append(TEXT_262);
    stringBuffer.append( splitRecord);
    stringBuffer.append(TEXT_263);
     if(dieOnError) {
    stringBuffer.append(TEXT_264);
     } else { 
    stringBuffer.append(TEXT_265);
     } 
    stringBuffer.append(TEXT_266);
    
					}else{
					
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    
									generateCode.checkFooterAndRandom(footer,random);
							
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_274);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(removeEmptyRowFlag );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(header );
    stringBuffer.append(hasDynamic?"-1":"");
    stringBuffer.append(TEXT_278);
    stringBuffer.append(footer );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(limit );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(random );
    stringBuffer.append(TEXT_281);
    stringBuffer.append( splitRecord);
    stringBuffer.append(TEXT_282);
     if(dieOnError) {
    stringBuffer.append(TEXT_283);
     } else { 
    stringBuffer.append(TEXT_284);
     } 
    stringBuffer.append(TEXT_285);
    
					}
					
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    
				    	if (conns!=null) {
				    		if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
				    			for (int i=0;i<conns.size();i++) {
				    				IConnection connTemp = conns.get(i);
				    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
									
    stringBuffer.append(TEXT_289);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_290);
    
				    				}
				    			}
				    	
								IConnection conn = conns.get(0);
								if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
								
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_294);
    
										if(hasDynamic){// generate the dynamic schema code
											generateCode.colLen = sizeListColumns;
											generateCode.dynamic_index = dynamic_index;
											generateCode.generateDynamicSchemaCode(false); //false: delimited mode
											rowUtil.callValueToConnWithD("fid_"+cid, firstConnName, "dynamic_"+cid);
										}else{
											rowUtil.callValueToConn("fid_"+cid, firstConnName);
										}
										
			
										
										if(rejectConnName.equals(firstConnName)) {
										
    stringBuffer.append(TEXT_295);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_296);
    
										}
										
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    
			        					if (dieOnError) {
			            				
    stringBuffer.append(TEXT_299);
    
			        					} else {
			            					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
							                
    stringBuffer.append(TEXT_300);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_302);
    rowUtil.callConnToConn(firstConnName, rejectConnName);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_305);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_306);
    
			            					} else if(("").equals(rejectConnName)){
			                				
    stringBuffer.append(TEXT_307);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_308);
    
			            					} else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_309);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_310);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_311);
    
									}
			        					} 
			        					
    stringBuffer.append(TEXT_312);
    
								}
							}
							if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {//no use code, we can link only one main line now.
								boolean isFirstEnter = true;
								for (int i=0;i<conns.size();i++) {
									IConnection conn = conns.get(i);
									if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
									
										if(isFirstEnter) {
										
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    isFirstEnter = false; 
										}
										
    stringBuffer.append(TEXT_315);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_318);
    
						    	 		rowUtil.callConnToConn(firstConnName, conn.getName());
									}
								}
								 
								if(!isFirstEnter) {
								
    stringBuffer.append(TEXT_319);
    
								}
								
							}
				  		}
			}
		}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}else{//the following is the tFileInputCSV component
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		class RowUtil extends DefaultRowUtil{
			public void codeForValueToConn(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, int start , int end){
				codeForValueToConnWithD(node, metadata, sourceValueClass, sourceValueName, targetConnName, null, start ,end);
			}
			public boolean codeForValueToConnWithD(INode node, IMetadataTable metadata, String sourceValueClass, String sourceValueName, String targetConnName, String dynamicName, int start , int end){
				cid = node.getUniqueName();
				String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
				
				List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
				String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
				boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;
				
				String checkDateStr = ElementParameterParser.getValue(node,"__CHECK_DATE__");
				boolean checkDate = (checkDateStr!=null&&!("").equals(checkDateStr))?("true").equals(checkDateStr):false;
				
				String checkNumStr = ElementParameterParser.getValue(node, "__CHECK_FIELDS_NUM__");
				boolean checkNum = (checkNumStr!=null&&!("").equals(checkNumStr))?("true").equals(checkNumStr):false; 
				
				String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
				boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
				String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
				String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
				
				List<IMetadataColumn> columns=metadata.getListColumns();
				int columnSize = columns.size();
				if(metadata.isDynamicSchema()){
				
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_321);
    if(this.isBehindDynamic){
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_322);
    }else{
    stringBuffer.append(TEXT_323);
    }
    stringBuffer.append(TEXT_324);
    
				}
				
    stringBuffer.append(TEXT_325);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_327);
    
					for(int colNo=start;colNo<end;colNo++) {
						IMetadataColumn column1 =metadata.getListColumns().get(colNo);
					
    stringBuffer.append(TEXT_328);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_329);
    stringBuffer.append(column1.getLabel() );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaIdType(column1.getTalendType(), column1.isNullable()));
    stringBuffer.append(TEXT_331);
    
					}
					
    stringBuffer.append(TEXT_332);
    if(isTrimAll){
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    
					}
					boolean hasStringDefault = false;
					for (int valueM=0; valueM<columnSize; valueM++) {
						IMetadataColumn column = columns.get(valueM);
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT){
							if(hasStringDefault==false && column.getDefault()!=null && column.getDefault().length() > 0 ){
								hasStringDefault = true;
								break;
							}
						}
					}
					
					if(hasStringDefault==true){
					
    stringBuffer.append(TEXT_342);
    
					}
					int dynamic_index = 1;
	                
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    
					for (int i=start;i<end;i++) {
						IMetadataColumn column=columns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
						if(metadata.isDynamicSchema()){
						
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_346);
    stringBuffer.append(i-1 );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_348);
    
						}else{
						
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_351);
    
						}
						
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_354);
    if((!isTrimAll && (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))){
    stringBuffer.append(TEXT_355);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    
							}
							if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
								String defaultValue = column.getDefault();
								if(defaultValue!=null && defaultValue.length()>0){
								
    stringBuffer.append(TEXT_360);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_362);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(defaultValue );
    stringBuffer.append(TEXT_367);
    
								}else{
								
    stringBuffer.append(TEXT_368);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    
								}
							} else {
							
    stringBuffer.append(TEXT_373);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    
									if(javaType == JavaTypesManager.DATE) {
										if(checkNum || checkDate){
										
    stringBuffer.append(TEXT_376);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_381);
    
										}else{
										
    stringBuffer.append(TEXT_382);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_383);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_384);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_387);
    
										}
									} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
									
    stringBuffer.append(TEXT_388);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_389);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_390);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_394);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_395);
    
									}else if(javaType == JavaTypesManager.BYTE_ARRAY){ 
									
    stringBuffer.append(TEXT_396);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_397);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_400);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_401);
    
									}else if(javaType == JavaTypesManager.LIST){ 
                                    
    stringBuffer.append(TEXT_402);
    stringBuffer.append(TEXT_403);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_404);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_405);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_406);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_408);
    
									}else if(column.getTalendType().equals("id_Dynamic")){
										this.isBehindDynamic=true;
										dynamic_index = i;
									
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_414);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_415);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_420);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_421);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(dynamicName);
    stringBuffer.append(TEXT_423);
    
									}else {
									
    stringBuffer.append(TEXT_424);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_425);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_426);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_427);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    
									}
									
    stringBuffer.append(TEXT_430);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_431);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_432);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault()));
    stringBuffer.append(TEXT_433);
    					
							}
							
    stringBuffer.append(TEXT_434);
    stringBuffer.append(targetConnName );
    stringBuffer.append(TEXT_435);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault()) );
    stringBuffer.append(TEXT_437);
    
					}
					
    stringBuffer.append(TEXT_438);
    if(checkNum) {
    stringBuffer.append(TEXT_439);
    stringBuffer.append(sourceValueName);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_441);
    if(metadata.isDynamicSchema()){
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    }
    stringBuffer.append(TEXT_444);
    stringBuffer.append(metadata.getListColumns().size() );
    stringBuffer.append(TEXT_445);
    if(metadata.isDynamicSchema()){
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    }
    stringBuffer.append(TEXT_448);
    
				}
				return this.isBehindDynamic;
			}
			
			public void codeForConnToConn(INode node, IMetadataTable metadata, String sourceConnName, String targetConnName, int start , int end){
    			for(int colNum=start;colNum<end;colNum++) {
    				IMetadataColumn column=metadata.getListColumns().get(colNum);
    			
    stringBuffer.append(TEXT_449);
    stringBuffer.append(targetConnName);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_451);
    stringBuffer.append(sourceConnName);
    stringBuffer.append(TEXT_452);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_453);
    
				}
				
    stringBuffer.append(TEXT_454);
    
			}
		}//class defined end
		
		if ((metadatas!=null)&&(metadatas.size()>0)) {
		    if (metadata!=null) {
		    
		        String filename = ElementParameterParser.getValueWithUIFieldKey(node,"__FILENAME__", "FILENAME");
		    	String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		    	String header = ElementParameterParser.getValue(node, "__HEADER__");
		    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
		    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
		    	if(("").equals(limit)){
		    		limit="-1";
		    	}
		    	String delim1 = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");     	
		    	String rowSeparator1 = ElementParameterParser.getValue(node, "__CSVROWSEPARATOR__");
		    	
		    	
		    	String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
		    	
		    	if(("").equals(escapeChar1)){
		    		escapeChar1 = "\"\"";
		    	}
		    	String escapeChar = escapeChar1.substring(1,escapeChar1.length()-1);
		    	if(("'").equals(escapeChar)){
		    		escapeChar = "\\'";
		    	}
		    	String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
		    	if(("").equals(textEnclosure1)){
		    		textEnclosure1 = "\"\"";
		    	}
		    	String textEnclosure = textEnclosure1.substring(1,textEnclosure1.length()-1);
		    	if ("".equals(textEnclosure)) 
		    		textEnclosure = "\0";
		    	if(("'").equals(textEnclosure)){
		    		textEnclosure = "\\'";
		    	}
		    	
		    	String removeEmptyRow = ElementParameterParser.getValue(node, "__REMOVE_EMPTY_ROW__");
		    	
		    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
				boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
				
				boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));
				if(uncompress){
					footer = "0";
				}
				
				List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
			    String rejectConnName = "";
    			List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
    			if(rejectConns != null && rejectConns.size() > 0) {
        			IConnection rejectConn = rejectConns.get(0);
        			rejectConnName = rejectConn.getName();
   				}
    			List<IMetadataColumn> rejectColumnList = null;
    			IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
    			if(metadataTable != null) {
        			rejectColumnList = metadataTable.getListColumns();      
    			}
    			String firstConnName = "";
				if (conns!=null) {
					if (conns.size()>0) {
						IConnection conn = conns.get(0);
						if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
							firstConnName = conn.getName();		
						}
					}
				}
				
				RowUtil rowUtil = new RowUtil(); 
				if (conns!=null) {
				    if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
						if(hasDynamic){
							rowUtil.prepareValueToConnWithD(node, metadata, "String[]", "row"+cid, firstConnName, "dynamic_"+cid, schemaOptNum);
							
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_457);
    
						}else{
							rowUtil.prepareValueToConn(node, metadata, "String[]", "row"+cid, firstConnName, schemaOptNum);
						}
						if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
							rowUtil.prepareConnToConn(metadata, firstConnName, rejectConnName);
						}
						rowUtil.generateClass(delim1);
					}
				}	
				
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_460);
    stringBuffer.append( footer);
    stringBuffer.append(TEXT_461);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_463);
    stringBuffer.append( limit );
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_465);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_466);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_468);
    stringBuffer.append(delim1);
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_470);
    stringBuffer.append(rowSeparator1);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(rowSeparator1);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_474);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_476);
    
					if(uncompress){
					
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_483);
     if(dieOnError) {
    stringBuffer.append(TEXT_484);
     } else { 
    stringBuffer.append(TEXT_485);
     } 
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_487);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_489);
     if(dieOnError) {
    stringBuffer.append(TEXT_490);
     } else { 
    stringBuffer.append(TEXT_491);
     } 
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_497);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_500);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_501);
    
					}else{
					
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_505);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_506);
    
								generateCode.checkFooter(footer);
							
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_511);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_515);
    
					}
					
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_519);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    
						if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){//normal situation
						
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_524);
    
						}else{ //context and global variables
						
    stringBuffer.append(TEXT_525);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_526);
    stringBuffer.append(textEnclosure1 );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_533);
    
						}
					
						if(("").equals(escapeChar1) || escapeChar1.startsWith("\"")){//normal situation
	        				if(("\\\\").equals(escapeChar)){
	        				
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_535);
    
	        				}else if(escapeChar.equals(textEnclosure)){
	        				
    stringBuffer.append(TEXT_536);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_538);
    
	        				}else{
	        				
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_541);
    
	        				}
	        			}else{//context and global variables
	 					
    stringBuffer.append(TEXT_542);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_543);
    stringBuffer.append(escapeChar1 );
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_551);
    if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){
    stringBuffer.append(TEXT_552);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_553);
    }else{
    stringBuffer.append(TEXT_554);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_555);
    }
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_560);
    
						}
						
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_564);
    stringBuffer.append( header );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_567);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_568);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_570);
    
						   	if(("true").equals(removeEmptyRow)){
						   	
    stringBuffer.append(TEXT_571);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_575);
    
							}
							
    stringBuffer.append(TEXT_576);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_577);
    
							if(("true").equals(removeEmptyRow)){
							
    stringBuffer.append(TEXT_578);
    
							}
							
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_582);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_583);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_585);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_586);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_587);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_588);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_589);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_590);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_591);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_592);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_593);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_595);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_596);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_597);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_598);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_599);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_600);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_601);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_602);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_603);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_604);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_605);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_606);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_607);
    
						if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){//normal situation
						
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_609);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_610);
    
						}else{
						
    stringBuffer.append(TEXT_611);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_612);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_613);
    
						}
						if(("").equals(escapeChar1) || escapeChar1.startsWith("\"")){//normal situation
	        				if(("\\\\").equals(escapeChar)){
	        				
    stringBuffer.append(TEXT_614);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_615);
    
	        				}else if(escapeChar.equals(textEnclosure)){
	        				
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_617);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_618);
    
	        				}else{
	        				
    stringBuffer.append(TEXT_619);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_621);
    
	        				}
	        			}else{//context and global variables
						
    stringBuffer.append(TEXT_622);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_623);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_624);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_625);
    if(("").equals(textEnclosure1) || textEnclosure1.startsWith("\"")){
    stringBuffer.append(TEXT_626);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_627);
    }else{
    stringBuffer.append(TEXT_628);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_629);
    }
    stringBuffer.append(TEXT_630);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_631);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_632);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_633);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_634);
    
	        			}
	        			
    stringBuffer.append(TEXT_635);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_638);
    stringBuffer.append( header );
    stringBuffer.append(hasDynamic?"-1":"");
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_640);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_642);
    stringBuffer.append(removeEmptyRow );
    stringBuffer.append(TEXT_643);
     if(dieOnError) {
    stringBuffer.append(TEXT_644);
     } else { 
    stringBuffer.append(TEXT_645);
     } 
    stringBuffer.append(TEXT_646);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_647);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_648);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_649);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_650);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_651);
    
	   				if(("true").equals(removeEmptyRow)){
	   				
    stringBuffer.append(TEXT_652);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_653);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_654);
    
					}
					
    stringBuffer.append(TEXT_655);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_656);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_657);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_658);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_659);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_660);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_661);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_662);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_663);
    
			    	if (conns!=null) {
	    				if (conns.size()>0 && firstConnName != null && firstConnName.length()>0) {
	    					for (int i=0;i<conns.size();i++) {
	    						IConnection connTemp = conns.get(i);
	    						if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
								
    stringBuffer.append(TEXT_664);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_665);
    
	    						}
	    					}
	    					
							IConnection conn = conns.get(0);
							if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
							
    stringBuffer.append(TEXT_666);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_667);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_668);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_669);
    
									List<IMetadataColumn> columns=metadata.getListColumns();
									int columnSize = columns.size();
									if(hasDynamic){// generate the dynamic schema code
										generateCode.colLen = columnSize;
										generateCode.dynamic_index = dynamic_index;
										generateCode.generateDynamicSchemaCode(true); //true: CSV mode
										rowUtil.callValueToConnWithD("row"+cid, firstConnName, "dynamic_"+cid);
									}else{
										rowUtil.callValueToConn("row"+cid, firstConnName);
									}
										
	
									if(rejectConnName.equals(firstConnName)) {
									
    stringBuffer.append(TEXT_670);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_671);
    
									}
									
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_673);
    
        							if (dieOnError) {
            						
    stringBuffer.append(TEXT_674);
    
        							} else {
            							if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
						                
    stringBuffer.append(TEXT_675);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_676);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_677);
    
                							rowUtil.callConnToConn(firstConnName, rejectConnName);
                							
    stringBuffer.append(TEXT_678);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_679);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_680);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_681);
    
            							} else if(("").equals(rejectConnName)){
                						
    stringBuffer.append(TEXT_682);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_683);
    	
            							} else if(rejectConnName.equals(firstConnName)){
            							
    stringBuffer.append(TEXT_684);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_686);
    
            							}
        							} 
        							
    stringBuffer.append(TEXT_687);
    			
							}
						}
						if (conns.size()>0) {	
							boolean isFirstEnter = true;
							for (int i=0;i<conns.size();i++) {
								IConnection conn = conns.get(i);
								if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
									if(isFirstEnter) {
									
    stringBuffer.append(TEXT_688);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_689);
    isFirstEnter = false; 
									}
									
    stringBuffer.append(TEXT_690);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_691);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_692);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_693);
    
        							rowUtil.callConnToConn(firstConnName, conn.getName());
								}
							}
							if(!isFirstEnter) {
							
    stringBuffer.append(TEXT_694);
    
							}
						}
					}
			}
		}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  	}
	
    stringBuffer.append(TEXT_695);
    return stringBuffer.toString();
  }
}
