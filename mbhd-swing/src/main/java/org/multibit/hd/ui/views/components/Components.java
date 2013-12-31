package org.multibit.hd.ui.views.components;

import net.miginfocom.swing.MigLayout;
import org.multibit.hd.core.api.seed_phrase.SeedPhraseGenerator;
import org.multibit.hd.ui.views.components.seed_phrase_display.SeedPhraseDisplayModel;
import org.multibit.hd.ui.views.components.seed_phrase_display.SeedPhraseDisplayView;
import org.multibit.hd.ui.views.fonts.AwesomeDecorator;
import org.multibit.hd.ui.views.fonts.AwesomeIcon;

import javax.swing.*;

/**
 * <p>Factory to provide the following to UI:</p>
 * <ul>
 * <li>Creation of complex components requiring a model and view</li>
 * </ul>
 *
 * @since 0.0.1
 *         
 */
public class Components {

  public static final String CREATE_WALLET_ACTION_NAME = "Create";
  public static final String RESTORE_WALLET_ACTION_NAME = "Restore";
  public static final String HARDWARE_WALLET_ACTION_NAME = "Hardware";
  public static final String SELECT_WALLET_ACTION_NAME = "Select";
  public static final String WELCOME_ACTION_NAME = "Welcome";

  /**
   * <p>A wallet detail panel provides a summary of the information contained within the wallet</p>
   *
   * @return A new wallet detail panel
   */
  public static JPanel newWalletDetailPanel() {

    MigLayout layout = new MigLayout(
      "fillx", // Layout
      "[]10[grow]", // Columns
      "[][][][]"  // Rows
    );

    JPanel panel = Panels.newPanel(layout);

    panel.add(new JLabel("Summary"), "wrap");
    panel.add(new JLabel("Location:"));
    panel.add(new JLabel("/Users/<someone>/Library/Application Support/MultiBitHD/mbhd-2412897490823174231947"), "push,wrap");
    panel.add(new JLabel("Contacts:"));
    panel.add(new JLabel("357"), "push,wrap");
    panel.add(new JLabel("Transactions:"));
    panel.add(new JLabel("165"), "push,wrap");

    return panel;
  }

  /**
   * <p>A contact search panel provides a means of finding a contact through their name or a Bitcoin address</p>
   *
   * @return A new recipient panel
   */
  public static JPanel newContactSearch() {

    JPanel panel = Panels.newPanel();
    panel.add(new JLabel("Recipient"));
    panel.add(TextBoxes.newRecipient());

    JLabel recipientIcon = new JLabel();
    AwesomeDecorator.applyIcon(AwesomeIcon.USER, recipientIcon, false, AwesomeDecorator.LARGE_ICON_SIZE);
    panel.add(recipientIcon);

    return panel;
  }

  /**
   * <p>A Bitcoin amount panel provides a means of entering either a Bitcoin or fiat amount and seeing an immediate rate conversion</p>
   *
   * @return A new Bitcoin amount panel
   */
  public static JPanel newBitcoinAmount() {

    JPanel panel = Panels.newPanel();

    panel.add(new JLabel("Amount"));
    panel.add(new JLabel("BTC"));
    panel.add(TextBoxes.newCurrency("0.00"));
    panel.add(new JLabel("="));
    panel.add(new JLabel("$"));
    panel.add(TextBoxes.newCurrency("0.00"));
    panel.add(new JLabel("(MtGox)"));

    return panel;
  }

  /**
   * <p>A notes panel provides a means of entering some text data</p>
   *
   * @return A new notes panel
   */
  public static JPanel newNotes() {

    JPanel panel = Panels.newPanel();

    panel.add(new JLabel("Notes"));
    panel.add(TextBoxes.newNotes());

    return panel;
  }

  /**
   * <p>A wallet password panel provides a means of entering a user password</p>
   *
   * @return A new wallet password panel
   */
  public static JPanel newWalletPassword() {

    JPanel panel = Panels.newPanel();

    panel.add(new JLabel("Wallet password:"));
    panel.add(TextBoxes.newPassword());

    // TODO Convert this to use a hide/show button
    JButton eyeIcon = new JButton();
    AwesomeDecorator.applyIcon(AwesomeIcon.EYE, eyeIcon, false, AwesomeDecorator.NORMAL_ICON_SIZE);
    panel.add(eyeIcon);

    return panel;
  }

  /**
   * <p>A "seed phrase" model and view shows the words used in a BIP0039 seed</p>
   *
   * @param generator The seed phrase generator
   *
   * @return A new "seed size selector" panel
   */
  public static ModelAndView<SeedPhraseDisplayModel, SeedPhraseDisplayView> newSeedPhraseMaV(final SeedPhraseGenerator generator) {

    SeedPhraseDisplayModel model = new SeedPhraseDisplayModel(generator);
    SeedPhraseDisplayView view = new SeedPhraseDisplayView(model);

    return new ModelAndView<>(model ,view);

  }

}