package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileInputExcelBeginJava
{
  protected static String nl;
  public static synchronized TFileInputExcelBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputExcelBeginJava result = new TFileInputExcelBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_3 = " {" + NL + "\t\t\t\t" + NL + "\t\t    \tpublic java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, String oneSheetName, boolean useRegex) {" + NL + "\t\t\t        " + NL + "\t\t\t        java.util.List<jxl.Sheet> list = new java.util.ArrayList<jxl.Sheet>();" + NL + "\t\t\t        " + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "\t\t\t        \t" + NL + "\t\t\t\t        jxl.Sheet[] sheets = workbook.getSheets();" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (int i = 0; i < sheets.length; i++) {" + NL + "\t\t\t\t            String sheetName = sheets[i].getName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tjxl.Sheet sheet = workbook.getSheet(sheetName);" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }\t" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "\t\t\t\t        " + NL + "\t\t\t        }else{\t" + NL + "\t\t\t        \tjxl.Sheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "\t\t\t        \t" + NL + "\t\t\t        }" + NL + "\t\t\t        " + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "\t\t    \t" + NL + "\t\t\t    public java.util.List<jxl.Sheet> getSheets(jxl.Workbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<jxl.Sheet> list =  new java.util.ArrayList<jxl.Sheet>();" + NL + "\t\t\t    \tjxl.Sheet sheet = workbook.getSheet(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "\t\t\t    " + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\tRegexUtil_";
  protected final String TEXT_4 = " regexUtil_";
  protected final String TEXT_5 = " = new RegexUtil_";
  protected final String TEXT_6 = "();" + NL + "\t\tfinal jxl.WorkbookSettings workbookSettings_";
  protected final String TEXT_7 = " = new jxl.WorkbookSettings();" + NL + "\t\tworkbookSettings_";
  protected final String TEXT_8 = ".setDrawingsDisabled(true);";
  protected final String TEXT_9 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_10 = ".setCellValidationDisabled(true);";
  protected final String TEXT_11 = NL + "\t\tworkbookSettings_";
  protected final String TEXT_12 = ".setSuppressWarnings(true);";
  protected final String TEXT_13 = "\t\t" + NL + "        workbookSettings_";
  protected final String TEXT_14 = ".setEncoding(";
  protected final String TEXT_15 = ");" + NL + "        " + NL + "        Object source_";
  protected final String TEXT_16 = " =";
  protected final String TEXT_17 = ";" + NL + "        final jxl.Workbook workbook_";
  protected final String TEXT_18 = ";" + NL + "        " + NL + "        java.io.InputStream toClose_";
  protected final String TEXT_19 = " = null;" + NL + "        try {" + NL + "            if(source_";
  protected final String TEXT_20 = " instanceof java.io.InputStream){" + NL + "        \t\ttoClose_";
  protected final String TEXT_21 = " = (java.io.InputStream)source_";
  protected final String TEXT_22 = ";" + NL + "        \t\tworkbook_";
  protected final String TEXT_23 = " = jxl.Workbook.getWorkbook(new java.io.BufferedInputStream(toClose_";
  protected final String TEXT_24 = "), workbookSettings_";
  protected final String TEXT_25 = ");" + NL + "            }else if(source_";
  protected final String TEXT_26 = " instanceof String){" + NL + "        \t\ttoClose_";
  protected final String TEXT_27 = " = new java.io.FileInputStream(source_";
  protected final String TEXT_28 = ".toString());" + NL + "        \t\tworkbook_";
  protected final String TEXT_29 = " = jxl.Workbook.getWorkbook(new java.io.BufferedInputStream(toClose_";
  protected final String TEXT_30 = "), workbookSettings_";
  protected final String TEXT_31 = ");" + NL + "            }else{" + NL + "            \tworkbook_";
  protected final String TEXT_32 = " = null;" + NL + "            \tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "            } " + NL + "        } finally {" + NL + "\t\t\tif(toClose_";
  protected final String TEXT_33 = "!=null) {" + NL + "\t\t\t\ttoClose_";
  protected final String TEXT_34 = ".close();" + NL + "    \t\t}" + NL + "        }" + NL + "        try {";
  protected final String TEXT_35 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_36 = " = java.util.Arrays.<jxl.Sheet> asList(workbook_";
  protected final String TEXT_37 = ".getSheets());";
  protected final String TEXT_38 = NL + "\t\tjava.util.List<jxl.Sheet> sheetList_";
  protected final String TEXT_39 = " = new java.util.ArrayList<jxl.Sheet>();";
  protected final String TEXT_40 = NL + "        sheetList_";
  protected final String TEXT_41 = ".addAll(regexUtil_";
  protected final String TEXT_42 = ".getSheets(workbook_";
  protected final String TEXT_43 = ", ";
  protected final String TEXT_44 = ", ";
  protected final String TEXT_45 = "));";
  protected final String TEXT_46 = NL + "        if(sheetList_";
  protected final String TEXT_47 = ".size() <= 0){" + NL + "        \tthrow new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "        " + NL + "        java.util.List<jxl.Sheet> sheet_FilterNullList_";
  protected final String TEXT_48 = " = new java.util.ArrayList<jxl.Sheet>();" + NL + "        for(jxl.Sheet sheet_FilterNull_";
  protected final String TEXT_49 = " : sheetList_";
  protected final String TEXT_50 = "){" + NL + "        \tif(sheet_FilterNull_";
  protected final String TEXT_51 = ".getRows()>0){" + NL + "        \t\tsheet_FilterNullList_";
  protected final String TEXT_52 = ".add(sheet_FilterNull_";
  protected final String TEXT_53 = ");" + NL + "        \t}" + NL + "        }" + NL + "\t\tsheetList_";
  protected final String TEXT_54 = " = sheet_FilterNullList_";
  protected final String TEXT_55 = ";" + NL + "\tif(sheetList_";
  protected final String TEXT_56 = ".size()>0){" + NL + "        int nb_line_";
  protected final String TEXT_57 = " = 0;            " + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_58 = " = ";
  protected final String TEXT_59 = "0";
  protected final String TEXT_60 = ";" + NL + "        " + NL + "        int footer_input_";
  protected final String TEXT_61 = " = ";
  protected final String TEXT_62 = "0";
  protected final String TEXT_63 = ";" + NL + "        " + NL + "        int end_line_";
  protected final String TEXT_64 = "=0;" + NL + "        for(jxl.Sheet sheet_";
  protected final String TEXT_65 = ":sheetList_";
  protected final String TEXT_66 = "){" + NL + "        \tend_line_";
  protected final String TEXT_67 = "+=sheet_";
  protected final String TEXT_68 = ".getRows();" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_69 = " -= footer_input_";
  protected final String TEXT_70 = ";" + NL + "        int limit_";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = "-1";
  protected final String TEXT_73 = ";" + NL + "        int start_column_";
  protected final String TEXT_74 = " = ";
  protected final String TEXT_75 = "0";
  protected final String TEXT_76 = "-1";
  protected final String TEXT_77 = ";" + NL + "        int end_column_";
  protected final String TEXT_78 = " = sheetList_";
  protected final String TEXT_79 = ".get(0).getColumns();";
  protected final String TEXT_80 = NL + "        Integer lastColumn_";
  protected final String TEXT_81 = " = ";
  protected final String TEXT_82 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_83 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_84 = " = lastColumn_";
  protected final String TEXT_85 = ".intValue();" + NL + "        }";
  protected final String TEXT_86 = NL + "        jxl.Cell[] row_";
  protected final String TEXT_87 = " = null;" + NL + "        jxl.Sheet sheet_";
  protected final String TEXT_88 = " = sheetList_";
  protected final String TEXT_89 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_90 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_91 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_92 = " = sheetList_";
  protected final String TEXT_93 = ".get(0).getRows();" + NL + "        " + NL + "        //for the number format" + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_94 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "\t\tchar separatorChar_";
  protected final String TEXT_95 = " = df_";
  protected final String TEXT_96 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "        " + NL + "        for(int i_";
  protected final String TEXT_97 = " = begin_line_";
  protected final String TEXT_98 = "; i_";
  protected final String TEXT_99 = " < end_line_";
  protected final String TEXT_100 = "; i_";
  protected final String TEXT_101 = "++){" + NL + "        " + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_102 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_103 = " != -1 && nb_line_";
  protected final String TEXT_104 = " >= limit_";
  protected final String TEXT_105 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "            while (i_";
  protected final String TEXT_106 = " >= rowCount_";
  protected final String TEXT_107 = " + currentRows_";
  protected final String TEXT_108 = ") {" + NL + "                rowCount_";
  protected final String TEXT_109 = " += currentRows_";
  protected final String TEXT_110 = ";" + NL + "                sheet_";
  protected final String TEXT_111 = " = sheetList_";
  protected final String TEXT_112 = ".get(++sheetIndex_";
  protected final String TEXT_113 = ");" + NL + "                currentRows_";
  protected final String TEXT_114 = " = sheet_";
  protected final String TEXT_115 = ".getRows();" + NL + "            }";
  protected final String TEXT_116 = NL + "            if (rowCount_";
  protected final String TEXT_117 = " <= i_";
  protected final String TEXT_118 = ") {" + NL + "                row_";
  protected final String TEXT_119 = " = sheet_";
  protected final String TEXT_120 = ".getRow(i_";
  protected final String TEXT_121 = " - rowCount_";
  protected final String TEXT_122 = ");" + NL + "            }";
  protected final String TEXT_123 = NL + "            if (rowCount_";
  protected final String TEXT_124 = " <= i_";
  protected final String TEXT_125 = " && i_";
  protected final String TEXT_126 = " - rowCount_";
  protected final String TEXT_127 = " >= begin_line_";
  protected final String TEXT_128 = " && currentRows_";
  protected final String TEXT_129 = " - footer_input_";
  protected final String TEXT_130 = " > i_";
  protected final String TEXT_131 = " - rowCount_";
  protected final String TEXT_132 = ") {" + NL + "                row_";
  protected final String TEXT_133 = " = sheet_";
  protected final String TEXT_134 = ".getRow(i_";
  protected final String TEXT_135 = " - rowCount_";
  protected final String TEXT_136 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_137 = "               " + NL + "        \tglobalMap.put(\"";
  protected final String TEXT_138 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_139 = ".getName());";
  protected final String TEXT_140 = NL + "    \t\t";
  protected final String TEXT_141 = " = null;\t\t\t";
  protected final String TEXT_142 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_143 = " = new String[";
  protected final String TEXT_144 = "];" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_145 = " = end_column_";
  protected final String TEXT_146 = " >\trow_";
  protected final String TEXT_147 = ".length ? row_";
  protected final String TEXT_148 = ".length : end_column_";
  protected final String TEXT_149 = ";" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_150 = ";i++){" + NL + "\t\t\t\t" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_151 = " < actual_end_column_";
  protected final String TEXT_152 = "){" + NL + "\t\t\t\t" + NL + "\t\t\t\t  jxl.Cell cell_";
  protected final String TEXT_153 = " = row_";
  protected final String TEXT_154 = "[i + start_column_";
  protected final String TEXT_155 = "];";
  protected final String TEXT_156 = " " + NL + "                        if (jxl.CellType.NUMBER == cell_";
  protected final String TEXT_157 = ".getType()){" + NL + "                            double doubleCell_";
  protected final String TEXT_158 = " = ((jxl.NumberCell)cell_";
  protected final String TEXT_159 = ").getValue();" + NL + "                            temp_row_";
  protected final String TEXT_160 = "[i] = String.valueOf(doubleCell_";
  protected final String TEXT_161 = ");" + NL + "                            if(temp_row_";
  protected final String TEXT_162 = "[i]!=null) {" + NL + "                                temp_row_";
  protected final String TEXT_163 = "[i] = df_";
  protected final String TEXT_164 = ".format(doubleCell_";
  protected final String TEXT_165 = ");" + NL + "                            }" + NL + "                        } else{" + NL + "                            temp_row_";
  protected final String TEXT_166 = "[i] = cell_";
  protected final String TEXT_167 = ".getContents();" + NL + "                        }";
  protected final String TEXT_168 = NL + "                        temp_row_";
  protected final String TEXT_169 = "[i] = cell_";
  protected final String TEXT_170 = ".getContents();";
  protected final String TEXT_171 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_172 = "[i]=\"\";" + NL + "\t\t\t\t}\t\t\t\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_173 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_174 = " = new ";
  protected final String TEXT_175 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_176 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_177 = " = \"\";" + NL + "\t\t\ttry {\t\t\t";
  protected final String TEXT_178 = "\t\t\t\t\t" + NL + "\t\t\tif(temp_row_";
  protected final String TEXT_179 = "[";
  protected final String TEXT_180 = "]";
  protected final String TEXT_181 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_182 = "=";
  protected final String TEXT_183 = " + start_column_";
  protected final String TEXT_184 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_185 = " = \"";
  protected final String TEXT_186 = "\";";
  protected final String TEXT_187 = NL + "\t\t\t";
  protected final String TEXT_188 = ".";
  protected final String TEXT_189 = " = temp_row_";
  protected final String TEXT_190 = "[";
  protected final String TEXT_191 = "]";
  protected final String TEXT_192 = ";";
  protected final String TEXT_193 = "\t\t" + NL + "\t\t\tif(";
  protected final String TEXT_194 = "<actual_end_column_";
  protected final String TEXT_195 = "){" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\tjava.util.Date dateGMT_";
  protected final String TEXT_196 = " = ((jxl.DateCell)row_";
  protected final String TEXT_197 = "[";
  protected final String TEXT_198 = " + start_column_";
  protected final String TEXT_199 = "]).getDate();" + NL + "\t\t\t\t\t";
  protected final String TEXT_200 = ".";
  protected final String TEXT_201 = " = new java.util.Date(dateGMT_";
  protected final String TEXT_202 = ".getTime() - java.util.TimeZone.getDefault().getOffset(dateGMT_";
  protected final String TEXT_203 = ".getTime()));" + NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_204 = NL + "\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_205 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_206 = " + \" )\");" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_207 = NL + "\t\t";
  protected final String TEXT_208 = ".";
  protected final String TEXT_209 = " = ParserUtils.parseTo_";
  protected final String TEXT_210 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_211 = "[";
  protected final String TEXT_212 = "]";
  protected final String TEXT_213 = ", ";
  protected final String TEXT_214 = ", ";
  protected final String TEXT_215 = "));";
  protected final String TEXT_216 = "\t\t\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_217 = ".";
  protected final String TEXT_218 = " = temp_row_";
  protected final String TEXT_219 = "[";
  protected final String TEXT_220 = "]";
  protected final String TEXT_221 = ".getBytes(";
  protected final String TEXT_222 = ");" + NL + "\t";
  protected final String TEXT_223 = NL + "\t\t\t";
  protected final String TEXT_224 = ".";
  protected final String TEXT_225 = " = ParserUtils.parseTo_";
  protected final String TEXT_226 = "(temp_row_";
  protected final String TEXT_227 = "[";
  protected final String TEXT_228 = "]";
  protected final String TEXT_229 = ");";
  protected final String TEXT_230 = "\t\t\t\t\t" + NL + "\t\t\t}else {";
  protected final String TEXT_231 = NL + "\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_232 = "' in '";
  protected final String TEXT_233 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_234 = NL + "\t\t\t\t";
  protected final String TEXT_235 = ".";
  protected final String TEXT_236 = " = ";
  protected final String TEXT_237 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_238 = "++;";
  protected final String TEXT_239 = NL + "\t\t}";
  protected final String TEXT_240 = NL + "\t\t\t\t\t";
  protected final String TEXT_241 = " ";
  protected final String TEXT_242 = " = null; ";
  protected final String TEXT_243 = NL;
  protected final String TEXT_244 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_245 = " == ";
  protected final String TEXT_246 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_247 = "  " + NL + "\t\t\t\t\t" + NL + "    } catch (java.lang.Exception e) {" + NL + "        whetherReject_";
  protected final String TEXT_248 = " = true;";
  protected final String TEXT_249 = NL + "            throw(e);";
  protected final String TEXT_250 = NL + "                    ";
  protected final String TEXT_251 = " = new ";
  protected final String TEXT_252 = "Struct();";
  protected final String TEXT_253 = NL + "                    ";
  protected final String TEXT_254 = ".";
  protected final String TEXT_255 = " = ";
  protected final String TEXT_256 = ".";
  protected final String TEXT_257 = ";";
  protected final String TEXT_258 = NL + "                ";
  protected final String TEXT_259 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_260 = "+ \" column: \" + curColName_";
  protected final String TEXT_261 = " + \" (No. \" + curColNum_";
  protected final String TEXT_262 = " + \")\";";
  protected final String TEXT_263 = NL + "                ";
  protected final String TEXT_264 = " = null;";
  protected final String TEXT_265 = NL + "                System.err.println(e.getMessage());";
  protected final String TEXT_266 = NL + "                ";
  protected final String TEXT_267 = " = null;";
  protected final String TEXT_268 = NL + "            \t";
  protected final String TEXT_269 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_270 = "+ \" column: \" + curColName_";
  protected final String TEXT_271 = " + \" (No. \" + curColNum_";
  protected final String TEXT_272 = " + \")\";";
  protected final String TEXT_273 = NL + "    }\t\t\t\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_274 = NL + "\t\t";
  protected final String TEXT_275 = "if(!whetherReject_";
  protected final String TEXT_276 = ") { ";
  protected final String TEXT_277 = "      " + NL + "             if(";
  protected final String TEXT_278 = " == null){ " + NL + "            \t ";
  protected final String TEXT_279 = " = new ";
  protected final String TEXT_280 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_281 = NL + "\t    \t ";
  protected final String TEXT_282 = ".";
  protected final String TEXT_283 = " = ";
  protected final String TEXT_284 = ".";
  protected final String TEXT_285 = ";    \t\t\t\t";
  protected final String TEXT_286 = NL + "\t\t";
  protected final String TEXT_287 = " } ";
  protected final String TEXT_288 = "\t";
  protected final String TEXT_289 = NL + "\t\t\torg.apache.log4j.Logger logger_";
  protected final String TEXT_290 = " = org.apache.log4j.Logger.getLogger(\"org.openxml4j.opc\");" + NL + "\t        logger_";
  protected final String TEXT_291 = ".setLevel(org.apache.log4j.Level.WARN);" + NL + "\t\t\tclass RegexUtil_";
  protected final String TEXT_292 = " {" + NL + "\t\t\t\t" + NL + "\t\t    \tpublic java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {" + NL + "\t\t\t        " + NL + "\t\t\t        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\t\t        " + NL + "\t\t\t        if(useRegex){//this part process the regex issue" + NL + "\t\t\t        \t" + NL + "\t\t\t\t        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);" + NL + "\t\t\t\t        for (org.apache.poi.xssf.usermodel.XSSFSheet sheet : workbook) {" + NL + "\t\t\t\t            String sheetName = sheet.getSheetName();" + NL + "\t\t\t\t            java.util.regex.Matcher matcher = pattern.matcher(sheetName);" + NL + "\t\t\t\t            if (matcher.matches()) {" + NL + "\t\t\t\t            \tif(sheet != null){" + NL + "\t\t\t\t                \tlist.add(sheet);" + NL + "\t\t\t\t                }\t" + NL + "\t\t\t\t            }" + NL + "\t\t\t\t        }" + NL + "\t\t\t\t        " + NL + "\t\t\t        }else{\t" + NL + "\t\t\t        \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheet(oneSheetName);" + NL + "\t\t            \tif(sheet != null){" + NL + "\t\t                \tlist.add(sheet);" + NL + "\t\t                }" + NL + "\t\t\t        \t" + NL + "\t\t\t        }" + NL + "\t\t\t        " + NL + "\t\t\t        return list;" + NL + "\t\t\t    }" + NL + "\t\t    \t" + NL + "\t\t\t    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {" + NL + "\t\t\t    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\t\t    \torg.apache.poi.xssf.usermodel.XSSFSheet sheet = workbook.getSheetAt(index);" + NL + "\t            \tif(sheet != null){" + NL + "\t                \tlist.add(sheet);" + NL + "\t                }" + NL + "\t\t\t    \treturn list;" + NL + "\t\t\t    }" + NL + "\t\t\t    " + NL + "\t\t\t}" + NL + "\t\tRegexUtil_";
  protected final String TEXT_293 = " regexUtil_";
  protected final String TEXT_294 = " = new RegexUtil_";
  protected final String TEXT_295 = "();" + NL + "\t\t" + NL + "\t\tObject source_";
  protected final String TEXT_296 = " = ";
  protected final String TEXT_297 = ";" + NL + "\t\torg.apache.poi.xssf.usermodel.XSSFWorkbook workbook_";
  protected final String TEXT_298 = " = null;" + NL + "\t\t" + NL + "\t\tif(source_";
  protected final String TEXT_299 = " instanceof String){" + NL + "\t\t\tworkbook_";
  protected final String TEXT_300 = " = new org.apache.poi.xssf.usermodel.XSSFWorkbook((String)source_";
  protected final String TEXT_301 = ");" + NL + "\t\t} else if(source_";
  protected final String TEXT_302 = " instanceof java.io.InputStream) {" + NL + "     \t\tworkbook_";
  protected final String TEXT_303 = " = new org.apache.poi.xssf.usermodel.XSSFWorkbook((java.io.InputStream)source_";
  protected final String TEXT_304 = ");" + NL + "\t\t} else{" + NL + "\t\t\tworkbook_";
  protected final String TEXT_305 = " = null;" + NL + "\t\t\tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t";
  protected final String TEXT_306 = NL + "    \tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_307 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "    \tfor(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_308 = ":workbook_";
  protected final String TEXT_309 = "){" + NL + "   \t\t\tsheetList_";
  protected final String TEXT_310 = ".add(sheet_";
  protected final String TEXT_311 = ");" + NL + "    \t}";
  protected final String TEXT_312 = NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_";
  protected final String TEXT_313 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();";
  protected final String TEXT_314 = NL + "        sheetList_";
  protected final String TEXT_315 = ".addAll(regexUtil_";
  protected final String TEXT_316 = ".getSheets(workbook_";
  protected final String TEXT_317 = ", ";
  protected final String TEXT_318 = ", ";
  protected final String TEXT_319 = "));";
  protected final String TEXT_320 = NL + "    \tif(sheetList_";
  protected final String TEXT_321 = ".size() <= 0){" + NL + "            throw new RuntimeException(\"Special sheets not exist!\");" + NL + "        }" + NL + "\t\t" + NL + "\t\tjava.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_";
  protected final String TEXT_322 = " = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();" + NL + "\t\tfor (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_";
  protected final String TEXT_323 = " : sheetList_";
  protected final String TEXT_324 = ") {" + NL + "\t\t\tif(sheet_FilterNull_";
  protected final String TEXT_325 = "!=null && sheetList_FilterNull_";
  protected final String TEXT_326 = ".iterator()!=null && sheet_FilterNull_";
  protected final String TEXT_327 = ".iterator().hasNext()){" + NL + "\t\t\t\tsheetList_FilterNull_";
  protected final String TEXT_328 = ".add(sheet_FilterNull_";
  protected final String TEXT_329 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsheetList_";
  protected final String TEXT_330 = " = sheetList_FilterNull_";
  protected final String TEXT_331 = ";" + NL + "\tif(sheetList_";
  protected final String TEXT_332 = ".size()>0){" + NL + "\t\tint nb_line_";
  protected final String TEXT_333 = " = 0;            " + NL + "" + NL + "        int begin_line_";
  protected final String TEXT_334 = " = ";
  protected final String TEXT_335 = "0";
  protected final String TEXT_336 = ";" + NL + "        " + NL + "        int footer_input_";
  protected final String TEXT_337 = " = ";
  protected final String TEXT_338 = "0";
  protected final String TEXT_339 = ";" + NL + "        " + NL + "        int end_line_";
  protected final String TEXT_340 = "=0;" + NL + "        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_341 = ":sheetList_";
  protected final String TEXT_342 = "){" + NL + "\t\t\tend_line_";
  protected final String TEXT_343 = "+=(sheet_";
  protected final String TEXT_344 = ".getLastRowNum()+1);" + NL + "        }" + NL + "        end_line_";
  protected final String TEXT_345 = " -= footer_input_";
  protected final String TEXT_346 = ";" + NL + "        int limit_";
  protected final String TEXT_347 = " = ";
  protected final String TEXT_348 = "-1";
  protected final String TEXT_349 = ";" + NL + "        int start_column_";
  protected final String TEXT_350 = " = ";
  protected final String TEXT_351 = "0";
  protected final String TEXT_352 = "-1";
  protected final String TEXT_353 = ";" + NL + "        int end_column_";
  protected final String TEXT_354 = " = -1;";
  protected final String TEXT_355 = "       " + NL + "        Integer lastColumn_";
  protected final String TEXT_356 = " = ";
  protected final String TEXT_357 = ";" + NL + "        if(lastColumn_";
  protected final String TEXT_358 = "!=null){" + NL + "        \tend_column_";
  protected final String TEXT_359 = " = lastColumn_";
  protected final String TEXT_360 = ".intValue();" + NL + "        }        ";
  protected final String TEXT_361 = NL + "        " + NL + "        org.apache.poi.xssf.usermodel.XSSFRow row_";
  protected final String TEXT_362 = " = null;" + NL + "        org.apache.poi.xssf.usermodel.XSSFSheet sheet_";
  protected final String TEXT_363 = " = sheetList_";
  protected final String TEXT_364 = ".get(0);" + NL + "        int rowCount_";
  protected final String TEXT_365 = " = 0;" + NL + "        int sheetIndex_";
  protected final String TEXT_366 = " = 0;" + NL + "        int currentRows_";
  protected final String TEXT_367 = " = (sheetList_";
  protected final String TEXT_368 = ".get(0).getLastRowNum()+1);" + NL + "\t\t" + NL + "\t\t//for the number format        " + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_369 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "        char decimalChar_";
  protected final String TEXT_370 = " = df_";
  protected final String TEXT_371 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "        " + NL + "        for(int i_";
  protected final String TEXT_372 = " = begin_line_";
  protected final String TEXT_373 = "; i_";
  protected final String TEXT_374 = " < end_line_";
  protected final String TEXT_375 = "; i_";
  protected final String TEXT_376 = "++){" + NL + "       " + NL + "        \tint emptyColumnCount_";
  protected final String TEXT_377 = " = 0;" + NL + "" + NL + "        \tif (limit_";
  protected final String TEXT_378 = " != -1 && nb_line_";
  protected final String TEXT_379 = " >= limit_";
  protected final String TEXT_380 = ") {" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "            while (i_";
  protected final String TEXT_381 = " >= rowCount_";
  protected final String TEXT_382 = " + currentRows_";
  protected final String TEXT_383 = ") {" + NL + "                rowCount_";
  protected final String TEXT_384 = " += currentRows_";
  protected final String TEXT_385 = ";" + NL + "                sheet_";
  protected final String TEXT_386 = " = sheetList_";
  protected final String TEXT_387 = ".get(++sheetIndex_";
  protected final String TEXT_388 = ");" + NL + "                currentRows_";
  protected final String TEXT_389 = " = (sheet_";
  protected final String TEXT_390 = ".getLastRowNum()+1);" + NL + "            }" + NL + "            globalMap.put(\"";
  protected final String TEXT_391 = "_CURRENT_SHEET\",sheet_";
  protected final String TEXT_392 = ".getSheetName());";
  protected final String TEXT_393 = NL + "            if (rowCount_";
  protected final String TEXT_394 = " <= i_";
  protected final String TEXT_395 = ") {" + NL + "                row_";
  protected final String TEXT_396 = " = sheet_";
  protected final String TEXT_397 = ".getRow(i_";
  protected final String TEXT_398 = " - rowCount_";
  protected final String TEXT_399 = ");" + NL + "            }";
  protected final String TEXT_400 = NL + "            if (rowCount_";
  protected final String TEXT_401 = " <= i_";
  protected final String TEXT_402 = " && i_";
  protected final String TEXT_403 = " - rowCount_";
  protected final String TEXT_404 = " >= begin_line_";
  protected final String TEXT_405 = " && currentRows_";
  protected final String TEXT_406 = " - footer_input_";
  protected final String TEXT_407 = " > i_";
  protected final String TEXT_408 = " - rowCount_";
  protected final String TEXT_409 = ") {" + NL + "                row_";
  protected final String TEXT_410 = " = sheet_";
  protected final String TEXT_411 = ".getRow(i_";
  protected final String TEXT_412 = " - rowCount_";
  protected final String TEXT_413 = ");" + NL + "            }else{" + NL + "            \tcontinue;" + NL + "            }";
  protected final String TEXT_414 = "          ";
  protected final String TEXT_415 = NL + "\t\t    ";
  protected final String TEXT_416 = " = null;\t\t\t";
  protected final String TEXT_417 = NL + "\t\t\tString[] temp_row_";
  protected final String TEXT_418 = " = new String[";
  protected final String TEXT_419 = "];";
  protected final String TEXT_420 = "\t\t\t\t" + NL + "\t\t\t\tList<Boolean> datelist_";
  protected final String TEXT_421 = " = new java.util.ArrayList<Boolean>();" + NL + "\t\t\t\tList<String> patternlist_";
  protected final String TEXT_422 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_423 = NL + "\t\t\t\t\t\t\tdatelist_";
  protected final String TEXT_424 = ".add(";
  protected final String TEXT_425 = ");" + NL + "\t\t\t\t\t\t\tpatternlist_";
  protected final String TEXT_426 = ".add(";
  protected final String TEXT_427 = ");";
  protected final String TEXT_428 = NL + "\t\t\tint excel_end_column_";
  protected final String TEXT_429 = ";" + NL + "\t\t\tif(row_";
  protected final String TEXT_430 = "==null){" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_431 = "=0;" + NL + "\t\t\t}else{" + NL + "\t\t\t\texcel_end_column_";
  protected final String TEXT_432 = "=row_";
  protected final String TEXT_433 = ".getLastCellNum();" + NL + "\t\t\t}" + NL + "\t\t\tint actual_end_column_";
  protected final String TEXT_434 = ";" + NL + "\t\t\tif(end_column_";
  protected final String TEXT_435 = " == -1){" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_436 = " = excel_end_column_";
  protected final String TEXT_437 = ";" + NL + "\t\t\t}" + NL + "\t\t\telse{" + NL + "\t\t\t\tactual_end_column_";
  protected final String TEXT_438 = " = end_column_";
  protected final String TEXT_439 = " >\texcel_end_column_";
  protected final String TEXT_440 = " ? excel_end_column_";
  protected final String TEXT_441 = " : end_column_";
  protected final String TEXT_442 = ";" + NL + "\t\t\t}" + NL + "\t\t\torg.apache.poi.ss.formula.eval.NumberEval ne_";
  protected final String TEXT_443 = " = null;" + NL + "\t\t\tfor(int i=0;i<";
  protected final String TEXT_444 = ";i++){" + NL + "\t\t\t\tif(i + start_column_";
  protected final String TEXT_445 = " < actual_end_column_";
  protected final String TEXT_446 = "){" + NL + "\t\t\t\t\torg.apache.poi.ss.usermodel.Cell cell_";
  protected final String TEXT_447 = " = row_";
  protected final String TEXT_448 = ".getCell(i + start_column_";
  protected final String TEXT_449 = ");" + NL + "\t\t\t\t\tif(cell_";
  protected final String TEXT_450 = "!=null){" + NL + "\t\t\t\t\tswitch (cell_";
  protected final String TEXT_451 = ".getCellType()) {" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:" + NL + "                            temp_row_";
  protected final String TEXT_452 = "[i] = cell_";
  protected final String TEXT_453 = ".getRichStringCellValue().getString();" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:" + NL + "                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_454 = ")) {";
  protected final String TEXT_455 = NL + "                    \t        \tif(datelist_";
  protected final String TEXT_456 = ".get(i)){" + NL + "                        \t        \ttemp_row_";
  protected final String TEXT_457 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_458 = ".getDateCellValue(),patternlist_";
  protected final String TEXT_459 = ".get(i));" + NL + "                            \t   \t} else{" + NL + "                                \t\ttemp_row_";
  protected final String TEXT_460 = "[i] = cell_";
  protected final String TEXT_461 = ".getDateCellValue().toString();" + NL + "                                \t}";
  protected final String TEXT_462 = NL + "\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_463 = "[i] =cell_";
  protected final String TEXT_464 = ".getDateCellValue().toString();";
  protected final String TEXT_465 = NL + "                            } else {" + NL + "                                temp_row_";
  protected final String TEXT_466 = "[i] = df_";
  protected final String TEXT_467 = ".format(cell_";
  protected final String TEXT_468 = ".getNumericCellValue());" + NL + "                            }" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:" + NL + "                            temp_row_";
  protected final String TEXT_469 = "[i] =String.valueOf(cell_";
  protected final String TEXT_470 = ".getBooleanCellValue());" + NL + "                            break;" + NL + "                        case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_FORMULA:" + NL + "        \t\t\t\t\tswitch (cell_";
  protected final String TEXT_471 = ".getCachedFormulaResultType()) {" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING:" + NL + "                                    temp_row_";
  protected final String TEXT_472 = "[i] = cell_";
  protected final String TEXT_473 = ".getRichStringCellValue().getString();" + NL + "                                    break;" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC:" + NL + "                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_";
  protected final String TEXT_474 = ")) {";
  protected final String TEXT_475 = NL + "                    \t        \t\t\tif(datelist_";
  protected final String TEXT_476 = ".get(i)){" + NL + "                        \t        \t\t\ttemp_row_";
  protected final String TEXT_477 = "[i] = FormatterUtils.format_Date(cell_";
  protected final String TEXT_478 = ".getDateCellValue(),patternlist_";
  protected final String TEXT_479 = ".get(i));" + NL + "                            \t   \t\t\t} else{" + NL + "                                \t\t\t\ttemp_row_";
  protected final String TEXT_480 = "[i] =cell_";
  protected final String TEXT_481 = ".getDateCellValue().toString();" + NL + "                                \t\t\t}";
  protected final String TEXT_482 = NL + "\t\t\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_483 = "[i] =cell_";
  protected final String TEXT_484 = ".getDateCellValue().toString();";
  protected final String TEXT_485 = NL + "                                    } else {" + NL + "\t                                    ne_";
  protected final String TEXT_486 = " = new org.apache.poi.ss.formula.eval.NumberEval(cell_";
  protected final String TEXT_487 = ".getNumericCellValue());" + NL + "\t\t\t\t\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_488 = "[i] = ne_";
  protected final String TEXT_489 = ".getStringValue();" + NL + "                                    }" + NL + "                                    break;" + NL + "                                case org.apache.poi.ss.usermodel.Cell.CELL_TYPE_BOOLEAN:" + NL + "                                    temp_row_";
  protected final String TEXT_490 = "[i] =String.valueOf(cell_";
  protected final String TEXT_491 = ".getBooleanCellValue());" + NL + "                                    break;" + NL + "                                default:" + NL + "                            \t\ttemp_row_";
  protected final String TEXT_492 = "[i] = \"\";" + NL + "                            }" + NL + "                            break;" + NL + "                        default:" + NL + "                            temp_row_";
  protected final String TEXT_493 = "[i] = \"\";" + NL + "                        }" + NL + "                \t}" + NL + "                \telse{" + NL + "                \t\ttemp_row_";
  protected final String TEXT_494 = "[i]=\"\";" + NL + "                \t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t}else{" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_495 = "[i]=\"\";" + NL + "\t\t\t\t}\t\t\t\t\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\tboolean whetherReject_";
  protected final String TEXT_496 = " = false;" + NL + "\t\t\t";
  protected final String TEXT_497 = " = new ";
  protected final String TEXT_498 = "Struct();" + NL + "\t\t\tint curColNum_";
  protected final String TEXT_499 = " = -1;" + NL + "\t\t\tString curColName_";
  protected final String TEXT_500 = " = \"\";" + NL + "\t\t\ttry{";
  protected final String TEXT_501 = NL + "\t\t\tif(temp_row_";
  protected final String TEXT_502 = "[";
  protected final String TEXT_503 = "]";
  protected final String TEXT_504 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_505 = "=";
  protected final String TEXT_506 = " + start_column_";
  protected final String TEXT_507 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_508 = " = \"";
  protected final String TEXT_509 = "\";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_510 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_511 = ".";
  protected final String TEXT_512 = " = temp_row_";
  protected final String TEXT_513 = "[";
  protected final String TEXT_514 = "]";
  protected final String TEXT_515 = ";";
  protected final String TEXT_516 = "\t\t" + NL + "\t\t\t\tif(";
  protected final String TEXT_517 = "<actual_end_column_";
  protected final String TEXT_518 = "){" + NL + "\t\t\t\t\ttry{" + NL + "\t\t\t\t\t\tif(row_";
  protected final String TEXT_519 = ".getCell(";
  protected final String TEXT_520 = "+ start_column_";
  protected final String TEXT_521 = ").getCellType() == org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(row_";
  protected final String TEXT_522 = ".getCell(";
  protected final String TEXT_523 = "+ start_column_";
  protected final String TEXT_524 = "))){" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_525 = ".";
  protected final String TEXT_526 = " = row_";
  protected final String TEXT_527 = ".getCell(";
  protected final String TEXT_528 = "+ start_column_";
  protected final String TEXT_529 = ").getDateCellValue();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\telse{" + NL + "                            java.util.Date tempDate_";
  protected final String TEXT_530 = " = ParserUtils.parseTo_Date(temp_row_";
  protected final String TEXT_531 = "[";
  protected final String TEXT_532 = "]";
  protected final String TEXT_533 = ", ";
  protected final String TEXT_534 = ");" + NL + "                            if(tempDate_";
  protected final String TEXT_535 = ".after((new SimpleDateFormat(\"yyyy/MM/dd hh:mm:ss.SSS\")).parse(\"9999/12/31 23:59:59.999\"))||tempDate_";
  protected final String TEXT_536 = ".before((new SimpleDateFormat(\"yyyy/MM/dd\")).parse(\"1900/01/01\"))){" + NL + "                                throw new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_537 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_538 = " + \" )\");" + NL + "                            }else{";
  protected final String TEXT_539 = NL + "                                ";
  protected final String TEXT_540 = ".";
  protected final String TEXT_541 = " = tempDate_";
  protected final String TEXT_542 = ";" + NL + "                            }" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_543 = NL + "\t\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_544 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_545 = " + \" )\");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_546 = NL + "\t\t\t\t";
  protected final String TEXT_547 = ".";
  protected final String TEXT_548 = " = ParserUtils.parseTo_";
  protected final String TEXT_549 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_550 = "[";
  protected final String TEXT_551 = "]";
  protected final String TEXT_552 = ", ";
  protected final String TEXT_553 = ", ";
  protected final String TEXT_554 = "));";
  protected final String TEXT_555 = NL + "\t\t\t\t";
  protected final String TEXT_556 = ".";
  protected final String TEXT_557 = " = ParserUtils.parseTo_";
  protected final String TEXT_558 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_559 = "[";
  protected final String TEXT_560 = "]";
  protected final String TEXT_561 = ", null, '.'==decimalChar_";
  protected final String TEXT_562 = " ? null : decimalChar_";
  protected final String TEXT_563 = "));";
  protected final String TEXT_564 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_565 = ".";
  protected final String TEXT_566 = " = temp_row_";
  protected final String TEXT_567 = "[";
  protected final String TEXT_568 = "]";
  protected final String TEXT_569 = ".getBytes(";
  protected final String TEXT_570 = ");";
  protected final String TEXT_571 = NL + "\t\t\t\t";
  protected final String TEXT_572 = ".";
  protected final String TEXT_573 = " = ParserUtils.parseTo_";
  protected final String TEXT_574 = "(temp_row_";
  protected final String TEXT_575 = "[";
  protected final String TEXT_576 = "]";
  protected final String TEXT_577 = ");";
  protected final String TEXT_578 = NL + "\t\t\t}else{";
  protected final String TEXT_579 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_580 = "' in '";
  protected final String TEXT_581 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_582 = NL + "\t\t\t\t";
  protected final String TEXT_583 = ".";
  protected final String TEXT_584 = " = ";
  protected final String TEXT_585 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_586 = "++;";
  protected final String TEXT_587 = NL + "\t\t\t}";
  protected final String TEXT_588 = " ";
  protected final String TEXT_589 = " = null; ";
  protected final String TEXT_590 = NL;
  protected final String TEXT_591 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_592 = " == ";
  protected final String TEXT_593 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_594 = "  " + NL + "\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_595 = " = true;";
  protected final String TEXT_596 = NL + "\t            throw(e);";
  protected final String TEXT_597 = NL + "\t\t\t\t\t";
  protected final String TEXT_598 = " = new ";
  protected final String TEXT_599 = "Struct();";
  protected final String TEXT_600 = NL + "\t\t\t\t\t";
  protected final String TEXT_601 = ".";
  protected final String TEXT_602 = " = ";
  protected final String TEXT_603 = ".";
  protected final String TEXT_604 = ";";
  protected final String TEXT_605 = NL + "\t\t\t\t\t";
  protected final String TEXT_606 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_607 = "+ \" column: \" + curColName_";
  protected final String TEXT_608 = " + \" (No. \" + curColNum_";
  protected final String TEXT_609 = " + \")\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_610 = " = null;";
  protected final String TEXT_611 = NL + "\t\t\t\t\t System.err.println(e.getMessage());" + NL + "\t\t\t\t\t ";
  protected final String TEXT_612 = " = null;";
  protected final String TEXT_613 = NL + "\t\t\t\t\t";
  protected final String TEXT_614 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_615 = "+ \" column: \" + curColName_";
  protected final String TEXT_616 = " + \" (No. \" + curColNum_";
  protected final String TEXT_617 = " + \")\";";
  protected final String TEXT_618 = NL + "\t\t\t}\t" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_619 = NL + "\t\t";
  protected final String TEXT_620 = "if(!whetherReject_";
  protected final String TEXT_621 = ") { ";
  protected final String TEXT_622 = "      " + NL + "             if(";
  protected final String TEXT_623 = " == null){ " + NL + "            \t ";
  protected final String TEXT_624 = " = new ";
  protected final String TEXT_625 = "Struct();" + NL + "             }\t\t\t\t";
  protected final String TEXT_626 = NL + "\t    \t ";
  protected final String TEXT_627 = ".";
  protected final String TEXT_628 = " = ";
  protected final String TEXT_629 = ".";
  protected final String TEXT_630 = ";    \t\t\t\t";
  protected final String TEXT_631 = NL + "\t\t";
  protected final String TEXT_632 = " } ";
  protected final String TEXT_633 = "\t";
  protected final String TEXT_634 = NL + "\t\tObject source_";
  protected final String TEXT_635 = " = ";
  protected final String TEXT_636 = ";" + NL + "\t\tcom.talend.excel.xssf.event.ExcelReader excelReader_";
  protected final String TEXT_637 = " = null;" + NL + "\t\t" + NL + "\t\tif(source_";
  protected final String TEXT_638 = " instanceof java.io.InputStream || source_";
  protected final String TEXT_639 = " instanceof String){" + NL + "\t\t\texcelReader_";
  protected final String TEXT_640 = " = new com.talend.excel.xssf.event.ExcelReader();" + NL + "\t\t}else{" + NL + "\t\t\tthrow new java.lang.Exception(\"The data source should be specified as Inputstream or File Path!\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\ttry {";
  protected final String TEXT_641 = NL + "\t\texcelReader_";
  protected final String TEXT_642 = ".addSheetName(\".*\",true);";
  protected final String TEXT_643 = NL + "\t\texcelReader_";
  protected final String TEXT_644 = ".addSheetName(";
  protected final String TEXT_645 = ", ";
  protected final String TEXT_646 = ");";
  protected final String TEXT_647 = NL + "\t\tint start_column_";
  protected final String TEXT_648 = " = ";
  protected final String TEXT_649 = "0";
  protected final String TEXT_650 = "-1";
  protected final String TEXT_651 = ";" + NL + "\t\tint end_column_";
  protected final String TEXT_652 = " = ";
  protected final String TEXT_653 = "-1";
  protected final String TEXT_654 = "-1";
  protected final String TEXT_655 = ";" + NL + "\t\tif(start_column_";
  protected final String TEXT_656 = " >=0) {//follow start column" + NL + "\t\t\tend_column_";
  protected final String TEXT_657 = " = start_column_";
  protected final String TEXT_658 = " + ";
  protected final String TEXT_659 = " - 1;" + NL + "\t\t} else if(end_column_";
  protected final String TEXT_660 = " >= 0) {//follow end column" + NL + "\t\t\tstart_column_";
  protected final String TEXT_661 = " = end_column_";
  protected final String TEXT_662 = " - ";
  protected final String TEXT_663 = " + 1;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif(end_column_";
  protected final String TEXT_664 = "<0 || start_column_";
  protected final String TEXT_665 = "<0) {" + NL + "\t\t\tthrow new RuntimeException(\"Error start column and end column.\");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tint header_";
  protected final String TEXT_666 = " = ";
  protected final String TEXT_667 = "0";
  protected final String TEXT_668 = ";" + NL + "\t\tint limit_";
  protected final String TEXT_669 = " = ";
  protected final String TEXT_670 = "-1";
  protected final String TEXT_671 = ";" + NL + "\t\t" + NL + "\t\tint nb_line_";
  protected final String TEXT_672 = " = 0;" + NL + "\t\t" + NL + "\t\t//for the number format        " + NL + "        java.text.DecimalFormat df_";
  protected final String TEXT_673 = " = new java.text.DecimalFormat(\"#.####################################\");" + NL + "        char decimalChar_";
  protected final String TEXT_674 = " = df_";
  protected final String TEXT_675 = ".getDecimalFormatSymbols().getDecimalSeparator();" + NL + "\t\t" + NL + "\t\tif(source_";
  protected final String TEXT_676 = " instanceof String){" + NL + "\t\t\texcelReader_";
  protected final String TEXT_677 = ".parse((String)source_";
  protected final String TEXT_678 = ",";
  protected final String TEXT_679 = ");" + NL + "\t\t} else if(source_";
  protected final String TEXT_680 = " instanceof java.io.InputStream) {" + NL + "\t\t\texcelReader_";
  protected final String TEXT_681 = ".parse((java.io.InputStream)source_";
  protected final String TEXT_682 = ",";
  protected final String TEXT_683 = ");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t" + NL + "\t\twhile((header_";
  protected final String TEXT_684 = "--)>0 && excelReader_";
  protected final String TEXT_685 = ".hasNext()) {//skip the header" + NL + "\t\t\texcelReader_";
  protected final String TEXT_686 = ".next();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\twhile(excelReader_";
  protected final String TEXT_687 = ".hasNext()) {" + NL + "\t\t\tint emptyColumnCount_";
  protected final String TEXT_688 = " = 0;" + NL + "\t\t" + NL + "\t\t\tif (limit_";
  protected final String TEXT_689 = " != -1 && nb_line_";
  protected final String TEXT_690 = " >= limit_";
  protected final String TEXT_691 = ") {" + NL + "\t\t\t\texcelReader_";
  protected final String TEXT_692 = ".stopRead();" + NL + "        \t\tbreak;" + NL + "        \t}" + NL + "        \t" + NL + "        \tjava.util.List<String> row_";
  protected final String TEXT_693 = " = excelReader_";
  protected final String TEXT_694 = ".next();";
  protected final String TEXT_695 = NL + "\t\t";
  protected final String TEXT_696 = " = null;\t\t\t";
  protected final String TEXT_697 = NL + "\t\tString[] temp_row_";
  protected final String TEXT_698 = " = new String[";
  protected final String TEXT_699 = "];" + NL + "\t\tfor(int i_";
  protected final String TEXT_700 = "=0;i_";
  protected final String TEXT_701 = " < ";
  protected final String TEXT_702 = ";i_";
  protected final String TEXT_703 = "++){" + NL + "\t\t\tint current_";
  protected final String TEXT_704 = " = i_";
  protected final String TEXT_705 = " + start_column_";
  protected final String TEXT_706 = ";" + NL + "\t\t\tif(current_";
  protected final String TEXT_707 = " <= end_column_";
  protected final String TEXT_708 = "){" + NL + "\t\t\t\tif(current_";
  protected final String TEXT_709 = " < row_";
  protected final String TEXT_710 = ".size()){" + NL + "\t\t\t\t\tString column_";
  protected final String TEXT_711 = " = row_";
  protected final String TEXT_712 = ".get(current_";
  protected final String TEXT_713 = ");" + NL + "\t\t\t\t\tif(column_";
  protected final String TEXT_714 = "!=null) {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_715 = "[i_";
  protected final String TEXT_716 = "] = column_";
  protected final String TEXT_717 = ";" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\ttemp_row_";
  protected final String TEXT_718 = "[i_";
  protected final String TEXT_719 = "]=\"\";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\ttemp_row_";
  protected final String TEXT_720 = "[i_";
  protected final String TEXT_721 = "]=\"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\ttemp_row_";
  protected final String TEXT_722 = "[i_";
  protected final String TEXT_723 = "]=\"\";" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tboolean whetherReject_";
  protected final String TEXT_724 = " = false;" + NL + "\t\t";
  protected final String TEXT_725 = " = new ";
  protected final String TEXT_726 = "Struct();" + NL + "\t\tint curColNum_";
  protected final String TEXT_727 = " = -1;" + NL + "\t\tString curColName_";
  protected final String TEXT_728 = " = \"\";" + NL + "\t\t" + NL + "\t\ttry{";
  protected final String TEXT_729 = NL + "\t\t\tif(temp_row_";
  protected final String TEXT_730 = "[";
  protected final String TEXT_731 = "]";
  protected final String TEXT_732 = ".length() > 0) {" + NL + "\t\t\t\tcurColNum_";
  protected final String TEXT_733 = "=";
  protected final String TEXT_734 = " + start_column_";
  protected final String TEXT_735 = " + 1;" + NL + "\t\t\t\tcurColName_";
  protected final String TEXT_736 = " = \"";
  protected final String TEXT_737 = "\";" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_738 = "\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_739 = ".";
  protected final String TEXT_740 = " = temp_row_";
  protected final String TEXT_741 = "[";
  protected final String TEXT_742 = "]";
  protected final String TEXT_743 = ";";
  protected final String TEXT_744 = "\t\t" + NL + "\t\t\t\ttry{" + NL + "\t\t\t\t\t";
  protected final String TEXT_745 = ".";
  protected final String TEXT_746 = " = ParserUtils.parseTo_Date(temp_row_";
  protected final String TEXT_747 = "[";
  protected final String TEXT_748 = "]";
  protected final String TEXT_749 = ", ";
  protected final String TEXT_750 = ");" + NL + "\t\t\t\t}catch(java.lang.Exception e){" + NL + "\t\t\t\t\t";
  protected final String TEXT_751 = NL + "\t\t\t\t\tthrow new RuntimeException(\"The cell format is not Date in ( Row. \"+(nb_line_";
  protected final String TEXT_752 = "+1)+ \" and ColumnNum. \" + curColNum_";
  protected final String TEXT_753 = " + \" )\");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_754 = NL + "\t\t\t\t";
  protected final String TEXT_755 = ".";
  protected final String TEXT_756 = " = ParserUtils.parseTo_";
  protected final String TEXT_757 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_758 = "[";
  protected final String TEXT_759 = "]";
  protected final String TEXT_760 = ", ";
  protected final String TEXT_761 = ", ";
  protected final String TEXT_762 = "));";
  protected final String TEXT_763 = NL + "\t\t\t\t";
  protected final String TEXT_764 = ".";
  protected final String TEXT_765 = " = ParserUtils.parseTo_";
  protected final String TEXT_766 = "(ParserUtils.parseTo_Number(temp_row_";
  protected final String TEXT_767 = "[";
  protected final String TEXT_768 = "]";
  protected final String TEXT_769 = ", null, '.'==decimalChar_";
  protected final String TEXT_770 = " ? null : decimalChar_";
  protected final String TEXT_771 = "));";
  protected final String TEXT_772 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t";
  protected final String TEXT_773 = ".";
  protected final String TEXT_774 = " = temp_row_";
  protected final String TEXT_775 = "[";
  protected final String TEXT_776 = "]";
  protected final String TEXT_777 = ".getBytes(";
  protected final String TEXT_778 = ");";
  protected final String TEXT_779 = NL + "\t\t\t\t";
  protected final String TEXT_780 = ".";
  protected final String TEXT_781 = " = ParserUtils.parseTo_";
  protected final String TEXT_782 = "(temp_row_";
  protected final String TEXT_783 = "[";
  protected final String TEXT_784 = "]";
  protected final String TEXT_785 = ");";
  protected final String TEXT_786 = NL + "\t\t\t}else{";
  protected final String TEXT_787 = NL + "\t\t\t\t\tthrow new RuntimeException(\"Value is empty for column : '";
  protected final String TEXT_788 = "' in '";
  protected final String TEXT_789 = "' connection, value is invalid or this column should be nullable or have a default value.\");";
  protected final String TEXT_790 = NL + "\t\t\t\t";
  protected final String TEXT_791 = ".";
  protected final String TEXT_792 = " = ";
  protected final String TEXT_793 = ";" + NL + "\t\t\t\temptyColumnCount_";
  protected final String TEXT_794 = "++;";
  protected final String TEXT_795 = NL + "\t\t\t}";
  protected final String TEXT_796 = NL;
  protected final String TEXT_797 = " ";
  protected final String TEXT_798 = " = null; ";
  protected final String TEXT_799 = NL;
  protected final String TEXT_800 = NL + "        if(emptyColumnCount_";
  protected final String TEXT_801 = " == ";
  protected final String TEXT_802 = "){" + NL + "        \tbreak; //if meet the empty row, there will break the iterate." + NL + "        }";
  protected final String TEXT_803 = NL + "\t\t} catch(java.lang.Exception e) {" + NL + "\t\t\twhetherReject_";
  protected final String TEXT_804 = " = true;";
  protected final String TEXT_805 = NL + "\t            throw(e);";
  protected final String TEXT_806 = NL + "\t\t\t\t\t";
  protected final String TEXT_807 = " = new ";
  protected final String TEXT_808 = "Struct();";
  protected final String TEXT_809 = NL + "\t\t\t\t\t";
  protected final String TEXT_810 = ".";
  protected final String TEXT_811 = " = ";
  protected final String TEXT_812 = ".";
  protected final String TEXT_813 = ";";
  protected final String TEXT_814 = NL + "\t\t\t\t\t";
  protected final String TEXT_815 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_816 = "+ \" column: \" + curColName_";
  protected final String TEXT_817 = " + \" (No. \" + curColNum_";
  protected final String TEXT_818 = " + \")\";" + NL + "\t\t\t\t\t";
  protected final String TEXT_819 = " = null;";
  protected final String TEXT_820 = NL + "\t\t\t\t\t System.err.println(e.getMessage());" + NL + "\t\t\t\t\t ";
  protected final String TEXT_821 = " = null;";
  protected final String TEXT_822 = NL + "\t\t\t\t\t";
  protected final String TEXT_823 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_824 = "+ \" column: \" + curColName_";
  protected final String TEXT_825 = " + \" (No. \" + curColNum_";
  protected final String TEXT_826 = " + \")\";";
  protected final String TEXT_827 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_828 = NL + "        \t\t";
  protected final String TEXT_829 = "if(!whetherReject_";
  protected final String TEXT_830 = ") { ";
  protected final String TEXT_831 = "      " + NL + "                     if(";
  protected final String TEXT_832 = " == null){ " + NL + "                    \t ";
  protected final String TEXT_833 = " = new ";
  protected final String TEXT_834 = "Struct();" + NL + "                     }\t\t\t\t";
  protected final String TEXT_835 = NL + "        \t    \t ";
  protected final String TEXT_836 = ".";
  protected final String TEXT_837 = " = ";
  protected final String TEXT_838 = ".";
  protected final String TEXT_839 = ";    \t\t\t\t";
  protected final String TEXT_840 = NL + "        \t\t";
  protected final String TEXT_841 = " } ";
  protected final String TEXT_842 = "\t";
  protected final String TEXT_843 = NL;
  protected final String TEXT_844 = NL;
  protected final String TEXT_845 = NL;
  protected final String TEXT_846 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
	IMetadataTable metadata = metadatas.get(0);
	if (metadata!=null) {
		boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
	
		String fileName = ElementParameterParser.getValue(node,"__FILENAME__");
	
    	String header = ElementParameterParser.getValue(node, "__HEADER__");
    	String limit = ElementParameterParser.getValue(node, "__LIMIT__");
    	String footer = ElementParameterParser.getValue(node, "__FOOTER__");
    	String firstColumn = ElementParameterParser.getValue(node, "__FIRST_COLUMN__");
    	String lastColumn = ElementParameterParser.getValue(node, "__LAST_COLUMN__");
    	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
		boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;
		String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
		
		String allSheets = ElementParameterParser.getValue(node, "__ALL_SHEETS__");
		boolean isAllSheets = (allSheets!=null&&!("").equals(allSheets))?("true").equals(allSheets):false;
		List<Map<String, String>> sheetNameList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__SHEETLIST__");
		
		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);
		
		boolean affect = ("true").equals(ElementParameterParser.getValue(node,"__AFFECT_EACH_SHEET__"));
		boolean stopOnEmptyRow = ("true").equals(ElementParameterParser.getValue(node,"__STOPREAD_ON_EMPTYROW__"));
		
		List<Map<String, String>> trimSelects = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIMSELECT__");
		String isTrimAllStr = ElementParameterParser.getValue(node,"__TRIMALL__");
		boolean isTrimAll = (isTrimAllStr!=null&&!("").equals(isTrimAllStr))?("true").equals(isTrimAllStr):true;
		
		String mode = ElementParameterParser.getValue(node,"__GENERATION_MODE__");
		boolean eventMode = "EVENT_MODE".equals(mode);
		
		if(!version07){//version judgement
			boolean bReadRealValue = ("true").equals(ElementParameterParser.getValue(node, "__READ_REAL_VALUE__"));
			boolean notNeedValidateOnCell = !("false").equals(ElementParameterParser.getValue(node,"__NOVALIDATE_ON_CELL__"));//make wizard work
			boolean suppressWarn = !("false").equals(ElementParameterParser.getValue(node,"__SUPPRESS_WARN__"));//make wizard work

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_8);
    
		if(notNeedValidateOnCell==true){

    stringBuffer.append(TEXT_9);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_10);
    
		}
		if(suppressWarn ==true){

    stringBuffer.append(TEXT_11);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_12);
    
		}

    stringBuffer.append(TEXT_13);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
          
		if(isAllSheets){

    stringBuffer.append(TEXT_35);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_37);
    
		}else{

    stringBuffer.append(TEXT_38);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_39);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_40);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_45);
    
			}
		}

    stringBuffer.append(TEXT_46);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_58);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_59);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_60);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_61);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_62);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_63);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_71);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_72);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_73);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_74);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_75);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_76);
    }
    stringBuffer.append(TEXT_77);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_79);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    }
    stringBuffer.append(TEXT_86);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_91);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_115);
    
	if(!affect){

    stringBuffer.append(TEXT_116);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_120);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_122);
    
	}else{

    stringBuffer.append(TEXT_123);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_125);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_136);
    
    }

    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    
//begin
//
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

    	if (conns!=null) {
    		if (conns.size()>0) {
    			for (int i=0;i<conns.size();i++) {
    				IConnection connTemp = conns.get(i);
    				if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_140);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_141);
    
    				}
    			}
    		}
    	}
    	
		String firstConnName = "";
		if (conns!=null) {
			if (conns.size()>0) {
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
//
//end
    stringBuffer.append(TEXT_142);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_144);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_150);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_151);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_155);
    
                    if(bReadRealValue){

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
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    
                    }else{

    stringBuffer.append(TEXT_168);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    
                    }

    stringBuffer.append(TEXT_171);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    
//start
//
					for (int i=0; i<size; i++) {
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
//
//end
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_179);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_180);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_183);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_186);
    
//start
//

						if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {
//
//end
    stringBuffer.append(TEXT_187);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_191);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_192);
    		
//start
			} else if(javaType == JavaTypesManager.DATE) {
//
//end
    stringBuffer.append(TEXT_193);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_194);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_198);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_204);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_206);
    
//start			
			}else if(advancedSeparator && JavaTypesManager.isNumberType(javaType)) { 

    stringBuffer.append(TEXT_207);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_209);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_212);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_213);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_214);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_215);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 
	
    stringBuffer.append(TEXT_216);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_220);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_222);
    
			} else {
//
//end
    stringBuffer.append(TEXT_223);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_225);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_228);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_229);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_230);
    
//start
//
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {
//
//end
    stringBuffer.append(TEXT_231);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_233);
    
//start
//
						} else {
//
//end
    stringBuffer.append(TEXT_234);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_237);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_238);
    
//start
//
						}
//
//end
    stringBuffer.append(TEXT_239);
    
//start
//
					}
    stringBuffer.append(TEXT_240);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_241);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_242);
    }
    stringBuffer.append(TEXT_243);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_244);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_246);
    
	}

    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    
        if (dieOnError) {
            
    stringBuffer.append(TEXT_249);
    
        } else {
            if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {

                
    stringBuffer.append(TEXT_250);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_252);
    
                for(IMetadataColumn column : metadata.getListColumns()) {
                    
    stringBuffer.append(TEXT_253);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_255);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_257);
    
                }
                
    stringBuffer.append(TEXT_258);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_262);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_264);
    
            } else if(("").equals(rejectConnName)){
                
    stringBuffer.append(TEXT_265);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_267);
    
            } else if(rejectConnName.equals(firstConnName)){
    stringBuffer.append(TEXT_268);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    }
        } 
        
    stringBuffer.append(TEXT_273);
    
				}
			}
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_274);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_277);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_280);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_281);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_285);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_286);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_287);
     } 
    stringBuffer.append(TEXT_288);
    
		}
		}

    	
		} else if(!eventMode) {//version judgement /***excel 2007 xlsx and usermodel mode*****/

    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    
		if(isAllSheets){

    stringBuffer.append(TEXT_306);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_311);
    
		}else{

    stringBuffer.append(TEXT_312);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_313);
    
			for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_314);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_317);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_318);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_319);
    
			}
		}

    stringBuffer.append(TEXT_320);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_331);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_332);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_333);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_334);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_335);
    }else{
    stringBuffer.append( header );
    }
    stringBuffer.append(TEXT_336);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_337);
    if(("").equals(footer.trim())){
    stringBuffer.append(TEXT_338);
    }else{
    stringBuffer.append(footer);
    }
    stringBuffer.append(TEXT_339);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_341);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_342);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_344);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_345);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_347);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_348);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_349);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_350);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_351);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_352);
    }
    stringBuffer.append(TEXT_353);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_354);
    if(lastColumn!=null && !("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_357);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_358);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    }
    stringBuffer.append(TEXT_361);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_363);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_364);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_372);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_373);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_374);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_375);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_378);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_379);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_382);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_383);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_384);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_385);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_386);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_387);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_388);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_389);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_392);
    
	if(!affect){

    stringBuffer.append(TEXT_393);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_394);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_395);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_396);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_397);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_398);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_399);
    
	}else{

    stringBuffer.append(TEXT_400);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_401);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_402);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_403);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_404);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_405);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_406);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_407);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_408);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_409);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_410);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_411);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_412);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_413);
    
    }

    stringBuffer.append(TEXT_414);
    
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
		if (conns!=null) {
			if (conns.size()>0) {
		    	for (int i=0;i<conns.size();i++) {
		    		IConnection connTemp = conns.get(i);
		    		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_415);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_416);
    
		    		}
		    	}
		    }
		}
		List<Map<String, String>> dateSelect = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__DATESELECT__");
		boolean converDatetoString = ("true").equals(ElementParameterParser.getValue(node, "__CONVERTDATETOSTRING__"));
		String firstConnName = "";
		if (conns!=null) {//3	 
			if (conns.size()>0) {//4
				IConnection conn = conns.get(0);
				firstConnName = conn.getName();
				List<IMetadataColumn> listColumns = metadata.getListColumns();
				int size = listColumns.size();
				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//5

    stringBuffer.append(TEXT_417);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_418);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_419);
    
			if(converDatetoString){

    stringBuffer.append(TEXT_420);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_421);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_422);
    	
				for(IMetadataColumn column:listColumns){
					for(Map<String, String> line:dateSelect){// search in the date table
						String columnName = line.get("SCHEMA_COLUMN");				
						if(column.getLabel().equals(columnName)){

    stringBuffer.append(TEXT_423);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_424);
    stringBuffer.append(line.get("CONVERTDATE"));
    stringBuffer.append(TEXT_425);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_426);
    stringBuffer.append(line.get("PATTERN"));
    stringBuffer.append(TEXT_427);
    
						}
					}
				}	
			}

    stringBuffer.append(TEXT_428);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_429);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_430);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_431);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_432);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_433);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_434);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_435);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_436);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_437);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_438);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_439);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_440);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_441);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_442);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_443);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_444);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_445);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_446);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_447);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_448);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_449);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_450);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_451);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_452);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_453);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_454);
    
								if(converDatetoString){

    stringBuffer.append(TEXT_455);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_456);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_457);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_458);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_459);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_460);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_461);
    
								}else{

    stringBuffer.append(TEXT_462);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_463);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_464);
    
								}

    stringBuffer.append(TEXT_465);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_466);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_467);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_468);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_469);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_470);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_471);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_472);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_473);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_474);
    
										if(converDatetoString){

    stringBuffer.append(TEXT_475);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_476);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_477);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_478);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_479);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_480);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_481);
    
										}else{

    stringBuffer.append(TEXT_482);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_483);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_484);
    
										}

    stringBuffer.append(TEXT_485);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_486);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_487);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_488);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_489);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_490);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_491);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_492);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_493);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_494);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_495);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_496);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_497);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_498);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_499);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_500);
    
					for (int i=0; i<size; i++) {//5
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_501);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_502);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_503);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_504);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_505);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_506);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_507);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_508);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_509);
    		
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_510);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_511);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_512);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_513);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_514);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_515);
    		
						} else if(javaType == JavaTypesManager.DATE) {						

    stringBuffer.append(TEXT_516);
    stringBuffer.append( i);
    stringBuffer.append(TEXT_517);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_518);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_519);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_520);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_521);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_522);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_523);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_524);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_525);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_526);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_527);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_528);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_529);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_530);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_531);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_532);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_533);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_534);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_535);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_536);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_537);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_538);
    stringBuffer.append(TEXT_539);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_540);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_541);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_542);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_543);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_544);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_545);
    		
						}else if(JavaTypesManager.isNumberType(javaType)) { 
							if(advancedSeparator) {

    stringBuffer.append(TEXT_546);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_547);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_548);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_549);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_550);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_551);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_552);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_553);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_554);
    
							} else {

    stringBuffer.append(TEXT_555);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_556);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_557);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_558);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_559);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_560);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_561);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_562);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_563);
    
							}
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 

    stringBuffer.append(TEXT_564);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_565);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_566);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_567);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_568);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_569);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_570);
    
						} else {

    stringBuffer.append(TEXT_571);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_572);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_573);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_574);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_575);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_576);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_577);
    
						}

    stringBuffer.append(TEXT_578);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_579);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_580);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_581);
    
						} else {

    stringBuffer.append(TEXT_582);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_583);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_584);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_585);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_586);
    
						}

    stringBuffer.append(TEXT_587);
    
					}

    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_588);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_589);
    }
    stringBuffer.append(TEXT_590);
    
	if(stopOnEmptyRow){

    stringBuffer.append(TEXT_591);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_592);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_593);
    
	}

    stringBuffer.append(TEXT_594);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_595);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_596);
    
		        }
		        else{
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_597);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_598);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_599);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_600);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_601);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_602);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_603);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_604);
    
					    }//16

    stringBuffer.append(TEXT_605);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_606);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_607);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_608);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_609);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_610);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_611);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_612);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_613);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_614);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_615);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_616);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_617);
    
					}//15
				}

    stringBuffer.append(TEXT_618);
    
				}
			}
		if (conns.size()>0) {	
			boolean isFirstEnter = true;
			for (int i=0;i<conns.size();i++) {
				IConnection conn = conns.get(i);
				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_619);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_620);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_621);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_622);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_623);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_624);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_625);
    
			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_626);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_627);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_628);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_629);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_630);
    
				 	}
				}
			}

    stringBuffer.append(TEXT_631);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_632);
     } 
    stringBuffer.append(TEXT_633);
    
		}
		}

    
		} else {//version judgement /***excel 2007 xlsx and event mode*****/

    stringBuffer.append(TEXT_634);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_635);
    stringBuffer.append(fileName);
    stringBuffer.append(TEXT_636);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_637);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_638);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_639);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_640);
    
			if(isAllSheets){

    stringBuffer.append(TEXT_641);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_642);
    
			} else {
				for(Map<String, String> tmp:sheetNameList){

    stringBuffer.append(TEXT_643);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_644);
    stringBuffer.append(tmp.get("SHEETNAME"));
    stringBuffer.append(TEXT_645);
    stringBuffer.append((tmp.get("USE_REGEX")!=null&&!"".equals(tmp.get("USE_REGEX")))?"true".equals(tmp.get("USE_REGEX")):false);
    stringBuffer.append(TEXT_646);
    
				}
			}

    stringBuffer.append(TEXT_647);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_648);
    if(("").equals(firstColumn.trim())){
    stringBuffer.append(TEXT_649);
    }else{
    stringBuffer.append(firstColumn);
    stringBuffer.append(TEXT_650);
    }
    stringBuffer.append(TEXT_651);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_652);
    if(("").equals(lastColumn.trim())){
    stringBuffer.append(TEXT_653);
    }else{
    stringBuffer.append(lastColumn);
    stringBuffer.append(TEXT_654);
    }
    stringBuffer.append(TEXT_655);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_656);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_657);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_658);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_659);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_660);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_661);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_662);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_663);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_664);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_665);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_666);
    if(("").equals(header.trim())){
    stringBuffer.append(TEXT_667);
    }else{
    stringBuffer.append(header);
    }
    stringBuffer.append(TEXT_668);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_669);
    if(("").equals(limit.trim())){
    stringBuffer.append(TEXT_670);
    }else{
    stringBuffer.append(limit);
    }
    stringBuffer.append(TEXT_671);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_672);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_673);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_674);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_675);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_676);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_677);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_678);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_679);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_680);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_681);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_682);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_683);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_684);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_685);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_686);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_687);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_688);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_689);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_690);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_691);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_692);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_693);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_694);
    
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
    		
    		if (conns!=null) {
    			if (conns.size()>0) {
    		    	for (int i=0;i<conns.size();i++) {
    		    		IConnection connTemp = conns.get(i);
    		    		if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_695);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_696);
    
    		    		}
    		    	}
    		    }
			}
			
			String firstConnName = "";
			if (conns!=null) {//TD1024
				if (conns.size()>0) {//TD528
					IConnection conn = conns.get(0);
    				firstConnName = conn.getName();
    				List<IMetadataColumn> listColumns = metadata.getListColumns();
    				int size = listColumns.size();
    				if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//TD256

    stringBuffer.append(TEXT_697);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_698);
    stringBuffer.append(listColumns.size());
    stringBuffer.append(TEXT_699);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_700);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_701);
    stringBuffer.append(size);
    stringBuffer.append(TEXT_702);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_703);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_704);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_705);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_706);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_707);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_708);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_709);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_710);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_711);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_712);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_713);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_714);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_715);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_716);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_717);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_718);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_719);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_720);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_721);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_722);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_723);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_724);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_725);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_726);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_727);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_728);
    
                		for (int i=0; i<size; i++) {//TD128
						IMetadataColumn column = listColumns.get(i);
						String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_729);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_730);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_731);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_732);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_733);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_734);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_735);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_736);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_737);
    		
						if (javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_738);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_739);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_740);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_741);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_742);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_743);
    		
						} else if(javaType == JavaTypesManager.DATE) {						

    stringBuffer.append(TEXT_744);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_745);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_746);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_747);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_748);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_749);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_750);
     // for bug TDI-19404 
    stringBuffer.append(TEXT_751);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_752);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_753);
    		
						}else if(JavaTypesManager.isNumberType(javaType)) { 
							if(advancedSeparator) {

    stringBuffer.append(TEXT_754);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_755);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_756);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_757);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_758);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_759);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_760);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_761);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_762);
    
							} else {

    stringBuffer.append(TEXT_763);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_764);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_765);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_766);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_767);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_768);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_769);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_770);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_771);
    
							}
						} else if(javaType == JavaTypesManager.BYTE_ARRAY) { 

    stringBuffer.append(TEXT_772);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_773);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_774);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_775);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_776);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_777);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_778);
    
						} else {

    stringBuffer.append(TEXT_779);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_780);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_781);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_782);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_783);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_784);
    stringBuffer.append((isTrimAll || (!trimSelects.isEmpty() && ("true").equals(trimSelects.get(i).get("TRIM"))))?".trim()":"" );
    stringBuffer.append(TEXT_785);
    
						}

    stringBuffer.append(TEXT_786);
    
						String defaultValue = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate, column.getDefault());
						if(defaultValue == null) {

    stringBuffer.append(TEXT_787);
    stringBuffer.append( column.getLabel() );
    stringBuffer.append(TEXT_788);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_789);
    
						} else {

    stringBuffer.append(TEXT_790);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_791);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_792);
    stringBuffer.append(defaultValue);
    stringBuffer.append(TEXT_793);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_794);
    
						}

    stringBuffer.append(TEXT_795);
    
					}//TD128

    stringBuffer.append(TEXT_796);
    if(rejectConnName.equals(firstConnName)) {
    stringBuffer.append(TEXT_797);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_798);
    }
    stringBuffer.append(TEXT_799);
    
	if(stopOnEmptyRow && false){

    stringBuffer.append(TEXT_800);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_801);
    stringBuffer.append(size );
    stringBuffer.append(TEXT_802);
    
	}

    stringBuffer.append(TEXT_803);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_804);
    
		        if (dieOnError) {

    stringBuffer.append(TEXT_805);
    
		        }
		        else{
					if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {//15

    stringBuffer.append(TEXT_806);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_807);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_808);
    
						for(IMetadataColumn column : metadata.getListColumns()) {//16

    stringBuffer.append(TEXT_809);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_810);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_811);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_812);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_813);
    
					    }//16

    stringBuffer.append(TEXT_814);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_815);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_816);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_817);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_818);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_819);
    
					} else if(("").equals(rejectConnName)){

    stringBuffer.append(TEXT_820);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_821);
    
					} else if(rejectConnName.equals(firstConnName)){

    stringBuffer.append(TEXT_822);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_823);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_824);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_825);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_826);
    
					}//15
				}

    stringBuffer.append(TEXT_827);
    
    				}//TD256
				}//TD528
				
        		if (conns.size()>0) {//TD64
        			boolean isFirstEnter = true;
        			for (int i=0;i<conns.size();i++) {
        				IConnection conn = conns.get(i);
        				if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

    stringBuffer.append(TEXT_828);
     if(isFirstEnter) {
    stringBuffer.append(TEXT_829);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_830);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_831);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_832);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_833);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_834);
    
        			    	 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_835);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_836);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_837);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_838);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_839);
    
        				 	}
        				}
        			}

    stringBuffer.append(TEXT_840);
     if(!isFirstEnter) {
    stringBuffer.append(TEXT_841);
     } 
    stringBuffer.append(TEXT_842);
    
        		}//TD64

			}//TD1024

    stringBuffer.append(TEXT_843);
    
		}//end version judgement

    stringBuffer.append(TEXT_844);
    
	}
}
//
//end
    stringBuffer.append(TEXT_845);
    stringBuffer.append(TEXT_846);
    return stringBuffer.toString();
  }
}
