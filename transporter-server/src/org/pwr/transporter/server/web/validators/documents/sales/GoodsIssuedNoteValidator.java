package org.pwr.transporter.server.web.validators.documents.sales;


import org.pwr.transporter.entity.sales.GoodsIssuedNote;
import org.pwr.transporter.entity.sales.GoodsIssuedNoteRow;
import org.pwr.transporter.server.web.validators.documents.GenericDocumentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



/**
 * <pre>
 *     Validate {@link GoodsIssuedNote}
 * </pre>
 * <hr/>
 * 
 * @author W.S.
 * @version 0.0.1
 */
public class GoodsIssuedNoteValidator implements Validator {

    private String prefix;

    @Autowired
    GenericDocumentValidator genericDocumentValidator;

    @Autowired
    GoodsIssuedNoteRowValidator goodsIssuedNoteRowValidator;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(GoodsIssuedNote.class);
    }


    public GoodsIssuedNoteValidator() {
        prefix = "";
    }


    public GoodsIssuedNoteValidator(String prefix) {
        this.prefix = prefix;
    }


    @Override
    public void validate(Object obj, Errors errors) {

        genericDocumentValidator.validate(obj, errors);

        GoodsIssuedNote ent = (GoodsIssuedNote) obj;
        for( GoodsIssuedNoteRow row : ent.getRows() ) {
            goodsIssuedNoteRowValidator.validate(row, errors);
        }
        // TODO
    }

}
