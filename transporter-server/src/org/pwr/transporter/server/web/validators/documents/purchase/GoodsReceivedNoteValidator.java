package org.pwr.transporter.server.web.validators.documents.purchase;


import org.pwr.transporter.entity.purchase.GoodsReceivedNote;
import org.pwr.transporter.entity.purchase.GoodsReceivedNoteRow;
import org.pwr.transporter.server.web.validators.documents.GenericDocumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 * <pre>
 *     Validate {@link GoodsReceivedNote}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GoodsReceivedNoteValidator implements Validator {

    private String prefix;

    @Autowired
    GenericDocumentValidator genericDocumentValidator;

    @Autowired
    GoodsReceivedNoteRowValidator goodsReceivedNoteRowValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(GoodsReceivedNote.class);
    }


    public GoodsReceivedNoteValidator(String prefix) {
        this.prefix = prefix;
    }


    public GoodsReceivedNoteValidator() {
        prefix = "";
    }


    @Override
    public void validate(Object obj, Errors errors) {

        genericDocumentValidator.validate(obj, errors);

        GoodsReceivedNote ent = (GoodsReceivedNote) obj;
        for( GoodsReceivedNoteRow row : ent.getRows() ) {
            goodsReceivedNoteRowValidator.validate(row, errors);
        }
        // TODO
    }

}
