package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;

public class TFileOutputDelimitedBeginJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedBeginJava result = new TFileOutputDelimitedBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "String fileName_";
  protected final String TEXT_3 = " = \"\";";
  protected final String TEXT_4 = NL + "        int dynamic_column_count_";
  protected final String TEXT_5 = " = 1;";
  protected final String TEXT_6 = NL + "\tclass FileOutputDelimitedUtil_";
  protected final String TEXT_7 = "{";
  protected final String TEXT_8 = NL + "\t\tpublic void putHeaderValue_";
  protected final String TEXT_9 = "(java.io.Writer out";
  protected final String TEXT_10 = ",final String OUT_DELIM_";
  protected final String TEXT_11 = ",final ";
  protected final String TEXT_12 = "Struct ";
  protected final String TEXT_13 = ")throws java.lang.Exception{";
  protected final String TEXT_14 = NL + "\t\t\t\t\t\t\t\t\tout";
  protected final String TEXT_15 = ".write(\"";
  protected final String TEXT_16 = "\");";
  protected final String TEXT_17 = NL + "\t\t\t\t\t\t\t\t\troutines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ", out";
  protected final String TEXT_20 = ", OUT_DELIM_";
  protected final String TEXT_21 = "); ";
  protected final String TEXT_22 = NL + "\t\t\t\t\t\t\t\t\tout";
  protected final String TEXT_23 = ".write(OUT_DELIM_";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\t}";
  protected final String TEXT_26 = NL + "\t\t}";
  protected final String TEXT_27 = NL + "\t\tpublic void putValue_";
  protected final String TEXT_28 = "(final ";
  protected final String TEXT_29 = "Struct ";
  protected final String TEXT_30 = ",StringBuilder sb_";
  protected final String TEXT_31 = ",final String OUT_DELIM_";
  protected final String TEXT_32 = ")throws java.lang.Exception {";
  protected final String TEXT_33 = NL + "\t\t\t\t\t\t\tif(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " != null) {";
  protected final String TEXT_36 = NL + "    \t\t\t\t    \t\troutines.system.DynamicUtils.writeValuesToStringBuilder(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ", sb_";
  protected final String TEXT_39 = ", OUT_DELIM_";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\t\t\t\t\t\t\t\tsb_";
  protected final String TEXT_42 = ".append(";
  protected final String TEXT_43 = NL + "    \t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = ")";
  protected final String TEXT_47 = NL + "        \t\t\t\t\t\tFormatterUtils.format_Number(";
  protected final String TEXT_48 = ".toPlainString(), ";
  protected final String TEXT_49 = ", ";
  protected final String TEXT_50 = ")\t\t\t\t\t";
  protected final String TEXT_51 = NL + "        \t\t\t\t\t\tFormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = ")).toPlainString(), ";
  protected final String TEXT_54 = ", ";
  protected final String TEXT_55 = ")\t\t\t\t\t\t";
  protected final String TEXT_56 = NL + "    \t\t\t\t\t\t\t";
  protected final String TEXT_57 = ".toPlainString()";
  protected final String TEXT_58 = NL + "    \t\t\t\t\t\t\tjava.nio.charset.Charset.forName(";
  protected final String TEXT_59 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = ")).toString()";
  protected final String TEXT_62 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = NL + "    \t\t\t\t\t\t\t);";
  protected final String TEXT_65 = NL + "    \t\t\t\t\t    } ";
  protected final String TEXT_66 = "\t\t\t\t\t" + NL + "    \t\t\t            sb_";
  protected final String TEXT_67 = ".append(OUT_DELIM_";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "\t\t}";
  protected final String TEXT_70 = NL + "\t\t}";
  protected final String TEXT_71 = NL + "\t\tpublic void putHeaderValue_";
  protected final String TEXT_72 = "(String[] headColu";
  protected final String TEXT_73 = ",final ";
  protected final String TEXT_74 = "Struct ";
  protected final String TEXT_75 = ",int dynamic_column_count_";
  protected final String TEXT_76 = " ";
  protected final String TEXT_77 = ")throws java.lang.Exception{";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\t\t\t\theadColu";
  protected final String TEXT_79 = "[";
  protected final String TEXT_80 = "+dynamic_column_count_";
  protected final String TEXT_81 = "]=\"";
  protected final String TEXT_82 = "\";";
  protected final String TEXT_83 = NL + "\t\t\t\t\t\t\t\t\theadColu";
  protected final String TEXT_84 = "[";
  protected final String TEXT_85 = "]=\"";
  protected final String TEXT_86 = "\";";
  protected final String TEXT_87 = NL + "                                dynamic_column_count_";
  protected final String TEXT_88 = " = ";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = ".getColumnCount();" + NL + "\t\t\t\t\t\t\t\t\tfor(int mi=0;mi<dynamic_column_count_";
  protected final String TEXT_91 = ";mi++){" + NL + "        \t    \t\t     \t\t\theadColu";
  protected final String TEXT_92 = "[";
  protected final String TEXT_93 = "+mi]=";
  protected final String TEXT_94 = ".";
  protected final String TEXT_95 = ".getColumnMetadata(mi).getName();" + NL + "        \t    \t\t     \t\t}";
  protected final String TEXT_96 = NL + "\t\t}";
  protected final String TEXT_97 = NL + "\t\t}";
  protected final String TEXT_98 = NL + "\t\tpublic void putValue_";
  protected final String TEXT_99 = "(final ";
  protected final String TEXT_100 = "Struct ";
  protected final String TEXT_101 = ",String[] row";
  protected final String TEXT_102 = ",int dynamic_column_count_";
  protected final String TEXT_103 = " ";
  protected final String TEXT_104 = "){";
  protected final String TEXT_105 = NL + "\t\t\t\t\t\t\tif (";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = " != null) {" + NL + "\t\t\t\t\t\t\t    dynamic_column_count_";
  protected final String TEXT_108 = " = ";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = ".getColumnCount();" + NL + "                            \troutines.system.DynamicUtils.writeValuesToStringArray(";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = ", row";
  protected final String TEXT_113 = ", ";
  protected final String TEXT_114 = ");" + NL + "                            }";
  protected final String TEXT_115 = " " + NL + "                \t\t    row";
  protected final String TEXT_116 = "[";
  protected final String TEXT_117 = "+dynamic_column_count_";
  protected final String TEXT_118 = "]=";
  protected final String TEXT_119 = NL + "                \t\t\trow";
  protected final String TEXT_120 = "[";
  protected final String TEXT_121 = "]=";
  protected final String TEXT_122 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = ";";
  protected final String TEXT_125 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = ", ";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = "\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_130 = ".";
  protected final String TEXT_131 = ")).toString();";
  protected final String TEXT_132 = NL + "        \t\t\t\t\tFormatterUtils.format_Number(";
  protected final String TEXT_133 = ".toPlainString(), ";
  protected final String TEXT_134 = ", ";
  protected final String TEXT_135 = ");";
  protected final String TEXT_136 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_137 = ".";
  protected final String TEXT_138 = ")).toPlainString(), ";
  protected final String TEXT_139 = ", ";
  protected final String TEXT_140 = ");\t\t\t\t\t\t";
  protected final String TEXT_141 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_142 = ".toPlainString();";
  protected final String TEXT_143 = NL + "\t\t\t\t\t\t\tString.valueOf(";
  protected final String TEXT_144 = ".";
  protected final String TEXT_145 = ");";
  protected final String TEXT_146 = NL + "\t\t}";
  protected final String TEXT_147 = NL + "\t\t}";
  protected final String TEXT_148 = NL + "\t}" + NL + "\tFileOutputDelimitedUtil_";
  protected final String TEXT_149 = " fileOutputDelimitedUtil_";
  protected final String TEXT_150 = "=new FileOutputDelimitedUtil_";
  protected final String TEXT_151 = "();";
  protected final String TEXT_152 = NL + "fileName_";
  protected final String TEXT_153 = " = (new java.io.File(";
  protected final String TEXT_154 = ")).getAbsolutePath().replace(\"\\\\\",\"/\");" + NL + "String fullName_";
  protected final String TEXT_155 = " = null;" + NL + "String extension_";
  protected final String TEXT_156 = " = null;" + NL + "String directory_";
  protected final String TEXT_157 = " = null;" + NL + "if((fileName_";
  protected final String TEXT_158 = ".indexOf(\"/\") != -1)) {" + NL + "    if(fileName_";
  protected final String TEXT_159 = ".lastIndexOf(\".\") < fileName_";
  protected final String TEXT_160 = ".lastIndexOf(\"/\")) {" + NL + "        fullName_";
  protected final String TEXT_161 = " = fileName_";
  protected final String TEXT_162 = ";" + NL + "        extension_";
  protected final String TEXT_163 = " = \"\";" + NL + "    } else {" + NL + "        fullName_";
  protected final String TEXT_164 = " = fileName_";
  protected final String TEXT_165 = ".substring(0, fileName_";
  protected final String TEXT_166 = ".lastIndexOf(\".\"));" + NL + "        extension_";
  protected final String TEXT_167 = " = fileName_";
  protected final String TEXT_168 = ".substring(fileName_";
  protected final String TEXT_169 = ".lastIndexOf(\".\"));" + NL + "    }           " + NL + "    directory_";
  protected final String TEXT_170 = " = fileName_";
  protected final String TEXT_171 = ".substring(0, fileName_";
  protected final String TEXT_172 = ".lastIndexOf(\"/\"));            " + NL + "} else {" + NL + "    if(fileName_";
  protected final String TEXT_173 = ".lastIndexOf(\".\") != -1) {" + NL + "        fullName_";
  protected final String TEXT_174 = " = fileName_";
  protected final String TEXT_175 = ".substring(0, fileName_";
  protected final String TEXT_176 = ".lastIndexOf(\".\"));" + NL + "        extension_";
  protected final String TEXT_177 = " = fileName_";
  protected final String TEXT_178 = ".substring(fileName_";
  protected final String TEXT_179 = ".lastIndexOf(\".\"));" + NL + "    } else {" + NL + "        fullName_";
  protected final String TEXT_180 = " = fileName_";
  protected final String TEXT_181 = ";" + NL + "        extension_";
  protected final String TEXT_182 = " = \"\";" + NL + "    }" + NL + "    directory_";
  protected final String TEXT_183 = " = \"\";" + NL + "}" + NL + "boolean isFileGenerated_";
  protected final String TEXT_184 = " = true;" + NL + "java.io.File file";
  protected final String TEXT_185 = " = new java.io.File(fileName_";
  protected final String TEXT_186 = ");" + NL + "globalMap.put(\"";
  protected final String TEXT_187 = "_FILE_NAME\",fileName_";
  protected final String TEXT_188 = ");";
  protected final String TEXT_189 = NL + "if(file";
  protected final String TEXT_190 = ".exists()){" + NL + "\tisFileGenerated_";
  protected final String TEXT_191 = " = false;" + NL + "}";
  protected final String TEXT_192 = NL;
  protected final String TEXT_193 = NL + "            boolean isFirstCheckDyn_";
  protected final String TEXT_194 = "= true;";
  protected final String TEXT_195 = NL + "    \t\tint nb_line_";
  protected final String TEXT_196 = " = 0;" + NL + "            int splitEvery_";
  protected final String TEXT_197 = " = ";
  protected final String TEXT_198 = ";" + NL + "            int splitedFileNo_";
  protected final String TEXT_199 = " = 0;" + NL + "            int currentRow_";
  protected final String TEXT_200 = " = 0;\t\t" + NL + "    \t\t" + NL + "    \t\tfinal String OUT_DELIM_";
  protected final String TEXT_201 = " = ";
  protected final String TEXT_202 = ";" + NL + "    \t\t" + NL + "    \t\tfinal String OUT_DELIM_ROWSEP_";
  protected final String TEXT_203 = " = ";
  protected final String TEXT_204 = ";" + NL;
  protected final String TEXT_205 = "         " + NL + "                //create directory only if not exists" + NL + "                if(directory_";
  protected final String TEXT_206 = " != null && directory_";
  protected final String TEXT_207 = ".trim().length() != 0) {" + NL + "                    java.io.File dir_";
  protected final String TEXT_208 = " = new java.io.File(directory_";
  protected final String TEXT_209 = ");" + NL + "                    if(!dir_";
  protected final String TEXT_210 = ".exists()) {" + NL + "                        dir_";
  protected final String TEXT_211 = ".mkdirs();" + NL + "                    }" + NL + "                }";
  protected final String TEXT_212 = NL + "    ";
  protected final String TEXT_213 = NL + "\t\t\t\tfile";
  protected final String TEXT_214 = " = new java.io.File(fileName_";
  protected final String TEXT_215 = ");" + NL + "\t\t\t\tString zipName_";
  protected final String TEXT_216 = " = fullName_";
  protected final String TEXT_217 = " + \".zip\";" + NL + "\t\t\t\tjava.io.File file_";
  protected final String TEXT_218 = " = new java.io.File(zipName_";
  protected final String TEXT_219 = ");" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_220 = "= null;    \t\t    " + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_221 = " = null;" + NL + "    \t\t    try {" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_222 = "= new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_223 = ")));" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_224 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_225 = ".getName()));" + NL + "    \t\t    \tout";
  protected final String TEXT_226 = " = new ";
  protected final String TEXT_227 = "(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_228 = ",";
  protected final String TEXT_229 = "));";
  protected final String TEXT_230 = "\t\t" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_231 = " = null;" + NL + "            \ttry {" + NL + "            \t\tout";
  protected final String TEXT_232 = " = new ";
  protected final String TEXT_233 = "(new java.io.OutputStreamWriter(" + NL + "            \t\tnew java.io.FileOutputStream(fileName_";
  protected final String TEXT_234 = ", ";
  protected final String TEXT_235 = "),";
  protected final String TEXT_236 = "));";
  protected final String TEXT_237 = NL + "                java.io.Writer out";
  protected final String TEXT_238 = " = null;" + NL + "                file";
  protected final String TEXT_239 = " = new java.io.File(fullName_";
  protected final String TEXT_240 = " + splitedFileNo_";
  protected final String TEXT_241 = " + extension_";
  protected final String TEXT_242 = ");" + NL + "                try {" + NL + "                \tout";
  protected final String TEXT_243 = " = new ";
  protected final String TEXT_244 = "(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_245 = " + splitedFileNo_";
  protected final String TEXT_246 = " + extension_";
  protected final String TEXT_247 = ", ";
  protected final String TEXT_248 = "),";
  protected final String TEXT_249 = "));";
  protected final String TEXT_250 = NL + "\t\t\t\t";
  protected final String TEXT_251 = NL + "\t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_252 = NL + "\t\t\t\tsynchronized (lockWrite) {" + NL + "\t\t        ";
  protected final String TEXT_253 = NL + "\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_254 = NL + "    \t\t    if(file_";
  protected final String TEXT_255 = ".length()==0)  " + NL + "    \t\t    {" + NL + "    \t\t    ";
  protected final String TEXT_256 = NL + "    \t\t    if(file";
  protected final String TEXT_257 = ".length()==0)  " + NL + "    \t\t    {" + NL + "    \t\t        ";
  protected final String TEXT_258 = NL + "                            \t\tfileOutputDelimitedUtil_";
  protected final String TEXT_259 = ".putHeaderValue_";
  protected final String TEXT_260 = "(out";
  protected final String TEXT_261 = ",OUT_DELIM_";
  protected final String TEXT_262 = ");";
  protected final String TEXT_263 = NL + "\t    \t\t            out";
  protected final String TEXT_264 = ".write(\"";
  protected final String TEXT_265 = "\");" + NL + "\t    \t\t            ";
  protected final String TEXT_266 = NL + "\t    \t\t                out";
  protected final String TEXT_267 = ".write(OUT_DELIM_";
  protected final String TEXT_268 = ");" + NL + "\t    \t\t                ";
  protected final String TEXT_269 = NL + "    \t\t        out";
  protected final String TEXT_270 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_271 = ");" + NL + "    \t\t        out";
  protected final String TEXT_272 = ".flush();" + NL + "    \t\t    }" + NL + "\t\t        ";
  protected final String TEXT_273 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_274 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_275 = NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_276 = NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_277 = "= null;    \t\t    " + NL + "    \t\t    java.io.OutputStreamWriter writer_";
  protected final String TEXT_278 = " = null;" + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_279 = " = null;" + NL + "    \t\t    try {" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_280 = "=new java.util.zip.ZipOutputStream(new java.io.BufferedOutputStream(";
  protected final String TEXT_281 = "));" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_282 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "    \t\t    \twriter_";
  protected final String TEXT_283 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_284 = ",";
  protected final String TEXT_285 = ");" + NL + "    \t\t    \tout";
  protected final String TEXT_286 = " = new ";
  protected final String TEXT_287 = "(writer_";
  protected final String TEXT_288 = ");";
  protected final String TEXT_289 = "\t\t" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.io.OutputStreamWriter writer_";
  protected final String TEXT_290 = " = null;" + NL + "    \t\t    java.io.Writer out";
  protected final String TEXT_291 = " = null;" + NL + "    \t\t    try {" + NL + "    \t\t    \twriter_";
  protected final String TEXT_292 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_293 = ",";
  protected final String TEXT_294 = ");" + NL + "    \t\t    \tout";
  protected final String TEXT_295 = " = new ";
  protected final String TEXT_296 = "(writer_";
  protected final String TEXT_297 = ");";
  protected final String TEXT_298 = NL + "                            \t\tfileOutputDelimitedUtil_";
  protected final String TEXT_299 = ".putHeaderValue_";
  protected final String TEXT_300 = "(out";
  protected final String TEXT_301 = ",OUT_DELIM_";
  protected final String TEXT_302 = ");";
  protected final String TEXT_303 = NL + "    \t\t            out";
  protected final String TEXT_304 = ".write(\"";
  protected final String TEXT_305 = "\");" + NL + "    \t\t            ";
  protected final String TEXT_306 = NL + "    \t\t                out";
  protected final String TEXT_307 = ".write(OUT_DELIM_";
  protected final String TEXT_308 = ");" + NL + "    \t\t                ";
  protected final String TEXT_309 = NL + "    \t\t        out";
  protected final String TEXT_310 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_311 = ");";
  protected final String TEXT_312 = NL;
  protected final String TEXT_313 = NL;
  protected final String TEXT_314 = NL + "            boolean isFirstCheckDyn_";
  protected final String TEXT_315 = "= true;" + NL + "            String[] headColu";
  protected final String TEXT_316 = " = null;";
  protected final String TEXT_317 = NL + "            String[] headColu";
  protected final String TEXT_318 = "=new String[";
  protected final String TEXT_319 = "];";
  protected final String TEXT_320 = "   \t    \t\t" + NL + "            class CSVBasicSet_";
  protected final String TEXT_321 = "{          \t" + NL + "            \tprivate char field_Delim;            \t" + NL + "            \tprivate char row_Delim;            \t" + NL + "            \tprivate char escape;            \t" + NL + "            \tprivate char textEnclosure;" + NL + "            \tprivate boolean useCRLFRecordDelimiter;" + NL + "            \t" + NL + "            \tpublic boolean isUseCRLFRecordDelimiter() {" + NL + "            \t\treturn useCRLFRecordDelimiter;" + NL + "            \t}" + NL + "            \t          \t" + NL + "            \tpublic void setFieldSeparator(String fieldSep) throws IllegalArgumentException{" + NL + "                    char field_Delim_";
  protected final String TEXT_322 = "[] = null;" + NL + "                    " + NL + "            \t\t//support passing value (property: Field Separator) by 'context.fs' or 'globalMap.get(\"fs\")'." + NL + "            \t\tif (fieldSep.length() > 0 ){" + NL + "            \t\t\tfield_Delim_";
  protected final String TEXT_323 = " = fieldSep.toCharArray();" + NL + "            \t\t}else { " + NL + "            \t\t\tthrow new IllegalArgumentException(\"Field Separator must be assigned a char.\");" + NL + "            \t\t}" + NL + "            \t\tthis.field_Delim = field_Delim_";
  protected final String TEXT_324 = "[0];" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getFieldDelim(){" + NL + "            \t\tif(this.field_Delim==0){" + NL + "            \t\t\tsetFieldSeparator(";
  protected final String TEXT_325 = ");" + NL + "            \t\t}" + NL + "            \t\treturn this.field_Delim;" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic void setRowSeparator(String rowSep){" + NL + "            \t\tif(\"\\r\\n\".equals(rowSep)) {" + NL + "            \t\t\tuseCRLFRecordDelimiter = true;" + NL + "            \t\t\treturn;" + NL + "            \t\t}" + NL + "            \t\tchar row_Delim";
  protected final String TEXT_326 = "[] = null;" + NL + "                 " + NL + "            \t\t//support passing value (property: Row Separator) by 'context.rs' or 'globalMap.get(\"rs\")'.  " + NL + "            \t\tif (rowSep.length() > 0 ){ " + NL + "            \t\t\trow_Delim";
  protected final String TEXT_327 = " = rowSep.toCharArray();" + NL + "            \t\t}else {" + NL + "            \t\t\tthrow new IllegalArgumentException(\"Row Separator must be assigned a char.\");" + NL + "            \t\t}" + NL + "            \t\tthis.row_Delim = row_Delim";
  protected final String TEXT_328 = "[0];" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getRowDelim(){" + NL + "            \t\tif(this.row_Delim==0){" + NL + "            \t\t\tsetRowSeparator(";
  protected final String TEXT_329 = ");" + NL + "            \t\t}" + NL + "            \t\treturn this.row_Delim;" + NL + "            \t}" + NL + "            \t       \t        " + NL + "        \t    public void setEscapeAndTextEnclosure(String strEscape, String strTextEnclosure) throws IllegalArgumentException{" + NL + "        \t        if(strEscape.length() <= 0 ){ " + NL + "        \t            throw new IllegalArgumentException(\"Escape Char must be assigned a char.\"); " + NL + "        \t        }" + NL + "        \t        " + NL + "                \tif (\"\".equals(strTextEnclosure)) strTextEnclosure = \"\\0\";" + NL + "        \t\t\tchar textEnclosure_";
  protected final String TEXT_330 = "[] = null;" + NL + "        \t        " + NL + "        \t        if(strTextEnclosure.length() > 0 ){ " + NL + "              \t\t\ttextEnclosure_";
  protected final String TEXT_331 = " = strTextEnclosure.toCharArray(); " + NL + "        \t\t\t}else { " + NL + "        \t            throw new IllegalArgumentException(\"Text Enclosure must be assigned a char.\"); " + NL + "        \t        }" + NL + "" + NL + "\t\t\t\t\tthis.textEnclosure = textEnclosure_";
  protected final String TEXT_332 = "[0];" + NL + "" + NL + "        \t\t\tif((\"\\\\\").equals(strEscape)){" + NL + "        \t\t\t\tthis.escape = '\\\\';" + NL + "        \t\t\t}else if(strEscape.equals(strTextEnclosure)){" + NL + "        \t\t\t\tthis.escape = this.textEnclosure;" + NL + "        \t\t\t} else {" + NL + "        \t\t\t\t//the default escape mode is double escape" + NL + "        \t\t\t\tthis.escape = this.textEnclosure;" + NL + "        \t\t\t}" + NL + "        \t\t\t" + NL + "        \t\t\t" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getEscapeChar(){" + NL + "            \t\treturn (char)this.escape;" + NL + "            \t}" + NL + "            \t" + NL + "            \tpublic char getTextEnclosure(){" + NL + "            \t\treturn this.textEnclosure;" + NL + "            \t}" + NL + "            }" + NL + "" + NL + "            int nb_line_";
  protected final String TEXT_333 = " = 0;" + NL + "            int splitEvery_";
  protected final String TEXT_334 = " = ";
  protected final String TEXT_335 = ";" + NL + "            int splitedFileNo_";
  protected final String TEXT_336 = " =0;" + NL + "            int currentRow_";
  protected final String TEXT_337 = " = 0;" + NL + "            " + NL + "            " + NL + "            CSVBasicSet_";
  protected final String TEXT_338 = " csvSettings_";
  protected final String TEXT_339 = " = new CSVBasicSet_";
  protected final String TEXT_340 = "();" + NL + "            csvSettings_";
  protected final String TEXT_341 = ".setFieldSeparator(";
  protected final String TEXT_342 = ");" + NL + "            csvSettings_";
  protected final String TEXT_343 = ".setRowSeparator(";
  protected final String TEXT_344 = ");" + NL + "\t\t\tcsvSettings_";
  protected final String TEXT_345 = ".setEscapeAndTextEnclosure(";
  protected final String TEXT_346 = ",";
  protected final String TEXT_347 = ");";
  protected final String TEXT_348 = "         " + NL + "                //create directory only if not exists" + NL + "                if(directory_";
  protected final String TEXT_349 = " != null && directory_";
  protected final String TEXT_350 = ".trim().length() != 0) {" + NL + "                    java.io.File dir_";
  protected final String TEXT_351 = " = new java.io.File(directory_";
  protected final String TEXT_352 = ");" + NL + "                    if(!dir_";
  protected final String TEXT_353 = ".exists()) {" + NL + "                        dir_";
  protected final String TEXT_354 = ".mkdirs();" + NL + "                    }" + NL + "                }";
  protected final String TEXT_355 = NL + "\t\t\t\tfile";
  protected final String TEXT_356 = " = new java.io.File(fileName_";
  protected final String TEXT_357 = ");" + NL + "\t\t\t\tString zipName_";
  protected final String TEXT_358 = " = fullName_";
  protected final String TEXT_359 = " + \".zip\";" + NL + "\t\t\t\tjava.io.File file_";
  protected final String TEXT_360 = " = new java.io.File(zipName_";
  protected final String TEXT_361 = ");\t\t\t\t" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_362 = " = null;" + NL + "                java.io.Writer out";
  protected final String TEXT_363 = " = null;" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_364 = " = null; " + NL + "                try {" + NL + "                \tzipOut_";
  protected final String TEXT_365 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_366 = ")));" + NL + "\t    \t\t    zipOut_";
  protected final String TEXT_367 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_368 = ".getName()));" + NL + "\t    \t\t    out";
  protected final String TEXT_369 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_370 = ", ";
  protected final String TEXT_371 = "));" + NL + "\t    \t\t    java.io.StringWriter strWriter";
  protected final String TEXT_372 = " = new java.io.StringWriter();" + NL + "\t    \t\t    CsvWriter";
  protected final String TEXT_373 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_374 = ");" + NL + "\t    \t\t    CsvWriter";
  protected final String TEXT_375 = ".setSeparator(csvSettings_";
  protected final String TEXT_376 = ".getFieldDelim());";
  protected final String TEXT_377 = "\t\t" + NL + "                java.io.Writer out";
  protected final String TEXT_378 = " = null;" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_379 = " = null;" + NL + "                try {" + NL + "                \tout";
  protected final String TEXT_380 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "                    new java.io.FileOutputStream(fileName_";
  protected final String TEXT_381 = ", ";
  protected final String TEXT_382 = "), ";
  protected final String TEXT_383 = "));" + NL + "\t\t\t\t\tjava.io.StringWriter strWriter";
  protected final String TEXT_384 = " = new java.io.StringWriter();" + NL + "\t\t\t\t\tCsvWriter";
  protected final String TEXT_385 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_386 = ");" + NL + "\t\t\t\t\tCsvWriter";
  protected final String TEXT_387 = ".setSeparator(csvSettings_";
  protected final String TEXT_388 = ".getFieldDelim());";
  protected final String TEXT_389 = NL + "\t\t\t\tfile";
  protected final String TEXT_390 = " = new java.io.File(fileName_";
  protected final String TEXT_391 = ");" + NL + "\t\t\t\tString zipName_";
  protected final String TEXT_392 = " = fullName_";
  protected final String TEXT_393 = " + \".zip\";" + NL + "\t\t\t\tjava.io.File file_";
  protected final String TEXT_394 = " = new java.io.File(zipName_";
  protected final String TEXT_395 = ");" + NL + "    \t\t    //routines.system.Row" + NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_396 = " = null;" + NL + "\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_397 = " = null;" + NL + "                try {" + NL + "                \tzipOut_";
  protected final String TEXT_398 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(new java.io.FileOutputStream(zipName_";
  protected final String TEXT_399 = ")));" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_400 = ".putNextEntry(new java.util.zip.ZipEntry(file";
  protected final String TEXT_401 = ".getName()));" + NL + "    \t\t    \tCsvWriter";
  protected final String TEXT_402 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                    zipOut_";
  protected final String TEXT_403 = ", ";
  protected final String TEXT_404 = ")));" + NL + "                    CsvWriter";
  protected final String TEXT_405 = ".setSeparator(csvSettings_";
  protected final String TEXT_406 = ".getFieldDelim());" + NL + "\t\t\t\t";
  protected final String TEXT_407 = NL + "\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_408 = " = null;" + NL + "                try {" + NL + "                \tCsvWriter";
  protected final String TEXT_409 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                    new java.io.FileOutputStream(fileName_";
  protected final String TEXT_410 = ", ";
  protected final String TEXT_411 = "), ";
  protected final String TEXT_412 = ")));" + NL + "                    CsvWriter";
  protected final String TEXT_413 = ".setSeparator(csvSettings_";
  protected final String TEXT_414 = ".getFieldDelim());" + NL + "\t\t\t\t";
  protected final String TEXT_415 = NL + "                file";
  protected final String TEXT_416 = " = new java.io.File(fullName_";
  protected final String TEXT_417 = " + splitedFileNo_";
  protected final String TEXT_418 = " + extension_";
  protected final String TEXT_419 = ");" + NL + "                java.io.Writer out";
  protected final String TEXT_420 = " = null;" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_421 = " = null;" + NL + "                try {" + NL + "                \tout";
  protected final String TEXT_422 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_423 = " + splitedFileNo_";
  protected final String TEXT_424 = " + extension_";
  protected final String TEXT_425 = ", ";
  protected final String TEXT_426 = "),";
  protected final String TEXT_427 = "));" + NL + "                \tjava.io.StringWriter strWriter";
  protected final String TEXT_428 = " = new java.io.StringWriter();" + NL + "                \tCsvWriter";
  protected final String TEXT_429 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_430 = ");" + NL + "                \tCsvWriter";
  protected final String TEXT_431 = ".setSeparator(csvSettings_";
  protected final String TEXT_432 = ".getFieldDelim());";
  protected final String TEXT_433 = NL + "                file";
  protected final String TEXT_434 = " = new java.io.File(fullName_";
  protected final String TEXT_435 = " + splitedFileNo_";
  protected final String TEXT_436 = " + extension_";
  protected final String TEXT_437 = ");" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_438 = " = null; " + NL + "                try {" + NL + "                \tCsvWriter";
  protected final String TEXT_439 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_440 = " + splitedFileNo_";
  protected final String TEXT_441 = " + extension_";
  protected final String TEXT_442 = ", ";
  protected final String TEXT_443 = "),";
  protected final String TEXT_444 = ")));" + NL + "                    CsvWriter";
  protected final String TEXT_445 = ".setSeparator(csvSettings_";
  protected final String TEXT_446 = ".getFieldDelim());";
  protected final String TEXT_447 = NL + "    \t    \tif(csvSettings_";
  protected final String TEXT_448 = ".isUseCRLFRecordDelimiter()) {" + NL + "    \t    \t\tCsvWriter";
  protected final String TEXT_449 = ".setLineEnd(\"\\r\\n\");" + NL + "    \t    \t} else {" + NL + "    \t    \t\tCsvWriter";
  protected final String TEXT_450 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_451 = ".getRowDelim());" + NL + "    \t    \t}" + NL + "\t    \t\t";
  protected final String TEXT_452 = NL + "\t    \t\tif(!csvSettings_";
  protected final String TEXT_453 = ".isUseCRLFRecordDelimiter() && csvSettings_";
  protected final String TEXT_454 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_455 = ".getRowDelim()!='\\n') {" + NL + "\t    \t\t\tCsvWriter";
  protected final String TEXT_456 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_457 = ".getRowDelim());" + NL + "\t    \t\t}" + NL + "\t    \t\t";
  protected final String TEXT_458 = "\t\t   " + NL + "\t\t\t";
  protected final String TEXT_459 = NL + "\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_460 = NL + "\t\t\tsynchronized (lockWrite) {" + NL + "\t        ";
  protected final String TEXT_461 = NL + "\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t";
  protected final String TEXT_462 = NL + "\t        \tif(file_";
  protected final String TEXT_463 = ".length()==0)" + NL + "\t        \t{" + NL + "\t        ";
  protected final String TEXT_464 = NL + "    \t        if(file";
  protected final String TEXT_465 = ".length()==0)  " + NL + "    \t        {" + NL + "    \t            ";
  protected final String TEXT_466 = NL + "                        fileOutputDelimitedUtil_";
  protected final String TEXT_467 = ".putHeaderValue_";
  protected final String TEXT_468 = "(headColu";
  protected final String TEXT_469 = ");";
  protected final String TEXT_470 = "\t      \t" + NL + "        \t\t\t\theadColu";
  protected final String TEXT_471 = "[";
  protected final String TEXT_472 = "]=\"";
  protected final String TEXT_473 = "\";" + NL + "        \t\t\t\t";
  protected final String TEXT_474 = "\t " + NL + "    \t            CsvWriter";
  protected final String TEXT_475 = ".writeNext(headColu";
  protected final String TEXT_476 = ");" + NL + "    \t            CsvWriter";
  protected final String TEXT_477 = ".flush();" + NL + "    \t            \t";
  protected final String TEXT_478 = NL + "    \t            out";
  protected final String TEXT_479 = ".write(strWriter";
  protected final String TEXT_480 = ".getBuffer().toString());" + NL + "    \t            out";
  protected final String TEXT_481 = ".flush();" + NL + "                \tstrWriter";
  protected final String TEXT_482 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_483 = ".getBuffer().length()); \t" + NL + "                \t\t";
  protected final String TEXT_484 = NL + "                }" + NL + "\t        ";
  protected final String TEXT_485 = NL + "\t\t\t} " + NL + "\t        ";
  protected final String TEXT_486 = NL + "\t\t\t} " + NL + "\t        ";
  protected final String TEXT_487 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_488 = NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_489 = " = null;" + NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_490 = " = null;" + NL + "                java.io.Writer out";
  protected final String TEXT_491 = " = null;\t\t\t\t" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_492 = " = null;" + NL + "                try {" + NL + "                \tzipOut_";
  protected final String TEXT_493 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_494 = "));" + NL + "    \t\t    \tzipOut_";
  protected final String TEXT_495 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "    \t\t    \toutWriter_";
  protected final String TEXT_496 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_497 = ", ";
  protected final String TEXT_498 = ");" + NL + "    \t\t    \tout";
  protected final String TEXT_499 = " = new routines.system.BufferedOutput(outWriter_";
  protected final String TEXT_500 = ");" + NL + "    \t\t    \tjava.io.StringWriter strWriter";
  protected final String TEXT_501 = " = new java.io.StringWriter();" + NL + "    \t\t    \tCsvWriter";
  protected final String TEXT_502 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_503 = ");" + NL + "    \t\t    \tCsvWriter";
  protected final String TEXT_504 = ".setSeparator(csvSettings_";
  protected final String TEXT_505 = ".getFieldDelim());";
  protected final String TEXT_506 = NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_507 = " = null;" + NL + "                java.io.Writer out";
  protected final String TEXT_508 = " = null;\t\t\t\t" + NL + "                com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_509 = " = null;  " + NL + "                try {" + NL + "                \toutWriter_";
  protected final String TEXT_510 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_511 = ", ";
  protected final String TEXT_512 = ");" + NL + "                \tout";
  protected final String TEXT_513 = " = new routines.system.BufferedOutput(outWriter_";
  protected final String TEXT_514 = ");" + NL + "                \tjava.io.StringWriter strWriter";
  protected final String TEXT_515 = " = new java.io.StringWriter();" + NL + "                \tCsvWriter";
  protected final String TEXT_516 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_517 = ");" + NL + "                \tCsvWriter";
  protected final String TEXT_518 = ".setSeparator(csvSettings_";
  protected final String TEXT_519 = ".getFieldDelim());";
  protected final String TEXT_520 = NL + "    \t\t    java.util.zip.ZipOutputStream zipOut_";
  protected final String TEXT_521 = " = null;" + NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_522 = " = null;" + NL + "\t\t\t\tjava.io.BufferedWriter bufferWriter_";
  protected final String TEXT_523 = " = null;" + NL + "\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_524 = " = null;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tzipOut_";
  protected final String TEXT_525 = "=new java.util.zip.ZipOutputStream(" + NL + "    \t\t    \t\t\tnew java.io.BufferedOutputStream(";
  protected final String TEXT_526 = "));" + NL + "    \t\t   \t\tzipOut_";
  protected final String TEXT_527 = ".putNextEntry(new java.util.zip.ZipEntry(\"TalendOutputDelimited\"));" + NL + "    \t\t   \t\toutWriter_";
  protected final String TEXT_528 = " = new java.io.OutputStreamWriter(zipOut_";
  protected final String TEXT_529 = ", ";
  protected final String TEXT_530 = ");" + NL + "    \t\t   \t\tbufferWriter_";
  protected final String TEXT_531 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_532 = ");" + NL + "    \t\t   \t\tCsvWriter";
  protected final String TEXT_533 = " = new com.talend.csv.CSVWriter(bufferWriter_";
  protected final String TEXT_534 = ");" + NL + "    \t\t   \t\tCsvWriter";
  protected final String TEXT_535 = ".setSeparator(csvSettings_";
  protected final String TEXT_536 = ".getFieldDelim());";
  protected final String TEXT_537 = NL + "\t\t\t\tjava.io.OutputStreamWriter outWriter_";
  protected final String TEXT_538 = " = null;" + NL + "\t\t\t\tjava.io.BufferedWriter bufferWriter_";
  protected final String TEXT_539 = " = null;" + NL + "\t\t\t\tcom.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_540 = " = null;" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\toutWriter_";
  protected final String TEXT_541 = " = new java.io.OutputStreamWriter(";
  protected final String TEXT_542 = ", ";
  protected final String TEXT_543 = ");" + NL + "\t\t\t\t\tbufferWriter_";
  protected final String TEXT_544 = " = new java.io.BufferedWriter(outWriter_";
  protected final String TEXT_545 = ");" + NL + "\t\t\t\t\tCsvWriter";
  protected final String TEXT_546 = " = new com.talend.csv.CSVWriter(bufferWriter_";
  protected final String TEXT_547 = ");" + NL + "\t\t\t\t\tCsvWriter";
  protected final String TEXT_548 = ".setSeparator(csvSettings_";
  protected final String TEXT_549 = ".getFieldDelim());";
  protected final String TEXT_550 = NL + "       \t    \tif(csvSettings_";
  protected final String TEXT_551 = ".isUseCRLFRecordDelimiter()) {" + NL + "    \t    \t\tCsvWriter";
  protected final String TEXT_552 = ".setLineEnd(\"\\r\\n\");" + NL + "    \t    \t} else {" + NL + "    \t    \t\tCsvWriter";
  protected final String TEXT_553 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_554 = ".getRowDelim());   \t    \t" + NL + "    \t    \t}" + NL + "    \t    \t";
  protected final String TEXT_555 = NL + "    \t    \tif(!csvSettings_";
  protected final String TEXT_556 = ".isUseCRLFRecordDelimiter() && csvSettings_";
  protected final String TEXT_557 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_558 = ".getRowDelim()!='\\n') {" + NL + "\t    \t\t\tCsvWriter";
  protected final String TEXT_559 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_560 = ".getRowDelim());" + NL + "\t    \t\t}" + NL + "    \t    \t";
  protected final String TEXT_561 = NL + "                     fileOutputDelimitedUtil_";
  protected final String TEXT_562 = ".putHeaderValue_";
  protected final String TEXT_563 = "(headColu";
  protected final String TEXT_564 = ");";
  protected final String TEXT_565 = NL + "       \t\t\t\theadColu";
  protected final String TEXT_566 = "[";
  protected final String TEXT_567 = "]=\"";
  protected final String TEXT_568 = "\";" + NL + "       \t\t\t\t";
  protected final String TEXT_569 = NL + "        \t\tCsvWriter";
  protected final String TEXT_570 = ".writeNext(headColu";
  protected final String TEXT_571 = ");\t" + NL + "        \t\t\t";
  protected final String TEXT_572 = NL + "        \t\tout";
  protected final String TEXT_573 = ".write(strWriter";
  protected final String TEXT_574 = ".getBuffer().toString());" + NL + "                strWriter";
  protected final String TEXT_575 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_576 = ".getBuffer().length());" + NL + "        \t\t\t";
  protected final String TEXT_577 = NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_578 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_579 = ".getEscapeChar());" + NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_580 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_581 = ".getTextEnclosure());" + NL + "\t\t\t\tCsvWriter";
  protected final String TEXT_582 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);";
  protected final String TEXT_583 = NL + NL;
  protected final String TEXT_584 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
String outStream = ElementParameterParser.getValue(node,"__STREAMNAME__");
String fileName = ElementParameterParser.getValue(node,"__FILENAME__");

boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}
boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));

String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
	

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
List<IMetadataTable> metadatas = node.getMetadataList();
List< ? extends IConnection> conns = node.getIncomingConnections();
if ((metadatas!=null)&&(metadatas.size()>0)) {//A1
	IMetadataTable metadata = metadatas.get(0);
	boolean hasDynamic = metadata.isDynamicSchema();
	if(hasDynamic && ("true").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
	}
	IMetadataColumn dynamicCol = metadata.getDynamicColumn();
	for (IConnection conn : conns) {//B1
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//C1
	    	List<IMetadataColumn> columns = metadata.getListColumns();
	       	int sizeColumns = columns.size();
			if(sizeColumns> schemaOptNum){//D1

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
				if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {//E1 not use CSV Option
					if(isIncludeHeader){//F1
						for (int i = 0; i < sizeColumns; i++) {//H1
	                        IMetadataColumn column = columns.get(i);
	                       	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_8);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    if(hasDynamic){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(conn.getName() );
    }
    stringBuffer.append(TEXT_13);
    
							}
							if(!("id_Dynamic".equals(column.getTalendType()))) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_16);
    
							}else{

    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
							}
							if(i != sizeColumns - 1) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
							}
							if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_25);
    
							}
						}//H1
						if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_26);
    
						}
					}//F1
        			for (int i = 0; i < sizeColumns; i++) {//F2
        				IMetadataColumn column = columns.get(i);
    					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
	                    if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_27);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    
						}
    					if(!isPrimitive) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_35);
    
    				    } 
    				    if(column.getTalendType().equals("id_Dynamic")){

    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
    				    }else{

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    
    			        	String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			        	if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_43);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_46);
    	
    						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
								if(javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_48);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_50);
     
        						} else { 

    stringBuffer.append(TEXT_51);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_54);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_55);
     
        						}
							} else if(javaType == JavaTypesManager.BIGDECIMAL){

    stringBuffer.append(TEXT_56);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_57);
    
							} else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_58);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_61);
    
    			        	} else {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(column.getLabel() );
    				
    			        	}

    stringBuffer.append(TEXT_64);
    
    					}
    					if(!isPrimitive) {

    stringBuffer.append(TEXT_65);
    
    			        } 
    			        if(i != sizeColumns - 1) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
    			        }
    			        if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_69);
    
						}
    		        }//F2
					if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_70);
    
					}
				}else{
					//E2 use CSV Option
					if(isIncludeHeader){//F3
						for (int i = 0; i < sizeColumns; i++) {//H3
	                        IMetadataColumn column = columns.get(i);
	                       	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_71);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_73);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    
							}
							if(!("id_Dynamic".equals(column.getTalendType()))) {
							    if(hasDynamic){

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_82);
    
							    }else{

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_86);
    
							    }
							}else{

    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_95);
    
							}
							if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_96);
    
							}
						}//H3
						if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_97);
    
						}
					}//F3
        			for (int i = 0; i < sizeColumns; i++) {//F4
        				IMetadataColumn column = columns.get(i);
    					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    					String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
	                    if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_98);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    
						}
    					if(("id_Dynamic").equals(column.getTalendType())) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_114);
    
                		}else{
                		    if(hasDynamic){

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ "==null?\"\":");
    
                		    }else{

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ "==null?\"\":");
    					
                		    }
                			if(javaType == JavaTypesManager.STRING ){

    stringBuffer.append(TEXT_122);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_124);
    
                			}else if(javaType == JavaTypesManager.DATE && pattern != null){

    stringBuffer.append(TEXT_125);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_128);
    
                			}else if(javaType == JavaTypesManager.BYTE_ARRAY){

    stringBuffer.append(TEXT_129);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_131);
    
                			} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        						if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_132);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_133);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_134);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_135);
      	
								} else { 
    stringBuffer.append(TEXT_136);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_139);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_140);
    		
								}
        					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_142);
    
                			} else{

    stringBuffer.append(TEXT_143);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_145);
    
                			}
                		}
    			        if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_146);
    
						}
    		        }//F4
					if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_147);
    
					}
				}

    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    
			}//D1
		}//C1
	}//B1
}//A1

if(!useStream){

    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    
	if(isAppend){

    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    
	}
}
if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_192);
    
    
    
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
           
            String fieldSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__FIELDSEPARATOR__",
                "FIELDSEPARATOR"
            );
            
            String rowSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__ROWSEPARATOR__",
                "ROWSEPARATOR"
            );
            
    		
    		boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
    		
            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
            
            boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
            
            boolean hasDynamic = metadata.isDynamicSchema();
				if(hasDynamic){
            
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    	}
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(fieldSeparator );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(rowSeparator );
    stringBuffer.append(TEXT_204);
    
			if(!useStream){
			//**************************** the following is the part of file Path***************************************
			
    			if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){

    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    
    			}

    stringBuffer.append(TEXT_212);
     	
    			String writerClass = null;
    			if(isInRowMode){
    				writerClass = "routines.system.BufferedOutput";
    			}else{
    				writerClass = "java.io.BufferedWriter";
    			}
    			if(!split){
    				if(compress && !isAppend){// compress the dest file

    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_229);
    
    				}else{

    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_236);
     
					}
    			} else {

    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_249);
    
    			}
    			
    			if(isIncludeHeader && !hasDynamic){
    		    
    stringBuffer.append(TEXT_250);
    
					if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_251);
    
					}
					if (codeGenArgument.subTreeContainsParallelIterate()) {
				
    stringBuffer.append(TEXT_252);
     
		        	}
		        	if (isParallelize) {
				
    stringBuffer.append(TEXT_253);
     
					}
					if(!split && compress && !isAppend){
		        
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    
    		    	}else{
    		    	
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    
    		        }		
	    		        List<IMetadataColumn> columns = metadata.getListColumns();
	    		        int sizeColumns = columns.size();
	    		        for (int i = 0; i < sizeColumns; i++) {
	    		            IMetadataColumn column = columns.get(i);
                            if(sizeColumns > schemaOptNum){
                            	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    
                            	}
                            }else{//AA
	    		            
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_265);
    
	    		            if(i != sizeColumns - 1) {
	    		                
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    
	    		            }
	    		            }//AA
	    		        }
    		        
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
     
		        	if (isParallelize) {
				
    stringBuffer.append(TEXT_273);
    
		        	}
					if (codeGenArgument.subTreeContainsParallelIterate()) {
				
    stringBuffer.append(TEXT_274);
    
		        	}
		        	if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_275);
    
					}
		        
    
    			}

    		}else{
    		//***********************the following is the part of output Stream**************************************
    		
    			String writerClass = null;
    			if(isInRowMode){
    				writerClass = "routines.system.BufferedOutput";
    			}else{
    				writerClass = "java.io.BufferedWriter";
    			}
    			if(compress){// compress the dest output stream
 
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    
    			}else{

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(writerClass);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    
				}
    			if(isIncludeHeader && !hasDynamic){
    		        List<IMetadataColumn> columns = metadata.getListColumns();
    		        int sizeColumns = columns.size();
    		        for (int i = 0; i < sizeColumns; i++) {
    		            IMetadataColumn column = columns.get(i);
  						if(sizeColumns > schemaOptNum){
                            if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    
                            }
                        }else{//BB
    		            
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_305);
    
    		            if(i != sizeColumns - 1) {
    		                
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    
    		            }
    		            }//BB
    		        }
    		        
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_311);
    
    		    }
    		}// ****************************output Stream end*************************************
        }
    }
    
    stringBuffer.append(TEXT_312);
    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{// the following is the tFileOutputCSV component
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_313);
    
    
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {                       
        	List<IMetadataColumn> columns = metadata.getListColumns();
	    	int sizeColumns = columns.size(); 
    		String delim = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
    		String rowSeparator = ElementParameterParser.getValue(node, "__CSVROWSEPARATOR__");
    		boolean useOSLineSeparator = ("true").equals(ElementParameterParser.getValue(node,"__OS_LINE_SEPARATOR_AS_ROW_SEPARATOR__"));
    		
        	String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
        	
 			if(escapeChar1.equals("\"\"\"")){
 				escapeChar1 = "\"\\\"\"";
 			}
        	
        	String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
 			if(textEnclosure1.equals("\"\"\"")){
 				textEnclosure1 = "\"\\\"\"";
 			}
 			
        	boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
            
            boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
            
            boolean hasDynamic = metadata.isDynamicSchema();
				if(hasDynamic){
            
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_316);
    
            	}else{
            
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_319);
    
            	}
    	    
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(delim );
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(splitEvery );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(delim);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(escapeChar1 );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(textEnclosure1 );
    stringBuffer.append(TEXT_347);
    
			if(!useStream){
			//**************************** the following is the part of file Path***************************************
            	if(("true").equals(ElementParameterParser.getValue(node,"__CREATE__"))){
                
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    
            	}
    	
	            if(!split){
	            	if(isInRowMode){
    					if(compress && !isAppend){// compress the dest file

    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    
    					}else{

    stringBuffer.append(TEXT_377);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_381);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_382);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_383);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    
                		}
                	}else{
                		if(compress && !isAppend){// compress the dest file
				
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_401);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_402);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_404);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_405);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_406);
    
						}else{
				
    stringBuffer.append(TEXT_407);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_408);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_409);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_410);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_411);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_412);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_413);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_414);
    
						}
                	}
	            }else{
	            	if(isInRowMode){
                
    stringBuffer.append(TEXT_415);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_416);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_417);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_418);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_419);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_422);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_425);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_427);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_432);
    
                	}else{
                
    stringBuffer.append(TEXT_433);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_438);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_442);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_444);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_445);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_446);
    
                	}
	            }
	            
	            if(!useOSLineSeparator) {
	    		
    stringBuffer.append(TEXT_447);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_448);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_451);
    
	    		} else {
	    		
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_454);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_457);
    
	    		}
	    		
	    	    if(isIncludeHeader && !hasDynamic)
	    	    {
    	        
    stringBuffer.append(TEXT_458);
    
				if(codeGenArgument.getIsRunInMultiThread()){
			
    stringBuffer.append(TEXT_459);
    
				}
				if (codeGenArgument.subTreeContainsParallelIterate()) {
			
    stringBuffer.append(TEXT_460);
     
	        	}
	        	if (isParallelize) {
			
    stringBuffer.append(TEXT_461);
     
				}
				if(!split && compress && !isAppend){
	        
    stringBuffer.append(TEXT_462);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_463);
    
	        	}else{
	        
    stringBuffer.append(TEXT_464);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_465);
    
    	        }			
	         			for(int i = 0 ; i < sizeColumns ; i++)
	        			{
	        				IMetadataColumn column = columns.get(i);
							if(sizeColumns> schemaOptNum){
                            	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_467);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_468);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_469);
    
                            	}
                           	}else{//CC
        				
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_472);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_473);
    
        					}//CC
         				}
    	            
    stringBuffer.append(TEXT_474);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_477);
    if(isInRowMode){
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_482);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_483);
    }
    stringBuffer.append(TEXT_484);
     
	        	if (isParallelize) {
			
    stringBuffer.append(TEXT_485);
    
	        	}
				if (codeGenArgument.subTreeContainsParallelIterate()) {
			
    stringBuffer.append(TEXT_486);
    
	        	}
	        	if(codeGenArgument.getIsRunInMultiThread()){
			
    stringBuffer.append(TEXT_487);
    
				}
	        
    		  
	    	    }
	    	}else{
    		//***********************the following is the part of output Stream**************************************
	            if(isInRowMode){
	            	if(compress){// compress the dest output stream

    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_489);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_491);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_492);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_494);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_497);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_500);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_502);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_503);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_505);
    
	            	}else{

    stringBuffer.append(TEXT_506);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_509);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_510);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_511);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_514);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_515);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_516);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_517);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_518);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_519);
    
					}
                }else{
                	if(compress){// compress the dest output stream

    stringBuffer.append(TEXT_520);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_522);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_523);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_524);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_526);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_528);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_529);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_531);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_532);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_533);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_536);
    
                	}else{

    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_539);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_540);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(outStream );
    stringBuffer.append(TEXT_542);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_543);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_545);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_546);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_547);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_548);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_549);
    
					}
                }
                
                if(!useOSLineSeparator) {

    stringBuffer.append(TEXT_550);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_551);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_552);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_553);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_554);
    
    	    	} else {
    	    	
    stringBuffer.append(TEXT_555);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_556);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_557);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_559);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_560);
    
    	    	}
    	    	
	    	    if(isIncludeHeader && !hasDynamic)
	    	    {
	    	        for(int i = 0; i < sizeColumns; i++)
	        		{
	        			IMetadataColumn column = columns.get(i);
						if(sizeColumns> schemaOptNum){
                            if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_562);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_563);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_564);
    
                            }
                       	}else{//DD
        			
    stringBuffer.append(TEXT_565);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_566);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_567);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_568);
    
       					}//DD
	        		}
    	        
    stringBuffer.append(TEXT_569);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_570);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_571);
    if(isInRowMode){
    stringBuffer.append(TEXT_572);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_573);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_575);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_576);
    }
	    	    }
	    	}//*****************************csv mode under output stream end********************************************************
	    	
	    	if(!(isIncludeHeader && hasDynamic)){//when there is dynamic schema, it won't be enclosed with "\""

    stringBuffer.append(TEXT_577);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_578);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_579);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_580);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_581);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_582);
    
			}
	    }
    }
    
    stringBuffer.append(TEXT_583);
    
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

    stringBuffer.append(TEXT_584);
    return stringBuffer.toString();
  }
}
