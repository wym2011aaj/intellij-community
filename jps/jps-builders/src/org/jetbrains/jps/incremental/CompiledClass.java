package org.jetbrains.jps.incremental;

import com.intellij.openapi.util.io.FileUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jps.javac.BinaryContent;

import java.io.File;

/**
 * @author Eugene Zhuravlev
 *         Date: 11/18/12
 */
public class CompiledClass {
  @NotNull
  private final File myOutputFile;
  @NotNull
  private final File mySourceFile;
  @Nullable
  private final String myClassName;
  @NotNull
  private BinaryContent myContent;

  public CompiledClass(@NotNull File outputFile, @NotNull File sourceFile, @Nullable String className, @NotNull BinaryContent content) {
    myOutputFile = outputFile;
    mySourceFile = sourceFile;
    myClassName = className;
    myContent = content;
  }

  @NotNull
  public File getOutputFile() {
    return myOutputFile;
  }

  @NotNull
  public File getSourceFile() {
    return mySourceFile;
  }

  @Nullable
  public String getClassName() {
    return myClassName;
  }

  @NotNull
  public BinaryContent getContent() {
    return myContent;
  }

  public void setContent(@NotNull BinaryContent content) {
    myContent = content;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CompiledClass aClass = (CompiledClass)o;

    if (!FileUtil.filesEqual(myOutputFile, aClass.myOutputFile)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return FileUtil.fileHashCode(myOutputFile);
  }
}