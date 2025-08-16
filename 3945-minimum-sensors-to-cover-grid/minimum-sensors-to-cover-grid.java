class Solution {
    public int minSensors(int n, int m, int k) {
        int num_row = n;
        int num_col = m;
        //suppose we're making a square by putting a sensor in the middle of the square
        int maxcovered_rows_by_a_sensor = 2*k+1;
        int maxcovered_cols_by_a_sensor = 2*k+1;

        int req_sensor_to_cover_all_rows =num_row/maxcovered_rows_by_a_sensor; 
        int req_sensor_to_cover_all_cols =num_col/maxcovered_cols_by_a_sensor;

        //but if there might be chnces that some rows left because they are less than max covered 
        if(num_row % maxcovered_rows_by_a_sensor != 0 ) req_sensor_to_cover_all_rows++; // add one more sensor to cover that
        if(num_col % maxcovered_cols_by_a_sensor != 0 ) req_sensor_to_cover_all_cols++; // add one more sensor to cover that

        int ans = req_sensor_to_cover_all_rows*req_sensor_to_cover_all_cols;
        return ans;

    }
}