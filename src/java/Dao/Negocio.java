/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import beans.*;
import interfaces.tiendaInt;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import util.MySQLConexion;

/**
 *
 * @author Renzo GM
 */
public class Negocio implements tiendaInt{

    @Override
    public List<Categoria> lisCategoria() {
      List<Categoria> lis = new ArrayList<>();
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql = "select idcategoria,descripcion,imagen from categorias";
            PreparedStatement st = conn.prepareStatement(sql);
            //st.setString(1, cad);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Categoria a = new Categoria();
                a.setCodc(rs.getString(1));
                a.setNomc(rs.getString(2));
                a.setImagen(rs.getString(3));
	        lis.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lis;

    }

    @Override
    public List<Articulo> lisArticulo(String id) {
        List<Articulo> lista=new ArrayList();
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql="select idarticulo, descripcion, precioUnidad,"
         + "stock , imagen from articulos where idcategoria=?";
            PreparedStatement st = conn.prepareStatement(sql);
          st.setString(1, id);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Articulo a = new Articulo();
                a.setCoda(rs.getString(1));
                a.setNomart(rs.getString(2));
                a.setPrecio(rs.getDouble(3));
                a.setStk(rs.getInt(4));
	        lista.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return lista;
    }

    @Override
    public Articulo busArt(String id) {
        Articulo a=null;
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql="select idarticulo, descripcion, precioUnidad,"
         + "stock , imagen from articulos where idcategoria=?";
            PreparedStatement st = conn.prepareStatement(sql);
          st.setString(1, id);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
               a = new Articulo();
                a.setCoda(rs.getString(1));
                a.setNomart(rs.getString(2));
                a.setPrecio(rs.getDouble(3));
                a.setStk(rs.getInt(4));
	        
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return a;
    }

    @Override
    public Cliente busCli(String id) {
        Cliente a=null;
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql="select apellidos, nombres, password from articulos where idcliente=?";
            PreparedStatement st = conn.prepareStatement(sql);
          st.setString(1, id);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
               a = new Cliente();
                a.setCodc(id);
                a.setApe(rs.getString(2));
                a.setNom(rs.getString(3));
                a.setClave(rs.getString(4));
	        
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return a;
    }

    @Override
    public String grabaFact(String codc, List<Compra> lista) {
        String fac="";
        double sm=0;
        for(Compra x:lista) sm=sm+x.total();
        
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql="{call spfactura(?,?)}";
            CallableStatement st = conn.prepareCall(sql);
          st.setString(1, codc);
          st.setDouble(2, sm);
           ResultSet rs = st.executeQuery();
            rs.next();
            fac=rs.getString(1);
            String sql2="{call spdetalle(?,?,?)}";
            CallableStatement st2 = conn.prepareCall(sql2);
            
            for (Compra x:lista) {
           st2.setString(1, fac);
           st2.setString(2, x.getCoda());
           st2.setInt(3, x.getCantidad());
           st2.executeUpdate();
       }
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
return fac;
    }
    
}
