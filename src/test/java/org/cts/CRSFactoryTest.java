/*
 * Coordinate Transformations Suite (abridged CTS)  is a library developped to 
 * perform Coordinate Transformations using well known geodetic algorithms 
 * and parameter sets. 
 * Its main focus are simplicity, flexibility, interoperability, in this order.
 *
 * This library has been originally developed by Michaël Michaud under the JGeod
 * name. It has been renamed CTS in 2009 and shared to the community from 
 * the OrbisGIS code repository.
 *
 * CTS is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License.
 *
 * CTS is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * CTS. If not, see <http://www.gnu.org/licenses/>.
 *
 * For more information, please consult: <https://github.com/orbisgis/cts/>
 */

package org.cts;

import org.cts.crs.CoordinateReferenceSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * @author Erwan Bocher
 */
class CRSFactoryTest extends CTSTestCase {

    @Test
    void testCRSFromLAMBEDeprecated() throws Exception {
        String prj = "PROJCS[\"NTF (Paris) / France II (deprecated)\",GEOGCS[\"NTF (Paris)\","
                + "DATUM[\"Nouvelle_Triangulation_Francaise_Paris\",SPHEROID[\"Clarke 1880 (IGN)\",6378249.2,293.4660212936269,AUTHORITY[\"EPSG\",\"7011\"]],TOWGS84[-168,-60,320,0,0,0,0],AUTHORITY[\"EPSG\",\"6807\"]],"
                + "PRIMEM[\"Paris\",2.33722917,AUTHORITY[\"EPSG\",\"8903\"]],UNIT[\"grad\",0.01570796326794897,AUTHORITY[\"EPSG\",\"9105\"]],AUTHORITY[\"EPSG\",\"4807\"]],UNIT[\"metre\",1,AUTHORITY[\"EPSG\",\"9001\"]],"
                + "PROJECTION[\"Lambert_Conformal_Conic_1SP\"],PARAMETER[\"latitude_of_origin\",52],PARAMETER[\"central_meridian\",0],PARAMETER[\"scale_factor\",0.99987742],PARAMETER[\"false_easting\",600000],PARAMETER[\"false_northing\",2200000],AUTHORITY[\"EPSG\",\"27582\"],"
                + "AXIS[\"X\",EAST],AXIS[\"Y\",NORTH]]";
        CoordinateReferenceSystem crs = cRSFactory.createFromPrj(prj);        
        assertNotNull(crs);
        assertEquals("NTF (Paris) / France II (deprecated)", crs.getName());
    }

    @Test
    void testCRSFromLAMB93() throws Exception {
        String prj = "PROJCS[\"RGF93_Lambert_93\",GEOGCS[\"GCS_RGF_1993\","
                + "DATUM[\"D_RGF_1993\",SPHEROID[\"GRS_1980\",6378137.0,298.257222101]],"
                + "PRIMEM[\"Greenwich\",0.0],UNIT[\"Degree\",0.0174532925199433]],"
                + "PROJECTION[\"Lambert_Conformal_Conic\"],PARAMETER[\"False_Easting\",700000.0],"
                + "PARAMETER[\"False_Northing\",6600000.0],PARAMETER[\"Central_Meridian\",3.0],"
                + "PARAMETER[\"Standard_Parallel_1\",44.0],PARAMETER[\"Standard_Parallel_2\",49.0],"
                + "PARAMETER[\"Latitude_Of_Origin\",46.5],UNIT[\"Meter\",1.0]]";
        CoordinateReferenceSystem crs = cRSFactory.createFromPrj(prj);
        assertNotNull(crs);
        assertEquals("RGF93_Lambert_93", crs.getName());
    }

    @Test
    void testOGC_WKT_27572_CRS() throws Exception {
        String prj = "PROJCS[\"NTF (Paris) / Lambert zone II\",GEOGCS[\"NTF (Paris)\","
                + "DATUM[\"Nouvelle_Triangulation_Francaise_Paris\","
                + "SPHEROID[\"Clarke 1880 (IGN)\",6378249.2,293.4660212936269,"
                + "AUTHORITY[\"EPSG\",\"7011\"]],TOWGS84[-168,-60,320,0,0,0,0],"
                + "AUTHORITY[\"EPSG\",\"6807\"]],PRIMEM[\"Paris\",2.33722917,"
                + "AUTHORITY[\"EPSG\",\"8903\"]],UNIT[\"grad\",0.01570796326794897,"
                + "AUTHORITY[\"EPSG\",\"9105\"]],AUTHORITY[\"EPSG\",\"4807\"]],UNIT[\"metre\",1,"
                + "AUTHORITY[\"EPSG\",\"9001\"]],PROJECTION[\"Lambert_Conformal_Conic_1SP\"],"
                + "PARAMETER[\"latitude_of_origin\",52],PARAMETER[\"central_meridian\",0],"
                + "PARAMETER[\"scale_factor\",0.99987742],PARAMETER[\"false_easting\",600000],"
                + "PARAMETER[\"false_northing\",2200000],"
                + "AUTHORITY[\"EPSG\",\"27572\"],AXIS[\"X\",EAST],AXIS[\"Y\",NORTH]]";
        CoordinateReferenceSystem crs = cRSFactory.createFromPrj(prj);
        assertNotNull(crs);
        assertEquals("EPSG", crs.getAuthorityName());
        assertEquals("27572", crs.getAuthorityKey());
    }

    @Test
    void testOGC_WKT_27572_CRS_SPACE() throws Exception {
        String prj = "PROJCS[\" NTF (Paris) / Lambert zone II \",GEOGCS[\" NTF (Paris) \","
                + "DATUM[\" Nouvelle_Triangulation_Francaise_Paris \","
                + "SPHEROID[\" Clarke 1880 (IGN) \", 6378249.2 , 293.4660212936269 ,"
                + "AUTHORITY[\" EPSG \" , \" 7011 \"]],TOWGS84[ -168 , -60 , 320 , 0 , 0 , 0 , 0 ],"
                + "AUTHORITY[\" EPSG \" , \" 6807 \"]],PRIMEM[\" Paris \", 2.33722917 ,"
                + "AUTHORITY[\" EPSG \" , \" 8903 \"]],UNIT[\" grad \", 0.01570796326794897 ,"
                + "AUTHORITY[\" EPSG \" , \" 9105 \"]],AUTHORITY[\" EPSG \",\" 4807 \"]],UNIT[\" metre \" , 1 , "
                + "AUTHORITY[\" EPSG \" , \" 9001 \"]],PROJECTION[\" Lambert_Conformal_Conic_1SP \"],"
                + "PARAMETER[\" latitude_of_origin \" , 52 ],PARAMETER[\" central_meridian \" , 0 ],"
                + "PARAMETER[\" scale_factor \" , 0.99987742 ],PARAMETER[\" false_easting \" , 600000 ],"
                + "PARAMETER[\" false_northing \" , 2200000 ],"
                + "AUTHORITY[\" EPSG \" , \" 27572 \"],AXIS[\" X \" , EAST ],AXIS[\" Y \" , NORTH ]] ";
        CoordinateReferenceSystem crs = cRSFactory.createFromPrj(prj);
        assertNotNull(crs);
        assertEquals("EPSG", crs.getAuthorityName());
        assertEquals("27572", crs.getAuthorityKey());
    }
    
    
    @Test
    void testCRSFromProj4() throws Exception {
        String prj = "+proj=tmerc +lat_0=0 +lon_0=106 +k=1 +x_0=500000 +y_0=0 +ellps=krass +towgs84=-17.51,-108.32,-62.39,0,0,0,0 +units=m +no_defs";
        CoordinateReferenceSystem crs = cRSFactory.createFromPrj4(prj);
        assertNotNull(crs);
    }
    
    @Test
    void testCRSFromProj4UTM() throws Exception {
        String prj = "+proj=utm +zone=32 +south +datum=WGS84 +units=m +no_defs";
        CoordinateReferenceSystem crs = cRSFactory.createFromPrj4(prj);
        assertEquals("UTM 32 NORTH", crs.getName());
    }
}
