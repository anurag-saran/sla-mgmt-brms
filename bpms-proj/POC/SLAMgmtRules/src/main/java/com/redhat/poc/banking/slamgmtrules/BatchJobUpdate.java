package com.redhat.poc.banking.slamgmtrules;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class BatchJobUpdate implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   @org.kie.api.definition.type.Label(value = "Transaction Type")
   private java.lang.String transactionType;

   @org.kie.api.definition.type.Label(value = "Number Of Transactions Processed")
   private java.lang.Integer noOfTransProcessed;

   public BatchJobUpdate()
   {
   }

   public java.lang.String getTransactionType()
   {
      return this.transactionType;
   }

   public void setTransactionType(java.lang.String transactionType)
   {
      this.transactionType = transactionType;
   }

   public java.lang.Integer getNoOfTransProcessed()
   {
      return this.noOfTransProcessed;
   }

   public void setNoOfTransProcessed(java.lang.Integer noOfTransProcessed)
   {
      this.noOfTransProcessed = noOfTransProcessed;
   }

   public BatchJobUpdate(java.lang.String transactionType,
         java.lang.Integer noOfTransProcessed)
   {
      this.transactionType = transactionType;
      this.noOfTransProcessed = noOfTransProcessed;
   }

}