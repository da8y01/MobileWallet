/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mobilewallet;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.io.file.FileSystemRegistry;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

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
    private final String sLocalOutputPrefix = "expeout_";
    private final String sFileExt = ".text";
    private final String sLocalDataExt = ".json";
    private final String sOutputExt = ".out";

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


    public boolean WriteLocalFile(String sWriteData) throws IOException {
        FileConnection fc = null;
        DataOutputStream dos = null;
        OutputStream os = null;
        PrintStream ps = null;

        try {
            // If exists already, first delete file, a little clumsy.
            //fc = (FileConnection) Connector.open(fileURL.toString(), Connector.READ_WRITE);
            //String url = sFileSchema + sFSRoot + "expeout_201101" + sFileExt;
            String url = sFileSchema + sFSRoot + sLocalOutputPrefix + "201101" + sOutputExt;
            fc = (FileConnection) Connector.open(url, Connector.READ_WRITE);
            if (!fc.exists()) {
                fc.create();
            }

            dos = new DataOutputStream(fc.openOutputStream());
            //dos.writeUTF(sWriteData);
            dos.write(sWriteData.getBytes());
            //os = fc.openOutputStream(Long.MAX_VALUE);
            //os = fc.openOutputStream();
            //ps = new PrintStream(os);
            //ps.println(sWriteData);

            SetSuccess(true);
        } catch (ConnectionNotFoundException cnfex) {
            SetSuccess(false);
            SetMessages(cnfex.toString());
            cnfex.printStackTrace();
        } catch (IOException ioex) {
            SetSuccess(false);
            SetMessages(ioex.toString());
            ioex.printStackTrace();
        } catch (Exception ex) {
            SetSuccess(false);
            SetMessages(ex.toString());
            ex.printStackTrace();
        } finally {
            /*if (ps != null) {
                ps.flush();
                ps.close();
            }
            if (os != null) {
                os.flush();
                os.close();
            }*/
            if (dos != null) {
                dos.flush();
                dos.close();
            }
            if (fc != null) {
                fc.close();
            }
        }

        return GetSuccess();
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


    public boolean OutputJSON(PuntoExpendio punto) {
        boolean bSuccessResult;

        try {
            bSuccessResult = WriteLocalFile(ProcessOutJSON(punto));
        } catch (IOException ioex) {
            bSuccessResult = false;
            SetMessages(ioex.toString());
            ioex.printStackTrace();
        } catch (Exception ex) {
            bSuccessResult = false;
            SetMessages(ex.toString());
            ex.printStackTrace();
        }

        return bSuccessResult;
    }


    private String ProcessOutJSON(PuntoExpendio punto) {
        // Define an external an a nexted JSONObjects
        JSONObject jsonobject = new JSONObject();

        // Now generate the JSON output
        try {
            jsonobject.put("ID", Integer.toString(punto.GetId())); // a name/value pair
            jsonobject.put("ENTR. DEV.", punto.GetEntrDev()); // a name/value pair
            jsonobject.put("VALOR TOTAL", Integer.toString(punto.GetValorTotal())); // a name/value pair
        } catch (JSONException jsonex) {
            // ...process exception
            SetMessages(jsonex.toString());
            jsonex.printStackTrace();
        } catch (Exception ex) {
            // ...process exception
            SetMessages(ex.toString());
            ex.printStackTrace();
        }

        return jsonobject.toString(); // return the JSON text
    }

    public String ReadOutputFile() throws IOException {
        FileConnection fc = null;
        InputStream is = null;
        StringBuffer sb = new StringBuffer();

        try {
            String url = sFileSchema + sFSRoot + sLocalOutputPrefix + "201101" + sOutputExt;
            fc = (FileConnection) Connector.open(url, Connector.READ_WRITE);
            if (fc == null) {
                SetMessages("[!] ERROR: fc == null.");
                System.out.println(GetMessages());
                return null;
            }
            if (!fc.exists()) {
                //SetMessages("[!] ERROR: !fc.exists().");
                //System.out.println(GetMessages());
                fc.create();
                return "";
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

    public String AddJSONInfo(String sOldJSON, PuntoExpendio pePunto) {
        String sAddResult = "";
        JSONObject[] old_puntos_array = null;
        JSONObject newjson = null;
        JSONObject newjsonpunto = null;
        JSONArray janew = null;

        try {
            if (sOldJSON.equalsIgnoreCase("")) {
                newjson = new JSONObject();

                newjsonpunto = new JSONObject();
                newjsonpunto.put("ID", Integer.toString(pePunto.GetId()));
                newjsonpunto.put("ENTR. DEV.", pePunto.GetEntrDev());
                newjsonpunto.put("VALOR TOTAL", Integer.toString(pePunto.GetValorTotal()));

                janew = new JSONArray();
                janew.put(newjsonpunto);

                newjson.put("data puntos", janew); //a name/value pair

                sAddResult = newjson.toString();
            } else {
                JSONObject jsonobject = new JSONObject(sOldJSON);
                if (jsonobject != null) {
                    JSONArray japuntos = jsonobject.getJSONArray("data puntos");
                    if (japuntos != null) {
                        old_puntos_array = new JSONObject[japuntos.length()];
                        for (int i = 0; i < japuntos.length(); i++) {
                            old_puntos_array[i] = japuntos.getJSONObject(i);
                        }
                    }
                }


                newjson = new JSONObject();

                newjsonpunto = new JSONObject();
                newjsonpunto.put("ID", Integer.toString(pePunto.GetId()));
                newjsonpunto.put("ENTR. DEV.", pePunto.GetEntrDev());
                newjsonpunto.put("VALOR TOTAL", Integer.toString(pePunto.GetValorTotal()));

                janew = new JSONArray();
                for (int i = 0; i < old_puntos_array.length; i++) {
                    janew.put(old_puntos_array[i]);
                }
                janew.put(newjsonpunto);

                newjson.put("data puntos", janew); //a name/value pair

                sAddResult = newjson.toString();
            }
        } catch (JSONException jsonex) {
            SetMessages(jsonex.toString());
            sAddResult = GetMessages();
            jsonex.printStackTrace();
        } catch (Exception ex) {
            SetMessages(ex.toString());
            sAddResult = GetMessages();
            ex.printStackTrace();
        }

        System.out.println(sAddResult);
        return sAddResult;
    }

}
