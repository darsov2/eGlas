package mk.ukim.finki.eglas.services.Impl;

import mk.ukim.finki.eglas.model.Address;
import mk.ukim.finki.eglas.model.ElectoralUnit;
import mk.ukim.finki.eglas.model.PollingStation;
import mk.ukim.finki.eglas.repository.AddressRepository;
import mk.ukim.finki.eglas.repository.PollingStationRepository;
import mk.ukim.finki.eglas.services.AddressService;
import mk.ukim.finki.eglas.services.ElectoralUnitService;
import mk.ukim.finki.eglas.services.MunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MunicipalityService municipalityService;
    private final ElectoralUnitService electoralUnitService;
    private final PollingStationRepository pollingStationRepository;


    @Autowired
    AddressServiceImpl(AddressRepository addressRepository, MunicipalityService municipalityService, ElectoralUnitService electoralUnitService, PollingStationRepository pollingStationRepository){
        this.addressRepository = addressRepository;
        this.municipalityService = municipalityService;
        this.electoralUnitService = electoralUnitService;
        this.pollingStationRepository = pollingStationRepository;
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address findAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
    }


    @Override
    public Address updateAddress(Long id, String street, Integer houseNumber, Integer entranceNumber, Integer apartmentNumber, Long municipality, Long pollingStation) {
        Address address = new Address();
        if (id != null){
            address = findAddressById(id);
        }
        address.setStreet(street);
        address.setHouseNumber(houseNumber);
        address.setMunicipality(municipalityService.findById(municipality));
        address.setEntranceNumber(entranceNumber);
        address.setApartmentNumber(apartmentNumber);
//        address.setPollingStation(findPollingStationById(pollingStation));

        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.delete(findAddressById(id));
    }

    @Override
    public List<PollingStation> findAllPollingStations() {
        return pollingStationRepository.findAll();
    }

    @Override
    public PollingStation findPollingStationById(Long id) {
        return pollingStationRepository.findById(id).orElseThrow(() -> new RuntimeException("Polling Station not found"));
    }

    @Override
    public PollingStation updatePollingStation(Long id, String name, String street, Integer houseNumber, Integer entranceNumber, Integer apartmentNumber, Long municipality, Long electoralUnitId) {
        Address address = findByStreetLikeAndHouseNumberAndEntranceNumberAndApartmentNumberAAndMunicipality(street, houseNumber, entranceNumber, apartmentNumber, municipality);
        PollingStation poll = new PollingStation();
        if (id!= null){
            poll = findPollingStationById(id);
        }
        poll.setAddress(address);
        poll.setElectoralUnit(electoralUnitService.findById(electoralUnitId));
        poll.setName(name);
        return pollingStationRepository.save(poll);
    }


    @Override
    public PollingStation deletePollingStation(Long id) {
        PollingStation pollingStation = findPollingStationById(id);
        pollingStationRepository.delete(pollingStation);
        return pollingStation;
    }

    @Override
    public List<String> findStreetNames() {
        return addressRepository.findAllDistinctStreet();
    }

    @Override
    public Address findByStreetLikeAndHouseNumberAndEntranceNumberAndApartmentNumberAAndMunicipality(String street, Integer houseNumber, Integer entranceNumber, Integer apartmentNumber, Long municipality) {
        return addressRepository.findByStreetLikeAndHouseNumberAndEntranceNumberAndApartmentNumberAndMunicipality_Id(street, houseNumber, entranceNumber, apartmentNumber, municipality)
                .orElseGet(() -> updateAddress(null, street, houseNumber, entranceNumber, apartmentNumber, municipality, null));
    }
}
