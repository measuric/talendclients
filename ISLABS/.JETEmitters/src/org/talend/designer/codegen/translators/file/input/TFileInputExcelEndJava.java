package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.ElementParameterParser;

public class TFileInputExcelEndJava
{
  protected static String nl;
  public static synchronized TFileInputExcelEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputExcelEndJava result = new TFileInputExcelEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t\t\tnb_line_";
  protected final String TEXT_2 = "++;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_3 = NL + "\t\t\ttry {" + NL + "\t\t\t\tif(excelReader_";
  protected final String TEXT_4 = "!=null) {" + NL + "\t\t\t\t\texcelReader_";
  protected final String TEXT_5 = ".handleException();" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch(java.lang.Exception e_";
  protected final String TEXT_6 = ") {" + NL + "\t\t\t\tif(!(e_";
  protected final String TEXT_7 = ".getCause() instanceof com.talend.excel.xssf.event.EnoughDataException))" + NL + "\t\t\t\t";
  protected final String TEXT_8 = NL + "\t\t\t\tthrow(e_";
  protected final String TEXT_9 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tSystem.err.println(e_";
  protected final String TEXT_11 = ".getMessage());\t" + NL + "\t\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\tglobalMap.put(\"";
  protected final String TEXT_14 = "_NB_LINE\",nb_line_";
  protected final String TEXT_15 = ");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_17 = NL + "\t\t} finally { " + NL + "\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\tif(!(source_";
  protected final String TEXT_19 = " instanceof java.io.InputStream)){" + NL + "\t\t\t\t\t\tworkbook_";
  protected final String TEXT_20 = ".close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_21 = NL + "  \t\t\t\tif(!(source_";
  protected final String TEXT_22 = " instanceof java.io.InputStream)){" + NL + "  \t\t\t\t\tworkbook_";
  protected final String TEXT_23 = ".getPackage().revert();" + NL + "  \t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t}\t" + NL + "\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean version07 = ("true").equals(ElementParameterParser.getValue(node,"__VERSION_2007__"));
	String mode = ElementParameterParser.getValue(node,"__GENERATION_MODE__");
	boolean eventMode = "EVENT_MODE".equals(mode);
	
	String dieOnErrorStr = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	boolean dieOnError = (dieOnErrorStr!=null&&!("").equals(dieOnErrorStr))?("true").equals(dieOnErrorStr):false;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    if(version07 && eventMode) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
     if(dieOnError) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
     } else { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    if((version07 && !eventMode) || !version07) {
    stringBuffer.append(TEXT_16);
    }//Bug TDI-25655
    stringBuffer.append(TEXT_17);
    if(!version07){
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    }else if(!eventMode){
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    } else {//TODO event mode
				
				}
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
