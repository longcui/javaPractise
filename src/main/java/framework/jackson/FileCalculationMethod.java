package framework.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FileCalculationMethod {
        SHOTPOINT_COUNT("Shotpoint Count", DataSource.SPS_FILE),
        NODE_DEPLOYED_COUNT("Node Deployed Count", DataSource.STARFIX_FILE),
        NODE_RECOVERED_COUNT("Node Recovered Count", DataSource.STARFIX_FILE);

        private String des;
        private DataSource[] dataSources;
        FileCalculationMethod(String des, DataSource... dataSources) {
            this.des = des;
            this.dataSources = dataSources;
        }

        //for jackson
        public String getName() {
            return name();
        }

        public String getDes() {
            return des;
        }

        public DataSource[] getDataSources() {
            return dataSources;
        }
    }

