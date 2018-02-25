package lookalike.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * An entity User composed by three fields (id, email, name).
 * The Entity annotation indicates that this class is a JPA entity.
 * The Table annotation specifies the name for the table in the db.
 *
 * @author netgloo
 */
@Entity
@Table(name = "dnb")
public class Dnb {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  @Id
  private Double ship_to_account_number;
  private String paperless;
  private String TOTAL_POPULATION;
  private String ETHNICITY_GROUP;
  private String CAMEO_GROUP;
  private String MAX_AGE_GROUP;
  private String AVG_HOUSEHOLD_INCOME;
  private String auto_pay;
  private String ach_setup;
  private String MAX_EDUCATION;
  private String CATEGORY;
  private String has_purchasepower;
  private String cc_setup;
  private String EMPLOYEE_SIZE_RANGE;
  private String CAMEO_CATEGORY;
  private Double SIC8_new;
  private String customer_group_desc;
  private Double one_Quarter_Spend;
  private Double one_Quarter_Txn;
  private Double two_Quarter_Spend;
  private Double two_Quarter_Txn;
  private Double three_Quarter_Spend;
  private Double three_Quarter_Txn;
  private Double Quarter_1_2_Spend;
  private Double Quarter_2_3_Spend;
  private Double Quarter_1_2_Txn;
  private Double Quarter_2_3_Txn;
  private String isExisting;
  private Double Score;
  private String pbi_value_segment;
  
	public Double getShip_to_account_number() {
		return ship_to_account_number;
	}
	public void setShip_to_account_number(Double ship_to_account_number) {
		this.ship_to_account_number = ship_to_account_number;
	}
	public String getPaperless() {
		return paperless;
	}
	public void setPaperless(String paperless) {
		this.paperless = paperless;
	}
	public String getTOTAL_POPULATION() {
		return TOTAL_POPULATION;
	}
	public void setTOTAL_POPULATION(String tOTAL_POPULATION) {
		TOTAL_POPULATION = tOTAL_POPULATION;
	}
	public String getETHNICITY_GROUP() {
		return ETHNICITY_GROUP;
	}
	public void setETHNICITY_GROUP(String eTHNICITY_GROUP) {
		ETHNICITY_GROUP = eTHNICITY_GROUP;
	}
	public String getCAMEO_GROUP() {
		return CAMEO_GROUP;
	}
	public void setCAMEO_GROUP(String cAMEO_GROUP) {
		CAMEO_GROUP = cAMEO_GROUP;
	}
	public String getMAX_AGE_GROUP() {
		return MAX_AGE_GROUP;
	}
	public void setMAX_AGE_GROUP(String mAX_AGE_GROUP) {
		MAX_AGE_GROUP = mAX_AGE_GROUP;
	}
	public String getAVG_HOUSEHOLD_INCOME() {
		return AVG_HOUSEHOLD_INCOME;
	}
	public void setAVG_HOUSEHOLD_INCOME(String aVG_HOUSEHOLD_INCOME) {
		AVG_HOUSEHOLD_INCOME = aVG_HOUSEHOLD_INCOME;
	}
	public String getAuto_pay() {
		return auto_pay;
	}
	public void setAuto_pay(String auto_pay) {
		this.auto_pay = auto_pay;
	}
	public String getAch_setup() {
		return ach_setup;
	}
	public void setAch_setup(String ach_setup) {
		this.ach_setup = ach_setup;
	}
	public String getMAX_EDUCATION() {
		return MAX_EDUCATION;
	}
	public void setMAX_EDUCATION(String mAX_EDUCATION) {
		MAX_EDUCATION = mAX_EDUCATION;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	public String getHas_purchasepower() {
		return has_purchasepower;
	}
	public void setHas_purchasepower(String has_purchasepower) {
		this.has_purchasepower = has_purchasepower;
	}
	public String getCc_setup() {
		return cc_setup;
	}
	public void setCc_setup(String cc_setup) {
		this.cc_setup = cc_setup;
	}
	public String getEMPLOYEE_SIZE_RANGE() {
		return EMPLOYEE_SIZE_RANGE;
	}
	public void setEMPLOYEE_SIZE_RANGE(String eMPLOYEE_SIZE_RANGE) {
		EMPLOYEE_SIZE_RANGE = eMPLOYEE_SIZE_RANGE;
	}
	public String getCAMEO_CATEGORY() {
		return CAMEO_CATEGORY;
	}
	public void setCAMEO_CATEGORY(String cAMEO_CATEGORY) {
		CAMEO_CATEGORY = cAMEO_CATEGORY;
	}
	public Double getSIC8_new() {
		return SIC8_new;
	}
	public void setSIC8_new(Double sIC8_new) {
		SIC8_new = sIC8_new;
	}
	public String getCustomer_group_desc() {
		return customer_group_desc;
	}
	public void setCustomer_group_desc(String customer_group_desc) {
		this.customer_group_desc = customer_group_desc;
	}
	public Double getOne_Quarter_Spend() {
		return one_Quarter_Spend;
	}
	public void setOne_Quarter_Spend(Double one_Quarter_Spend) {
		this.one_Quarter_Spend = one_Quarter_Spend;
	}
	public Double getOne_Quarter_Txn() {
		return one_Quarter_Txn;
	}
	public void setOne_Quarter_Txn(Double one_Quarter_Txn) {
		this.one_Quarter_Txn = one_Quarter_Txn;
	}
	public Double getTwo_Quarter_Spend() {
		return two_Quarter_Spend;
	}
	public void setTwo_Quarter_Spend(Double two_Quarter_Spend) {
		this.two_Quarter_Spend = two_Quarter_Spend;
	}
	public Double getTwo_Quarter_Txn() {
		return two_Quarter_Txn;
	}
	public void setTwo_Quarter_Txn(Double two_Quarter_Txn) {
		this.two_Quarter_Txn = two_Quarter_Txn;
	}
	public Double getThree_Quarter_Spend() {
		return three_Quarter_Spend;
	}
	public void setThree_Quarter_Spend(Double three_Quarter_Spend) {
		this.three_Quarter_Spend = three_Quarter_Spend;
	}
	public Double getThree_Quarter_Txn() {
		return three_Quarter_Txn;
	}
	public void setThree_Quarter_Txn(Double three_Quarter_Txn) {
		this.three_Quarter_Txn = three_Quarter_Txn;
	}
	public Double getQuarter_1_2_Spend() {
		return Quarter_1_2_Spend;
	}
	public void setQuarter_1_2_Spend(Double quarter_1_2_Spend) {
		Quarter_1_2_Spend = quarter_1_2_Spend;
	}
	public Double getQuarter_2_3_Spend() {
		return Quarter_2_3_Spend;
	}
	public void setQuarter_2_3_Spend(Double quarter_2_3_Spend) {
		Quarter_2_3_Spend = quarter_2_3_Spend;
	}
	public Double getQuarter_1_2_Txn() {
		return Quarter_1_2_Txn;
	}
	public void setQuarter_1_2_Txn(Double quarter_1_2_Txn) {
		Quarter_1_2_Txn = quarter_1_2_Txn;
	}
	public Double getQuarter_2_3_Txn() {
		return Quarter_2_3_Txn;
	}
	public void setQuarter_2_3_Txn(Double quarter_2_3_Txn) {
		Quarter_2_3_Txn = quarter_2_3_Txn;
	}
	public String getIsExisting() {
		return isExisting;
	}
	public void setIsExisting(String isExisting) {
		this.isExisting = isExisting;
	}
	public Double getScore() {
		return Score;
	}
	public void setScore(Double score) {
		Score = score;
	}
	public String getPbi_value_segment() {
		return pbi_value_segment;
	}
	public void setPbi_value_segment(String pbi_value_segment) {
		this.pbi_value_segment = pbi_value_segment;
	}
  
  
  
  
  
} // class User