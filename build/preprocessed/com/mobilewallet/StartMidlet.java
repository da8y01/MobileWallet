/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mobilewallet;

import java.io.IOException;
import java.util.Enumeration;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import org.netbeans.microedition.lcdui.LoginScreen;

/**
 * @author Admin
 */
public class StartMidlet extends MIDlet implements CommandListener {

    private boolean midletPaused = false;

    private String sMessages;

    private Enumeration enumeration;
    private ConnectionHandler connectionhandler;
    private RutaExpendio RutaExpendio;
    private PuntoExpendio a_PuntoExpendio, CurrPuntoExpendio;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private List ListInicio;
    private LoginScreen LoginScreen;
    private List ListExpendio;
    private List ListConsignataria;
    private List ListVerificar;
    private Alert Alert;
    private List ListFS;
    private List ListContentRoot;
    private Form FormPuntoExpendio;
    private TextField textFieldPEEntrDev;
    private StringItem stringItemPEValorUnitario;
    private StringItem stringItemPEFecha;
    private StringItem stringItemPEId;
    private StringItem stringItemPENombre;
    private TextField textFieldPEValorTotal;
    private Command exitCommand;
    private Command backCommand;
    private Command sendCommand;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The StartMidlet constructor.
     */
    public StartMidlet() {
        connectionhandler = new ConnectionHandler();
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
        try {
            VerifyFileConnectionSupport();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getListInicio());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == FormPuntoExpendio) {//GEN-BEGIN:|7-commandAction|1|95-preAction
            if (command == backCommand) {//GEN-END:|7-commandAction|1|95-preAction
                // write pre-action user code here
                switchDisplayable(null, getListExpendio());//GEN-LINE:|7-commandAction|2|95-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|3|94-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|4|94-postAction
                // write post-action user code here
            } else if (command == sendCommand) {//GEN-LINE:|7-commandAction|5|108-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|6|108-postAction
                // write post-action user code here
                EscribirPuntoExpendio();
            }//GEN-BEGIN:|7-commandAction|7|60-preAction
        } else if (displayable == ListConsignataria) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|5|60-preAction
                // write pre-action user code here
                ListConsignatariaAction();//GEN-LINE:|7-commandAction|6|60-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|7|63-preAction
                // write pre-action user code here
                switchDisplayable(null, getListInicio());//GEN-LINE:|7-commandAction|8|63-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|9|62-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|10|62-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|86-preAction
        } else if (displayable == ListContentRoot) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|11|86-preAction
                // write pre-action user code here
                ListContentRootAction();//GEN-LINE:|7-commandAction|12|86-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|13|89-preAction
                // write pre-action user code here
                switchDisplayable(null, getListInicio());//GEN-LINE:|7-commandAction|14|89-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|15|88-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|16|88-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|17|55-preAction
        } else if (displayable == ListExpendio) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|17|55-preAction
                // write pre-action user code here
                ListExpendioAction();//GEN-LINE:|7-commandAction|18|55-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|19|58-preAction
                // write pre-action user code here
                switchDisplayable(null, getListInicio());//GEN-LINE:|7-commandAction|20|58-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|21|57-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|22|57-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|23|79-preAction
        } else if (displayable == ListFS) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|23|79-preAction
                // write pre-action user code here
                ListFSAction();//GEN-LINE:|7-commandAction|24|79-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|25|82-preAction
                // write pre-action user code here
                switchDisplayable(null, getListInicio());//GEN-LINE:|7-commandAction|26|82-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|27|81-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|28|81-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|29|16-preAction
        } else if (displayable == ListInicio) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|29|16-preAction
                // write pre-action user code here
                ListInicioAction();//GEN-LINE:|7-commandAction|30|16-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|31|19-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|32|19-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|33|65-preAction
        } else if (displayable == ListVerificar) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|33|65-preAction
                // write pre-action user code here
                ListVerificarAction();//GEN-LINE:|7-commandAction|34|65-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|35|68-preAction
                // write pre-action user code here
                switchDisplayable(null, getListInicio());//GEN-LINE:|7-commandAction|36|68-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|37|67-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|38|67-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|39|27-preAction
        } else if (displayable == LoginScreen) {
            if (command == LoginScreen.LOGIN_COMMAND) {//GEN-END:|7-commandAction|39|27-preAction
                // write pre-action user code here
                ValidateLoginExpendio(LoginScreen.getUsername(), LoginScreen.getPassword());
//GEN-LINE:|7-commandAction|40|27-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|41|30-preAction
                // write pre-action user code here
                switchDisplayable(null, getListInicio());//GEN-LINE:|7-commandAction|42|30-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|43|28-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|44|28-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|45|7-postCommandAction
        }//GEN-END:|7-commandAction|45|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|46|
    //</editor-fold>//GEN-END:|7-commandAction|46|


    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ListInicio ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of ListInicio component.
     * @return the initialized component instance
     */
    public List getListInicio() {
        if (ListInicio == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            ListInicio = new List("INICIO", Choice.IMPLICIT);//GEN-BEGIN:|14-getter|1|14-postInit
            ListInicio.append("Activar", null);
            ListInicio.append("Desbloquear", null);
            ListInicio.append("Expendio", null);
            ListInicio.append("Consignataria", null);
            ListInicio.append("Verificar", null);
            ListInicio.append("FS Roots", null);
            ListInicio.append("[+] INFO: ", null);
            ListInicio.addCommand(getExitCommand());
            ListInicio.setCommandListener(this);
            ListInicio.setSelectedFlags(new boolean[] { false, false, false, false, false, false, false });//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return ListInicio;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ListInicioAction ">//GEN-BEGIN:|14-action|0|14-preAction
    /**
     * Performs an action assigned to the selected list element in the ListInicio component.
     */
    public void ListInicioAction() {//GEN-END:|14-action|0|14-preAction
        // enter pre-action user code here
        String __selectedString = getListInicio().getString(getListInicio().getSelectedIndex());//GEN-BEGIN:|14-action|1|20-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Activar")) {//GEN-END:|14-action|1|20-preAction
                // write pre-action user code here
//GEN-LINE:|14-action|2|20-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Desbloquear")) {//GEN-LINE:|14-action|3|21-preAction
                // write pre-action user code here
//GEN-LINE:|14-action|4|21-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Expendio")) {//GEN-LINE:|14-action|5|22-preAction
                // write pre-action user code here
                switchDisplayable(null, getLoginScreen());//GEN-LINE:|14-action|6|22-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Consignataria")) {//GEN-LINE:|14-action|7|23-preAction
                // write pre-action user code here
                switchDisplayable(null, getLoginScreen());//GEN-LINE:|14-action|8|23-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Verificar")) {//GEN-LINE:|14-action|9|46-preAction
                // write pre-action user code here
                switchDisplayable(null, getLoginScreen());//GEN-LINE:|14-action|10|46-postAction
                // write post-action user code here
            } else if (__selectedString.equals("FS Roots")) {//GEN-LINE:|14-action|11|77-preAction
                // write pre-action user code here
                switchDisplayable(null, getListFS());//GEN-LINE:|14-action|12|77-postAction
                // write post-action user code here
            } else if (__selectedString.equals("[+] INFO: ")) {//GEN-LINE:|14-action|13|24-preAction
                // write pre-action user code here
//GEN-LINE:|14-action|14|24-postAction
                // write post-action user code here
            }//GEN-BEGIN:|14-action|15|14-postAction
        }//GEN-END:|14-action|15|14-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|14-action|16|
    //</editor-fold>//GEN-END:|14-action|16|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: LoginScreen ">//GEN-BEGIN:|25-getter|0|25-preInit
    /**
     * Returns an initiliazed instance of LoginScreen component.
     * @return the initialized component instance
     */
    public LoginScreen getLoginScreen() {
        if (LoginScreen == null) {//GEN-END:|25-getter|0|25-preInit
            // write pre-init user code here
            LoginScreen = new LoginScreen(getDisplay());//GEN-BEGIN:|25-getter|1|25-postInit
            LoginScreen.setLabelTexts("Username", "Password");
            LoginScreen.setTitle("INGRESAR");
            LoginScreen.addCommand(LoginScreen.LOGIN_COMMAND);
            LoginScreen.addCommand(getExitCommand());
            LoginScreen.addCommand(getBackCommand());
            LoginScreen.setCommandListener(this);
            LoginScreen.setBGColor(-3355444);
            LoginScreen.setFGColor(0);
            LoginScreen.setUseLoginButton(false);
            LoginScreen.setLoginButtonText("Login");//GEN-END:|25-getter|1|25-postInit
            // write post-init user code here
        }//GEN-BEGIN:|25-getter|2|
        return LoginScreen;
    }
    //</editor-fold>//GEN-END:|25-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|18-getter|0|18-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
            // write post-init user code here
        }//GEN-BEGIN:|18-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|18-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|29-getter|0|29-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|29-getter|0|29-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|29-getter|1|29-postInit
            // write post-init user code here
        }//GEN-BEGIN:|29-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|29-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: sendCommand ">//GEN-BEGIN:|107-getter|0|107-preInit
    /**
     * Returns an initiliazed instance of sendCommand component.
     * @return the initialized component instance
     */
    public Command getSendCommand() {
        if (sendCommand == null) {//GEN-END:|107-getter|0|107-preInit
            // write pre-init user code here
            sendCommand = new Command("Enviar", Command.SCREEN, 0);//GEN-LINE:|107-getter|1|107-postInit
            // write post-init user code here
        }//GEN-BEGIN:|107-getter|2|
        return sendCommand;
    }
    //</editor-fold>//GEN-END:|107-getter|2|





    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ListExpendio ">//GEN-BEGIN:|54-getter|0|54-preInit
    /**
     * Returns an initiliazed instance of ListExpendio component.
     * @return the initialized component instance
     */
    public List getListExpendio() {
        if (ListExpendio == null) {//GEN-END:|54-getter|0|54-preInit
            // write pre-init user code here
            ListExpendio = new List("EXPENDIO", Choice.IMPLICIT);//GEN-BEGIN:|54-getter|1|54-postInit
            ListExpendio.addCommand(getExitCommand());
            ListExpendio.addCommand(getBackCommand());
            ListExpendio.setCommandListener(this);//GEN-END:|54-getter|1|54-postInit
            // write post-init user code here
            enumeration = RutaExpendio.VectorPuntos.elements();
            while (enumeration.hasMoreElements()) {
                a_PuntoExpendio = (PuntoExpendio) enumeration.nextElement();
                String sItem = "[!] "+a_PuntoExpendio.GetId()+": "+a_PuntoExpendio.GetNombre();
                ListExpendio.append(sItem, null);
            }
        }//GEN-BEGIN:|54-getter|2|
        return ListExpendio;
    }
    //</editor-fold>//GEN-END:|54-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ListExpendioAction ">//GEN-BEGIN:|54-action|0|54-preAction
    /**
     * Performs an action assigned to the selected list element in the ListExpendio component.
     */
    public void ListExpendioAction() {//GEN-END:|54-action|0|54-preAction
        // enter pre-action user code here
        String __selectedString = getListExpendio().getString(getListExpendio().getSelectedIndex());//GEN-LINE:|54-action|1|54-postAction
        // enter post-action user code here
        String selectedId = "";
        int i = 0;

        if (__selectedString.startsWith("[!]")) {
            i = __selectedString.indexOf(" ");
            //selectedId = __selectedString.substring(++i, __selectedString.length());
            selectedId = __selectedString.substring(++i, __selectedString.indexOf(":"));
            //System.out.println("[+] 'selectedId': '"+selectedId+"'");

            enumeration = RutaExpendio.VectorPuntos.elements();
            while (enumeration.hasMoreElements()) {
                PuntoExpendio curr_PuntoExpendio = (PuntoExpendio) enumeration.nextElement();
                if (Integer.toString(curr_PuntoExpendio.GetId()).equalsIgnoreCase(selectedId)) {
                    CurrPuntoExpendio = curr_PuntoExpendio;
                    break;
                }
            }

            switchDisplayable(null, getFormPuntoExpendio());
        }
        else {
            getAlert().setTitle("INFO");
            getAlert().setType(AlertType.INFO);
            getAlert().setString("El punto ya ha sido diligenciado");
            switchDisplayable(null, getAlert());
        }
    }//GEN-BEGIN:|54-action|2|
    //</editor-fold>//GEN-END:|54-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ListConsignataria ">//GEN-BEGIN:|59-getter|0|59-preInit
    /**
     * Returns an initiliazed instance of ListConsignataria component.
     * @return the initialized component instance
     */
    public List getListConsignataria() {
        if (ListConsignataria == null) {//GEN-END:|59-getter|0|59-preInit
            // write pre-init user code here
            ListConsignataria = new List("CONSIGNATARIA", Choice.IMPLICIT);//GEN-BEGIN:|59-getter|1|59-postInit
            ListConsignataria.addCommand(getExitCommand());
            ListConsignataria.addCommand(getBackCommand());
            ListConsignataria.setCommandListener(this);//GEN-END:|59-getter|1|59-postInit
            // write post-init user code here
        }//GEN-BEGIN:|59-getter|2|
        return ListConsignataria;
    }
    //</editor-fold>//GEN-END:|59-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ListConsignatariaAction ">//GEN-BEGIN:|59-action|0|59-preAction
    /**
     * Performs an action assigned to the selected list element in the ListConsignataria component.
     */
    public void ListConsignatariaAction() {//GEN-END:|59-action|0|59-preAction
        // enter pre-action user code here
        String __selectedString = getListConsignataria().getString(getListConsignataria().getSelectedIndex());//GEN-LINE:|59-action|1|59-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|59-action|2|
    //</editor-fold>//GEN-END:|59-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ListVerificar ">//GEN-BEGIN:|64-getter|0|64-preInit
    /**
     * Returns an initiliazed instance of ListVerificar component.
     * @return the initialized component instance
     */
    public List getListVerificar() {
        if (ListVerificar == null) {//GEN-END:|64-getter|0|64-preInit
            // write pre-init user code here
            ListVerificar = new List("VERIFICAR", Choice.IMPLICIT);//GEN-BEGIN:|64-getter|1|64-postInit
            ListVerificar.addCommand(getExitCommand());
            ListVerificar.addCommand(getBackCommand());
            ListVerificar.setCommandListener(this);//GEN-END:|64-getter|1|64-postInit
            // write post-init user code here
        }//GEN-BEGIN:|64-getter|2|
        return ListVerificar;
    }
    //</editor-fold>//GEN-END:|64-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ListVerificarAction ">//GEN-BEGIN:|64-action|0|64-preAction
    /**
     * Performs an action assigned to the selected list element in the ListVerificar component.
     */
    public void ListVerificarAction() {//GEN-END:|64-action|0|64-preAction
        // enter pre-action user code here
        String __selectedString = getListVerificar().getString(getListVerificar().getSelectedIndex());//GEN-LINE:|64-action|1|64-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|64-action|2|
    //</editor-fold>//GEN-END:|64-action|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: Alert ">//GEN-BEGIN:|76-getter|0|76-preInit
    /**
     * Returns an initiliazed instance of Alert component.
     * @return the initialized component instance
     */
    public Alert getAlert() {
        if (Alert == null) {//GEN-END:|76-getter|0|76-preInit
            // write pre-init user code here
            Alert = new Alert("");//GEN-BEGIN:|76-getter|1|76-postInit
            Alert.setTimeout(Alert.FOREVER);//GEN-END:|76-getter|1|76-postInit
            // write post-init user code here
        }//GEN-BEGIN:|76-getter|2|
        return Alert;
    }
    //</editor-fold>//GEN-END:|76-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ListFS ">//GEN-BEGIN:|78-getter|0|78-preInit
    /**
     * Returns an initiliazed instance of ListFS component.
     * @return the initialized component instance
     */
    public List getListFS() {
        if (ListFS == null) {//GEN-END:|78-getter|0|78-preInit
            // write pre-init user code here
            ListFS = new List("FS ROOTS", Choice.IMPLICIT);//GEN-BEGIN:|78-getter|1|78-postInit
            ListFS.addCommand(getExitCommand());
            ListFS.addCommand(getBackCommand());
            ListFS.setCommandListener(this);//GEN-END:|78-getter|1|78-postInit
            // write post-init user code here
            enumeration = connectionhandler.GetEnumFSDevices();
            while (enumeration.hasMoreElements()) {
                ListFS.append((String)enumeration.nextElement(), null);
            }
        }//GEN-BEGIN:|78-getter|2|
        return ListFS;
    }
    //</editor-fold>//GEN-END:|78-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ListFSAction ">//GEN-BEGIN:|78-action|0|78-preAction
    /**
     * Performs an action assigned to the selected list element in the ListFS component.
     */
    public void ListFSAction() {//GEN-END:|78-action|0|78-preAction
        // enter pre-action user code here
        String __selectedString = getListFS().getString(getListFS().getSelectedIndex());//GEN-LINE:|78-action|1|78-postAction
        // enter post-action user code here
        enumeration = connectionhandler.GetEnumRootList(__selectedString);
        switchDisplayable(null, getListContentRoot());
    }//GEN-BEGIN:|78-action|2|
    //</editor-fold>//GEN-END:|78-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ListContentRoot ">//GEN-BEGIN:|85-getter|0|85-preInit
    /**
     * Returns an initiliazed instance of ListContentRoot component.
     * @return the initialized component instance
     */
    public List getListContentRoot() {
        if (ListContentRoot == null) {//GEN-END:|85-getter|0|85-preInit
            // write pre-init user code here
            ListContentRoot = new List("ROOT CONTENT", Choice.IMPLICIT);//GEN-BEGIN:|85-getter|1|85-postInit
            ListContentRoot.addCommand(getExitCommand());
            ListContentRoot.addCommand(getBackCommand());
            ListContentRoot.setCommandListener(this);//GEN-END:|85-getter|1|85-postInit
            // write post-init user code here
            while (enumeration.hasMoreElements()) {
                ListContentRoot.append((String)enumeration.nextElement(), null);
            }
        }//GEN-BEGIN:|85-getter|2|
        return ListContentRoot;
    }
    //</editor-fold>//GEN-END:|85-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: ListContentRootAction ">//GEN-BEGIN:|85-action|0|85-preAction
    /**
     * Performs an action assigned to the selected list element in the ListContentRoot component.
     */
    public void ListContentRootAction() {//GEN-END:|85-action|0|85-preAction
        // enter pre-action user code here
        String __selectedString = getListContentRoot().getString(getListContentRoot().getSelectedIndex());//GEN-LINE:|85-action|1|85-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|85-action|2|
    //</editor-fold>//GEN-END:|85-action|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: FormPuntoExpendio ">//GEN-BEGIN:|93-getter|0|93-preInit
    /**
     * Returns an initiliazed instance of FormPuntoExpendio component.
     * @return the initialized component instance
     */
    public Form getFormPuntoExpendio() {
        //if (FormPuntoExpendio == null) {//GEN-END:|93-getter|0|93-preInit
            // write pre-init user code here
            FormPuntoExpendio = new Form("PUNTO EXPENDIO", new Item[] { getStringItemPEId(), getStringItemPENombre(), getStringItemPEFecha(), getTextFieldPEEntrDev(), getStringItemPEValorUnitario(), getTextFieldPEValorTotal() });//GEN-BEGIN:|93-getter|1|93-postInit
            FormPuntoExpendio.addCommand(getExitCommand());
            FormPuntoExpendio.addCommand(getBackCommand());
            FormPuntoExpendio.addCommand(getSendCommand());
            FormPuntoExpendio.setCommandListener(this);//GEN-END:|93-getter|1|93-postInit
            // write post-init user code here
            //getStringItemPEId().setText(Integer.toString(CurrPuntoExpendio.GetId()));
            //getStringItemPENombre().setText(CurrPuntoExpendio.GetNombre());
            //getStringItemPEFecha().setText(CurrPuntoExpendio.GetFecha());
            //getStringItemPEValorUnitario().setText(Integer.toString(CurrPuntoExpendio.GetValorUnitario()));
            stringItemPEId.setText(Integer.toString(CurrPuntoExpendio.GetId()));
            stringItemPENombre.setText(CurrPuntoExpendio.GetNombre());
            stringItemPEFecha.setText(CurrPuntoExpendio.GetFecha());
            stringItemPEValorUnitario.setText(Integer.toString(CurrPuntoExpendio.GetValorUnitario()));
        //}//GEN-BEGIN:|93-getter|2|
        return FormPuntoExpendio;
    }
    //</editor-fold>//GEN-END:|93-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemPEId ">//GEN-BEGIN:|98-getter|0|98-preInit
    /**
     * Returns an initiliazed instance of stringItemPEId component.
     * @return the initialized component instance
     */
    public StringItem getStringItemPEId() {
        //if (stringItemPEId == null) {//GEN-END:|98-getter|0|98-preInit
            // write pre-init user code here
            stringItemPEId = new StringItem("Id:", null);//GEN-LINE:|98-getter|1|98-postInit
            // write post-init user code here
        //}//GEN-BEGIN:|98-getter|2|
        return stringItemPEId;
    }
    //</editor-fold>//GEN-END:|98-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemPENombre ">//GEN-BEGIN:|99-getter|0|99-preInit
    /**
     * Returns an initiliazed instance of stringItemPENombre component.
     * @return the initialized component instance
     */
    public StringItem getStringItemPENombre() {
        //if (stringItemPENombre == null) {//GEN-END:|99-getter|0|99-preInit
            // write pre-init user code here
            stringItemPENombre = new StringItem("Nombre:", null);//GEN-LINE:|99-getter|1|99-postInit
            // write post-init user code here
        //}//GEN-BEGIN:|99-getter|2|
        return stringItemPENombre;
    }
    //</editor-fold>//GEN-END:|99-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemPEFecha ">//GEN-BEGIN:|100-getter|0|100-preInit
    /**
     * Returns an initiliazed instance of stringItemPEFecha component.
     * @return the initialized component instance
     */
    public StringItem getStringItemPEFecha() {
        //if (stringItemPEFecha == null) {//GEN-END:|100-getter|0|100-preInit
            // write pre-init user code here
            stringItemPEFecha = new StringItem("Fecha:", null);//GEN-LINE:|100-getter|1|100-postInit
            // write post-init user code here
        //}//GEN-BEGIN:|100-getter|2|
        return stringItemPEFecha;
    }
    //</editor-fold>//GEN-END:|100-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textFieldPEEntrDev ">//GEN-BEGIN:|102-getter|0|102-preInit
    /**
     * Returns an initiliazed instance of textFieldPEEntrDev component.
     * @return the initialized component instance
     */
    public TextField getTextFieldPEEntrDev() {
        //if (textFieldPEEntrDev == null) {//GEN-END:|102-getter|0|102-preInit
            // write pre-init user code here
            textFieldPEEntrDev = new TextField("Entr. Dev.:", null, 4, TextField.NUMERIC);//GEN-LINE:|102-getter|1|102-postInit
            // write post-init user code here
        //}//GEN-BEGIN:|102-getter|2|
        return textFieldPEEntrDev;
    }
    //</editor-fold>//GEN-END:|102-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItemPEValorUnitario ">//GEN-BEGIN:|103-getter|0|103-preInit
    /**
     * Returns an initiliazed instance of stringItemPEValorUnitario component.
     * @return the initialized component instance
     */
    public StringItem getStringItemPEValorUnitario() {
        //if (stringItemPEValorUnitario == null) {//GEN-END:|103-getter|0|103-preInit
            // write pre-init user code here
            stringItemPEValorUnitario = new StringItem("Valor Unitario:", null);//GEN-LINE:|103-getter|1|103-postInit
            // write post-init user code here
        //}//GEN-BEGIN:|103-getter|2|
        return stringItemPEValorUnitario;
    }
    //</editor-fold>//GEN-END:|103-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textFieldPEValorTotal ">//GEN-BEGIN:|104-getter|0|104-preInit
    /**
     * Returns an initiliazed instance of textFieldPEValorTotal component.
     * @return the initialized component instance
     */
    public TextField getTextFieldPEValorTotal() {
        //if (textFieldPEValorTotal == null) {//GEN-END:|104-getter|0|104-preInit
            // write pre-init user code here
            textFieldPEValorTotal = new TextField("Valor Total:", null, 16, TextField.NUMERIC);//GEN-LINE:|104-getter|1|104-postInit
            // write post-init user code here
        //}//GEN-BEGIN:|104-getter|2|
        return textFieldPEValorTotal;
    }
    //</editor-fold>//GEN-END:|104-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }


    public void VerifyFileConnectionSupport() throws IOException {
        String version = "";
        version = System.getProperty("microedition.io.file.FileConnection.version");
        if (version != null) {
            if (!version.equals("1.0")) {
                throw new IOException("Package is not version 1.0.");
            }
        } else {
            throw new IOException("File connection optional package is not available.");
        }
    }


    private void ValidateLoginExpendio(String username, String password) {
        if (username.equalsIgnoreCase("expe") && password.equalsIgnoreCase("expe")) {
            GoToExpendio();
        } else if (username.equalsIgnoreCase("cons") && password.equalsIgnoreCase("cons")) {
            GoToConsignataria();
        } else if (username.equalsIgnoreCase("veri") && password.equalsIgnoreCase("veri")) {
            GoToVerificar();
        } else {
            getAlert().setTitle("ERROR DE LOGIN");
            getAlert().setString("Información de login incorrecta.");
            getAlert().setType(AlertType.ERROR);
            switchDisplayable(null, getAlert());
        }
    }


    private void GoToExpendio() {
        try {
            RutaExpendio = new RutaExpendio(connectionhandler.ReadLocalFile());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        switchDisplayable(null, getListExpendio());
    }

    private void GoToConsignataria() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void GoToVerificar() {
        throw new UnsupportedOperationException("Not yet implemented");
    }


    public String GetMessages() {
        return this.sMessages;
    }

    public void SetMessages(String msg) {
        this.sMessages = msg;
    }

    private void EscribirPuntoExpendio() {
        CurrPuntoExpendio.SetEntrDev(textFieldPEEntrDev.getString());
        CurrPuntoExpendio.SetValorTotal(Integer.parseInt(textFieldPEValorTotal.getString()));

        (new Thread() {

            public void run() {
                String sOldOutFile, sUpdatedJSON;
                boolean bWrote;

                try {
                    sOldOutFile = connectionhandler.ReadOutputFile();
                    sUpdatedJSON = connectionhandler.AddJSONInfo(sOldOutFile, CurrPuntoExpendio);
                    bWrote = connectionhandler.WriteLocalFile(sUpdatedJSON);
                } catch (IOException ioex) {
                    bWrote = false;
                    SetMessages(ioex.toString());
                    ioex.printStackTrace();
                } catch (Exception ex) {
                    bWrote = false;
                    SetMessages(ex.toString());
                    ex.printStackTrace();
                }

                if (bWrote) {
                    System.out.println();
                    getAlert().setTitle("CORRECTO");
                    getAlert().setString("Información de punto de expendio guardada.");
                    getAlert().setType(AlertType.CONFIRMATION);
                    switchDisplayable(null, getAlert());
                } else {
                    System.out.println();
                    getAlert().setTitle("ERROR");
                    getAlert().setString("Error al guardar información de punto de expendio.");
                    getAlert().setType(AlertType.ERROR);
                    switchDisplayable(null, getAlert());
                }
            }
        }).start();
    }

}
