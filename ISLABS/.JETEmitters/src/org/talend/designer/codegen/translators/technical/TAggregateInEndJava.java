package org.talend.designer.codegen.translators.technical;

public class TAggregateInEndJava
{
  protected static String nl;
  public static synchronized TAggregateInEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAggregateInEndJava result = new TAggregateInEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "} // G_AggR_600";
  protected final String TEXT_2 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
