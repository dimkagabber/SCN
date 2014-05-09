package com.equalize.xpi.esr.mapping;

import org.w3c.dom.Document;

import com.sap.aii.mapping.api.StreamTransformationException;

public abstract class AbstractDOM2DOM extends AbstractMappingBase{
	protected void executeMappingSteps() throws StreamTransformationException {
		try {
			Document inputDoc = parseInputXML(input.getInputPayload().getInputStream());
			Document outputDoc = getDocumentBuilder().newDocument();

			generateOutput(inputDoc, outputDoc);
			transformDocumentToStream(outputDoc, output.getOutputPayload().getOutputStream(), indentOutputXML);

		} catch (Exception e) {
			trace.addInfo(e.getMessage());
			throw new StreamTransformationException("Mapping Exception: " + e.getMessage(), e);
		}
	}

	protected abstract void generateOutput (Document inDoc, Document outDoc);
}
