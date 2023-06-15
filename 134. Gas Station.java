class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalGas = 0;

        //check if total fuel from gas station is greater than cost
        // if yes, it is guranteed to have an index i where the car can complete the route.
        for(int i = 0; i < n; i++) {
            totalGas += gas[i] - cost[i]; 
        }

        if(totalGas < 0) {
                return -1;
            }

        totalGas = 0;
        int result = 0;
        for(int i = 0; i < n; i++) {

            //find totalGas left after filling up and cost at each index
            totalGas += gas[i] - cost[i];

            //Since, it is guranteed to have a unique index where the car can start to finish the route, 
            //if total gas goes negative, start from next index and assign it to result.
            //Start the same computation again for new index.
            if(totalGas < 0) {
                totalGas = 0;
                result = i + 1;
            }
        }
    return result;

    }
}
