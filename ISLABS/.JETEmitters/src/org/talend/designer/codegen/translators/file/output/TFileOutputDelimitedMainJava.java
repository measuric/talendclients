package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileOutputDelimitedMainJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedMainJava result = new TFileOutputDelimitedMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "    \t\t\t\tStringBuilder sb_";
  protected final String TEXT_4 = " = new StringBuilder();" + NL + "    \t\t        ";
  protected final String TEXT_5 = NL + "\t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tsynchronized (lockWrite) {" + NL + "\t\t        ";
  protected final String TEXT_7 = NL + "\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_8 = NL + "\t        \t\tif(isFirstCheckDyn_";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = "&& (file_";
  protected final String TEXT_11 = ".length()==0)";
  protected final String TEXT_12 = "){" + NL + "\t                \t";
  protected final String TEXT_13 = NL + "    \t\t        if(isFirstCheckDyn_";
  protected final String TEXT_14 = " ";
  protected final String TEXT_15 = "&& file";
  protected final String TEXT_16 = ".length()==0";
  protected final String TEXT_17 = "){" + NL + "        \t\t        ";
  protected final String TEXT_18 = NL + "                            \t\tfileOutputDelimitedUtil_";
  protected final String TEXT_19 = ".putHeaderValue_";
  protected final String TEXT_20 = "(out";
  protected final String TEXT_21 = ",OUT_DELIM_";
  protected final String TEXT_22 = ", ";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "    \t\t        \tout";
  protected final String TEXT_25 = ".write(\"";
  protected final String TEXT_26 = "\");" + NL + "        \t\t         ";
  protected final String TEXT_27 = NL + "\t    \t\t        routines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_28 = ".";
  protected final String TEXT_29 = ", out";
  protected final String TEXT_30 = ", OUT_DELIM_";
  protected final String TEXT_31 = "); " + NL + "    \t    \t\t     ";
  protected final String TEXT_32 = NL + "                        out";
  protected final String TEXT_33 = ".write(OUT_DELIM_";
  protected final String TEXT_34 = ");" + NL + "        \t\t         ";
  protected final String TEXT_35 = NL + "                        out";
  protected final String TEXT_36 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_37 = ");" + NL + "                        isFirstCheckDyn_";
  protected final String TEXT_38 = " = false;" + NL + "    \t\t        }" + NL + "\t\t        ";
  protected final String TEXT_39 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_40 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_41 = NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_42 = NL + "    \t\t                    ";
  protected final String TEXT_43 = NL + "                            fileOutputDelimitedUtil_";
  protected final String TEXT_44 = ".putValue_";
  protected final String TEXT_45 = "(";
  protected final String TEXT_46 = ",sb_";
  protected final String TEXT_47 = ",OUT_DELIM_";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = "   \t\t\t\t" + NL + "    \t    \t\t\t\tif(";
  protected final String TEXT_50 = ".";
  protected final String TEXT_51 = " != null) {" + NL + "        \t\t\t\t    ";
  protected final String TEXT_52 = NL + "    \t\t\t\t    routines.system.DynamicUtils.writeValuesToStringBuilder(";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = ", sb_";
  protected final String TEXT_55 = ", OUT_DELIM_";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "    \t\t\t\t\tsb_";
  protected final String TEXT_58 = ".append(" + NL + "    \t\t\t        ";
  protected final String TEXT_59 = NL + "    \t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = ", ";
  protected final String TEXT_62 = ")" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_63 = NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_64 = NL + "        \t\t\t\t\t\t\tFormatterUtils.format_Number(";
  protected final String TEXT_65 = ".toPlainString(), ";
  protected final String TEXT_66 = ", ";
  protected final String TEXT_67 = ")\t\t\t\t\t" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_68 = NL + "        \t\t\t\t\t\t\tFormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = ")).toPlainString(), ";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ")\t\t\t\t\t\t" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_74 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_75 = ".toPlainString()" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_76 = NL + "    \t\t\t\t\t\tjava.nio.charset.Charset.forName(";
  protected final String TEXT_77 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = ")).toString()" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_80 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_83 = NL + "    \t\t\t\t\t);" + NL + "    \t\t\t\t\t";
  protected final String TEXT_84 = NL + "    \t\t\t\t\t    } " + NL + "    \t\t\t\t\t";
  protected final String TEXT_85 = "\t\t\t\t\t" + NL + "    \t\t\t            sb_";
  protected final String TEXT_86 = ".append(OUT_DELIM_";
  protected final String TEXT_87 = ");" + NL + "    \t\t\t            ";
  protected final String TEXT_88 = NL + "    \t\t        sb_";
  protected final String TEXT_89 = ".append(OUT_DELIM_ROWSEP_";
  protected final String TEXT_90 = ");" + NL + "    \t\t" + NL + "    \t\t\t\t" + NL + "    \t\t\t\t";
  protected final String TEXT_91 = NL + "    \t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "    \t\t\t\t";
  protected final String TEXT_92 = NL + "    \t\t\t\tsynchronized (lockWrite) {" + NL + "    \t\t        ";
  protected final String TEXT_93 = NL + "\t\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_94 = NL + "    \t\t        nb_line_";
  protected final String TEXT_95 = "++;" + NL + "    \t\t        ";
  protected final String TEXT_96 = NL + "    \t\t            if(currentRow_";
  protected final String TEXT_97 = " % splitEvery_";
  protected final String TEXT_98 = "==0 && currentRow_";
  protected final String TEXT_99 = "!=0){" + NL + "    \t\t                splitedFileNo_";
  protected final String TEXT_100 = "++;" + NL + "    \t\t                out";
  protected final String TEXT_101 = ".close(); " + NL + "    \t\t                //close original outputStream" + NL + "    \t\t                out";
  protected final String TEXT_102 = " = new ";
  protected final String TEXT_103 = "(new java.io.OutputStreamWriter(" + NL + "    \t\t                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_104 = " + splitedFileNo_";
  protected final String TEXT_105 = " + extension_";
  protected final String TEXT_106 = ", ";
  protected final String TEXT_107 = "),";
  protected final String TEXT_108 = "));" + NL + "    \t\t                file";
  protected final String TEXT_109 = " = new java.io.File(fullName_";
  protected final String TEXT_110 = " + splitedFileNo_";
  protected final String TEXT_111 = " + extension_";
  protected final String TEXT_112 = ");  \t\t\t\t\t" + NL + "    " + NL + "    \t\t                ";
  protected final String TEXT_113 = NL + "    \t\t                    if(file";
  protected final String TEXT_114 = ".length()==0){  " + NL + "    \t\t                        ";
  protected final String TEXT_115 = NL + "                            \t\t\tfileOutputDelimitedUtil_";
  protected final String TEXT_116 = ".putHeaderValue_";
  protected final String TEXT_117 = "(out";
  protected final String TEXT_118 = ",OUT_DELIM_";
  protected final String TEXT_119 = ", ";
  protected final String TEXT_120 = ");";
  protected final String TEXT_121 = NL + "    \t\t                            out";
  protected final String TEXT_122 = ".write(\"";
  protected final String TEXT_123 = "\");" + NL + "    \t\t                            ";
  protected final String TEXT_124 = NL + "\t    \t\t            \t\t\troutines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_125 = ".";
  protected final String TEXT_126 = ", out";
  protected final String TEXT_127 = ", OUT_DELIM_";
  protected final String TEXT_128 = "); " + NL + "\t    \t\t            \t\t\t";
  protected final String TEXT_129 = NL + "    \t\t                                out";
  protected final String TEXT_130 = ".write(OUT_DELIM_";
  protected final String TEXT_131 = ");" + NL + "    \t\t                                ";
  protected final String TEXT_132 = NL + "    \t\t                        out";
  protected final String TEXT_133 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_134 = ");" + NL + "    \t\t                    }\t" + NL + "    \t\t                    ";
  protected final String TEXT_135 = NL + "    \t\t                out";
  protected final String TEXT_136 = ".write(sb_";
  protected final String TEXT_137 = ".toString());" + NL + "    \t\t                ";
  protected final String TEXT_138 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_139 = "%";
  protected final String TEXT_140 = " == 0) {" + NL + "        \t\t                out";
  protected final String TEXT_141 = ".flush();" + NL + "        \t\t                }" + NL + "    \t\t                    ";
  protected final String TEXT_142 = " \t\t\t" + NL + "    \t\t            }else{" + NL + "    \t\t                out";
  protected final String TEXT_143 = ".write(sb_";
  protected final String TEXT_144 = ".toString());" + NL + "    \t\t                ";
  protected final String TEXT_145 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_146 = "%";
  protected final String TEXT_147 = " == 0) {" + NL + "        \t\t                out";
  protected final String TEXT_148 = ".flush();" + NL + "        \t\t                }" + NL + "    \t\t                    ";
  protected final String TEXT_149 = "  \t\t\t" + NL + "    \t\t            }\t" + NL + "    \t\t            currentRow_";
  protected final String TEXT_150 = "++;\t\t\t\t" + NL + "    \t\t\t" + NL + "    " + NL + "    \t\t            ";
  protected final String TEXT_151 = NL + "    \t\t" + NL + "    \t\t            out";
  protected final String TEXT_152 = ".write(sb_";
  protected final String TEXT_153 = ".toString());" + NL + "    \t\t            ";
  protected final String TEXT_154 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_155 = "%";
  protected final String TEXT_156 = " == 0) {" + NL + "        \t\t                out";
  protected final String TEXT_157 = ".flush();" + NL + "        \t\t                }" + NL + "    \t\t                ";
  protected final String TEXT_158 = "     \t\t\t" + NL + "    \t\t            ";
  protected final String TEXT_159 = NL + "    \t\t        ";
  protected final String TEXT_160 = NL + "    \t\t\t\t} " + NL + "    \t\t        ";
  protected final String TEXT_161 = NL + "    \t\t\t\t} " + NL + "    \t\t        ";
  protected final String TEXT_162 = NL + "    \t\t\t\t}" + NL + "    \t\t\t\t";
  protected final String TEXT_163 = " \t\t\t" + NL + "    \t\t        " + NL + "    \t\t        ";
  protected final String TEXT_164 = NL;
  protected final String TEXT_165 = NL;
  protected final String TEXT_166 = NL + "        \t    dynamic_column_count_";
  protected final String TEXT_167 = " = 1;" + NL + "        \t    ";
  protected final String TEXT_168 = NL + "\t\t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_169 = NL + "\t\t\t\t\tsynchronized (lockWrite) {" + NL + "\t        \t\t\t\t";
  protected final String TEXT_170 = NL + "        \t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "        \t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_171 = NL + "        \t\t\t\tif(isFirstCheckDyn_";
  protected final String TEXT_172 = " ";
  protected final String TEXT_173 = "&& (file_";
  protected final String TEXT_174 = ".length()==0)";
  protected final String TEXT_175 = "){" + NL + "        \t\t\t\t\theadColu";
  protected final String TEXT_176 = " = new String[";
  protected final String TEXT_177 = "-1+";
  protected final String TEXT_178 = ".";
  protected final String TEXT_179 = ".getColumnCount()];" + NL + "            \t\t\t\t";
  protected final String TEXT_180 = NL + "            \t\t\tif(isFirstCheckDyn_";
  protected final String TEXT_181 = " ";
  protected final String TEXT_182 = "&& file";
  protected final String TEXT_183 = ".length()==0";
  protected final String TEXT_184 = "){" + NL + "            \t\t\t\theadColu";
  protected final String TEXT_185 = " = new String[";
  protected final String TEXT_186 = "-1+";
  protected final String TEXT_187 = ".";
  protected final String TEXT_188 = ".getColumnCount()];" + NL + "            \t\t\t";
  protected final String TEXT_189 = NL + "                                    dynamic_column_count_";
  protected final String TEXT_190 = " = ";
  protected final String TEXT_191 = ".";
  protected final String TEXT_192 = ".getColumnCount();";
  protected final String TEXT_193 = NL + "                            \t\tfileOutputDelimitedUtil_";
  protected final String TEXT_194 = ".putHeaderValue_";
  protected final String TEXT_195 = "(headColu";
  protected final String TEXT_196 = ", ";
  protected final String TEXT_197 = ",dynamic_column_count_";
  protected final String TEXT_198 = ");";
  protected final String TEXT_199 = NL + "        \t\t        \theadColu";
  protected final String TEXT_200 = "[";
  protected final String TEXT_201 = "+dynamic_column_count_";
  protected final String TEXT_202 = "]=\"";
  protected final String TEXT_203 = "\";" + NL + "            \t\t         ";
  protected final String TEXT_204 = NL + "        \t\t        \theadColu";
  protected final String TEXT_205 = "[";
  protected final String TEXT_206 = "]=\"";
  protected final String TEXT_207 = "\";" + NL + "            \t\t         ";
  protected final String TEXT_208 = NL + "        \t    \t\t     for(int mi=0;mi<dynamic_column_count_";
  protected final String TEXT_209 = ";mi++){" + NL + "        \t    \t\t     \theadColu";
  protected final String TEXT_210 = "[";
  protected final String TEXT_211 = "+mi]=";
  protected final String TEXT_212 = ".";
  protected final String TEXT_213 = ".getColumnMetadata(mi).getName();" + NL + "        \t    \t\t     }" + NL + "        \t    \t\t     ";
  protected final String TEXT_214 = NL + "                            CsvWriter";
  protected final String TEXT_215 = ".writeNext(headColu";
  protected final String TEXT_216 = ");" + NL + "        \t            \tCsvWriter";
  protected final String TEXT_217 = ".flush();" + NL + "        \t            \t";
  protected final String TEXT_218 = NL + "        \t            \tout";
  protected final String TEXT_219 = ".write(strWriter";
  protected final String TEXT_220 = ".getBuffer().toString());" + NL + "        \t            \tout";
  protected final String TEXT_221 = ".flush();" + NL + "        \t            \tstrWriter";
  protected final String TEXT_222 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_223 = ".getBuffer().length()); \t" + NL + "                    \t\t";
  protected final String TEXT_224 = NL + "        \t            }" + NL + "            \t        ";
  protected final String TEXT_225 = NL + "\t\t\t\t\t} " + NL + "            \t        ";
  protected final String TEXT_226 = NL + "\t\t\t\t\t} " + NL + "            \t        ";
  protected final String TEXT_227 = NL + "\t\t\t\t\t}" + NL + "            \t\t\t";
  protected final String TEXT_228 = NL + "        \t            if(isFirstCheckDyn_";
  protected final String TEXT_229 = "){" + NL + "                    \t\tCsvWriter";
  protected final String TEXT_230 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_231 = ".getEscapeChar());" + NL + "            \t\t\t\tCsvWriter";
  protected final String TEXT_232 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_233 = ".getTextEnclosure());" + NL + "            \t\t\t\tCsvWriter";
  protected final String TEXT_234 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);" + NL + "                    \t\tisFirstCheckDyn_";
  protected final String TEXT_235 = " = false;" + NL + "                    \t}";
  protected final String TEXT_236 = "  \t" + NL + "                    \tString[] row";
  protected final String TEXT_237 = "=new String[";
  protected final String TEXT_238 = "];\t\t" + NL + "                    \t";
  protected final String TEXT_239 = NL + "                    \tdynamic_column_count_";
  protected final String TEXT_240 = " =1;" + NL + "                    \t";
  protected final String TEXT_241 = NL + "                \t\t\t    dynamic_column_count_";
  protected final String TEXT_242 = " = ";
  protected final String TEXT_243 = ".";
  protected final String TEXT_244 = ".getColumnCount();" + NL + "                \t\t\t    ";
  protected final String TEXT_245 = NL + "                            \tfileOutputDelimitedUtil_";
  protected final String TEXT_246 = ".putValue_";
  protected final String TEXT_247 = "(";
  protected final String TEXT_248 = ",row";
  protected final String TEXT_249 = ",dynamic_column_count_";
  protected final String TEXT_250 = " ";
  protected final String TEXT_251 = ");";
  protected final String TEXT_252 = NL + "                            if (";
  protected final String TEXT_253 = ".";
  protected final String TEXT_254 = " != null) {" + NL + "                            \troutines.system.DynamicUtils.writeValuesToStringArray(";
  protected final String TEXT_255 = ".";
  protected final String TEXT_256 = ", row";
  protected final String TEXT_257 = ", ";
  protected final String TEXT_258 = ");" + NL + "                            }" + NL + "                \t\t\t";
  protected final String TEXT_259 = " " + NL + "                \t\t\trow";
  protected final String TEXT_260 = "[";
  protected final String TEXT_261 = "+dynamic_column_count_";
  protected final String TEXT_262 = "]=";
  protected final String TEXT_263 = NL + "                \t\t\trow";
  protected final String TEXT_264 = "[";
  protected final String TEXT_265 = "]=";
  protected final String TEXT_266 = ".";
  protected final String TEXT_267 = ";" + NL + "                \t\t\t";
  protected final String TEXT_268 = "FormatterUtils.format_Date(";
  protected final String TEXT_269 = ".";
  protected final String TEXT_270 = ", ";
  protected final String TEXT_271 = ");" + NL + "                \t\t\t";
  protected final String TEXT_272 = "java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_273 = ".";
  protected final String TEXT_274 = ")).toString();" + NL + "                \t\t\t";
  protected final String TEXT_275 = "FormatterUtils.format_Number(";
  protected final String TEXT_276 = ".toPlainString(), ";
  protected final String TEXT_277 = ", ";
  protected final String TEXT_278 = ");\t\t\t\t\t" + NL + "                \t\t\t";
  protected final String TEXT_279 = "FormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_280 = ".";
  protected final String TEXT_281 = ")).toPlainString(), ";
  protected final String TEXT_282 = ", ";
  protected final String TEXT_283 = ");\t\t\t\t\t\t" + NL + "                \t\t\t";
  protected final String TEXT_284 = ".toPlainString();" + NL + "                \t\t\t";
  protected final String TEXT_285 = "String.valueOf(";
  protected final String TEXT_286 = ".";
  protected final String TEXT_287 = ");" + NL + "                \t\t\t";
  protected final String TEXT_288 = NL + "    \t\t\tsynchronized (multiThreadLockWrite) {";
  protected final String TEXT_289 = NL + "\t\t\t\tsynchronized (lockWrite) {";
  protected final String TEXT_290 = NL + "\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\tsynchronized (pLockWrite) {";
  protected final String TEXT_291 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_292 = "++;";
  protected final String TEXT_293 = NL + "            \t\t\t    if(currentRow_";
  protected final String TEXT_294 = " % splitEvery_";
  protected final String TEXT_295 = "==0 && currentRow_";
  protected final String TEXT_296 = "!=0){" + NL + "            \t\t\t        splitedFileNo_";
  protected final String TEXT_297 = "++;" + NL + "            \t\t\t        CsvWriter";
  protected final String TEXT_298 = ".close(); " + NL + "            \t\t\t        //close original outputStream" + NL + "            \t\t\t        ";
  protected final String TEXT_299 = NL + "            \t\t\t        out";
  protected final String TEXT_300 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "\t\t\t\t\t\t\t\t\tnew java.io.FileOutputStream(fullName_";
  protected final String TEXT_301 = " + splitedFileNo_";
  protected final String TEXT_302 = " + extension_";
  protected final String TEXT_303 = ", ";
  protected final String TEXT_304 = "),";
  protected final String TEXT_305 = "));" + NL + "\t\t\t\t\t\t\t\tstrWriter";
  protected final String TEXT_306 = " = new java.io.StringWriter();" + NL + "            \t                CsvWriter";
  protected final String TEXT_307 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_308 = ");" + NL + "            \t                CsvWriter";
  protected final String TEXT_309 = ".setSeparator(csvSettings_";
  protected final String TEXT_310 = ".getFieldDelim());" + NL + "            \t                ";
  protected final String TEXT_311 = NL + "            \t                CsvWriter";
  protected final String TEXT_312 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "\t\t\t\t\t\t\t\t\tnew java.io.FileOutputStream(fullName_";
  protected final String TEXT_313 = " + splitedFileNo_";
  protected final String TEXT_314 = " + extension_";
  protected final String TEXT_315 = ", ";
  protected final String TEXT_316 = "),";
  protected final String TEXT_317 = ")));" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_318 = ".setSeparator(csvSettings_";
  protected final String TEXT_319 = ".getFieldDelim());" + NL + "            \t                ";
  protected final String TEXT_320 = NL + "    \t\t\t            \tif(csvSettings_";
  protected final String TEXT_321 = ".getRowDelim()!='\\r' && csvSettings_";
  protected final String TEXT_322 = ".getRowDelim()!='\\n')" + NL + "    \t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_323 = ".setLineEnd(\"\"+csvSettings_";
  protected final String TEXT_324 = ".getRowDelim());" + NL + "            \t\t\t        //set header." + NL + "            \t\t\t        ";
  protected final String TEXT_325 = NL + "            \t\t\t            CsvWriter";
  protected final String TEXT_326 = ".writeNext(headColu";
  protected final String TEXT_327 = ");" + NL + "            \t\t\t            ";
  protected final String TEXT_328 = "\t" + NL + "            \t\t\t            out";
  protected final String TEXT_329 = ".write(strWriter";
  protected final String TEXT_330 = ".getBuffer().toString());" + NL + "               \t\t\t\t\t\tstrWriter";
  protected final String TEXT_331 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_332 = ".getBuffer().length());" + NL + "            \t\t\t            ";
  protected final String TEXT_333 = NL + "                                    file";
  protected final String TEXT_334 = " = new java.io.File(fullName_";
  protected final String TEXT_335 = " + splitedFileNo_";
  protected final String TEXT_336 = " + extension_";
  protected final String TEXT_337 = ");" + NL + "                        \t\t    if(file";
  protected final String TEXT_338 = ".length() == 0) {" + NL + "                        \t\t        CsvWriter";
  protected final String TEXT_339 = ".writeNext(headColu";
  protected final String TEXT_340 = "); " + NL + "                        \t\t        ";
  protected final String TEXT_341 = NL + "                        \t\t        out";
  protected final String TEXT_342 = ".write(strWriter";
  protected final String TEXT_343 = ".getBuffer().toString());" + NL + "                \t\t\t\t\t\tstrWriter";
  protected final String TEXT_344 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_345 = ".getBuffer().length());" + NL + "                \t\t\t\t\t\t";
  protected final String TEXT_346 = NL + "                       \t\t    \t}\t  " + NL + "                        \t\t    ";
  protected final String TEXT_347 = NL + "                        \t\t//initialize new CsvWriter information" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_348 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_349 = ".getEscapeChar());" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_350 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_351 = ".getTextEnclosure());" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_352 = ".setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);" + NL + "\t\t\t\t\t      \t\t        \t\t" + NL + "                        \t\tCsvWriter";
  protected final String TEXT_353 = ".writeNext(row";
  protected final String TEXT_354 = ");" + NL + "                        \t\t";
  protected final String TEXT_355 = NL + "                        \t\tout";
  protected final String TEXT_356 = ".write(strWriter";
  protected final String TEXT_357 = ".getBuffer().toString());" + NL + "                \t\t\t\tstrWriter";
  protected final String TEXT_358 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_359 = ".getBuffer().length());" + NL + "                        \t\t";
  protected final String TEXT_360 = NL + "            \t\t                if(nb_line_";
  protected final String TEXT_361 = "%";
  protected final String TEXT_362 = " == 0) {" + NL + "            \t\t                ";
  protected final String TEXT_363 = NL + "            \t\t                out";
  protected final String TEXT_364 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_365 = NL + "            \t\t                CsvWriter";
  protected final String TEXT_366 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_367 = NL + "            \t\t                }" + NL + "                        \t\t    ";
  protected final String TEXT_368 = " " + NL + "         \t\t\t\t" + NL + "         \t\t\t\t\t}else{" + NL + "         \t\t\t\t\t    CsvWriter";
  protected final String TEXT_369 = ".writeNext(row";
  protected final String TEXT_370 = ");\t" + NL + "         \t\t\t\t\t    ";
  protected final String TEXT_371 = NL + "         \t\t\t\t\t    out";
  protected final String TEXT_372 = ".write(strWriter";
  protected final String TEXT_373 = ".getBuffer().toString());" + NL + "                \t\t\t\tstrWriter";
  protected final String TEXT_374 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_375 = ".getBuffer().length());" + NL + "         \t\t\t\t\t    ";
  protected final String TEXT_376 = NL + "            \t\t                if(nb_line_";
  protected final String TEXT_377 = "%";
  protected final String TEXT_378 = " == 0) {" + NL + "            \t\t                ";
  protected final String TEXT_379 = NL + "            \t\t                out";
  protected final String TEXT_380 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_381 = NL + "            \t\t                CsvWriter";
  protected final String TEXT_382 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_383 = NL + "            \t\t                }" + NL + "         \t\t\t\t\t        ";
  protected final String TEXT_384 = "  \t\t\t\t\t" + NL + "         \t\t\t\t\t}\t" + NL + "            \t\t\t    currentRow_";
  protected final String TEXT_385 = "++;\t\t" + NL + "             \t\t\t" + NL + "            \t\t\t    ";
  protected final String TEXT_386 = NL + "            \t\t\t    CsvWriter";
  protected final String TEXT_387 = ".writeNext(row";
  protected final String TEXT_388 = ");\t" + NL + "            \t\t\t    ";
  protected final String TEXT_389 = NL + "            \t\t\t    out";
  protected final String TEXT_390 = ".write(strWriter";
  protected final String TEXT_391 = ".getBuffer().toString());" + NL + "                \t\t\tstrWriter";
  protected final String TEXT_392 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_393 = ".getBuffer().length());" + NL + "            \t\t\t    ";
  protected final String TEXT_394 = NL + "            \t\t                if(nb_line_";
  protected final String TEXT_395 = "%";
  protected final String TEXT_396 = " == 0) {" + NL + "            \t\t                ";
  protected final String TEXT_397 = NL + "            \t\t                out";
  protected final String TEXT_398 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_399 = NL + "            \t\t                CsvWriter";
  protected final String TEXT_400 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_401 = NL + "            \t\t                }" + NL + "            \t\t\t        ";
  protected final String TEXT_402 = "  \t\t\t\t" + NL + "            \t\t\t    ";
  protected final String TEXT_403 = NL + "    \t\t\t} ";
  protected final String TEXT_404 = NL + "\t\t\t\t}";
  protected final String TEXT_405 = NL + "    \t\t\t}";
  protected final String TEXT_406 = NL + "            \t\t\t" + NL + "            \t\t\t";
  protected final String TEXT_407 = NL;
  protected final String TEXT_408 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));
int schemaOptNum=100;
String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
	schemaOptNum  = Integer.parseInt(schemaOptNumStr);
}
int dynamic_column_index=-1;
if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_2);
    
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
                        
            
            String encoding = ElementParameterParser.getValue(
                node,
                "__ENCODING__"
            );
            
            boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
            
            boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
    		
    		boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
    		
    		boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
            
            boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
            String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
            
    		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
   		    
			String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
			boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
			
			boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
			
			boolean hasDynamic = metadata.isDynamicSchema();

        	List< ? extends IConnection> conns = node.getIncomingConnections();
        	for (IConnection conn : conns) {
        		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        			List<IMetadataColumn> columns = metadata.getListColumns();
        			int sizeColumns = columns.size();
        		    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
	                if(isIncludeHeader && hasDynamic){
						if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_5);
    
    					}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {
				
    stringBuffer.append(TEXT_6);
     
    		        	}
    		        	if (isParallelize) {
				
    stringBuffer.append(TEXT_7);
     
						}
	                	if(!split && compress && !isAppend){
	                	
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    if(!useStream){
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    
	                	}else{
    		        
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    if(!useStream){
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    
        		        }
                    	for (int i = 0; i < sizeColumns; i++) {
                            IMetadataColumn column = columns.get(i);
                            if(sizeColumns> schemaOptNum){
                            	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_23);
    
                            	}
                            }else{//AA
                            if(!("id_Dynamic".equals(column.getTalendType()))) {
        		         
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_26);
    
        		            }else{
    	    		     
    stringBuffer.append(TEXT_27);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    
        		            }
        		            if(i != sizeColumns - 1) {
        		         
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    
                            }
                            }//AA
                        }
        		        
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
     
		        		if (isParallelize) {
				
    stringBuffer.append(TEXT_39);
    
		        		}
						if (codeGenArgument.subTreeContainsParallelIterate()) {
				
    stringBuffer.append(TEXT_40);
    
		        		}
		        		if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_41);
    
						}
		        
    stringBuffer.append(TEXT_42);
    
    		        }					  
        			for (int i = 0; i < sizeColumns; i++) {
      			
        				IMetadataColumn column = columns.get(i);
    					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
    					if(sizeColumns> schemaOptNum){
                            if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
                            }
                        }else{//BB
    					if(!isPrimitive) {
    					    
    stringBuffer.append(TEXT_49);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_51);
    
    				    } 
    				    if(column.getTalendType().equals("id_Dynamic")){
    				    	dynamic_column_index = i;

    stringBuffer.append(TEXT_52);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    
    				    }else{
    				    
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
    			        	String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			        	if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
    			            
    stringBuffer.append(TEXT_59);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_61);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_62);
    	
    						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
							
    stringBuffer.append(TEXT_63);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_65);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_67);
     } else { 
    stringBuffer.append(TEXT_68);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_72);
     } 
    stringBuffer.append(TEXT_73);
    
							} else if(javaType == JavaTypesManager.BIGDECIMAL){
    						
    stringBuffer.append(TEXT_74);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_75);
    
							} else if(javaType == JavaTypesManager.BYTE_ARRAY){
    						
    stringBuffer.append(TEXT_76);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_79);
    
    			        	} else {
    			            
    stringBuffer.append(TEXT_80);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_82);
    				
    			        	}
    			        
    stringBuffer.append(TEXT_83);
    
    					}
    					if(!isPrimitive) {
    					    
    stringBuffer.append(TEXT_84);
    
    			        } 
    			        if(i != sizeColumns - 1) {
    			            
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    
    			        }
    			        }//BB
    		        }
    		        
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    
    					if(codeGenArgument.getIsRunInMultiThread()){
    				
    stringBuffer.append(TEXT_91);
    
    					}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {
    				
    stringBuffer.append(TEXT_92);
     
    		        	}
    		        	if (isParallelize) {
  					
    stringBuffer.append(TEXT_93);
     
						}
    		        
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    
    		        // add a prerequisite useStream to support output stream feature:8873
    		        if(!useStream && split){ 
    		            
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(isInRowMode?"routines.system.BufferedOutput":"java.io.BufferedWriter");
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append( isAppend);
    stringBuffer.append(TEXT_107);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    
    		                if(isIncludeHeader){
    		                    
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    		
    		                        //List<IMetadataColumn> columns = metadata.getListColumns();
    		                        //int sizeColumns = columns.size();
    		                        for (int i = 0; i < sizeColumns; i++) {
    		                            IMetadataColumn column = columns.get(i);
										if(sizeColumns> schemaOptNum){
                            				if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    if(hasDynamic){
    stringBuffer.append(TEXT_119);
    stringBuffer.append(conn.getName() );
    }
    stringBuffer.append(TEXT_120);
    
                            				}
                           			 	}else{//CC
    		                            if(!("id_Dynamic".equals(column.getTalendType()))) {
    		                            
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_123);
    
    		                            }else{
	    		            			
    stringBuffer.append(TEXT_124);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    
    		                            }
    		                            if(i != sizeColumns - 1) {
    		                                
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    
    		                            }
    		                            }//CC
    		                        }
    		                        
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    
    		                }
    		                
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_137);
     
    		                if(flushOnRow) { 
    		                    
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    
    		                }
    		                
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
     
    		                if(flushOnRow) { 
    		                    
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    
    		                }
    		                
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
     
    		        } else { 
    		            
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
     
    		            if(flushOnRow) { 
    		                
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    
    		            }
    		            
    stringBuffer.append(TEXT_158);
    
    		        }
    		        
    stringBuffer.append(TEXT_159);
     
    		        	if (isParallelize) {
    				
    stringBuffer.append(TEXT_160);
    
    		        	}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {
    				
    stringBuffer.append(TEXT_161);
    
    		        	}
    		        	if(codeGenArgument.getIsRunInMultiThread()){
    				
    stringBuffer.append(TEXT_162);
    
    					}
    		        
    stringBuffer.append(TEXT_163);
    
    	        }
            }
        }
    }
    
    stringBuffer.append(TEXT_164);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{//the following is the tFileOutputCSV component
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_165);
    
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {                                    
            String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    		String delim = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
        	boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
        	boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));

        	boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
        	
        	boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
        	
        	boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
        	String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
        	
    		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);        	
        	
        	String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
			boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
        	
        	List< ? extends IConnection> conns = node.getIncomingConnections();
        	
        	boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
        	
        	boolean hasDynamic = metadata.isDynamicSchema();
        	IMetadataColumn dynamicCol = metadata.getDynamicColumn();
        	if(hasDynamic){
        	    
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    
        	}
        	if(conns!=null){
        		if (conns.size()>0){
        		    IConnection conn =conns.get(0);
            		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        				List<IMetadataColumn> columns = metadata.getListColumns();
            			int sizeColumns = columns.size();
            			if(isIncludeHeader && hasDynamic){

							if(codeGenArgument.getIsRunInMultiThread()){
							
    stringBuffer.append(TEXT_168);
    
            				}
            				if (codeGenArgument.subTreeContainsParallelIterate()) {
							
    stringBuffer.append(TEXT_169);
     
            	        	}
            	        	if (isParallelize) {
							
    stringBuffer.append(TEXT_170);
     
							}
            				if(!split && compress && !isAppend){
            				
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    if(!useStream){
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    }
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_178);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_179);
    
            				}else{
            			
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    if(!useStream){
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    }
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_187);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_188);
    
            				}
                        	for (int i = 0; i < sizeColumns; i++) {
                                IMetadataColumn column = columns.get(i);
                                if(("id_Dynamic").equals(column.getTalendType())) {
                                    
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_192);
    
                                }
								if(sizeColumns> schemaOptNum){
                            		if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    
                            		}
                            	}else{//DD
                                if(!("id_Dynamic".equals(column.getTalendType()))) {
                                	if(i>dynamic_column_index&& dynamic_column_index != -1){
            		         
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_203);
    
            		         		}else{
            		         
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_207);
    
            		         		}
            		            }else{
            		            dynamic_column_index = i;
        	    		     
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_212);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_213);
    
            		            }
            		            }//DD
                            }
                            
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    if(isInRowMode){
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
    }
    stringBuffer.append(TEXT_224);
     
            	        	if (isParallelize) {
            			
    stringBuffer.append(TEXT_225);
    
            	        	}
            				if (codeGenArgument.subTreeContainsParallelIterate()) {
            			
    stringBuffer.append(TEXT_226);
    
            	        	}
            	        	if(codeGenArgument.getIsRunInMultiThread()){
            			
    stringBuffer.append(TEXT_227);
    
            				}
            	        
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    
            			}
            			
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(hasDynamic?"+"+conn.getName()+".":"" );
    stringBuffer.append(dynamicCol==null?"":dynamicCol.getLabel()+".getColumnCount()-1" );
    stringBuffer.append(TEXT_238);
    
                    	if(hasDynamic){
                    	
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    
                    	}
            			for (int i = 0; i < sizeColumns; i++) {
                			IMetadataColumn column = columns.get(i);
                			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                			boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
                			if(("id_Dynamic").equals(column.getTalendType())) {
                			    
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_243);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_244);
    
                			}
							if(sizeColumns> schemaOptNum){
                            	if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    if(hasDynamic){
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    }
    stringBuffer.append(TEXT_251);
    
                            	}
                            }else{//EE
                			if(("id_Dynamic").equals(column.getTalendType())) {
                			    dynamic_column_index=i;
                			
    stringBuffer.append(TEXT_252);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_253);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_254);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_255);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(dynamic_column_index);
    stringBuffer.append(TEXT_258);
    
                			}else{
                				if(i>dynamic_column_index && dynamic_column_index !=-1){
                			
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(i-1);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ "==null?\"\":");
    					
                				}else{
                			
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ "==null?\"\":");
    					
                				}
                				if(javaType == JavaTypesManager.STRING ){
                			
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_267);
    
                				}else if(javaType == JavaTypesManager.DATE && pattern != null){
                			
    stringBuffer.append(TEXT_268);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_270);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_271);
    
                				}else if(javaType == JavaTypesManager.BYTE_ARRAY){
                			
    stringBuffer.append(TEXT_272);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_274);
    
                				} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        							if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_275);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_276);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_277);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_278);
      	} else { 
    stringBuffer.append(TEXT_279);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_281);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_282);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_283);
    		}
        						} else if (javaType == JavaTypesManager.BIGDECIMAL) {
							
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_284);
    
                			 	} else{
                			
    stringBuffer.append(TEXT_285);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_287);
    
                				}
                			}
                			}//EE
            			}

        					if(codeGenArgument.getIsRunInMultiThread()){

    stringBuffer.append(TEXT_288);
    
    					}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {

    stringBuffer.append(TEXT_289);
    
						}
						if (isParallelize) {

    stringBuffer.append(TEXT_290);
    
						}

    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    
            			if(!useStream && split){
            			    
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    if(isInRowMode){
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    }else{
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_316);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_317);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    }
    stringBuffer.append(TEXT_320);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    
            			        if(isIncludeHeader && !isAppend){
            			            
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    if(isInRowMode){
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_332);
    }
            			        }
            			        if(isIncludeHeader && isAppend){
            			            
    stringBuffer.append(TEXT_333);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_336);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_340);
    if(isInRowMode){
    stringBuffer.append(TEXT_341);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_345);
    }
    stringBuffer.append(TEXT_346);
    
            			        }
                        		
    stringBuffer.append(TEXT_347);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_353);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_354);
    if(isInRowMode){
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    }
                        		if(flushOnRow) { 
                        		    
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_362);
    if(isInRowMode){
    stringBuffer.append(TEXT_363);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_364);
    }else{
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    }
    stringBuffer.append(TEXT_367);
    
                    			}
                        		
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_370);
    if(isInRowMode){
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_372);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_374);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_375);
    }
         					    if(flushOnRow) { 
         					        
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_378);
    if(isInRowMode){
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_380);
    }else{
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_382);
    }
    stringBuffer.append(TEXT_383);
    
         					    }
         					    
    stringBuffer.append(TEXT_384);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_385);
    
            			}else{
            			    
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_388);
    if(isInRowMode){
    stringBuffer.append(TEXT_389);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_393);
    }
            			    if(flushOnRow) { 
            			        
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_396);
    if(isInRowMode){
    stringBuffer.append(TEXT_397);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_398);
    }else{
    stringBuffer.append(TEXT_399);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_400);
    }
    stringBuffer.append(TEXT_401);
    
                			}
            			    
    stringBuffer.append(TEXT_402);
       		
            		
            			}
            			
     
						if ( isParallelize) {

    stringBuffer.append(TEXT_403);
    
    		        	}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {

    stringBuffer.append(TEXT_404);
    
						}
						if(codeGenArgument.getIsRunInMultiThread()){

    stringBuffer.append(TEXT_405);
    
    					}

    stringBuffer.append(TEXT_406);
       		
            		}
        		
        		}
        	}	
    	
        }
    
    }
    
    stringBuffer.append(TEXT_407);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

    stringBuffer.append(TEXT_408);
    return stringBuffer.toString();
  }
}
