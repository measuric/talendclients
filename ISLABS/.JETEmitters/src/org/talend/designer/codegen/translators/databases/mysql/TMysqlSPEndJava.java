package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TMysqlSPEndJava
{
  protected static String nl;
  public static synchronized TMysqlSPEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlSPEndJava result = new TMysqlSPEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "statement_";
  protected final String TEXT_3 = ".close();";
  protected final String TEXT_4 = NL + "\tconnection_";
  protected final String TEXT_5 = " .close();" + NL + "\t";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    
if (!("true").equals(useExistingConn)) {
	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    
}

    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
