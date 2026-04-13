package com.docencia.ficheros;

import com.docencia.ficheros.repo.ClienteRepositoryJson;
import com.docencia.ficheros.repo.HotelRepositoryXml;
import com.docencia.ficheros.repo.ReservaRepositoryCsv;
import com.docencia.ficheros.repo.interfaces.IClienteRepository;
import com.docencia.ficheros.repo.interfaces.IHotelRepository;
import com.docencia.ficheros.repo.interfaces.IReservaRepository;
import com.docencia.ficheros.service.ReservaService;

public abstract class BaseTest {
    protected final IReservaRepository reservaRepository = new ReservaRepositoryCsv("data/reservas.csv");
    protected final IClienteRepository clienteRepository = new ClienteRepositoryJson("data/clientes.json");
    protected final IHotelRepository hotelRepository = new HotelRepositoryXml("data/hoteles.xml");
    protected final ReservaService service = new ReservaService(reservaRepository, clienteRepository, hotelRepository);
}
