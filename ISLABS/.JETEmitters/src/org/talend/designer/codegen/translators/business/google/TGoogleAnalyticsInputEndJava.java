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

public class TGoogleAnalyticsInputEndJava
{
  protected static String nl;
  public static synchronized TGoogleAnalyticsInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleAnalyticsInputEndJava result = new TGoogleAnalyticsInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    " + NL + "\t   countLines_";
  protected final String TEXT_2 = "++;";
  protected final String TEXT_3 = NL + "       if (countLines_";
  protected final String TEXT_4 = " >= ";
  protected final String TEXT_5 = ") {" + NL + "           break;" + NL + "       }";
  protected final String TEXT_6 = NL + "\t} // close while from output connection of ";
  protected final String TEXT_7 = " " + NL + "\tglobalMap.put(\"";
  protected final String TEXT_8 = "_NB_LINE\", countLines_";
  protected final String TEXT_9 = "); " + NL + "\tglobalMap.put(\"";
  protected final String TEXT_10 = "_TOTAL_AFFECTED_ROWS\", ";
  protected final String TEXT_11 = ".getTotalAffectedRows());" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_12 = "_CONTAINS_SAMPLED_DATA\", ";
  protected final String TEXT_13 = ".containsSampledData());";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode) codeGenArgument.getArgument();
    String cid = node.getUniqueName(); 
	String maxRowsStr = ElementParameterParser.getValue(node, "__MAX_ROWS__");
	int maxRows = 0;
	if (maxRowsStr != null && maxRowsStr.isEmpty() == false) {
		maxRows = Integer.parseInt(maxRowsStr);
	}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
      if (maxRows > 0) { 
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(maxRows);
    stringBuffer.append(TEXT_5);
      } 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}
