package org.talend.designer.codegen.translators.file.management;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFileListBeginJava
{
  protected static String nl;
  public static synchronized TFileListBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileListBeginJava result = new TFileListBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  " + NL + "        Comparator<java.io.File> fileNameASC_";
  protected final String TEXT_2 = " = new Comparator<java.io.File>() {" + NL + "        " + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if (bO1IsFile && bO2IsFile) {" + NL + "                return (o1.getName()).compareTo(o2.getName());" + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return 1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return -1;" + NL + "            } else if (!bO1IsFile && !bO2IsFile) {" + NL + "                return (o1.getName()).compareTo(o2.getName());" + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_3 = NL + "        Comparator<java.io.File> fileNameDESC_";
  protected final String TEXT_4 = " = new Comparator<java.io.File>() {" + NL + "" + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if (bO1IsFile && bO2IsFile) {" + NL + "                return (o2.getName()).compareTo(o1.getName());" + NL + "            } else if (bO1IsFile && !bO2IsFile) {" + NL + "                return -1;" + NL + "            } else if (!bO1IsFile && bO2IsFile) {" + NL + "                return 1;" + NL + "            } else if (!bO1IsFile && !bO2IsFile) {" + NL + "                return (o2.getName()).compareTo(o1.getName());" + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_5 = NL + "        Comparator<java.io.File> lastModifiedASC_";
  protected final String TEXT_6 = " = new Comparator<java.io.File>() {" + NL + "        " + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if ((bO1IsFile && bO2IsFile) || (!bO1IsFile && !bO2IsFile)) {" + NL + "                if (o1.lastModified() == o2.lastModified()) {" + NL + "                    return (o1.getName()).compareTo(o2.getName());" + NL + "                } else if (o1.lastModified() > o2.lastModified()) {" + NL + "                    return 1;" + NL + "                } else {" + NL + "                    return -1;" + NL + "                }" + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return 1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return -1;" + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_7 = NL + "        Comparator<java.io.File> lastModifiedDESC_";
  protected final String TEXT_8 = " = new Comparator<java.io.File>() {" + NL + "        " + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if ((bO1IsFile && bO2IsFile) || (!bO1IsFile && !bO2IsFile)) {" + NL + "                if (o1.lastModified() == o2.lastModified()) {" + NL + "                    return (o2.getName()).compareTo(o1.getName());" + NL + "                } else if (o1.lastModified() < o2.lastModified()) {" + NL + "                    return 1;" + NL + "                } else {" + NL + "                    return -1;" + NL + "                }" + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return -1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return 1;            " + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_9 = NL + "        Comparator<java.io.File> filseSizeASC_";
  protected final String TEXT_10 = " = new Comparator<java.io.File>() {" + NL + "" + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "                      " + NL + "            if (bO1IsFile && bO2IsFile) {" + NL + "                long size_1 = o1.length();" + NL + "                long size_2 = o2.length();                " + NL + "       " + NL + "                if (size_1 == size_2) {" + NL + "                    return (o1.getName()).compareTo(o2.getName());" + NL + "                } else if (size_1 > size_2) {" + NL + "                    return 1;" + NL + "                } else {" + NL + "                    return -1;" + NL + "                }                " + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return 1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return -1;" + NL + "            } else if ((!bO1IsFile) && (!bO2IsFile)){" + NL + "                return (o1.getName()).compareTo(o2.getName());" + NL + "            } else{" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_11 = NL + "        Comparator<java.io.File> filseSizeDESC_";
  protected final String TEXT_12 = " = new Comparator<java.io.File>() {" + NL + "        " + NL + "          public int compare(java.io.File o1, java.io.File o2) {" + NL + "            boolean bO1IsFile = o1.isFile();" + NL + "            boolean bO2IsFile = o2.isFile();" + NL + "            " + NL + "            if (bO1IsFile && bO2IsFile) {" + NL + "                " + NL + "                long size_1 = o1.length();" + NL + "                long size_2 = o2.length();" + NL + "              " + NL + "                if (size_1 == size_2) {" + NL + "                    return (o2.getName()).compareTo(o1.getName());" + NL + "                } else if (size_1 < size_2) {" + NL + "                    return 1;" + NL + "                } else {" + NL + "                    return -1;" + NL + "                }" + NL + "                " + NL + "            } else if (bO1IsFile && (!bO2IsFile)) {" + NL + "                return -1;" + NL + "            } else if ((!bO1IsFile) && bO2IsFile) {" + NL + "                return 1;" + NL + "            } else if ((!bO1IsFile) && (!bO2IsFile)){" + NL + "                return (o2.getName()).compareTo(o1.getName());" + NL + "            } else {" + NL + "                return 0;" + NL + "            }" + NL + "          }" + NL + "        };";
  protected final String TEXT_13 = NL + "    \tString fileName_";
  protected final String TEXT_14 = " = file.getName();" + NL + "\t\tfor (final String filemask_";
  protected final String TEXT_15 = " : maskList_";
  protected final String TEXT_16 = ") {" + NL + "\t\t\tString filemask_compile_";
  protected final String TEXT_17 = " = filemask_";
  protected final String TEXT_18 = ";" + NL + "\t\t\t";
  protected final String TEXT_19 = NL + "\t\t    \tfilemask_compile_";
  protected final String TEXT_20 = " = org.apache.oro.text.GlobCompiler.globToPerl5(filemask_";
  protected final String TEXT_21 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t\t    ";
  protected final String TEXT_22 = NL + "\t\t      java.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_23 = " = java.util.regex.Pattern.compile(filemask_compile_";
  protected final String TEXT_24 = ");" + NL + "\t\t    ";
  protected final String TEXT_25 = NL + "\t\t      java.util.regex.Pattern fileNamePattern_";
  protected final String TEXT_26 = " = java.util.regex.Pattern.compile(filemask_compile_";
  protected final String TEXT_27 = ", java.util.regex.Pattern.CASE_INSENSITIVE);";
  protected final String TEXT_28 = NL + "          \tif (fileNamePattern_";
  protected final String TEXT_29 = ".matcher(fileName_";
  protected final String TEXT_30 = ").matches()){";
  protected final String TEXT_31 = NL + "\t\t\t \t\tboolean isExclude_";
  protected final String TEXT_32 = " = false;" + NL + "\t\t\t        for(java.util.regex.Pattern pattern : excludefileNameEachPattern_";
  protected final String TEXT_33 = ") {" + NL + "\t\t\t        \tif(pattern.matcher(fileName_";
  protected final String TEXT_34 = ").matches()) {" + NL + "\t\t\t        \t\tisExclude_";
  protected final String TEXT_35 = " = true;" + NL + "\t\t\t        \t\tbreak;" + NL + "\t\t\t        \t}" + NL + "\t\t\t        }" + NL + "\t\t\t        if(!isExclude_";
  protected final String TEXT_36 = ") {" + NL + "\t\t\t          list_";
  protected final String TEXT_37 = ".add(file);" + NL + "\t\t\t        }";
  protected final String TEXT_38 = NL + "                  list_";
  protected final String TEXT_39 = ".add(file);";
  protected final String TEXT_40 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_41 = "   " + NL + "    " + NL + "  String directory_";
  protected final String TEXT_42 = " = ";
  protected final String TEXT_43 = ";" + NL + "  final java.util.List<String> maskList_";
  protected final String TEXT_44 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_45 = NL + "      maskList_";
  protected final String TEXT_46 = ".add(\"*\");";
  protected final String TEXT_47 = NL + "      maskList_";
  protected final String TEXT_48 = ".add(\".*\");";
  protected final String TEXT_49 = " " + NL + "    maskList_";
  protected final String TEXT_50 = ".add(";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = "  " + NL + "  int NB_FILE";
  protected final String TEXT_53 = " = 0;" + NL + "" + NL + "  final boolean case_sensitive_";
  protected final String TEXT_54 = " = ";
  protected final String TEXT_55 = ";";
  protected final String TEXT_56 = "   " + NL + "      String excludefilemask_";
  protected final String TEXT_57 = " = ";
  protected final String TEXT_58 = ";" + NL + "\t  final List<java.util.regex.Pattern> excludefileNameEachPattern_";
  protected final String TEXT_59 = " = new java.util.ArrayList<java.util.regex.Pattern>();" + NL + "\t  if(excludefilemask_";
  protected final String TEXT_60 = "!=null && !\"\".equals(excludefilemask_";
  protected final String TEXT_61 = ")) {" + NL + "\t  \tfor(String excludefilemaskEach_";
  protected final String TEXT_62 = " : excludefilemask_";
  protected final String TEXT_63 = ".split(\",\")) {" + NL + "\t  \t ";
  protected final String TEXT_64 = NL + "\t  \t\texcludefilemaskEach_";
  protected final String TEXT_65 = " = org.apache.oro.text.GlobCompiler.globToPerl5(excludefilemaskEach_";
  protected final String TEXT_66 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t  \t ";
  protected final String TEXT_67 = NL + "\t\t\t\texcludefileNameEachPattern_";
  protected final String TEXT_68 = ".add(java.util.regex.Pattern.compile(excludefilemaskEach_";
  protected final String TEXT_69 = ",java.util.regex.Pattern.CASE_INSENSITIVE));" + NL + "\t\t ";
  protected final String TEXT_70 = NL + "\t\t\t\texcludefileNameEachPattern_";
  protected final String TEXT_71 = ".add(java.util.regex.Pattern.compile(excludefilemaskEach_";
  protected final String TEXT_72 = "));" + NL + "\t\t ";
  protected final String TEXT_73 = "\t  \t \t\t" + NL + "\t  \t}" + NL + "\t  }";
  protected final String TEXT_74 = NL + "    final java.util.List<java.io.File> list_";
  protected final String TEXT_75 = " = new java.util.ArrayList<java.io.File>();" + NL + "\tjava.io.File file_";
  protected final String TEXT_76 = " = new java.io.File(directory_";
  protected final String TEXT_77 = ");" + NL + "    ";
  protected final String TEXT_78 = NL + "\t\tfile_";
  protected final String TEXT_79 = ".listFiles(new java.io.FilenameFilter() {" + NL + "\t\t\tpublic boolean accept(java.io.File dir, String name) {" + NL + "\t\t\t\tjava.io.File file = new java.io.File(dir, name);" + NL + "\t\t\t\t";
  protected final String TEXT_80 = NL + "\t                if (!file.isDirectory()) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_81 = NL + "\t                \treturn true;" + NL + "\t                } else {" + NL + "\t                  file.listFiles(this);" + NL + "\t                }" + NL + "\t\t\t\t";
  protected final String TEXT_82 = NL + "\t                if (!file.isDirectory()) {" + NL + "\t                  return true;" + NL + "\t                } else {" + NL + "\t                \t";
  protected final String TEXT_83 = NL + "\t                  \tfile.listFiles(this);" + NL + "\t                }" + NL + "\t\t\t\t";
  protected final String TEXT_84 = NL + "\t                 ";
  protected final String TEXT_85 = NL + "\t\t            if (file.isDirectory()) {" + NL + "\t\t              file.listFiles(this);" + NL + "\t\t            }" + NL + "\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t);";
  protected final String TEXT_87 = " " + NL + "\t\tfile_";
  protected final String TEXT_88 = ".listFiles(new java.io.FilenameFilter() {" + NL + "\t\t\tpublic boolean accept(java.io.File dir, String name) {" + NL + "\t\t\t\tjava.io.File file = new java.io.File(dir, name);";
  protected final String TEXT_89 = NL + "                if (!file.isDirectory()) {" + NL + "                \t";
  protected final String TEXT_90 = NL + "                }";
  protected final String TEXT_91 = NL + "                if (file.isDirectory()) {" + NL + "                \t";
  protected final String TEXT_92 = NL + "                }";
  protected final String TEXT_93 = NL + "                \t";
  protected final String TEXT_94 = NL + "              return true;" + NL + "            }" + NL + "          }" + NL + "      );";
  protected final String TEXT_95 = " ";
  protected final String TEXT_96 = NL + "      java.util.Collections.sort(list_";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "      java.util.Collections.sort(list_";
  protected final String TEXT_99 = ", fileName";
  protected final String TEXT_100 = "_";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "      java.util.Collections.sort(list_";
  protected final String TEXT_103 = ", filseSize";
  protected final String TEXT_104 = "_";
  protected final String TEXT_105 = ");";
  protected final String TEXT_106 = NL + "      java.util.Collections.sort(list_";
  protected final String TEXT_107 = ", lastModified";
  protected final String TEXT_108 = "_";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + "    " + NL + "    for (int i_";
  protected final String TEXT_111 = " = 0; i_";
  protected final String TEXT_112 = " < list_";
  protected final String TEXT_113 = ".size(); i_";
  protected final String TEXT_114 = "++){" + NL + "      java.io.File files_";
  protected final String TEXT_115 = " = list_";
  protected final String TEXT_116 = ".get(i_";
  protected final String TEXT_117 = ");" + NL + "      String fileName_";
  protected final String TEXT_118 = " = files_";
  protected final String TEXT_119 = ".getName();" + NL + "      " + NL + "      String currentFileName_";
  protected final String TEXT_120 = " = files_";
  protected final String TEXT_121 = ".getName(); " + NL + "      String currentFilePath_";
  protected final String TEXT_122 = " = files_";
  protected final String TEXT_123 = ".getAbsolutePath();" + NL + "      String currentFileDirectory_";
  protected final String TEXT_124 = " = files_";
  protected final String TEXT_125 = ".getParent();" + NL + "      String currentFileExtension_";
  protected final String TEXT_126 = " = null;" + NL + "      " + NL + "      if (files_";
  protected final String TEXT_127 = ".getName().contains(\".\") && files_";
  protected final String TEXT_128 = ".isFile()){" + NL + "        currentFileExtension_";
  protected final String TEXT_129 = " = files_";
  protected final String TEXT_130 = ".getName().substring(files_";
  protected final String TEXT_131 = ".getName().lastIndexOf(\".\") + 1);" + NL + "      } else{" + NL + "        currentFileExtension_";
  protected final String TEXT_132 = " = \"\";" + NL + "      }";
  protected final String TEXT_133 = NL + "        currentFilePath_";
  protected final String TEXT_134 = " = currentFilePath_";
  protected final String TEXT_135 = ".replaceAll(\"\\\\\\\\\", \"/\");" + NL + "        currentFileDirectory_";
  protected final String TEXT_136 = " = currentFileDirectory_";
  protected final String TEXT_137 = ".replaceAll(\"\\\\\\\\\", \"/\");";
  protected final String TEXT_138 = NL + "      " + NL + "      NB_FILE";
  protected final String TEXT_139 = " ++;" + NL + "      globalMap.put(\"";
  protected final String TEXT_140 = "_CURRENT_FILE\", currentFileName_";
  protected final String TEXT_141 = ");" + NL + "      globalMap.put(\"";
  protected final String TEXT_142 = "_CURRENT_FILEPATH\", currentFilePath_";
  protected final String TEXT_143 = ");" + NL + "      globalMap.put(\"";
  protected final String TEXT_144 = "_CURRENT_FILEDIRECTORY\", currentFileDirectory_";
  protected final String TEXT_145 = ");" + NL + "      globalMap.put(\"";
  protected final String TEXT_146 = "_CURRENT_FILEEXTENSION\", currentFileExtension_";
  protected final String TEXT_147 = ");" + NL + "      globalMap.put(\"";
  protected final String TEXT_148 = "_NB_FILE\", NB_FILE";
  protected final String TEXT_149 = "); ";
  protected final String TEXT_150 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
  CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
  INode node = (INode)codeGenArgument.getArgument();
  String cid = node.getUniqueName();
  boolean incldSubdir = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDSUBDIR__"));
  boolean ifexclude = ("true").equals(ElementParameterParser.getValue(node, "__IFEXCLUDE__"));
  String filelistType = ElementParameterParser.getValue(node, "__LIST_MODE__");
  boolean useGlob = ("true").equals(ElementParameterParser.getValue(node, "__GLOBEXPRESSIONS__"));
  List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");
  boolean toSlash = ("true").equals(ElementParameterParser.getValue(node, "__FORMAT_FILEPATH_TO_SLASH__"));
  boolean caseSensitive = ("YES").equals(ElementParameterParser.getValue(node, "__CASE_SENSITIVE__"));
  
  class codeGenerater{
    public void genFileNameOder(String _cid, String _suffix){
      if ("ASC".equals(_suffix)){
      
    stringBuffer.append(TEXT_1);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_2);
    
      } else if ("DESC".equals(_suffix)){
      
    stringBuffer.append(TEXT_3);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_4);
    
      }
    }
    
    public void genLastModifiedOder(String _cid, String _suffix){
      if ("ASC".equals(_suffix)){
      
    stringBuffer.append(TEXT_5);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_6);
    
      } else if ("DESC".equals(_suffix)){
      
    stringBuffer.append(TEXT_7);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_8);
    
      }
    }
    
    public void genFileSizeOder(String _cid, String _suffix){
      if ("ASC".equals(_suffix)){
      
    stringBuffer.append(TEXT_9);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_10);
    
      } else if ("DESC".equals(_suffix)){
      
    stringBuffer.append(TEXT_11);
    stringBuffer.append(_cid);
    stringBuffer.append(TEXT_12);
    
      }
    }
    public void addFiles(String cid,boolean useGlob,boolean caseSensitive,boolean ifexclude){
    
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    if (useGlob){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
		    }
		    if (caseSensitive){
		    
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
		    }else{
		    
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
            }
           
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    if (ifexclude){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    }else{
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    
    }
  }  
  
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DIRECTORY__") );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    
  if (files.size() == 0){
    if (useGlob){
    
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    
    } else{
    
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    
    }
  }
  
  for (int i = 0; i < files.size(); i++) {
    Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(caseSensitive );
    stringBuffer.append(TEXT_55);
    
    if (ifexclude){
    
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(ElementParameterParser.getValue(node, "__EXCLUDEFILEMASK__"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    if (useGlob){
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    }
	  	 	if (!caseSensitive){
	  	 
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    
			} else {
		 
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
			}
		 
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
    codeGenerater cg = new codeGenerater();
    if (incldSubdir) {
    
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
				if (("FILES").equals(filelistType)) {
				
    stringBuffer.append(TEXT_80);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_81);
    
				} else if(("DIRECTORIES").equals(filelistType)) {
				
    stringBuffer.append(TEXT_82);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_83);
    
				} else if(("BOTH").equals(filelistType)) {
				
    stringBuffer.append(TEXT_84);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_85);
    
				}
				
    stringBuffer.append(TEXT_86);
    
    } else {
    
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
              if (("FILES").equals(filelistType)) {
              
    stringBuffer.append(TEXT_89);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_90);
    
              } else if (("DIRECTORIES").equals(filelistType)) {
              
    stringBuffer.append(TEXT_91);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    stringBuffer.append(TEXT_92);
    
              } else if (("BOTH").equals(filelistType)) {
              
    stringBuffer.append(TEXT_93);
     cg.addFiles(cid,useGlob,caseSensitive,ifexclude); 
    
              }
              
    stringBuffer.append(TEXT_94);
    
    }
    
    stringBuffer.append(TEXT_95);
    
    boolean bOrdByDefault = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_NOTHING__"));
    boolean bOrdByFileName = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_FILENAME__"));
    boolean bOrdByFileSize = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_FILESIZE__"));
    boolean bOrdByModifiedTime = "true".equals(ElementParameterParser.getValue(node, "__ORDER_BY_MODIFIEDDATE__"));
    
    boolean bOrdASC = "true".equals(ElementParameterParser.getValue(node, "__ORDER_ACTION_ASC__"));
    //boolean bOrdDESC = "true".equals(ElementParameterParser.getValue(node, "__ORDER_ACTION_DESC__"));
    
    String suffix = bOrdASC ? "ASC" : "DESC";
    
    if (bOrdByDefault){
    
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    
    } else if (bOrdByFileName){
      cg.genFileNameOder(cid, suffix);
      
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(suffix);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    
    } else if (bOrdByFileSize){
      cg.genFileSizeOder(cid, suffix);
      
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(suffix);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
    } else if (bOrdByModifiedTime){
      cg.genLastModifiedOder(cid, suffix);
      
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(suffix);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    
    }
    
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    if (toSlash){
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    }
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    return stringBuffer.toString();
  }
}
