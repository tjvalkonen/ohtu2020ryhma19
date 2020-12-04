/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.domain;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReadingTipServiceTest {

    ReadingTipService service;
    

    public ReadingTipServiceTest() {
    }

    @Before
    public void setUp() throws Exception {
        FakeReadingTipDao readingTip = new FakeReadingTipDao();
        readingTip.addTip(new BookTip("First title"));
        readingTip.addTip(new BookTip("Second title"));
        readingTip.addTip(new BookTip("Third title"));
        readingTip.addTip(new BookTip("Dune"));
        
        service = new ReadingTipService(readingTip);
        
    }

    @Test
    public void atStartListContainsSetUpValues() throws Exception {
        List<ReadingTip> readingTips = service.browseReadingTips();
        assertEquals(4, readingTips.size());
    }

    @Test
    public void readingTipContainsAllValues() throws Exception {
        List<ReadingTip> readingTips = service.browseReadingTips();

    }

    @Test
    public void readingTipCanBeFound() throws Exception {
        assertEquals("First title", service.getOneTip("1").getTitle());
    }

    @Test
    public void readingTipCanBeModified() throws Exception {
        service.modifyTip("1", "book", "Herbert", "1234");
        assertEquals("Herbert", service.getOneTip("1").getMoreInfo1());
    }
    
    @Test
    public void readingTipCanBeDeleted() throws Exception {
        service.removeTip("1");
        assertEquals(3, service.browseReadingTips().size());
    }
    
    @Test
    public void readingTipCanBeMarkedAsReadAndUnread() throws Exception {
        service.markAsRead("2");
        ReadingTip r = service.getOneTip("2");
        assertEquals(1, r.getRead());
        
        service.markAsUnread("2");
        r = service.getOneTip("2");
        assertEquals(0, r.getRead());
    }
}
