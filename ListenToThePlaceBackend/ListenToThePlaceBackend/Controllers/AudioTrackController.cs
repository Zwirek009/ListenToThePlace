using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Linq;
using ListenToThePlaceBackend.Models;

namespace TodoApi.Controllers
{
    [Route("api/[controller]")]
    public class AudioTrackController : ControllerBase
    {
        private readonly ListenToThePlaceDBContext _context;

        public AudioTrackController(ListenToThePlaceDBContext context)
        {
            _context = context;

            if (_context.AudioTracks.Count() == 0)
            {
                _context.AudioTracks.Add(new AudioTrackItem { Name = "Imagine", Performer = "John Lennon", Latitude = 52.2390750, Longtitude = 20.9858590 });
                _context.SaveChanges();
            }
        }
    }
}
