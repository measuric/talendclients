package org.talend.designer.codegen.translators.business.google;

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

public class TGoogleAnalyticsMCFInputBeginJava
{
  protected static String nl;
  public static synchronized TGoogleAnalyticsMCFInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleAnalyticsMCFInputBeginJava result = new TGoogleAnalyticsMCFInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    // start creating client" + NL + "\t";
  protected final String TEXT_2 = NL + "\t\tde.cimt.talendcomp.googleanalytics.GoogleAnalyticsMCFInput ";
  protected final String TEXT_3 = " = de.cimt.talendcomp.googleanalytics.GoogleAnalyticsMCFInput.getFromCache(";
  protected final String TEXT_4 = " + ";
  protected final String TEXT_5 = " + \"";
  protected final String TEXT_6 = "\" + jobName);" + NL + "\t\tif (";
  protected final String TEXT_7 = " == null) {" + NL + "\t\t\t";
  protected final String TEXT_8 = " = new de.cimt.talendcomp.googleanalytics.GoogleAnalyticsMCFInput();" + NL + "\t";
  protected final String TEXT_9 = NL + "\t\tde.cimt.talendcomp.googleanalytics.GoogleAnalyticsMCFInput ";
  protected final String TEXT_10 = " = new de.cimt.talendcomp.googleanalytics.GoogleAnalyticsMCFInput();" + NL + "\t";
  protected final String TEXT_11 = NL + "\t";
  protected final String TEXT_12 = NL + "\t\t\t";
  protected final String TEXT_13 = ".setApplicationName(";
  protected final String TEXT_14 = ");" + NL + "\t";
  protected final String TEXT_15 = NL + "\t        // setup credentials" + NL + "\t\t\t";
  protected final String TEXT_16 = ".setAccountEmail(";
  protected final String TEXT_17 = ");" + NL + "\t\t\t";
  protected final String TEXT_18 = ".setKeyFile(";
  protected final String TEXT_19 = ");" + NL + "\t";
  protected final String TEXT_20 = NL + "\t\t\t";
  protected final String TEXT_21 = ".setTimeoutInSeconds(";
  protected final String TEXT_22 = ");" + NL + "\t";
  protected final String TEXT_23 = NL + "\t";
  protected final String TEXT_24 = NL + "\t\t\t";
  protected final String TEXT_25 = ".setTimeOffsetMillisToPast(";
  protected final String TEXT_26 = ");" + NL + "\t";
  protected final String TEXT_27 = NL + "\t";
  protected final String TEXT_28 = NL + "\t\t\t";
  protected final String TEXT_29 = ".setFetchSize(";
  protected final String TEXT_30 = ");" + NL + "\t";
  protected final String TEXT_31 = NL + "\t        ";
  protected final String TEXT_32 = ".deliverTotalsDataset(";
  protected final String TEXT_33 = ");" + NL + "\t\t\ttry {" + NL + "\t\t\t    // initialize client with private key" + NL + "\t\t\t\t";
  protected final String TEXT_34 = ".initializeAnalyticsClient();" + NL + "\t\t\t} catch (Exception e) {" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_35 = "_ERROR_MESSAGE\", e.getMessage());" + NL + "\t\t\t\tthrow e;\t" + NL + "\t\t\t}" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_36 = "\", ";
  protected final String TEXT_37 = ");" + NL + "\t";
  protected final String TEXT_38 = NL + "\t\t\tde.cimt.talendcomp.googleanalytics.GoogleAnalyticsMCFInput.putIntoCache(";
  protected final String TEXT_39 = " + ";
  protected final String TEXT_40 = " + \"";
  protected final String TEXT_41 = "\" + jobName, ";
  protected final String TEXT_42 = ");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_43 = NL + "\t\t// setup query" + NL + "\t\t";
  protected final String TEXT_44 = ".setProfileId(";
  protected final String TEXT_45 = ");" + NL + "\t\t";
  protected final String TEXT_46 = ".setStartDate(";
  protected final String TEXT_47 = ");" + NL + "\t\t// for selecting data for one day, set end date == start date" + NL + "\t\t";
  protected final String TEXT_48 = ".setEndDate(";
  protected final String TEXT_49 = ");";
  protected final String TEXT_50 = NL + "\t\t";
  protected final String TEXT_51 = ".setDimensions(";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\t\t";
  protected final String TEXT_54 = ".setMetrics(";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\t\t";
  protected final String TEXT_57 = ".setFilters(";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "\t\t";
  protected final String TEXT_60 = ".setConversionPathDelimiter(";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL + "\t\t";
  protected final String TEXT_63 = ".setSorts(";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = NL + "\t\t// fire query and fetch first chunk of data" + NL + "\t\ttry {" + NL + "\t\t    // checks also the correctness of result columns" + NL + "\t\t\t";
  protected final String TEXT_66 = ".executeQuery();" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_67 = "_ERROR_MESSAGE\", e.getMessage());" + NL + "\t\t\tthrow e;\t" + NL + "\t\t}" + NL + "\t\t// iterate through the data..." + NL + "\t\tint countLines_";
  protected final String TEXT_68 = " = 0;" + NL + "\t\twhile (true) {" + NL + "\t\t    try {" + NL + "\t\t\t    // hasNextDataset() executes a new query if needed" + NL + "\t\t\t    if (";
  protected final String TEXT_69 = ".hasNextDataset() == false) {" + NL + "\t\t\t    \tbreak;" + NL + "\t\t\t    }" + NL + "\t\t    } catch (Exception e) {" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_70 = "_ERROR_MESSAGE\", e.getMessage());" + NL + "\t\t\t\tthrow e;\t" + NL + "\t\t    }" + NL + "\t\t    // next row" + NL + "\t\t\tjava.util.List<String> dataset_";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = ".getNextDataset();" + NL + "\t\t\t// create new row to avoid setting null values" + NL + "\t\t\t";
  protected final String TEXT_73 = " = new ";
  protected final String TEXT_74 = "Struct();";
  protected final String TEXT_75 = NL + "\t\t// fill schema field ";
  protected final String TEXT_76 = NL + "\t\tString ";
  protected final String TEXT_77 = "_value_";
  protected final String TEXT_78 = " = dataset_";
  protected final String TEXT_79 = ".get(";
  protected final String TEXT_80 = ");" + NL + "\t\tif (";
  protected final String TEXT_81 = "_value_";
  protected final String TEXT_82 = " != null) {";
  protected final String TEXT_83 = NL + "\t\t\tif (countLines_";
  protected final String TEXT_84 = " == 0) {" + NL + "\t\t\t    // we cannot set a date value for the totals row" + NL + "\t\t\t\t";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = " = null;" + NL + "\t\t\t} else {";
  protected final String TEXT_87 = NL + "\t\t\t\t";
  protected final String TEXT_88 = ".";
  protected final String TEXT_89 = " = ";
  protected final String TEXT_90 = "_value_";
  protected final String TEXT_91 = ";";
  protected final String TEXT_92 = NL + "    \t        try {" + NL + "\t\t\t\t\t";
  protected final String TEXT_93 = ".";
  protected final String TEXT_94 = " = (";
  protected final String TEXT_95 = ") de.cimt.talendcomp.googleanalytics.Util.convertToDatatype(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_96 = "_value_";
  protected final String TEXT_97 = ", " + NL + "\t\t\t\t\t\t\t\"";
  protected final String TEXT_98 = "\", " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_99 = ");" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\tthrow new Exception(\"Convert field: ";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = " value=[\" + ";
  protected final String TEXT_102 = "_value_";
  protected final String TEXT_103 = " + \"] countLines=\" + countLines_";
  protected final String TEXT_104 = " + \" failed:\" + e.getMessage(), e);\t\t" + NL + "\t\t\t\t}";
  protected final String TEXT_105 = "                " + NL + "\t\t\t}";
  protected final String TEXT_106 = NL + "\t\t\t\t";
  protected final String TEXT_107 = ".";
  protected final String TEXT_108 = " = ";
  protected final String TEXT_109 = "_value_";
  protected final String TEXT_110 = ";";
  protected final String TEXT_111 = NL + "    \t        try {" + NL + "\t\t\t\t\t";
  protected final String TEXT_112 = ".";
  protected final String TEXT_113 = " = (";
  protected final String TEXT_114 = ") de.cimt.talendcomp.googleanalytics.Util.convertToDatatype(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_115 = "_value_";
  protected final String TEXT_116 = ", " + NL + "\t\t\t\t\t\t\t\"";
  protected final String TEXT_117 = "\", " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_118 = ");" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\tthrow new Exception(\"Convert field: ";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = " value=[\" + ";
  protected final String TEXT_121 = "_value_";
  protected final String TEXT_122 = " + \"] countLines=\" + countLines_";
  protected final String TEXT_123 = " + \" failed:\" + e.getMessage(), e);\t\t" + NL + "\t\t\t\t}";
  protected final String TEXT_124 = "                ";
  protected final String TEXT_125 = NL + "\t\t\t\t";
  protected final String TEXT_126 = ".";
  protected final String TEXT_127 = " = ";
  protected final String TEXT_128 = "_value_";
  protected final String TEXT_129 = ";";
  protected final String TEXT_130 = NL + "    \t        try {" + NL + "\t\t\t\t\t";
  protected final String TEXT_131 = ".";
  protected final String TEXT_132 = " = (";
  protected final String TEXT_133 = ") de.cimt.talendcomp.googleanalytics.Util.convertToDatatype(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_134 = "_value_";
  protected final String TEXT_135 = ", " + NL + "\t\t\t\t\t\t\t\"";
  protected final String TEXT_136 = "\", " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_137 = ");" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\tthrow new Exception(\"Convert field: ";
  protected final String TEXT_138 = ".";
  protected final String TEXT_139 = " value=[\" + ";
  protected final String TEXT_140 = "_value_";
  protected final String TEXT_141 = " + \"] countLines=\" + countLines_";
  protected final String TEXT_142 = " + \" failed:\" + e.getMessage(), e);\t\t" + NL + "\t\t\t\t}";
  protected final String TEXT_143 = "                ";
  protected final String TEXT_144 = NL + "\t\t}";
  protected final String TEXT_145 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    String profileId = ElementParameterParser.getValue(node, "__PROFILE_ID__");
    String applicationName = ElementParameterParser.getValue(node, "__APPLICATION_NAME__");
	String accountEmail = ElementParameterParser.getValue(node, "__SERVICE_ACCOUNT_EMAIL__");
	String keyFile = ElementParameterParser.getValue(node, "__KEY_FILE__");
	String startDate = ElementParameterParser.getValue(node, "__START_DATE__");
	String endDate = ElementParameterParser.getValue(node, "__END_DATE__");
	String dimensions = ElementParameterParser.getValue(node, "__DIMENSIONS__");
	String metrics = ElementParameterParser.getValue(node, "__METRICS__");
	String filters = ElementParameterParser.getValue(node, "__FILTERS__");
	String pathDelimiter = ElementParameterParser.getValue(node, "__CONVERSION_PATH_DELIMITER__");
	String sorts = ElementParameterParser.getValue(node, "__SORTS__");
	String timeout = ElementParameterParser.getValue(node, "__TIMEOUT_IN_SEC__");
	String timeOffset = ElementParameterParser.getValue(node, "__TIME_OFFSET__");
	String fetchSize = ElementParameterParser.getValue(node, "__FETCH_SIZE__");
	String numberFormatLocale = ElementParameterParser.getValue(node, "__NUMBERFORMAT_LOCALE__");
	if (numberFormatLocale != null && numberFormatLocale.isEmpty() == false) {
		numberFormatLocale = "\"" + numberFormatLocale + "\"";
	} else {
		numberFormatLocale = "null";
	}
	boolean deliverTotalsDataset = "true".equals(ElementParameterParser.getValue(node, "__DELIVER_TOTALS_DATASET__"));
	String keepClient = ElementParameterParser.getValue(node, "__KEEP_CLIENT__");
	String keepClientName = ElementParameterParser.getValue(node, "__KEEP_CLIENT_KEY__");
	keepClientName = keepClientName != null && keepClientName.isEmpty() == false ? keepClientName : "\"\"";
    IConnection conn = null;
    List<IMetadataColumn> listColumns = null;
    if (node.getOutgoingConnections().size() > 0) {
        conn = node.getOutgoingConnections().get(0);
	    IMetadataTable metadata = conn.getMetadataTable();
	    listColumns = metadata.getListColumns();
    }

    stringBuffer.append(TEXT_1);
     if ("true".equals(keepClient)) {
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(accountEmail);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(keepClientName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
     } else {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
     }
    stringBuffer.append(TEXT_11);
     if (applicationName != null && applicationName.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(applicationName);
    stringBuffer.append(TEXT_14);
     }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(accountEmail);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(keyFile);
    stringBuffer.append(TEXT_19);
     if (timeout != null && timeout.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_22);
     }
    stringBuffer.append(TEXT_23);
     if (timeOffset != null && timeOffset.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(timeOffset);
    stringBuffer.append(TEXT_26);
     }
    stringBuffer.append(TEXT_27);
     if (fetchSize != null && fetchSize.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(fetchSize);
    stringBuffer.append(TEXT_30);
     }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append("true".equals(deliverTotalsDataset));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
     if ("true".equals(keepClient)) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(accountEmail);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(keepClientName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
     }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(profileId);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(startDate);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(endDate);
    stringBuffer.append(TEXT_49);
     if (dimensions != null && dimensions.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(dimensions);
    stringBuffer.append(TEXT_52);
     }
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(metrics);
    stringBuffer.append(TEXT_55);
     if (filters != null && filters.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(filters);
    stringBuffer.append(TEXT_58);
     }
     if (pathDelimiter != null && pathDelimiter.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(pathDelimiter);
    stringBuffer.append(TEXT_61);
     }
     if (sorts != null && sorts.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(sorts);
    stringBuffer.append(TEXT_64);
     }
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_74);
    	int index = 0;
    if (listColumns != null && conn != null) {
        for (IMetadataColumn col : listColumns) {
        String javaClassName = JavaTypesManager.getJavaTypeFromId(col.getTalendType()).getNullableClass().getName(); 
    stringBuffer.append(TEXT_75);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_82);
              if (deliverTotalsDataset) {
		         if ("java.util.Date".equals(javaClassName)) { 
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_86);
                  if ("java.lang.String".equals(javaClassName)) { 
    stringBuffer.append(TEXT_87);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_91);
                  } else { 
    stringBuffer.append(TEXT_92);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(javaClassName);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(col.getTalendType().substring(3));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(((col.getPattern() != null && col.getPattern().isEmpty() == false) ? col.getPattern() : numberFormatLocale));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
                  } 
    stringBuffer.append(TEXT_105);
                  } else {
                    if ("java.lang.String".equals(javaClassName)) { 
    stringBuffer.append(TEXT_106);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_110);
                      } else { 
    stringBuffer.append(TEXT_111);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(javaClassName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(col.getTalendType().substring(3));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(((col.getPattern() != null && col.getPattern().isEmpty() == false) ? col.getPattern() : numberFormatLocale));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
                      } 
    stringBuffer.append(TEXT_124);
                  } 
              } else {
                if ("java.lang.String".equals(javaClassName)) { 
    stringBuffer.append(TEXT_125);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_129);
                  } else { 
    stringBuffer.append(TEXT_130);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(javaClassName);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(col.getTalendType().substring(3));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(((col.getPattern() != null && col.getPattern().isEmpty() == false) ? col.getPattern() : numberFormatLocale));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_138);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
                  } 
    stringBuffer.append(TEXT_143);
              } 
    stringBuffer.append(TEXT_144);
          index++; 
          } 
      } 
    stringBuffer.append(TEXT_145);
    return stringBuffer.toString();
  }
}
