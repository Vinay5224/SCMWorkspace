package com.SCMXPert.sbmongodb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SCMXPert.sbmongodb.document.Customer;
import com.SCMXPert.sbmongodb.document.DeviceData;
import com.SCMXPert.sbmongodb.document.DeviceDataStream;
import com.SCMXPert.sbmongodb.document.Devices;
import com.SCMXPert.sbmongodb.document.FiltersData;
import com.SCMXPert.sbmongodb.document.ShipmentDetails;
import com.SCMXPert.sbmongodb.document.ShipmentTransactionDeviceData;
import com.SCMXPert.sbmongodb.document.ShipmentTransactions;
import com.SCMXPert.sbmongodb.document.Shipments;
import com.SCMXPert.sbmongodb.repository.CustomerRepository;
import com.SCMXPert.sbmongodb.repository.DeviceDataStreamRepository;
import com.SCMXPert.sbmongodb.repository.DevicesRepository;
import com.SCMXPert.sbmongodb.repository.ShipmentTransactionsRepository;
import com.SCMXPert.sbmongodb.repository.ShipmentsRepository;

@Controller
@RequestMapping("/SCMXPert")
public class DashboardController {

	@Autowired
	private ShipmentsRepository shiprepo;

	@Autowired
	private ShipmentTransactionsRepository shiptransrepo;

	@Autowired
	private CustomerRepository customerepo;

	@Autowired
	private DeviceDataStreamRepository devicedatarepo;

	@Autowired
	private DevicesRepository devicerepo;

	@ResponseBody
	@GetMapping("/getShipmentTransaction/{Customer_Id}")
	public List<ShipmentTransactions> getshipmentstrans(@PathVariable String Customer_Id) {

		/*
		 * Shipments ship = shiprepo.findByCustomer_Id(Customer_Id.trim());
		 * System.out.println("Delivered Status "+ship.getShipment_Status() +
		 * "  Delivered_Date.Date  "+ ship.getDelivered_Date().getDate()
		 * +"  Comments "+ship.getComments().toString() ); ShipmentTransactions
		 * shipTran = shiptransrepo.findBySingleCustomer_Id(Customer_Id.trim());
		 * Devices device = devicerepo.findByBP_Id(shipTran.getBP_Id());
		 * System.out.println("\n "+device.getImeiNumber()); DeviceDataStream
		 * deviceStream =
		 * devicedatarepo.findByModem_IMEI(device.getImeiNumber());
		 * System.out.println("\n "+deviceStream.getSensorId());
		 */
		List<ShipmentTransactions> sp = shiptransrepo.findByCustomer_Id(Customer_Id.trim());

		return sp;
	}

	
	//Filters Rest EndPoints
	@ResponseBody
	@GetMapping("/getFiltersData/{Customer_Id}")
	public FiltersData getFilters(@PathVariable(value = "Customer_Id") String Customer_id) {

		/*
		 * System.out.println("Coming"); Customer cus =
		 * customerepo.findByCustomer_id(Customer_id.trim()); FiltersData fd =
		 * new FiltersData();
		 * fd.setBusiness_Partner_Id(cus.getBusiness_Partner_Id());
		 * fd.setDepartments(cus.getDepartments());
		 * fd.setDevice_Id(cus.getDevice_Id()); fd.setGoods(fd.getGoods());
		 */
		return customerepo.findByCustomer_id(Customer_id.trim());
	}

	
	//Get Shipments RestEndpoints
	@ResponseBody
	@GetMapping("/getShipments/{Customer_Id}/{Created_By}")
	public List<ShipmentDetails> getShipmentsInfo(@PathVariable(value = "Customer_Id") String Customer_id,
			@PathVariable(value = "Created_By") String Created_By) {

		List<ShipmentDetails> spd = new ArrayList<ShipmentDetails>();
		List<Shipments> sp = shiprepo.getShipments(Customer_id.trim(), Created_By.trim());
		for (Shipments shp : sp) {

			ShipmentDetails innerSpd = new ShipmentDetails();
			innerSpd.setCustomer_Id(shp.getCustomer_Id());
			innerSpd.setCreated_By(shp.getCreated_By());
			innerSpd.setShipment_Id(shp.getShipment_Id());
			innerSpd.setShipment_Num(shp.getShipment_Num());
			innerSpd.setRoute_From(shp.getRoute_From());
			innerSpd.setRoute_To(shp.getRoute_To());
			innerSpd.setCreated_Date(shp.getCreated_Date());
			innerSpd.setEstimated_Delivery_Date(shp.getEstimated_Delivery_Date());
			innerSpd.setDelivered_Date(shp.getDelivered_Date());
			innerSpd.setDelivered_Status(shp.getShipment_Status());

			List<ShipmentTransactions> innerSPT = shiptransrepo.findByShipment_Id(shp.getShipment_Id().trim());
			innerSpd.setDevice_Id(innerSPT.get(0).getDevice_Id());
			innerSpd.setEvent_Status(shiptransrepo.event_status(shp.getShipment_Id().trim()));
			
			innerSpd.setWayPoints(shiptransrepo.getlatLong(innerSPT.get(0).getDevice_Id(), shp.getCreated_Date()).toString());
			spd.add(innerSpd);

		}

		return spd;
	}

	// DeviceData RestEndPoint
	@ResponseBody
	@GetMapping("/getDeviceData/{Device_Id}/{UTC}")
	public List<DeviceData> getDeviceData(@PathVariable(value = "Device_Id") String Device_Id,
			@PathVariable(value = "UTC") String UTC) {

		List<DeviceData> deviceData = new ArrayList<DeviceData>();
		List<DeviceDataStream> deviceDataStream = devicedatarepo.getDeviceDataStream(Device_Id.trim(), UTC.trim());

		for (DeviceDataStream dds : deviceDataStream) {

			DeviceData dd = new DeviceData();
			dd.setAltitude(dds.getAltitude());
			dd.setBAT(dds.getBAT());
			dd.setDevice_Id(dds.getDevice_Id());
			dd.setDistance(dds.getDistance());
			dd.setInternal_Temperature(dds.getInternal_temperature());
			dd.setLatitude(dds.getLatitude());
			dd.setLongitude(dds.getLongitude());
			dd.setMessage_Number(dds.getMessage_Number());
			dd.setReport_type(dds.getReport_type());
			dd.setSensor_id(dds.getSensor_id());
			dd.setSpeed(dds.getSpeed());
			dd.setTemp_Measurment(dds.getTemp_Measurment());
			dd.setUTC(dds.getUTC());

			deviceData.add(dd);

		}

		return deviceData;

	}

	
	//getShipmentTransaction and deviceDatastream data
	// DeviceData RestEndPoint
	@ResponseBody
	@GetMapping("/getShipmentTransactionDeviceData/{Shipment_Id}")
	public List<ShipmentTransactionDeviceData> getShipmentTransaction(@PathVariable(value = "Shipment_Id") String Shipment_Id) {
		
		List<ShipmentTransactionDeviceData> shiptranDevData = new ArrayList<ShipmentTransactionDeviceData>();
		List<ShipmentTransactions> shipTrans = new ArrayList<ShipmentTransactions>();
		DeviceDataStream dds = new DeviceDataStream();
		
		shipTrans = shiptransrepo.findByShipment_Id(Shipment_Id.trim());
		
		if(shipTrans.size()!=0){		
			dds = devicedatarepo.getDeviceDataStreamSingleDocumentDate(shipTrans.get(0).getDevice_Id().trim());
			
			for(ShipmentTransactions shpTran : shipTrans){
				
				ShipmentTransactionDeviceData shpTranDD = new ShipmentTransactionDeviceData();
				shpTranDD.setShipment_Id(shpTran.getShipment_Id());
				shpTranDD.setShipment_Num(shpTran.getShipment_Num());
				shpTranDD.setEvent_Name(shpTran.getEvent_Name());
				shpTranDD.setMode_of_Transport(shpTran.getMode_of_Transport());
				shpTranDD.setDevice_Id(shpTran.getDevice_Id());
				shpTranDD.setAltitude(dds.getAltitude());
				shpTranDD.setBAT(dds.getBAT());
				shpTranDD.setDistance(dds.getDistance());
				shpTranDD.setInternal_temperature(dds.getInternal_temperature());
				shpTranDD.setLatitude(dds.getLatitude());
				shpTranDD.setLongitude(dds.getLongitude());
				shpTranDD.setMessage_Number(dds.getMessage_Number());
				shpTranDD.setReport_type(dds.getReport_type());
				shpTranDD.setSensor_id(dds.getSensor_id());
				shpTranDD.setSpeed(dds.getSpeed());
				shpTranDD.setTemp_Measurment(dds.getTemp_Measurment());
				shpTranDD.setUTC(dds.getUTC());
				shiptranDevData.add(shpTranDD);
			}
			
		}
		
		
				
	return shiptranDevData;
	}
	
	
}
