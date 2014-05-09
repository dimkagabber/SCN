package com.equalize.xpi.esr.mapping;

import java.util.ArrayList;

import org.w3c.dom.Document;

import com.sap.aii.mapping.api.StreamTransformationException;

public abstract class AbstractPlain2DOM extends AbstractMappingBase {

	@Override
	protected void executeMappingSteps() throws StreamTransformationException {
		try {
			ArrayList<String> inputContents = parsePlainInput(input.getInputPayload().getInputStream());
			Document outputDoc = getDocumentBuilder().newDocument();

			generateOutput(inputContents, outputDoc);	
			transformDocumentToStream(outputDoc, output.getOutputPayload().getOutputStream(), indentOutputXML);

		} catch (Exception e) {
			trace.addInfo(e.getMessage());
			throw new StreamTransformationException("Mapping Exception: " + e.getMessage(), e);
		}
	}

	protected abstract void generateOutput (ArrayList<String> inContents, Document outDoc);
}
