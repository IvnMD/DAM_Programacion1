package com.docencia.ficheros.repo;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.docencia.ficheros.model.Hotel;
import com.docencia.ficheros.repo.interfaces.IHotelRepository;
import com.docencia.ficheros.util.ResourceUtils;

public class HotelRepositoryXml implements IHotelRepository {

    private List<Hotel> hoteles;
    private final String path;

    public HotelRepositoryXml(String resourcePath) {
        this.path = resourcePath;
    }

    @Override
    public List<Hotel> findAll() {
        try (InputStream is = ResourceUtils.getResourceAsStream(path)) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(is);

            NodeList lista = doc.getElementsByTagName("hotel");
            for (int i = 0; i < lista.getLength(); i++) {
                Element el = (Element) lista.item(i);
                int id = Integer.parseInt(el.getElementsByTagName("id").item(0).getTextContent());
                String nombre = el.getElementsByTagName("nombre").item(0).getTextContent();
                double precioNoche = Double
                        .parseDouble(el.getElementsByTagName("precioNoche").item(0).getTextContent());

                Hotel hotel = new Hotel(id, nombre, precioNoche);
                hoteles.add(hotel);
            }
            return hoteles;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Hotel findById(int id) {
        Hotel hotel = new Hotel();
        try (InputStream is = ResourceUtils.getResourceAsStream(path)) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(is);

            NodeList lista = doc.getElementsByTagName("hotel");
            for (int i = 0; i < lista.getLength(); i++) {
                Element el = (Element) lista.item(i);
                String nombre = el.getElementsByTagName("nombre").item(0).getTextContent();
                double precioNoche = Double
                        .parseDouble(el.getElementsByTagName("precioNoche").item(0).getTextContent());

                hotel = new Hotel(id, nombre, precioNoche);
            }
            return hotel;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
