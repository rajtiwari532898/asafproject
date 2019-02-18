/**
 * 
 */
package com.tcs.dvt.bean;
/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.comdata.posa.cardholder.TransactionDetails;
import com.comdata.posa.cardholder.TransactionRequest;
import com.comdata.posa.cardholder.TransactionServiceImpl;
import com.comdata.posa.common.SortableList;
import com.comdata.posa.constant.PosaConstant;
import com.comdata.posa.exception.BusinessException;
import com.comdata.posa.util.CommonUtil;
import com.comdata.posa.util.GetDBConnection;
import com.comdata.prepaid.account.Transaction;
import com.comdata.prepaid.cardholer.Cardholder;
import com.informatica.powercenter.sdk.lm.DriverFactory;
import com.informatica.powercenter.sdk.lm.EJLMRequestMode;
import com.informatica.powercenter.sdk.lm.EJLMWorkflowStatus;
import com.informatica.powercenter.sdk.lm.IJLMConnection;
import com.informatica.powercenter.sdk.lm.IJLMDate;
import com.informatica.powercenter.sdk.lm.IJLMDriver;
import com.informatica.powercenter.sdk.lm.IJLMStartWorkflowReplyDetail;
import com.informatica.powercenter.sdk.lm.IJLMWorkflow;
import com.informatica.powercenter.sdk.lm.IJLMWorkflowDetails;
import com.informatica.powercenter.sdk.lm.JLMException;
*/
/**
 * @author 195964
 * 
 */
public class TransactionDetBean {
	//private static final Logger M_LOGGER = Logger.getLogger(TransactionDetBean.class);
	/*private FacesContext context = FacesContext.getCurrentInstance();
	private HttpSession session = (HttpSession) context.getExternalContext()
			.getSession(true);
	private String screenNav = null;
	private Date startDate;
	private Date endDate;
	private List<TransactionDetails> transListInfo;
	private List<TransactionDetails> transListInfoPosted;
	private String cardNumber;
	private String expDate;
	private double acctbalance;
	private String acctStatus;
	private String init;
	private String dateSel;
	private boolean visibleDates;
	private boolean visibleData;
	private boolean visibleDataPosted;
	private UIData dataTableBinding;
	private UIData dataTableBindingPosted;
	private SortEnableList sortEnableList;
	private SortPostedList sortPostedList;

	private String tranDateColName;
	private String tranDateColNamePosted;
	private Comparator<TransactionDetails> comparator;
	private Comparator<TransactionDetails> comparatorTran;
	private boolean visiblePopup;
	private boolean visibleDtPopup;
	private String bal;
	private String strbalance;
	private String cardNo;
	private String cardHolderName;
	private boolean nodata;
	private boolean nodataPending;
	private boolean nodataPosted;
	private boolean driverInit = false;
	private List<WorkflowBean> workflowList = new ArrayList<WorkflowBean>();

	private boolean renderWfDtlsPopup;
	private boolean renderWfAvgRunTimePopup;

	private WorkflowBean workflowBean;
	private IJLMConnection connection;

	public List<WorkflowBean> getWorkflowList() {
		return workflowList;
	}

	public void setWorkflowList(List<WorkflowBean> workflowList) {
		this.workflowList = workflowList;
	}

	*//**
	 * @return the visibleDtPopup
	 *//*
	public boolean isVisibleDtPopup() {
		return visibleDtPopup;
	}

	*//**
	 * @param visibleDtPopup
	 *            the visibleDtPopup to set
	 *//*
	public void setVisibleDtPopup(boolean visibleDtPopup) {
		this.visibleDtPopup = visibleDtPopup;
	}

	*//**
	 * @return the visiblePopup
	 *//*
	public boolean isVisiblePopup() {
		return visiblePopup;
	}

	*//**
	 * @param visiblePopup
	 *            the visiblePopup to set
	 *//*
	public void setVisiblePopup(boolean visiblePopup) {
		this.visiblePopup = visiblePopup;
	}

	*//**
	 * TransactionDetBean constructor
	 *//*
	public TransactionDetBean() {

	}

	*//**
	 * @author TCS This method checkDates
	 * @param void
	 * @return int
	 *//*
	public int checkDates() {
		int flag = 1;
		// Date Range must be within 90 Days
		Long days = CommonUtil.getNoOfDays(startDate, endDate);
		long noOfDays = days.longValue();
		// and within last 14 Months
		double monthsR = 0d;
		Calendar currentDate = Calendar.getInstance();
		Date tempDt = currentDate.getTime();
		Date todayDate = CommonUtil.changeDateFormatDt(tempDt);
		if (!todayDate.equals(startDate)) {
			Double monthsRange = CommonUtil.monthsBetween(todayDate, startDate);
			monthsR = monthsRange.doubleValue();
		}
		if (noOfDays > (Integer.parseInt(CommonUtil
				.getProperty(PosaConstant.NO_OF_DAYS)))
				|| monthsR <= -(Integer.parseInt(CommonUtil
						.getProperty(PosaConstant.NO_OF_MONTHS)))) {
			visiblePopup = true;
			screenNav = PosaConstant.TRANS_DET;
			flag = 0;
		}
		if (startDate.after(endDate)) {
			visibleDtPopup = true;
			screenNav = PosaConstant.TRANS_DET;
			flag = 0;
		}

		return flag;
	}

	*//**
	 * @author TCS This method getTransactionList
	 * @param void
	 * @return String
	 *//*
	public String getTransactionList() {
		// Check range if dates entered by user
		int showError = 1;
		if (visibleDates) {
			showError = this.checkDates();
			nodataPosted = false;
			nodataPending = false;
			visibleData = false;
			visibleDataPosted = false;
		}
		if (showError == 1) {
			Cardholder cardHolder = (Cardholder) session
					.getAttribute("cardHolderDet");
			String acctNumber = (String) session
					.getAttribute("parentAcctNumber");
			String cardNumber1 = (String) session.getAttribute("cardNumber");
			if (cardHolder == null) {
				screenNav = PosaConstant.HOME_NAV;
			} else {
				try {
					// Setting the transaction details
					TransactionDetails transDet = null;
					TransactionRequest tranReq = new TransactionRequest();
					tranReq.setAccountNumber(acctNumber);
					tranReq.setCardHolderRefNumber(cardHolder
							.getCardholderReferenceNumber());
					tranReq.setStartDate(CommonUtil
							.changeDateToCalender(startDate));
					tranReq
							.setEndDate(CommonUtil
									.changeDateToCalender(endDate));
					tranReq.setCardNumber(cardNumber1);
					TransactionServiceImpl tranImpl = new TransactionServiceImpl();
					List<Transaction> transList = new ArrayList<Transaction>();
					List<Transaction> transList1 = new ArrayList<Transaction>();
					if (!"".equals(tranReq.getCardHolderRefNumber())) {
						// For pending Transaction
						tranReq
								.setTransactionType(PosaConstant.TRANSACTION_TYPE_PENDING);
						transList = (ArrayList<Transaction>) tranImpl
								.getTransactionList(tranReq);
						// For Posted Transaction
						tranReq
								.setTransactionType(PosaConstant.TRANSACTION_TYPE_POSTED);
						transList1 = (ArrayList<Transaction>) tranImpl
								.getTransactionList(tranReq);
					}
					List<TransactionDetails> transDetailList = new ArrayList<TransactionDetails>();
					if (transList != null && transList.size() > 0) {
						for (int count = 0; count < transList.size(); count++) {
							// System.out.println("This is the card No "+((Transaction)transList.get(count)).getCardNumber());
							transDet = new TransactionDetails();
							transDet
									.setTransactionDate(CommonUtil
											.changeDateFormatToYyyyMmDd(((Transaction) transList
													.get(count))
													.getTransactionDate()
													.getTime()));
							transDet
									.setTranDate(((Transaction) transList
											.get(count)).getTransactionDate()
											.getTime());
							// transDet.setPostedDate(CommonUtil.changeDateFormatToYyyyMmDd(((Transaction)transList.get(count)).getPostedDate().getTime()));
							transDet
									.setPostedDate(PosaConstant.TRANSACTION_TYPE_DISPLAY);
							transDet
									.setTransactionRecordID(((Transaction) transList
											.get(count))
											.getTransactionRecordID());
							transDet.setTransactionDet(((Transaction) transList
									.get(count)).getMerchantDetails());
							transDet
									.setSettlementAmount(((Transaction) transList
											.get(count)).getSettlementAmount()
											.getAmount());
							transDet
									.setSettlementCurrency(((Transaction) transList
											.get(count)).getSettlementAmount()
											.getCurrency());
							transDet.setSettleAmount(((Transaction) transList
									.get(count)).getSettlementAmount()
									.getAmount().toString());
							transDet.setLocation(((Transaction) transList
									.get(count)).getMerchantCity());
							transDet.setTransType(((Transaction) transList
									.get(count)).getTransType());
							transDetailList.add(transDet);
						}
						this.setTransListInfo(transDetailList);
						visibleData = true;

					} else {
						visibleData = false;
						nodataPending = true;
					}
					//
					List<TransactionDetails> transDetailList1 = new ArrayList<TransactionDetails>();
					if (transList1 != null && transList1.size() > 0) {
						for (int count = 0; count < transList1.size(); count++) {
							// System.out.println("This is the card No "+((Transaction)transList.get(count)).getCardNumber());
							transDet = new TransactionDetails();
							transDet
									.setTransactionDate(CommonUtil
											.changeDateFormatToYyyyMmDd(((Transaction) transList1
													.get(count))
													.getTransactionDate()
													.getTime()));
							transDet
									.setTranDate(((Transaction) transList1
											.get(count)).getTransactionDate()
											.getTime());
							transDet
									.setPostedDate(CommonUtil
											.changeDateFormatToYyyyMmDd(((Transaction) transList1
													.get(count))
													.getPostedDate().getTime()));
							transDet
									.setTransactionRecordID(((Transaction) transList1
											.get(count))
											.getTransactionRecordID());
							transDet
									.setTransactionDet(((Transaction) transList1
											.get(count)).getMerchantDetails());
							transDet
									.setSettlementAmount(((Transaction) transList1
											.get(count)).getSettlementAmount()
											.getAmount());
							transDet
									.setSettlementCurrency(((Transaction) transList1
											.get(count)).getSettlementAmount()
											.getCurrency());
							transDet.setSettleAmount(((Transaction) transList1
									.get(count)).getSettlementAmount()
									.getAmount().toString());
							transDet.setLocation(((Transaction) transList1
									.get(count)).getMerchantCity());
							transDet.setTransType(((Transaction) transList1
									.get(count)).getTransType());
							transDetailList1.add(transDet);
						}
						this.setTransListInfoPosted(transDetailList1);
						visibleDataPosted = true;
					} else {
						nodataPosted = true;
						if (visibleData == false)
							nodata = true;
					}
					screenNav = PosaConstant.TRANS_DET;

				} catch (BusinessException ex) {
					M_LOGGER.debug(ex.getMessage());

				}
			}
		}
		return screenNav;
	}

	*//**
	 * @author TCS This method getTimeZone
	 * @param void
	 * @return TimeZone
	 *//*
	public TimeZone getTimeZone() {
		return java.util.TimeZone.getDefault();
	}

	*//**
	 * @return the transListInfo
	 *//*
	public List<TransactionDetails> getTransListInfo() {
		return transListInfo;
	}

	*//**
	 * @param transListInfo
	 *            the transListInfo to set
	 *//*
	public void setTransListInfo(List<TransactionDetails> transListInfo1) {
		this.transListInfo = transListInfo1;
	}

	*//**
	 * @return the cardNumber
	 *//*
	public String getCardNumber() {
		return cardNumber;
	}

	*//**
	 * @param cardNumber
	 *            the cardNumber to set
	 *//*
	public void setCardNumber(String cardNumber1) {
		this.cardNumber = cardNumber1;
	}

	*//**
	 * @return the expDate
	 *//*
	public String getExpDate() {
		return expDate;
	}

	*//**
	 * @param expDate
	 *            the expDate to set
	 *//*
	public void setExpDate(String expDate1) {
		this.expDate = expDate1;
	}

	*//**
	 * @return the acctbalance
	 *//*
	public double getAcctbalance() {
		return acctbalance;
	}

	*//**
	 * @param acctbalance
	 *            the acctbalance to set
	 *//*
	public void setAcctbalance(double acctbalance1) {
		this.acctbalance = acctbalance1;
	}

	*//**
	 * @return the acctStatus
	 *//*
	public String getAcctStatus() {
		return acctStatus;
	}

	*//**
	 * @param acctStatus
	 *            the acctStatus to set
	 *//*
	public void setAcctStatus(String acctStatus1) {
		this.acctStatus = acctStatus1;
	}

	*//**
	 * @author TCS This method loads initial details on page load when the
	 *         create exception button is clicked.
	 * @param void
	 * @return void
	 *//*
	private void initTransaction() {
		
		 * CardholderCardsDetail
		 * chCardHolder=(CardholderCardsDetail)session.getAttribute
		 * ("CardDetails"); this.setAcctbalance(chCardHolder.getBalance());
		 * this.setAcctStatus(chCardHolder.getCardStatus());
		 * this.setCardNumber(chCardHolder.getCardNumber());
		 * this.setExpDate(chCardHolder.getExpiryDate());
		 * this.setCardHolderName(chCardHolder.getCardHolderName()); String
		 * cardNum=chCardHolder.getCardNumber();
		 * this.setCardNo(cardNum.substring(12,cardNum.length()));
		 * this.setBal(chCardHolder.getBal());
		 * this.setStrbalance(chCardHolder.getStrbalance());
		 * this.setDateSel("Item1"); // This is to set the dates first time
		 * Calendar currentDate = Calendar.getInstance(); Date tempDt =
		 * currentDate.getTime();
		 * setEndDate(CommonUtil.changeDateFormatDt(tempDt));
		 * setStartDate(CommonUtil.getDateBeforeDays(30));
		 

		// //

		// IJLMConnection connection = null;
		IJLMDriver driver = null;

		try {
			driver = DriverFactory.getDriver("JLMDriver10");
			if (!driverInit) {
				driver
						.initialize("C:\\Documents and Settings\\382763\\Desktop\\locale\\locale");
				driver.createThreadLocale();
				driverInit = true;
			}
			connection = driver.getConnection("tick", 6020, 360, null);
			connection.login("", "infa_rep_srv", "U_JAPI", "U_JAPI", null);
		} catch (JLMException e) {
			e.printStackTrace();
		}

		init = "success";
		// //
		if (workflowList.size() == 0) {
			WorkflowBean workflowBean = new WorkflowBean();
			WorkflowBean workflowBean1 = new WorkflowBean();
			workflowBean.setWorkflowName("WF_1");
			workflowBean1.setWorkflowName("WF_INST");
			workflowList.add(workflowBean);
			workflowList.add(workflowBean1);
		}
	}

	*//**
	 * @author TCS This method loads initial details on page load.
	 * @param void
	 * @return String
	 *//*
	public String getInit() {
		if (init == null) {
			initTransaction();
		}
		return "value";
	}

	*//**
	 * @param init
	 *            the init to set
	 *//*
	public void setInit(String init) {
		this.init = init;
	}

	*//**
	 * @return the dateSel
	 *//*
	public String getDateSel() {
		return dateSel;
	}

	*//**
	 * @param dateSel
	 *            the dateSel to set
	 *//*
	public void setDateSel(String dateSel1) {
		this.dateSel = dateSel1;
	}

	*//**
	 * @return the visibleDates
	 *//*
	public boolean isVisibleDates() {
		return visibleDates;
	}

	*//**
	 * @param visibleDates
	 *            the visibleDates to set
	 *//*
	public void setVisibleDates(boolean visibleDates1) {
		this.visibleDates = visibleDates1;
	}

	*//**
	 * @return the tranDateColName
	 *//*
	public String getTranDateColName() {
		tranDateColName = "Transaction Date";
		return tranDateColName;
	}

	*//**
	 * @param tranDateColName
	 *            the tranDateColName to set
	 *//*
	public void setTranDateColName(String tranDateColName1) {
		this.tranDateColName = tranDateColName1;
	}

	*//**
	 * @author TCS This call to methods dateSelListner (Method to call action)
	 * @param ValueChangeEvent
	 * @return void
	 *//*
	public void dateSelListner(ValueChangeEvent evnt) {
		if (transListInfo != null && transListInfo.size() > 0) {
			this.transListInfo.clear();
			visibleData = false;
			visibleDataPosted = false;
		}
		if (transListInfoPosted != null && transListInfoPosted.size() > 0) {
			this.transListInfoPosted.clear();
			visibleData = false;
			visibleDataPosted = false;
		}
		nodataPosted = false;
		nodataPending = false;
		if (evnt.getNewValue() != null) {
			String choice = evnt.getNewValue().toString();
			if (choice.equalsIgnoreCase("Item4")) {
				visibleDates = true;
			} else {
				if (choice.equalsIgnoreCase("Item1")) {
					Calendar currentDate = Calendar.getInstance();
					Date tempDt = currentDate.getTime();
					setEndDate(CommonUtil.changeDateFormatDt(tempDt));
					setStartDate(CommonUtil.getDateBeforeDays(30));
					// this.setStartDate(startDate);
				} else {
					if (choice.equalsIgnoreCase("Item2")) {
						Calendar currentDate = Calendar.getInstance();
						Date tempDt = currentDate.getTime();
						setEndDate(CommonUtil.changeDateFormatDt(tempDt));
						setStartDate(CommonUtil.getDateBeforeDays(60));
					} else {
						if (choice.equalsIgnoreCase("Item3")) {
							Calendar currentDate = Calendar.getInstance();
							Date tempDt = currentDate.getTime();
							setEndDate(CommonUtil.changeDateFormatDt(tempDt));
							setStartDate(CommonUtil.getDateBeforeDays(90));
						}
					}
				}
				visibleDates = false;
			}
		}
	}

	*//**
	 * @return the startDate
	 *//*
	public Date getStartDate() {
		if (startDate != null) {
			// startDate=CommonUtil.changeDateFormatDt(startDate);
			return (Date) startDate.clone();
		} else {
			Calendar currentDate = Calendar.getInstance();
			Date startDate1 = currentDate.getTime();
			// startDate = CommonUtil.changeDateFormatDt(tempDt);
			return (Date) startDate1.clone();
		}
	}

	*//**
	 * @param startDate
	 *            the startDate to set
	 *//*
	public void setStartDate(Date startDate) {
		if (startDate != null) {
			this.startDate = (Date) startDate.clone();
		} else {
			this.startDate = null;
		}
	}

	*//**
	 * @return the endDate
	 *//*
	public Date getEndDate() {
		if (endDate != null) {
			// endDate=CommonUtil.changeDateFormatDt(endDate);
			return (Date) endDate.clone();
		} else {
			Calendar currentDate = Calendar.getInstance();
			Date endDate1 = currentDate.getTime();
			// endDate = CommonUtil.changeDateFormatDt(tempDt);
			return (Date) endDate1.clone();
		}

	}

	*//**
	 * @param endDate
	 *            the endDate to set
	 *//*
	public void setEndDate(Date endDate) {
		if (endDate != null) {
			this.endDate = (Date) endDate.clone();
		} else {
			this.endDate = null;
		}
	}

	*//**
	 * @return the dataTableBinding
	 *//*
	public UIData getDataTableBinding() {
		return dataTableBinding;
	}

	*//**
	 * @param dataTableBinding
	 *            the dataTableBinding to set
	 *//*
	public void setDataTableBinding(UIData dataTableBinding) {
		this.dataTableBinding = dataTableBinding;
	}

	*//**
	 * @return the visibleData
	 *//*
	public boolean isVisibleData() {
		return visibleData;
	}

	*//**
	 * @param visibleData
	 *            the visibleData to set
	 *//*
	public void setVisibleData(boolean visibleData) {
		this.visibleData = visibleData;
	}

	*//**
	 * Sorting on column
	 * 
	 * @param actionEvent
	 *//*
	@SuppressWarnings("unchecked")
	public void sortActionListen(ActionEvent actionEvent) {
		Map<String, Object> attributeList = actionEvent.getComponent()
				.getAttributes();
		String value = null;
		value = (String) attributeList.get(PosaConstant.VALUE);
		sortEnableList.setSortColumnName(value);
		if (getTransListInfo() != null && getTransListInfo().size() > 0) {
			sortEnableList.sort();
		}
	}

	public SortEnableList getSortEnableList() {
		if (sortEnableList == null) {
			sortEnableList = new SortEnableList();
			sortEnableList.initializeComparator();
		}
		return sortEnableList;
	}

	public void setSortEnableList(SortEnableList sortEnableListInp) {
		this.sortEnableList = sortEnableListInp;
	}

	class SortEnableList extends SortableList {
		SortEnableList() {
			super(tranDateColName);
		}

		@Override
		protected boolean isDefaultAscending(String sortColumn) {
			return ascending;
		}

		@Override
		protected void sort() {
			if (transListInfo != null && !transListInfo.isEmpty()
					&& transListInfo.size() > 0) {
				if (!oldSort.equals(sortColumnName)) {
					oldSort = sortColumnName;
					ascending = true;
				} else {
					oldAscending = ascending;
					ascending = !ascending;
				}
				Collections.sort(transListInfo, comparator);
			}
		}

		private void initializeComparator() {
			comparator = new Comparator<TransactionDetails>() {
				public int compare(TransactionDetails c1, TransactionDetails c2) {
					int index = 0;
					index = getIntialisedComparator(c1, c2, ascending,
							sortColumnName);
					return index;
				}
			};
		}
	}

	private int getIntialisedComparator(TransactionDetails c1,
			TransactionDetails c2, boolean ascending, String sortColumnName) {
		int index1 = 0;
		if (sortColumnName.equals(tranDateColName)) {
			index1 = PosaConstant.compareDates(ascending, c1.getTranDate(), c2
					.getTranDate());
		}
		return index1;
	}

	@SuppressWarnings("unchecked")
	public void sortActionListenPosted(ActionEvent actionEvent) {
		Map<String, Object> attributeList = actionEvent.getComponent()
				.getAttributes();
		String value = null;
		value = (String) attributeList.get(PosaConstant.VALUE);
		sortPostedList.setSortColumnName(value);
		if (getTransListInfoPosted() != null
				&& getTransListInfoPosted().size() > 0) {
			sortPostedList.sort();
		}
	}

	class SortPostedList extends SortableList {
		SortPostedList() {
			super(tranDateColNamePosted);
		}

		@Override
		protected boolean isDefaultAscending(String sortColumn) {
			return ascending;
		}

		@Override
		protected void sort() {
			if (transListInfoPosted != null && !transListInfoPosted.isEmpty()
					&& transListInfoPosted.size() > 0) {
				if (!oldSort.equals(sortColumnName)) {
					oldSort = sortColumnName;
					ascending = true;
				} else {
					oldAscending = ascending;
					ascending = !ascending;
				}
				Collections.sort(transListInfoPosted, comparatorTran);
			}
		}

		private void initializeComparatorPosted() {
			comparatorTran = new Comparator<TransactionDetails>() {
				public int compare(TransactionDetails c1, TransactionDetails c2) {
					int index = 0;
					index = getIntialisedComparatorPosted(c1, c2, ascending,
							sortColumnName);
					return index;
				}
			};
		}
	}

	private int getIntialisedComparatorPosted(TransactionDetails c1,
			TransactionDetails c2, boolean ascending, String sortColumnName) {
		int index1 = 0;
		if (sortColumnName.equals(tranDateColNamePosted)) {
			index1 = PosaConstant.compareDates(ascending, c1.getTranDate(), c2
					.getTranDate());
		}
		return index1;
	}

	*//**
	 * @return the sortPostedList
	 *//*
	public SortPostedList getSortPostedList() {
		if (sortPostedList == null) {
			sortPostedList = new SortPostedList();
			sortPostedList.initializeComparatorPosted();
		}
		return sortPostedList;
	}

	*//**
	 * @param sortPostedList
	 *            the sortPostedList to set
	 *//*
	public void setSortPostedList(SortPostedList sortPostedListInp) {
		this.sortPostedList = sortPostedListInp;
	}

	public String yesAction() {
		visiblePopup = false;
		visibleDtPopup = false;
		nodata = false;
		return PosaConstant.TRANS_DET;
	}

	*//**
	 * @return the cardNo
	 *//*
	public String getCardNo() {
		return cardNo;
	}

	*//**
	 * @param cardNo
	 *            the cardNo to set
	 *//*
	public void setCardNo(String cardNo1) {
		this.cardNo = cardNo1;
	}

	*//**
	 * @return the cardHolderName
	 *//*
	public String getCardHolderName() {
		return cardHolderName;
	}

	*//**
	 * @param cardHolderName
	 *            the cardHolderName to set
	 *//*
	public void setCardHolderName(String cardHolderName1) {
		this.cardHolderName = cardHolderName1;
	}

	*//**
	 * @return the bal
	 *//*
	public String getBal() {
		return bal;
	}

	*//**
	 * @param bal
	 *            the bal to set
	 *//*
	public void setBal(String bal1) {
		this.bal = bal1;
	}

	*//**
	 * @return the strbalance
	 *//*
	public String getStrbalance() {
		return strbalance;
	}

	*//**
	 * @param strbalance
	 *            the strbalance to set
	 *//*
	public void setStrbalance(String strbalance1) {
		this.strbalance = strbalance1;
	}

	*//**
	 * @return the nodata
	 *//*
	public boolean isNodata() {
		return nodata;
	}

	*//**
	 * @param nodata
	 *            the nodata to set
	 *//*
	public void setNodata(boolean nodata) {
		this.nodata = nodata;
	}

	*//**
	 * @return the visibleDataPosted
	 *//*
	public boolean isVisibleDataPosted() {
		return visibleDataPosted;
	}

	*//**
	 * @param visibleDataPosted
	 *            the visibleDataPosted to set
	 *//*
	public void setVisibleDataPosted(boolean visibleDataPosted) {
		this.visibleDataPosted = visibleDataPosted;
	}

	*//**
	 * @return the transListInfoPosted
	 *//*
	public List<TransactionDetails> getTransListInfoPosted() {
		return transListInfoPosted;
	}

	*//**
	 * @param transListInfoPosted
	 *            the transListInfoPosted to set
	 *//*
	public void setTransListInfoPosted(
			List<TransactionDetails> transListInfoPosted) {
		this.transListInfoPosted = transListInfoPosted;
	}

	*//**
	 * @return the dataTableBindingPosted
	 *//*
	public UIData getDataTableBindingPosted() {
		return dataTableBindingPosted;
	}

	*//**
	 * @param dataTableBindingPosted
	 *            the dataTableBindingPosted to set
	 *//*
	public void setDataTableBindingPosted(UIData dataTableBindingPosted) {
		this.dataTableBindingPosted = dataTableBindingPosted;
	}

	*//**
	 * @return the tranDateColNamePosted
	 *//*
	public String getTranDateColNamePosted() {
		tranDateColNamePosted = "Transaction Date";
		return tranDateColNamePosted;
	}

	*//**
	 * @param tranDateColNamePosted
	 *            the tranDateColNamePosted to set
	 *//*
	public void setTranDateColNamePosted(String tranDateColNamePosted) {
		this.tranDateColNamePosted = tranDateColNamePosted;
	}

	*//**
	 * sortActionListen
	 * 
	 * @return the nodataPending
	 *//*
	public boolean isNodataPending() {
		return nodataPending;
	}

	*//**
	 * @param nodataPending
	 *            the nodataPending to set
	 *//*
	public void setNodataPending(boolean nodataPending) {
		this.nodataPending = nodataPending;
	}

	*//**
	 * @return the nodataPosted
	 *//*
	public boolean isNodataPosted() {
		return nodataPosted;
	}

	*//**
	 * @param nodataPosted
	 *            the nodataPosted to set
	 *//*
	public void setNodataPosted(boolean nodataPosted) {
		this.nodataPosted = nodataPosted;
	}

	*//**
	 * @return the comparatorTran
	 *//*
	public Comparator<TransactionDetails> getComparatorTran() {
		return comparatorTran;
	}

	*//**
	 * @param comparatorTran
	 *            the comparatorTran to set
	 *//*
	public void setComparatorTran(Comparator<TransactionDetails> comparatorTran1) {
		this.comparatorTran = comparatorTran1;
	}

	public void showPage(ActionEvent event) {

	}

	public String startWorkflow() {
		WorkflowBean workflowBean = (WorkflowBean) (dataTableBinding
				.getRowData());
		workflowBean.setWorkflowStatus(startWorkflowAction(workflowBean
				.getWorkflowName()));
		System.out.println("Informatica response : "
				+ workflowBean.getWorkflowStatus());
		return "";
	}

	public String startWorkflowAction(final String workflowName) {
		String message = "";

		try {
			final IJLMWorkflow workflow = connection.getWorkflow("IPN",
					workflowName, null);
			workflow.setWorkflowReason("Starting from Webpage");
			final IJLMStartWorkflowReplyDetail startWorkflowReplyDetail = workflow
					.startEx(EJLMRequestMode.NORMAL, null);
			final int workflowRunId = startWorkflowReplyDetail.getRunId();
			final IJLMWorkflowDetails wkdetails = workflow
					.getWorkflowDetails(null);
			final EJLMWorkflowStatus wkstatus = wkdetails
					.getWorkflowRunStatus();
			message = "Workflow " + workflowName + " is " + wkstatus.toString()
					+ " with run id " + workflowRunId;
		} catch (final JLMException e) {
			e.printStackTrace();
		}
		// finally {
		// if(connection != null) {
		// try {
		// connection.close(null);
		// //driver.deinitialize();
		// } catch (JLMException e) {
		// e.printStackTrace();
		// }
		// }
		// }
		return message;
	}

	public void getWorkflowAvgRunTime() {
		WorkflowBean workflowBean = (WorkflowBean) (dataTableBinding
				.getRowData());
		getWorkflowAvgRunTime(workflowBean);
	}
	
	private void getWorkflowAvgRunTime(WorkflowBean workflowBean) {
		Connection conn = null;
       	PreparedStatement ps = null;
       	ResultSet rs = null;
		String query = "select OWR.workflow_NAME, sum((OWR.END_TIME - OWR.START_TIME)*24*60*60)/count(OWR.workflow_NAME) \"Time_Seconds\" from opb_task OT JOIN OPB_WFLOW_RUN OWR ON OT.TASK_ID = OWR.WORKFLOW_ID and OWR.subject_id = (select subj_id from opb_subject where UPPER(subj_name) = 'IPN') and upper(OWR.WORKFLOW_NAME) = '"+workflowBean.getWorkflowName()+"' group by OWR.workflow_NAME";
		try {
			conn = GetDBConnection.getConnection("jdbc:oracle:thin:@tick:1521:orcl", "INFA_REP", "INFA_REP");
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
       		if(rs.next())
       		{
       			workflowBean.setWorkflowName(rs.getString(1));
       			workflowBean.setAvgRunTime(formatIntoHHMMSS(rs.getLong(2)));
       			System.out.println("Workflow Name " + rs.getString(1));
       			System.out.println("Avg Run Time " + rs.getString(2));
       		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (rs != null) {

					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				

			} catch (SQLException exception) {

				exception.printStackTrace();

			} 
		}
		this.workflowBean = workflowBean;
	}
	
	public void getWorkflowRunDetails() {
		WorkflowBean workflowBean = (WorkflowBean) (dataTableBinding
				.getRowData());
		getWorkflowdTLSAction(workflowBean);
		
	}

	private void getWorkflowdTLSAction(WorkflowBean workflowBean) {

		String startTime = "";
		String endTime = "";
		try {
			final IJLMWorkflow workflow = connection.getWorkflow("IPN",
					workflowBean.getWorkflowName(), null);
			workflow.setWorkflowReason("Starting from Webpage");
			// final IJLMStartWorkflowReplyDetail startWorkflowReplyDetail =
			// workflow.startEx(EJLMRequestMode.NORMAL, null);
			IJLMWorkflowDetails wfDetails = workflow.getWorkflowDetails(null);
			workflowBean.setWorkflowId(wfDetails.getWorkflowId());
			workflowBean.setWfRunId(wfDetails.getWorkflowRunId());

			// fetching Workflow Start Time
			final IJLMDate wfStartTime = wfDetails.getStartTime();

			startTime = wfStartTime.getDate() + "-" + wfStartTime.getMonth()
					+ "-" + wfStartTime.getYear() + "  "
					+ wfStartTime.getHours() + ":" + wfStartTime.getMinutes()
					+ ":" + wfStartTime.getSeconds();

			workflowBean.setStartTime(startTime);

			// fetching Workflow End Time
			final IJLMDate wfEndTime = wfDetails.getEndTime();
			endTime = wfEndTime.getDate() + "-" + wfEndTime.getMonth() + "-"
					+ wfEndTime.getYear() + "  " + wfEndTime.getHours() + ":"
					+ wfEndTime.getMinutes() + ":" + wfEndTime.getSeconds();

			workflowBean.setEndTime(endTime);

			// fetching Workflow Status
			workflowBean.setStatus(wfDetails.getWorkflowRunStatus().toString());
			final int date3 = wfStartTime.getUTCTime();
			final int date4 = wfEndTime.getUTCTime();
			final long diff1 = date4 - date3;

			// fetching Total Run time for Workflow

			workflowBean.setTotalTime(formatIntoHHMMSS(diff1));

			final int wfRunErrorCode = wfDetails.getRunErrorCode();
			if (wfRunErrorCode == 0) {
				workflowBean.setErrorMessage("NA");
			} else {
				workflowBean.setErrorMessage(wfDetails.getRunErrorMsg());
			}

		} catch (final JLMException e) {
			e.getErrorMessage();
			e.printStackTrace();
		}
		this.workflowBean = workflowBean;

	}

	*//**
	 * This method is used to format the time(in seconds ) to HHMMSS.
	 * 
	 * @param secsIn
	 * @return String
	 *//*
	private static String formatIntoHHMMSS(long secsIn) {
		if (secsIn < 0) {
			secsIn = 0;
		}

		final long hours = secsIn / 3600, remainder = secsIn % 3600, minutes = remainder / 60, seconds = remainder % 60;

		String totalTime = "";

		if (hours != 0) {
			totalTime += (hours < 10 ? "0" : "") + hours + " hours ";
		}
		if (minutes != 0) {
			totalTime += (minutes < 10 ? "0" : "") + minutes + " minutes ";
		}
		if (seconds != 0) {
			totalTime += (seconds < 10 ? "0" : "") + seconds + " seconds ";
		}

		return totalTime;
	}

	public boolean isRenderWfDtlsPopup() {
		return renderWfDtlsPopup;
	}

	public void setRenderWfDtlsPopup(boolean renderWfDtlsPopup) {
		this.renderWfDtlsPopup = renderWfDtlsPopup;
	}
	
	public boolean isRenderWfAvgRunTimePopup() {
		return renderWfAvgRunTimePopup;
	}

	public void setRenderWfAvgRunTimePopup(boolean renderWfAvgRunTimePopup) {
		this.renderWfAvgRunTimePopup = renderWfAvgRunTimePopup;
	}

	public WorkflowBean getWorkflowBean() {
		return workflowBean;
	}

	public void setWorkflowBean(WorkflowBean workflowBean) {
		this.workflowBean = workflowBean;
	}

	public void callPopup(ActionEvent evnt) {
		getWorkflowRunDetails();
		setRenderWfDtlsPopup(true);
	}

	public void closePopup(ActionEvent evnt) {
		setRenderWfDtlsPopup(false);
	}
	
	public void callPopupAvgRunTime(ActionEvent evnt) {
		getWorkflowAvgRunTime();
		setRenderWfAvgRunTimePopup(true);
	}

	public void closePopupAvgRunTime(ActionEvent evnt) {
		setRenderWfAvgRunTimePopup(false);
	}*/

}
