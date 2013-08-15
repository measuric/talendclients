package org.talend.designer.codegen.translators.databases.paraccel;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import java.util.Map;
import java.util.List;

public class TParAccelInputBeginJava
{
  protected static String nl;
  public static synchronized TParAccelInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TParAccelInputBeginJava result = new TParAccelInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "            java.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_3 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "            if (null != dataSources_";
  protected final String TEXT_4 = ") {";
  protected final String TEXT_5 = NL + "                conn_";
  protected final String TEXT_6 = " = dataSources_";
  protected final String TEXT_7 = ".get(";
  protected final String TEXT_8 = ").getConnection();" + NL + "            } else {" + NL + "\t\t\t    java.lang.Class.forName(\"";
  protected final String TEXT_9 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t        String dbUser_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ";" + NL + "\t\t        String dbPwd_";
  protected final String TEXT_13 = " = ";
  protected final String TEXT_14 = ";" + NL + "\t\t        conn_";
  protected final String TEXT_15 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_16 = ",dbUser_";
  protected final String TEXT_17 = ",dbPwd_";
  protected final String TEXT_18 = ");" + NL + "\t\t        ";
  protected final String TEXT_19 = NL + "\t\t    }";
  protected final String TEXT_20 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_21 = " = conn_";
  protected final String TEXT_22 = ".createStatement();";
  protected final String TEXT_23 = NL + "\t\t\tjava.sql.Statement stmt_";
  protected final String TEXT_24 = " = conn_";
  protected final String TEXT_25 = ".createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY," + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tjava.sql.ResultSet.CONCUR_READ_ONLY);" + NL + "\t\t\t";
  protected final String TEXT_26 = NL + "\t\t\t\t\ttmpContent_";
  protected final String TEXT_27 = " = rs_";
  protected final String TEXT_28 = ".getString(column_index_";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "                        if(tmpContent_";
  protected final String TEXT_31 = " != null) {" + NL + "                            tmpContent_";
  protected final String TEXT_32 = " = tmpContent_";
  protected final String TEXT_33 = ";" + NL + "                        }";
  protected final String TEXT_34 = NL + "                    if(tmpContent_";
  protected final String TEXT_35 = " != null && tmpContent_";
  protected final String TEXT_36 = ".length() > 0) {\t\t\t  \t";
  protected final String TEXT_37 = NL + "                        ";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = " = tmpContent_";
  protected final String TEXT_40 = ".charAt(0);\t\t\t  \t\t" + NL + "                    } else {\t\t\t  \t";
  protected final String TEXT_41 = "\t\t\t  \t    " + NL + "                            if(tmpContent_";
  protected final String TEXT_42 = " == null) {\t\t\t  \t   \t";
  protected final String TEXT_43 = NL + "                                ";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = " = null;\t\t\t  \t\t\t" + NL + "                            } else {\t\t\t  \t\t";
  protected final String TEXT_46 = NL + "                                ";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            }";
  protected final String TEXT_49 = "\t\t\t  \t\t" + NL + "                            if((\"\").equals(tmpContent_";
  protected final String TEXT_50 = ")) {\t\t\t  \t\t";
  protected final String TEXT_51 = NL + "                                ";
  protected final String TEXT_52 = ".";
  protected final String TEXT_53 = " = '\\0';\t\t\t  \t\t\t" + NL + "                            } else {\t\t\t  \t\t" + NL + "        \t\t\t  \t\t\tthrow new RuntimeException(" + NL + "        \t\t\t\t\t\t\t\"Value is empty for column : '";
  protected final String TEXT_54 = "' in '";
  protected final String TEXT_55 = "' connection, value is invalid or this column should be nullable or have a default value.\");\t\t\t\t\t\t\t" + NL + "                            }\t\t\t  \t\t";
  protected final String TEXT_56 = NL + "                    }";
  protected final String TEXT_57 = NL + "\t\t\tif(rs_";
  protected final String TEXT_58 = ".getTimestamp(column_index_";
  protected final String TEXT_59 = ") != null) {" + NL + "\t\t\t    ";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = " = new java.util.Date(rs_";
  protected final String TEXT_62 = ".getTimestamp(column_index_";
  protected final String TEXT_63 = ").getTime());" + NL + "\t\t\t} else {" + NL + "\t\t\t    ";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = " =  null;" + NL + "\t\t\t}\t\t\t ";
  protected final String TEXT_66 = NL + "            tmpContent_";
  protected final String TEXT_67 = " = rs_";
  protected final String TEXT_68 = ".getString(column_index_";
  protected final String TEXT_69 = ");" + NL + "            if(tmpContent_";
  protected final String TEXT_70 = " != null) {";
  protected final String TEXT_71 = NL + "                ";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = " = tmpContent_";
  protected final String TEXT_74 = ";" + NL + "            } else {";
  protected final String TEXT_75 = NL + "                ";
  protected final String TEXT_76 = ".";
  protected final String TEXT_77 = " = null;" + NL + "            }";
  protected final String TEXT_78 = NL + "            if(rs_";
  protected final String TEXT_79 = ".getObject(column_index_";
  protected final String TEXT_80 = ") != null) {";
  protected final String TEXT_81 = NL + "                ";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = " = rs_";
  protected final String TEXT_84 = ".get";
  protected final String TEXT_85 = "(column_index_";
  protected final String TEXT_86 = ");" + NL + "            } else {";
  protected final String TEXT_87 = NL + "                    ";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = " = null;";
  protected final String TEXT_90 = "    " + NL + "                    throw new RuntimeException(\"Null value in non-Nullable column\");";
  protected final String TEXT_91 = NL + "            }";
  protected final String TEXT_92 = NL + "\t\t\tif (";
  protected final String TEXT_93 = " > 0) {" + NL + "\t\t\t\t\tjava.io.Writer output_";
  protected final String TEXT_94 = " = new java.io.FileWriter(";
  protected final String TEXT_95 = ", true);" + NL + "\t\t\t\t\tjava.sql.DriverManager.setLogWriter(new java.io.PrintWriter(output_";
  protected final String TEXT_96 = ",true));" + NL + "\t\t\t\t}\t\t\t\t" + NL + "\t\t\tcom.paraccel.Driver.setLogLevel(";
  protected final String TEXT_97 = ");" + NL + "" + NL + "\t\t\tString url_";
  protected final String TEXT_98 = " = \"jdbc:paraccel://\" + ";
  protected final String TEXT_99 = " + \":\" + ";
  protected final String TEXT_100 = " + \"/\" + ";
  protected final String TEXT_101 = " +\"?prepareThreshold=100&loglevel=\"+";
  protected final String TEXT_102 = "+\"&protocolVersion=3\";";
  protected final String TEXT_103 = NL + "\t\t\t\tconn_";
  protected final String TEXT_104 = ".setAutoCommit(false);";
  protected final String TEXT_105 = NL + "                stmt_";
  protected final String TEXT_106 = ".setFetchSize(";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL + "    " + NL + "\t";
  protected final String TEXT_109 = NL + "\t\t    int nb_line_";
  protected final String TEXT_110 = " = 0;" + NL + "\t\t    java.sql.Connection conn_";
  protected final String TEXT_111 = " = null;";
  protected final String TEXT_112 = NL + "\t\t        conn_";
  protected final String TEXT_113 = " = (java.sql.Connection)globalMap.get(\"";
  protected final String TEXT_114 = "\");" + NL + "\t\t        if (null == conn_";
  protected final String TEXT_115 = ") {";
  protected final String TEXT_116 = NL + "\t\t\t\t\tjava.util.Map<String, routines.system.TalendDataSource> dataSources_";
  protected final String TEXT_117 = " = (java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\t\t\t\tconn_";
  protected final String TEXT_118 = " = dataSources_";
  protected final String TEXT_119 = ".get(";
  protected final String TEXT_120 = ").getConnection();" + NL + "\t\t\t\t\t//globalMap.put(\"";
  protected final String TEXT_121 = "\", conn_";
  protected final String TEXT_122 = ");" + NL + "\t\t        }";
  protected final String TEXT_123 = NL + NL + "\t\t    ";
  protected final String TEXT_124 = NL + "\t\t    " + NL + "\t\t    String dbquery_";
  protected final String TEXT_125 = " = ";
  protected final String TEXT_126 = ";" + NL + "\t\t    " + NL + "\t\t    globalMap.put(\"";
  protected final String TEXT_127 = "_QUERY\",dbquery_";
  protected final String TEXT_128 = ");" + NL + "\t\t    " + NL + "\t\t    java.sql.ResultSet rs_";
  protected final String TEXT_129 = " = stmt_";
  protected final String TEXT_130 = ".executeQuery(dbquery_";
  protected final String TEXT_131 = ");" + NL + "\t\t    java.sql.ResultSetMetaData rsmd_";
  protected final String TEXT_132 = " = rs_";
  protected final String TEXT_133 = ".getMetaData();" + NL + "\t\t    int colQtyInRs_";
  protected final String TEXT_134 = " = rsmd_";
  protected final String TEXT_135 = ".getColumnCount();" + NL;
  protected final String TEXT_136 = NL + "\t\t    routines.system.Dynamic dcg_";
  protected final String TEXT_137 = " =  new routines.system.Dynamic();" + NL + "\t\t    dcg_";
  protected final String TEXT_138 = ".setDbmsId(\"";
  protected final String TEXT_139 = "\");" + NL + "\t\t    List<String> listSchema_";
  protected final String TEXT_140 = "=new java.util.ArrayList<String>();" + NL + "\t\t    ";
  protected final String TEXT_141 = NL + "\t\t    \t    listSchema_";
  protected final String TEXT_142 = ".add(\"";
  protected final String TEXT_143 = "\");" + NL + "\t    \t    ";
  protected final String TEXT_144 = NL + "\t\t\t" + NL + "\t\t\tint fixedColumnCount_";
  protected final String TEXT_145 = " = ";
  protected final String TEXT_146 = ";" + NL + "\t\t\t" + NL + "            for (int i = ";
  protected final String TEXT_147 = "; i <= rsmd_";
  protected final String TEXT_148 = ".getColumnCount()-";
  protected final String TEXT_149 = "; i++) {" + NL + "                if (!(listSchema_";
  protected final String TEXT_150 = ".contains(rsmd_";
  protected final String TEXT_151 = ".getColumnName(i).toUpperCase()) )) {" + NL + "                \troutines.system.DynamicMetadata dcm_";
  protected final String TEXT_152 = "=new routines.system.DynamicMetadata();" + NL + "                \tdcm_";
  protected final String TEXT_153 = ".setName(rsmd_";
  protected final String TEXT_154 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_155 = ".setDbName(rsmd_";
  protected final String TEXT_156 = ".getColumnName(i));" + NL + "                \tdcm_";
  protected final String TEXT_157 = ".setType(routines.system.Dynamic.getTalendTypeFromDBType(\"";
  protected final String TEXT_158 = "\", rsmd_";
  protected final String TEXT_159 = ".getColumnTypeName(i).toUpperCase(), rsmd_";
  protected final String TEXT_160 = ".getPrecision(i), rsmd_";
  protected final String TEXT_161 = ".getScale(i)));" + NL + "                \tdcm_";
  protected final String TEXT_162 = ".setDbType(rsmd_";
  protected final String TEXT_163 = ".getColumnTypeName(i));";
  protected final String TEXT_164 = NL + "                \tdcm_";
  protected final String TEXT_165 = ".setFormat(";
  protected final String TEXT_166 = ");";
  protected final String TEXT_167 = NL + "\t\t\tif(\"LONG\".equals(rsmd_";
  protected final String TEXT_168 = ".getColumnTypeName(i).toUpperCase())) {" + NL + "\t\t\t\tString length = MetadataTalendType.getDefaultDBTypes(\"oracle_id\", \"LONG\", MetadataTalendType.DEFAULT_LENGTH);" + NL + "\t\t\t\tif(length!=null && !(\"\".equals(length))) {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_169 = ".setLength(Integer.parseInt(length));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tdcm_";
  protected final String TEXT_170 = ".setLength(rsmd_";
  protected final String TEXT_171 = ".getPrecision(i));" + NL + "\t\t\t\t}" + NL + "\t\t\t} else {" + NL + "\t\t\t\tdcm_";
  protected final String TEXT_172 = ".setLength(rsmd_";
  protected final String TEXT_173 = ".getPrecision(i));" + NL + "\t\t\t}";
  protected final String TEXT_174 = NL + "\t\t\tdcm_";
  protected final String TEXT_175 = ".setLength(rsmd_";
  protected final String TEXT_176 = ".getPrecision(i));";
  protected final String TEXT_177 = NL + "                \tdcm_";
  protected final String TEXT_178 = ".setPrecision(rsmd_";
  protected final String TEXT_179 = ".getScale(i));" + NL + "                \tdcm_";
  protected final String TEXT_180 = ".setNullable(rsmd_";
  protected final String TEXT_181 = ".isNullable(i) == 0 ? false : true);" + NL + "                \tdcm_";
  protected final String TEXT_182 = ".setKey(false);" + NL + "                \tdcm_";
  protected final String TEXT_183 = ".setSourceType(DynamicMetadata.sourceTypes.database);" + NL + "                \tdcm_";
  protected final String TEXT_184 = ".setColumnPosition(i);" + NL + "                \tdcg_";
  protected final String TEXT_185 = ".metadatas.add(dcm_";
  protected final String TEXT_186 = ");" + NL + "                }" + NL + "            }";
  protected final String TEXT_187 = NL + "\t\t    String tmpContent_";
  protected final String TEXT_188 = " = null;" + NL + "\t\t    int column_index_";
  protected final String TEXT_189 = " =1;" + NL + "\t\t    while (rs_";
  protected final String TEXT_190 = ".next()) {" + NL + "\t\t        nb_line_";
  protected final String TEXT_191 = "++;" + NL + "\t\t        ";
  protected final String TEXT_192 = NL + "\t\t                        column_index_";
  protected final String TEXT_193 = " = ";
  protected final String TEXT_194 = " + dcg_";
  protected final String TEXT_195 = ".getColumnCount(); " + NL + "\t\t                    ";
  protected final String TEXT_196 = NL + "\t\t                        column_index_";
  protected final String TEXT_197 = " = ";
  protected final String TEXT_198 = ";" + NL + "\t\t                    ";
  protected final String TEXT_199 = NL + "\t\t                    if(colQtyInRs_";
  protected final String TEXT_200 = " < column_index_";
  protected final String TEXT_201 = ") {" + NL + "\t\t                        ";
  protected final String TEXT_202 = ".";
  protected final String TEXT_203 = " = ";
  protected final String TEXT_204 = "; \t\t\t" + NL + "\t\t                    } else {";
  protected final String TEXT_205 = NL + "\t\t                 \t\t\t";
  protected final String TEXT_206 = "\t\t\t";
  protected final String TEXT_207 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_208 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_209 = NL + "\t\t                            ";
  protected final String TEXT_210 = ".";
  protected final String TEXT_211 = " = (List)rs_";
  protected final String TEXT_212 = ".getObject(column_index_";
  protected final String TEXT_213 = ");";
  protected final String TEXT_214 = NL + "\t\t                         ";
  protected final String TEXT_215 = NL + "                                    oracle.spatial.geometry.JGeometry jGeom = oracle.spatial.geometry.JGeometry.load((oracle.sql.STRUCT) rs_";
  protected final String TEXT_216 = ".getObject(column_index_";
  protected final String TEXT_217 = "));" + NL + "                                    oracle.spatial.util.WKT wkt = new oracle.spatial.util.WKT();" + NL + "                                    String wktValue = new String(wkt.fromJGeometry(jGeom));" + NL;
  protected final String TEXT_218 = NL + "                                    ";
  protected final String TEXT_219 = ".";
  protected final String TEXT_220 = " = new Geometry(wktValue);";
  protected final String TEXT_221 = NL + "                                        ";
  protected final String TEXT_222 = ".";
  protected final String TEXT_223 = ".setEPSG(";
  protected final String TEXT_224 = ");";
  protected final String TEXT_225 = NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_226 = NL + "                                  ";
  protected final String TEXT_227 = ".";
  protected final String TEXT_228 = "=dcg_";
  protected final String TEXT_229 = ";";
  protected final String TEXT_230 = NL + "\t\t\t\t\t\t\t\t\t\tList<Object> list_";
  protected final String TEXT_231 = " = new java.util.ArrayList<Object>();" + NL + "\t\t\t\t\t    \t\t\t\tfor(int i_";
  protected final String TEXT_232 = " = ";
  protected final String TEXT_233 = "; i_";
  protected final String TEXT_234 = "  <= rsmd_";
  protected final String TEXT_235 = ".getColumnCount(); i_";
  protected final String TEXT_236 = " ++){" + NL + "\t\t\t\t\t\t \t\t\t\t\tif (\"NTEXT\".equals(rsmd_";
  protected final String TEXT_237 = ".getColumnTypeName(i_";
  protected final String TEXT_238 = " ).toUpperCase())) {" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.ClobImpl clob_";
  protected final String TEXT_239 = " = (net.sourceforge.jtds.jdbc.ClobImpl) rs_";
  protected final String TEXT_240 = ".getClob(i_";
  protected final String TEXT_241 = ");" + NL + "\t\t\t\t\t\t\t\t\t\t\t\tif(clob_";
  protected final String TEXT_242 = "!=null){" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tnet.sourceforge.jtds.jdbc.TalendNTextImpl tNTextImpl_";
  protected final String TEXT_243 = " = new net.sourceforge.jtds.jdbc.TalendNTextImpl(clob_";
  protected final String TEXT_244 = ");" + NL + "\t\t\t\t\t\t\t  \t\t\t\t\t\tlist_";
  protected final String TEXT_245 = ".add(tNTextImpl_";
  protected final String TEXT_246 = ".getValue());" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t\tlist_";
  protected final String TEXT_247 = ".add(null);" + NL + "\t\t\t\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t   \t\t\t\t\t}" + NL + "   \t \t\t\t\t    \t\t\t\t}" + NL + "                                 \t\t routines.system.DynamicUtils.readColumnsFromDatabase_Mssql(";
  protected final String TEXT_248 = ".";
  protected final String TEXT_249 = ", rs_";
  protected final String TEXT_250 = ", fixedColumnCount_";
  protected final String TEXT_251 = ",list_";
  protected final String TEXT_252 = ");";
  protected final String TEXT_253 = NL + "                                \t\t routines.system.DynamicUtils.readColumnsFromDatabase(";
  protected final String TEXT_254 = ".";
  protected final String TEXT_255 = ", rs_";
  protected final String TEXT_256 = ", fixedColumnCount_";
  protected final String TEXT_257 = ");";
  protected final String TEXT_258 = NL + "                                \torg.postgis.Geometry o = org.postgis.PGgeometry.geomFromString(rs_";
  protected final String TEXT_259 = ".getObject(column_index_";
  protected final String TEXT_260 = ").toString());" + NL + "                                \tStringBuffer sb = new StringBuffer();" + NL + "                                \to.outerWKT(sb, false);" + NL + "                                \t";
  protected final String TEXT_261 = ".";
  protected final String TEXT_262 = " = new Geometry(sb.toString());";
  protected final String TEXT_263 = NL + "\t\t                          ";
  protected final String TEXT_264 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_265 = NL + "\t\t                    }";
  protected final String TEXT_266 = NL + "\t\t                            ";
  protected final String TEXT_267 = ".";
  protected final String TEXT_268 = " = ";
  protected final String TEXT_269 = ".";
  protected final String TEXT_270 = ";" + NL + "\t\t                            ";
  protected final String TEXT_271 = NL + NL + NL;
  protected final String TEXT_272 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by connection component
	class DefaultDBInputUtil {
	
		protected String cid ;
		protected String dbproperties ;
		protected String dbhost;
	    protected String dbport;
	    protected String dbname;
	    protected String dbuser;
		protected String dbpwd ;
	    
	    public void beforeComponentProcess(INode node){
	    	cid = node.getUniqueName();
	    }
	    
	    public void afterUseExistConnection(INode node) {
	    }
	    
	    public String getDirverClassName(INode node){
			return "";
		}
	    
	    public void afterUseNewConnection(INode node) {
	    }
	    
	    public void setURL(INode node) {
	    }

		public void createConnection(INode node) {
			cid = node.getUniqueName();
			dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
			dbhost = ElementParameterParser.getValue(node, "__HOST__");
	    	dbport = ElementParameterParser.getValue(node, "__PORT__");
	    	dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	    	dbuser = ElementParameterParser.getValue(node, "__USER__");
	 		dbpwd = ElementParameterParser.getValue(node, "__PASS__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
                String alias = ElementParameterParser.getValue(node, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_8);
    stringBuffer.append(this.getDirverClassName(node) );
    stringBuffer.append(TEXT_9);
    this.setURL(node);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    this.afterUseNewConnection(node);
    stringBuffer.append(TEXT_19);
    
		}
		
		public String getQueryString(INode node) {
			String dbquery= ElementParameterParser.getValue(node, "__QUERY__");
			dbquery = dbquery.replaceAll("\n"," ");
			dbquery = dbquery.replaceAll("\r"," ");
			
			return dbquery;
		}
		
		public void createStatement(INode node) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    
		}
		public void createMinValueStatement(INode node){

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    }
		public String mappingType(String typeToGenerate) {
		
            if(("byte[]").equals(typeToGenerate)) {
                return "Bytes";
            } else if(("java.util.Date").equals(typeToGenerate)) {
                return "Timestamp";
            } else if(("Integer").equals(typeToGenerate)) {
               return "Int";
            } else {
                return typeToGenerate.substring(0,1).toUpperCase()+typeToGenerate.substring(1);
            }
		}
		//-----------according schema type to generate ResultSet
		public void generateStringCharAndCharacterSet(String firstConnName, IMetadataColumn column, int currentColNo,
					String trimMethod, String typeToGenerate, boolean whetherTrimAllCol, boolean whetherTrimCol) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    
                    if(whetherTrimAllCol || whetherTrimCol) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_33);
    
                    }

    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
                        if(("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_48);
    
                        } else {

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_55);
    
                        }

    stringBuffer.append(TEXT_56);
    
		}
		
	    public void generateTimestampResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_65);
    
	    }
	    
	    public void generateStringResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String trimMethod) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(trimMethod);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_77);
    
	    }
	    
	    public void generateBytesResultSet(String firstConnName, IMetadataColumn column, int currentColNo) {
	    }
	    
	    public void generateOthersResultSet(String firstConnName, IMetadataColumn column, int currentColNo, String typeToGenerate) {

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    
                if(column.isNullable()) {
                    
    stringBuffer.append(TEXT_87);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_89);
    
                } else {
                    
    stringBuffer.append(TEXT_90);
        
                }
                
    stringBuffer.append(TEXT_91);
    
	    }
	    //---------end according schema type to generate ResultSet
	    
		public void afterGenertorType(String firstConnName, IMetadataColumn column, int currentColNo) {
	    }
	    
		public void afterComponentProcess(INode node){
	    }
	}//end DefaultDBInputUtil class
	
	DefaultDBInputUtil dbInputBeginUtil = new DefaultDBInputUtil();
	
	

    

	class DBInputBeginUtil extends DefaultDBInputUtil{
	    
		public void setURL(INode node) {
			
			String logLevel= ElementParameterParser.getValue(node, "__LOG_LEVEL__");
			String logFile= ElementParameterParser.getValue(node, "__LOG_FILE__");

    stringBuffer.append(TEXT_92);
    stringBuffer.append( logLevel );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append( logFile );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append( logLevel );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_101);
    stringBuffer.append( logLevel );
    stringBuffer.append(TEXT_102);
    
		}
		
		public String getDirverClassName(INode node){
			return "com.paraccel.Driver";
		}
		
		public void createConnection(INode node) {
			super.createConnection(node);
			String useCursor= ElementParameterParser.getValue(node, "__USE_CURSOR__");
            if(("true").equals(useCursor)) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    
			}
		}
		
		public void createStatement(INode node) {
			super.createStatement(node);
			String useCursor= ElementParameterParser.getValue(node, "__USE_CURSOR__");
			String cursorSize= ElementParameterParser.getValue(node, "__CURSOR_SIZE__");
            if(("true").equals(useCursor)) {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cursorSize );
    stringBuffer.append(TEXT_107);
    
            }
		}
		
		//-----------according schema type to generate ResultSet
	    
	    //---------end according schema type to generate ResultSet
	}//end class
	
	dbInputBeginUtil = new DBInputBeginUtil();

    stringBuffer.append(TEXT_108);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	        
	String type = ElementParameterParser.getValue(node, "__TYPE__");
	String dbhost = ElementParameterParser.getValue(node, "__HOST__");
	String dbport = ElementParameterParser.getValue(node, "__PORT__");
	String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
	String dbproperties = ElementParameterParser.getValue(node, "__PROPERTIES__");
	String dbuser = ElementParameterParser.getValue(node, "__USER__");
	String dbpwd = ElementParameterParser.getValue(node, "__PASS__");
	String dbencoding = ElementParameterParser.getValue(node, "__ENCODING__");
	String enableStream = ElementParameterParser.getValue(node, "__ENABLE_STREAM__");
	String dbms=ElementParameterParser.getValue(node, "__MAPPING__");
	
    boolean whetherTrimAllCol = ("true").equals(ElementParameterParser.getValue(node, "__TRIM_ALL_COLUMN__"));
    List<Map<String, String>> trimColumnList = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__TRIM_COLUMN__");
    
    dbInputBeginUtil.beforeComponentProcess(node);
    int dynamic_index=-1;
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas != null) && (metadatas.size()>0)) {
		IMetadataTable metadata = metadatas.get(0);
		if (metadata != null) {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    
		    String useExistingConn = ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__");
		    if(("true").equals(useExistingConn)) {
		        String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
		        String conn = "conn_" + connection;

    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    
                    INode connectionNode = null;
                    for (INode processNode : node.getProcess().getGeneratingNodes()) {
                        if(connection.equals(processNode.getUniqueName())) {
                            connectionNode = processNode;
                            break;
                        }
                    }
                    String alias = ElementParameterParser.getValue(connectionNode, "__DATASOURCE_ALIAS__");

    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append((null != alias && !("".equals(alias)))?alias:"\"\"");
    stringBuffer.append(TEXT_120);
    stringBuffer.append(conn);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    
				dbInputBeginUtil.afterUseExistConnection(node);
		
		    } else {
				dbInputBeginUtil.createConnection(node);
		    }

    stringBuffer.append(TEXT_123);
    dbInputBeginUtil.createStatement(node);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(dbInputBeginUtil.getQueryString(node));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    
		    List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
		    List<IMetadataColumn> columnList = metadata.getListColumns();
		    boolean isDynamic = metadata.isDynamicSchema();
		    if(isDynamic){
		    	String DynamicDatePattern = "\"dd-MM-yyyy\"";
		    	for(IMetadataColumn column : columnList) {
		    		if("id_Dynamic".equals(column.getTalendType())) {
		    			DynamicDatePattern = column.getPattern();
		    			break;
		    		}
		    	}
		    
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(dbms );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    
		    
		    for(int i=0; i< columnList.size(); i++) {
		        if(columnList.get(i).getTalendType().equals("id_Dynamic")){
		            dynamic_index = i+1;
		        }else{
		            IMetadataColumn column = columnList.get(i);
		            String columName = column.getOriginalDbColumnName();
		            if(columName==null || "".equals(columName)){
		                columName = column.getLabel();
		            }
	            
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(columName.toUpperCase());
    stringBuffer.append(TEXT_143);
    
		    	}
			}
		    
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(dynamic_index-1);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(dynamic_index);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(columnList.size()-dynamic_index);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(dbms );
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
     if((DynamicDatePattern!=null) && (!"".equals(DynamicDatePattern)) && (!"\"\"".equals(DynamicDatePattern))) {
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(DynamicDatePattern);
    stringBuffer.append(TEXT_166);
     } 
    
		if (("oracle_id".equalsIgnoreCase(dbms))) {

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
    
		} else {

    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    
		}

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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    
		    }
		    
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    
		        if(conns != null && conns.size() > 0) {
		            IConnection conn = conns.get(0);
		            String firstConnName = conn.getName();
		            int currentColNo = 1;
		            for(IMetadataColumn column : columnList) {
		                boolean whetherTrimCol = false;
		                if((trimColumnList != null && trimColumnList.size() > 0) && !whetherTrimAllCol) {
		                    for(Map<String, String> trimColumn : trimColumnList) {
		                        if(column.getLabel().equals(trimColumn.get("SCHEMA_COLUMN"))) {
		                            if(("true").equals(trimColumn.get("TRIM"))) {
		                                whetherTrimCol = true;
		                                break;
		                            }
		                        }
		                    }
		                }
		                String trimMethod = "";
		                if(whetherTrimAllCol || whetherTrimCol) {
		                    trimMethod = ".trim()";
		                }
		                String columnType = column.getType();
		                 
		                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
		                String defVal = JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate); 	
		                if(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
		                    if(!("Dynamic").equals(typeToGenerate) && isDynamic && dynamic_index < currentColNo) {
		                    
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(currentColNo-1);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    }else{
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    stringBuffer.append(currentColNo);
    stringBuffer.append(TEXT_198);
    }
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_203);
    stringBuffer.append(defVal);
    stringBuffer.append(TEXT_204);
    
		                        typeToGenerate = dbInputBeginUtil.mappingType(typeToGenerate);
		  
		                        if(("Char").equals(typeToGenerate) || ("Character").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_205);
    dbInputBeginUtil.generateStringCharAndCharacterSet(firstConnName, column,currentColNo, trimMethod, typeToGenerate, whetherTrimAllCol, whetherTrimCol);
    stringBuffer.append(TEXT_206);
    
		                        } else if(("Timestamp").equals(typeToGenerate)) {
		                        	if("vertica_id".equalsIgnoreCase(dbms) && "DATE".equalsIgnoreCase(column.getType())){

    stringBuffer.append(TEXT_207);
    dbInputBeginUtil.generateOthersResultSet(firstConnName, column,  currentColNo,  "Date");
    
									}else{

    stringBuffer.append(TEXT_208);
    dbInputBeginUtil.generateTimestampResultSet(firstConnName, column, currentColNo);
    
									}
		                         } else if (("List").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_209);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    
		                        } else if(("String").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_214);
    dbInputBeginUtil.generateStringResultSet(firstConnName, column, currentColNo,trimMethod);
    
								} else if("Geometry".equals(typeToGenerate) && type.indexOf("ORACLE") >= 0) {

    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_220);
    
                                    String sourceCRS = ElementParameterParser.getValue(node,"__CRS__");
                                    String forceCRS = ElementParameterParser.getValue(node,"__FORCE_CRS__");
                                    if (forceCRS.equals("true")) {

    stringBuffer.append(TEXT_221);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_223);
    stringBuffer.append(sourceCRS);
    stringBuffer.append(TEXT_224);
    
                                    }
								} else if(("Bytes").equals(typeToGenerate) && (columnType != null && (("LONG RAW").equals(columnType) || ("RAW").equals(columnType)))) {//oracle

    stringBuffer.append(TEXT_225);
    dbInputBeginUtil.generateBytesResultSet(firstConnName, column, currentColNo);
    
								} else if(("Dynamic").equals(typeToGenerate)) {

    stringBuffer.append(TEXT_226);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
     //for bug TDI-20886
									if ("id_MSSQL".equalsIgnoreCase(dbms)) {

    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(metadata.getListColumns().size());
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    
									}else{

    stringBuffer.append(TEXT_253);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    
									}
								} else if(typeToGenerate.equals("Geometry")) {

    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_262);
    
                 	            } else {

    stringBuffer.append(TEXT_263);
    dbInputBeginUtil.generateOthersResultSet( firstConnName, column,  currentColNo,  typeToGenerate);
    
		                        }

    stringBuffer.append(TEXT_264);
    dbInputBeginUtil.afterGenertorType( firstConnName, column,  currentColNo);
    stringBuffer.append(TEXT_265);
      
		                    currentColNo++;
		                }
		            }
		            if(conns.size() > 1) {
		                for(int connNO = 1 ; connNO < conns.size() ; connNO++) {
		                    IConnection conn2 = conns.get(connNO);
		                    if((conn2.getName().compareTo(firstConnName) != 0) && (conn2.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {
		                        for(IMetadataColumn column:columnList){
		                            
    stringBuffer.append(TEXT_266);
    stringBuffer.append(conn2.getName());
    stringBuffer.append(TEXT_267);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_268);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_270);
     
		                        }
		                    }
		                }
		            }
		        }
		}
	}

    stringBuffer.append(TEXT_271);
    stringBuffer.append(TEXT_272);
    return stringBuffer.toString();
  }
}
