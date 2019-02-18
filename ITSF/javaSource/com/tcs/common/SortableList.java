package com.tcs.common;




/**
 * The SortableList class is a utility class used by the  data table
 * paginator example.
 *
 * @since 0.3.0
 */
public abstract class SortableList {

    protected String sortColumnName;
    protected boolean ascending=true;

    // we only want to resort if the oder or column has changed.
    protected String oldSort;
    protected boolean oldAscending;


   protected SortableList(String defaultSortColumn) {
        sortColumnName = defaultSortColumn;
        ascending = isDefaultAscending(defaultSortColumn);
        oldSort = sortColumnName;
        // make sure sortColumnName on first render
        oldAscending = !ascending;
    }

    /**
     * Sort the list.
     */
    protected abstract void sort();
    //protected abstract void SortPlans(List<HealthCoverage> a);

    /**
     * Is the default sortColumnName direction for the given column "ascending" ?
     */
    protected abstract boolean isDefaultAscending(String sortColumn);

    /**
     * Gets the sortColumnName column.
     *
     * @return column to sortColumnName
     */
    public String getSortColumnName() {
        return sortColumnName;
    }

    /**
     * Sets the sortColumnName column
     *
     * @param sortColumnName column to sortColumnName
     */
    public void setSortColumnName(String sortColumnNm) {
        oldSort = this.sortColumnName;
        this.sortColumnName = sortColumnNm;

    }

    /**
     * Is the sortColumnName ascending.
     *
     * @return true if the ascending sortColumnName otherwise false.
     */
    public boolean isAscending() {
        return ascending;
    }

    /**
     * Set sortColumnName type.
     *
     * @param ascending true for ascending sortColumnName, false for desending sortColumnName.
     */
    public void setAscending(boolean ascendng) {
        oldAscending = this.ascending;
        this.ascending = ascendng;
    }
}
