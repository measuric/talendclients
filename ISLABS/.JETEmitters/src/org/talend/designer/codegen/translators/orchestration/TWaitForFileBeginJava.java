package org.talend.designer.codegen.translators.orchestration;

import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TWaitForFileBeginJava
{
  protected static String nl;
  public static synchronized TWaitForFileBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWaitForFileBeginJava result = new TWaitForFileBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "       " + NL + "        class Util_";
  protected final String TEXT_2 = " {" + NL + "" + NL + "            private boolean flagt = false;" + NL + "" + NL + "            private java.util.regex.Pattern fileNamePatternt = null;" + NL + "        \tprivate java.util.List<String> list;" + NL + "\t\t\tpublic java.util.List<String> getFiles(){" + NL + "\t\t\t\tsetFiles();" + NL + "\t\t\t\treturn list;" + NL + "\t\t\t}";
  protected final String TEXT_3 = NL + "\t\t\tprivate java.util.Map<String, Long> originalTimeMap;" + NL + "\t\t\tprivate java.util.Map<String, String> originalContentMap;" + NL + "\t\t\tprivate boolean initMap = false;" + NL + "\t\t\tpublic Util_";
  protected final String TEXT_4 = "(){" + NL + "\t\t\t}" + NL + "\t\t\tpublic Util_";
  protected final String TEXT_5 = "(boolean iniMap){" + NL + "\t\t\t\tlist = new java.util.ArrayList<String>();" + NL + "\t\t\t\tif(iniMap){" + NL + "\t\t\t\t\tthis.initMap = true;" + NL + "\t\t\t\t\toriginalTimeMap = new java.util.HashMap<String, Long>();" + NL + "\t\t\t\t\toriginalContentMap = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tpublic void addFile(java.io.File file){" + NL + "\t\t\t\tlist.add(file.getPath());" + NL + "\t\t\t\tif(initMap){" + NL + "\t\t\t\t\toriginalTimeMap.put(file.getPath(), file.lastModified());" + NL + "\t\t\t\t\toriginalContentMap.put(file.getPath(),getFileChecksum(file));" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tpublic java.util.Map<String, Long> getTimeMap(){" + NL + "\t\t\t\treturn originalTimeMap;" + NL + "\t\t\t}" + NL + "\t\t\tpublic java.util.Map<String, String> getContentMap(){" + NL + "\t\t\t\treturn originalContentMap;" + NL + "\t\t\t}" + NL + "\t\t\tpublic String getFileChecksum(java.io.File file) {" + NL + "            \tString strMD5 = \"\";" + NL + "            \tjava.security.MessageDigest complete = null;" + NL + "            \tjava.io.InputStream fis = null;" + NL + "            \ttry{" + NL + "                    fis =  new java.io.FileInputStream(file);" + NL + "                    byte[] buffer = new byte[1024];" + NL + "                    complete = java.security.MessageDigest.getInstance(\"MD5\");" + NL + "                    int numRead;" + NL + "                    while((numRead = fis.read(buffer))!= -1){" + NL + "                      \tif (numRead > 0) {" + NL + "                        \tcomplete.update(buffer, 0, numRead);" + NL + "                        }" + NL + "                    }" + NL + "                } catch(java.lang.Exception ex) {" + NL + "                } finally {" + NL + "                \tif(fis != null) {" + NL + "                \t\ttry {" + NL + "                \t\t\tfis.close();" + NL + "                \t\t} catch(java.lang.Exception ex) {" + NL + "                \t\t}" + NL + "                \t}" + NL + "                }" + NL + "               \t" + NL + "               \tif(complete != null){" + NL + "        \t\t\tbyte[] b = complete.digest();" + NL + "         \t\t\tfor (int i = 0; i < b.length; i++) {" + NL + "          \t\t\t\tstrMD5 += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );" + NL + "          \t\t\t}" + NL + "      \t\t\t}" + NL + "        \t\treturn strMD5;" + NL + "            }";
  protected final String TEXT_6 = NL + "        \tpublic Util_";
  protected final String TEXT_7 = "(){" + NL + "\t\t\t\tthis.list = new java.util.ArrayList<String>();" + NL + "\t\t\t}" + NL + "\t\t\tpublic void addFile(java.io.File file){" + NL + "\t\t\t\tthis.list.add(file.getPath());" + NL + "\t\t\t}";
  protected final String TEXT_8 = NL + "            void setFiles() {" + NL + "                String directoryt = ";
  protected final String TEXT_9 = ";" + NL + "                String filemaskt = ";
  protected final String TEXT_10 = "+\"$\";" + NL + "" + NL + "                if (filemaskt.indexOf(\"^\") == -1) {" + NL + "                    filemaskt = \"^\" + filemaskt;" + NL + "                }" + NL + "                if (!(filemaskt.lastIndexOf(\".*$\") == -1) && filemaskt.lastIndexOf(\"*.*$\") == -1) {" + NL + "                    filemaskt = filemaskt.substring(0, filemaskt.length() - 3) + \"$\";" + NL + "                    flagt = true;" + NL + "                } else {" + NL + "                    filemaskt = java.util.regex.Pattern.compile(\"[*]\").matcher(filemaskt).replaceAll(\".*\");" + NL + "                }" + NL + "" + NL + "                boolean case_sensitivet = ";
  protected final String TEXT_11 = ";" + NL + "                fileNamePatternt = java.util.regex.Pattern.compile(filemaskt);" + NL + "                if (!case_sensitivet) {" + NL + "                    fileNamePatternt = java.util.regex.Pattern.compile(filemaskt, java.util.regex.Pattern.CASE_INSENSITIVE);" + NL + "                }" + NL + "                java.io.File filet = new java.io.File(directoryt);" + NL + "                filet.listFiles(new java.io.FilenameFilter() {" + NL + "" + NL + "                    public boolean accept(java.io.File dir, String name) {" + NL + "                        java.io.File file = new java.io.File(dir, name);" + NL + "                        if (file.isFile()) {" + NL + "                            String fileNamet = name;" + NL + "                            if (flagt == true) {" + NL + "                                if (!(fileNamet.indexOf(\".\") == -1)) {" + NL + "                                    if (fileNamePatternt.matcher(fileNamet.substring(0, fileNamet.indexOf(\".\"))).find()) {" + NL + "                                        addFile(file);" + NL + "" + NL + "                                    }" + NL + "                                } else {" + NL + "                                    if (fileNamePatternt.matcher(fileNamet).find()) {" + NL + "                                        addFile(file);" + NL + "                                    }" + NL + "                                }" + NL + "                            } else {" + NL + "                                if (fileNamePatternt.matcher(fileNamet).find()) {" + NL + "                                    addFile(file);" + NL + "                                }" + NL + "                            }" + NL + "" + NL + "                            return true;" + NL + "                        } ";
  protected final String TEXT_12 = "                          " + NL + "                            else {" + NL + "" + NL + "                                file.listFiles(this);" + NL + "                            }" + NL + "                      ";
  protected final String TEXT_13 = "                        " + NL + "                        return false;" + NL + "                    }" + NL + "" + NL + "                });" + NL + "" + NL + "            }";
  protected final String TEXT_14 = NL + "\t\t\tjava.util.List<java.io.File> getCreatedFiles(java.util.List<String> originalFiles, java.util.List<String> fetchOneTimeFiles) {" + NL + "\t\t\t\tjava.util.List<java.io.File> newCreatedFiles = new java.util.ArrayList<java.io.File>();" + NL + "\t\t\t\tString [] array = originalFiles.toArray(new String[]{});" + NL + "\t\t\t\tfor(String file: fetchOneTimeFiles){" + NL + "\t\t\t\t\tint index = java.util.Arrays.binarySearch(array, file);" + NL + "\t\t\t\t\tif(index<0){" + NL + "\t\t\t\t\t\tnewCreatedFiles.add(new java.io.File(file));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn newCreatedFiles;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "        }" + NL + "            " + NL + "        Util_";
  protected final String TEXT_16 = " util_";
  protected final String TEXT_17 = " = new Util_";
  protected final String TEXT_18 = "(";
  protected final String TEXT_19 = "true";
  protected final String TEXT_20 = ");" + NL + "        java.util.List<String> originalFiles_";
  protected final String TEXT_21 = " = util_";
  protected final String TEXT_22 = ".getFiles();            ";
  protected final String TEXT_23 = NL + "            java.util.Map<String,Long> originalMap_";
  protected final String TEXT_24 = " = util_";
  protected final String TEXT_25 = ".getTimeMap();" + NL + "            java.util.Map<String,String> originalContentMap_";
  protected final String TEXT_26 = " = util_";
  protected final String TEXT_27 = ".getContentMap();";
  protected final String TEXT_28 = NL + "      " + NL + "        int count_";
  protected final String TEXT_29 = " = 0;" + NL + "        ";
  protected final String TEXT_30 = NL + "        String osName_";
  protected final String TEXT_31 = " = System.getProperty(\"os.name\");" + NL + "        boolean isWindows_";
  protected final String TEXT_32 = " = osName_";
  protected final String TEXT_33 = " != null && osName_";
  protected final String TEXT_34 = ".toLowerCase().startsWith(\"win\");";
  protected final String TEXT_35 = NL + "        " + NL + "        while (true) {";
  protected final String TEXT_36 = "                " + NL + "                if (count_";
  protected final String TEXT_37 = " == ";
  protected final String TEXT_38 = " ) {" + NL + "                    break;" + NL + "                }";
  protected final String TEXT_39 = "                " + NL + "            boolean found_";
  protected final String TEXT_40 = " = false;";
  protected final String TEXT_41 = "              " + NL + "    \t\t\tif( count_";
  protected final String TEXT_42 = " < originalFiles_";
  protected final String TEXT_43 = ".size()) {" + NL + "                    java.io.File file_";
  protected final String TEXT_44 = " = new java.io.File(originalFiles_";
  protected final String TEXT_45 = ".get(count_";
  protected final String TEXT_46 = "));" + NL + "                    globalMap.put(\"";
  protected final String TEXT_47 = "_FILENAME\", file_";
  protected final String TEXT_48 = ".getName());" + NL + "                    globalMap.put(\"";
  protected final String TEXT_49 = "_PRESENT_FILE\", file_";
  protected final String TEXT_50 = ".getAbsolutePath());" + NL + "                    found_";
  protected final String TEXT_51 = " = true;" + NL + "    \t\t\t} else {" + NL + "\t\t\t    ";
  protected final String TEXT_52 = NL + "\t\t\tutil_";
  protected final String TEXT_53 = " = new Util_";
  protected final String TEXT_54 = "(";
  protected final String TEXT_55 = "false";
  protected final String TEXT_56 = ");" + NL + "\t\t\t" + NL + "            java.util.List<String> fetchFilesOneTime_";
  protected final String TEXT_57 = " = util_";
  protected final String TEXT_58 = ".getFiles();" + NL + "            util_";
  protected final String TEXT_59 = " = new Util_";
  protected final String TEXT_60 = "();";
  protected final String TEXT_61 = NL + "\t\t\t\tjava.util.Collections.sort(originalFiles_";
  protected final String TEXT_62 = ");" + NL + "                java.util.List<java.io.File> newCreatedFiles_";
  protected final String TEXT_63 = " = util_";
  protected final String TEXT_64 = ".getCreatedFiles(originalFiles_";
  protected final String TEXT_65 = ",fetchFilesOneTime_";
  protected final String TEXT_66 = ");" + NL + "" + NL + "               \tfor ( int i=0; i< newCreatedFiles_";
  protected final String TEXT_67 = ".size(); i++) {" + NL + "\t\t\t\t\tjava.io.File file_";
  protected final String TEXT_68 = " = newCreatedFiles_";
  protected final String TEXT_69 = ".get(i);" + NL + "           \t\t\t";
  protected final String TEXT_70 = NL + "\t  \t\t\t\tif (isWindows_";
  protected final String TEXT_71 = "){" + NL + "\t  \t\t\t\t\tjava.io.File tempfile_";
  protected final String TEXT_72 = " =new java.io.File(file_";
  protected final String TEXT_73 = ".getAbsolutePath()+\".talendTempfile\"); " + NL + "\t  \t\t\t\t\tThread.sleep(";
  protected final String TEXT_74 = ");" + NL + "\t  \t\t\t\t\tif(file_";
  protected final String TEXT_75 = ".renameTo(tempfile_";
  protected final String TEXT_76 = ")) {" + NL + "\t  \t\t\t\t\t\ttempfile_";
  protected final String TEXT_77 = ".renameTo(file_";
  protected final String TEXT_78 = "); " + NL + "\t  \t\t\t\t\t} else {" + NL + "\t  \t\t\t\t\t\tcontinue;" + NL + "\t  \t\t\t\t\t}" + NL + "\t  \t\t\t\t} else { " + NL + "\t\t\t\t\t\tlong timestamp_";
  protected final String TEXT_79 = " = file_";
  protected final String TEXT_80 = ".lastModified();" + NL + "\t" + NL + "\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_81 = ");" + NL + "\t" + NL + "\t                \tif(file_";
  protected final String TEXT_82 = ".lastModified() != timestamp_";
  protected final String TEXT_83 = "){" + NL + "\t                \t\tcontinue;" + NL + "\t                \t}" + NL + "\t                }" + NL + "            \t\t";
  protected final String TEXT_84 = NL + "                    globalMap.put(\"";
  protected final String TEXT_85 = "_FILENAME\", file_";
  protected final String TEXT_86 = ".getName());" + NL + "                    globalMap.put(\"";
  protected final String TEXT_87 = "_CREATED_FILE\", file_";
  protected final String TEXT_88 = ".getAbsolutePath());" + NL + "                    found_";
  protected final String TEXT_89 = " = true;" + NL + "                    originalFiles_";
  protected final String TEXT_90 = ".add(file_";
  protected final String TEXT_91 = ".getPath());              " + NL + "                    break;" + NL + "            \t}" + NL + "\t\t\t";
  protected final String TEXT_92 = NL + "            \tjava.util.Collections.sort(fetchFilesOneTime_";
  protected final String TEXT_93 = ");" + NL + "            \tString [] arrayFetchFilesOneTime_";
  protected final String TEXT_94 = " = fetchFilesOneTime_";
  protected final String TEXT_95 = ".toArray(new String[]{});" + NL + "            \tfor(String str_";
  protected final String TEXT_96 = " : originalFiles_";
  protected final String TEXT_97 = ") {" + NL + "            \t\tint index_delete_";
  protected final String TEXT_98 = " = java.util.Arrays.binarySearch(arrayFetchFilesOneTime_";
  protected final String TEXT_99 = ",str_";
  protected final String TEXT_100 = ");" + NL + "                    if(index_delete_";
  protected final String TEXT_101 = " < 0) {" + NL + "\t            \t\tjava.io.File file_";
  protected final String TEXT_102 = " = new java.io.File(str_";
  protected final String TEXT_103 = ");" + NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_104 = "_FILENAME\", file_";
  protected final String TEXT_105 = ".getName());" + NL + "                        globalMap.put(\"";
  protected final String TEXT_106 = "_DELETED_FILE\", file_";
  protected final String TEXT_107 = ".getAbsolutePath());" + NL + "                        found_";
  protected final String TEXT_108 = " = true;  " + NL + "                        originalFiles_";
  protected final String TEXT_109 = ".remove(str_";
  protected final String TEXT_110 = ");                  " + NL + "                        break;" + NL + "                    }" + NL + "                }";
  protected final String TEXT_111 = NL + "                for(String str_";
  protected final String TEXT_112 = " : fetchFilesOneTime_";
  protected final String TEXT_113 = ") {" + NL + "                \tjava.io.File file_";
  protected final String TEXT_114 = " = new java.io.File(str_";
  protected final String TEXT_115 = ");" + NL + "                \t" + NL + "            \t";
  protected final String TEXT_116 = NL + "\t\t\t\t\tif (isWindows_";
  protected final String TEXT_117 = "){" + NL + "\t\t\t\t\t\tjava.io.File tempfile_";
  protected final String TEXT_118 = " =new java.io.File(file_";
  protected final String TEXT_119 = ".getAbsolutePath()+\".talendTempfile\");" + NL + "\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_120 = ");" + NL + "\t\t\t\t\t\tif(file_";
  protected final String TEXT_121 = ".renameTo(tempfile_";
  protected final String TEXT_122 = ")) {" + NL + "\t  \t\t\t\t\t\ttempfile_";
  protected final String TEXT_123 = ".renameTo(file_";
  protected final String TEXT_124 = "); " + NL + "\t  \t\t\t\t\t} else {" + NL + "\t  \t\t\t\t\t\tcontinue;" + NL + "\t  \t\t\t\t\t}" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tlong timestamp_";
  protected final String TEXT_125 = " = file_";
  protected final String TEXT_126 = ".lastModified();" + NL + "\t" + NL + "\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_127 = ");" + NL + "\t" + NL + "\t                \tif(file_";
  protected final String TEXT_128 = ".lastModified() != timestamp_";
  protected final String TEXT_129 = "){" + NL + "\t                \t\tcontinue;" + NL + "\t                \t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_130 = NL + "\t\t\t\t";
  protected final String TEXT_131 = NL + "\t\t\t\t\tif(originalMap_";
  protected final String TEXT_132 = ".get(str_";
  protected final String TEXT_133 = ")==null ){" + NL + "                    \toriginalMap_";
  protected final String TEXT_134 = ".put(str_";
  protected final String TEXT_135 = ",file_";
  protected final String TEXT_136 = ".lastModified());" + NL + "                    \toriginalContentMap_";
  protected final String TEXT_137 = ".put(str_";
  protected final String TEXT_138 = ",util_";
  protected final String TEXT_139 = ".getFileChecksum(file_";
  protected final String TEXT_140 = "));" + NL + "\t\t\t\t\t} else if(originalMap_";
  protected final String TEXT_141 = ".get(str_";
  protected final String TEXT_142 = ")!=file_";
  protected final String TEXT_143 = ".lastModified()) {" + NL + "                        originalMap_";
  protected final String TEXT_144 = ".put(str_";
  protected final String TEXT_145 = ",file_";
  protected final String TEXT_146 = ".lastModified());" + NL + "                        String fileMD5_";
  protected final String TEXT_147 = " = util_";
  protected final String TEXT_148 = ".getFileChecksum(file_";
  protected final String TEXT_149 = ");" + NL + "\t\t\t\t\t\tif(!fileMD5_";
  protected final String TEXT_150 = ".equals(originalContentMap_";
  protected final String TEXT_151 = ".get(str_";
  protected final String TEXT_152 = "))){" + NL + "\t                    \tglobalMap.put(\"";
  protected final String TEXT_153 = "_FILENAME\", file_";
  protected final String TEXT_154 = ".getName());" + NL + "\t                        globalMap.put(\"";
  protected final String TEXT_155 = "_UPDATED_FILE\", file_";
  protected final String TEXT_156 = ".getAbsolutePath());" + NL + "\t                       \tfound_";
  protected final String TEXT_157 = " = true;" + NL + "\t                        originalContentMap_";
  protected final String TEXT_158 = ".put(str_";
  protected final String TEXT_159 = ",fileMD5_";
  protected final String TEXT_160 = ");" + NL + "\t                        break;" + NL + "\t\t\t\t\t\t}" + NL + "                    }" + NL + "            \t";
  protected final String TEXT_161 = NL + "\t\t\t\t\tif(originalMap_";
  protected final String TEXT_162 = ".get(str_";
  protected final String TEXT_163 = ")==null ){" + NL + "                    \toriginalMap_";
  protected final String TEXT_164 = ".put(str_";
  protected final String TEXT_165 = ",file_";
  protected final String TEXT_166 = ".lastModified());" + NL + "                    \toriginalContentMap_";
  protected final String TEXT_167 = ".put(str_";
  protected final String TEXT_168 = ",util_";
  protected final String TEXT_169 = ".getFileChecksum(file_";
  protected final String TEXT_170 = "));" + NL + "\t\t\t\t\t} else if(originalMap_";
  protected final String TEXT_171 = ".get(str_";
  protected final String TEXT_172 = ")!=file_";
  protected final String TEXT_173 = ".lastModified()) {" + NL + "            \t\t\toriginalMap_";
  protected final String TEXT_174 = ".put(str_";
  protected final String TEXT_175 = ",file_";
  protected final String TEXT_176 = ".lastModified());" + NL + "\t            \t\tString fileMD5_";
  protected final String TEXT_177 = " = util_";
  protected final String TEXT_178 = ".getFileChecksum(file_";
  protected final String TEXT_179 = ");" + NL + "            \t\t\tif(!fileMD5_";
  protected final String TEXT_180 = ".equals(originalContentMap_";
  protected final String TEXT_181 = ".get(str_";
  protected final String TEXT_182 = "))){" + NL + "\t\t\t\t\t\t\toriginalContentMap_";
  protected final String TEXT_183 = ".put(str_";
  protected final String TEXT_184 = ",fileMD5_";
  protected final String TEXT_185 = ");" + NL + "\t            \t\t\tglobalMap.put(\"";
  protected final String TEXT_186 = "_NOT_UPDATED_FILE\", null);" + NL + "\t            \t\t\tfound_";
  protected final String TEXT_187 = " = false;" + NL + "            \t\t\t}else{" + NL + "\t                    \tglobalMap.put(\"";
  protected final String TEXT_188 = "_FILENAME\", file_";
  protected final String TEXT_189 = ".getName());" + NL + "\t                    \tglobalMap.put(\"";
  protected final String TEXT_190 = "_NOT_UPDATED_FILE\", file_";
  protected final String TEXT_191 = ".getAbsolutePath());" + NL + "\t                    \tfound_";
  protected final String TEXT_192 = " = true;" + NL + "\t                    \tbreak;" + NL + "                    \t}" + NL + "                   \t}else{                   " + NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_193 = "_FILENAME\", file_";
  protected final String TEXT_194 = ".getName());" + NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_195 = "_NOT_UPDATED_FILE\", file_";
  protected final String TEXT_196 = ".getAbsolutePath());" + NL + "                    \tfound_";
  protected final String TEXT_197 = " = true;" + NL + "                    \tbreak;" + NL + "                    }";
  protected final String TEXT_198 = NL + "                }    " + NL + "                ";
  protected final String TEXT_199 = NL + "                java.util.Collections.sort(originalFiles_";
  protected final String TEXT_200 = ");" + NL + "                java.util.Collections.sort(fetchFilesOneTime_";
  protected final String TEXT_201 = ");" + NL + "                String [] arrayFetchFilesOneTime_";
  protected final String TEXT_202 = " = fetchFilesOneTime_";
  protected final String TEXT_203 = ".toArray(new String[]{});" + NL + "                for(String str_";
  protected final String TEXT_204 = " : originalFiles_";
  protected final String TEXT_205 = ") {" + NL + "                \tint index_fileall_";
  protected final String TEXT_206 = " = java.util.Arrays.binarySearch(arrayFetchFilesOneTime_";
  protected final String TEXT_207 = ",str_";
  protected final String TEXT_208 = ");" + NL + "                    if(index_fileall_";
  protected final String TEXT_209 = " < 0 ) {" + NL + "\t                \tjava.io.File file_";
  protected final String TEXT_210 = " = new java.io.File(str_";
  protected final String TEXT_211 = ");" + NL + "                    \tglobalMap.put(\"";
  protected final String TEXT_212 = "_FILENAME\", file_";
  protected final String TEXT_213 = ".getName());" + NL + "                        globalMap.put(\"";
  protected final String TEXT_214 = "_DELETED_FILE\", file_";
  protected final String TEXT_215 = ".getAbsolutePath());" + NL + "                        found_";
  protected final String TEXT_216 = " = true;" + NL + "                        originalFiles_";
  protected final String TEXT_217 = ".remove(str_";
  protected final String TEXT_218 = ");" + NL + "                        originalMap_";
  protected final String TEXT_219 = ".remove(str_";
  protected final String TEXT_220 = ");" + NL + "                    \toriginalContentMap_";
  protected final String TEXT_221 = ".remove(str_";
  protected final String TEXT_222 = ");" + NL + "                        break;" + NL + "                    }" + NL + "                }" + NL + "                java.util.List<java.io.File> newCreatedFiles_";
  protected final String TEXT_223 = " = util_";
  protected final String TEXT_224 = ".getCreatedFiles(originalFiles_";
  protected final String TEXT_225 = ",fetchFilesOneTime_";
  protected final String TEXT_226 = ");" + NL + "                for ( int i=0; i< newCreatedFiles_";
  protected final String TEXT_227 = ".size(); i++) {" + NL + "\t\t\t\t\tjava.io.File file_";
  protected final String TEXT_228 = " = newCreatedFiles_";
  protected final String TEXT_229 = ".get(i);" + NL + "           \t\t\t";
  protected final String TEXT_230 = NL + "\t  \t\t\t\tif (isWindows_";
  protected final String TEXT_231 = "){" + NL + "\t  \t\t\t\t\tjava.io.File tempfile=new java.io.File(file_";
  protected final String TEXT_232 = ".getAbsolutePath()+\".talendTempfile\"); " + NL + "\t  \t\t\t\t\tThread.sleep(";
  protected final String TEXT_233 = ");" + NL + "\t  \t\t\t\t\tif(file_";
  protected final String TEXT_234 = ".renameTo(tempfile)) {" + NL + "\t  \t\t\t\t\t\ttempfile.renameTo(file_";
  protected final String TEXT_235 = "); " + NL + "\t  \t\t\t\t\t} else {" + NL + "\t  \t\t\t\t\t\tcontinue;" + NL + "\t  \t\t\t\t\t}" + NL + "\t  \t\t\t\t} else { " + NL + "\t\t\t\t\t\tlong timestamp_";
  protected final String TEXT_236 = " = file_";
  protected final String TEXT_237 = ".lastModified();" + NL + "\t" + NL + "\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_238 = ");" + NL + "\t" + NL + "\t                \tif(file_";
  protected final String TEXT_239 = ".lastModified() != timestamp_";
  protected final String TEXT_240 = "){" + NL + "\t                \t\tcontinue;" + NL + "\t                \t}" + NL + "\t                }";
  protected final String TEXT_241 = NL + "                    globalMap.put(\"";
  protected final String TEXT_242 = "_FILENAME\", file_";
  protected final String TEXT_243 = ".getName());" + NL + "                    globalMap.put(\"";
  protected final String TEXT_244 = "_CREATED_FILE\", file_";
  protected final String TEXT_245 = ".getAbsolutePath());" + NL + "                    found_";
  protected final String TEXT_246 = " = true;" + NL + "                    originalFiles_";
  protected final String TEXT_247 = ".add(file_";
  protected final String TEXT_248 = ".getPath());           " + NL + "                    originalMap_";
  protected final String TEXT_249 = ".put(file_";
  protected final String TEXT_250 = ".getPath(),file_";
  protected final String TEXT_251 = ".lastModified());" + NL + "                    originalContentMap_";
  protected final String TEXT_252 = ".put(file_";
  protected final String TEXT_253 = ".getPath(),util_";
  protected final String TEXT_254 = ".getFileChecksum(file_";
  protected final String TEXT_255 = "));" + NL + "                    break;" + NL + "\t\t\t\t}" + NL + "                for(String str_";
  protected final String TEXT_256 = " : fetchFilesOneTime_";
  protected final String TEXT_257 = ") {" + NL + "                \tjava.io.File file_";
  protected final String TEXT_258 = " = new java.io.File(str_";
  protected final String TEXT_259 = ");" + NL + "                \t" + NL + "\t\t\t\t\t";
  protected final String TEXT_260 = NL + "\t\t\t\t\tif (isWindows_";
  protected final String TEXT_261 = "){" + NL + "\t\t\t\t\t\tjava.io.File tempfile_";
  protected final String TEXT_262 = " =new java.io.File(file_";
  protected final String TEXT_263 = ".getAbsolutePath()+\".talendTempfile\");" + NL + "\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_264 = ");" + NL + "\t\t\t\t\t\tif(file_";
  protected final String TEXT_265 = ".renameTo(tempfile_";
  protected final String TEXT_266 = ")) {" + NL + "\t  \t\t\t\t\t\ttempfile_";
  protected final String TEXT_267 = ".renameTo(file_";
  protected final String TEXT_268 = "); " + NL + "\t  \t\t\t\t\t} else {" + NL + "\t  \t\t\t\t\t\tcontinue;" + NL + "\t  \t\t\t\t\t}" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tlong timestamp_";
  protected final String TEXT_269 = " = file_";
  protected final String TEXT_270 = ".lastModified();" + NL + "\t" + NL + "\t\t\t\t\t\tThread.sleep(";
  protected final String TEXT_271 = ");" + NL + "\t" + NL + "\t                \tif(file_";
  protected final String TEXT_272 = ".lastModified() != timestamp_";
  protected final String TEXT_273 = "){" + NL + "\t                \t\tcontinue;" + NL + "\t                \t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_274 = NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tif(originalMap_";
  protected final String TEXT_275 = ".get(str_";
  protected final String TEXT_276 = ")==null ){" + NL + "                    \toriginalMap_";
  protected final String TEXT_277 = ".put(str_";
  protected final String TEXT_278 = ",file_";
  protected final String TEXT_279 = ".lastModified());" + NL + "                    \toriginalContentMap_";
  protected final String TEXT_280 = ".put(str_";
  protected final String TEXT_281 = ",util_";
  protected final String TEXT_282 = ".getFileChecksum(file_";
  protected final String TEXT_283 = "));" + NL + "\t\t\t\t\t} else if(originalMap_";
  protected final String TEXT_284 = ".get(str_";
  protected final String TEXT_285 = ")!=file_";
  protected final String TEXT_286 = ".lastModified()) {" + NL + "                        originalMap_";
  protected final String TEXT_287 = ".put(str_";
  protected final String TEXT_288 = ",file_";
  protected final String TEXT_289 = ".lastModified());//occur repeat value              " + NL + "                        String fileMD5_";
  protected final String TEXT_290 = " = util_";
  protected final String TEXT_291 = ".getFileChecksum(file_";
  protected final String TEXT_292 = ");" + NL + "                        if(!fileMD5_";
  protected final String TEXT_293 = ".equals(originalContentMap_";
  protected final String TEXT_294 = ".get(str_";
  protected final String TEXT_295 = "))){" + NL + "                        \toriginalContentMap_";
  protected final String TEXT_296 = ".put(str_";
  protected final String TEXT_297 = ",fileMD5_";
  protected final String TEXT_298 = ");" + NL + "\t                    \tglobalMap.put(\"";
  protected final String TEXT_299 = "_FILENAME\", file_";
  protected final String TEXT_300 = ".getName());" + NL + "\t                        globalMap.put(\"";
  protected final String TEXT_301 = "_UPDATED_FILE\", file_";
  protected final String TEXT_302 = ".getAbsolutePath());" + NL + "\t                        found_";
  protected final String TEXT_303 = " = true;" + NL + "\t                        break;" + NL + "                        }" + NL + "                    }" + NL + "                }               ";
  protected final String TEXT_304 = NL;
  protected final String TEXT_305 = "   " + NL + "                }";
  protected final String TEXT_306 = NL + "            count_";
  protected final String TEXT_307 = "++;" + NL + "            " + NL + "            globalMap.put(\"";
  protected final String TEXT_308 = "_CURRENT_ITERATION\", count_";
  protected final String TEXT_309 = ");" + NL + "            " + NL + "            if (!found_";
  protected final String TEXT_310 = ") {" + NL + "            \tThread.sleep(";
  protected final String TEXT_311 = " * 1000);" + NL + "                continue;" + NL + "            }            " + NL;
  protected final String TEXT_312 = "\t" + NL + "\t\t";
  protected final String TEXT_313 = ".";
  protected final String TEXT_314 = " = ((";
  protected final String TEXT_315 = ")globalMap.get(\"";
  protected final String TEXT_316 = "_";
  protected final String TEXT_317 = "\"));";
  protected final String TEXT_318 = "            ";
  protected final String TEXT_319 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();
    boolean incldSubdir = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDE_SUBDIR__"));
    boolean present = ("true").equals(ElementParameterParser.getValue(node, "__INCLUDE_PRESENT__"));
    String triggerAction = ElementParameterParser.getValue(node, "__ACTION_ON__");
    boolean waitRelease = ("true").equals(ElementParameterParser.getValue(node, "__WAIT_RELEASE__"));
    boolean nonUpdate = "true".equals(ElementParameterParser.getValue(node, "__NON_UPDATE__"));
    String interval = ElementParameterParser.getValue(node, "__INTERVAL_CHECK__");

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    
        if(("fileupdated").equals(triggerAction) || ("fileall").equals(triggerAction)) {
        
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    
        }else{
        
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    
        }
        
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ElementParameterParser.getValue(node, "__DIRECTORY__") );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FILEMASK__"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CASE_SENSITIVE__") );
    stringBuffer.append(TEXT_11);
    
                        if(incldSubdir==true)  {
                            
    stringBuffer.append(TEXT_12);
    
                        }   
                        
    stringBuffer.append(TEXT_13);
    
			if(("filecreated").equals(triggerAction) || ("fileall").equals(triggerAction)) {

    stringBuffer.append(TEXT_14);
    
			}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    if(("fileupdated").equals(triggerAction) || ("fileall").equals(triggerAction)) {
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
        if(("fileupdated").equals(triggerAction) || ("fileall").equals(triggerAction)) {
            
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    
        }
        
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    if(waitRelease) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    
            if(!("").equals(ElementParameterParser.getValue(node,"__MAX_ITERATIONS__"))){
                
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MAX_ITERATIONS__") );
    stringBuffer.append(TEXT_38);
    
            } 
            
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
            if(present){
                
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    
    			}
			
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    if(("fileupdated").equals(triggerAction) || ("fileall").equals(triggerAction)) {
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    
            if(("filecreated").equals(triggerAction)) {
            
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    	
   					//fix bug 22123,if we can rename the filename,that means no other program is using the file.
           			if(waitRelease){
           			
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
            		}
            		
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_91);
    
            } else if(("filedeleted").equals(triggerAction)) {
            
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    
            } else if(("fileupdated").equals(triggerAction)) {
                
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    if(waitRelease) {
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    if(!nonUpdate){
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    }else{
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    }
    stringBuffer.append(TEXT_198);
    
            } else if(("fileall").equals(triggerAction)) {
                
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    	
   					//fix bug 22123,if we can rename the filename,that means no other program is using the file.
           			if(waitRelease) {
           			
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_237);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    
        	    	}
            		
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    if(waitRelease) {
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(interval);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    }
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    
            }
            
    stringBuffer.append(TEXT_304);
    
            if(present) {
                
    stringBuffer.append(TEXT_305);
    
            }
            
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(ElementParameterParser.getValue(node, "__WAIT__"));
    stringBuffer.append(TEXT_311);
    	
	//*************************************************************//	
	//The following part will extract data from globalMap to schema in order to support the MAIN link simply.
	//step 1:
	
	IConnection firstDataConn = null;
	List<IMetadataColumn> firstColumnList = null;

	//1. get first DATA Link
	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();	
	if(conns != null && conns.size() > 0){
		for(IConnection conn : conns){
			if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
				firstDataConn = conn;
				break;
			}
		}
	}

	//2. get first columnList (with real columns data) 	
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ( metadatas != null && metadatas.size() > 0 ) {
		IMetadataTable metadata = metadatas.get(0);
		if(metadata != null){
			firstColumnList = metadata.getListColumns(); 
			if ( firstColumnList == null || firstColumnList.size() == 0 ) {
				firstColumnList = null;
			}
		}
	}
	
	//3. check the config Link and Schema
	if(firstDataConn != null && firstColumnList != null)
	{
    	//step 2:
    
        String firstDataConnName = firstDataConn.getName();
        for (IMetadataColumn column: firstColumnList) {
        	String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());

    stringBuffer.append(TEXT_312);
    stringBuffer.append(firstDataConnName );
    stringBuffer.append(TEXT_313);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_317);
    
	    }
 	}

    stringBuffer.append(TEXT_318);
    stringBuffer.append(TEXT_319);
    return stringBuffer.toString();
  }
}
