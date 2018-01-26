import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Teste {

        public static void main(String[] args) {
                try {
                	
                        Class.forName("Opensql.JDBCDriver");
                        System.out.println("teste");
			 			 Connection c = DriverManager.getConnection("jdbc:opensql:/HST=192.168.37.117;/DSN=/home/hospub/banco/bdint;SEC=33;LEV=atua");
			 			 
                        Statement s = c.createStatement();
                        //ResultSet rs1 = s.executeQuery("update PESSOA set IDADE=55 where NOME_P = 'johny'");
                        ResultSet rs = s.executeQuery("select * from cen54 where n54numbolet=23");
                        int cols = (rs.getMetaData()).getColumnCount();

                        while (rs.next()) {
                                String fields[] = new String[cols];

                                for (int i = 0; i < cols; i++) {
                                        fields[i] = rs.getString(i + 1);
                                }

                                System.out.println("[" + join(fields, ", ") + "]");
                        }
                        c.close();
                } catch (Exception x) {
                        x.printStackTrace();
                }
        }

        static String join(String[] array, String delim) {
                StringBuffer sb = join(array, delim, new StringBuffer());
                return sb.toString();
        }

        static StringBuffer join(String[] array, String delim, StringBuffer sb) {
                for (int i = 0; i < array.length; i++) {
                        if (i != 0)
                                sb.append(delim);
                        sb.append("'" + array[i] + "'");
                }

                return sb;
        }

}

