/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mobilewallet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.io.file.FileSystemRegistry;

/**
 *
 * @author Admin
 */
public class ConnectionHandler {

    private final String sFileSchema = "file:///";
    private final String sFSRoot = "c:/other/";
    //private final String sFSRoot = "root1/";
    private final String sLocalCodePrefix = "code_";
    private final String sLocalExpePrefix = "expe_";
    private final String sFileExt = ".text";
    private final String sLocalDataExt = ".json";

    private boolean bSuccess;
    private String sResults, sMessages;


    public ConnectionHandler() {
        this.bSuccess = false;
        this.sResults = this.sMessages = "";
    }


    public Enumeration GetEnumFSDevices() {
        return FileSystemRegistry.listRoots();
    }


    public String ReadLocalCode(String type) throws IOException {
        FileConnection fc = null;
        InputStream is = null;
        StringBuffer sb = new StringBuffer();

        try {
            String url = sFileSchema + sFSRoot + sLocalCodePrefix + type + sFileExt;
            fc = (FileConnection) Connector.open(url, Connector.READ);
            if (fc == null) {
                SetMessages("[!] ERROR: fc == null.");
                System.out.println(GetMessages());
                return null;
            }
            if (!fc.exists()) {
                SetMessages("[!] ERROR: !fc.exists().");
                System.out.println(GetMessages());
                return null;
            }

            is = fc.openInputStream();
            int ch;
            while ((ch = is.read()) != -1) {
                sb.append((char) ch);
            }
        } catch (ConnectionNotFoundException cnfex) {
            SetMessages(cnfex.toString());
            cnfex.printStackTrace();
        } catch (IOException ioex) {
            SetMessages(ioex.toString());
            ioex.printStackTrace();
        } catch (Exception ex) {
            SetMessages(ex.toString());
            ex.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }

            if (fc != null) {
                fc.close();
            }
        }

        return sb.toString();
    }


    public String ReadLocalFile() throws IOException {
        FileConnection fc = null;
        InputStream is = null;
        StringBuffer sb = new StringBuffer();

        try {
            String local_code = ReadLocalCode("expe");
            String url = sFileSchema + sFSRoot + sLocalExpePrefix + local_code + sLocalDataExt;
            fc = (FileConnection) Connector.open(url, Connector.READ);
            if (fc == null) {
                SetMessages("[!] ERROR: fc == null.");
                System.out.println(GetMessages());
                return null;
            }
            if (!fc.exists()) {
                SetMessages("[!] ERROR: !fc.exists().");
                System.out.println(GetMessages());
                return null;
            }

            is = fc.openInputStream();
            int ch;
            while ((ch = is.read()) != -1) {
                sb.append((char) ch);
            }

            System.out.println(sb.toString());
        } catch (ConnectionNotFoundException cnfex) {
            SetMessages(cnfex.toString());
            cnfex.printStackTrace();
        } catch (IOException ioex) {
            SetMessages(ioex.toString());
            ioex.printStackTrace();
        } catch (Exception ex) {
            SetMessages(ex.toString());
            ex.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }

            if (fc != null) {
                fc.close();
            }
        }

        return sb.toString();
    }


    public void WriteLocalFile() throws IOException {
        FileConnection fc = null;
        //DataOutputStream dos = null;
        OutputStream os = null;
        PrintStream ps = null;

        try {
            // If exists already, first delete file, a little clumsy.
            //fc = (FileConnection) Connector.open(fileURL.toString(), Connector.READ_WRITE);
            String url = sFileSchema + sFSRoot + "expeout_201101" + sFileExt;
            fc = (FileConnection) Connector.open(url, Connector.READ_WRITE);
            if (!fc.exists()) {
                fc.create();
            }

            //dos = new DataOutputStream(fc.openOutputStream());
            os = fc.openOutputStream(Long.MAX_VALUE);
            ps = new PrintStream(os);
            ps.println("Some text to append");
        } catch (ConnectionNotFoundException cnfex) {
            SetMessages(cnfex.toString());
            cnfex.printStackTrace();
        } catch (IOException ioex) {
            SetMessages(ioex.toString());
            ioex.printStackTrace();
        } catch (Exception ex) {
            SetMessages(ex.toString());
            ex.printStackTrace();
        } finally {
            if (ps != null) {
                ps.flush();
                ps.close();
            }
            if (os != null) {
                os.flush();
                os.close();
            }
            if (fc != null) {
                fc.close();
            }
        }
    }


    public Enumeration GetEnumRootList(String deviceDir) {
        FileConnection fc = null;
        InputStream is = null;
        Enumeration enumTraverse = null;

        try {
            fc = (FileConnection) Connector.open(sFileSchema+deviceDir);

            if (fc == null) {
                SetMessages("[!] ERROR: fc == null.");
                System.out.println(GetMessages());
                return null;
            }
            if (!fc.exists()) {
                SetMessages("[!] ERROR: !fc.exists().");
                System.out.println(GetMessages());
                return null;
            }

            enumTraverse = fc.list();
        } catch (IOException ioex) {
            SetMessages(ioex.toString());
            ioex.printStackTrace();
        } catch (Exception ex) {
            SetMessages(ex.toString());
            ex.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }

                if (fc != null) {
                    fc.close();
                }
            } catch (IOException ioex) {
                SetMessages(ioex.toString());
                ioex.printStackTrace();
            } catch (Exception ex) {
                SetMessages(ex.toString());
                ex.printStackTrace();
            }
        }

        return enumTraverse;
    }


    public boolean GetSuccess() {
        return this.bSuccess;
    }

    public void SetSuccess(boolean suc) {
        this.bSuccess = suc;
    }


    public String GetResults() {
        return this.sResults;
    }

    public void SetResults(String res) {
        this.sResults = res;
    }


    public String GetMessages() {
        return this.sMessages;
    }

    public void SetMessages(String msg) {
        this.sMessages = msg;
    }

}
