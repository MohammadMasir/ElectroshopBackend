package com.electroshop.electroshop_backend;

import com.electroshop.electroshop_backend.measurement.domain.MeasurementType;
import com.electroshop.electroshop_backend.measurement.domain.ProductMeasurement;
import com.electroshop.electroshop_backend.measurement.domain.Unit;
import com.electroshop.electroshop_backend.measurement.enums.MeasurementCategory;
import com.electroshop.electroshop_backend.measurement.repository.MeasurementTypeRepository;
import com.electroshop.electroshop_backend.measurement.repository.ProductMeasurementRepository;
import com.electroshop.electroshop_backend.measurement.repository.UnitRepository;
import com.electroshop.electroshop_backend.product.domain.*;
import com.electroshop.electroshop_backend.product.enums.StockStatus;
import com.electroshop.electroshop_backend.product.repository.*;
import com.electroshop.electroshop_backend.user.domain.Vendor;
import com.electroshop.electroshop_backend.user.repository.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DummyDataGenerator implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final KeyFeaturesRepository keyFeaturesRepository;
    private final FeatureCategoryRepository featureCategoryRepository;
    private final ProductKeyFeatureRepository productKeyFeatureRepository;
    private final MeasurementTypeRepository  measurementTypeRepository;
    private final UnitRepository unitRepository;
    private final ProductMeasurementRepository productMeasurementRepository;
    private final ProductDetailsRepository productDetailsRepository;
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;
    private final VendorRepository vendorRepository;
    private final InventoryRepository inventoryRepository;

    public DummyDataGenerator(
            CategoryRepository categoryRepository,
            BrandRepository brandRepository,
            ModelRepository modelRepository,
            KeyFeaturesRepository keyFeaturesRepository,
            FeatureCategoryRepository featureCategoryRepository,
            ProductKeyFeatureRepository productKeyFeatureRepository,
            MeasurementTypeRepository measurementTypeRepository,
            UnitRepository unitRepository,
            ProductDetailsRepository productDetailsRepository,
            ProductRepository productRepository,
            WarehouseRepository warehouseRepository,
            VendorRepository vendorRepository,
            InventoryRepository inventoryRepository,
            ProductMeasurementRepository productMeasurementRepository){
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.keyFeaturesRepository = keyFeaturesRepository;
        this.featureCategoryRepository = featureCategoryRepository;
        this.productKeyFeatureRepository = productKeyFeatureRepository;
        this.measurementTypeRepository = measurementTypeRepository;
        this.unitRepository = unitRepository;
        this.productDetailsRepository = productDetailsRepository;
        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
        this.vendorRepository = vendorRepository;
        this.inventoryRepository = inventoryRepository;
        this.productMeasurementRepository = productMeasurementRepository;
    }

    private Product generateProductsRelatedData() {

        // Create Category..
        Category category = new Category();
        category.setName("Laptop");
        categoryRepository.save(category);

        // Create Brand..
        Brand brand = new Brand();
        brand.setName("Samsung");
        brandRepository.save(brand);

        // Create Model..
        Model model = new Model();
        model.setName("Galaxy Book3 Pro 360");
        model.setBrandModel(brand);
        modelRepository.save(model);

        // Create KeyFeature..
        KeyFeatures keyFeatures = new KeyFeatures();
        keyFeatures.setFeatureName("Processor");
        keyFeaturesRepository.save(keyFeatures);

        // Create FeatureCategory..
        FeatureCategory featureCategory = new FeatureCategory();
        featureCategory.setCategory(category);
        featureCategory.setKeyFeatures(keyFeatures);
        featureCategoryRepository.save(featureCategory);

        // Create MeasurementType..
        MeasurementType measurementType = new MeasurementType();
        measurementType.setName("Screen Size");
        measurementType.setMeasurementCategory(MeasurementCategory.LENGTH);
        measurementType.setDescription("No description");
        measurementTypeRepository.save(measurementType);

        // Create Unit..
        Unit unit = new Unit();
        unit.setName("Inch");
        unit.setIsBaseUnit(false);
        unit.setConversionFactor(BigDecimal.valueOf(0.0254));
        unit.setSymbol("inch");
        unit.setMeasurementCategory(MeasurementCategory.LENGTH);
        unitRepository.save(unit);

        // Create Product..
        Product  product = new Product();
        product.setCategory(category);
        product.setBrand(brand);
        product.setModel(model);
        product.setName("Samsung Galaxy Book3 Pro 360 Laptop");
        product.setColor("Beige Brown");
        product.setPrice(BigDecimal.valueOf(190000));
        product.setDescription("A one of a Samsung Laptop..");
        productRepository.save(product);

        // Create ProductMeasurement..
        ProductMeasurement productMeasurement = new ProductMeasurement();
        productMeasurement.setMeasurementType(measurementType);
        productMeasurement.setUnit(unit);
        productMeasurement.setValue(BigDecimal.valueOf(15.6));
        productMeasurement.setMeasurementProduct(product);
        productMeasurementRepository.save(productMeasurement);

        // Create ProductKeyFeature..
        ProductKeyFeature productKeyFeature = new ProductKeyFeature();
        productKeyFeature.setProdFeature(product);
        productKeyFeature.setKeyFeatures(keyFeatures);
        productKeyFeature.setValue("Intel i7 10th Generation");
        productKeyFeatureRepository.save(productKeyFeature);

        // Create ProductDetails..
        ProductDetails productDetails = new ProductDetails();
        productDetails.setDetailsProduct(product);
        productDetails.setSpecificationName("Refresh Rate");
        productDetails.setSpecificationDetails("144Hz");
        productDetailsRepository.save(productDetails);

        return product;

    }

    private void generateInventoryData() {

        // Create Warehouse..
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseName("Kapadiya Godown");
        warehouse.setWarehouseAddress("Kapadia Kurla West");
        warehouseRepository.save(warehouse);

        // Create Vendor..
        Vendor vendor = new Vendor();
        vendor.setVendorName("Galeecha Manufacturers");
        vendor.setVendorAddress("Sakinaka, Andheri West");
        vendorRepository.save(vendor);

        // Create Inventory..
        Inventory inventory = new Inventory();
        inventory.setInventoryVendor(vendor);
        inventory.setInventoryWarehouse(warehouse);
        inventory.setQuantity(800);
        inventory.setMinimumCount(100);
        inventory.setStockStatus(StockStatus.AVAILABLE);
        inventory.setInventoryProduct(generateProductsRelatedData());
        inventoryRepository.save(inventory);

    }

    @Override
    public void run(String... args) throws Exception {
        generateInventoryData();
    }

}
