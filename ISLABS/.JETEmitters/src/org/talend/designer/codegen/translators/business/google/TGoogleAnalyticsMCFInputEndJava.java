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

public class TGoogleAnalyticsMCFInputEndJava
{
  protected static String nl;
  public static synchronized TGoogleAnalyticsMCFInputEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TGoogleAnalyticsMCFInputEndJava result = new TGoogleAnalyticsMCFInputEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    " + NL + "\t   countLines_";
  protected final String TEXT_2 = "++;" + NL + "\t} // close while from output connection of ";
  protected final String TEXT_3 = " " + NL + "\tglobalMap.put(\"";
  protected final String TEXT_4 = "_NB_LINE\", countLines_";
  protected final String TEXT_5 = "); " + NL + "\tglobalMap.put(\"";
  protected final String TEXT_6 = "_TOTAL_AFFECTED_ROWS\", ";
  protected final String TEXT_7 = ".getTotalAffectedRows());" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_8 = "_CONTAINS_SAMPLED_DATA\", ";
  protected final String TEXT_9 = ".containsSampledData());";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName(); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
