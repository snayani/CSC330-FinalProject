package edu.cuny.csi.csc330.fall14.project;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.*;

import edu.cuny.csi.csc330.fall14.project.Menu;

/**
 * The Class JTextAreaOutputStream. Allows "System.out" to be directed to a JTextArea
 * 
 */
public class JTextAreaOutputStream extends OutputStream
{
    
    /** The destination. */
    private final JTextArea destination;

    /**
     * Instantiates a new j text area output stream.
     *
     * @param destination the destination
     */
    public JTextAreaOutputStream (JTextArea destination)
    {
        if (destination == null)
            throw new IllegalArgumentException ("Destination is null");

        this.destination = destination;
    }

    /* (non-Javadoc)
     * @see java.io.OutputStream#write(byte[], int, int)
     */
    @Override
    public void write(byte[] buffer, int offset, int length) throws IOException
    {
        final String text = new String (buffer, offset, length);
        SwingUtilities.invokeLater(new Runnable ()
            {
                @Override
                public void run() 
                {
                    destination.append (text);
                }
            });
    }

    /* (non-Javadoc)
     * @see java.io.OutputStream#write(int)
     */
    @Override
    public void write(int b) throws IOException
    {
        write (new byte [] {(byte)b}, 0, 1);
    }
    
    /**
     * Sets the output to a specific JTextArea
     *
     * @param dest1 the new out
     */
    public static void setOut(JTextArea dest1)
    {
    	JTextAreaOutputStream out = new JTextAreaOutputStream (dest1);
        System.setOut (new PrintStream (out));
    }
}
