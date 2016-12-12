package uk.org.cinquin.final_annotation;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import com.sun.source.util.Trees;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;

@SupportedAnnotationTypes("uk.org.cinquin.final_annotation.Final")
public class FinalAnnotationProcessor extends AbstractProcessor {

	private Trees trees;
	private FinalTranslator visitor;

	@Override
	public void init(ProcessingEnvironment processingEnvironment) {
		this.processingEnv = processingEnvironment;
		JavacProcessingEnvironment javacProcessingEnvironment = (JavacProcessingEnvironment) processingEnvironment;
		this.trees = Trees.instance(processingEnvironment);
		TreeMaker treeMaker = TreeMaker.instance(javacProcessingEnvironment.getContext());
		visitor = new FinalTranslator(javacProcessingEnvironment, treeMaker);
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
		if (!roundEnvironment.processingOver()) {
			Set<? extends Element> elements = roundEnvironment.getRootElements();
			elements.forEach(element -> {
				JCTree tree = (JCTree) trees.getTree(element);
				tree.accept(visitor);
			});
		}
		return false;
	}

	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latest();
	}

}
