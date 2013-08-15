package org.talend.designer.codegen.translators.logs;

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

public class TRedirectOutputBeginJava
{
  protected static String nl;
  public static synchronized TRedirectOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRedirectOutputBeginJava result = new TRedirectOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "String fileOutName_";
  protected final String TEXT_2 = " = (new java.io.File(";
  protected final String TEXT_3 = ")).getAbsolutePath().replace(\"\\\\\",\"/\");" + NL + "java.io.File fileOut_";
  protected final String TEXT_4 = " = new java.io.File(fileOutName_";
  protected final String TEXT_5 = ");" + NL + "System.setOut(new java.io.PrintStream(new java.io.FileOutputStream(fileOut_";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = "), true));";
  protected final String TEXT_8 = NL + "System.out.println(";
  protected final String TEXT_9 = " + TalendDate.formatDate(\"yyyy-MM-dd HH:mm:ss\", new Date(startTime)) + \"\");";
  protected final String TEXT_10 = NL + "String fileErrName_";
  protected final String TEXT_11 = " = (new java.io.File(";
  protected final String TEXT_12 = ")).getAbsolutePath().replace(\"\\\\\",\"/\");" + NL + "java.io.File fileErr_";
  protected final String TEXT_13 = " = new java.io.File(fileErrName_";
  protected final String TEXT_14 = ");" + NL + "System.setErr(new java.io.PrintStream(new java.io.FileOutputStream(fileErr_";
  protected final String TEXT_15 = ", ";
  protected final String TEXT_16 = "), true));";
  protected final String TEXT_17 = NL + "System.err.println(";
  protected final String TEXT_18 = " + TalendDate.formatDate(\"yyyy-MM-dd HH:mm:ss\", new Date(startTime)) + \"\");";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    
    boolean redirectOut = ("true").equals(ElementParameterParser.getValue(node, "__SYSTEMOUT__"));
    String appendOut = ((String)ElementParameterParser.getValue(node, "__APPENDSYSTEMOUT__"));
    boolean redirectErr = ("true").equals(ElementParameterParser.getValue(node, "__SYSTEMERR__"));
    String appendErr = ((String)ElementParameterParser.getValue(node, "__APPENDSYSTEMERR__"));
    boolean outputDate = ("true").equals(ElementParameterParser.getValue(node, "__OUTPUTDATE__"));
    String dateCaption = ((String)ElementParameterParser.getValue(node, "__DATECAPTION__"));

	if (redirectOut) {
		String fileOut = ElementParameterParser.getValue(node, "__SYSTEMOUTFILE__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(fileOut);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(appendOut);
    stringBuffer.append(TEXT_7);
          if (outputDate) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(dateCaption);
    stringBuffer.append(TEXT_9);
    
		}
	}
	if (redirectErr) {
		String fileErr = ElementParameterParser.getValue(node, "__SYSTEMERRFILE__");

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(fileErr);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(appendErr);
    stringBuffer.append(TEXT_16);
          if (outputDate) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(dateCaption);
    stringBuffer.append(TEXT_18);
    
		}
	}

    return stringBuffer.toString();
  }
}
