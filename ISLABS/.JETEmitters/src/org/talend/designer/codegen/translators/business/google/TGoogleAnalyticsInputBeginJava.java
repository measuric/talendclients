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

public class TGoogleAnalyticsInputBeginJava
{
  protected static String nl;
  public static synchronized TGoogleAnalyticsInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleAnalyticsInputBeginJava result = new TGoogleAnalyticsInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    // start creating client";
  protected final String TEXT_2 = NL + "\t\tde.cimt.talendcomp.googleanalytics.GoogleAnalyticsInput ";
  protected final String TEXT_3 = " = de.cimt.talendcomp.googleanalytics.GoogleAnalyticsInput.getFromCache(";
  protected final String TEXT_4 = " + ";
  protected final String TEXT_5 = " + \"";
  protected final String TEXT_6 = "\" + jobName);" + NL + "\t\tif (";
  protected final String TEXT_7 = " == null) {" + NL + "\t\t\t";
  protected final String TEXT_8 = " = new de.cimt.talendcomp.googleanalytics.GoogleAnalyticsInput();";
  protected final String TEXT_9 = NL + "\t\tde.cimt.talendcomp.googleanalytics.GoogleAnalyticsInput ";
  protected final String TEXT_10 = " = new de.cimt.talendcomp.googleanalytics.GoogleAnalyticsInput();";
  protected final String TEXT_11 = NL + "\t\t\t";
  protected final String TEXT_12 = ".setApplicationName(";
  protected final String TEXT_13 = ");";
  protected final String TEXT_14 = NL + "\t        // setup credentials" + NL + "\t\t\t";
  protected final String TEXT_15 = ".setAccountEmail(";
  protected final String TEXT_16 = ");" + NL + "\t\t\t";
  protected final String TEXT_17 = ".setKeyFile(";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\t\t";
  protected final String TEXT_20 = ".setTimeoutInSeconds(";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t\t\t";
  protected final String TEXT_23 = ".setTimeOffsetMillisToPast(";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\t\t";
  protected final String TEXT_26 = ".setFetchSize(";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\t        ";
  protected final String TEXT_29 = ".deliverTotalsDataset(";
  protected final String TEXT_30 = ");" + NL + "\t\t\ttry {" + NL + "\t\t\t    // initialize client with private key" + NL + "\t\t\t\t";
  protected final String TEXT_31 = ".initializeAnalyticsClient();" + NL + "\t\t\t} catch (Exception e) {" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_32 = "_ERROR_MESSAGE\", e.getMessage());" + NL + "\t\t\t\tthrow e;\t" + NL + "\t\t\t}" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_33 = "\", ";
  protected final String TEXT_34 = ");";
  protected final String TEXT_35 = NL + "\t\t\tde.cimt.talendcomp.googleanalytics.GoogleAnalyticsInput.putIntoCache(";
  protected final String TEXT_36 = " + ";
  protected final String TEXT_37 = " + \"";
  protected final String TEXT_38 = "\" + jobName, ";
  protected final String TEXT_39 = ");" + NL + "\t\t}";
  protected final String TEXT_40 = NL + "\t\t// setup query" + NL + "\t\t";
  protected final String TEXT_41 = ".setProfileId(";
  protected final String TEXT_42 = ");" + NL + "\t\t";
  protected final String TEXT_43 = ".setStartDate(";
  protected final String TEXT_44 = ");" + NL + "\t\t// for selecting data for one day, set end date == start date" + NL + "\t\t";
  protected final String TEXT_45 = ".setEndDate(";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "\t\t";
  protected final String TEXT_48 = ".setDimensions(";
  protected final String TEXT_49 = ");";
  protected final String TEXT_50 = NL + "\t\t";
  protected final String TEXT_51 = ".setMetrics(";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\t\t";
  protected final String TEXT_54 = ".setFilters(";
  protected final String TEXT_55 = ");";
  protected final String TEXT_56 = NL + "\t\t";
  protected final String TEXT_57 = ".setSegmentId(";
  protected final String TEXT_58 = ");";
  protected final String TEXT_59 = NL + "\t\t";
  protected final String TEXT_60 = ".setSorts(";
  protected final String TEXT_61 = ");";
  protected final String TEXT_62 = NL + "\t\t// fire query and fetch first chunk of data" + NL + "\t\ttry {" + NL + "\t\t    // checks also the correctness of result columns" + NL + "\t\t\t";
  protected final String TEXT_63 = ".executeQuery();" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_64 = "_ERROR_MESSAGE\", e.getMessage());" + NL + "\t\t\tthrow e;\t" + NL + "\t\t}" + NL + "\t\t// iterate through the data..." + NL + "\t\tint countLines_";
  protected final String TEXT_65 = " = 0;" + NL + "\t\twhile (true) {" + NL + "\t\t    try {" + NL + "\t\t\t    // hasNextDataset() executes a new query if needed" + NL + "\t\t\t    if (";
  protected final String TEXT_66 = ".hasNextDataset() == false) {" + NL + "\t\t\t    \tbreak;" + NL + "\t\t\t    }" + NL + "\t\t    } catch (Exception e) {" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_67 = "_ERROR_MESSAGE\", e.getMessage());" + NL + "\t\t\t\tthrow e;\t" + NL + "\t\t    }" + NL + "\t\t    // next row from results" + NL + "\t\t\tjava.util.List<String> dataset_";
  protected final String TEXT_68 = " = ";
  protected final String TEXT_69 = ".getNextDataset();" + NL + "\t\t\t// create a new row, thats avoid the need of setting attributes to null" + NL + "\t\t\t";
  protected final String TEXT_70 = " = new ";
  protected final String TEXT_71 = "Struct();";
  protected final String TEXT_72 = NL + "\t\t// fill schema field ";
  protected final String TEXT_73 = NL + "\t\tString ";
  protected final String TEXT_74 = "_value_";
  protected final String TEXT_75 = " = dataset_";
  protected final String TEXT_76 = ".get(";
  protected final String TEXT_77 = ");" + NL + "\t\tif (";
  protected final String TEXT_78 = "_value_";
  protected final String TEXT_79 = " != null) {";
  protected final String TEXT_80 = NL + "\t\t\tif (countLines_";
  protected final String TEXT_81 = " == 0) {" + NL + "\t\t\t    // we cannot set a date value for the totals row" + NL + "\t\t\t\t";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = " = null;" + NL + "\t\t\t} else {";
  protected final String TEXT_84 = NL + "\t\t\t\t";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = " = ";
  protected final String TEXT_87 = "_value_";
  protected final String TEXT_88 = ";";
  protected final String TEXT_89 = NL + "    \t        try {" + NL + "\t\t\t\t\t";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = " = (";
  protected final String TEXT_92 = ") de.cimt.talendcomp.googleanalytics.Util.convertToDatatype(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_93 = "_value_";
  protected final String TEXT_94 = ", " + NL + "\t\t\t\t\t\t\t\"";
  protected final String TEXT_95 = "\", " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_96 = ");" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\tthrow new Exception(\"Convert field: ";
  protected final String TEXT_97 = ".";
  protected final String TEXT_98 = " value=[\" + ";
  protected final String TEXT_99 = "_value_";
  protected final String TEXT_100 = " + \"] countLines=\" + countLines_";
  protected final String TEXT_101 = " + \" failed:\" + e.getMessage(), e);\t\t" + NL + "\t\t\t\t}";
  protected final String TEXT_102 = "                " + NL + "\t\t\t}";
  protected final String TEXT_103 = NL + "\t\t\t\t";
  protected final String TEXT_104 = ".";
  protected final String TEXT_105 = " = ";
  protected final String TEXT_106 = "_value_";
  protected final String TEXT_107 = ";";
  protected final String TEXT_108 = NL + "    \t        try {" + NL + "\t\t\t\t\t";
  protected final String TEXT_109 = ".";
  protected final String TEXT_110 = " = (";
  protected final String TEXT_111 = ") de.cimt.talendcomp.googleanalytics.Util.convertToDatatype(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_112 = "_value_";
  protected final String TEXT_113 = ", " + NL + "\t\t\t\t\t\t\t\"";
  protected final String TEXT_114 = "\", " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_115 = ");" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\tthrow new Exception(\"Convert field: ";
  protected final String TEXT_116 = ".";
  protected final String TEXT_117 = " value=[\" + ";
  protected final String TEXT_118 = "_value_";
  protected final String TEXT_119 = " + \"] countLines=\" + countLines_";
  protected final String TEXT_120 = " + \" failed:\" + e.getMessage(), e);\t\t" + NL + "\t\t\t\t}";
  protected final String TEXT_121 = "                ";
  protected final String TEXT_122 = NL + "\t\t\t\t";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = " = ";
  protected final String TEXT_125 = "_value_";
  protected final String TEXT_126 = ";";
  protected final String TEXT_127 = NL + "    \t        try {" + NL + "\t\t\t\t\t";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = " = (";
  protected final String TEXT_130 = ") de.cimt.talendcomp.googleanalytics.Util.convertToDatatype(" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_131 = "_value_";
  protected final String TEXT_132 = ", " + NL + "\t\t\t\t\t\t\t\"";
  protected final String TEXT_133 = "\", " + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_134 = ");" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\tthrow new Exception(\"Convert field: ";
  protected final String TEXT_135 = ".";
  protected final String TEXT_136 = " value=[\" + ";
  protected final String TEXT_137 = "_value_";
  protected final String TEXT_138 = " + \"] countLines=\" + countLines_";
  protected final String TEXT_139 = " + \" failed:\" + e.getMessage(), e);\t\t" + NL + "\t\t\t\t}";
  protected final String TEXT_140 = "                ";
  protected final String TEXT_141 = NL + "\t\t}";
  protected final String TEXT_142 = NL;

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
	String segmentId = ElementParameterParser.getValue(node, "__SEGMENT_ID__");
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
    List<IMetadataColumn> listColumns = null;
    IConnection conn = null;
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
     if (applicationName != null && applicationName.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(applicationName);
    stringBuffer.append(TEXT_13);
     }
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(accountEmail);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(keyFile);
    stringBuffer.append(TEXT_18);
     if (timeout != null && timeout.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_21);
     }
     if (timeOffset != null && timeOffset.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(timeOffset);
    stringBuffer.append(TEXT_24);
     }
     if (fetchSize != null && fetchSize.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(fetchSize);
    stringBuffer.append(TEXT_27);
     }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append("true".equals(deliverTotalsDataset));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
     if ("true".equals(keepClient)) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(accountEmail);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(keepClientName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
     }
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(profileId);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(startDate);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(endDate);
    stringBuffer.append(TEXT_46);
     if (dimensions != null && dimensions.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(dimensions);
    stringBuffer.append(TEXT_49);
     }
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(metrics);
    stringBuffer.append(TEXT_52);
     if (filters != null && filters.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(filters);
    stringBuffer.append(TEXT_55);
     }
     if (segmentId != null && segmentId.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(segmentId);
    stringBuffer.append(TEXT_58);
     }
     if (sorts != null && sorts.trim().isEmpty() == false) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(sorts);
    stringBuffer.append(TEXT_61);
     }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
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
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_71);
    	int index = 0;
    if (listColumns != null && conn != null) {
        for (IMetadataColumn col : listColumns) {
        String javaClassName = JavaTypesManager.getJavaTypeFromId(col.getTalendType()).getNullableClass().getName(); 
    stringBuffer.append(TEXT_72);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_79);
              if (deliverTotalsDataset) {
		         if ("java.util.Date".equals(javaClassName)) { 
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_83);
                  if ("java.lang.String".equals(javaClassName)) { 
    stringBuffer.append(TEXT_84);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_88);
                  } else { 
    stringBuffer.append(TEXT_89);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(javaClassName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(col.getTalendType().substring(3));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(((col.getPattern() != null && col.getPattern().isEmpty() == false) ? col.getPattern() : numberFormatLocale));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
                  } 
    stringBuffer.append(TEXT_102);
                  } else {
                    if ("java.lang.String".equals(javaClassName)) { 
    stringBuffer.append(TEXT_103);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_104);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_107);
                      } else { 
    stringBuffer.append(TEXT_108);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(javaClassName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(col.getTalendType().substring(3));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(((col.getPattern() != null && col.getPattern().isEmpty() == false) ? col.getPattern() : numberFormatLocale));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
                      } 
    stringBuffer.append(TEXT_121);
                  } 
              } else {
                if ("java.lang.String".equals(javaClassName)) { 
    stringBuffer.append(TEXT_122);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_126);
                  } else { 
    stringBuffer.append(TEXT_127);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_128);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(javaClassName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(col.getTalendType().substring(3));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(((col.getPattern() != null && col.getPattern().isEmpty() == false) ? col.getPattern() : numberFormatLocale));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(col.getLabel());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(index);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
                  } 
    stringBuffer.append(TEXT_140);
              } 
    stringBuffer.append(TEXT_141);
          index++;
          } 
      } 
    stringBuffer.append(TEXT_142);
    return stringBuffer.toString();
  }
}
