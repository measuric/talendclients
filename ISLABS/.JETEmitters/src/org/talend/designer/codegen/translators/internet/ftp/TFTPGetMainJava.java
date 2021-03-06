package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFTPGetMainJava
{
  protected static String nl;
  public static synchronized TFTPGetMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPGetMainJava result = new TFTPGetMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "try {" + NL + "  globalMap.put(\"";
  protected final String TEXT_2 = "_CURRENT_STATUS\", \"No file transfered.\");" + NL + "  String dir_";
  protected final String TEXT_3 = " = root_";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL + "  String mask_";
  protected final String TEXT_6 = " = maskStr_";
  protected final String TEXT_7 = ".replaceAll(\"\\\\\\\\\", \"/\") ;";
  protected final String TEXT_8 = NL + "  String mask_";
  protected final String TEXT_9 = " = maskStr_";
  protected final String TEXT_10 = ";";
  protected final String TEXT_11 = NL + "  int i_";
  protected final String TEXT_12 = " = mask_";
  protected final String TEXT_13 = ".lastIndexOf('/'); " + NL + "" + NL + "  if (i_";
  protected final String TEXT_14 = " != -1){" + NL + "    dir_";
  protected final String TEXT_15 = " = mask_";
  protected final String TEXT_16 = ".substring(0, i_";
  protected final String TEXT_17 = "); " + NL + "    mask_";
  protected final String TEXT_18 = " = mask_";
  protected final String TEXT_19 = ".substring(i_";
  protected final String TEXT_20 = "+1);  " + NL + "  }" + NL + "  ";
  protected final String TEXT_21 = NL + "  mask_";
  protected final String TEXT_22 = " = org.apache.oro.text.GlobCompiler.globToPerl5(mask_";
  protected final String TEXT_23 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);";
  protected final String TEXT_24 = NL + "  " + NL + "  if (dir_";
  protected final String TEXT_25 = "!=null && !\"\".equals(dir_";
  protected final String TEXT_26 = ")){" + NL + "    if ((\".*\").equals(mask_";
  protected final String TEXT_27 = ")) {" + NL + "      getter_";
  protected final String TEXT_28 = ".getAllFiles(dir_";
  protected final String TEXT_29 = ", localdir_";
  protected final String TEXT_30 = ");" + NL + "    } else {" + NL + "      getter_";
  protected final String TEXT_31 = ".getFiles(dir_";
  protected final String TEXT_32 = ", localdir_";
  protected final String TEXT_33 = " ,mask_";
  protected final String TEXT_34 = ");" + NL + "    }" + NL + "  }" + NL + "  getter_";
  protected final String TEXT_35 = ".chdir(root_";
  protected final String TEXT_36 = ");" + NL + "} catch(java.lang.Exception e) {";
  protected final String TEXT_37 = NL + "    throw(e);";
  protected final String TEXT_38 = NL + "    System.err.print(e.getMessage());";
  protected final String TEXT_39 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
String overwrite=ElementParameterParser.getValue(node, "__OVERWRITE__");
String sftpoverwrite=ElementParameterParser.getValue(node, "__SFTPOVERWRITE__");
String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean sftp = false;

boolean usePerl5 = ("true").equals(ElementParameterParser.getValue(node, "__PERL5_REGEX__"));

if ("true".equals(useExistingConn)) {
  List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();

  for (INode n : nodeList) {

    if (n.getUniqueName().equals(connection)) {
      sftp = "true".equals(ElementParameterParser.getValue(n, "__SFTP__"));
    }
  }
} else {
  sftp = "true".equals(ElementParameterParser.getValue(node, "__SFTP__"));
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    if(!usePerl5) {//perl5 mode not support windows(\) path separator at the mask string
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    } else {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    if(!usePerl5) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    if ("true".equals(dieOnError)){
    stringBuffer.append(TEXT_37);
    }else{
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    return stringBuffer.toString();
  }
}
