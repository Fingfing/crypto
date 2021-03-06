// -----BEGIN DISCLAIMER-----
/*******************************************************************************
 * Copyright (c) 2011 JCrypTool Team and Contributors
 *
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
// -----END DISCLAIMER-----
package org.jcryptool.visual.he.wizards;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.jcryptool.visual.he.Messages;
import org.jcryptool.visual.he.rsa.RSAData;

/**
 * page for saving a keypair.
 *
 * @author Michael Gaber
 */
public class RSASaveKeypairPage extends RSASaveWizardPage {

    /** minimal height for a textfield so it diesn't cut the entered text. */
    private static final int TEXTFIELD_MIN_HEIGHT = 15;

    /** unique pagename to get this page from inside a wizard. */
    private static final String PAGENAME = "Save Keypair Page"; //$NON-NLS-1$

    /** title of this page, displayed in the head of the wizard. */
    private static final String TITLE = Messages.RSASaveKeypairPage_save_keypair_text;

    /** field for the password. */
    private Text password;

    /** password verification field. */
    private Text passwordverify;

    /** modifyListener for the fields. */
    private final ModifyListener ml = new ModifyListener() {

        public void modifyText(final ModifyEvent e) {
            final boolean pwmatch = password.getText().equals(passwordverify.getText());
            setPageComplete(!owner.getText().equals("") && !password.getText().equals("") //$NON-NLS-1$ //$NON-NLS-2$
                    && pwmatch);
            if (pwmatch) {
                data.setContactName(owner.getText());
                data.setPassword(password.getText());
                setErrorMessage(null);
            } else {
                setErrorMessage(Messages.RSASaveKeypairPage_error_passwords_mismatch);
                data.setPassword(null);
                data.setContactName(null);
            }
        }
    };

    /** shared data object. */
    private final RSAData data;

    /**
     * Constructor, sets page incomplete and calls super and sets the description.
     *
     * @param data the data object
     */
    public RSASaveKeypairPage(final RSAData data) {
        super(PAGENAME, TITLE, null);
        setPageComplete(false);
        this.setDescription(Messages.RSASaveKeypairPage_enter_params_text);
        this.data = data;
    }

    /**
     * Set up UI stuff.
     *
     * @param parent the parent composite
     */
    public final void createControl(final Composite parent) {
        final Composite composite = new Composite(parent, SWT.NONE);
        // do stuff like layout et al
        final int ncol = 2;
        final GridLayout gl = new GridLayout(ncol, false);
        composite.setLayout(gl);
        final GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        // needed so textfields don't cut text
        gd.heightHint = TEXTFIELD_MIN_HEIGHT;
        final GridData gd2 = new GridData(SWT.FILL, SWT.CENTER, false, false, ncol, 1);
        final Label own = new Label(composite, SWT.NONE);
        own.setText(Messages.RSASaveKeypairPage_name);
        own.setLayoutData(gd2);

        owner = new Text(composite, SWT.BORDER | SWT.SINGLE);
        owner.addModifyListener(ml);
        owner.setLayoutData(gd);

        final Label pass = new Label(composite, SWT.NONE);
        pass.setText(Messages.RSASaveKeypairPage_password);
        pass.setLayoutData(gd2);

        password = new Text(composite, SWT.BORDER | SWT.PASSWORD);
        password.addModifyListener(ml);
        password.setLayoutData(gd);
        new Label(composite, SWT.NONE).setLayoutData(gd);
        passwordverify = new Text(composite, SWT.BORDER | SWT.PASSWORD);
        passwordverify.addModifyListener(ml);
        passwordverify.setLayoutData(gd);

        // finish
        setControl(composite);
    }

    /**
     * getter for the pagename.
     *
     * @return the pagename
     */
    public static String getPagename() {
        return PAGENAME;
    }

    @Override
    public IWizardPage getNextPage() {
        return null;
    }
}
